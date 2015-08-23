/**
 * IRsPersonService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.base;

public interface IRsPersonService extends java.rmi.Remote {
    public int acceptUpdateRsPersonState(com.gmcc.support.trade.service.provider.rcsm.base.RsPersonQo arg0) throws java.rmi.RemoteException;
    public java.lang.String acceptSaveRsPerson(com.gmcc.support.trade.service.provider.rcsm.base.RsPersonVo arg0) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.base.RsPersonVo[] acceptQueryRsPerson(com.gmcc.support.trade.service.provider.rcsm.base.RsPersonQo arg0) throws java.rmi.RemoteException;
    public int acceptDelRsPerson(java.lang.String personId) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.base.Paging acceptQueryRsPersonByPage(com.gmcc.support.trade.service.provider.rcsm.base.RsPersonQo arg0, com.gmcc.support.trade.service.provider.rcsm.base.Paging arg1) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.base.RsPersonVo acceptRsPersonDetail(java.lang.String personId) throws java.rmi.RemoteException;
}
