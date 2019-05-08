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

package com.fds.vr.business.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.fds.vr.business.model.VRTechnicalSpec_XDD;
import com.fds.vr.business.service.VRTechnicalSpec_XDDLocalServiceUtil;

/**
 * The extended model base implementation for the VRTechnicalSpec_XDD service. Represents a row in the &quot;vr_technicalspec_xdd&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VRTechnicalSpec_XDDImpl}.
 * </p>
 *
 * @author LamTV
 * @see VRTechnicalSpec_XDDImpl
 * @see VRTechnicalSpec_XDD
 * @generated
 */
@ProviderType
public abstract class VRTechnicalSpec_XDDBaseImpl
	extends VRTechnicalSpec_XDDModelImpl implements VRTechnicalSpec_XDD {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vr technical spec_xdd model instance should use the {@link VRTechnicalSpec_XDD} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			VRTechnicalSpec_XDDLocalServiceUtil.addVRTechnicalSpec_XDD(this);
		}
		else {
			VRTechnicalSpec_XDDLocalServiceUtil.updateVRTechnicalSpec_XDD(this);
		}
	}
}