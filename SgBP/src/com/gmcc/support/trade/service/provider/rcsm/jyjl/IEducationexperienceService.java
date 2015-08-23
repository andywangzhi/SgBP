/**
 * IEducationexperienceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gmcc.support.trade.service.provider.rcsm.jyjl;

public interface IEducationexperienceService extends java.rmi.Remote {
    public int acceptDelEduExpbyPerId(java.lang.String personID) throws java.rmi.RemoteException;
    public int acceptSaveEduExp(com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceVo arg0) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceVo[] acceptQueryEducationexperience(com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceQo arg0) throws java.rmi.RemoteException;
    public int acceptDelEduExp(java.lang.String educationID) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceVo[] acceptEduExpDetailbyPersonId(java.lang.String personID) throws java.rmi.RemoteException;
    public com.gmcc.support.trade.service.provider.rcsm.jyjl.EducationexperienceVo acceptEduExpDetailbyEduId(java.lang.String educationID) throws java.rmi.RemoteException;
}
