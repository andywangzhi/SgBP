/**
 * ProjectExperienceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.xmjy;

public class ProjectExperienceServiceLocator extends org.apache.axis.client.Service implements com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceService {

    public ProjectExperienceServiceLocator() {
    }


    public ProjectExperienceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProjectExperienceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ProjectExperienceServicePort
    private java.lang.String ProjectExperienceServicePort_address = "http://Acer-PC:7001/SG/xmjy/proxy/ProjectExperienceProxyService";

    public java.lang.String getProjectExperienceServicePortAddress() {
        return ProjectExperienceServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProjectExperienceServicePortWSDDServiceName = "ProjectExperienceServicePort";

    public java.lang.String getProjectExperienceServicePortWSDDServiceName() {
        return ProjectExperienceServicePortWSDDServiceName;
    }

    public void setProjectExperienceServicePortWSDDServiceName(java.lang.String name) {
        ProjectExperienceServicePortWSDDServiceName = name;
    }

    public com.gmcc.support.trade.service.provider.rcsm.xmjy.IProjectExperienceService getProjectExperienceServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ProjectExperienceServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProjectExperienceServicePort(endpoint);
    }

    public com.gmcc.support.trade.service.provider.rcsm.xmjy.IProjectExperienceService getProjectExperienceServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getProjectExperienceServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProjectExperienceServicePortEndpointAddress(java.lang.String address) {
        ProjectExperienceServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.gmcc.support.trade.service.provider.rcsm.xmjy.IProjectExperienceService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceServiceSoapBindingStub(new java.net.URL(ProjectExperienceServicePort_address), this);
                _stub.setPortName(getProjectExperienceServicePortWSDDServiceName());
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
        if ("ProjectExperienceServicePort".equals(inputPortName)) {
            return getProjectExperienceServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://xmjy.rcsm.provider.service.trade.support.gmcc.com/", "ProjectExperienceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://xmjy.rcsm.provider.service.trade.support.gmcc.com/", "ProjectExperienceServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ProjectExperienceServicePort".equals(portName)) {
            setProjectExperienceServicePortEndpointAddress(address);
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
