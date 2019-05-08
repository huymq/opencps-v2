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

import com.fds.vr.business.model.VRProductionPlant;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VRProductionPlant in entity cache.
 *
 * @author LamTV
 * @see VRProductionPlant
 * @generated
 */
@ProviderType
public class VRProductionPlantCacheModel implements CacheModel<VRProductionPlant>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRProductionPlantCacheModel)) {
			return false;
		}

		VRProductionPlantCacheModel vrProductionPlantCacheModel = (VRProductionPlantCacheModel)obj;

		if (id == vrProductionPlantCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(79);

		sb.append("{id=");
		sb.append(id);
		sb.append(", mtCore=");
		sb.append(mtCore);
		sb.append(", mappingMA_CTY=");
		sb.append(mappingMA_CTY);
		sb.append(", mappingTEN_CTY=");
		sb.append(mappingTEN_CTY);
		sb.append(", mappingDIA_CHI_CTY=");
		sb.append(mappingDIA_CHI_CTY);
		sb.append(", mappingMA_XUONG_LR=");
		sb.append(mappingMA_XUONG_LR);
		sb.append(", mappingTEN_XUONG_LR=");
		sb.append(mappingTEN_XUONG_LR);
		sb.append(", mappingDIA_CHI_XUONG_LR=");
		sb.append(mappingDIA_CHI_XUONG_LR);
		sb.append(", mappingNote=");
		sb.append(mappingNote);
		sb.append(", mappingStatus=");
		sb.append(mappingStatus);
		sb.append(", productionPlantCode=");
		sb.append(productionPlantCode);
		sb.append(", productionPlantName=");
		sb.append(productionPlantName);
		sb.append(", productionPlantAddress=");
		sb.append(productionPlantAddress);
		sb.append(", productionPlantStateCode=");
		sb.append(productionPlantStateCode);
		sb.append(", productionPlantStateName=");
		sb.append(productionPlantStateName);
		sb.append(", productionPlantProvinceCode=");
		sb.append(productionPlantProvinceCode);
		sb.append(", productionPlantProvinceName=");
		sb.append(productionPlantProvinceName);
		sb.append(", productionPlantDistrictCode=");
		sb.append(productionPlantDistrictCode);
		sb.append(", productionPlantDistrictName=");
		sb.append(productionPlantDistrictName);
		sb.append(", productionPlantEmail=");
		sb.append(productionPlantEmail);
		sb.append(", productionPlantPhone=");
		sb.append(productionPlantPhone);
		sb.append(", productionPlantFax=");
		sb.append(productionPlantFax);
		sb.append(", productionPlantRepresentative=");
		sb.append(productionPlantRepresentative);
		sb.append(", productionPlantRepresentativeTitle=");
		sb.append(productionPlantRepresentativeTitle);
		sb.append(", productionPlantContactName=");
		sb.append(productionPlantContactName);
		sb.append(", productionPlantContactEmail=");
		sb.append(productionPlantContactEmail);
		sb.append(", productionPlantContactPhone=");
		sb.append(productionPlantContactPhone);
		sb.append(", productionPlantType=");
		sb.append(productionPlantType);
		sb.append(", productionPlantStatus=");
		sb.append(productionPlantStatus);
		sb.append(", productionPlantEmployeesNote=");
		sb.append(productionPlantEmployeesNote);
		sb.append(", productionPlantEquipmentsNote=");
		sb.append(productionPlantEquipmentsNote);
		sb.append(", productionPlantProdEquipmentsNote=");
		sb.append(productionPlantProdEquipmentsNote);
		sb.append(", registrationId=");
		sb.append(registrationId);
		sb.append(", applicantProfileId=");
		sb.append(applicantProfileId);
		sb.append(", latestCOPReportDate=");
		sb.append(latestCOPReportDate);
		sb.append(", latestCOPReportResult=");
		sb.append(latestCOPReportResult);
		sb.append(", nextCOPReportDate=");
		sb.append(nextCOPReportDate);
		sb.append(", modifyDate=");
		sb.append(modifyDate);
		sb.append(", syncDate=");
		sb.append(syncDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VRProductionPlant toEntityModel() {
		VRProductionPlantImpl vrProductionPlantImpl = new VRProductionPlantImpl();

		vrProductionPlantImpl.setId(id);
		vrProductionPlantImpl.setMtCore(mtCore);

		if (mappingMA_CTY == null) {
			vrProductionPlantImpl.setMappingMA_CTY(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setMappingMA_CTY(mappingMA_CTY);
		}

		if (mappingTEN_CTY == null) {
			vrProductionPlantImpl.setMappingTEN_CTY(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setMappingTEN_CTY(mappingTEN_CTY);
		}

		if (mappingDIA_CHI_CTY == null) {
			vrProductionPlantImpl.setMappingDIA_CHI_CTY(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setMappingDIA_CHI_CTY(mappingDIA_CHI_CTY);
		}

		if (mappingMA_XUONG_LR == null) {
			vrProductionPlantImpl.setMappingMA_XUONG_LR(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setMappingMA_XUONG_LR(mappingMA_XUONG_LR);
		}

		if (mappingTEN_XUONG_LR == null) {
			vrProductionPlantImpl.setMappingTEN_XUONG_LR(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setMappingTEN_XUONG_LR(mappingTEN_XUONG_LR);
		}

		if (mappingDIA_CHI_XUONG_LR == null) {
			vrProductionPlantImpl.setMappingDIA_CHI_XUONG_LR(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setMappingDIA_CHI_XUONG_LR(mappingDIA_CHI_XUONG_LR);
		}

		if (mappingNote == null) {
			vrProductionPlantImpl.setMappingNote(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setMappingNote(mappingNote);
		}

		if (mappingStatus == null) {
			vrProductionPlantImpl.setMappingStatus(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setMappingStatus(mappingStatus);
		}

		if (productionPlantCode == null) {
			vrProductionPlantImpl.setProductionPlantCode(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantCode(productionPlantCode);
		}

		if (productionPlantName == null) {
			vrProductionPlantImpl.setProductionPlantName(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantName(productionPlantName);
		}

		if (productionPlantAddress == null) {
			vrProductionPlantImpl.setProductionPlantAddress(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantAddress(productionPlantAddress);
		}

		if (productionPlantStateCode == null) {
			vrProductionPlantImpl.setProductionPlantStateCode(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantStateCode(productionPlantStateCode);
		}

		if (productionPlantStateName == null) {
			vrProductionPlantImpl.setProductionPlantStateName(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantStateName(productionPlantStateName);
		}

		if (productionPlantProvinceCode == null) {
			vrProductionPlantImpl.setProductionPlantProvinceCode(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantProvinceCode(productionPlantProvinceCode);
		}

		if (productionPlantProvinceName == null) {
			vrProductionPlantImpl.setProductionPlantProvinceName(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantProvinceName(productionPlantProvinceName);
		}

		if (productionPlantDistrictCode == null) {
			vrProductionPlantImpl.setProductionPlantDistrictCode(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantDistrictCode(productionPlantDistrictCode);
		}

		if (productionPlantDistrictName == null) {
			vrProductionPlantImpl.setProductionPlantDistrictName(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantDistrictName(productionPlantDistrictName);
		}

		if (productionPlantEmail == null) {
			vrProductionPlantImpl.setProductionPlantEmail(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantEmail(productionPlantEmail);
		}

		if (productionPlantPhone == null) {
			vrProductionPlantImpl.setProductionPlantPhone(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantPhone(productionPlantPhone);
		}

		if (productionPlantFax == null) {
			vrProductionPlantImpl.setProductionPlantFax(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantFax(productionPlantFax);
		}

		if (productionPlantRepresentative == null) {
			vrProductionPlantImpl.setProductionPlantRepresentative(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantRepresentative(productionPlantRepresentative);
		}

		if (productionPlantRepresentativeTitle == null) {
			vrProductionPlantImpl.setProductionPlantRepresentativeTitle(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantRepresentativeTitle(productionPlantRepresentativeTitle);
		}

		if (productionPlantContactName == null) {
			vrProductionPlantImpl.setProductionPlantContactName(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantContactName(productionPlantContactName);
		}

		if (productionPlantContactEmail == null) {
			vrProductionPlantImpl.setProductionPlantContactEmail(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantContactEmail(productionPlantContactEmail);
		}

		if (productionPlantContactPhone == null) {
			vrProductionPlantImpl.setProductionPlantContactPhone(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantContactPhone(productionPlantContactPhone);
		}

		if (productionPlantType == null) {
			vrProductionPlantImpl.setProductionPlantType(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantType(productionPlantType);
		}

		if (productionPlantStatus == null) {
			vrProductionPlantImpl.setProductionPlantStatus(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantStatus(productionPlantStatus);
		}

		if (productionPlantEmployeesNote == null) {
			vrProductionPlantImpl.setProductionPlantEmployeesNote(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantEmployeesNote(productionPlantEmployeesNote);
		}

		if (productionPlantEquipmentsNote == null) {
			vrProductionPlantImpl.setProductionPlantEquipmentsNote(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantEquipmentsNote(productionPlantEquipmentsNote);
		}

		if (productionPlantProdEquipmentsNote == null) {
			vrProductionPlantImpl.setProductionPlantProdEquipmentsNote(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setProductionPlantProdEquipmentsNote(productionPlantProdEquipmentsNote);
		}

		vrProductionPlantImpl.setRegistrationId(registrationId);
		vrProductionPlantImpl.setApplicantProfileId(applicantProfileId);

		if (latestCOPReportDate == Long.MIN_VALUE) {
			vrProductionPlantImpl.setLatestCOPReportDate(null);
		}
		else {
			vrProductionPlantImpl.setLatestCOPReportDate(new Date(
					latestCOPReportDate));
		}

		if (latestCOPReportResult == null) {
			vrProductionPlantImpl.setLatestCOPReportResult(StringPool.BLANK);
		}
		else {
			vrProductionPlantImpl.setLatestCOPReportResult(latestCOPReportResult);
		}

		if (nextCOPReportDate == Long.MIN_VALUE) {
			vrProductionPlantImpl.setNextCOPReportDate(null);
		}
		else {
			vrProductionPlantImpl.setNextCOPReportDate(new Date(
					nextCOPReportDate));
		}

		if (modifyDate == Long.MIN_VALUE) {
			vrProductionPlantImpl.setModifyDate(null);
		}
		else {
			vrProductionPlantImpl.setModifyDate(new Date(modifyDate));
		}

		if (syncDate == Long.MIN_VALUE) {
			vrProductionPlantImpl.setSyncDate(null);
		}
		else {
			vrProductionPlantImpl.setSyncDate(new Date(syncDate));
		}

		vrProductionPlantImpl.resetOriginalValues();

		return vrProductionPlantImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		mtCore = objectInput.readLong();
		mappingMA_CTY = objectInput.readUTF();
		mappingTEN_CTY = objectInput.readUTF();
		mappingDIA_CHI_CTY = objectInput.readUTF();
		mappingMA_XUONG_LR = objectInput.readUTF();
		mappingTEN_XUONG_LR = objectInput.readUTF();
		mappingDIA_CHI_XUONG_LR = objectInput.readUTF();
		mappingNote = objectInput.readUTF();
		mappingStatus = objectInput.readUTF();
		productionPlantCode = objectInput.readUTF();
		productionPlantName = objectInput.readUTF();
		productionPlantAddress = objectInput.readUTF();
		productionPlantStateCode = objectInput.readUTF();
		productionPlantStateName = objectInput.readUTF();
		productionPlantProvinceCode = objectInput.readUTF();
		productionPlantProvinceName = objectInput.readUTF();
		productionPlantDistrictCode = objectInput.readUTF();
		productionPlantDistrictName = objectInput.readUTF();
		productionPlantEmail = objectInput.readUTF();
		productionPlantPhone = objectInput.readUTF();
		productionPlantFax = objectInput.readUTF();
		productionPlantRepresentative = objectInput.readUTF();
		productionPlantRepresentativeTitle = objectInput.readUTF();
		productionPlantContactName = objectInput.readUTF();
		productionPlantContactEmail = objectInput.readUTF();
		productionPlantContactPhone = objectInput.readUTF();
		productionPlantType = objectInput.readUTF();
		productionPlantStatus = objectInput.readUTF();
		productionPlantEmployeesNote = objectInput.readUTF();
		productionPlantEquipmentsNote = objectInput.readUTF();
		productionPlantProdEquipmentsNote = objectInput.readUTF();

		registrationId = objectInput.readLong();

		applicantProfileId = objectInput.readLong();
		latestCOPReportDate = objectInput.readLong();
		latestCOPReportResult = objectInput.readUTF();
		nextCOPReportDate = objectInput.readLong();
		modifyDate = objectInput.readLong();
		syncDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(mtCore);

		if (mappingMA_CTY == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mappingMA_CTY);
		}

		if (mappingTEN_CTY == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mappingTEN_CTY);
		}

		if (mappingDIA_CHI_CTY == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mappingDIA_CHI_CTY);
		}

		if (mappingMA_XUONG_LR == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mappingMA_XUONG_LR);
		}

		if (mappingTEN_XUONG_LR == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mappingTEN_XUONG_LR);
		}

		if (mappingDIA_CHI_XUONG_LR == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mappingDIA_CHI_XUONG_LR);
		}

		if (mappingNote == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mappingNote);
		}

		if (mappingStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mappingStatus);
		}

		if (productionPlantCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantCode);
		}

		if (productionPlantName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantName);
		}

		if (productionPlantAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantAddress);
		}

		if (productionPlantStateCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantStateCode);
		}

		if (productionPlantStateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantStateName);
		}

		if (productionPlantProvinceCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantProvinceCode);
		}

		if (productionPlantProvinceName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantProvinceName);
		}

		if (productionPlantDistrictCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantDistrictCode);
		}

		if (productionPlantDistrictName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantDistrictName);
		}

		if (productionPlantEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantEmail);
		}

		if (productionPlantPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantPhone);
		}

		if (productionPlantFax == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantFax);
		}

		if (productionPlantRepresentative == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantRepresentative);
		}

		if (productionPlantRepresentativeTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantRepresentativeTitle);
		}

		if (productionPlantContactName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantContactName);
		}

		if (productionPlantContactEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantContactEmail);
		}

		if (productionPlantContactPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantContactPhone);
		}

		if (productionPlantType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantType);
		}

		if (productionPlantStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantStatus);
		}

		if (productionPlantEmployeesNote == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantEmployeesNote);
		}

		if (productionPlantEquipmentsNote == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantEquipmentsNote);
		}

		if (productionPlantProdEquipmentsNote == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionPlantProdEquipmentsNote);
		}

		objectOutput.writeLong(registrationId);

		objectOutput.writeLong(applicantProfileId);
		objectOutput.writeLong(latestCOPReportDate);

		if (latestCOPReportResult == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(latestCOPReportResult);
		}

		objectOutput.writeLong(nextCOPReportDate);
		objectOutput.writeLong(modifyDate);
		objectOutput.writeLong(syncDate);
	}

	public long id;
	public long mtCore;
	public String mappingMA_CTY;
	public String mappingTEN_CTY;
	public String mappingDIA_CHI_CTY;
	public String mappingMA_XUONG_LR;
	public String mappingTEN_XUONG_LR;
	public String mappingDIA_CHI_XUONG_LR;
	public String mappingNote;
	public String mappingStatus;
	public String productionPlantCode;
	public String productionPlantName;
	public String productionPlantAddress;
	public String productionPlantStateCode;
	public String productionPlantStateName;
	public String productionPlantProvinceCode;
	public String productionPlantProvinceName;
	public String productionPlantDistrictCode;
	public String productionPlantDistrictName;
	public String productionPlantEmail;
	public String productionPlantPhone;
	public String productionPlantFax;
	public String productionPlantRepresentative;
	public String productionPlantRepresentativeTitle;
	public String productionPlantContactName;
	public String productionPlantContactEmail;
	public String productionPlantContactPhone;
	public String productionPlantType;
	public String productionPlantStatus;
	public String productionPlantEmployeesNote;
	public String productionPlantEquipmentsNote;
	public String productionPlantProdEquipmentsNote;
	public long registrationId;
	public long applicantProfileId;
	public long latestCOPReportDate;
	public String latestCOPReportResult;
	public long nextCOPReportDate;
	public long modifyDate;
	public long syncDate;
}