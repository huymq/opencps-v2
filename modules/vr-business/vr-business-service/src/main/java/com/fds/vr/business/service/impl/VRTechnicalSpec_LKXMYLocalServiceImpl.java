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
import com.fds.vr.business.model.VRTechnicalSpec_LKXMY;
import com.fds.vr.business.service.base.VRTechnicalSpec_LKXMYLocalServiceBaseImpl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the vr technical spec_lkxmy local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fds.vr.business.service.VRTechnicalSpec_LKXMYLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LamTV
 * @see VRTechnicalSpec_LKXMYLocalServiceBaseImpl
 * @see com.fds.vr.business.service.VRTechnicalSpec_LKXMYLocalServiceUtil
 */
@ProviderType
public class VRTechnicalSpec_LKXMYLocalServiceImpl
	extends VRTechnicalSpec_LKXMYLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.fds.vr.business.service.VRTechnicalSpec_LKXMYLocalServiceUtil} to access the vr technical spec_lkxmy local service.
	 */
	
	
	public List<VRTechnicalSpec_LKXMY> findByConvertAssembleId(long convertAssembleId) throws SystemException {
		try {
			return vrTechnicalSpec_LKXMYPersistence.findByConvertAssembleId(convertAssembleId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRTechnicalSpec_LKXMY>();
		
	}
	
	public List<VRTechnicalSpec_LKXMY> findByReferenceUid(String referenceUid) throws SystemException {
		try {
			return vrTechnicalSpec_LKXMYPersistence.findByReferenceUid(referenceUid);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRTechnicalSpec_LKXMY>();
		
	}
	
	public List<VRTechnicalSpec_LKXMY> findByDossierNo(String dossierNo, long mtCore) throws SystemException {
		try {
			return vrTechnicalSpec_LKXMYPersistence.findByDossierNo(dossierNo, mtCore);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRTechnicalSpec_LKXMY>();
		
	}
	
	public List<VRTechnicalSpec_LKXMY> findByDossierId(long dossierId, long mtCore) throws SystemException {
		try {
			return vrTechnicalSpec_LKXMYPersistence.findByDossierId(dossierId, mtCore);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRTechnicalSpec_LKXMY>();
		
	}
	
	public List<VRTechnicalSpec_LKXMY> findByDossierIdCTN(String dossierIdCTN) throws SystemException {
		try {
			return vrTechnicalSpec_LKXMYPersistence.findByDossierIdCTN(dossierIdCTN);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRTechnicalSpec_LKXMY>();
		
	}
	
	public List<VRTechnicalSpec_LKXMY> findByDeliverableCode(String deliverableCode) throws SystemException {
		try {
			return vrTechnicalSpec_LKXMYPersistence.findByDeliverableCode(deliverableCode);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRTechnicalSpec_LKXMY>();
		
	}
	
	private Log _log = LogFactoryUtil.getLog(VRTechnicalSpec_LKXMYLocalServiceImpl.class);
}