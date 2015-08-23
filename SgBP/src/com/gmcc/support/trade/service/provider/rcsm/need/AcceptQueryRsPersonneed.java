/**
 * AcceptQueryRsPersonneed.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis #axisVersion# #today# WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.need;

public class AcceptQueryRsPersonneed  implements java.io.Serializable {
    private com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed arg0;

    public AcceptQueryRsPersonneed() {
    }

    public AcceptQueryRsPersonneed(
           com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed arg0) {
           this.arg0 = arg0;
    }


    /**
     * Gets the arg0 value for this AcceptQueryRsPersonneed.
     * 
     * @return arg0
     */
    public com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed getArg0() {
        return arg0;
    }


    /**
     * Sets the arg0 value for this AcceptQueryRsPersonneed.
     * 
     * @param arg0
     */
    public void setArg0(com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed arg0) {
        this.arg0 = arg0;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcceptQueryRsPersonneed)) return false;
        AcceptQueryRsPersonneed other = (AcceptQueryRsPersonneed) obj;
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
        new org.apache.axis.description.TypeDesc(AcceptQueryRsPersonneed.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://need.rcsm.provider.service.trade.support.gmcc.com/", "acceptQueryRsPersonneed"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arg0");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arg0"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://need.rcsm.provider.service.trade.support.gmcc.com/", "rsPersonneed"));
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
