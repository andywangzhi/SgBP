/**
 * Paging.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis #axisVersion# #today# WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.need;

public class Paging  implements java.io.Serializable {
    private int currentIndex;

    private int endRow;

    private int firstIndex;

    private int lastIndex;

    private int nextIndex;

    private int pageSize;

    private int prevIndex;

    private int startRow;

    private int totalPages;

    private long totalRecords;

    private java.lang.Object[] voList;

    public Paging() {
    }

    public Paging(
           int currentIndex,
           int endRow,
           int firstIndex,
           int lastIndex,
           int nextIndex,
           int pageSize,
           int prevIndex,
           int startRow,
           int totalPages,
           long totalRecords,
           java.lang.Object[] voList) {
           this.currentIndex = currentIndex;
           this.endRow = endRow;
           this.firstIndex = firstIndex;
           this.lastIndex = lastIndex;
           this.nextIndex = nextIndex;
           this.pageSize = pageSize;
           this.prevIndex = prevIndex;
           this.startRow = startRow;
           this.totalPages = totalPages;
           this.totalRecords = totalRecords;
           this.voList = voList;
    }


    /**
     * Gets the currentIndex value for this Paging.
     * 
     * @return currentIndex
     */
    public int getCurrentIndex() {
        return currentIndex;
    }


    /**
     * Sets the currentIndex value for this Paging.
     * 
     * @param currentIndex
     */
    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }


    /**
     * Gets the endRow value for this Paging.
     * 
     * @return endRow
     */
    public int getEndRow() {
        return endRow;
    }


    /**
     * Sets the endRow value for this Paging.
     * 
     * @param endRow
     */
    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }


    /**
     * Gets the firstIndex value for this Paging.
     * 
     * @return firstIndex
     */
    public int getFirstIndex() {
        return firstIndex;
    }


    /**
     * Sets the firstIndex value for this Paging.
     * 
     * @param firstIndex
     */
    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }


    /**
     * Gets the lastIndex value for this Paging.
     * 
     * @return lastIndex
     */
    public int getLastIndex() {
        return lastIndex;
    }


    /**
     * Sets the lastIndex value for this Paging.
     * 
     * @param lastIndex
     */
    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }


    /**
     * Gets the nextIndex value for this Paging.
     * 
     * @return nextIndex
     */
    public int getNextIndex() {
        return nextIndex;
    }


    /**
     * Sets the nextIndex value for this Paging.
     * 
     * @param nextIndex
     */
    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }


    /**
     * Gets the pageSize value for this Paging.
     * 
     * @return pageSize
     */
    public int getPageSize() {
        return pageSize;
    }


    /**
     * Sets the pageSize value for this Paging.
     * 
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * Gets the prevIndex value for this Paging.
     * 
     * @return prevIndex
     */
    public int getPrevIndex() {
        return prevIndex;
    }


    /**
     * Sets the prevIndex value for this Paging.
     * 
     * @param prevIndex
     */
    public void setPrevIndex(int prevIndex) {
        this.prevIndex = prevIndex;
    }


    /**
     * Gets the startRow value for this Paging.
     * 
     * @return startRow
     */
    public int getStartRow() {
        return startRow;
    }


    /**
     * Sets the startRow value for this Paging.
     * 
     * @param startRow
     */
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }


    /**
     * Gets the totalPages value for this Paging.
     * 
     * @return totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }


    /**
     * Sets the totalPages value for this Paging.
     * 
     * @param totalPages
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }


    /**
     * Gets the totalRecords value for this Paging.
     * 
     * @return totalRecords
     */
    public long getTotalRecords() {
        return totalRecords;
    }


    /**
     * Sets the totalRecords value for this Paging.
     * 
     * @param totalRecords
     */
    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }


    /**
     * Gets the voList value for this Paging.
     * 
     * @return voList
     */
    public java.lang.Object[] getVoList() {
        return voList;
    }


    /**
     * Sets the voList value for this Paging.
     * 
     * @param voList
     */
    public void setVoList(java.lang.Object[] voList) {
        this.voList = voList;
    }

    public java.lang.Object getVoList(int i) {
        return this.voList[i];
    }

    public void setVoList(int i, java.lang.Object _value) {
        this.voList[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Paging)) return false;
        Paging other = (Paging) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.currentIndex == other.getCurrentIndex() &&
            this.endRow == other.getEndRow() &&
            this.firstIndex == other.getFirstIndex() &&
            this.lastIndex == other.getLastIndex() &&
            this.nextIndex == other.getNextIndex() &&
            this.pageSize == other.getPageSize() &&
            this.prevIndex == other.getPrevIndex() &&
            this.startRow == other.getStartRow() &&
            this.totalPages == other.getTotalPages() &&
            this.totalRecords == other.getTotalRecords() &&
            ((this.voList==null && other.getVoList()==null) || 
             (this.voList!=null &&
              java.util.Arrays.equals(this.voList, other.getVoList())));
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
        _hashCode += getCurrentIndex();
        _hashCode += getEndRow();
        _hashCode += getFirstIndex();
        _hashCode += getLastIndex();
        _hashCode += getNextIndex();
        _hashCode += getPageSize();
        _hashCode += getPrevIndex();
        _hashCode += getStartRow();
        _hashCode += getTotalPages();
        _hashCode += new Long(getTotalRecords()).hashCode();
        if (getVoList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVoList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVoList(), i);
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
        new org.apache.axis.description.TypeDesc(Paging.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://need.rcsm.provider.service.trade.support.gmcc.com/", "paging"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currentIndex");
        elemField.setXmlName(new javax.xml.namespace.QName("", "currentIndex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endRow");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endRow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstIndex");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firstIndex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastIndex");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastIndex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nextIndex");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nextIndex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pageSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prevIndex");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prevIndex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startRow");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startRow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalPages");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalPages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalRecords");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalRecords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("voList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "voList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
