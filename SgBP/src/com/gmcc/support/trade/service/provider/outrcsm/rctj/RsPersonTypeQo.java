/**
 * RsPersonTypeQo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.outrcsm.rctj;

public class RsPersonTypeQo  implements java.io.Serializable {
    private int forDate;

    private java.lang.String pcounty;

    private java.lang.String specialtyType;

    private java.lang.String technicallytype;

    private int todate;

    public RsPersonTypeQo() {
    }

    public RsPersonTypeQo(
           int forDate,
           java.lang.String pcounty,
           java.lang.String specialtyType,
           java.lang.String technicallytype,
           int todate) {
           this.forDate = forDate;
           this.pcounty = pcounty;
           this.specialtyType = specialtyType;
           this.technicallytype = technicallytype;
           this.todate = todate;
    }


    /**
     * Gets the forDate value for this RsPersonTypeQo.
     * 
     * @return forDate
     */
    public int getForDate() {
        return forDate;
    }


    /**
     * Sets the forDate value for this RsPersonTypeQo.
     * 
     * @param forDate
     */
    public void setForDate(int forDate) {
        this.forDate = forDate;
    }


    /**
     * Gets the pcounty value for this RsPersonTypeQo.
     * 
     * @return pcounty
     */
    public java.lang.String getPcounty() {
        return pcounty;
    }


    /**
     * Sets the pcounty value for this RsPersonTypeQo.
     * 
     * @param pcounty
     */
    public void setPcounty(java.lang.String pcounty) {
        this.pcounty = pcounty;
    }


    /**
     * Gets the specialtyType value for this RsPersonTypeQo.
     * 
     * @return specialtyType
     */
    public java.lang.String getSpecialtyType() {
        return specialtyType;
    }


    /**
     * Sets the specialtyType value for this RsPersonTypeQo.
     * 
     * @param specialtyType
     */
    public void setSpecialtyType(java.lang.String specialtyType) {
        this.specialtyType = specialtyType;
    }


    /**
     * Gets the technicallytype value for this RsPersonTypeQo.
     * 
     * @return technicallytype
     */
    public java.lang.String getTechnicallytype() {
        return technicallytype;
    }


    /**
     * Sets the technicallytype value for this RsPersonTypeQo.
     * 
     * @param technicallytype
     */
    public void setTechnicallytype(java.lang.String technicallytype) {
        this.technicallytype = technicallytype;
    }


    /**
     * Gets the todate value for this RsPersonTypeQo.
     * 
     * @return todate
     */
    public int getTodate() {
        return todate;
    }


    /**
     * Sets the todate value for this RsPersonTypeQo.
     * 
     * @param todate
     */
    public void setTodate(int todate) {
        this.todate = todate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RsPersonTypeQo)) return false;
        RsPersonTypeQo other = (RsPersonTypeQo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.forDate == other.getForDate() &&
            ((this.pcounty==null && other.getPcounty()==null) || 
             (this.pcounty!=null &&
              this.pcounty.equals(other.getPcounty()))) &&
            ((this.specialtyType==null && other.getSpecialtyType()==null) || 
             (this.specialtyType!=null &&
              this.specialtyType.equals(other.getSpecialtyType()))) &&
            ((this.technicallytype==null && other.getTechnicallytype()==null) || 
             (this.technicallytype!=null &&
              this.technicallytype.equals(other.getTechnicallytype()))) &&
            this.todate == other.getTodate();
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
        _hashCode += getForDate();
        if (getPcounty() != null) {
            _hashCode += getPcounty().hashCode();
        }
        if (getSpecialtyType() != null) {
            _hashCode += getSpecialtyType().hashCode();
        }
        if (getTechnicallytype() != null) {
            _hashCode += getTechnicallytype().hashCode();
        }
        _hashCode += getTodate();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RsPersonTypeQo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://rctj.rcsm.provider.service.trade.support.gmcc.com/", "rsPersonTypeQo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("forDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "forDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcounty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcounty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialtyType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specialtyType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("technicallytype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "technicallytype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("todate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "todate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
