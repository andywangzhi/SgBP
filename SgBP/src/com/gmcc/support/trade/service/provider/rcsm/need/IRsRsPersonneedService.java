/**
 * IRsRsPersonneedService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis #axisVersion# #today# WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.need;

public interface IRsRsPersonneedService extends java.rmi.Remote {
    public int acceptDelRsPersonneed(java.lang.String needid) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed[] acceptQueryRsPersonneed(com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed arg0) throws java.rmi.RemoteException;
    public int acceptUpdateRsPersonneedState(com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed arg0) throws java.rmi.RemoteException;
    public java.lang.String acceptSaveRsPersonneed(com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed arg0) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed acceptRsPersonneedDetail(java.lang.String needid) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.need.Paging acceptQueryRsPersonneedByPage(com.gmcc.support.trade.service.provider.rcsm.need.RsPersonneed arg0, com.gmcc.support.trade.service.provider.rcsm.need.Paging arg1) throws java.rmi.RemoteException;
}
