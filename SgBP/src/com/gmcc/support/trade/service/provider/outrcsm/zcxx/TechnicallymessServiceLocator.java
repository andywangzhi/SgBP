/**
 * TechnicallymessServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.outrcsm.zcxx;

public class TechnicallymessServiceLocator extends org.apache.axis.client.Service implements com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessService {

    public TechnicallymessServiceLocator() {
    }


    public TechnicallymessServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TechnicallymessServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TechnicallymessServicePort
    private java.lang.String TechnicallymessServicePort_address = "http://Acer-PC:7001/SG/zcxx/proxy/TechnicallymessProxyService";

    public java.lang.String getTechnicallymessServicePortAddress() {
        return TechnicallymessServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TechnicallymessServicePortWSDDServiceName = "TechnicallymessServicePort";

    public java.lang.String getTechnicallymessServicePortWSDDServiceName() {
        return TechnicallymessServicePortWSDDServiceName;
    }

    public void setTechnicallymessServicePortWSDDServiceName(java.lang.String name) {
        TechnicallymessServicePortWSDDServiceName = name;
    }

    public com.gmcc.support.trade.service.provider.outrcsm.zcxx.ITechnicallymessService getTechnicallymessServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TechnicallymessServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTechnicallymessServicePort(endpoint);
    }

    public com.gmcc.support.trade.service.provider.outrcsm.zcxx.ITechnicallymessService getTechnicallymessServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getTechnicallymessServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTechnicallymessServicePortEndpointAddress(java.lang.String address) {
        TechnicallymessServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.gmcc.support.trade.service.provider.outrcsm.zcxx.ITechnicallymessService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessServiceSoapBindingStub _stub = new com.gmcc.support.trade.service.provider.outrcsm.zcxx.TechnicallymessServiceSoapBindingStub(new java.net.URL(TechnicallymessServicePort_address), this);
                _stub.setPortName(getTechnicallymessServicePortWSDDServiceName());
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
        if ("TechnicallymessServicePort".equals(inputPortName)) {
            return getTechnicallymessServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://zcxx.rcsm.provider.service.trade.support.gmcc.com/", "TechnicallymessService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://zcxx.rcsm.provider.service.trade.support.gmcc.com/", "TechnicallymessServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TechnicallymessServicePort".equals(portName)) {
            setTechnicallymessServicePortEndpointAddress(address);
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
