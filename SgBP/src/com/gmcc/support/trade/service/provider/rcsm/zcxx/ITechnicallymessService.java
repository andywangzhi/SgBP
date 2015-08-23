/**
 * ITechnicallymessService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.zcxx;

public interface ITechnicallymessService extends java.rmi.Remote {
    public com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessVo acceptTechnicallymessDetail(java.lang.String techId) throws java.rmi.RemoteException;
    public int acceptDelTechnicallymessByPersonId(java.lang.String personID) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessVo[] acceptQueryTechnicallymess(com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessQo arg0) throws java.rmi.RemoteException;
    public int acceptSaveTechnicallymess(com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessVo arg0) throws java.rmi.RemoteException;
    public int acceptDelTechnicallymess(java.lang.String techId) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.zcxx.TechnicallymessVo[] acceptTechnicallymessDetailByPersonId(java.lang.String personID) throws java.rmi.RemoteException;
}
