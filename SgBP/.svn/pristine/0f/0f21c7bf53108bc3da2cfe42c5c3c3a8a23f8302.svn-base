/**
 * RsAffixServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.outrcsm.affix;

public class RsAffixServiceLocator extends org.apache.axis.client.Service implements com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixService {

    public RsAffixServiceLocator() {
    }


    public RsAffixServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RsAffixServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RsAffixServicePort
    private java.lang.String RsAffixServicePort_address = "http://localhost:8080/extws/service/RsAffixService";

    public java.lang.String getRsAffixServicePortAddress() {
        return RsAffixServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RsAffixServicePortWSDDServiceName = "RsAffixServicePort";

    public java.lang.String getRsAffixServicePortWSDDServiceName() {
        return RsAffixServicePortWSDDServiceName;
    }

    public void setRsAffixServicePortWSDDServiceName(java.lang.String name) {
        RsAffixServicePortWSDDServiceName = name;
    }

    public com.gmcc.support.trade.service.provider.outrcsm.affix.IRsAffixService getRsAffixServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RsAffixServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRsAffixServicePort(endpoint);
    }

    public com.gmcc.support.trade.service.provider.outrcsm.affix.IRsAffixService getRsAffixServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getRsAffixServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRsAffixServicePortEndpointAddress(java.lang.String address) {
        RsAffixServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.gmcc.support.trade.service.provider.outrcsm.affix.IRsAffixService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixServiceSoapBindingStub(new java.net.URL(RsAffixServicePort_address), this);
                _stub.setPortName(getRsAffixServicePortWSDDServiceName());
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
        if ("RsAffixServicePort".equals(inputPortName)) {
            return getRsAffixServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://affix.rcsm.provider.service.trade.support.gmcc.com/", "OutRsAffixService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://affix.rcsm.provider.service.trade.support.gmcc.com/", "RsAffixServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RsAffixServicePort".equals(portName)) {
            setRsAffixServicePortEndpointAddress(address);
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
