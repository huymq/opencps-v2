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

import com.fds.vr.business.model.VRIssue;

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
 * The cache model class for representing VRIssue in entity cache.
 *
 * @author LamTV
 * @see VRIssue
 * @generated
 */
@ProviderType
public class VRIssueCacheModel implements CacheModel<VRIssue>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRIssueCacheModel)) {
			return false;
		}

		VRIssueCacheModel vrIssueCacheModel = (VRIssueCacheModel)obj;

		if (id == vrIssueCacheModel.id) {
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
		StringBundler sb = new StringBundler(113);

		sb.append("{id=");
		sb.append(id);
		sb.append(", mtCore=");
		sb.append(mtCore);
		sb.append(", dossierId=");
		sb.append(dossierId);
		sb.append(", stampIssueNo=");
		sb.append(stampIssueNo);
		sb.append(", appliedDate=");
		sb.append(appliedDate);
		sb.append(", approvedDate=");
		sb.append(approvedDate);
		sb.append(", vehicleClass=");
		sb.append(vehicleClass);
		sb.append(", applicantProfileId=");
		sb.append(applicantProfileId);
		sb.append(", applicantName=");
		sb.append(applicantName);
		sb.append(", applicantAddress=");
		sb.append(applicantAddress);
		sb.append(", applicantRepresentative=");
		sb.append(applicantRepresentative);
		sb.append(", applicantRepresentativeTitle=");
		sb.append(applicantRepresentativeTitle);
		sb.append(", applicantEmail=");
		sb.append(applicantEmail);
		sb.append(", applicantPhone=");
		sb.append(applicantPhone);
		sb.append(", applicantFax=");
		sb.append(applicantFax);
		sb.append(", applicantContactName=");
		sb.append(applicantContactName);
		sb.append(", applicantContactEmail=");
		sb.append(applicantContactEmail);
		sb.append(", applicantContactPhone=");
		sb.append(applicantContactPhone);
		sb.append(", productionPlantId=");
		sb.append(productionPlantId);
		sb.append(", productionPlantCode=");
		sb.append(productionPlantCode);
		sb.append(", productionPlantName=");
		sb.append(productionPlantName);
		sb.append(", productionPlantAddress=");
		sb.append(productionPlantAddress);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", methodOfIssue=");
		sb.append(methodOfIssue);
		sb.append(", totalInDocument=");
		sb.append(totalInDocument);
		sb.append(", issueCorporationId=");
		sb.append(issueCorporationId);
		sb.append(", verifyCorporationId=");
		sb.append(verifyCorporationId);
		sb.append(", digitalissuestatus=");
		sb.append(digitalissuestatus);
		sb.append(", issueType=");
		sb.append(issueType);
		sb.append(", averageSTBQuantity=");
		sb.append(averageSTBQuantity);
		sb.append(", maxMonthQuantity=");
		sb.append(maxMonthQuantity);
		sb.append(", averageSTMQuantity=");
		sb.append(averageSTMQuantity);
		sb.append(", accumulatedMonthQuantity=");
		sb.append(accumulatedMonthQuantity);
		sb.append(", totalInUse=");
		sb.append(totalInUse);
		sb.append(", totalCancelled=");
		sb.append(totalCancelled);
		sb.append(", totalLost=");
		sb.append(totalLost);
		sb.append(", totalNotUsed=");
		sb.append(totalNotUsed);
		sb.append(", totalReturned=");
		sb.append(totalReturned);
		sb.append(", flow=");
		sb.append(flow);
		sb.append(", examinationRequired=");
		sb.append(examinationRequired);
		sb.append(", examinationPeriod=");
		sb.append(examinationPeriod);
		sb.append(", examinationLastTime=");
		sb.append(examinationLastTime);
		sb.append(", copresult=");
		sb.append(copresult);
		sb.append(", copreportno=");
		sb.append(copreportno);
		sb.append(", copreportdate=");
		sb.append(copreportdate);
		sb.append(", postreview=");
		sb.append(postreview);
		sb.append(", postreviewrecordno=");
		sb.append(postreviewrecordno);
		sb.append(", postreviewrecorddate=");
		sb.append(postreviewrecorddate);
		sb.append(", corporationId=");
		sb.append(corporationId);
		sb.append(", inspectorcode=");
		sb.append(inspectorcode);
		sb.append(", inspectorname=");
		sb.append(inspectorname);
		sb.append(", leadername=");
		sb.append(leadername);
		sb.append(", applicantmaker=");
		sb.append(applicantmaker);
		sb.append(", applicantchecker=");
		sb.append(applicantchecker);
		sb.append(", modifyDate=");
		sb.append(modifyDate);
		sb.append(", syncDate=");
		sb.append(syncDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VRIssue toEntityModel() {
		VRIssueImpl vrIssueImpl = new VRIssueImpl();

		vrIssueImpl.setId(id);
		vrIssueImpl.setMtCore(mtCore);
		vrIssueImpl.setDossierId(dossierId);

		if (stampIssueNo == null) {
			vrIssueImpl.setStampIssueNo(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setStampIssueNo(stampIssueNo);
		}

		if (appliedDate == Long.MIN_VALUE) {
			vrIssueImpl.setAppliedDate(null);
		}
		else {
			vrIssueImpl.setAppliedDate(new Date(appliedDate));
		}

		if (approvedDate == Long.MIN_VALUE) {
			vrIssueImpl.setApprovedDate(null);
		}
		else {
			vrIssueImpl.setApprovedDate(new Date(approvedDate));
		}

		if (vehicleClass == null) {
			vrIssueImpl.setVehicleClass(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setVehicleClass(vehicleClass);
		}

		vrIssueImpl.setApplicantProfileId(applicantProfileId);

		if (applicantName == null) {
			vrIssueImpl.setApplicantName(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setApplicantName(applicantName);
		}

		if (applicantAddress == null) {
			vrIssueImpl.setApplicantAddress(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setApplicantAddress(applicantAddress);
		}

		if (applicantRepresentative == null) {
			vrIssueImpl.setApplicantRepresentative(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setApplicantRepresentative(applicantRepresentative);
		}

		if (applicantRepresentativeTitle == null) {
			vrIssueImpl.setApplicantRepresentativeTitle(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setApplicantRepresentativeTitle(applicantRepresentativeTitle);
		}

		if (applicantEmail == null) {
			vrIssueImpl.setApplicantEmail(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setApplicantEmail(applicantEmail);
		}

		if (applicantPhone == null) {
			vrIssueImpl.setApplicantPhone(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setApplicantPhone(applicantPhone);
		}

		if (applicantFax == null) {
			vrIssueImpl.setApplicantFax(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setApplicantFax(applicantFax);
		}

		if (applicantContactName == null) {
			vrIssueImpl.setApplicantContactName(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setApplicantContactName(applicantContactName);
		}

		if (applicantContactEmail == null) {
			vrIssueImpl.setApplicantContactEmail(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setApplicantContactEmail(applicantContactEmail);
		}

		if (applicantContactPhone == null) {
			vrIssueImpl.setApplicantContactPhone(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setApplicantContactPhone(applicantContactPhone);
		}

		vrIssueImpl.setProductionPlantId(productionPlantId);

		if (productionPlantCode == null) {
			vrIssueImpl.setProductionPlantCode(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setProductionPlantCode(productionPlantCode);
		}

		if (productionPlantName == null) {
			vrIssueImpl.setProductionPlantName(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setProductionPlantName(productionPlantName);
		}

		if (productionPlantAddress == null) {
			vrIssueImpl.setProductionPlantAddress(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setProductionPlantAddress(productionPlantAddress);
		}

		if (remarks == null) {
			vrIssueImpl.setRemarks(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setRemarks(remarks);
		}

		if (methodOfIssue == null) {
			vrIssueImpl.setMethodOfIssue(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setMethodOfIssue(methodOfIssue);
		}

		vrIssueImpl.setTotalInDocument(totalInDocument);

		if (issueCorporationId == null) {
			vrIssueImpl.setIssueCorporationId(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setIssueCorporationId(issueCorporationId);
		}

		if (verifyCorporationId == null) {
			vrIssueImpl.setVerifyCorporationId(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setVerifyCorporationId(verifyCorporationId);
		}

		if (digitalissuestatus == null) {
			vrIssueImpl.setDigitalissuestatus(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setDigitalissuestatus(digitalissuestatus);
		}

		if (issueType == null) {
			vrIssueImpl.setIssueType(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setIssueType(issueType);
		}

		vrIssueImpl.setAverageSTBQuantity(averageSTBQuantity);
		vrIssueImpl.setMaxMonthQuantity(maxMonthQuantity);
		vrIssueImpl.setAverageSTMQuantity(averageSTMQuantity);
		vrIssueImpl.setAccumulatedMonthQuantity(accumulatedMonthQuantity);
		vrIssueImpl.setTotalInUse(totalInUse);
		vrIssueImpl.setTotalCancelled(totalCancelled);
		vrIssueImpl.setTotalLost(totalLost);
		vrIssueImpl.setTotalNotUsed(totalNotUsed);
		vrIssueImpl.setTotalReturned(totalReturned);

		if (flow == null) {
			vrIssueImpl.setFlow(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setFlow(flow);
		}

		if (examinationRequired == null) {
			vrIssueImpl.setExaminationRequired(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setExaminationRequired(examinationRequired);
		}

		if (examinationPeriod == null) {
			vrIssueImpl.setExaminationPeriod(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setExaminationPeriod(examinationPeriod);
		}

		if (examinationLastTime == Long.MIN_VALUE) {
			vrIssueImpl.setExaminationLastTime(null);
		}
		else {
			vrIssueImpl.setExaminationLastTime(new Date(examinationLastTime));
		}

		if (copresult == null) {
			vrIssueImpl.setCopresult(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setCopresult(copresult);
		}

		if (copreportno == null) {
			vrIssueImpl.setCopreportno(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setCopreportno(copreportno);
		}

		if (copreportdate == Long.MIN_VALUE) {
			vrIssueImpl.setCopreportdate(null);
		}
		else {
			vrIssueImpl.setCopreportdate(new Date(copreportdate));
		}

		if (postreview == null) {
			vrIssueImpl.setPostreview(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setPostreview(postreview);
		}

		if (postreviewrecordno == null) {
			vrIssueImpl.setPostreviewrecordno(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setPostreviewrecordno(postreviewrecordno);
		}

		if (postreviewrecorddate == Long.MIN_VALUE) {
			vrIssueImpl.setPostreviewrecorddate(null);
		}
		else {
			vrIssueImpl.setPostreviewrecorddate(new Date(postreviewrecorddate));
		}

		if (corporationId == null) {
			vrIssueImpl.setCorporationId(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setCorporationId(corporationId);
		}

		if (inspectorcode == null) {
			vrIssueImpl.setInspectorcode(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setInspectorcode(inspectorcode);
		}

		if (inspectorname == null) {
			vrIssueImpl.setInspectorname(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setInspectorname(inspectorname);
		}

		if (leadername == null) {
			vrIssueImpl.setLeadername(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setLeadername(leadername);
		}

		if (applicantmaker == null) {
			vrIssueImpl.setApplicantmaker(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setApplicantmaker(applicantmaker);
		}

		if (applicantchecker == null) {
			vrIssueImpl.setApplicantchecker(StringPool.BLANK);
		}
		else {
			vrIssueImpl.setApplicantchecker(applicantchecker);
		}

		if (modifyDate == Long.MIN_VALUE) {
			vrIssueImpl.setModifyDate(null);
		}
		else {
			vrIssueImpl.setModifyDate(new Date(modifyDate));
		}

		if (syncDate == Long.MIN_VALUE) {
			vrIssueImpl.setSyncDate(null);
		}
		else {
			vrIssueImpl.setSyncDate(new Date(syncDate));
		}

		vrIssueImpl.resetOriginalValues();

		return vrIssueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		mtCore = objectInput.readLong();

		dossierId = objectInput.readLong();
		stampIssueNo = objectInput.readUTF();
		appliedDate = objectInput.readLong();
		approvedDate = objectInput.readLong();
		vehicleClass = objectInput.readUTF();

		applicantProfileId = objectInput.readLong();
		applicantName = objectInput.readUTF();
		applicantAddress = objectInput.readUTF();
		applicantRepresentative = objectInput.readUTF();
		applicantRepresentativeTitle = objectInput.readUTF();
		applicantEmail = objectInput.readUTF();
		applicantPhone = objectInput.readUTF();
		applicantFax = objectInput.readUTF();
		applicantContactName = objectInput.readUTF();
		applicantContactEmail = objectInput.readUTF();
		applicantContactPhone = objectInput.readUTF();

		productionPlantId = objectInput.readLong();
		productionPlantCode = objectInput.readUTF();
		productionPlantName = objectInput.readUTF();
		productionPlantAddress = objectInput.readUTF();
		remarks = objectInput.readUTF();
		methodOfIssue = objectInput.readUTF();

		totalInDocument = objectInput.readLong();
		issueCorporationId = objectInput.readUTF();
		verifyCorporationId = objectInput.readUTF();
		digitalissuestatus = objectInput.readUTF();
		issueType = objectInput.readUTF();

		averageSTBQuantity = objectInput.readInt();

		maxMonthQuantity = objectInput.readInt();

		averageSTMQuantity = objectInput.readInt();

		accumulatedMonthQuantity = objectInput.readInt();

		totalInUse = objectInput.readInt();

		totalCancelled = objectInput.readInt();

		totalLost = objectInput.readInt();

		totalNotUsed = objectInput.readInt();

		totalReturned = objectInput.readInt();
		flow = objectInput.readUTF();
		examinationRequired = objectInput.readUTF();
		examinationPeriod = objectInput.readUTF();
		examinationLastTime = objectInput.readLong();
		copresult = objectInput.readUTF();
		copreportno = objectInput.readUTF();
		copreportdate = objectInput.readLong();
		postreview = objectInput.readUTF();
		postreviewrecordno = objectInput.readUTF();
		postreviewrecorddate = objectInput.readLong();
		corporationId = objectInput.readUTF();
		inspectorcode = objectInput.readUTF();
		inspectorname = objectInput.readUTF();
		leadername = objectInput.readUTF();
		applicantmaker = objectInput.readUTF();
		applicantchecker = objectInput.readUTF();
		modifyDate = objectInput.readLong();
		syncDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(mtCore);

		objectOutput.writeLong(dossierId);

		if (stampIssueNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stampIssueNo);
		}

		objectOutput.writeLong(appliedDate);
		objectOutput.writeLong(approvedDate);

		if (vehicleClass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vehicleClass);
		}

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

		if (applicantRepresentative == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantRepresentative);
		}

		if (applicantRepresentativeTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantRepresentativeTitle);
		}

		if (applicantEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantEmail);
		}

		if (applicantPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantPhone);
		}

		if (applicantFax == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantFax);
		}

		if (applicantContactName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantContactName);
		}

		if (applicantContactEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantContactEmail);
		}

		if (applicantContactPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantContactPhone);
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

		if (remarks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		if (methodOfIssue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(methodOfIssue);
		}

		objectOutput.writeLong(totalInDocument);

		if (issueCorporationId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(issueCorporationId);
		}

		if (verifyCorporationId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(verifyCorporationId);
		}

		if (digitalissuestatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(digitalissuestatus);
		}

		if (issueType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(issueType);
		}

		objectOutput.writeInt(averageSTBQuantity);

		objectOutput.writeInt(maxMonthQuantity);

		objectOutput.writeInt(averageSTMQuantity);

		objectOutput.writeInt(accumulatedMonthQuantity);

		objectOutput.writeInt(totalInUse);

		objectOutput.writeInt(totalCancelled);

		objectOutput.writeInt(totalLost);

		objectOutput.writeInt(totalNotUsed);

		objectOutput.writeInt(totalReturned);

		if (flow == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(flow);
		}

		if (examinationRequired == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(examinationRequired);
		}

		if (examinationPeriod == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(examinationPeriod);
		}

		objectOutput.writeLong(examinationLastTime);

		if (copresult == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(copresult);
		}

		if (copreportno == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(copreportno);
		}

		objectOutput.writeLong(copreportdate);

		if (postreview == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postreview);
		}

		if (postreviewrecordno == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postreviewrecordno);
		}

		objectOutput.writeLong(postreviewrecorddate);

		if (corporationId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(corporationId);
		}

		if (inspectorcode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(inspectorcode);
		}

		if (inspectorname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(inspectorname);
		}

		if (leadername == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(leadername);
		}

		if (applicantmaker == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantmaker);
		}

		if (applicantchecker == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantchecker);
		}

		objectOutput.writeLong(modifyDate);
		objectOutput.writeLong(syncDate);
	}

	public long id;
	public long mtCore;
	public long dossierId;
	public String stampIssueNo;
	public long appliedDate;
	public long approvedDate;
	public String vehicleClass;
	public long applicantProfileId;
	public String applicantName;
	public String applicantAddress;
	public String applicantRepresentative;
	public String applicantRepresentativeTitle;
	public String applicantEmail;
	public String applicantPhone;
	public String applicantFax;
	public String applicantContactName;
	public String applicantContactEmail;
	public String applicantContactPhone;
	public long productionPlantId;
	public String productionPlantCode;
	public String productionPlantName;
	public String productionPlantAddress;
	public String remarks;
	public String methodOfIssue;
	public long totalInDocument;
	public String issueCorporationId;
	public String verifyCorporationId;
	public String digitalissuestatus;
	public String issueType;
	public int averageSTBQuantity;
	public int maxMonthQuantity;
	public int averageSTMQuantity;
	public int accumulatedMonthQuantity;
	public int totalInUse;
	public int totalCancelled;
	public int totalLost;
	public int totalNotUsed;
	public int totalReturned;
	public String flow;
	public String examinationRequired;
	public String examinationPeriod;
	public long examinationLastTime;
	public String copresult;
	public String copreportno;
	public long copreportdate;
	public String postreview;
	public String postreviewrecordno;
	public long postreviewrecorddate;
	public String corporationId;
	public String inspectorcode;
	public String inspectorname;
	public String leadername;
	public String applicantmaker;
	public String applicantchecker;
	public long modifyDate;
	public long syncDate;
}