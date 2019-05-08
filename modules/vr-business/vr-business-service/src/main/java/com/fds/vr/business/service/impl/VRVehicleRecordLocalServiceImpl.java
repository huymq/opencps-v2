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
import com.fds.vr.business.model.VRVehicleRecord;
import com.fds.vr.business.service.base.VRVehicleRecordLocalServiceBaseImpl;

/**
 * The implementation of the vr vehicle record local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fds.vr.business.service.VRVehicleRecordLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author khoavd
 * @see VRVehicleRecordLocalServiceBaseImpl
 * @see com.fds.vr.business.service.VRVehicleRecordLocalServiceUtil
 */
@ProviderType
public class VRVehicleRecordLocalServiceImpl
	extends VRVehicleRecordLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.fds.vr.business.service.VRVehicleRecordLocalServiceUtil} to access the vr vehicle record local service.
	 */
	
	public List<VRVehicleRecord> findByissueVehicleCertificateId(long mtCore, long issueVehicleCertificateId) throws PortalException, SystemException {
		try {
			return vrVehicleRecordPersistence.findByissueVehicleCertificateId(mtCore, issueVehicleCertificateId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRVehicleRecord>();
		
	}


	public List<VRVehicleRecord> findBydossierId(long mtCore, long dossierId) throws PortalException, SystemException {
		try {
			return vrVehicleRecordPersistence.findBydossierId(mtCore, dossierId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRVehicleRecord>();
		
	}
	
	public List<VRVehicleRecord> findBycertificateId(long mtCore, long certificateId) throws PortalException, SystemException {
		try {
			return vrVehicleRecordPersistence.findBycertificateId(mtCore, certificateId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRVehicleRecord>();
		
	}
	
	public List<VRVehicleRecord> findByapplicantProfileId(long mtCore, long applicantProfileId) throws PortalException, SystemException {
		try {
			return vrVehicleRecordPersistence.findByapplicantProfileId(mtCore, applicantProfileId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRVehicleRecord>();
		
	}
	
	public List<VRVehicleRecord> findByapplicantProfileIdAndPrintingStatus(long mtCore, long applicantProfileId, long printingStatus) throws PortalException, SystemException {
		try {
			return vrVehicleRecordPersistence.findByapplicantProfileIdAndPrintingStatus(mtCore, applicantProfileId, printingStatus);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRVehicleRecord>();
		
	}
	
	public List<VRVehicleRecord> findByapplicantProfileIdAndVehicleRecordStatus(long mtCore, long applicantProfileId, long vehicleRecordStatus) throws PortalException, SystemException {
		try {
			return vrVehicleRecordPersistence.findByapplicantProfileIdAndVehicleRecordStatus(mtCore, applicantProfileId, vehicleRecordStatus);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRVehicleRecord>();
		
	}
	
	private Log _log = LogFactoryUtil.getLog(VRVehicleRecordLocalServiceImpl.class);
}