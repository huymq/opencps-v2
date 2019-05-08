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
import com.fds.vr.business.model.VROutputSheetDetails;
import com.fds.vr.business.service.base.VROutputSheetDetailsLocalServiceBaseImpl;

/**
 * The implementation of the vr output sheet details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fds.vr.business.service.VROutputSheetDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author khoavd
 * @see VROutputSheetDetailsLocalServiceBaseImpl
 * @see com.fds.vr.business.service.VROutputSheetDetailsLocalServiceUtil
 */
@ProviderType
public class VROutputSheetDetailsLocalServiceImpl
	extends VROutputSheetDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.fds.vr.business.service.VROutputSheetDetailsLocalServiceUtil} to access the vr output sheet details local service.
	 */
	
	public VROutputSheetDetails updateOutputSheetDetails(long id, long mtCore, long inputSheetId, 
			long outputSheetId, long bookId, long issueVehicleCertificateId, long certificateId,
			String certificateNumber, Date certificateDate, String vehicleClass, String stampType,
			String stampShortNo, String serialStartNo, String serialEndNo, long subTotalInDocument,
			long subTotalQuantities, long unitPrice, long totalAmount, long totalInUse, long totalNotUsed,
			long totalLost, long totalCancelled, long totalReturned, String remark)
		throws PortalException, SystemException {
		
		VROutputSheetDetails outputSheetDetails = null;
		
		if(id > 0) {
			outputSheetDetails = vrOutputSheetDetailsPersistence.findByPrimaryKey(id);
		} else {
			id = counterLocalService.increment(VROutputSheetDetails.class.getName());
			outputSheetDetails = vrOutputSheetDetailsPersistence.create(id);
		}
		
		outputSheetDetails.setModifyDate(new Date());
		outputSheetDetails.setMtCore(mtCore);
		outputSheetDetails.setInputSheetId(inputSheetId);
		outputSheetDetails.setOutputSheetId(outputSheetId);
		outputSheetDetails.setBookId(bookId);
		outputSheetDetails.setIssueVehicleCertificateId(issueVehicleCertificateId);
		outputSheetDetails.setCertificateId(certificateId);
		outputSheetDetails.setCertificateNumber(certificateNumber);
		outputSheetDetails.setCertificateDate(certificateDate);
		outputSheetDetails.setVehicleClass(vehicleClass);
		outputSheetDetails.setStampType(stampType);
		outputSheetDetails.setStampShortNo(stampShortNo);
		outputSheetDetails.setSerialStartNo(serialStartNo);
		outputSheetDetails.setSerialEndNo(serialEndNo);
		outputSheetDetails.setSubTotalInDocument(subTotalInDocument);
		outputSheetDetails.setSubTotalQuantities(subTotalQuantities);
		outputSheetDetails.setUnitPrice(unitPrice);
		outputSheetDetails.setTotalAmount(totalAmount);
		outputSheetDetails.setTotalInUse(totalInUse);
		outputSheetDetails.setTotalNotUsed(totalNotUsed);
		outputSheetDetails.setTotalLost(totalLost);
		outputSheetDetails.setTotalCancelled(totalCancelled);
		outputSheetDetails.setTotalReturned(totalReturned);
		outputSheetDetails.setRemark(remark);
		
		return vrOutputSheetDetailsPersistence.update(outputSheetDetails);
	}
	
	public List<VROutputSheetDetails> findByInputSheetId(long mtCore, long inputSheetId) throws PortalException, SystemException {
		try {
			return vrOutputSheetDetailsPersistence.findByInputSheetId(mtCore, inputSheetId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VROutputSheetDetails>();
		
	}


	public List<VROutputSheetDetails> findByInputSheetIdAndBookId(long mtCore, long inputSheetId, long bookId) throws PortalException, SystemException {
		try {
			return vrOutputSheetDetailsPersistence.findByInputSheetIdAndBookId(mtCore, inputSheetId, bookId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VROutputSheetDetails>();
		
	}
	
	public List<VROutputSheetDetails> findByOutputSheetId(long mtCore, long outputSheetId) throws PortalException, SystemException {
		try {
			return vrOutputSheetDetailsPersistence.findByOutputSheetId(mtCore, outputSheetId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VROutputSheetDetails>();
		
	}
	
	public List<VROutputSheetDetails> findByOutputSheetIdAndBookId(long mtCore, long outputSheetId, long bookId) throws PortalException, SystemException {
		try {
			return vrOutputSheetDetailsPersistence.findByOutputSheetIdAndBookId(mtCore, outputSheetId, bookId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VROutputSheetDetails>();
		
	}
	
	public List<VROutputSheetDetails> findByInputSheetIdAndBookIdAndStampType(long mtCore, long inputSheetId, long bookId, String stampType) throws PortalException, SystemException {
		try {
			return vrOutputSheetDetailsPersistence.findByInputSheetIdAndBookIdAndStampType(mtCore, inputSheetId, bookId, stampType);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VROutputSheetDetails>();
		
	}
	
	public List<VROutputSheetDetails> findByOutputSheetIdAndBookIdAndStampType(long mtCore, long outputSheetId, long bookId, String stampType) throws PortalException, SystemException {
		try {
			return vrOutputSheetDetailsPersistence.findByOutputSheetIdAndBookIdAndStampType(mtCore, outputSheetId, bookId, stampType);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VROutputSheetDetails>();
		
	}
	
	public List<VROutputSheetDetails> findBycertificateId(long mtCore, long certificateId) throws PortalException, SystemException {
		try {
			return vrOutputSheetDetailsPersistence.findBycertificateId(mtCore, certificateId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VROutputSheetDetails>();
		
	}


	public List<VROutputSheetDetails> findBycertificateNumber(long mtCore, String certificateNumber) throws PortalException, SystemException {
		try {
			return vrOutputSheetDetailsPersistence.findBycertificateNumber(mtCore, certificateNumber);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VROutputSheetDetails>();
		
	}
	
	public List<VROutputSheetDetails> findByissueVehicleCertificateId(long mtCore, long issueVehicleCertificateId) throws PortalException, SystemException {
		try {
			return vrOutputSheetDetailsPersistence.findByissueVehicleCertificateId(mtCore, issueVehicleCertificateId);
		} catch (Exception e) {
			_log.error(e);
		}
		return new ArrayList<VROutputSheetDetails>();
		
	}
	
	private Log _log = LogFactoryUtil.getLog(VROutputSheetDetailsLocalServiceBaseImpl.class);
}