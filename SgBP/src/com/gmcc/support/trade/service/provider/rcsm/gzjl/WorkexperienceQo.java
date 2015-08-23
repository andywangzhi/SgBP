/**
 * WorkexperienceQo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.gzjl;

public class WorkexperienceQo  implements java.io.Serializable {
    private int adddate;

    private java.lang.String adduser;

    private java.lang.String companyName;

    private int fromDate;

    private int modifydate;

    private java.lang.String modifyuser;

    private java.lang.String personId;

    private java.lang.String pposition;

    private int toDate;

    private java.lang.String workId;

    public WorkexperienceQo() {
    }

    public WorkexperienceQo(
           int adddate,
           java.lang.String adduser,
           java.lang.String companyName,
           int fromDate,
           int modifydate,
           java.lang.String modifyuser,
           java.lang.String personId,
           java.lang.String pposition,
           int toDate,
           java.lang.String workId) {
           this.adddate = adddate;
           this.adduser = adduser;
           this.companyName = companyName;
           this.fromDate = fromDate;
           this.modifydate = modifydate;
           this.modifyuser = modifyuser;
           this.personId = personId;
           this.pposition = pposition;
           this.toDate = toDate;
           this.workId = workId;
    }


    /**
     * Gets the adddate value for this WorkexperienceQo.
     * 
     * @return adddate
     */
    public int getAdddate() {
        return adddate;
    }


    /**
     * Sets the adddate value for this WorkexperienceQo.
     * 
     * @param adddate
     */
    public void setAdddate(int adddate) {
        this.adddate = adddate;
    }


    /**
     * Gets the adduser value for this WorkexperienceQo.
     * 
     * @return adduser
     */
    public java.lang.String getAdduser() {
        return adduser;
    }


    /**
     * Sets the adduser value for this WorkexperienceQo.
     * 
     * @param adduser
     */
    public void setAdduser(java.lang.String adduser) {
        this.adduser = adduser;
    }


    /**
     * Gets the companyName value for this WorkexperienceQo.
     * 
     * @return companyName
     */
    public java.lang.String getCompanyName() {
        return companyName;
    }


    /**
     * Sets the companyName value for this WorkexperienceQo.
     * 
     * @param companyName
     */
    public void setCompanyName(java.lang.String companyName) {
        this.companyName = companyName;
    }


    /**
     * Gets the fromDate value for this WorkexperienceQo.
     * 
     * @return fromDate
     */
    public int getFromDate() {
        return fromDate;
    }


    /**
     * Sets the fromDate value for this WorkexperienceQo.
     * 
     * @param fromDate
     */
    public void setFromDate(int fromDate) {
        this.fromDate = fromDate;
    }


    /**
     * Gets the modifydate value for this WorkexperienceQo.
     * 
     * @return modifydate
     */
    public int getModifydate() {
        return modifydate;
    }


    /**
     * Sets the modifydate value for this WorkexperienceQo.
     * 
     * @param modifydate
     */
    public void setModifydate(int modifydate) {
        this.modifydate = modifydate;
    }


    /**
     * Gets the modifyuser value for this WorkexperienceQo.
     * 
     * @return modifyuser
     */
    public java.lang.String getModifyuser() {
        return modifyuser;
    }


    /**
     * Sets the modifyuser value for this WorkexperienceQo.
     * 
     * @param modifyuser
     */
    public void setModifyuser(java.lang.String modifyuser) {
        this.modifyuser = modifyuser;
    }


    /**
     * Gets the personId value for this WorkexperienceQo.
     * 
     * @return personId
     */
    public java.lang.String getPersonId() {
        return personId;
    }


    /**
     * Sets the personId value for this WorkexperienceQo.
     * 
     * @param personId
     */
    public void setPersonId(java.lang.String personId) {
        this.personId = personId;
    }


    /**
     * Gets the pposition value for this WorkexperienceQo.
     * 
     * @return pposition
     */
    public java.lang.String getPposition() {
        return pposition;
    }


    /**
     * Sets the pposition value for this WorkexperienceQo.
     * 
     * @param pposition
     */
    public void setPposition(java.lang.String pposition) {
        this.pposition = pposition;
    }


    /**
     * Gets the toDate value for this WorkexperienceQo.
     * 
     * @return toDate
     */
    public int getToDate() {
        return toDate;
    }


    /**
     * Sets the toDate value for this WorkexperienceQo.
     * 
     * @param toDate
     */
    public void setToDate(int toDate) {
        this.toDate = toDate;
    }


    /**
     * Gets the workId value for this WorkexperienceQo.
     * 
     * @return workId
     */
    public java.lang.String getWorkId() {
        return workId;
    }


    /**
     * Sets the workId value for this WorkexperienceQo.
     * 
     * @param workId
     */
    public void setWorkId(java.lang.String workId) {
        this.workId = workId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WorkexperienceQo)) return false;
        WorkexperienceQo other = (WorkexperienceQo) obj;
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
            ((this.companyName==null && other.getCompanyName()==null) || 
             (this.companyName!=null &&
              this.companyName.equals(other.getCompanyName()))) &&
            this.fromDate == other.getFromDate() &&
            this.modifydate == other.getModifydate() &&
            ((this.modifyuser==null && other.getModifyuser()==null) || 
             (this.modifyuser!=null &&
              this.modifyuser.equals(other.getModifyuser()))) &&
            ((this.personId==null && other.getPersonId()==null) || 
             (this.personId!=null &&
              this.personId.equals(other.getPersonId()))) &&
            ((this.pposition==null && other.getPposition()==null) || 
             (this.pposition!=null &&
              this.pposition.equals(other.getPposition()))) &&
            this.toDate == other.getToDate() &&
            ((this.workId==null && other.getWorkId()==null) || 
             (this.workId!=null &&
              this.workId.equals(other.getWorkId())));
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
        if (getCompanyName() != null) {
            _hashCode += getCompanyName().hashCode();
        }
        _hashCode += getFromDate();
        _hashCode += getModifydate();
        if (getModifyuser() != null) {
            _hashCode += getModifyuser().hashCode();
        }
        if (getPersonId() != null) {
            _hashCode += getPersonId().hashCode();
        }
        if (getPposition() != null) {
            _hashCode += getPposition().hashCode();
        }
        _hashCode += getToDate();
        if (getWorkId() != null) {
            _hashCode += getWorkId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WorkexperienceQo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://gzjl.rcsm.provider.service.trade.support.gmcc.com/", "workexperienceQo"));
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
        elemField.setFieldName("companyName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "companyName"));
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
        elemField.setFieldName("personId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "personId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pposition");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pposition"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "workId"));
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
