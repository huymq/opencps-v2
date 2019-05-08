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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.fds.vr.business.model.VRIssue;
import com.fds.vr.business.service.base.VRIssueLocalServiceBaseImpl;

/**
 * The implementation of the vr issue local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fds.vr.business.service.VRIssueLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author khoavd
 * @see VRIssueLocalServiceBaseImpl
 * @see com.fds.vr.business.service.VRIssueLocalServiceUtil
 */
@ProviderType
public class VRIssueLocalServiceImpl extends VRIssueLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.fds.vr.business.service.VRIssueLocalServiceUtil} to access the vr issue local service.
	 */
	
	public List<VRIssue> findBydossierId(long mtCore, long dossierId) throws PortalException, SystemException {
		try {
			return vrIssuePersistence.findBydossierId(mtCore, dossierId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRIssue>();
		
	}


	public List<VRIssue> findBystampIssueNo(long mtCore, String stampIssueNo) throws PortalException, SystemException {
		try {
			return vrIssuePersistence.findBystampIssueNo(mtCore, stampIssueNo);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRIssue>();
		
	}
	
	public List<VRIssue> findByapplicantProfileId(long mtCore, long dossierId, long applicantProfileId) throws PortalException, SystemException {
		try {
			return vrIssuePersistence.findByapplicantProfileId(mtCore, dossierId, applicantProfileId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRIssue>();
		
	}
	
	public List<VRIssue> findBycorporationId(long mtCore, String corporationId) throws PortalException, SystemException {
		try {
			return vrIssuePersistence.findBycorporationId(mtCore, corporationId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRIssue>();
		
	}
	
	public List<VRIssue> findByissueCorporationId(long mtCore, String issueCorporationId) throws PortalException, SystemException {
		try {
			return vrIssuePersistence.findByissueCorporationId(mtCore, issueCorporationId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRIssue>();
		
	}
	
	public List<VRIssue> findByverifyCorporationId(long mtCore, String verifyCorporationId) throws PortalException, SystemException {
		try {
			return vrIssuePersistence.findByverifyCorporationId(mtCore, verifyCorporationId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRIssue>();
		
	}
	

	public List<VRIssue> findByproductionPlantId(long mtCore, long productionPlantId) throws PortalException, SystemException {
		try {
			return vrIssuePersistence.findByproductionPlantId(mtCore, productionPlantId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRIssue>();
		
	}
	
	public List<VRIssue> findBycopreportno(long mtCore, String copreportno) throws PortalException, SystemException {
		try {
			return vrIssuePersistence.findBycopreportno(mtCore, copreportno);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRIssue>();
		
	}
	
	private Log _log = LogFactoryUtil.getLog(VRIssueLocalServiceImpl.class);
}