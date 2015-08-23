/**
 * WorkexperienceServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.gzjl;

public class WorkexperienceServiceTestCase extends junit.framework.TestCase {
    public WorkexperienceServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testWorkexperienceServicePortWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceLocator().getWorkexperienceServicePortAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1WorkexperienceServicePortAcceptSaveWorkexperience() throws Exception {
        com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceLocator().getWorkexperienceServicePort();
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
        value = binding.acceptSaveWorkexperience(new com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo());
        // TBD - validate results
    }

    public void test2WorkexperienceServicePortAcceptQueryWorkexperience() throws Exception {
        com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceLocator().getWorkexperienceServicePort();
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
        com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo[] value = null;
        value = binding.acceptQueryWorkexperience(new com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceQo());
        // TBD - validate results
    }

    public void test3WorkexperienceServicePortAcceptWorkexperienceDetail() throws Exception {
        com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceLocator().getWorkexperienceServicePort();
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
        com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo[] value = null;
        value = binding.acceptWorkexperienceDetail(new java.lang.String());
        // TBD - validate results
    }

    public void test4WorkexperienceServicePortAcceptDelWorkexperienceByworkID() throws Exception {
        com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceLocator().getWorkexperienceServicePort();
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
        value = binding.acceptDelWorkexperienceByworkID(new java.lang.String());
        // TBD - validate results
    }

    public void test5WorkexperienceServicePortAcceptDelWorkexperience() throws Exception {
        com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceLocator().getWorkexperienceServicePort();
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
        value = binding.acceptDelWorkexperience(new java.lang.String());
        // TBD - validate results
    }

    public void test6WorkexperienceServicePortAcceptWorkexperienceDetailbyworkId() throws Exception {
        com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceServiceLocator().getWorkexperienceServicePort();
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
        com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo value = null;
        value = binding.acceptWorkexperienceDetailbyworkId(new java.lang.String());
        // TBD - validate results
    }

}
