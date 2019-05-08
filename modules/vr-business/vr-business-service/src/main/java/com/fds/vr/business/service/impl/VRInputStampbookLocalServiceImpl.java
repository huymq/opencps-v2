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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.fds.vr.business.model.VRInputStampbook;
import com.fds.vr.business.service.base.VRInputStampbookLocalServiceBaseImpl;

/**
 * The implementation of the vr input stampbook local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fds.vr.business.service.VRInputStampbookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author khoavd
 * @see VRInputStampbookLocalServiceBaseImpl
 * @see com.fds.vr.business.service.VRInputStampbookLocalServiceUtil
 */
@ProviderType
public class VRInputStampbookLocalServiceImpl
	extends VRInputStampbookLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.fds.vr.business.service.VRInputStampbookLocalServiceUtil} to access the vr input stampbook local service.
	 */
	
	public VRInputStampbook updateInputStambook(long id, long mtCore, long inputSheetId, 
			long bookId, String vehicleClass, String stampType, 
			String stampShortNo, long serialStartNo, String serialEndNo, 
			long subTotalInDocument, long subTotalQuantities, long units, 
			long unitPrice, long totalAmount, long totalInUse, long totalNotUsed, 
			long sum1, long sum2, long sum3, String remark)
		throws PortalException, SystemException {
		
		VRInputStampbook inputStambook = null;
		
		if(id > 0) {
			inputStambook = vrInputStampbookPersistence.findByPrimaryKey(id);
		} else {
			id = counterLocalService.increment(VRInputStampbook.class.getName());
			inputStambook = vrInputStampbookPersistence.create(id);
		}
		
		inputStambook.setModifyDate(new Date());
		inputStambook.setMtCore(mtCore);
		inputStambook.setInputSheetId(inputSheetId);
		inputStambook.setBookId(bookId);
		inputStambook.setVehicleClass(vehicleClass);
		inputStambook.setStampType(stampType);
		inputStambook.setStampShortNo(stampShortNo);
		inputStambook.setSerialStartNo(serialStartNo);
		inputStambook.setSerialEndNo(serialEndNo);
		inputStambook.setSubTotalInDocument(subTotalInDocument);
		inputStambook.setSubTotalQuantities(subTotalQuantities);
		inputStambook.setUnits(units);
		inputStambook.setUnitPrice(unitPrice);
		inputStambook.setTotalAmount(totalAmount);
		inputStambook.setTotalInUse(totalInUse);
		inputStambook.setTotalNotUsed(totalNotUsed);
		inputStambook.setSum1(sum1);
		inputStambook.setSum2(sum2);
		inputStambook.setSum3(sum3);
		inputStambook.setRemark(remark);
		
		return vrInputStampbookPersistence.update(inputStambook);
		
	}
	
	public List<VRInputStampbook> findByInputSheetId(long mtCore, long inputSheetId) throws PortalException, SystemException {
		try {
			return vrInputStampbookPersistence.findByInputSheetId(mtCore, inputSheetId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInputStampbook>();
		
	}


	public List<VRInputStampbook> findByInputSheetIdAndBookId(long mtCore, long inputSheetId, long bookId) throws PortalException, SystemException {
		try {
			return vrInputStampbookPersistence.findByInputSheetIdAndBookId(mtCore, inputSheetId, bookId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInputStampbook>();
		
	}
	
	public List<VRInputStampbook> findByInputSheetIdAndBookIdAndStampType(long mtCore, long inputSheetId, long bookId, String stampType) throws PortalException, SystemException {
		try {
			return vrInputStampbookPersistence.findByInputSheetIdAndBookIdAndStampType(mtCore, inputSheetId, bookId, stampType);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInputStampbook>();
		
	}
	
	
	private Log _log = LogFactoryUtil.getLog(VRInputStampbookLocalServiceImpl.class);
}