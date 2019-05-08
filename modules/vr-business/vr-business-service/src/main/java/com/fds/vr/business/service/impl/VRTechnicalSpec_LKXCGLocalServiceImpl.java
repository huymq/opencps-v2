/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.fds.vr.business.service.impl;

import aQute.bnd.annotation.ProviderType;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import com.fds.vr.business.model.VRTechnicalSpec_LKXCG;
import com.fds.vr.business.service.base.VRTechnicalSpec_LKXCGLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the vr technical spec_lkxcg local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fds.vr.business.service.VRTechnicalSpec_LKXCGLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LamTV
 * @see VRTechnicalSpec_LKXCGLocalServiceBaseImpl
 * @see com.fds.vr.business.service.VRTechnicalSpec_LKXCGLocalServiceUtil
 */
@ProviderType
public class VRTechnicalSpec_LKXCGLocalServiceImpl
	extends VRTechnicalSpec_LKXCGLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.fds.vr.business.service.VRTechnicalSpec_LKXCGLocalServiceUtil} to access the vr technical spec_lkxcg local service.
	 */
	
	public List<VRTechnicalSpec_LKXCG> findByConvertAssembleId(long convertAssembleId) throws SystemException {
		try {
			return vrTechnicalSpec_LKXCGPersistence.findByConvertAssembleId(convertAssembleId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRTechnicalSpec_LKXCG>();
		
	}
	
	public List<VRTechnicalSpec_LKXCG> findByReferenceUid(String referenceUid) throws SystemException {
		try {
			return vrTechnicalSpec_LKXCGPersistence.findByReferenceUid(referenceUid);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRTechnicalSpec_LKXCG>();
		
	}
	
	public List<VRTechnicalSpec_LKXCG> findByDossierNo(String dossierNo, long mtCore) throws SystemException {
		try {
			return vrTechnicalSpec_LKXCGPersistence.findByDossierNo(dossierNo, mtCore);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRTechnicalSpec_LKXCG>();
		
	}
	
	public List<VRTechnicalSpec_LKXCG> findByDossierId(long dossierId, long mtCore) throws SystemException {
		try {
			return vrTechnicalSpec_LKXCGPersistence.findByDossierId(dossierId, mtCore);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRTechnicalSpec_LKXCG>();
		
	}
	
	public List<VRTechnicalSpec_LKXCG> findByDossierIdCTN(String dossierIdCTN) throws SystemException {
		try {
			return vrTechnicalSpec_LKXCGPersistence.findByDossierIdCTN(dossierIdCTN);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRTechnicalSpec_LKXCG>();
		
	}
	
	public List<VRTechnicalSpec_LKXCG> findByDeliverableCode(String deliverableCode) throws SystemException {
		try {
			return vrTechnicalSpec_LKXCGPersistence.findByDeliverableCode(deliverableCode);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRTechnicalSpec_LKXCG>();
		
	}
	
	private Log _log = LogFactoryUtil.getLog(VRTechnicalSpec_LKXCGLocalServiceImpl.class);

}