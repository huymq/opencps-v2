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

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import com.fds.vr.business.model.VRDossierFile;
import com.fds.vr.business.model.VRInspectionStandard;
import com.fds.vr.business.model.VRRegistration;
import com.fds.vr.business.service.base.VRInspectionStandardLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the vr inspection standard local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fds.vr.business.service.VRInspectionStandardLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author khoavd
 * @see VRInspectionStandardLocalServiceBaseImpl
 * @see com.fds.vr.business.service.VRInspectionStandardLocalServiceUtil
 */
@ProviderType
public class VRInspectionStandardLocalServiceImpl
	extends VRInspectionStandardLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.fds.vr.business.service.VRInspectionStandardLocalServiceUtil} to access the vr inspection standard local service.
	 */

	public VRInspectionStandard updateInspectionStandard(LinkedHashMap<String, String> mapValues,
			long vrVehicleCertificateId, Date modifiedDate, VRRegistration registration, VRDossierFile dossierFile) {
		
		Date now = new Date();

		long vrInspectionStandardId = counterLocalService.increment(VRInspectionStandard.class.getName());

		VRInspectionStandard object = vrInspectionStandardPersistence.create(vrInspectionStandardId);

		/// Add audit fields
		object.setSyncDate(now);
		object.setModifyDate(modifiedDate);

		// Add other fields
		object.setVehicleCertificateId(vrVehicleCertificateId);
		// TODO
		
		

		return vrInspectionStandardPersistence.update(object);
	}
	
	public List<VRInspectionStandard> findByvehicleCertificateId(long vehicleCertificateId, long markupstatus) throws PortalException, SystemException {
		try {
			return vrInspectionStandardPersistence.findByvehicleCertificateId(vehicleCertificateId, markupstatus);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInspectionStandard>();
		
	}


	public List<VRInspectionStandard> findByDeliverableCode(String deliverableCode) throws PortalException, SystemException {
		try {
			return vrInspectionStandardPersistence.findByDeliverableCode(deliverableCode);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInspectionStandard>();
		
	}
	
	private Log _log = LogFactoryUtil.getLog(VRInspectionStandardLocalServiceImpl.class);
}