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

package com.fds.vr.business.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link VRIssueEquipmentCertificate}.
 * </p>
 *
 * @author LamTV
 * @see VRIssueEquipmentCertificate
 * @generated
 */
@ProviderType
public class VRIssueEquipmentCertificateWrapper
	implements VRIssueEquipmentCertificate,
		ModelWrapper<VRIssueEquipmentCertificate> {
	public VRIssueEquipmentCertificateWrapper(
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate) {
		_vrIssueEquipmentCertificate = vrIssueEquipmentCertificate;
	}

	@Override
	public Class<?> getModelClass() {
		return VRIssueEquipmentCertificate.class;
	}

	@Override
	public String getModelClassName() {
		return VRIssueEquipmentCertificate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("mtcore", getMtcore());
		attributes.put("issueId", getIssueId());
		attributes.put("issueVehicleCertificateId",
			getIssueVehicleCertificateId());
		attributes.put("vehiclecertificaterecordno",
			getVehiclecertificaterecordno());
		attributes.put("equipmentName", getEquipmentName());
		attributes.put("equipmentType", getEquipmentType());
		attributes.put("equipmentCertificateType", getEquipmentCertificateType());
		attributes.put("equipmentDocumentNo", getEquipmentDocumentNo());
		attributes.put("equipmentCertificateRecordNo",
			getEquipmentCertificateRecordNo());
		attributes.put("equipmentExamRecordNo", getEquipmentExamRecordNo());
		attributes.put("EquipmentCertificateRecordId",
			getEquipmentCertificateRecordId());
		attributes.put("TotalQuantity", getTotalQuantity());
		attributes.put("TotalProductUsed", getTotalProductUsed());
		attributes.put("TotalInUse", getTotalInUse());
		attributes.put("TotalNotUsed", getTotalNotUsed());
		attributes.put("applicantNo", getApplicantNo());
		attributes.put("applicantname", getApplicantname());
		attributes.put("applicantaddress", getApplicantaddress());
		attributes.put("productionplantname", getProductionplantname());
		attributes.put("productionplantaddress", getProductionplantaddress());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("syncDate", getSyncDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer mtcore = (Integer)attributes.get("mtcore");

		if (mtcore != null) {
			setMtcore(mtcore);
		}

		Integer issueId = (Integer)attributes.get("issueId");

		if (issueId != null) {
			setIssueId(issueId);
		}

		Integer issueVehicleCertificateId = (Integer)attributes.get(
				"issueVehicleCertificateId");

		if (issueVehicleCertificateId != null) {
			setIssueVehicleCertificateId(issueVehicleCertificateId);
		}

		String vehiclecertificaterecordno = (String)attributes.get(
				"vehiclecertificaterecordno");

		if (vehiclecertificaterecordno != null) {
			setVehiclecertificaterecordno(vehiclecertificaterecordno);
		}

		String equipmentName = (String)attributes.get("equipmentName");

		if (equipmentName != null) {
			setEquipmentName(equipmentName);
		}

		String equipmentType = (String)attributes.get("equipmentType");

		if (equipmentType != null) {
			setEquipmentType(equipmentType);
		}

		String equipmentCertificateType = (String)attributes.get(
				"equipmentCertificateType");

		if (equipmentCertificateType != null) {
			setEquipmentCertificateType(equipmentCertificateType);
		}

		String equipmentDocumentNo = (String)attributes.get(
				"equipmentDocumentNo");

		if (equipmentDocumentNo != null) {
			setEquipmentDocumentNo(equipmentDocumentNo);
		}

		String equipmentCertificateRecordNo = (String)attributes.get(
				"equipmentCertificateRecordNo");

		if (equipmentCertificateRecordNo != null) {
			setEquipmentCertificateRecordNo(equipmentCertificateRecordNo);
		}

		String equipmentExamRecordNo = (String)attributes.get(
				"equipmentExamRecordNo");

		if (equipmentExamRecordNo != null) {
			setEquipmentExamRecordNo(equipmentExamRecordNo);
		}

		Integer EquipmentCertificateRecordId = (Integer)attributes.get(
				"EquipmentCertificateRecordId");

		if (EquipmentCertificateRecordId != null) {
			setEquipmentCertificateRecordId(EquipmentCertificateRecordId);
		}

		Integer TotalQuantity = (Integer)attributes.get("TotalQuantity");

		if (TotalQuantity != null) {
			setTotalQuantity(TotalQuantity);
		}

		Integer TotalProductUsed = (Integer)attributes.get("TotalProductUsed");

		if (TotalProductUsed != null) {
			setTotalProductUsed(TotalProductUsed);
		}

		Integer TotalInUse = (Integer)attributes.get("TotalInUse");

		if (TotalInUse != null) {
			setTotalInUse(TotalInUse);
		}

		Integer TotalNotUsed = (Integer)attributes.get("TotalNotUsed");

		if (TotalNotUsed != null) {
			setTotalNotUsed(TotalNotUsed);
		}

		String applicantNo = (String)attributes.get("applicantNo");

		if (applicantNo != null) {
			setApplicantNo(applicantNo);
		}

		String applicantname = (String)attributes.get("applicantname");

		if (applicantname != null) {
			setApplicantname(applicantname);
		}

		String applicantaddress = (String)attributes.get("applicantaddress");

		if (applicantaddress != null) {
			setApplicantaddress(applicantaddress);
		}

		String productionplantname = (String)attributes.get(
				"productionplantname");

		if (productionplantname != null) {
			setProductionplantname(productionplantname);
		}

		String productionplantaddress = (String)attributes.get(
				"productionplantaddress");

		if (productionplantaddress != null) {
			setProductionplantaddress(productionplantaddress);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		Date syncDate = (Date)attributes.get("syncDate");

		if (syncDate != null) {
			setSyncDate(syncDate);
		}
	}

	@Override
	public VRIssueEquipmentCertificate toEscapedModel() {
		return new VRIssueEquipmentCertificateWrapper(_vrIssueEquipmentCertificate.toEscapedModel());
	}

	@Override
	public VRIssueEquipmentCertificate toUnescapedModel() {
		return new VRIssueEquipmentCertificateWrapper(_vrIssueEquipmentCertificate.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _vrIssueEquipmentCertificate.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _vrIssueEquipmentCertificate.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _vrIssueEquipmentCertificate.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _vrIssueEquipmentCertificate.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<VRIssueEquipmentCertificate> toCacheModel() {
		return _vrIssueEquipmentCertificate.toCacheModel();
	}

	@Override
	public int compareTo(
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate) {
		return _vrIssueEquipmentCertificate.compareTo(vrIssueEquipmentCertificate);
	}

	/**
	* Returns the equipment certificate record ID of this vr issue equipment certificate.
	*
	* @return the equipment certificate record ID of this vr issue equipment certificate
	*/
	@Override
	public int getEquipmentCertificateRecordId() {
		return _vrIssueEquipmentCertificate.getEquipmentCertificateRecordId();
	}

	/**
	* Returns the issue ID of this vr issue equipment certificate.
	*
	* @return the issue ID of this vr issue equipment certificate
	*/
	@Override
	public int getIssueId() {
		return _vrIssueEquipmentCertificate.getIssueId();
	}

	/**
	* Returns the issue vehicle certificate ID of this vr issue equipment certificate.
	*
	* @return the issue vehicle certificate ID of this vr issue equipment certificate
	*/
	@Override
	public int getIssueVehicleCertificateId() {
		return _vrIssueEquipmentCertificate.getIssueVehicleCertificateId();
	}

	/**
	* Returns the mtcore of this vr issue equipment certificate.
	*
	* @return the mtcore of this vr issue equipment certificate
	*/
	@Override
	public int getMtcore() {
		return _vrIssueEquipmentCertificate.getMtcore();
	}

	/**
	* Returns the total in use of this vr issue equipment certificate.
	*
	* @return the total in use of this vr issue equipment certificate
	*/
	@Override
	public int getTotalInUse() {
		return _vrIssueEquipmentCertificate.getTotalInUse();
	}

	/**
	* Returns the total not used of this vr issue equipment certificate.
	*
	* @return the total not used of this vr issue equipment certificate
	*/
	@Override
	public int getTotalNotUsed() {
		return _vrIssueEquipmentCertificate.getTotalNotUsed();
	}

	/**
	* Returns the total product used of this vr issue equipment certificate.
	*
	* @return the total product used of this vr issue equipment certificate
	*/
	@Override
	public int getTotalProductUsed() {
		return _vrIssueEquipmentCertificate.getTotalProductUsed();
	}

	/**
	* Returns the total quantity of this vr issue equipment certificate.
	*
	* @return the total quantity of this vr issue equipment certificate
	*/
	@Override
	public int getTotalQuantity() {
		return _vrIssueEquipmentCertificate.getTotalQuantity();
	}

	@Override
	public int hashCode() {
		return _vrIssueEquipmentCertificate.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vrIssueEquipmentCertificate.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new VRIssueEquipmentCertificateWrapper((VRIssueEquipmentCertificate)_vrIssueEquipmentCertificate.clone());
	}

	/**
	* Returns the applicant no of this vr issue equipment certificate.
	*
	* @return the applicant no of this vr issue equipment certificate
	*/
	@Override
	public java.lang.String getApplicantNo() {
		return _vrIssueEquipmentCertificate.getApplicantNo();
	}

	/**
	* Returns the applicantaddress of this vr issue equipment certificate.
	*
	* @return the applicantaddress of this vr issue equipment certificate
	*/
	@Override
	public java.lang.String getApplicantaddress() {
		return _vrIssueEquipmentCertificate.getApplicantaddress();
	}

	/**
	* Returns the applicantname of this vr issue equipment certificate.
	*
	* @return the applicantname of this vr issue equipment certificate
	*/
	@Override
	public java.lang.String getApplicantname() {
		return _vrIssueEquipmentCertificate.getApplicantname();
	}

	/**
	* Returns the equipment certificate record no of this vr issue equipment certificate.
	*
	* @return the equipment certificate record no of this vr issue equipment certificate
	*/
	@Override
	public java.lang.String getEquipmentCertificateRecordNo() {
		return _vrIssueEquipmentCertificate.getEquipmentCertificateRecordNo();
	}

	/**
	* Returns the equipment certificate type of this vr issue equipment certificate.
	*
	* @return the equipment certificate type of this vr issue equipment certificate
	*/
	@Override
	public java.lang.String getEquipmentCertificateType() {
		return _vrIssueEquipmentCertificate.getEquipmentCertificateType();
	}

	/**
	* Returns the equipment document no of this vr issue equipment certificate.
	*
	* @return the equipment document no of this vr issue equipment certificate
	*/
	@Override
	public java.lang.String getEquipmentDocumentNo() {
		return _vrIssueEquipmentCertificate.getEquipmentDocumentNo();
	}

	/**
	* Returns the equipment exam record no of this vr issue equipment certificate.
	*
	* @return the equipment exam record no of this vr issue equipment certificate
	*/
	@Override
	public java.lang.String getEquipmentExamRecordNo() {
		return _vrIssueEquipmentCertificate.getEquipmentExamRecordNo();
	}

	/**
	* Returns the equipment name of this vr issue equipment certificate.
	*
	* @return the equipment name of this vr issue equipment certificate
	*/
	@Override
	public java.lang.String getEquipmentName() {
		return _vrIssueEquipmentCertificate.getEquipmentName();
	}

	/**
	* Returns the equipment type of this vr issue equipment certificate.
	*
	* @return the equipment type of this vr issue equipment certificate
	*/
	@Override
	public java.lang.String getEquipmentType() {
		return _vrIssueEquipmentCertificate.getEquipmentType();
	}

	/**
	* Returns the productionplantaddress of this vr issue equipment certificate.
	*
	* @return the productionplantaddress of this vr issue equipment certificate
	*/
	@Override
	public java.lang.String getProductionplantaddress() {
		return _vrIssueEquipmentCertificate.getProductionplantaddress();
	}

	/**
	* Returns the productionplantname of this vr issue equipment certificate.
	*
	* @return the productionplantname of this vr issue equipment certificate
	*/
	@Override
	public java.lang.String getProductionplantname() {
		return _vrIssueEquipmentCertificate.getProductionplantname();
	}

	/**
	* Returns the vehiclecertificaterecordno of this vr issue equipment certificate.
	*
	* @return the vehiclecertificaterecordno of this vr issue equipment certificate
	*/
	@Override
	public java.lang.String getVehiclecertificaterecordno() {
		return _vrIssueEquipmentCertificate.getVehiclecertificaterecordno();
	}

	@Override
	public java.lang.String toString() {
		return _vrIssueEquipmentCertificate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vrIssueEquipmentCertificate.toXmlString();
	}

	/**
	* Returns the modify date of this vr issue equipment certificate.
	*
	* @return the modify date of this vr issue equipment certificate
	*/
	@Override
	public Date getModifyDate() {
		return _vrIssueEquipmentCertificate.getModifyDate();
	}

	/**
	* Returns the sync date of this vr issue equipment certificate.
	*
	* @return the sync date of this vr issue equipment certificate
	*/
	@Override
	public Date getSyncDate() {
		return _vrIssueEquipmentCertificate.getSyncDate();
	}

	/**
	* Returns the ID of this vr issue equipment certificate.
	*
	* @return the ID of this vr issue equipment certificate
	*/
	@Override
	public long getId() {
		return _vrIssueEquipmentCertificate.getId();
	}

	/**
	* Returns the primary key of this vr issue equipment certificate.
	*
	* @return the primary key of this vr issue equipment certificate
	*/
	@Override
	public long getPrimaryKey() {
		return _vrIssueEquipmentCertificate.getPrimaryKey();
	}

	@Override
	public void persist() {
		_vrIssueEquipmentCertificate.persist();
	}

	/**
	* Sets the applicant no of this vr issue equipment certificate.
	*
	* @param applicantNo the applicant no of this vr issue equipment certificate
	*/
	@Override
	public void setApplicantNo(java.lang.String applicantNo) {
		_vrIssueEquipmentCertificate.setApplicantNo(applicantNo);
	}

	/**
	* Sets the applicantaddress of this vr issue equipment certificate.
	*
	* @param applicantaddress the applicantaddress of this vr issue equipment certificate
	*/
	@Override
	public void setApplicantaddress(java.lang.String applicantaddress) {
		_vrIssueEquipmentCertificate.setApplicantaddress(applicantaddress);
	}

	/**
	* Sets the applicantname of this vr issue equipment certificate.
	*
	* @param applicantname the applicantname of this vr issue equipment certificate
	*/
	@Override
	public void setApplicantname(java.lang.String applicantname) {
		_vrIssueEquipmentCertificate.setApplicantname(applicantname);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vrIssueEquipmentCertificate.setCachedModel(cachedModel);
	}

	/**
	* Sets the equipment certificate record ID of this vr issue equipment certificate.
	*
	* @param EquipmentCertificateRecordId the equipment certificate record ID of this vr issue equipment certificate
	*/
	@Override
	public void setEquipmentCertificateRecordId(
		int EquipmentCertificateRecordId) {
		_vrIssueEquipmentCertificate.setEquipmentCertificateRecordId(EquipmentCertificateRecordId);
	}

	/**
	* Sets the equipment certificate record no of this vr issue equipment certificate.
	*
	* @param equipmentCertificateRecordNo the equipment certificate record no of this vr issue equipment certificate
	*/
	@Override
	public void setEquipmentCertificateRecordNo(
		java.lang.String equipmentCertificateRecordNo) {
		_vrIssueEquipmentCertificate.setEquipmentCertificateRecordNo(equipmentCertificateRecordNo);
	}

	/**
	* Sets the equipment certificate type of this vr issue equipment certificate.
	*
	* @param equipmentCertificateType the equipment certificate type of this vr issue equipment certificate
	*/
	@Override
	public void setEquipmentCertificateType(
		java.lang.String equipmentCertificateType) {
		_vrIssueEquipmentCertificate.setEquipmentCertificateType(equipmentCertificateType);
	}

	/**
	* Sets the equipment document no of this vr issue equipment certificate.
	*
	* @param equipmentDocumentNo the equipment document no of this vr issue equipment certificate
	*/
	@Override
	public void setEquipmentDocumentNo(java.lang.String equipmentDocumentNo) {
		_vrIssueEquipmentCertificate.setEquipmentDocumentNo(equipmentDocumentNo);
	}

	/**
	* Sets the equipment exam record no of this vr issue equipment certificate.
	*
	* @param equipmentExamRecordNo the equipment exam record no of this vr issue equipment certificate
	*/
	@Override
	public void setEquipmentExamRecordNo(java.lang.String equipmentExamRecordNo) {
		_vrIssueEquipmentCertificate.setEquipmentExamRecordNo(equipmentExamRecordNo);
	}

	/**
	* Sets the equipment name of this vr issue equipment certificate.
	*
	* @param equipmentName the equipment name of this vr issue equipment certificate
	*/
	@Override
	public void setEquipmentName(java.lang.String equipmentName) {
		_vrIssueEquipmentCertificate.setEquipmentName(equipmentName);
	}

	/**
	* Sets the equipment type of this vr issue equipment certificate.
	*
	* @param equipmentType the equipment type of this vr issue equipment certificate
	*/
	@Override
	public void setEquipmentType(java.lang.String equipmentType) {
		_vrIssueEquipmentCertificate.setEquipmentType(equipmentType);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_vrIssueEquipmentCertificate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_vrIssueEquipmentCertificate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_vrIssueEquipmentCertificate.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this vr issue equipment certificate.
	*
	* @param id the ID of this vr issue equipment certificate
	*/
	@Override
	public void setId(long id) {
		_vrIssueEquipmentCertificate.setId(id);
	}

	/**
	* Sets the issue ID of this vr issue equipment certificate.
	*
	* @param issueId the issue ID of this vr issue equipment certificate
	*/
	@Override
	public void setIssueId(int issueId) {
		_vrIssueEquipmentCertificate.setIssueId(issueId);
	}

	/**
	* Sets the issue vehicle certificate ID of this vr issue equipment certificate.
	*
	* @param issueVehicleCertificateId the issue vehicle certificate ID of this vr issue equipment certificate
	*/
	@Override
	public void setIssueVehicleCertificateId(int issueVehicleCertificateId) {
		_vrIssueEquipmentCertificate.setIssueVehicleCertificateId(issueVehicleCertificateId);
	}

	/**
	* Sets the modify date of this vr issue equipment certificate.
	*
	* @param modifyDate the modify date of this vr issue equipment certificate
	*/
	@Override
	public void setModifyDate(Date modifyDate) {
		_vrIssueEquipmentCertificate.setModifyDate(modifyDate);
	}

	/**
	* Sets the mtcore of this vr issue equipment certificate.
	*
	* @param mtcore the mtcore of this vr issue equipment certificate
	*/
	@Override
	public void setMtcore(int mtcore) {
		_vrIssueEquipmentCertificate.setMtcore(mtcore);
	}

	@Override
	public void setNew(boolean n) {
		_vrIssueEquipmentCertificate.setNew(n);
	}

	/**
	* Sets the primary key of this vr issue equipment certificate.
	*
	* @param primaryKey the primary key of this vr issue equipment certificate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vrIssueEquipmentCertificate.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_vrIssueEquipmentCertificate.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the productionplantaddress of this vr issue equipment certificate.
	*
	* @param productionplantaddress the productionplantaddress of this vr issue equipment certificate
	*/
	@Override
	public void setProductionplantaddress(
		java.lang.String productionplantaddress) {
		_vrIssueEquipmentCertificate.setProductionplantaddress(productionplantaddress);
	}

	/**
	* Sets the productionplantname of this vr issue equipment certificate.
	*
	* @param productionplantname the productionplantname of this vr issue equipment certificate
	*/
	@Override
	public void setProductionplantname(java.lang.String productionplantname) {
		_vrIssueEquipmentCertificate.setProductionplantname(productionplantname);
	}

	/**
	* Sets the sync date of this vr issue equipment certificate.
	*
	* @param syncDate the sync date of this vr issue equipment certificate
	*/
	@Override
	public void setSyncDate(Date syncDate) {
		_vrIssueEquipmentCertificate.setSyncDate(syncDate);
	}

	/**
	* Sets the total in use of this vr issue equipment certificate.
	*
	* @param TotalInUse the total in use of this vr issue equipment certificate
	*/
	@Override
	public void setTotalInUse(int TotalInUse) {
		_vrIssueEquipmentCertificate.setTotalInUse(TotalInUse);
	}

	/**
	* Sets the total not used of this vr issue equipment certificate.
	*
	* @param TotalNotUsed the total not used of this vr issue equipment certificate
	*/
	@Override
	public void setTotalNotUsed(int TotalNotUsed) {
		_vrIssueEquipmentCertificate.setTotalNotUsed(TotalNotUsed);
	}

	/**
	* Sets the total product used of this vr issue equipment certificate.
	*
	* @param TotalProductUsed the total product used of this vr issue equipment certificate
	*/
	@Override
	public void setTotalProductUsed(int TotalProductUsed) {
		_vrIssueEquipmentCertificate.setTotalProductUsed(TotalProductUsed);
	}

	/**
	* Sets the total quantity of this vr issue equipment certificate.
	*
	* @param TotalQuantity the total quantity of this vr issue equipment certificate
	*/
	@Override
	public void setTotalQuantity(int TotalQuantity) {
		_vrIssueEquipmentCertificate.setTotalQuantity(TotalQuantity);
	}

	/**
	* Sets the vehiclecertificaterecordno of this vr issue equipment certificate.
	*
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno of this vr issue equipment certificate
	*/
	@Override
	public void setVehiclecertificaterecordno(
		java.lang.String vehiclecertificaterecordno) {
		_vrIssueEquipmentCertificate.setVehiclecertificaterecordno(vehiclecertificaterecordno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRIssueEquipmentCertificateWrapper)) {
			return false;
		}

		VRIssueEquipmentCertificateWrapper vrIssueEquipmentCertificateWrapper = (VRIssueEquipmentCertificateWrapper)obj;

		if (Objects.equals(_vrIssueEquipmentCertificate,
					vrIssueEquipmentCertificateWrapper._vrIssueEquipmentCertificate)) {
			return true;
		}

		return false;
	}

	@Override
	public VRIssueEquipmentCertificate getWrappedModel() {
		return _vrIssueEquipmentCertificate;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _vrIssueEquipmentCertificate.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _vrIssueEquipmentCertificate.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_vrIssueEquipmentCertificate.resetOriginalValues();
	}

	private final VRIssueEquipmentCertificate _vrIssueEquipmentCertificate;
}