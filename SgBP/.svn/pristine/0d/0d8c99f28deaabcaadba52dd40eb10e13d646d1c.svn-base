/**
 * RsPersonTypeServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.rctj;

public class RsPersonTypeServiceLocator extends org.apache.axis.client.Service implements com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeService {

    public RsPersonTypeServiceLocator() {
    }


    public RsPersonTypeServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RsPersonTypeServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RsPersonTypeServicePort
    private java.lang.String RsPersonTypeServicePort_address = "http://127.0.0.1:7001/myws/RsPersonTypeService";

    public java.lang.String getRsPersonTypeServicePortAddress() {
        return RsPersonTypeServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RsPersonTypeServicePortWSDDServiceName = "RsPersonTypeServicePort";

    public java.lang.String getRsPersonTypeServicePortWSDDServiceName() {
        return RsPersonTypeServicePortWSDDServiceName;
    }

    public void setRsPersonTypeServicePortWSDDServiceName(java.lang.String name) {
        RsPersonTypeServicePortWSDDServiceName = name;
    }

    public com.gmcc.support.trade.service.provider.rcsm.rctj.IRsPersonTypeService getRsPersonTypeServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RsPersonTypeServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRsPersonTypeServicePort(endpoint);
    }

    public com.gmcc.support.trade.service.provider.rcsm.rctj.IRsPersonTypeService getRsPersonTypeServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeServicePortBindingStub _stub = new com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeServicePortBindingStub(portAddress, this);
            _stub.setPortName(getRsPersonTypeServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRsPersonTypeServicePortEndpointAddress(java.lang.String address) {
        RsPersonTypeServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.gmcc.support.trade.service.provider.rcsm.rctj.IRsPersonTypeService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeServicePortBindingStub _stub = new com.gmcc.support.trade.service.provider.rcsm.rctj.RsPersonTypeServicePortBindingStub(new java.net.URL(RsPersonTypeServicePort_address), this);
                _stub.setPortName(getRsPersonTypeServicePortWSDDServiceName());
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
        if ("RsPersonTypeServicePort".equals(inputPortName)) {
            return getRsPersonTypeServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://rctj.rcsm.provider.service.trade.support.gmcc.com/", "RsPersonTypeService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://rctj.rcsm.provider.service.trade.support.gmcc.com/", "RsPersonTypeServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RsPersonTypeServicePort".equals(portName)) {
            setRsPersonTypeServicePortEndpointAddress(address);
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
