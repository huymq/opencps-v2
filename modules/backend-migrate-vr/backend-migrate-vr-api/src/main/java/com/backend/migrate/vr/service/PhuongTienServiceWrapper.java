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

package com.backend.migrate.vr.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PhuongTienService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhuongTienService
 * @generated
 */
@ProviderType
public class PhuongTienServiceWrapper implements PhuongTienService,
	ServiceWrapper<PhuongTienService> {
	public PhuongTienServiceWrapper(PhuongTienService phuongTienService) {
		_phuongTienService = phuongTienService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _phuongTienService.getOSGiServiceIdentifier();
	}

	@Override
	public PhuongTienService getWrappedService() {
		return _phuongTienService;
	}

	@Override
	public void setWrappedService(PhuongTienService phuongTienService) {
		_phuongTienService = phuongTienService;
	}

	private PhuongTienService _phuongTienService;
}