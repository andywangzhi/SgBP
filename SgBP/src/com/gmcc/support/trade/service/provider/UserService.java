package com.gmcc.support.trade.service.provider;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface UserService extends javax.xml.rpc.Service {
    public java.lang.String getUserServicePortAddress();

    public com.gmcc.support.trade.service.provider.IUserService getUserServicePort() throws javax.xml.rpc.ServiceException;

    public com.gmcc.support.trade.service.provider.IUserService getUserServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
