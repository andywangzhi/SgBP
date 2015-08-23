/**
 * TechnicallymessServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.zcxx;

public class TechnicallymessServiceTestCase extends junit.framework.TestCase {
    public TechnicallymessServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testTechnicallymessServicePortWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceLocator().getTechnicallymessServicePortAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1TechnicallymessServicePortAcceptTechnicallymessDetail() throws Exception {
        com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceLocator().getTechnicallymessServicePort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessVo value = null;
        value = binding.acceptTechnicallymessDetail(new java.lang.String());
        // TBD - validate results
    }

    public void test2TechnicallymessServicePortAcceptDelTechnicallymessByPersonId() throws Exception {
        com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceLocator().getTechnicallymessServicePort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.acceptDelTechnicallymessByPersonId(new java.lang.String());
        // TBD - validate results
    }

    public void test3TechnicallymessServicePortAcceptSaveTechnicallymess() throws Exception {
        com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceLocator().getTechnicallymessServicePort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.acceptSaveTechnicallymess(new com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessVo());
        // TBD - validate results
    }

    public void test4TechnicallymessServicePortAcceptDelTechnicallymess() throws Exception {
        com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceLocator().getTechnicallymessServicePort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.acceptDelTechnicallymess(new java.lang.String());
        // TBD - validate results
    }

    public void test5TechnicallymessServicePortAcceptTechnicallymessDetailByPersonId() throws Exception {
        com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessServiceLocator().getTechnicallymessServicePort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessVo[] value = null;
        value = binding.acceptTechnicallymessDetailByPersonId(new java.lang.String());
        // TBD - validate results
    }

}
