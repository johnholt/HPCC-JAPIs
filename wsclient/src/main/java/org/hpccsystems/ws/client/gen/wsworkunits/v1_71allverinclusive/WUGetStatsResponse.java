/**
 * WUGetStatsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive;

public class WUGetStatsResponse  implements java.io.Serializable {
    private org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.ArrayOfEspException exceptions;

    private java.lang.String WUID;

    private org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.WUStatisticItem[] statistics;

    public WUGetStatsResponse() {
    }

    public WUGetStatsResponse(
           org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.ArrayOfEspException exceptions,
           java.lang.String WUID,
           org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.WUStatisticItem[] statistics) {
           this.exceptions = exceptions;
           this.WUID = WUID;
           this.statistics = statistics;
    }


    /**
     * Gets the exceptions value for this WUGetStatsResponse.
     * 
     * @return exceptions
     */
    public org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.ArrayOfEspException getExceptions() {
        return exceptions;
    }


    /**
     * Sets the exceptions value for this WUGetStatsResponse.
     * 
     * @param exceptions
     */
    public void setExceptions(org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.ArrayOfEspException exceptions) {
        this.exceptions = exceptions;
    }


    /**
     * Gets the WUID value for this WUGetStatsResponse.
     * 
     * @return WUID
     */
    public java.lang.String getWUID() {
        return WUID;
    }


    /**
     * Sets the WUID value for this WUGetStatsResponse.
     * 
     * @param WUID
     */
    public void setWUID(java.lang.String WUID) {
        this.WUID = WUID;
    }


    /**
     * Gets the statistics value for this WUGetStatsResponse.
     * 
     * @return statistics
     */
    public org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.WUStatisticItem[] getStatistics() {
        return statistics;
    }


    /**
     * Sets the statistics value for this WUGetStatsResponse.
     * 
     * @param statistics
     */
    public void setStatistics(org.hpccsystems.ws.client.gen.wsworkunits.v1_71allverinclusive.WUStatisticItem[] statistics) {
        this.statistics = statistics;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WUGetStatsResponse)) return false;
        WUGetStatsResponse other = (WUGetStatsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.exceptions==null && other.getExceptions()==null) || 
             (this.exceptions!=null &&
              this.exceptions.equals(other.getExceptions()))) &&
            ((this.WUID==null && other.getWUID()==null) || 
             (this.WUID!=null &&
              this.WUID.equals(other.getWUID()))) &&
            ((this.statistics==null && other.getStatistics()==null) || 
             (this.statistics!=null &&
              java.util.Arrays.equals(this.statistics, other.getStatistics())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getExceptions() != null) {
            _hashCode += getExceptions().hashCode();
        }
        if (getWUID() != null) {
            _hashCode += getWUID().hashCode();
        }
        if (getStatistics() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getStatistics());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getStatistics(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WUGetStatsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", ">WUGetStatsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exceptions");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "Exceptions"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "ArrayOfEspException"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("WUID");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "WUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statistics");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "Statistics"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "WUStatisticItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("urn:hpccsystems:ws:wsworkunits", "WUStatisticItem"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
