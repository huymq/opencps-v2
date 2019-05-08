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
import com.fds.vr.business.model.VRIssueVehiclecertificate;
import com.fds.vr.business.service.base.VRIssueVehiclecertificateLocalServiceBaseImpl;

/**
 * The implementation of the vr issue vehiclecertificate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fds.vr.business.service.VRIssueVehiclecertificateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author khoavd
 * @see VRIssueVehiclecertificateLocalServiceBaseImpl
 * @see com.fds.vr.business.service.VRIssueVehiclecertificateLocalServiceUtil
 */
@ProviderType
public class VRIssueVehiclecertificateLocalServiceImpl
	extends VRIssueVehiclecertificateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.fds.vr.business.service.VRIssueVehiclecertificateLocalServiceUtil} to access the vr issue vehiclecertificate local service.
	 */
	public List<VRIssueVehiclecertificate> findBydossierId(long mtCore, long dossierId) throws PortalException, SystemException {
		try {
			return vrIssueVehiclecertificatePersistence.findBydossierId(mtCore, dossierId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRIssueVehiclecertificate>();
		
	}


	public List<VRIssueVehiclecertificate> findByissueId(long mtCore, long issueId) throws PortalException, SystemException {
		try {
			return vrIssueVehiclecertificatePersistence.findByissueId(mtCore, issueId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRIssueVehiclecertificate>();
		
	}
	
	public List<VRIssueVehiclecertificate> findBycertificateId(long mtCore, long dossierId, long certificateId) throws PortalException, SystemException {
		try {
			return vrIssueVehiclecertificatePersistence.findBycertificateId(mtCore, dossierId, certificateId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRIssueVehiclecertificate>();
		
	}
	

	
	private Log _log = LogFactoryUtil.getLog(VRIssueVehiclecertificateLocalServiceImpl.class);
	
}