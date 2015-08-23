/**
 * EducationexperienceQo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.outrcsm.jyjl;

public class EducationexperienceQo  implements java.io.Serializable {
    private int adddate;

    private java.lang.String adduser;

    private java.lang.String educationId;

    private int fromDate;

    private int modifydate;

    private java.lang.String modifyuser;

    private java.lang.String pcollege;

    private java.lang.String personId;

    private java.lang.String specialtyName;

    private int toDate;

    public EducationexperienceQo() {
    }

    public EducationexperienceQo(
           int adddate,
           java.lang.String adduser,
           java.lang.String educationId,
           int fromDate,
           int modifydate,
           java.lang.String modifyuser,
           java.lang.String pcollege,
           java.lang.String personId,
           java.lang.String specialtyName,
           int toDate) {
           this.adddate = adddate;
           this.adduser = adduser;
           this.educationId = educationId;
           this.fromDate = fromDate;
           this.modifydate = modifydate;
           this.modifyuser = modifyuser;
           this.pcollege = pcollege;
           this.personId = personId;
           this.specialtyName = specialtyName;
           this.toDate = toDate;
    }


    /**
     * Gets the adddate value for this EducationexperienceQo.
     * 
     * @return adddate
     */
    public int getAdddate() {
        return adddate;
    }


    /**
     * Sets the adddate value for this EducationexperienceQo.
     * 
     * @param adddate
     */
    public void setAdddate(int adddate) {
        this.adddate = adddate;
    }


    /**
     * Gets the adduser value for this EducationexperienceQo.
     * 
     * @return adduser
     */
    public java.lang.String getAdduser() {
        return adduser;
    }


    /**
     * Sets the adduser value for this EducationexperienceQo.
     * 
     * @param adduser
     */
    public void setAdduser(java.lang.String adduser) {
        this.adduser = adduser;
    }


    /**
     * Gets the educationId value for this EducationexperienceQo.
     * 
     * @return educationId
     */
    public java.lang.String getEducationId() {
        return educationId;
    }


    /**
     * Sets the educationId value for this EducationexperienceQo.
     * 
     * @param educationId
     */
    public void setEducationId(java.lang.String educationId) {
        this.educationId = educationId;
    }


    /**
     * Gets the fromDate value for this EducationexperienceQo.
     * 
     * @return fromDate
     */
    public int getFromDate() {
        return fromDate;
    }


    /**
     * Sets the fromDate value for this EducationexperienceQo.
     * 
     * @param fromDate
     */
    public void setFromDate(int fromDate) {
        this.fromDate = fromDate;
    }


    /**
     * Gets the modifydate value for this EducationexperienceQo.
     * 
     * @return modifydate
     */
    public int getModifydate() {
        return modifydate;
    }


    /**
     * Sets the modifydate value for this EducationexperienceQo.
     * 
     * @param modifydate
     */
    public void setModifydate(int modifydate) {
        this.modifydate = modifydate;
    }


    /**
     * Gets the modifyuser value for this EducationexperienceQo.
     * 
     * @return modifyuser
     */
    public java.lang.String getModifyuser() {
        return modifyuser;
    }


    /**
     * Sets the modifyuser value for this EducationexperienceQo.
     * 
     * @param modifyuser
     */
    public void setModifyuser(java.lang.String modifyuser) {
        this.modifyuser = modifyuser;
    }


    /**
     * Gets the pcollege value for this EducationexperienceQo.
     * 
     * @return pcollege
     */
    public java.lang.String getPcollege() {
        return pcollege;
    }


    /**
     * Sets the pcollege value for this EducationexperienceQo.
     * 
     * @param pcollege
     */
    public void setPcollege(java.lang.String pcollege) {
        this.pcollege = pcollege;
    }


    /**
     * Gets the personId value for this EducationexperienceQo.
     * 
     * @return personId
     */
    public java.lang.String getPersonId() {
        return personId;
    }


    /**
     * Sets the personId value for this EducationexperienceQo.
     * 
     * @param personId
     */
    public void setPersonId(java.lang.String personId) {
        this.personId = personId;
    }


    /**
     * Gets the specialtyName value for this EducationexperienceQo.
     * 
     * @return specialtyName
     */
    public java.lang.String getSpecialtyName() {
        return specialtyName;
    }


    /**
     * Sets the specialtyName value for this EducationexperienceQo.
     * 
     * @param specialtyName
     */
    public void setSpecialtyName(java.lang.String specialtyName) {
        this.specialtyName = specialtyName;
    }


    /**
     * Gets the toDate value for this EducationexperienceQo.
     * 
     * @return toDate
     */
    public int getToDate() {
        return toDate;
    }


    /**
     * Sets the toDate value for this EducationexperienceQo.
     * 
     * @param toDate
     */
    public void setToDate(int toDate) {
        this.toDate = toDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EducationexperienceQo)) return false;
        EducationexperienceQo other = (EducationexperienceQo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.adddate == other.getAdddate() &&
            ((this.adduser==null && other.getAdduser()==null) || 
             (this.adduser!=null &&
              this.adduser.equals(other.getAdduser()))) &&
            ((this.educationId==null && other.getEducationId()==null) || 
             (this.educationId!=null &&
              this.educationId.equals(other.getEducationId()))) &&
            this.fromDate == other.getFromDate() &&
            this.modifydate == other.getModifydate() &&
            ((this.modifyuser==null && other.getModifyuser()==null) || 
             (this.modifyuser!=null &&
              this.modifyuser.equals(other.getModifyuser()))) &&
            ((this.pcollege==null && other.getPcollege()==null) || 
             (this.pcollege!=null &&
              this.pcollege.equals(other.getPcollege()))) &&
            ((this.personId==null && other.getPersonId()==null) || 
             (this.personId!=null &&
              this.personId.equals(other.getPersonId()))) &&
            ((this.specialtyName==null && other.getSpecialtyName()==null) || 
             (this.specialtyName!=null &&
              this.specialtyName.equals(other.getSpecialtyName()))) &&
            this.toDate == other.getToDate();
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
        _hashCode += getAdddate();
        if (getAdduser() != null) {
            _hashCode += getAdduser().hashCode();
        }
        if (getEducationId() != null) {
            _hashCode += getEducationId().hashCode();
        }
        _hashCode += getFromDate();
        _hashCode += getModifydate();
        if (getModifyuser() != null) {
            _hashCode += getModifyuser().hashCode();
        }
        if (getPcollege() != null) {
            _hashCode += getPcollege().hashCode();
        }
        if (getPersonId() != null) {
            _hashCode += getPersonId().hashCode();
        }
        if (getSpecialtyName() != null) {
            _hashCode += getSpecialtyName().hashCode();
        }
        _hashCode += getToDate();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EducationexperienceQo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://jyjl.rcsm.provider.service.trade.support.gmcc.com/", "educationexperienceQo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adddate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "adddate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adduser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "adduser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("educationId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "educationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fromDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fromDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifydate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modifydate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifyuser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modifyuser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcollege");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcollege"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "personId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialtyName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "specialtyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "toDate"));
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
