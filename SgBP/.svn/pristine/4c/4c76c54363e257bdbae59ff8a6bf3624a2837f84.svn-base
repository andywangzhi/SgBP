/**
 * AcceptRsPersonneedDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis #axisVersion# #today# WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.need;

public class AcceptRsPersonneedDetail  implements java.io.Serializable {
    private java.lang.String needid;

    public AcceptRsPersonneedDetail() {
    }

    public AcceptRsPersonneedDetail(
           java.lang.String needid) {
           this.needid = needid;
    }


    /**
     * Gets the needid value for this AcceptRsPersonneedDetail.
     * 
     * @return needid
     */
    public java.lang.String getNeedid() {
        return needid;
    }


    /**
     * Sets the needid value for this AcceptRsPersonneedDetail.
     * 
     * @param needid
     */
    public void setNeedid(java.lang.String needid) {
        this.needid = needid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcceptRsPersonneedDetail)) return false;
        AcceptRsPersonneedDetail other = (AcceptRsPersonneedDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.needid==null && other.getNeedid()==null) || 
             (this.needid!=null &&
              this.needid.equals(other.getNeedid())));
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
        if (getNeedid() != null) {
            _hashCode += getNeedid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AcceptRsPersonneedDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://need.rcsm.provider.service.trade.support.gmcc.com/", "acceptRsPersonneedDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("needid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "needid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
