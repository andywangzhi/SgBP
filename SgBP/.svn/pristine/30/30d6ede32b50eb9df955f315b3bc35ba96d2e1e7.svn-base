/**
 * EducationexperienceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.outrcsm.jyjl;

public class EducationexperienceServiceLocator extends org.apache.axis.client.Service implements com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceService {

    public EducationexperienceServiceLocator() {
    }


    public EducationexperienceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EducationexperienceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EducationexperienceServicePort
    private java.lang.String EducationexperienceServicePort_address = "http://127.0.0.1:7001/myws/service/EducationexperienceService";

    public java.lang.String getEducationexperienceServicePortAddress() {
        return EducationexperienceServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EducationexperienceServicePortWSDDServiceName = "EducationexperienceServicePort";

    public java.lang.String getEducationexperienceServicePortWSDDServiceName() {
        return EducationexperienceServicePortWSDDServiceName;
    }

    public void setEducationexperienceServicePortWSDDServiceName(java.lang.String name) {
        EducationexperienceServicePortWSDDServiceName = name;
    }

    public com.gmcc.support.trade.service.provider.outrcsm.jyjl.IEducationexperienceService getEducationexperienceServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EducationexperienceServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEducationexperienceServicePort(endpoint);
    }

    public com.gmcc.support.trade.service.provider.outrcsm.jyjl.IEducationexperienceService getEducationexperienceServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getEducationexperienceServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEducationexperienceServicePortEndpointAddress(java.lang.String address) {
        EducationexperienceServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.gmcc.support.trade.service.provider.outrcsm.jyjl.IEducationexperienceService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.outrcsm.jyjl.EducationexperienceServiceSoapBindingStub(new java.net.URL(EducationexperienceServicePort_address), this);
                _stub.setPortName(getEducationexperienceServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EducationexperienceServicePort".equals(inputPortName)) {
            return getEducationexperienceServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://jyjl.rcsm.provider.service.trade.support.gmcc.com/", "EducationexperienceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://jyjl.rcsm.provider.service.trade.support.gmcc.com/", "EducationexperienceServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EducationexperienceServicePort".equals(portName)) {
            setEducationexperienceServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
