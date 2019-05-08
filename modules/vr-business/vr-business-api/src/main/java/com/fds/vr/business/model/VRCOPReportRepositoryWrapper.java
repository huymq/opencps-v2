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
 * This class is a wrapper for {@link VRCOPReportRepository}.
 * </p>
 *
 * @author LamTV
 * @see VRCOPReportRepository
 * @generated
 */
@ProviderType
public class VRCOPReportRepositoryWrapper implements VRCOPReportRepository,
	ModelWrapper<VRCOPReportRepository> {
	public VRCOPReportRepositoryWrapper(
		VRCOPReportRepository vrcopReportRepository) {
		_vrcopReportRepository = vrcopReportRepository;
	}

	@Override
	public Class<?> getModelClass() {
		return VRCOPReportRepository.class;
	}

	@Override
	public String getModelClassName() {
		return VRCOPReportRepository.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("mtCore", getMtCore());
		attributes.put("applicantProfileId", getApplicantProfileId());
		attributes.put("applicantName", getApplicantName());
		attributes.put("applicantAddress", getApplicantAddress());
		attributes.put("overseasManufacturerId", getOverseasManufacturerId());
		attributes.put("overseasManufacturerName", getOverseasManufacturerName());
		attributes.put("overseasManufacturerAddress",
			getOverseasManufacturerAddress());
		attributes.put("productionPlantId", getProductionPlantId());
		attributes.put("productionPlantCode", getProductionPlantCode());
		attributes.put("productionPlantName", getProductionPlantName());
		attributes.put("productionPlantAddress", getProductionPlantAddress());
		attributes.put("copReportNo", getCopReportNo());
		attributes.put("copReportStatus", getCopReportStatus());
		attributes.put("copReportType", getCopReportType());
		attributes.put("copReportMetadata", getCopReportMetadata());
		attributes.put("copReportSignName", getCopReportSignName());
		attributes.put("copReportSignTitle", getCopReportSignTitle());
		attributes.put("copReportSignPlace", getCopReportSignPlace());
		attributes.put("copReportDate", getCopReportDate());
		attributes.put("copReportApprovedDate", getCopReportApprovedDate());
		attributes.put("copReportExpiredDate", getCopReportExpiredDate());
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

		Long mtCore = (Long)attributes.get("mtCore");

		if (mtCore != null) {
			setMtCore(mtCore);
		}

		Long applicantProfileId = (Long)attributes.get("applicantProfileId");

		if (applicantProfileId != null) {
			setApplicantProfileId(applicantProfileId);
		}

		String applicantName = (String)attributes.get("applicantName");

		if (applicantName != null) {
			setApplicantName(applicantName);
		}

		String applicantAddress = (String)attributes.get("applicantAddress");

		if (applicantAddress != null) {
			setApplicantAddress(applicantAddress);
		}

		Long overseasManufacturerId = (Long)attributes.get(
				"overseasManufacturerId");

		if (overseasManufacturerId != null) {
			setOverseasManufacturerId(overseasManufacturerId);
		}

		String overseasManufacturerName = (String)attributes.get(
				"overseasManufacturerName");

		if (overseasManufacturerName != null) {
			setOverseasManufacturerName(overseasManufacturerName);
		}

		String overseasManufacturerAddress = (String)attributes.get(
				"overseasManufacturerAddress");

		if (overseasManufacturerAddress != null) {
			setOverseasManufacturerAddress(overseasManufacturerAddress);
		}

		Long productionPlantId = (Long)attributes.get("productionPlantId");

		if (productionPlantId != null) {
			setProductionPlantId(productionPlantId);
		}

		String productionPlantCode = (String)attributes.get(
				"productionPlantCode");

		if (productionPlantCode != null) {
			setProductionPlantCode(productionPlantCode);
		}

		String productionPlantName = (String)attributes.get(
				"productionPlantName");

		if (productionPlantName != null) {
			setProductionPlantName(productionPlantName);
		}

		String productionPlantAddress = (String)attributes.get(
				"productionPlantAddress");

		if (productionPlantAddress != null) {
			setProductionPlantAddress(productionPlantAddress);
		}

		String copReportNo = (String)attributes.get("copReportNo");

		if (copReportNo != null) {
			setCopReportNo(copReportNo);
		}

		String copReportStatus = (String)attributes.get("copReportStatus");

		if (copReportStatus != null) {
			setCopReportStatus(copReportStatus);
		}

		String copReportType = (String)attributes.get("copReportType");

		if (copReportType != null) {
			setCopReportType(copReportType);
		}

		String copReportMetadata = (String)attributes.get("copReportMetadata");

		if (copReportMetadata != null) {
			setCopReportMetadata(copReportMetadata);
		}

		String copReportSignName = (String)attributes.get("copReportSignName");

		if (copReportSignName != null) {
			setCopReportSignName(copReportSignName);
		}

		String copReportSignTitle = (String)attributes.get("copReportSignTitle");

		if (copReportSignTitle != null) {
			setCopReportSignTitle(copReportSignTitle);
		}

		String copReportSignPlace = (String)attributes.get("copReportSignPlace");

		if (copReportSignPlace != null) {
			setCopReportSignPlace(copReportSignPlace);
		}

		Date copReportDate = (Date)attributes.get("copReportDate");

		if (copReportDate != null) {
			setCopReportDate(copReportDate);
		}

		Date copReportApprovedDate = (Date)attributes.get(
				"copReportApprovedDate");

		if (copReportApprovedDate != null) {
			setCopReportApprovedDate(copReportApprovedDate);
		}

		Date copReportExpiredDate = (Date)attributes.get("copReportExpiredDate");

		if (copReportExpiredDate != null) {
			setCopReportExpiredDate(copReportExpiredDate);
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
	public VRCOPReportRepository toEscapedModel() {
		return new VRCOPReportRepositoryWrapper(_vrcopReportRepository.toEscapedModel());
	}

	@Override
	public VRCOPReportRepository toUnescapedModel() {
		return new VRCOPReportRepositoryWrapper(_vrcopReportRepository.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _vrcopReportRepository.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _vrcopReportRepository.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _vrcopReportRepository.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _vrcopReportRepository.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<VRCOPReportRepository> toCacheModel() {
		return _vrcopReportRepository.toCacheModel();
	}

	@Override
	public int compareTo(VRCOPReportRepository vrcopReportRepository) {
		return _vrcopReportRepository.compareTo(vrcopReportRepository);
	}

	@Override
	public int hashCode() {
		return _vrcopReportRepository.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vrcopReportRepository.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new VRCOPReportRepositoryWrapper((VRCOPReportRepository)_vrcopReportRepository.clone());
	}

	/**
	* Returns the applicant address of this vrcop report repository.
	*
	* @return the applicant address of this vrcop report repository
	*/
	@Override
	public java.lang.String getApplicantAddress() {
		return _vrcopReportRepository.getApplicantAddress();
	}

	/**
	* Returns the applicant name of this vrcop report repository.
	*
	* @return the applicant name of this vrcop report repository
	*/
	@Override
	public java.lang.String getApplicantName() {
		return _vrcopReportRepository.getApplicantName();
	}

	/**
	* Returns the cop report metadata of this vrcop report repository.
	*
	* @return the cop report metadata of this vrcop report repository
	*/
	@Override
	public java.lang.String getCopReportMetadata() {
		return _vrcopReportRepository.getCopReportMetadata();
	}

	/**
	* Returns the cop report no of this vrcop report repository.
	*
	* @return the cop report no of this vrcop report repository
	*/
	@Override
	public java.lang.String getCopReportNo() {
		return _vrcopReportRepository.getCopReportNo();
	}

	/**
	* Returns the cop report sign name of this vrcop report repository.
	*
	* @return the cop report sign name of this vrcop report repository
	*/
	@Override
	public java.lang.String getCopReportSignName() {
		return _vrcopReportRepository.getCopReportSignName();
	}

	/**
	* Returns the cop report sign place of this vrcop report repository.
	*
	* @return the cop report sign place of this vrcop report repository
	*/
	@Override
	public java.lang.String getCopReportSignPlace() {
		return _vrcopReportRepository.getCopReportSignPlace();
	}

	/**
	* Returns the cop report sign title of this vrcop report repository.
	*
	* @return the cop report sign title of this vrcop report repository
	*/
	@Override
	public java.lang.String getCopReportSignTitle() {
		return _vrcopReportRepository.getCopReportSignTitle();
	}

	/**
	* Returns the cop report status of this vrcop report repository.
	*
	* @return the cop report status of this vrcop report repository
	*/
	@Override
	public java.lang.String getCopReportStatus() {
		return _vrcopReportRepository.getCopReportStatus();
	}

	/**
	* Returns the cop report type of this vrcop report repository.
	*
	* @return the cop report type of this vrcop report repository
	*/
	@Override
	public java.lang.String getCopReportType() {
		return _vrcopReportRepository.getCopReportType();
	}

	/**
	* Returns the overseas manufacturer address of this vrcop report repository.
	*
	* @return the overseas manufacturer address of this vrcop report repository
	*/
	@Override
	public java.lang.String getOverseasManufacturerAddress() {
		return _vrcopReportRepository.getOverseasManufacturerAddress();
	}

	/**
	* Returns the overseas manufacturer name of this vrcop report repository.
	*
	* @return the overseas manufacturer name of this vrcop report repository
	*/
	@Override
	public java.lang.String getOverseasManufacturerName() {
		return _vrcopReportRepository.getOverseasManufacturerName();
	}

	/**
	* Returns the production plant address of this vrcop report repository.
	*
	* @return the production plant address of this vrcop report repository
	*/
	@Override
	public java.lang.String getProductionPlantAddress() {
		return _vrcopReportRepository.getProductionPlantAddress();
	}

	/**
	* Returns the production plant code of this vrcop report repository.
	*
	* @return the production plant code of this vrcop report repository
	*/
	@Override
	public java.lang.String getProductionPlantCode() {
		return _vrcopReportRepository.getProductionPlantCode();
	}

	/**
	* Returns the production plant name of this vrcop report repository.
	*
	* @return the production plant name of this vrcop report repository
	*/
	@Override
	public java.lang.String getProductionPlantName() {
		return _vrcopReportRepository.getProductionPlantName();
	}

	@Override
	public java.lang.String toString() {
		return _vrcopReportRepository.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vrcopReportRepository.toXmlString();
	}

	/**
	* Returns the cop report approved date of this vrcop report repository.
	*
	* @return the cop report approved date of this vrcop report repository
	*/
	@Override
	public Date getCopReportApprovedDate() {
		return _vrcopReportRepository.getCopReportApprovedDate();
	}

	/**
	* Returns the cop report date of this vrcop report repository.
	*
	* @return the cop report date of this vrcop report repository
	*/
	@Override
	public Date getCopReportDate() {
		return _vrcopReportRepository.getCopReportDate();
	}

	/**
	* Returns the cop report expired date of this vrcop report repository.
	*
	* @return the cop report expired date of this vrcop report repository
	*/
	@Override
	public Date getCopReportExpiredDate() {
		return _vrcopReportRepository.getCopReportExpiredDate();
	}

	/**
	* Returns the modify date of this vrcop report repository.
	*
	* @return the modify date of this vrcop report repository
	*/
	@Override
	public Date getModifyDate() {
		return _vrcopReportRepository.getModifyDate();
	}

	/**
	* Returns the sync date of this vrcop report repository.
	*
	* @return the sync date of this vrcop report repository
	*/
	@Override
	public Date getSyncDate() {
		return _vrcopReportRepository.getSyncDate();
	}

	/**
	* Returns the applicant profile ID of this vrcop report repository.
	*
	* @return the applicant profile ID of this vrcop report repository
	*/
	@Override
	public long getApplicantProfileId() {
		return _vrcopReportRepository.getApplicantProfileId();
	}

	/**
	* Returns the ID of this vrcop report repository.
	*
	* @return the ID of this vrcop report repository
	*/
	@Override
	public long getId() {
		return _vrcopReportRepository.getId();
	}

	/**
	* Returns the mt core of this vrcop report repository.
	*
	* @return the mt core of this vrcop report repository
	*/
	@Override
	public long getMtCore() {
		return _vrcopReportRepository.getMtCore();
	}

	/**
	* Returns the overseas manufacturer ID of this vrcop report repository.
	*
	* @return the overseas manufacturer ID of this vrcop report repository
	*/
	@Override
	public long getOverseasManufacturerId() {
		return _vrcopReportRepository.getOverseasManufacturerId();
	}

	/**
	* Returns the primary key of this vrcop report repository.
	*
	* @return the primary key of this vrcop report repository
	*/
	@Override
	public long getPrimaryKey() {
		return _vrcopReportRepository.getPrimaryKey();
	}

	/**
	* Returns the production plant ID of this vrcop report repository.
	*
	* @return the production plant ID of this vrcop report repository
	*/
	@Override
	public long getProductionPlantId() {
		return _vrcopReportRepository.getProductionPlantId();
	}

	@Override
	public void persist() {
		_vrcopReportRepository.persist();
	}

	/**
	* Sets the applicant address of this vrcop report repository.
	*
	* @param applicantAddress the applicant address of this vrcop report repository
	*/
	@Override
	public void setApplicantAddress(java.lang.String applicantAddress) {
		_vrcopReportRepository.setApplicantAddress(applicantAddress);
	}

	/**
	* Sets the applicant name of this vrcop report repository.
	*
	* @param applicantName the applicant name of this vrcop report repository
	*/
	@Override
	public void setApplicantName(java.lang.String applicantName) {
		_vrcopReportRepository.setApplicantName(applicantName);
	}

	/**
	* Sets the applicant profile ID of this vrcop report repository.
	*
	* @param applicantProfileId the applicant profile ID of this vrcop report repository
	*/
	@Override
	public void setApplicantProfileId(long applicantProfileId) {
		_vrcopReportRepository.setApplicantProfileId(applicantProfileId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vrcopReportRepository.setCachedModel(cachedModel);
	}

	/**
	* Sets the cop report approved date of this vrcop report repository.
	*
	* @param copReportApprovedDate the cop report approved date of this vrcop report repository
	*/
	@Override
	public void setCopReportApprovedDate(Date copReportApprovedDate) {
		_vrcopReportRepository.setCopReportApprovedDate(copReportApprovedDate);
	}

	/**
	* Sets the cop report date of this vrcop report repository.
	*
	* @param copReportDate the cop report date of this vrcop report repository
	*/
	@Override
	public void setCopReportDate(Date copReportDate) {
		_vrcopReportRepository.setCopReportDate(copReportDate);
	}

	/**
	* Sets the cop report expired date of this vrcop report repository.
	*
	* @param copReportExpiredDate the cop report expired date of this vrcop report repository
	*/
	@Override
	public void setCopReportExpiredDate(Date copReportExpiredDate) {
		_vrcopReportRepository.setCopReportExpiredDate(copReportExpiredDate);
	}

	/**
	* Sets the cop report metadata of this vrcop report repository.
	*
	* @param copReportMetadata the cop report metadata of this vrcop report repository
	*/
	@Override
	public void setCopReportMetadata(java.lang.String copReportMetadata) {
		_vrcopReportRepository.setCopReportMetadata(copReportMetadata);
	}

	/**
	* Sets the cop report no of this vrcop report repository.
	*
	* @param copReportNo the cop report no of this vrcop report repository
	*/
	@Override
	public void setCopReportNo(java.lang.String copReportNo) {
		_vrcopReportRepository.setCopReportNo(copReportNo);
	}

	/**
	* Sets the cop report sign name of this vrcop report repository.
	*
	* @param copReportSignName the cop report sign name of this vrcop report repository
	*/
	@Override
	public void setCopReportSignName(java.lang.String copReportSignName) {
		_vrcopReportRepository.setCopReportSignName(copReportSignName);
	}

	/**
	* Sets the cop report sign place of this vrcop report repository.
	*
	* @param copReportSignPlace the cop report sign place of this vrcop report repository
	*/
	@Override
	public void setCopReportSignPlace(java.lang.String copReportSignPlace) {
		_vrcopReportRepository.setCopReportSignPlace(copReportSignPlace);
	}

	/**
	* Sets the cop report sign title of this vrcop report repository.
	*
	* @param copReportSignTitle the cop report sign title of this vrcop report repository
	*/
	@Override
	public void setCopReportSignTitle(java.lang.String copReportSignTitle) {
		_vrcopReportRepository.setCopReportSignTitle(copReportSignTitle);
	}

	/**
	* Sets the cop report status of this vrcop report repository.
	*
	* @param copReportStatus the cop report status of this vrcop report repository
	*/
	@Override
	public void setCopReportStatus(java.lang.String copReportStatus) {
		_vrcopReportRepository.setCopReportStatus(copReportStatus);
	}

	/**
	* Sets the cop report type of this vrcop report repository.
	*
	* @param copReportType the cop report type of this vrcop report repository
	*/
	@Override
	public void setCopReportType(java.lang.String copReportType) {
		_vrcopReportRepository.setCopReportType(copReportType);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_vrcopReportRepository.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_vrcopReportRepository.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_vrcopReportRepository.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this vrcop report repository.
	*
	* @param id the ID of this vrcop report repository
	*/
	@Override
	public void setId(long id) {
		_vrcopReportRepository.setId(id);
	}

	/**
	* Sets the modify date of this vrcop report repository.
	*
	* @param modifyDate the modify date of this vrcop report repository
	*/
	@Override
	public void setModifyDate(Date modifyDate) {
		_vrcopReportRepository.setModifyDate(modifyDate);
	}

	/**
	* Sets the mt core of this vrcop report repository.
	*
	* @param mtCore the mt core of this vrcop report repository
	*/
	@Override
	public void setMtCore(long mtCore) {
		_vrcopReportRepository.setMtCore(mtCore);
	}

	@Override
	public void setNew(boolean n) {
		_vrcopReportRepository.setNew(n);
	}

	/**
	* Sets the overseas manufacturer address of this vrcop report repository.
	*
	* @param overseasManufacturerAddress the overseas manufacturer address of this vrcop report repository
	*/
	@Override
	public void setOverseasManufacturerAddress(
		java.lang.String overseasManufacturerAddress) {
		_vrcopReportRepository.setOverseasManufacturerAddress(overseasManufacturerAddress);
	}

	/**
	* Sets the overseas manufacturer ID of this vrcop report repository.
	*
	* @param overseasManufacturerId the overseas manufacturer ID of this vrcop report repository
	*/
	@Override
	public void setOverseasManufacturerId(long overseasManufacturerId) {
		_vrcopReportRepository.setOverseasManufacturerId(overseasManufacturerId);
	}

	/**
	* Sets the overseas manufacturer name of this vrcop report repository.
	*
	* @param overseasManufacturerName the overseas manufacturer name of this vrcop report repository
	*/
	@Override
	public void setOverseasManufacturerName(
		java.lang.String overseasManufacturerName) {
		_vrcopReportRepository.setOverseasManufacturerName(overseasManufacturerName);
	}

	/**
	* Sets the primary key of this vrcop report repository.
	*
	* @param primaryKey the primary key of this vrcop report repository
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vrcopReportRepository.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_vrcopReportRepository.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the production plant address of this vrcop report repository.
	*
	* @param productionPlantAddress the production plant address of this vrcop report repository
	*/
	@Override
	public void setProductionPlantAddress(
		java.lang.String productionPlantAddress) {
		_vrcopReportRepository.setProductionPlantAddress(productionPlantAddress);
	}

	/**
	* Sets the production plant code of this vrcop report repository.
	*
	* @param productionPlantCode the production plant code of this vrcop report repository
	*/
	@Override
	public void setProductionPlantCode(java.lang.String productionPlantCode) {
		_vrcopReportRepository.setProductionPlantCode(productionPlantCode);
	}

	/**
	* Sets the production plant ID of this vrcop report repository.
	*
	* @param productionPlantId the production plant ID of this vrcop report repository
	*/
	@Override
	public void setProductionPlantId(long productionPlantId) {
		_vrcopReportRepository.setProductionPlantId(productionPlantId);
	}

	/**
	* Sets the production plant name of this vrcop report repository.
	*
	* @param productionPlantName the production plant name of this vrcop report repository
	*/
	@Override
	public void setProductionPlantName(java.lang.String productionPlantName) {
		_vrcopReportRepository.setProductionPlantName(productionPlantName);
	}

	/**
	* Sets the sync date of this vrcop report repository.
	*
	* @param syncDate the sync date of this vrcop report repository
	*/
	@Override
	public void setSyncDate(Date syncDate) {
		_vrcopReportRepository.setSyncDate(syncDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRCOPReportRepositoryWrapper)) {
			return false;
		}

		VRCOPReportRepositoryWrapper vrcopReportRepositoryWrapper = (VRCOPReportRepositoryWrapper)obj;

		if (Objects.equals(_vrcopReportRepository,
					vrcopReportRepositoryWrapper._vrcopReportRepository)) {
			return true;
		}

		return false;
	}

	@Override
	public VRCOPReportRepository getWrappedModel() {
		return _vrcopReportRepository;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _vrcopReportRepository.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _vrcopReportRepository.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_vrcopReportRepository.resetOriginalValues();
	}

	private final VRCOPReportRepository _vrcopReportRepository;
}