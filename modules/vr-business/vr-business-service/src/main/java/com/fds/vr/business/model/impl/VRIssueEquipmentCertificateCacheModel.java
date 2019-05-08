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

import com.fds.vr.business.model.VRIssueEquipmentCertificate;

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
 * The cache model class for representing VRIssueEquipmentCertificate in entity cache.
 *
 * @author LamTV
 * @see VRIssueEquipmentCertificate
 * @generated
 */
@ProviderType
public class VRIssueEquipmentCertificateCacheModel implements CacheModel<VRIssueEquipmentCertificate>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRIssueEquipmentCertificateCacheModel)) {
			return false;
		}

		VRIssueEquipmentCertificateCacheModel vrIssueEquipmentCertificateCacheModel =
			(VRIssueEquipmentCertificateCacheModel)obj;

		if (id == vrIssueEquipmentCertificateCacheModel.id) {
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
		StringBundler sb = new StringBundler(47);

		sb.append("{id=");
		sb.append(id);
		sb.append(", mtcore=");
		sb.append(mtcore);
		sb.append(", issueId=");
		sb.append(issueId);
		sb.append(", issueVehicleCertificateId=");
		sb.append(issueVehicleCertificateId);
		sb.append(", vehiclecertificaterecordno=");
		sb.append(vehiclecertificaterecordno);
		sb.append(", equipmentName=");
		sb.append(equipmentName);
		sb.append(", equipmentType=");
		sb.append(equipmentType);
		sb.append(", equipmentCertificateType=");
		sb.append(equipmentCertificateType);
		sb.append(", equipmentDocumentNo=");
		sb.append(equipmentDocumentNo);
		sb.append(", equipmentCertificateRecordNo=");
		sb.append(equipmentCertificateRecordNo);
		sb.append(", equipmentExamRecordNo=");
		sb.append(equipmentExamRecordNo);
		sb.append(", EquipmentCertificateRecordId=");
		sb.append(EquipmentCertificateRecordId);
		sb.append(", TotalQuantity=");
		sb.append(TotalQuantity);
		sb.append(", TotalProductUsed=");
		sb.append(TotalProductUsed);
		sb.append(", TotalInUse=");
		sb.append(TotalInUse);
		sb.append(", TotalNotUsed=");
		sb.append(TotalNotUsed);
		sb.append(", applicantNo=");
		sb.append(applicantNo);
		sb.append(", applicantname=");
		sb.append(applicantname);
		sb.append(", applicantaddress=");
		sb.append(applicantaddress);
		sb.append(", productionplantname=");
		sb.append(productionplantname);
		sb.append(", productionplantaddress=");
		sb.append(productionplantaddress);
		sb.append(", modifyDate=");
		sb.append(modifyDate);
		sb.append(", syncDate=");
		sb.append(syncDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VRIssueEquipmentCertificate toEntityModel() {
		VRIssueEquipmentCertificateImpl vrIssueEquipmentCertificateImpl = new VRIssueEquipmentCertificateImpl();

		vrIssueEquipmentCertificateImpl.setId(id);
		vrIssueEquipmentCertificateImpl.setMtcore(mtcore);
		vrIssueEquipmentCertificateImpl.setIssueId(issueId);
		vrIssueEquipmentCertificateImpl.setIssueVehicleCertificateId(issueVehicleCertificateId);

		if (vehiclecertificaterecordno == null) {
			vrIssueEquipmentCertificateImpl.setVehiclecertificaterecordno(StringPool.BLANK);
		}
		else {
			vrIssueEquipmentCertificateImpl.setVehiclecertificaterecordno(vehiclecertificaterecordno);
		}

		if (equipmentName == null) {
			vrIssueEquipmentCertificateImpl.setEquipmentName(StringPool.BLANK);
		}
		else {
			vrIssueEquipmentCertificateImpl.setEquipmentName(equipmentName);
		}

		if (equipmentType == null) {
			vrIssueEquipmentCertificateImpl.setEquipmentType(StringPool.BLANK);
		}
		else {
			vrIssueEquipmentCertificateImpl.setEquipmentType(equipmentType);
		}

		if (equipmentCertificateType == null) {
			vrIssueEquipmentCertificateImpl.setEquipmentCertificateType(StringPool.BLANK);
		}
		else {
			vrIssueEquipmentCertificateImpl.setEquipmentCertificateType(equipmentCertificateType);
		}

		if (equipmentDocumentNo == null) {
			vrIssueEquipmentCertificateImpl.setEquipmentDocumentNo(StringPool.BLANK);
		}
		else {
			vrIssueEquipmentCertificateImpl.setEquipmentDocumentNo(equipmentDocumentNo);
		}

		if (equipmentCertificateRecordNo == null) {
			vrIssueEquipmentCertificateImpl.setEquipmentCertificateRecordNo(StringPool.BLANK);
		}
		else {
			vrIssueEquipmentCertificateImpl.setEquipmentCertificateRecordNo(equipmentCertificateRecordNo);
		}

		if (equipmentExamRecordNo == null) {
			vrIssueEquipmentCertificateImpl.setEquipmentExamRecordNo(StringPool.BLANK);
		}
		else {
			vrIssueEquipmentCertificateImpl.setEquipmentExamRecordNo(equipmentExamRecordNo);
		}

		vrIssueEquipmentCertificateImpl.setEquipmentCertificateRecordId(EquipmentCertificateRecordId);
		vrIssueEquipmentCertificateImpl.setTotalQuantity(TotalQuantity);
		vrIssueEquipmentCertificateImpl.setTotalProductUsed(TotalProductUsed);
		vrIssueEquipmentCertificateImpl.setTotalInUse(TotalInUse);
		vrIssueEquipmentCertificateImpl.setTotalNotUsed(TotalNotUsed);

		if (applicantNo == null) {
			vrIssueEquipmentCertificateImpl.setApplicantNo(StringPool.BLANK);
		}
		else {
			vrIssueEquipmentCertificateImpl.setApplicantNo(applicantNo);
		}

		if (applicantname == null) {
			vrIssueEquipmentCertificateImpl.setApplicantname(StringPool.BLANK);
		}
		else {
			vrIssueEquipmentCertificateImpl.setApplicantname(applicantname);
		}

		if (applicantaddress == null) {
			vrIssueEquipmentCertificateImpl.setApplicantaddress(StringPool.BLANK);
		}
		else {
			vrIssueEquipmentCertificateImpl.setApplicantaddress(applicantaddress);
		}

		if (productionplantname == null) {
			vrIssueEquipmentCertificateImpl.setProductionplantname(StringPool.BLANK);
		}
		else {
			vrIssueEquipmentCertificateImpl.setProductionplantname(productionplantname);
		}

		if (productionplantaddress == null) {
			vrIssueEquipmentCertificateImpl.setProductionplantaddress(StringPool.BLANK);
		}
		else {
			vrIssueEquipmentCertificateImpl.setProductionplantaddress(productionplantaddress);
		}

		if (modifyDate == Long.MIN_VALUE) {
			vrIssueEquipmentCertificateImpl.setModifyDate(null);
		}
		else {
			vrIssueEquipmentCertificateImpl.setModifyDate(new Date(modifyDate));
		}

		if (syncDate == Long.MIN_VALUE) {
			vrIssueEquipmentCertificateImpl.setSyncDate(null);
		}
		else {
			vrIssueEquipmentCertificateImpl.setSyncDate(new Date(syncDate));
		}

		vrIssueEquipmentCertificateImpl.resetOriginalValues();

		return vrIssueEquipmentCertificateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		mtcore = objectInput.readInt();

		issueId = objectInput.readInt();

		issueVehicleCertificateId = objectInput.readInt();
		vehiclecertificaterecordno = objectInput.readUTF();
		equipmentName = objectInput.readUTF();
		equipmentType = objectInput.readUTF();
		equipmentCertificateType = objectInput.readUTF();
		equipmentDocumentNo = objectInput.readUTF();
		equipmentCertificateRecordNo = objectInput.readUTF();
		equipmentExamRecordNo = objectInput.readUTF();

		EquipmentCertificateRecordId = objectInput.readInt();

		TotalQuantity = objectInput.readInt();

		TotalProductUsed = objectInput.readInt();

		TotalInUse = objectInput.readInt();

		TotalNotUsed = objectInput.readInt();
		applicantNo = objectInput.readUTF();
		applicantname = objectInput.readUTF();
		applicantaddress = objectInput.readUTF();
		productionplantname = objectInput.readUTF();
		productionplantaddress = objectInput.readUTF();
		modifyDate = objectInput.readLong();
		syncDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeInt(mtcore);

		objectOutput.writeInt(issueId);

		objectOutput.writeInt(issueVehicleCertificateId);

		if (vehiclecertificaterecordno == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vehiclecertificaterecordno);
		}

		if (equipmentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentName);
		}

		if (equipmentType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentType);
		}

		if (equipmentCertificateType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentCertificateType);
		}

		if (equipmentDocumentNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentDocumentNo);
		}

		if (equipmentCertificateRecordNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentCertificateRecordNo);
		}

		if (equipmentExamRecordNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentExamRecordNo);
		}

		objectOutput.writeInt(EquipmentCertificateRecordId);

		objectOutput.writeInt(TotalQuantity);

		objectOutput.writeInt(TotalProductUsed);

		objectOutput.writeInt(TotalInUse);

		objectOutput.writeInt(TotalNotUsed);

		if (applicantNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantNo);
		}

		if (applicantname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantname);
		}

		if (applicantaddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantaddress);
		}

		if (productionplantname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionplantname);
		}

		if (productionplantaddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionplantaddress);
		}

		objectOutput.writeLong(modifyDate);
		objectOutput.writeLong(syncDate);
	}

	public long id;
	public int mtcore;
	public int issueId;
	public int issueVehicleCertificateId;
	public String vehiclecertificaterecordno;
	public String equipmentName;
	public String equipmentType;
	public String equipmentCertificateType;
	public String equipmentDocumentNo;
	public String equipmentCertificateRecordNo;
	public String equipmentExamRecordNo;
	public int EquipmentCertificateRecordId;
	public int TotalQuantity;
	public int TotalProductUsed;
	public int TotalInUse;
	public int TotalNotUsed;
	public String applicantNo;
	public String applicantname;
	public String applicantaddress;
	public String productionplantname;
	public String productionplantaddress;
	public long modifyDate;
	public long syncDate;
}