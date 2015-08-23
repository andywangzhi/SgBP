package com.gmcc.support.trade.service.provider;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface IUserService extends java.rmi.Remote {
    public com.gmcc.support.trade.service.provider.UserVo acceptUserDetail(java.lang.String userId) throws java.rmi.RemoteException;
    public int acceptDelUser(java.lang.String userId) throws java.rmi.RemoteException;
    public int acceptSaveUser(com.gmcc.support.trade.service.provider.UserVo arg0) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.UserVo[] acceptQueryUser(com.gmcc.support.trade.service.provider.UserQo arg0) throws java.rmi.RemoteException;
}
