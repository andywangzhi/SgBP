/**
 * RsPersonneedServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis #axisVersion# #today# WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.need;

public class RsPersonneedServiceLocator extends org.apache.axis.client.Service implements com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneedService {

    public RsPersonneedServiceLocator() {
    }


    public RsPersonneedServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RsPersonneedServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RsPersonneedServicePort
    private java.lang.String RsPersonneedServicePort_address = "http://127.0.0.1/myws/service/RsPersonneedService";

    public java.lang.String getRsPersonneedServicePortAddress() {
        return RsPersonneedServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RsPersonneedServicePortWSDDServiceName = "RsPersonneedServicePort";

    public java.lang.String getRsPersonneedServicePortWSDDServiceName() {
        return RsPersonneedServicePortWSDDServiceName;
    }

    public void setRsPersonneedServicePortWSDDServiceName(java.lang.String name) {
        RsPersonneedServicePortWSDDServiceName = name;
    }

    public com.gmcc.support.trade.service.provider.rcsm.need.IRsRsPersonneedService getRsPersonneedServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RsPersonneedServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRsPersonneedServicePort(endpoint);
    }

    public com.gmcc.support.trade.service.provider.rcsm.need.IRsRsPersonneedService getRsPersonneedServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneedServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneedServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getRsPersonneedServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRsPersonneedServicePortEndpointAddress(java.lang.String address) {
        RsPersonneedServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.gmcc.support.trade.service.provider.rcsm.need.IRsRsPersonneedService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneedServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneedServiceSoapBindingStub(new java.net.URL(RsPersonneedServicePort_address), this);
                _stub.setPortName(getRsPersonneedServicePortWSDDServiceName());
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
        if ("RsPersonneedServicePort".equals(inputPortName)) {
            return getRsPersonneedServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://need.rcsm.provider.service.trade.support.gmcc.com/", "RsPersonneedService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://need.rcsm.provider.service.trade.support.gmcc.com/", "RsPersonneedServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RsPersonneedServicePort".equals(portName)) {
            setRsPersonneedServicePortEndpointAddress(address);
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
