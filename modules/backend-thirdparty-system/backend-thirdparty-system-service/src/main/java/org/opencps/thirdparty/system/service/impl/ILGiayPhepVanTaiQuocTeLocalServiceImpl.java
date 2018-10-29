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

package org.opencps.thirdparty.system.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.List;

import org.opencps.thirdparty.system.model.ILGiayPhepVanTai;
import org.opencps.thirdparty.system.model.ILGiayPhepVanTaiQuocTe;
import org.opencps.thirdparty.system.service.base.ILGiayPhepVanTaiQuocTeLocalServiceBaseImpl;

/**
 * The implementation of the il giay phep van tai quoc te local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.opencps.thirdparty.system.service.ILGiayPhepVanTaiQuocTeLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author trungdk
 * @see ILGiayPhepVanTaiQuocTeLocalServiceBaseImpl
 * @see org.opencps.thirdparty.system.service.ILGiayPhepVanTaiQuocTeLocalServiceUtil
 */
@ProviderType
public class ILGiayPhepVanTaiQuocTeLocalServiceImpl extends ILGiayPhepVanTaiQuocTeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * org.opencps.thirdparty.system.service.
	 * ILGiayPhepVanTaiQuocTeLocalServiceUtil} to access the il giay phep van
	 * tai quoc te local service.
	 */
	
	
	public ILGiayPhepVanTaiQuocTe getLastest() {
		List<ILGiayPhepVanTaiQuocTe> ls = ilGiayPhepVanTaiQuocTePersistence.findAll(0, 1);
		
		if (ls.isEmpty()) {
			return null;
		} else {
			return ls.get(0);
		}
	}
	public List<ILGiayPhepVanTaiQuocTe> getGiayPhep(int start, int end) {
		return ilGiayPhepVanTaiQuocTePersistence.findAll(start, end);
	}

	public List<ILGiayPhepVanTaiQuocTe> searchGiayPhep(String keyword, int start, int end) {

		// TODO update here

		return ilGiayPhepVanTaiQuocTePersistence.findAll(start, end);
	}

	public long countGayPhep(String keyword) {

		// TODO update here

		return ilGiayPhepVanTaiQuocTePersistence.countAll();
	}
}