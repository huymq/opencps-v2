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

import com.fds.vr.business.model.VRDossierFile;
import com.fds.vr.business.service.base.VRDossierFileLocalServiceBaseImpl;
import com.liferay.portal.kernel.util.OrderByComparator;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the vr dossier file local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fds.vr.business.service.VRDossierFileLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LamTV
 * @see VRDossierFileLocalServiceBaseImpl
 * @see com.fds.vr.business.service.VRDossierFileLocalServiceUtil
 */
@ProviderType
public class VRDossierFileLocalServiceImpl
	extends VRDossierFileLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.fds.vr.business.service.VRDossierFileLocalServiceUtil} to access the vr dossier file local service.
	 */
	public VRDossierFile getByDeliverableCode(String deliverableCode) {
		try {
			return vrDossierFilePersistence.findByDE_CODE(deliverableCode);
		} catch (Exception e) {
			return null;
		}
	}
	
	public VRDossierFile getDossierFileByDID_FTNO_First(long dossierId, String fileTemplateNo, boolean removed,
			OrderByComparator orderByComparator) {
		return vrDossierFilePersistence.fetchByDID_FTNO_First(dossierId, fileTemplateNo, removed, orderByComparator);
	}
	
	public static final String CLASS_NAME = VRDossierFile.class.getName();
}