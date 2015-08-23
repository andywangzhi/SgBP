/**
 * RsPersonServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.base;

public class RsPersonServiceLocator extends org.apache.axis.client.Service implements com.gmcc.support.trade.service.provider.rcsm.base.RsPersonService {

    public RsPersonServiceLocator() {
    }


    public RsPersonServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RsPersonServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RsPersonServicePort
    private java.lang.String RsPersonServicePort_address = "http://localhost/myws/service/RsPersonService";

    public java.lang.String getRsPersonServicePortAddress() {
        return RsPersonServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RsPersonServicePortWSDDServiceName = "RsPersonServicePort";

    public java.lang.String getRsPersonServicePortWSDDServiceName() {
        return RsPersonServicePortWSDDServiceName;
    }

    public void setRsPersonServicePortWSDDServiceName(java.lang.String name) {
        RsPersonServicePortWSDDServiceName = name;
    }

    public com.gmcc.support.trade.service.provider.rcsm.base.IRsPersonService getRsPersonServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RsPersonServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRsPersonServicePort(endpoint);
    }

    public com.gmcc.support.trade.service.provider.rcsm.base.IRsPersonService getRsPersonServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.gmcc.support.trade.service.provider.rcsm.base.RsPersonServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.rcsm.base.RsPersonServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getRsPersonServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRsPersonServicePortEndpointAddress(java.lang.String address) {
        RsPersonServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.gmcc.support.trade.service.provider.rcsm.base.IRsPersonService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.gmcc.support.trade.service.provider.rcsm.base.RsPersonServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.rcsm.base.RsPersonServiceSoapBindingStub(new java.net.URL(RsPersonServicePort_address), this);
                _stub.setPortName(getRsPersonServicePortWSDDServiceName());
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
        if ("RsPersonServicePort".equals(inputPortName)) {
            return getRsPersonServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://base.rcsm.provider.service.trade.support.gmcc.com/", "RsPersonService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://base.rcsm.provider.service.trade.support.gmcc.com/", "RsPersonServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RsPersonServicePort".equals(portName)) {
            setRsPersonServicePortEndpointAddress(address);
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
