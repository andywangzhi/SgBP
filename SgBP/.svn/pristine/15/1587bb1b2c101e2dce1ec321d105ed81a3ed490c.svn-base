package com.gmcc.support.trade.service.provider;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class UserServiceTestCase extends junit.framework.TestCase {
    public UserServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testUserServicePortWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.gmcc.support.trade.service.provider.UserServiceLocator().getUserServicePortAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.gmcc.support.trade.service.provider.UserServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1UserServicePortAcceptUserDetail() throws Exception {
        com.gmcc.support.trade.service.provider.UserServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.UserServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.UserServiceLocator().getUserServicePort();
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
        com.gmcc.support.trade.service.provider.UserVo value = null;
        value = binding.acceptUserDetail(new java.lang.String());
        // TBD - validate results
    }

    public void test2UserServicePortAcceptDelUser() throws Exception {
        com.gmcc.support.trade.service.provider.UserServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.UserServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.UserServiceLocator().getUserServicePort();
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
        value = binding.acceptDelUser(new java.lang.String());
        // TBD - validate results
    }

    public void test3UserServicePortAcceptSaveUser() throws Exception {
        com.gmcc.support.trade.service.provider.UserServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.UserServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.UserServiceLocator().getUserServicePort();
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
        value = binding.acceptSaveUser(new com.gmcc.support.trade.service.provider.UserVo());
        // TBD - validate results
    }

    public void test4UserServicePortAcceptQueryUser() throws Exception {
        com.gmcc.support.trade.service.provider.UserServiceSoapBindingStub binding;
        try {
            binding = (com.gmcc.support.trade.service.provider.UserServiceSoapBindingStub)
                          new com.gmcc.support.trade.service.provider.UserServiceLocator().getUserServicePort();
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
        com.gmcc.support.trade.service.provider.UserVo[] value = null;
        value = binding.acceptQueryUser(new com.gmcc.support.trade.service.provider.UserQo());
        // TBD - validate results
    }

}
