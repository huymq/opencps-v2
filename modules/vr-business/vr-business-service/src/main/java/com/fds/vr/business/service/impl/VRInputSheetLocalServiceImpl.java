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
import com.fds.vr.business.model.VRInputSheet;
import com.fds.vr.business.service.base.VRInputSheetLocalServiceBaseImpl;

/**
 * The implementation of the vr input sheet local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fds.vr.business.service.VRInputSheetLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author khoavd
 * @see VRInputSheetLocalServiceBaseImpl
 * @see com.fds.vr.business.service.VRInputSheetLocalServiceUtil
 */
@ProviderType
public class VRInputSheetLocalServiceImpl
	extends VRInputSheetLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.fds.vr.business.service.VRInputSheetLocalServiceUtil} to access the vr input sheet local service.
	 */
	
	public VRInputSheet updateInputSheet(long id, long mtCore, String inputSheetNo, 
			Date inputSheetDate, String originalDocumentNo, String corporationId, 
			long inputSheetType, String maker, String checker, 
			String approver, String deliveryName, String inventoryName, 
			String inventoryPlace, Date inventoryDate, String bookIDList, long isApproval, 
			long totalQuantities, long totalAmount, String amountInWords, String remark)
		throws PortalException, SystemException {
		
		VRInputSheet inputSheet = null;
		
		if(id > 0) {
			inputSheet = vrInputSheetPersistence.findByPrimaryKey(id);
		} else {
			id = counterLocalService.increment(VRInputSheet.class.getName());
			inputSheet = vrInputSheetPersistence.create(id);
		}
		
		inputSheet.setModifyDate(new Date());
		inputSheet.setMtCore(mtCore);
		inputSheet.setInputSheetNo(inputSheetNo);
		inputSheet.setInputSheetDate(inputSheetDate);
		inputSheet.setOriginalDocumentNo(originalDocumentNo);
		inputSheet.setCorporationId(corporationId);
		inputSheet.setInputSheetType(inputSheetType);
		inputSheet.setMaker(maker);
		inputSheet.setChecker(checker);
		inputSheet.setApprover(approver);
		inputSheet.setDeliveryName(deliveryName);
		inputSheet.setInventoryName(inventoryName);
		inputSheet.setInventoryPlace(inventoryPlace);
		inputSheet.setInventoryDate(inventoryDate);
		inputSheet.setBookIDList(bookIDList);
		inputSheet.setIsApproval(isApproval);
		inputSheet.setTotalQuantities(totalQuantities);
		inputSheet.setTotalAmount(totalAmount);
		inputSheet.setAmountInWords(amountInWords);
		inputSheet.setRemark(remark);
		
		return vrInputSheetPersistence.update(inputSheet);
	}
	
	public List<VRInputSheet> findByinputSheetNo(long mtCore, String inputSheetNo) throws PortalException, SystemException {
		try {
			return vrInputSheetPersistence.findByinputSheetNo(mtCore, inputSheetNo);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInputSheet>();
		
	}


	public List<VRInputSheet> findBycorporationId(long mtCore, String corporationId) throws PortalException, SystemException {
		try {
			return vrInputSheetPersistence.findBycorporationId(mtCore, corporationId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInputSheet>();
		
	}
	
	public List<VRInputSheet> findByinputSheetType(long mtCore, long inputSheetType) throws PortalException, SystemException {
		try {
			return vrInputSheetPersistence.findByinputSheetType(mtCore, inputSheetType);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VRInputSheet>();
		
	}
	
	private Log _log = LogFactoryUtil.getLog(VRInputSheetLocalServiceImpl.class);
}