/*******************************************************************************
 * Copyright (c) 2011 HPCC Systems. All rights reserved. This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: HPCC Systems - initial API and implementation
 ******************************************************************************/
package org.hpccsystems.ws.client.platform;

import org.hpccsystems.ws.client.HPCCFileSprayClient;
import org.hpccsystems.ws.client.HPCCWsWorkUnitsClient;
import org.hpccsystems.ws.client.gen.filespray.v1_15allverinclusive.DFUWorkunit;
import org.hpccsystems.ws.client.gen.filespray.v1_15allverinclusive.EspException;
import org.hpccsystems.ws.client.gen.filespray.v1_15allverinclusive.GetDFUWorkunitResponse;
import org.hpccsystems.ws.client.utils.DataSingleton;
import org.hpccsystems.ws.client.utils.DataSingletonCollection;
import org.hpccsystems.ws.client.utils.EqualsUtil;
import org.hpccsystems.ws.client.utils.HashCodeUtil;

public class FileSprayWorkunit extends DataSingleton
{
    public static DataSingletonCollection All = new DataSingletonCollection();

    public static FileSprayWorkunit get(Platform platform, String wuid)
    {
        if (wuid == null || wuid.isEmpty())
        {
            return null;
        }

        return (FileSprayWorkunit) All.get(new FileSprayWorkunit(platform, wuid));
    }

    private Platform    platform;
    private DFUWorkunit info;

    public enum Notification
    {
        LOGICALFILEWORKUNIT,
    }

    FileSprayWorkunit(Platform platform, String id)
    {
        this.platform = platform;
        info = new DFUWorkunit();
        info.setID(id);
        setChanged();
    }

    public Platform getPlatform()
    {
        return platform;
    }

    public String getID()
    {
        return info.getID();
    }

    /*
     * enum DFUstate { 0 DFUstate_unknown, 1 DFUstate_scheduled, 2 DFUstate_queued, 3 DFUstate_started, 4
     * DFUstate_aborted, 5 DFUstate_failed, 6 DFUstate_finished, 7 DFUstate_monitoring, 8 DFUstate_aborting
     *
     * WUStateNoLongerOnServer 999
     */
    public WUState getStateID()
    {
        if (info.getState() != null)
        {
            switch (info.getState())
            {
                case 1:
                    return WUState.SCHEDULED;
                case 2:
                    return WUState.WAIT;
                case 3:
                    return WUState.RUNNING;
                case 4:
                    return WUState.ABORTED;
                case 5:
                    return WUState.FAILED;
                case 6:
                    return WUState.COMPLETED;
                case 7:
                    return WUState.COMPLETED;
                case 8:
                    return WUState.ABORTING;
                case 999:
                    return WUState.UNKNOWN_ONSERVER;
            }
        }
        return WUState.UNKNOWN;
    }

    // Logical Files ---
    synchronized LogicalFile getLogicalFile(String name)
    {
        return LogicalFile.get(platform, name);
    }

    public LogicalFile getLogicalFile()
    {
        if (info.getSourceLogicalName() == null || info.getDestLogicalName() == null)
        {
            fullRefresh();
        }

        String logicalFileName = info.getSourceLogicalName();
        if (logicalFileName == null || logicalFileName.isEmpty())
        {
            logicalFileName = info.getDestLogicalName();
        }

        if (logicalFileName == null || logicalFileName.isEmpty())
        {
            return null;
        }

        return getLogicalFile(logicalFileName);
    }

    public String getFilePath()
    {
        if (info.getSourceLogicalName() == null || info.getDestLogicalName() == null)
        {
            fullRefresh();
        }

        String filePath = info.getSourceFilePath();
        if (filePath == null || filePath.isEmpty())
        {
            filePath = info.getDestFilePath();
        }

        if (filePath == null || filePath.isEmpty())
        {
            return null;
        }

        return filePath;
    }

    public boolean isDespray()
    {
        if (info.getSourceLogicalName() == null || info.getDestLogicalName() == null)
        {
            fullRefresh();
        }
        if (info.getSourceLogicalName() != null && info.getDestFilePath() != null)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean isComplete()
    {
        return HPCCWsWorkUnitsClient.isWorkunitComplete(getStateID());
    }

    public void refreshState()
    {
        fullRefresh();
    }

    @Override
    protected void fastRefresh()
    {
        fullRefresh();
    }

    @Override
    protected void fullRefresh()
    {
        try
        {
            HPCCFileSprayClient fileSprayClient = platform.getFileSprayClient();
            GetDFUWorkunitResponse response = fileSprayClient.getDFUWorkunit(info.getID());
            if (response.getResult() == null)
            { // Call succeeded, but no response...
                for (EspException e : response.getExceptions().getException())
                {
                    if (e.getCode().equals("20082"))
                    { // No longer exists...
                        info.setState(999);
                        setChanged();
                        notifyObservers(Notification.LOGICALFILEWORKUNIT);
                        break;
                    }
                }
            }
            else
            {
                update(response.getResult());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Updates ---
    public boolean update(DFUWorkunit wu)
    {
        boolean retVal = false;
        if (wu != null && info.getID().equals(wu.getID()) && !info.equals(wu))
        {
            if (updateState(wu))
            {
                retVal = true;
                notifyObservers(Notification.LOGICALFILEWORKUNIT);
            }
            if (updateLogicalFiles(wu))
            {
                retVal = true;
                notifyObservers(Notification.LOGICALFILEWORKUNIT);
            }
        }
        monitor();
        return retVal;
    }

    synchronized boolean updateState(DFUWorkunit wu)
    {
        if (wu != null && info.getID().equals(wu.getID()) && EqualsUtil.hasChanged(info.getState(), wu.getState()))
        {
            info.setState(wu.getState());
            setChanged();
            return true;
        }
        return false;
    }

    synchronized boolean updateLogicalFiles(DFUWorkunit wu)
    {
        if (wu != null
                && info.getID().equals(wu.getID())
                && (EqualsUtil.hasChanged(info.getSourceLogicalName(), wu.getSourceLogicalName()) || EqualsUtil
                        .hasChanged(info.getDestLogicalName(), wu.getDestLogicalName())))
        {
            info = wu;
            setChanged();
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object aThat)
    {
        if (this == aThat)
        {
            return true;
        }

        if (!(aThat instanceof FileSprayWorkunit))
        {
            return false;
        }
        FileSprayWorkunit that = (FileSprayWorkunit) aThat;

        // now a proper field-by-field evaluation can be made
        return EqualsUtil.areEqual(platform, that.platform) && EqualsUtil.areEqual(info.getID(), that.info.getID());
    }

    @Override
    public int hashCode()
    {
        int result = HashCodeUtil.SEED;
        result = HashCodeUtil.hash(result, platform);
        result = HashCodeUtil.hash(result, info.getID());
        return result;
    }

    public Object getClusterName()
    {
        if (info.getClusterName() == null)
        {
            fullRefresh();
        }
        return info.getClusterName();
    }
}
