/**
 * AcceptQueryRsPerson.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.outrcsm.base;

public class AcceptQueryRsPerson  implements java.io.Serializable {
    private com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutQo arg0;

    public AcceptQueryRsPerson() {
    }

    public AcceptQueryRsPerson(
           com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutQo arg0) {
           this.arg0 = arg0;
    }


    /**
     * Gets the arg0 value for this AcceptQueryRsPerson.
     * 
     * @return arg0
     */
    public com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutQo getArg0() {
        return arg0;
    }


    /**
     * Sets the arg0 value for this AcceptQueryRsPerson.
     * 
     * @param arg0
     */
    public void setArg0(com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutQo arg0) {
        this.arg0 = arg0;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcceptQueryRsPerson)) return false;
        AcceptQueryRsPerson other = (AcceptQueryRsPerson) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arg0==null && other.getArg0()==null) || 
             (this.arg0!=null &&
              this.arg0.equals(other.getArg0())));
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
        if (getArg0() != null) {
            _hashCode += getArg0().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AcceptQueryRsPerson.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://base.outrcsm.provider.service.trade.support.gmcc.com/", "acceptQueryRsPerson"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arg0");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arg0"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://base.outrcsm.provider.service.trade.support.gmcc.com/", "rsPersonOutQo"));
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
