/**
 * TechnologicalHarvestServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.outrcsm.kjcg;

public class TechnologicalHarvestServiceLocator extends org.apache.axis.client.Service implements com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestService {

    public TechnologicalHarvestServiceLocator() {
    }


    public TechnologicalHarvestServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TechnologicalHarvestServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TechnologicalHarvestServicePort
    private java.lang.String TechnologicalHarvestServicePort_address = "http://localhost:8080/myws/service/TechnologicalHarvestService";

    public java.lang.String getTechnologicalHarvestServicePortAddress() {
        return TechnologicalHarvestServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TechnologicalHarvestServicePortWSDDServiceName = "TechnologicalHarvestServicePort";

    public java.lang.String getTechnologicalHarvestServicePortWSDDServiceName() {
        return TechnologicalHarvestServicePortWSDDServiceName;
    }

    public void setTechnologicalHarvestServicePortWSDDServiceName(java.lang.String name) {
        TechnologicalHarvestServicePortWSDDServiceName = name;
    }

    public com.gmcc.support.trade.service.provider.outrcsm.kjcg.ITechnologicalHarvestService getTechnologicalHarvestServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TechnologicalHarvestServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTechnologicalHarvestServicePort(endpoint);
    }

    public com.gmcc.support.trade.service.provider.outrcsm.kjcg.ITechnologicalHarvestService getTechnologicalHarvestServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getTechnologicalHarvestServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTechnologicalHarvestServicePortEndpointAddress(java.lang.String address) {
        TechnologicalHarvestServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.gmcc.support.trade.service.provider.outrcsm.kjcg.ITechnologicalHarvestService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.outrcsm.kjcg.TechnologicalHarvestServiceSoapBindingStub(new java.net.URL(TechnologicalHarvestServicePort_address), this);
                _stub.setPortName(getTechnologicalHarvestServicePortWSDDServiceName());
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
        if ("TechnologicalHarvestServicePort".equals(inputPortName)) {
            return getTechnologicalHarvestServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://kjcg.rcsm.provider.service.trade.support.gmcc.com/", "TechnologicalHarvestService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://kjcg.rcsm.provider.service.trade.support.gmcc.com/", "TechnologicalHarvestServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TechnologicalHarvestServicePort".equals(portName)) {
            setTechnologicalHarvestServicePortEndpointAddress(address);
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
