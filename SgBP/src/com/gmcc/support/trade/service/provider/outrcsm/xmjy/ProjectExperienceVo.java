/**
 * ProjectExperienceVo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.outrcsm.xmjy;

public class ProjectExperienceVo  implements java.io.Serializable {
    private int adddate;

    private java.lang.String adduser;

    private java.lang.String experienceid;

    private int fromDate;

    private int modifydate;

    private java.lang.String modifyuser;

    private java.lang.String personId;

    private java.lang.Long personnum;

    private java.lang.Double projmoney;

    private java.lang.String projname;

    private java.lang.String projresponsibility;

    private int toDate;

    public ProjectExperienceVo() {
    }

    public ProjectExperienceVo(
           int adddate,
           java.lang.String adduser,
           java.lang.String experienceid,
           int fromDate,
           int modifydate,
           java.lang.String modifyuser,
           java.lang.String personId,
           java.lang.Long personnum,
           java.lang.Double projmoney,
           java.lang.String projname,
           java.lang.String projresponsibility,
           int toDate) {
           this.adddate = adddate;
           this.adduser = adduser;
           this.experienceid = experienceid;
           this.fromDate = fromDate;
           this.modifydate = modifydate;
           this.modifyuser = modifyuser;
           this.personId = personId;
           this.personnum = personnum;
           this.projmoney = projmoney;
           this.projname = projname;
           this.projresponsibility = projresponsibility;
           this.toDate = toDate;
    }


    /**
     * Gets the adddate value for this ProjectExperienceVo.
     * 
     * @return adddate
     */
    public int getAdddate() {
        return adddate;
    }


    /**
     * Sets the adddate value for this ProjectExperienceVo.
     * 
     * @param adddate
     */
    public void setAdddate(int adddate) {
        this.adddate = adddate;
    }


    /**
     * Gets the adduser value for this ProjectExperienceVo.
     * 
     * @return adduser
     */
    public java.lang.String getAdduser() {
        return adduser;
    }


    /**
     * Sets the adduser value for this ProjectExperienceVo.
     * 
     * @param adduser
     */
    public void setAdduser(java.lang.String adduser) {
        this.adduser = adduser;
    }


    /**
     * Gets the experienceid value for this ProjectExperienceVo.
     * 
     * @return experienceid
     */
    public java.lang.String getExperienceid() {
        return experienceid;
    }


    /**
     * Sets the experienceid value for this ProjectExperienceVo.
     * 
     * @param experienceid
     */
    public void setExperienceid(java.lang.String experienceid) {
        this.experienceid = experienceid;
    }


    /**
     * Gets the fromDate value for this ProjectExperienceVo.
     * 
     * @return fromDate
     */
    public int getFromDate() {
        return fromDate;
    }


    /**
     * Sets the fromDate value for this ProjectExperienceVo.
     * 
     * @param fromDate
     */
    public void setFromDate(int fromDate) {
        this.fromDate = fromDate;
    }


    /**
     * Gets the modifydate value for this ProjectExperienceVo.
     * 
     * @return modifydate
     */
    public int getModifydate() {
        return modifydate;
    }


    /**
     * Sets the modifydate value for this ProjectExperienceVo.
     * 
     * @param modifydate
     */
    public void setModifydate(int modifydate) {
        this.modifydate = modifydate;
    }


    /**
     * Gets the modifyuser value for this ProjectExperienceVo.
     * 
     * @return modifyuser
     */
    public java.lang.String getModifyuser() {
        return modifyuser;
    }


    /**
     * Sets the modifyuser value for this ProjectExperienceVo.
     * 
     * @param modifyuser
     */
    public void setModifyuser(java.lang.String modifyuser) {
        this.modifyuser = modifyuser;
    }


    /**
     * Gets the personId value for this ProjectExperienceVo.
     * 
     * @return personId
     */
    public java.lang.String getPersonId() {
        return personId;
    }


    /**
     * Sets the personId value for this ProjectExperienceVo.
     * 
     * @param personId
     */
    public void setPersonId(java.lang.String personId) {
        this.personId = personId;
    }


    /**
     * Gets the personnum value for this ProjectExperienceVo.
     * 
     * @return personnum
     */
    public java.lang.Long getPersonnum() {
        return personnum;
    }


    /**
     * Sets the personnum value for this ProjectExperienceVo.
     * 
     * @param personnum
     */
    public void setPersonnum(java.lang.Long personnum) {
        this.personnum = personnum;
    }


    /**
     * Gets the projmoney value for this ProjectExperienceVo.
     * 
     * @return projmoney
     */
    public java.lang.Double getProjmoney() {
        return projmoney;
    }


    /**
     * Sets the projmoney value for this ProjectExperienceVo.
     * 
     * @param projmoney
     */
    public void setProjmoney(java.lang.Double projmoney) {
        this.projmoney = projmoney;
    }


    /**
     * Gets the projname value for this ProjectExperienceVo.
     * 
     * @return projname
     */
    public java.lang.String getProjname() {
        return projname;
    }


    /**
     * Sets the projname value for this ProjectExperienceVo.
     * 
     * @param projname
     */
    public void setProjname(java.lang.String projname) {
        this.projname = projname;
    }


    /**
     * Gets the projresponsibility value for this ProjectExperienceVo.
     * 
     * @return projresponsibility
     */
    public java.lang.String getProjresponsibility() {
        return projresponsibility;
    }


    /**
     * Sets the projresponsibility value for this ProjectExperienceVo.
     * 
     * @param projresponsibility
     */
    public void setProjresponsibility(java.lang.String projresponsibility) {
        this.projresponsibility = projresponsibility;
    }


    /**
     * Gets the toDate value for this ProjectExperienceVo.
     * 
     * @return toDate
     */
    public int getToDate() {
        return toDate;
    }


    /**
     * Sets the toDate value for this ProjectExperienceVo.
     * 
     * @param toDate
     */
    public void setToDate(int toDate) {
        this.toDate = toDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProjectExperienceVo)) return false;
        ProjectExperienceVo other = (ProjectExperienceVo) obj;
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
            ((this.experienceid==null && other.getExperienceid()==null) || 
             (this.experienceid!=null &&
              this.experienceid.equals(other.getExperienceid()))) &&
            this.fromDate == other.getFromDate() &&
            this.modifydate == other.getModifydate() &&
            ((this.modifyuser==null && other.getModifyuser()==null) || 
             (this.modifyuser!=null &&
              this.modifyuser.equals(other.getModifyuser()))) &&
            ((this.personId==null && other.getPersonId()==null) || 
             (this.personId!=null &&
              this.personId.equals(other.getPersonId()))) &&
            ((this.personnum==null && other.getPersonnum()==null) || 
             (this.personnum!=null &&
              this.personnum.equals(other.getPersonnum()))) &&
            ((this.projmoney==null && other.getProjmoney()==null) || 
             (this.projmoney!=null &&
              this.projmoney.equals(other.getProjmoney()))) &&
            ((this.projname==null && other.getProjname()==null) || 
             (this.projname!=null &&
              this.projname.equals(other.getProjname()))) &&
            ((this.projresponsibility==null && other.getProjresponsibility()==null) || 
             (this.projresponsibility!=null &&
              this.projresponsibility.equals(other.getProjresponsibility()))) &&
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
        if (getExperienceid() != null) {
            _hashCode += getExperienceid().hashCode();
        }
        _hashCode += getFromDate();
        _hashCode += getModifydate();
        if (getModifyuser() != null) {
            _hashCode += getModifyuser().hashCode();
        }
        if (getPersonId() != null) {
            _hashCode += getPersonId().hashCode();
        }
        if (getPersonnum() != null) {
            _hashCode += getPersonnum().hashCode();
        }
        if (getProjmoney() != null) {
            _hashCode += getProjmoney().hashCode();
        }
        if (getProjname() != null) {
            _hashCode += getProjname().hashCode();
        }
        if (getProjresponsibility() != null) {
            _hashCode += getProjresponsibility().hashCode();
        }
        _hashCode += getToDate();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProjectExperienceVo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmjy.rcsm.provider.service.trade.support.gmcc.com/", "projectExperienceVo"));
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
        elemField.setFieldName("experienceid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "experienceid"));
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
        elemField.setFieldName("personnum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "personnum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projmoney");
        elemField.setXmlName(new javax.xml.namespace.QName("", "projmoney"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "projname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projresponsibility");
        elemField.setXmlName(new javax.xml.namespace.QName("", "projresponsibility"));
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
