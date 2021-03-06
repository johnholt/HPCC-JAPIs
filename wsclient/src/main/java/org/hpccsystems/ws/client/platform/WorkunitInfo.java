package org.hpccsystems.ws.client.platform;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hpccsystems.ws.client.HPCCWsWorkUnitsClient;
import org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.*;

// This class wraps the generated soap ECL Workunit, providing comparable and to-string methods for end-users.
public class WorkunitInfo implements
        Comparable<org.hpccsystems.ws.client.platform.WorkunitInfo>
{
    private int               maxMonitorTime   = HPCCWsWorkUnitsClient.defaultMaxWaitTime;
    private int               sleepMillis      = HPCCWsWorkUnitsClient.defaultWaitTime;
    private List<NamedValueInfo>      namedValues      = null;
    private String originalEclWatchUrl=null;
    private List<ApplicationValueInfo> applicationValues=new ArrayList<ApplicationValueInfo>();
    private List<ECLResultInfo> eclResults=new ArrayList<ECLResultInfo>();
    private Integer accessFlag;
    private Integer action;
    private String actionEx;
    private Boolean active;
    private Integer alertcount;
    private String[] allowedClusters;
    private Integer applicationValueCount;
    private String applicationValuesDesc;
    private Boolean archived;
    private String cluster;
    private Integer clusterFlag;
    private Calendar dateTimeScheduled;
    private Integer debugValueCount;
    private DebugValue[] debugValues;
    private String debugValuesDesc;
    private String description;
    private Integer errorCount;
    private Integer eventSchedule;
    private List<ECLExceptionInfo> exceptions=new ArrayList<ECLExceptionInfo>();
    private Integer graphCount;
    private ECLGraph[] graphs;
    private String graphsDesc;
    private Boolean hasArchiveQuery;
    private Boolean hasDebugValue;
    private ECLHelpFile[] helpers;
    private String helpersDesc;
    private Integer infoCount;
    private Boolean isPausing;
    private String jobname;
    private String owner;
    private Integer priorityClass;
    private Integer priorityLevel;
    private ECLQuery query;
    private String queue;
    private Integer resourceURLCount;
    private String[] resourceURLs;
    private Integer resultCount;
    private Integer resultLimit;
    private String resultsDesc;
    private String roxieCluster;
    private String scope;
    private String snapshot;
    private ECLSourceFile[] sourceFiles;
    private String sourceFilelsDesc;
    private String state;
    private String stateEx;
    private Integer stateID;
    private Integer sourceFileCount;
    private String sourceFileDesc;
    private Integer timerCount;
    private String timersDesc;
    private ECLTimingData[] timingData;
    private String totalClusterTime;
    private Integer variableCount;
    private List<ECLResultInfo> variables;
    private boolean thorLCR;
    private ThorLogInfo[] thorLogList;
    private String variablesDesc;
    private Integer warningCount;
    private Integer workflowCount;
    private ECLWorkflow[] workflows;
    private String workflowsDesc;
    private String wuid;
    private String xmlParams;
    private ECLWorkunit eclWorkunit;
    private String[] resultViews;
    /**
     * Create an ECL workunit from a axis-generated soap class ECL Workunit
     * 
     * @param base
     */
    public WorkunitInfo(org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.ECLWorkunit base)
    {
        copy(base);
    }

    public WorkunitInfo() {}

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(org.hpccsystems.ws.client.platform.WorkunitInfo wu)
    {
        if (wu == null || wu.getWuid() == null)
        {
            return 0;
        }
        else
        {
            // by default, sort by wuid descending, like ECL Watch
            return wu.getWuid().compareTo(this.getWuid());
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("wuid:").append(String.valueOf(getWuid())).append("\n");
        sb.append("owner:").append(String.valueOf(getOwner())).append("\n");
        sb.append("cluster:").append(String.valueOf(getCluster())).append("\n");
        sb.append("roxieCluster:").append(String.valueOf(getRoxieCluster())).append("\n");
        sb.append("jobname:").append(String.valueOf(getJobname())).append("\n");
        sb.append("queue:").append(String.valueOf(getQueue())).append("\n");
        sb.append(" stateID:").append(String.valueOf(getStateID())).append("\n");
        sb.append("state:").append(String.valueOf(getState())).append("\n");
        sb.append("stateEx:").append(String.valueOf(getStateEx())).append("\n");
        sb.append("description:").append(String.valueOf(getDescription())).append("\n");
        sb.append(" action:").append(String.valueOf(getAction())).append("\n");
        sb.append("actionEx:").append(String.valueOf(getActionEx())).append("\n");
        sb.append("dateTimeScheduled:").append(String.valueOf(getDateTimeScheduled())).append("\n");
        sb.append(" priorityClass:").append(String.valueOf(getPriorityClass())).append("\n");
        sb.append(" priorityLevel:").append(String.valueOf(getPriorityLevel())).append("\n");
        sb.append("scope:").append(String.valueOf(getScope())).append("\n");
        sb.append("snapshot:").append(String.valueOf(getSnapshot())).append("\n");
        sb.append(" resultLimit:").append(String.valueOf(getResultLimit())).append("\n");
        sb.append(" eventSchedule:").append(String.valueOf(getEventSchedule())).append("\n");
        sb.append("totalThorTime:").append(String.valueOf(getTotalClusterTime())).append("\n");
        sb.append(" errorCount:").append(String.valueOf(getErrorCount())).append("\n");
        sb.append(" warningCount:").append(String.valueOf(getWarningCount())).append("\n");
        sb.append(" infoCount:").append(String.valueOf(getInfoCount())).append("\n");
        sb.append(" graphCount:").append(String.valueOf(getGraphCount())).append("\n");
        sb.append(" sourceFileCount:").append(String.valueOf(getSourceFileCount())).append("\n");
        sb.append(" resultCount:").append(String.valueOf(getResultCount())).append("\n");
        sb.append(" variableCount:").append(String.valueOf(getVariableCount())).append("\n");
        sb.append(" timerCount:").append(String.valueOf(getTimerCount())).append("\n");
        sb.append("hasDebugValue:").append(String.valueOf(this.getHasDebugValue())).append("\n");
        sb.append(" applicationValueCount:").append(String.valueOf(getApplicationValueCount())).append("\n");
        sb.append("xmlParams:").append(String.valueOf(getXmlParams())).append("\n");
        sb.append(" accessFlag:").append(String.valueOf(getAccessFlag())).append("\n");
        sb.append(" clusterFlag:").append(String.valueOf(getClusterFlag())).append("\n");
        sb.append("helpersDesc:").append(String.valueOf(getHelpersDesc())).append("\n");
        sb.append("graphsDesc:").append(String.valueOf(getGraphsDesc())).append("\n");
        sb.append("sourceFilesDesc:").append(String.valueOf(getSourceFilesDesc())).append("\n");
        sb.append("resultsDesc:").append(String.valueOf(getResultsDesc())).append("\n");
        sb.append("variablesDesc:").append(String.valueOf(getVariablesDesc())).append("\n");
        sb.append("timersDesc:").append(String.valueOf(getTimersDesc())).append("\n");
        sb.append("debugValuesDesc:").append(String.valueOf(getDebugValuesDesc())).append("\n");
        sb.append("applicationValuesDesc:").append(String.valueOf(getApplicationValuesDesc())).append("\n");
        sb.append("workflowsDesc:").append(String.valueOf(getWorkflowsDesc())).append("\n");
        sb.append("hasArchiveQuery:").append(String.valueOf(this.getHasArchiveQuery())).append("\n");
        // TODO: include the content of unappended objects to the string
        return sb.toString();
    }

    /**
     * Copy a soap ecl workunit object into the wrapper
     * 
     * @param base
     */
    private void copy(org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.ECLWorkunit base)
    {
        if (base == null)
        {
            return;
        }
        this.eclWorkunit=base;
        this.setAccessFlag(base.getAccessFlag());
        this.setAction(base.getAction());
        this.setActionEx(base.getActionEx());
        this.setActive(base.getActive());
        this.setAlertCount(base.getAlertCount());
        this.setAllowedClusters(base.getAllowedClusters());
        this.setApplicationValueCount(base.getApplicationValueCount());
        if (base.getApplicationValues() != null)
        {
            this.applicationValues=new ArrayList<ApplicationValueInfo>();
            for (int i=0; i < base.getApplicationValues().length;i++) {
                applicationValues.add(new ApplicationValueInfo(base.getApplicationValues()[i]));
            }
        }
        this.setApplicationValuesDesc(base.getApplicationValuesDesc());
        this.setArchived(base.getArchived());
        this.setCluster(base.getCluster());
        this.setClusterFlag(base.getClusterFlag());
        this.setDateTimeScheduled(base.getDateTimeScheduled());
        this.setDebugValueCount(base.getDebugValueCount());
        this.setDebugValues(base.getDebugValues());
        this.setDebugValuesDesc(base.getDebugValuesDesc());
        this.setDescription(base.getDescription());        
        this.setErrorCount(base.getErrorCount());
        this.setEventSchedule(base.getEventSchedule());
        if (base.getExceptions() != null ) {
            this.exceptions=new ArrayList<ECLExceptionInfo>();
            for (int i=0; i < base.getExceptions().length;i++) {
                exceptions.add(new ECLExceptionInfo(base.getExceptions()[i]));
            }
        }
        this.setGraphCount(base.getGraphCount());
        this.setGraphs(base.getGraphs());
        this.setGraphsDesc(base.getGraphsDesc());
        this.setHasArchiveQuery(base.getHasArchiveQuery());
        this.setHasDebugValue(base.getHasDebugValue());
        this.setHelpers(base.getHelpers());
        this.setHelpersDesc(base.getHelpersDesc());
        this.setInfoCount(base.getInfoCount());
        this.setIsPausing(base.getIsPausing());
        this.setJobname(base.getJobname());
        this.setOwner(base.getOwner());
        this.setPriorityClass(base.getPriorityClass());
        this.setPriorityLevel(base.getPriorityLevel());
        this.setQuery(base.getQuery());
        this.setQueue(base.getQueue());
        this.setResourceURLCount(base.getResourceURLCount());
        this.setResourceURLs(base.getResourceURLs());
        this.setResultCount(base.getResultCount());
        this.setResultLimit(base.getResultLimit());
        if (base.getResults() != null)
        {
            this.eclResults=new ArrayList<ECLResultInfo>();
            for (int i=0; i < base.getResults().length;i++) {
                eclResults.add(new ECLResultInfo(base.getResults()[i]));
            }
        }
        this.setResultsDesc(base.getResultsDesc());
        this.setRoxieCluster(base.getRoxieCluster());
        this.setScope(base.getScope());
        this.setSnapshot(base.getSnapshot());
        this.setSourceFileCount(base.getSourceFileCount());
        this.setSourceFiles(base.getSourceFiles());
        this.setSourceFilesDesc(base.getSourceFilesDesc());
        this.setState(base.getState());
        this.setStateEx(base.getStateEx());
        this.setStateID(base.getStateID());
        this.setTimerCount(base.getTimerCount());
        this.setTimersDesc(base.getTimersDesc());
        this.setTimingData(base.getTimingData());
        this.setTotalClusterTime(base.getTotalClusterTime());
        this.setVariableCount(base.getVariableCount());
        if (base.getVariables() != null)
        {
            this.variables=new ArrayList<ECLResultInfo>();
            for (int i=0; i < base.getVariables().length;i++) {
                variables.add(new ECLResultInfo(base.getVariables()[i]));
            }
        }
        this.setThorLCR(base.getThorLCR());
        this.setThorLogList(base.getThorLogList());        
        this.setVariablesDesc(base.getVariablesDesc());
        this.setWarningCount(base.getWarningCount());
        this.setWorkflowCount(base.getWorkflowCount());
        this.setWorkflows(base.getWorkflows());
        this.setWorkflowsDesc(base.getWorkflowsDesc());
        this.setWuid(base.getWuid());
        this.setXmlParams(base.getXmlParams());

    }

    public boolean update(org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.ECLWorkunit wu)
    {
        boolean retVal = false;
        if (wu != null && this.getWuid().equals(wu.getWuid()) && !this.equals(wu))
        {
            if (updateState(wu))
            {
                retVal = true;
            }
            // RODRIGO other updates missing here...
        }
        return retVal;
    }

    synchronized boolean updateState(org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.ECLWorkunit wu)
    {
        boolean retVal = false;
        if (wu != null && this.getWuid().equals(wu.getWuid()))// && this.compareTo(wu))
        {
            this.setStateID(wu.getStateID());
            this.setStateEx(wu.getStateEx());
            this.setState(wu.getState());
            // setChanged();
            retVal = true;
        }
        return retVal;
    }


    public WorkunitInfo setMaxMonitorMillis(int time)
    {
        maxMonitorTime = time;
        return this;
    }

    public int getMaxMonitorMillis()
    {
        return maxMonitorTime;
    }

    public Integer getSleepMillis()
    {
        return sleepMillis;
    }

    public WorkunitInfo setSleepMillis(Integer sleepTime)
    {
        this.sleepMillis = sleepTime;
        return this;
    }

    /**
     * Gets the resultLimit value for this ECLWorkunit.
     * 
     * @return resultLimit
     */
    public Integer getResultLimit()
    {
        if (resultLimit == null)
        {
            return HPCCWsWorkUnitsClient.defaultResultLimit;
        }
        return resultLimit;
    }

    public List<NamedValueInfo> getNamedValues()
    {
        return namedValues;
    }

    public WorkunitInfo setNamedValues(List<NamedValueInfo> namedValues)
    {
        this.namedValues = namedValues;
        return this;
    }

    public WorkunitInfo setECL(String ecl)
    {
        if (this.getQuery() == null)
        {
            this.setQuery(new ECLQuery());
        }
        this.getQuery().setText(ecl);

        return this;
    }

    public String getECL()
    {
        if (this.getQuery() == null)
        {
            return "";
        }
        return this.getQuery().getText();
    }

	public String getOriginalEclWatchUrl() {
		return originalEclWatchUrl;
	}

	public WorkunitInfo setOriginalEclWatchUrl(String serverhost) {
		this.originalEclWatchUrl=serverhost;
        return this;
	}
    
	public List<ApplicationValueInfo> getApplicationValues() 
	{
	    return applicationValues;
	}
	
	public ECLException[] getRawExceptions()
	{
	    if (this.exceptions.size()==0) {
	        return null;
	    }
	    ECLException[] raw=new ECLException[this.exceptions.size()];
	    for (int i=0; i < exceptions.size();i++)
	    {
	        raw[i]=exceptions.get(i).getRaw();
	    }
	    return raw;
	}
	
	public ApplicationValue[] getRawApplicationValues() 
	{
	    if (applicationValues==null)
	    {
	        return null;
	    }
	    ApplicationValue[] raw=new ApplicationValue[applicationValues.size()];
	    int i=0;
	    for (ApplicationValueInfo item:applicationValues) {
	        raw[i]=item.getRaw();
	        i++;
	    }
	    return raw;
	}
	
	public NamedValue[] getRawNamedValues() 
    {
        if (namedValues==null)
        {
            return null;
        }
        NamedValue[] raw=new NamedValue[namedValues.size()];
        int i=0;
        for (NamedValueInfo item:namedValues) {
            raw[i]=item.getRaw();
            i++;
        }
        return raw;
    }
	
	public WorkunitInfo setNamedValues(NamedValue[] raw) 
	{
	    if (raw==null) 
	    {
	        return this;
	    }
	    namedValues=new ArrayList<NamedValueInfo>();
	    for (int i=0; i < raw.length;i++) 
	    {
	        namedValues.add(new NamedValueInfo(raw[i]));
	    }
        return this;
	}
    public int getMaxMonitorTime() {
        return maxMonitorTime;
    }

    public WorkunitInfo setMaxMonitorTime(int maxMonitorTime) {
        this.maxMonitorTime = maxMonitorTime;
        return this;
    }

    public List<ECLResultInfo> getResults() {
        return eclResults;
    }

    public WorkunitInfo setResults(List<ECLResultInfo> eclResults) {
        this.eclResults = eclResults;
        return this;
    }

    public Integer getAccessFlag() {
        return accessFlag;
    }

    public WorkunitInfo setAccessFlag(Integer accessFlag) {
        this.accessFlag = accessFlag;
        return this;
    }

    public Integer getAction() {
        return action;
    }

    public WorkunitInfo setAction(Integer action) {
        this.action = action;
        return this;
    }

    public String getActionEx() {
        return actionEx;
    }

    public WorkunitInfo setActionEx(String actionEx) {
        this.actionEx = actionEx;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public WorkunitInfo setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Integer getAlertCount() {
        return alertcount;
    }

    public WorkunitInfo setAlertCount(Integer alertcount) {
        this.alertcount = alertcount;
        return this;
    }

    public String[] getAllowedClusters() {
        return allowedClusters;
    }

    public WorkunitInfo setAllowedClusters(String[] allowedClusters) {
        this.allowedClusters = allowedClusters;
        return this;
    }

    public Integer getApplicationValueCount() {
        return applicationValueCount;
    }

    public WorkunitInfo setApplicationValueCount(Integer applicationValueCount) {
        this.applicationValueCount = applicationValueCount;
        return this;
    }

    public String getApplicationValuesDesc() {
        return applicationValuesDesc;
    }

    public WorkunitInfo setApplicationValuesDesc(String applicationValuesDesc) {
        this.applicationValuesDesc = applicationValuesDesc;
        return this;
    }

    public Boolean getArchived() {
        return archived;
    }

    public WorkunitInfo setArchived(Boolean archived) {
        this.archived = archived;
        return this;
    }

    public String getCluster() {
        return cluster;
    }

    public WorkunitInfo setCluster(String cluster) {
        this.cluster = cluster;
        return this;
    }

    public Integer getClusterFlag() {
        return clusterFlag;
    }

    public WorkunitInfo setClusterFlag(Integer clusterFlag) {
        this.clusterFlag = clusterFlag;
        return this;
    }

    public Calendar getDateTimeScheduled() {
        return dateTimeScheduled;
    }

    public WorkunitInfo setDateTimeScheduled(Calendar dateTimeScheduled) {
        this.dateTimeScheduled = dateTimeScheduled;
        return this;
    }

    public Integer getDebugValueCount() {
        return debugValueCount;
    }

    public WorkunitInfo setDebugValueCount(Integer debugValueCount) {
        this.debugValueCount = debugValueCount;
        return this;
    }

    public WorkunitInfo setSleepMillis(int sleepMillis) {
        this.sleepMillis = sleepMillis;
        return this;
    }

    public WorkunitInfo setApplicationValues(List<ApplicationValueInfo> applicationValues) {
        this.applicationValues = applicationValues;
        return this;
    }

    public WorkunitInfo setApplicationValues(ApplicationValue[] vals)
    {
        if (vals==null)
        {
            return this;
        }
        applicationValues=new ArrayList<ApplicationValueInfo>();
        for (int i=0; i < vals.length;i++) {
            applicationValues.add(new ApplicationValueInfo(vals[i]));
        }

        return this;
    }
    public Integer getAlertcount() {
        return alertcount;
    }

    public WorkunitInfo setAlertcount(Integer alertcount) {
        this.alertcount = alertcount;
        return this;
    }

    public DebugValue[] getDebugValues() {
        return debugValues;
    }

    public WorkunitInfo setDebugValues(DebugValue[] debugValues) {
        this.debugValues = debugValues;
        return this;
    }

    public String getDebugValuesDesc() {
        return debugValuesDesc;
    }

    public WorkunitInfo setDebugValuesDesc(String debugValuesDesc) {
        this.debugValuesDesc = debugValuesDesc;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public WorkunitInfo setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public WorkunitInfo setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
        return this;
    }

    public Integer getEventSchedule() {
        return eventSchedule;
    }

    public WorkunitInfo setEventSchedule(Integer eventSchedule) {
        this.eventSchedule = eventSchedule;
        return this;
    }

    public List<ECLExceptionInfo> getExceptions() {
        return exceptions;
    }

    public WorkunitInfo setExceptions(List<ECLExceptionInfo> exceptions) {
        this.exceptions = exceptions;
        return this;
    }

    public Integer getGraphCount() {
        return graphCount;
    }

    public WorkunitInfo setGraphCount(Integer graphCount) {
        this.graphCount = graphCount;
        return this;
    }

    public ECLGraph[] getGraphs() {
        return graphs;
    }

    public WorkunitInfo setGraphs(ECLGraph[] graphs) {
        this.graphs = graphs;
        return this;
    }

    public String getGraphsDesc() {
        return graphsDesc;
    }

    public WorkunitInfo setGraphsDesc(String graphsDesc) {
        this.graphsDesc = graphsDesc;
        return this;
    }

    public Boolean getHasArchiveQuery() {
        return hasArchiveQuery;
    }

    public WorkunitInfo setHasArchiveQuery(Boolean hasArchiveQuery) {
        this.hasArchiveQuery = hasArchiveQuery;
        return this;
    }

    public Boolean getHasDebugValue() {
        return hasDebugValue;
    }

    public WorkunitInfo setHasDebugValue(Boolean hasDebugValue) {
        this.hasDebugValue = hasDebugValue;
        return this;
    }

    public ECLHelpFile[] getHelpers() {
        return helpers;
    }

    public WorkunitInfo setHelpers(ECLHelpFile[] helpers) {
        this.helpers = helpers;
        return this;
    }

    public String getHelpersDesc() {
        return helpersDesc;
    }

    public WorkunitInfo setHelpersDesc(String helpersDesc) {
        this.helpersDesc = helpersDesc;
        return this;
    }

    public Integer getInfoCount() {
        return infoCount;
    }

    public WorkunitInfo setInfoCount(Integer infoCount) {
        this.infoCount = infoCount;
        return this;
    }

    public Boolean getIsPausing() {
        return isPausing;
    }

    public WorkunitInfo setIsPausing(Boolean isPausing) {
        this.isPausing = isPausing;
        return this;
    }

    public String getJobname() {
        return jobname;
    }

    public WorkunitInfo setJobname(String jobname) {
        this.jobname = jobname;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public WorkunitInfo setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public Integer getPriorityClass() {
        return priorityClass;
    }

    public WorkunitInfo setPriorityClass(Integer priorityClass) {
        this.priorityClass = priorityClass;
        return this;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public WorkunitInfo setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
        return this;
    }

    public ECLQuery getQuery() {
        return query;
    }

    public WorkunitInfo setQuery(ECLQuery query) {
        this.query = query;
        return this;
    }

    public String getQueue() {
        return queue;
    }

    public WorkunitInfo setQueue(String queue) {
        this.queue = queue;
        return this;
    }

    public Integer getResourceURLCount() {
        return resourceURLCount;
    }

    public WorkunitInfo setResourceURLCount(Integer resourceURLCount) {
        this.resourceURLCount = resourceURLCount;
        return this;
    }

    public String[] getResourceURLs() {
        return resourceURLs;
    }

    public WorkunitInfo setResourceURLs(String[] resourceURLs) {
        this.resourceURLs = resourceURLs;
        return this;
    }

    public Integer getResultCount() {
        return resultCount;
    }

    public WorkunitInfo setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
        return this;
    }

    public WorkunitInfo setResultLimit(Integer resultLimit) {
        this.resultLimit = resultLimit;
        return this;
    }

    public String getResultsDesc() {
        return resultsDesc;
    }

    public WorkunitInfo setResultsDesc(String resultsDesc) {
        this.resultsDesc = resultsDesc;
        return this;
    }

    public String getRoxieCluster() {
        return roxieCluster;
    }

    public WorkunitInfo setRoxieCluster(String roxieCluster) {
        this.roxieCluster = roxieCluster;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public WorkunitInfo setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public String getSnapshot() {
        return snapshot;
    }

    public WorkunitInfo setSnapshot(String snapshot) {
        this.snapshot = snapshot;
        return this;
    }

    public ECLSourceFile[] getSourceFiles() {
        return sourceFiles;
    }

    public WorkunitInfo setSourceFiles(ECLSourceFile[] sourceFiles) {
        this.sourceFiles = sourceFiles;
        return this;
    }

    public String getSourceFilelsDesc() {
        return sourceFilelsDesc;
    }

    public WorkunitInfo setSourceFilelsDesc(String sourceFilelsDesc) {
        this.sourceFilelsDesc = sourceFilelsDesc;
        return this;
    }

    public String getState() {
        return state;
    }

    public WorkunitInfo setState(String state) {
        this.state = state;
        return this;
    }

    public String getStateEx() {
        return stateEx;
    }

    public WorkunitInfo setStateEx(String stateEx) {
        this.stateEx = stateEx;
        return this;
    }

    public Integer getStateID() {
        return stateID;
    }

    public WorkunitInfo setStateID(Integer stateID) {
        this.stateID = stateID;
        return this;
    }

    public Integer getTimerCount() {
        return timerCount;
    }

    public WorkunitInfo setTimerCount(Integer timerCount) {
        this.timerCount = timerCount;
        return this;
    }

    public String getTimersDesc() {
        return timersDesc;
    }

    public WorkunitInfo setTimersDesc(String timersDesc) {
        this.timersDesc = timersDesc;
        return this;
    }

    public ECLTimingData[] getTimingData() {
        return timingData;
    }

    public WorkunitInfo setTimingData(ECLTimingData[] timingData) {
        this.timingData = timingData;
        return this;
    }

    public String getTotalClusterTime() {
        return totalClusterTime;
    }

    public WorkunitInfo setTotalClusterTime(String totalClusterTime) {
        this.totalClusterTime = totalClusterTime;
        return this;
    }

    public Integer getVariableCount() {
        return variableCount;
    }

    public WorkunitInfo setVariableCount(Integer variableCount) {
        this.variableCount = variableCount;
        return this;
    }

    public List<ECLResultInfo> getVariables() {
        return variables;
    }

    public WorkunitInfo setVariables(List<ECLResultInfo> variables) {
        this.variables = variables;
        return this;
    }

    public boolean isThorLCR() {
        return thorLCR;
    }

    public WorkunitInfo setThorLCR(boolean thorLCR) {
        this.thorLCR = thorLCR;
        return this;
    }

    public ThorLogInfo[] getThorLogList() {
        return thorLogList;
    }

    public WorkunitInfo setThorLogList(ThorLogInfo[] thorLogList) {
        this.thorLogList = thorLogList;
        return this;
    }

    public String getVariablesDesc() {
        return variablesDesc;
    }

    public WorkunitInfo setVariablesDesc(String variablesDesc) {
        this.variablesDesc = variablesDesc;
        return this;
    }

    public Integer getWarningCount() {
        return warningCount;
    }

    public WorkunitInfo setWarningCount(Integer warningCount) {
        this.warningCount = warningCount;
        return this;
    }

    public Integer getWorkflowCount() {
        return workflowCount;
    }

    public WorkunitInfo setWorkflowCount(Integer workflowCount) {
        this.workflowCount = workflowCount;
        return this;
    }

    public ECLWorkflow[] getWorkflows() {
        return workflows;
    }

    public WorkunitInfo setWorkflows(ECLWorkflow[] workflows) {
        this.workflows = workflows;
        return this;
    }

    public String getWorkflowsDesc() {
        return workflowsDesc;
    }

    public WorkunitInfo setWorkflowsDesc(String workflowsDesc) {
        this.workflowsDesc = workflowsDesc;
        return this;
    }

    public String getWuid() {
        return wuid;
    }

    public WorkunitInfo setWuid(String wuid) {
        this.wuid = wuid;
        return this;
    }

    public String getXmlParams() {
        return xmlParams;
    }

    public WorkunitInfo setXmlParams(String xmlParams) {
        this.xmlParams = xmlParams;
        return this;
    }

    public Integer getSourceFileCount() {
        return sourceFileCount;
    }

    public WorkunitInfo setSourceFileCount(Integer sourceFileCount) {
        this.sourceFileCount = sourceFileCount;
        return this;
    }

    public String getSourceFilesDesc() {
        return sourceFileDesc;
    }

    public WorkunitInfo setSourceFilesDesc(String sourceFileDesc) {
        this.sourceFileDesc = sourceFileDesc;
        return this;
    }

    public ECLWorkunit getEclWorkunit() {
        return eclWorkunit;
    }

    public String[] getResultViews() {
        return resultViews;
    }

    public WorkunitInfo setResultViews(String[] resultViews) {
        this.resultViews = resultViews;
        return this;
    }



}
