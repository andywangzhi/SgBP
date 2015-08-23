/**
 * ITechnologicalHarvestService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.kjcg;

public interface ITechnologicalHarvestService extends java.rmi.Remote {
    public com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestVo[] acceptQueryHarvest(com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestQo arg0) throws java.rmi.RemoteException;
    public int acceptDelTechnologicalHarvest(java.lang.String harvestId) throws java.rmi.RemoteException;
    public int acceptDelTechnologicalHarvestByPerId(java.lang.String personID) throws java.rmi.RemoteException;
    public int acceptSaveTechnologicalHarvest(com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestVo arg0) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestVo acceptTechnologicalHarvestDetail(java.lang.String harvestId) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.kjcg.TechnologicalHarvestVo[] acceptTechnologicalHarvestByPerId(java.lang.String personId) throws java.rmi.RemoteException;
}
