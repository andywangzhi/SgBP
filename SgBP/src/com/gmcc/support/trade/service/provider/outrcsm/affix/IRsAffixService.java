/**
 * IRsAffixService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.outrcsm.affix;

public interface IRsAffixService extends java.rmi.Remote {
    public int acceptStateRsAffixByRsAffixId(com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixVo arg0) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixQo[] accepFindAffixByRsAffixId(java.lang.String rsAffixId) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixVo acceptSaveOrUpdateRsAffix(com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixVo arg0) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixQo[] acceptFindRsAffixByPersonId(java.lang.String personId) throws java.rmi.RemoteException;
    public int acceptStateRsAffixByPersonId(com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixVo arg0) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixQo[] acceptFindRsAffix(com.gmcc.support.trade.service.provider.outrcsm.affix.RsAffixQo arg0) throws java.rmi.RemoteException;
}
