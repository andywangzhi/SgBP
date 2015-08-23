/**
 * IWorkexperienceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.gzjl;

public interface IWorkexperienceService extends java.rmi.Remote {
    public int acceptSaveWorkexperience(com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo arg0) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo[] acceptQueryWorkexperience(com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceQo arg0) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo[] acceptWorkexperienceDetail(java.lang.String personId) throws java.rmi.RemoteException;
    public int acceptDelWorkexperienceByworkID(java.lang.String workId) throws java.rmi.RemoteException;
    public int acceptDelWorkexperience(java.lang.String personId) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.gzjl.WorkexperienceVo acceptWorkexperienceDetailbyworkId(java.lang.String workId) throws java.rmi.RemoteException;
}
