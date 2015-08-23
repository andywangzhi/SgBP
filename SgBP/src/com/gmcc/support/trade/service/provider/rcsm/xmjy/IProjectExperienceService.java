/**
 * IProjectExperienceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.xmjy;

public interface IProjectExperienceService extends java.rmi.Remote {
    public int acceptDelProjectExperience(java.lang.String experienceId) throws java.rmi.RemoteException;
    public int acceptSavePJExperience(com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceVo arg0) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceVo[] acceptPJEByPIdDetail(java.lang.String personId) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceVo[] acceptLikeQueryPJExperience(com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceQo arg0) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.xmjy.ProjectExperienceVo acceptPJExperienceDetail(java.lang.String experienceId) throws java.rmi.RemoteException;
    public int acceptDelPJExperienceByPId(java.lang.String personID) throws java.rmi.RemoteException;
}
