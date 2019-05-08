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
import com.fds.vr.business.model.VRCOPProductionPlantEmployee;
import com.fds.vr.business.service.base.VRCOPProductionPlantEmployeeLocalServiceBaseImpl;

/**
 * The implementation of the vrcop production plant employee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fds.vr.business.service.VRCOPProductionPlantEmployeeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author khoavd
 * @see VRCOPProductionPlantEmployeeLocalServiceBaseImpl
 * @see com.fds.vr.business.service.VRCOPProductionPlantEmployeeLocalServiceUtil
 */
@ProviderType
public class VRCOPProductionPlantEmployeeLocalServiceImpl
	extends VRCOPProductionPlantEmployeeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.fds.vr.business.service.VRCOPProductionPlantEmployeeLocalServiceUtil} to access the vrcop production plant employee local service.
	 */
	
	public List<VRCOPProductionPlantEmployee> findBycopReportRepositoryID(long mtCore, long copReportRepositoryID) throws PortalException, SystemException {
		try {
			return vrcopProductionPlantEmployeePersistence.findBycopReportRepositoryID(mtCore, copReportRepositoryID);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRCOPProductionPlantEmployee>();
		
	}


	public List<VRCOPProductionPlantEmployee> findBycopReportNo(long mtCore, String copReportNo) throws PortalException, SystemException {
		try {
			return vrcopProductionPlantEmployeePersistence.findBycopReportNo(mtCore, copReportNo);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRCOPProductionPlantEmployee>();
		
	}
	

	private Log _log = LogFactoryUtil.getLog(VRCOPProductionPlantEmployeeLocalServiceImpl.class);
}