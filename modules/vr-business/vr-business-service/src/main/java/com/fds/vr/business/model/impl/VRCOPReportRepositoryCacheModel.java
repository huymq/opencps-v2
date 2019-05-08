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

import com.fds.vr.business.model.VRCOPReportRepository;

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
 * The cache model class for representing VRCOPReportRepository in entity cache.
 *
 * @author LamTV
 * @see VRCOPReportRepository
 * @generated
 */
@ProviderType
public class VRCOPReportRepositoryCacheModel implements CacheModel<VRCOPReportRepository>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRCOPReportRepositoryCacheModel)) {
			return false;
		}

		VRCOPReportRepositoryCacheModel vrcopReportRepositoryCacheModel = (VRCOPReportRepositoryCacheModel)obj;

		if (id == vrcopReportRepositoryCacheModel.id) {
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
		StringBundler sb = new StringBundler(49);

		sb.append("{id=");
		sb.append(id);
		sb.append(", mtCore=");
		sb.append(mtCore);
		sb.append(", applicantProfileId=");
		sb.append(applicantProfileId);
		sb.append(", applicantName=");
		sb.append(applicantName);
		sb.append(", applicantAddress=");
		sb.append(applicantAddress);
		sb.append(", overseasManufacturerId=");
		sb.append(overseasManufacturerId);
		sb.append(", overseasManufacturerName=");
		sb.append(overseasManufacturerName);
		sb.append(", overseasManufacturerAddress=");
		sb.append(overseasManufacturerAddress);
		sb.append(", productionPlantId=");
		sb.append(productionPlantId);
		sb.append(", productionPlantCode=");
		sb.append(productionPlantCode);
		sb.append(", productionPlantName=");
		sb.append(productionPlantName);
		sb.append(", productionPlantAddress=");
		sb.append(productionPlantAddress);
		sb.append(", copReportNo=");
		sb.append(copReportNo);
		sb.append(", copReportStatus=");
		sb.append(copReportStatus);
		sb.append(", copReportType=");
		sb.append(copReportType);
		sb.append(", copReportMetadata=");
		sb.append(copReportMetadata);
		sb.append(", copReportSignName=");
		sb.append(copReportSignName);
		sb.append(", copReportSignTitle=");
		sb.append(copReportSignTitle);
		sb.append(", copReportSignPlace=");
		sb.append(copReportSignPlace);
		sb.append(", copReportDate=");
		sb.append(copReportDate);
		sb.append(", copReportApprovedDate=");
		sb.append(copReportApprovedDate);
		sb.append(", copReportExpiredDate=");
		sb.append(copReportExpiredDate);
		sb.append(", modifyDate=");
		sb.append(modifyDate);
		sb.append(", syncDate=");
		sb.append(syncDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VRCOPReportRepository toEntityModel() {
		VRCOPReportRepositoryImpl vrcopReportRepositoryImpl = new VRCOPReportRepositoryImpl();

		vrcopReportRepositoryImpl.setId(id);
		vrcopReportRepositoryImpl.setMtCore(mtCore);
		vrcopReportRepositoryImpl.setApplicantProfileId(applicantProfileId);

		if (applicantName == null) {
			vrcopReportRepositoryImpl.setApplicantName(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setApplicantName(applicantName);
		}

		if (applicantAddress == null) {
			vrcopReportRepositoryImpl.setApplicantAddress(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setApplicantAddress(applicantAddress);
		}

		vrcopReportRepositoryImpl.setOverseasManufacturerId(overseasManufacturerId);

		if (overseasManufacturerName == null) {
			vrcopReportRepositoryImpl.setOverseasManufacturerName(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setOverseasManufacturerName(overseasManufacturerName);
		}

		if (overseasManufacturerAddress == null) {
			vrcopReportRepositoryImpl.setOverseasManufacturerAddress(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setOverseasManufacturerAddress(overseasManufacturerAddress);
		}

		vrcopReportRepositoryImpl.setProductionPlantId(productionPlantId);

		if (productionPlantCode == null) {
			vrcopReportRepositoryImpl.setProductionPlantCode(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setProductionPlantCode(productionPlantCode);
		}

		if (productionPlantName == null) {
			vrcopReportRepositoryImpl.setProductionPlantName(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setProductionPlantName(productionPlantName);
		}

		if (productionPlantAddress == null) {
			vrcopReportRepositoryImpl.setProductionPlantAddress(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setProductionPlantAddress(productionPlantAddress);
		}

		if (copReportNo == null) {
			vrcopReportRepositoryImpl.setCopReportNo(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setCopReportNo(copReportNo);
		}

		if (copReportStatus == null) {
			vrcopReportRepositoryImpl.setCopReportStatus(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setCopReportStatus(copReportStatus);
		}

		if (copReportType == null) {
			vrcopReportRepositoryImpl.setCopReportType(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setCopReportType(copReportType);
		}

		if (copReportMetadata == null) {
			vrcopReportRepositoryImpl.setCopReportMetadata(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setCopReportMetadata(copReportMetadata);
		}

		if (copReportSignName == null) {
			vrcopReportRepositoryImpl.setCopReportSignName(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setCopReportSignName(copReportSignName);
		}

		if (copReportSignTitle == null) {
			vrcopReportRepositoryImpl.setCopReportSignTitle(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setCopReportSignTitle(copReportSignTitle);
		}

		if (copReportSignPlace == null) {
			vrcopReportRepositoryImpl.setCopReportSignPlace(StringPool.BLANK);
		}
		else {
			vrcopReportRepositoryImpl.setCopReportSignPlace(copReportSignPlace);
		}

		if (copReportDate == Long.MIN_VALUE) {
			vrcopReportRepositoryImpl.setCopReportDate(null);
		}
		else {
			vrcopReportRepositoryImpl.setCopReportDate(new Date(copReportDate));
		}

		if (copReportApprovedDate == Long.MIN_VALUE) {
			vrcopReportRepositoryImpl.setCopReportApprovedDate(null);
		}
		else {
			vrcopReportRepositoryImpl.setCopReportApprovedDate(new Date(
					copReportApprovedDate));
		}

		if (copReportExpiredDate == Long.MIN_VALUE) {
			vrcopReportRepositoryImpl.setCopReportExpiredDate(null);
		}
		else {
			vrcopReportRepositoryImpl.setCopReportExpiredDate(new Date(
					copReportExpiredDate));
		}

		if (modifyDate == Long.MIN_VALUE) {
			vrcopReportRepositoryImpl.setModifyDate(null);
		}
		else {
			vrcopReportRepositoryImpl.setModifyDate(new Date(modifyDate));
		}

		if (syncDate == Long.MIN_VALUE) {
			vrcopReportRepositoryImpl.setSyncDate(null);
		}
		else {
			vrcopReportRepositoryImpl.setSyncDate(new Date(syncDate));
		}

		vrcopReportRepositoryImpl.resetOriginalValues();

		return vrcopReportRepositoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		mtCore = objectInput.readLong();

		applicantProfileId = objectInput.readLong();
		applicantName = objectInput.readUTF();
		applicantAddress = objectInput.readUTF();

		overseasManufacturerId = objectInput.readLong();
		overseasManufacturerName = objectInput.readUTF();
		overseasManufacturerAddress = objectInput.readUTF();

		productionPlantId = objectInput.readLong();
		productionPlantCode = objectInput.readUTF();
		productionPlantName = objectInput.readUTF();
		productionPlantAddress = objectInput.readUTF();
		copReportNo = objectInput.readUTF();
		copReportStatus = objectInput.readUTF();
		copReportType = objectInput.readUTF();
		copReportMetadata = objectInput.readUTF();
		copReportSignName = objectInput.readUTF();
		copReportSignTitle = objectInput.readUTF();
		copReportSignPlace = objectInput.readUTF();
		copReportDate = objectInput.readLong();
		copReportApprovedDate = objectInput.readLong();
		copReportExpiredDate = objectInput.readLong();
		modifyDate = objectInput.readLong();
		syncDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(mtCore);

		objectOutput.writeLong(applicantProfileId);

		if (applicantName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantName);
		}

		if (applicantAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantAddress);
		}

		objectOutput.writeLong(overseasManufacturerId);

		if (overseasManufacturerName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(overseasManufacturerName);
		}

		if (overseasManufacturerAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(overseasManufacturerAddress);
		}

		objectOutput.writeLong(productionPlantId);

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

		if (copReportNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(copReportNo);
		}

		if (copReportStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(copReportStatus);
		}

		if (copReportType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(copReportType);
		}

		if (copReportMetadata == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(copReportMetadata);
		}

		if (copReportSignName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(copReportSignName);
		}

		if (copReportSignTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(copReportSignTitle);
		}

		if (copReportSignPlace == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(copReportSignPlace);
		}

		objectOutput.writeLong(copReportDate);
		objectOutput.writeLong(copReportApprovedDate);
		objectOutput.writeLong(copReportExpiredDate);
		objectOutput.writeLong(modifyDate);
		objectOutput.writeLong(syncDate);
	}

	public long id;
	public long mtCore;
	public long applicantProfileId;
	public String applicantName;
	public String applicantAddress;
	public long overseasManufacturerId;
	public String overseasManufacturerName;
	public String overseasManufacturerAddress;
	public long productionPlantId;
	public String productionPlantCode;
	public String productionPlantName;
	public String productionPlantAddress;
	public String copReportNo;
	public String copReportStatus;
	public String copReportType;
	public String copReportMetadata;
	public String copReportSignName;
	public String copReportSignTitle;
	public String copReportSignPlace;
	public long copReportDate;
	public long copReportApprovedDate;
	public long copReportExpiredDate;
	public long modifyDate;
	public long syncDate;
}