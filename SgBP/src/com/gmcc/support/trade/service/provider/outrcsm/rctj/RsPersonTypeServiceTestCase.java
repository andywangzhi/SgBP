/**
 * RsPersonTypeServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.outrcsm.rctj;

public class RsPersonTypeServiceTestCase extends junit.framework.TestCase {
    public RsPersonTypeServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testRsPersonTypeServicePortWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServiceLocator().getRsPersonTypeServicePortAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1RsPersonTypeServicePortAcceptRsPersonTypeDetailByPcounty() throws Exception {
        com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServicePortBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServicePortBindingStub)
                          new com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServiceLocator().getRsPersonTypeServicePort();
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
        com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeVo[] value = null;
        value = binding.acceptRsPersonTypeDetailByPcounty(new com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeQo());
        // TBD - validate results
    }

    public void test2RsPersonTypeServicePortAcceptRsPersonTypeDetailBySpecialtyType() throws Exception {
        com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServicePortBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServicePortBindingStub)
                          new com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServiceLocator().getRsPersonTypeServicePort();
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
        com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeVo[] value = null;
        value = binding.acceptRsPersonTypeDetailBySpecialtyType(new com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeQo());
        // TBD - validate results
    }

    public void test3RsPersonTypeServicePortAcceptRsPersonTypeDetailByTechnicallytype() throws Exception {
        com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServicePortBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServicePortBindingStub)
                          new com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeServiceLocator().getRsPersonTypeServicePort();
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
        com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeVo[] value = null;
        value = binding.acceptRsPersonTypeDetailByTechnicallytype(new com.gmcc.support.trade.service.provider.outrcsm.rctj.RsPersonTypeQo());
        // TBD - validate results
    }

}
