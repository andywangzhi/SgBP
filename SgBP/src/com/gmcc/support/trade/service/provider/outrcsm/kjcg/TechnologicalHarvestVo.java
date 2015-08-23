/**
 * TechnologicalHarvestVo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.outrcsm.kjcg;

public class TechnologicalHarvestVo  implements java.io.Serializable {
    private int adddate;

    private java.lang.String adduser;

    private int assessDate;

    private java.lang.String assessDep;

    private java.lang.String harvestId;

    private java.lang.String harvestLevel;

    private java.lang.String harvestName;

    private int modifydate;

    private java.lang.String modifyuser;

    private java.lang.String pdemo;

    private java.lang.String personId;

    public TechnologicalHarvestVo() {
    }

    public TechnologicalHarvestVo(
           int adddate,
           java.lang.String adduser,
           int assessDate,
           java.lang.String assessDep,
           java.lang.String harvestId,
           java.lang.String harvestLevel,
           java.lang.String harvestName,
           int modifydate,
           java.lang.String modifyuser,
           java.lang.String pdemo,
           java.lang.String personId) {
           this.adddate = adddate;
           this.adduser = adduser;
           this.assessDate = assessDate;
           this.assessDep = assessDep;
           this.harvestId = harvestId;
           this.harvestLevel = harvestLevel;
           this.harvestName = harvestName;
           this.modifydate = modifydate;
           this.modifyuser = modifyuser;
           this.pdemo = pdemo;
           this.personId = personId;
    }


    /**
     * Gets the adddate value for this TechnologicalHarvestVo.
     * 
     * @return adddate
     */
    public int getAdddate() {
        return adddate;
    }


    /**
     * Sets the adddate value for this TechnologicalHarvestVo.
     * 
     * @param adddate
     */
    public void setAdddate(int adddate) {
        this.adddate = adddate;
    }


    /**
     * Gets the adduser value for this TechnologicalHarvestVo.
     * 
     * @return adduser
     */
    public java.lang.String getAdduser() {
        return adduser;
    }


    /**
     * Sets the adduser value for this TechnologicalHarvestVo.
     * 
     * @param adduser
     */
    public void setAdduser(java.lang.String adduser) {
        this.adduser = adduser;
    }


    /**
     * Gets the assessDate value for this TechnologicalHarvestVo.
     * 
     * @return assessDate
     */
    public int getAssessDate() {
        return assessDate;
    }


    /**
     * Sets the assessDate value for this TechnologicalHarvestVo.
     * 
     * @param assessDate
     */
    public void setAssessDate(int assessDate) {
        this.assessDate = assessDate;
    }


    /**
     * Gets the assessDep value for this TechnologicalHarvestVo.
     * 
     * @return assessDep
     */
    public java.lang.String getAssessDep() {
        return assessDep;
    }


    /**
     * Sets the assessDep value for this TechnologicalHarvestVo.
     * 
     * @param assessDep
     */
    public void setAssessDep(java.lang.String assessDep) {
        this.assessDep = assessDep;
    }


    /**
     * Gets the harvestId value for this TechnologicalHarvestVo.
     * 
     * @return harvestId
     */
    public java.lang.String getHarvestId() {
        return harvestId;
    }


    /**
     * Sets the harvestId value for this TechnologicalHarvestVo.
     * 
     * @param harvestId
     */
    public void setHarvestId(java.lang.String harvestId) {
        this.harvestId = harvestId;
    }


    /**
     * Gets the harvestLevel value for this TechnologicalHarvestVo.
     * 
     * @return harvestLevel
     */
    public java.lang.String getHarvestLevel() {
        return harvestLevel;
    }


    /**
     * Sets the harvestLevel value for this TechnologicalHarvestVo.
     * 
     * @param harvestLevel
     */
    public void setHarvestLevel(java.lang.String harvestLevel) {
        this.harvestLevel = harvestLevel;
    }


    /**
     * Gets the harvestName value for this TechnologicalHarvestVo.
     * 
     * @return harvestName
     */
    public java.lang.String getHarvestName() {
        return harvestName;
    }


    /**
     * Sets the harvestName value for this TechnologicalHarvestVo.
     * 
     * @param harvestName
     */
    public void setHarvestName(java.lang.String harvestName) {
        this.harvestName = harvestName;
    }


    /**
     * Gets the modifydate value for this TechnologicalHarvestVo.
     * 
     * @return modifydate
     */
    public int getModifydate() {
        return modifydate;
    }


    /**
     * Sets the modifydate value for this TechnologicalHarvestVo.
     * 
     * @param modifydate
     */
    public void setModifydate(int modifydate) {
        this.modifydate = modifydate;
    }


    /**
     * Gets the modifyuser value for this TechnologicalHarvestVo.
     * 
     * @return modifyuser
     */
    public java.lang.String getModifyuser() {
        return modifyuser;
    }


    /**
     * Sets the modifyuser value for this TechnologicalHarvestVo.
     * 
     * @param modifyuser
     */
    public void setModifyuser(java.lang.String modifyuser) {
        this.modifyuser = modifyuser;
    }


    /**
     * Gets the pdemo value for this TechnologicalHarvestVo.
     * 
     * @return pdemo
     */
    public java.lang.String getPdemo() {
        return pdemo;
    }


    /**
     * Sets the pdemo value for this TechnologicalHarvestVo.
     * 
     * @param pdemo
     */
    public void setPdemo(java.lang.String pdemo) {
        this.pdemo = pdemo;
    }


    /**
     * Gets the personId value for this TechnologicalHarvestVo.
     * 
     * @return personId
     */
    public java.lang.String getPersonId() {
        return personId;
    }


    /**
     * Sets the personId value for this TechnologicalHarvestVo.
     * 
     * @param personId
     */
    public void setPersonId(java.lang.String personId) {
        this.personId = personId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TechnologicalHarvestVo)) return false;
        TechnologicalHarvestVo other = (TechnologicalHarvestVo) obj;
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
            this.assessDate == other.getAssessDate() &&
            ((this.assessDep==null && other.getAssessDep()==null) || 
             (this.assessDep!=null &&
              this.assessDep.equals(other.getAssessDep()))) &&
            ((this.harvestId==null && other.getHarvestId()==null) || 
             (this.harvestId!=null &&
              this.harvestId.equals(other.getHarvestId()))) &&
            ((this.harvestLevel==null && other.getHarvestLevel()==null) || 
             (this.harvestLevel!=null &&
              this.harvestLevel.equals(other.getHarvestLevel()))) &&
            ((this.harvestName==null && other.getHarvestName()==null) || 
             (this.harvestName!=null &&
              this.harvestName.equals(other.getHarvestName()))) &&
            this.modifydate == other.getModifydate() &&
            ((this.modifyuser==null && other.getModifyuser()==null) || 
             (this.modifyuser!=null &&
              this.modifyuser.equals(other.getModifyuser()))) &&
            ((this.pdemo==null && other.getPdemo()==null) || 
             (this.pdemo!=null &&
              this.pdemo.equals(other.getPdemo()))) &&
            ((this.personId==null && other.getPersonId()==null) || 
             (this.personId!=null &&
              this.personId.equals(other.getPersonId())));
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
        _hashCode += getAssessDate();
        if (getAssessDep() != null) {
            _hashCode += getAssessDep().hashCode();
        }
        if (getHarvestId() != null) {
            _hashCode += getHarvestId().hashCode();
        }
        if (getHarvestLevel() != null) {
            _hashCode += getHarvestLevel().hashCode();
        }
        if (getHarvestName() != null) {
            _hashCode += getHarvestName().hashCode();
        }
        _hashCode += getModifydate();
        if (getModifyuser() != null) {
            _hashCode += getModifyuser().hashCode();
        }
        if (getPdemo() != null) {
            _hashCode += getPdemo().hashCode();
        }
        if (getPersonId() != null) {
            _hashCode += getPersonId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TechnologicalHarvestVo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://kjcg.rcsm.provider.service.trade.support.gmcc.com/", "technologicalHarvestVo"));
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
        elemField.setFieldName("assessDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "assessDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assessDep");
        elemField.setXmlName(new javax.xml.namespace.QName("", "assessDep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("harvestId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "harvestId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("harvestLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "harvestLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("harvestName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "harvestName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("pdemo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pdemo"));
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
