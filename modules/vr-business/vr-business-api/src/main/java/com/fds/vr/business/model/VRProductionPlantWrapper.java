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
 * This class is a wrapper for {@link VRProductionPlant}.
 * </p>
 *
 * @author LamTV
 * @see VRProductionPlant
 * @generated
 */
@ProviderType
public class VRProductionPlantWrapper implements VRProductionPlant,
	ModelWrapper<VRProductionPlant> {
	public VRProductionPlantWrapper(VRProductionPlant vrProductionPlant) {
		_vrProductionPlant = vrProductionPlant;
	}

	@Override
	public Class<?> getModelClass() {
		return VRProductionPlant.class;
	}

	@Override
	public String getModelClassName() {
		return VRProductionPlant.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("mtCore", getMtCore());
		attributes.put("mappingMA_CTY", getMappingMA_CTY());
		attributes.put("mappingTEN_CTY", getMappingTEN_CTY());
		attributes.put("mappingDIA_CHI_CTY", getMappingDIA_CHI_CTY());
		attributes.put("mappingMA_XUONG_LR", getMappingMA_XUONG_LR());
		attributes.put("mappingTEN_XUONG_LR", getMappingTEN_XUONG_LR());
		attributes.put("mappingDIA_CHI_XUONG_LR", getMappingDIA_CHI_XUONG_LR());
		attributes.put("mappingNote", getMappingNote());
		attributes.put("mappingStatus", getMappingStatus());
		attributes.put("productionPlantCode", getProductionPlantCode());
		attributes.put("productionPlantName", getProductionPlantName());
		attributes.put("productionPlantAddress", getProductionPlantAddress());
		attributes.put("productionPlantStateCode", getProductionPlantStateCode());
		attributes.put("productionPlantStateName", getProductionPlantStateName());
		attributes.put("productionPlantProvinceCode",
			getProductionPlantProvinceCode());
		attributes.put("productionPlantProvinceName",
			getProductionPlantProvinceName());
		attributes.put("productionPlantDistrictCode",
			getProductionPlantDistrictCode());
		attributes.put("productionPlantDistrictName",
			getProductionPlantDistrictName());
		attributes.put("productionPlantEmail", getProductionPlantEmail());
		attributes.put("productionPlantPhone", getProductionPlantPhone());
		attributes.put("productionPlantFax", getProductionPlantFax());
		attributes.put("productionPlantRepresentative",
			getProductionPlantRepresentative());
		attributes.put("productionPlantRepresentativeTitle",
			getProductionPlantRepresentativeTitle());
		attributes.put("productionPlantContactName",
			getProductionPlantContactName());
		attributes.put("productionPlantContactEmail",
			getProductionPlantContactEmail());
		attributes.put("productionPlantContactPhone",
			getProductionPlantContactPhone());
		attributes.put("productionPlantType", getProductionPlantType());
		attributes.put("productionPlantStatus", getProductionPlantStatus());
		attributes.put("productionPlantEmployeesNote",
			getProductionPlantEmployeesNote());
		attributes.put("productionPlantEquipmentsNote",
			getProductionPlantEquipmentsNote());
		attributes.put("productionPlantProdEquipmentsNote",
			getProductionPlantProdEquipmentsNote());
		attributes.put("registrationId", getRegistrationId());
		attributes.put("applicantProfileId", getApplicantProfileId());
		attributes.put("latestCOPReportDate", getLatestCOPReportDate());
		attributes.put("latestCOPReportResult", getLatestCOPReportResult());
		attributes.put("nextCOPReportDate", getNextCOPReportDate());
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

		String mappingMA_CTY = (String)attributes.get("mappingMA_CTY");

		if (mappingMA_CTY != null) {
			setMappingMA_CTY(mappingMA_CTY);
		}

		String mappingTEN_CTY = (String)attributes.get("mappingTEN_CTY");

		if (mappingTEN_CTY != null) {
			setMappingTEN_CTY(mappingTEN_CTY);
		}

		String mappingDIA_CHI_CTY = (String)attributes.get("mappingDIA_CHI_CTY");

		if (mappingDIA_CHI_CTY != null) {
			setMappingDIA_CHI_CTY(mappingDIA_CHI_CTY);
		}

		String mappingMA_XUONG_LR = (String)attributes.get("mappingMA_XUONG_LR");

		if (mappingMA_XUONG_LR != null) {
			setMappingMA_XUONG_LR(mappingMA_XUONG_LR);
		}

		String mappingTEN_XUONG_LR = (String)attributes.get(
				"mappingTEN_XUONG_LR");

		if (mappingTEN_XUONG_LR != null) {
			setMappingTEN_XUONG_LR(mappingTEN_XUONG_LR);
		}

		String mappingDIA_CHI_XUONG_LR = (String)attributes.get(
				"mappingDIA_CHI_XUONG_LR");

		if (mappingDIA_CHI_XUONG_LR != null) {
			setMappingDIA_CHI_XUONG_LR(mappingDIA_CHI_XUONG_LR);
		}

		String mappingNote = (String)attributes.get("mappingNote");

		if (mappingNote != null) {
			setMappingNote(mappingNote);
		}

		String mappingStatus = (String)attributes.get("mappingStatus");

		if (mappingStatus != null) {
			setMappingStatus(mappingStatus);
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

		String productionPlantStateCode = (String)attributes.get(
				"productionPlantStateCode");

		if (productionPlantStateCode != null) {
			setProductionPlantStateCode(productionPlantStateCode);
		}

		String productionPlantStateName = (String)attributes.get(
				"productionPlantStateName");

		if (productionPlantStateName != null) {
			setProductionPlantStateName(productionPlantStateName);
		}

		String productionPlantProvinceCode = (String)attributes.get(
				"productionPlantProvinceCode");

		if (productionPlantProvinceCode != null) {
			setProductionPlantProvinceCode(productionPlantProvinceCode);
		}

		String productionPlantProvinceName = (String)attributes.get(
				"productionPlantProvinceName");

		if (productionPlantProvinceName != null) {
			setProductionPlantProvinceName(productionPlantProvinceName);
		}

		String productionPlantDistrictCode = (String)attributes.get(
				"productionPlantDistrictCode");

		if (productionPlantDistrictCode != null) {
			setProductionPlantDistrictCode(productionPlantDistrictCode);
		}

		String productionPlantDistrictName = (String)attributes.get(
				"productionPlantDistrictName");

		if (productionPlantDistrictName != null) {
			setProductionPlantDistrictName(productionPlantDistrictName);
		}

		String productionPlantEmail = (String)attributes.get(
				"productionPlantEmail");

		if (productionPlantEmail != null) {
			setProductionPlantEmail(productionPlantEmail);
		}

		String productionPlantPhone = (String)attributes.get(
				"productionPlantPhone");

		if (productionPlantPhone != null) {
			setProductionPlantPhone(productionPlantPhone);
		}

		String productionPlantFax = (String)attributes.get("productionPlantFax");

		if (productionPlantFax != null) {
			setProductionPlantFax(productionPlantFax);
		}

		String productionPlantRepresentative = (String)attributes.get(
				"productionPlantRepresentative");

		if (productionPlantRepresentative != null) {
			setProductionPlantRepresentative(productionPlantRepresentative);
		}

		String productionPlantRepresentativeTitle = (String)attributes.get(
				"productionPlantRepresentativeTitle");

		if (productionPlantRepresentativeTitle != null) {
			setProductionPlantRepresentativeTitle(productionPlantRepresentativeTitle);
		}

		String productionPlantContactName = (String)attributes.get(
				"productionPlantContactName");

		if (productionPlantContactName != null) {
			setProductionPlantContactName(productionPlantContactName);
		}

		String productionPlantContactEmail = (String)attributes.get(
				"productionPlantContactEmail");

		if (productionPlantContactEmail != null) {
			setProductionPlantContactEmail(productionPlantContactEmail);
		}

		String productionPlantContactPhone = (String)attributes.get(
				"productionPlantContactPhone");

		if (productionPlantContactPhone != null) {
			setProductionPlantContactPhone(productionPlantContactPhone);
		}

		String productionPlantType = (String)attributes.get(
				"productionPlantType");

		if (productionPlantType != null) {
			setProductionPlantType(productionPlantType);
		}

		String productionPlantStatus = (String)attributes.get(
				"productionPlantStatus");

		if (productionPlantStatus != null) {
			setProductionPlantStatus(productionPlantStatus);
		}

		String productionPlantEmployeesNote = (String)attributes.get(
				"productionPlantEmployeesNote");

		if (productionPlantEmployeesNote != null) {
			setProductionPlantEmployeesNote(productionPlantEmployeesNote);
		}

		String productionPlantEquipmentsNote = (String)attributes.get(
				"productionPlantEquipmentsNote");

		if (productionPlantEquipmentsNote != null) {
			setProductionPlantEquipmentsNote(productionPlantEquipmentsNote);
		}

		String productionPlantProdEquipmentsNote = (String)attributes.get(
				"productionPlantProdEquipmentsNote");

		if (productionPlantProdEquipmentsNote != null) {
			setProductionPlantProdEquipmentsNote(productionPlantProdEquipmentsNote);
		}

		Long registrationId = (Long)attributes.get("registrationId");

		if (registrationId != null) {
			setRegistrationId(registrationId);
		}

		Long applicantProfileId = (Long)attributes.get("applicantProfileId");

		if (applicantProfileId != null) {
			setApplicantProfileId(applicantProfileId);
		}

		Date latestCOPReportDate = (Date)attributes.get("latestCOPReportDate");

		if (latestCOPReportDate != null) {
			setLatestCOPReportDate(latestCOPReportDate);
		}

		String latestCOPReportResult = (String)attributes.get(
				"latestCOPReportResult");

		if (latestCOPReportResult != null) {
			setLatestCOPReportResult(latestCOPReportResult);
		}

		Date nextCOPReportDate = (Date)attributes.get("nextCOPReportDate");

		if (nextCOPReportDate != null) {
			setNextCOPReportDate(nextCOPReportDate);
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
	public VRProductionPlant toEscapedModel() {
		return new VRProductionPlantWrapper(_vrProductionPlant.toEscapedModel());
	}

	@Override
	public VRProductionPlant toUnescapedModel() {
		return new VRProductionPlantWrapper(_vrProductionPlant.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _vrProductionPlant.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _vrProductionPlant.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _vrProductionPlant.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _vrProductionPlant.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<VRProductionPlant> toCacheModel() {
		return _vrProductionPlant.toCacheModel();
	}

	@Override
	public int compareTo(VRProductionPlant vrProductionPlant) {
		return _vrProductionPlant.compareTo(vrProductionPlant);
	}

	@Override
	public int hashCode() {
		return _vrProductionPlant.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vrProductionPlant.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new VRProductionPlantWrapper((VRProductionPlant)_vrProductionPlant.clone());
	}

	/**
	* Returns the latest cop report result of this vr production plant.
	*
	* @return the latest cop report result of this vr production plant
	*/
	@Override
	public java.lang.String getLatestCOPReportResult() {
		return _vrProductionPlant.getLatestCOPReportResult();
	}

	/**
	* Returns the mapping dia_chi_cty of this vr production plant.
	*
	* @return the mapping dia_chi_cty of this vr production plant
	*/
	@Override
	public java.lang.String getMappingDIA_CHI_CTY() {
		return _vrProductionPlant.getMappingDIA_CHI_CTY();
	}

	/**
	* Returns the mapping dia_chi_xuong_lr of this vr production plant.
	*
	* @return the mapping dia_chi_xuong_lr of this vr production plant
	*/
	@Override
	public java.lang.String getMappingDIA_CHI_XUONG_LR() {
		return _vrProductionPlant.getMappingDIA_CHI_XUONG_LR();
	}

	/**
	* Returns the mapping ma_cty of this vr production plant.
	*
	* @return the mapping ma_cty of this vr production plant
	*/
	@Override
	public java.lang.String getMappingMA_CTY() {
		return _vrProductionPlant.getMappingMA_CTY();
	}

	/**
	* Returns the mapping ma_xuong_lr of this vr production plant.
	*
	* @return the mapping ma_xuong_lr of this vr production plant
	*/
	@Override
	public java.lang.String getMappingMA_XUONG_LR() {
		return _vrProductionPlant.getMappingMA_XUONG_LR();
	}

	/**
	* Returns the mapping note of this vr production plant.
	*
	* @return the mapping note of this vr production plant
	*/
	@Override
	public java.lang.String getMappingNote() {
		return _vrProductionPlant.getMappingNote();
	}

	/**
	* Returns the mapping status of this vr production plant.
	*
	* @return the mapping status of this vr production plant
	*/
	@Override
	public java.lang.String getMappingStatus() {
		return _vrProductionPlant.getMappingStatus();
	}

	/**
	* Returns the mapping ten_cty of this vr production plant.
	*
	* @return the mapping ten_cty of this vr production plant
	*/
	@Override
	public java.lang.String getMappingTEN_CTY() {
		return _vrProductionPlant.getMappingTEN_CTY();
	}

	/**
	* Returns the mapping ten_xuong_lr of this vr production plant.
	*
	* @return the mapping ten_xuong_lr of this vr production plant
	*/
	@Override
	public java.lang.String getMappingTEN_XUONG_LR() {
		return _vrProductionPlant.getMappingTEN_XUONG_LR();
	}

	/**
	* Returns the production plant address of this vr production plant.
	*
	* @return the production plant address of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantAddress() {
		return _vrProductionPlant.getProductionPlantAddress();
	}

	/**
	* Returns the production plant code of this vr production plant.
	*
	* @return the production plant code of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantCode() {
		return _vrProductionPlant.getProductionPlantCode();
	}

	/**
	* Returns the production plant contact email of this vr production plant.
	*
	* @return the production plant contact email of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantContactEmail() {
		return _vrProductionPlant.getProductionPlantContactEmail();
	}

	/**
	* Returns the production plant contact name of this vr production plant.
	*
	* @return the production plant contact name of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantContactName() {
		return _vrProductionPlant.getProductionPlantContactName();
	}

	/**
	* Returns the production plant contact phone of this vr production plant.
	*
	* @return the production plant contact phone of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantContactPhone() {
		return _vrProductionPlant.getProductionPlantContactPhone();
	}

	/**
	* Returns the production plant district code of this vr production plant.
	*
	* @return the production plant district code of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantDistrictCode() {
		return _vrProductionPlant.getProductionPlantDistrictCode();
	}

	/**
	* Returns the production plant district name of this vr production plant.
	*
	* @return the production plant district name of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantDistrictName() {
		return _vrProductionPlant.getProductionPlantDistrictName();
	}

	/**
	* Returns the production plant email of this vr production plant.
	*
	* @return the production plant email of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantEmail() {
		return _vrProductionPlant.getProductionPlantEmail();
	}

	/**
	* Returns the production plant employees note of this vr production plant.
	*
	* @return the production plant employees note of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantEmployeesNote() {
		return _vrProductionPlant.getProductionPlantEmployeesNote();
	}

	/**
	* Returns the production plant equipments note of this vr production plant.
	*
	* @return the production plant equipments note of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantEquipmentsNote() {
		return _vrProductionPlant.getProductionPlantEquipmentsNote();
	}

	/**
	* Returns the production plant fax of this vr production plant.
	*
	* @return the production plant fax of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantFax() {
		return _vrProductionPlant.getProductionPlantFax();
	}

	/**
	* Returns the production plant name of this vr production plant.
	*
	* @return the production plant name of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantName() {
		return _vrProductionPlant.getProductionPlantName();
	}

	/**
	* Returns the production plant phone of this vr production plant.
	*
	* @return the production plant phone of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantPhone() {
		return _vrProductionPlant.getProductionPlantPhone();
	}

	/**
	* Returns the production plant prod equipments note of this vr production plant.
	*
	* @return the production plant prod equipments note of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantProdEquipmentsNote() {
		return _vrProductionPlant.getProductionPlantProdEquipmentsNote();
	}

	/**
	* Returns the production plant province code of this vr production plant.
	*
	* @return the production plant province code of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantProvinceCode() {
		return _vrProductionPlant.getProductionPlantProvinceCode();
	}

	/**
	* Returns the production plant province name of this vr production plant.
	*
	* @return the production plant province name of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantProvinceName() {
		return _vrProductionPlant.getProductionPlantProvinceName();
	}

	/**
	* Returns the production plant representative of this vr production plant.
	*
	* @return the production plant representative of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantRepresentative() {
		return _vrProductionPlant.getProductionPlantRepresentative();
	}

	/**
	* Returns the production plant representative title of this vr production plant.
	*
	* @return the production plant representative title of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantRepresentativeTitle() {
		return _vrProductionPlant.getProductionPlantRepresentativeTitle();
	}

	/**
	* Returns the production plant state code of this vr production plant.
	*
	* @return the production plant state code of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantStateCode() {
		return _vrProductionPlant.getProductionPlantStateCode();
	}

	/**
	* Returns the production plant state name of this vr production plant.
	*
	* @return the production plant state name of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantStateName() {
		return _vrProductionPlant.getProductionPlantStateName();
	}

	/**
	* Returns the production plant status of this vr production plant.
	*
	* @return the production plant status of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantStatus() {
		return _vrProductionPlant.getProductionPlantStatus();
	}

	/**
	* Returns the production plant type of this vr production plant.
	*
	* @return the production plant type of this vr production plant
	*/
	@Override
	public java.lang.String getProductionPlantType() {
		return _vrProductionPlant.getProductionPlantType();
	}

	@Override
	public java.lang.String toString() {
		return _vrProductionPlant.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vrProductionPlant.toXmlString();
	}

	/**
	* Returns the latest cop report date of this vr production plant.
	*
	* @return the latest cop report date of this vr production plant
	*/
	@Override
	public Date getLatestCOPReportDate() {
		return _vrProductionPlant.getLatestCOPReportDate();
	}

	/**
	* Returns the modify date of this vr production plant.
	*
	* @return the modify date of this vr production plant
	*/
	@Override
	public Date getModifyDate() {
		return _vrProductionPlant.getModifyDate();
	}

	/**
	* Returns the next cop report date of this vr production plant.
	*
	* @return the next cop report date of this vr production plant
	*/
	@Override
	public Date getNextCOPReportDate() {
		return _vrProductionPlant.getNextCOPReportDate();
	}

	/**
	* Returns the sync date of this vr production plant.
	*
	* @return the sync date of this vr production plant
	*/
	@Override
	public Date getSyncDate() {
		return _vrProductionPlant.getSyncDate();
	}

	/**
	* Returns the applicant profile ID of this vr production plant.
	*
	* @return the applicant profile ID of this vr production plant
	*/
	@Override
	public long getApplicantProfileId() {
		return _vrProductionPlant.getApplicantProfileId();
	}

	/**
	* Returns the ID of this vr production plant.
	*
	* @return the ID of this vr production plant
	*/
	@Override
	public long getId() {
		return _vrProductionPlant.getId();
	}

	/**
	* Returns the mt core of this vr production plant.
	*
	* @return the mt core of this vr production plant
	*/
	@Override
	public long getMtCore() {
		return _vrProductionPlant.getMtCore();
	}

	/**
	* Returns the primary key of this vr production plant.
	*
	* @return the primary key of this vr production plant
	*/
	@Override
	public long getPrimaryKey() {
		return _vrProductionPlant.getPrimaryKey();
	}

	/**
	* Returns the registration ID of this vr production plant.
	*
	* @return the registration ID of this vr production plant
	*/
	@Override
	public long getRegistrationId() {
		return _vrProductionPlant.getRegistrationId();
	}

	@Override
	public void persist() {
		_vrProductionPlant.persist();
	}

	/**
	* Sets the applicant profile ID of this vr production plant.
	*
	* @param applicantProfileId the applicant profile ID of this vr production plant
	*/
	@Override
	public void setApplicantProfileId(long applicantProfileId) {
		_vrProductionPlant.setApplicantProfileId(applicantProfileId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vrProductionPlant.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_vrProductionPlant.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_vrProductionPlant.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_vrProductionPlant.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this vr production plant.
	*
	* @param id the ID of this vr production plant
	*/
	@Override
	public void setId(long id) {
		_vrProductionPlant.setId(id);
	}

	/**
	* Sets the latest cop report date of this vr production plant.
	*
	* @param latestCOPReportDate the latest cop report date of this vr production plant
	*/
	@Override
	public void setLatestCOPReportDate(Date latestCOPReportDate) {
		_vrProductionPlant.setLatestCOPReportDate(latestCOPReportDate);
	}

	/**
	* Sets the latest cop report result of this vr production plant.
	*
	* @param latestCOPReportResult the latest cop report result of this vr production plant
	*/
	@Override
	public void setLatestCOPReportResult(java.lang.String latestCOPReportResult) {
		_vrProductionPlant.setLatestCOPReportResult(latestCOPReportResult);
	}

	/**
	* Sets the mapping dia_chi_cty of this vr production plant.
	*
	* @param mappingDIA_CHI_CTY the mapping dia_chi_cty of this vr production plant
	*/
	@Override
	public void setMappingDIA_CHI_CTY(java.lang.String mappingDIA_CHI_CTY) {
		_vrProductionPlant.setMappingDIA_CHI_CTY(mappingDIA_CHI_CTY);
	}

	/**
	* Sets the mapping dia_chi_xuong_lr of this vr production plant.
	*
	* @param mappingDIA_CHI_XUONG_LR the mapping dia_chi_xuong_lr of this vr production plant
	*/
	@Override
	public void setMappingDIA_CHI_XUONG_LR(
		java.lang.String mappingDIA_CHI_XUONG_LR) {
		_vrProductionPlant.setMappingDIA_CHI_XUONG_LR(mappingDIA_CHI_XUONG_LR);
	}

	/**
	* Sets the mapping ma_cty of this vr production plant.
	*
	* @param mappingMA_CTY the mapping ma_cty of this vr production plant
	*/
	@Override
	public void setMappingMA_CTY(java.lang.String mappingMA_CTY) {
		_vrProductionPlant.setMappingMA_CTY(mappingMA_CTY);
	}

	/**
	* Sets the mapping ma_xuong_lr of this vr production plant.
	*
	* @param mappingMA_XUONG_LR the mapping ma_xuong_lr of this vr production plant
	*/
	@Override
	public void setMappingMA_XUONG_LR(java.lang.String mappingMA_XUONG_LR) {
		_vrProductionPlant.setMappingMA_XUONG_LR(mappingMA_XUONG_LR);
	}

	/**
	* Sets the mapping note of this vr production plant.
	*
	* @param mappingNote the mapping note of this vr production plant
	*/
	@Override
	public void setMappingNote(java.lang.String mappingNote) {
		_vrProductionPlant.setMappingNote(mappingNote);
	}

	/**
	* Sets the mapping status of this vr production plant.
	*
	* @param mappingStatus the mapping status of this vr production plant
	*/
	@Override
	public void setMappingStatus(java.lang.String mappingStatus) {
		_vrProductionPlant.setMappingStatus(mappingStatus);
	}

	/**
	* Sets the mapping ten_cty of this vr production plant.
	*
	* @param mappingTEN_CTY the mapping ten_cty of this vr production plant
	*/
	@Override
	public void setMappingTEN_CTY(java.lang.String mappingTEN_CTY) {
		_vrProductionPlant.setMappingTEN_CTY(mappingTEN_CTY);
	}

	/**
	* Sets the mapping ten_xuong_lr of this vr production plant.
	*
	* @param mappingTEN_XUONG_LR the mapping ten_xuong_lr of this vr production plant
	*/
	@Override
	public void setMappingTEN_XUONG_LR(java.lang.String mappingTEN_XUONG_LR) {
		_vrProductionPlant.setMappingTEN_XUONG_LR(mappingTEN_XUONG_LR);
	}

	/**
	* Sets the modify date of this vr production plant.
	*
	* @param modifyDate the modify date of this vr production plant
	*/
	@Override
	public void setModifyDate(Date modifyDate) {
		_vrProductionPlant.setModifyDate(modifyDate);
	}

	/**
	* Sets the mt core of this vr production plant.
	*
	* @param mtCore the mt core of this vr production plant
	*/
	@Override
	public void setMtCore(long mtCore) {
		_vrProductionPlant.setMtCore(mtCore);
	}

	@Override
	public void setNew(boolean n) {
		_vrProductionPlant.setNew(n);
	}

	/**
	* Sets the next cop report date of this vr production plant.
	*
	* @param nextCOPReportDate the next cop report date of this vr production plant
	*/
	@Override
	public void setNextCOPReportDate(Date nextCOPReportDate) {
		_vrProductionPlant.setNextCOPReportDate(nextCOPReportDate);
	}

	/**
	* Sets the primary key of this vr production plant.
	*
	* @param primaryKey the primary key of this vr production plant
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vrProductionPlant.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_vrProductionPlant.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the production plant address of this vr production plant.
	*
	* @param productionPlantAddress the production plant address of this vr production plant
	*/
	@Override
	public void setProductionPlantAddress(
		java.lang.String productionPlantAddress) {
		_vrProductionPlant.setProductionPlantAddress(productionPlantAddress);
	}

	/**
	* Sets the production plant code of this vr production plant.
	*
	* @param productionPlantCode the production plant code of this vr production plant
	*/
	@Override
	public void setProductionPlantCode(java.lang.String productionPlantCode) {
		_vrProductionPlant.setProductionPlantCode(productionPlantCode);
	}

	/**
	* Sets the production plant contact email of this vr production plant.
	*
	* @param productionPlantContactEmail the production plant contact email of this vr production plant
	*/
	@Override
	public void setProductionPlantContactEmail(
		java.lang.String productionPlantContactEmail) {
		_vrProductionPlant.setProductionPlantContactEmail(productionPlantContactEmail);
	}

	/**
	* Sets the production plant contact name of this vr production plant.
	*
	* @param productionPlantContactName the production plant contact name of this vr production plant
	*/
	@Override
	public void setProductionPlantContactName(
		java.lang.String productionPlantContactName) {
		_vrProductionPlant.setProductionPlantContactName(productionPlantContactName);
	}

	/**
	* Sets the production plant contact phone of this vr production plant.
	*
	* @param productionPlantContactPhone the production plant contact phone of this vr production plant
	*/
	@Override
	public void setProductionPlantContactPhone(
		java.lang.String productionPlantContactPhone) {
		_vrProductionPlant.setProductionPlantContactPhone(productionPlantContactPhone);
	}

	/**
	* Sets the production plant district code of this vr production plant.
	*
	* @param productionPlantDistrictCode the production plant district code of this vr production plant
	*/
	@Override
	public void setProductionPlantDistrictCode(
		java.lang.String productionPlantDistrictCode) {
		_vrProductionPlant.setProductionPlantDistrictCode(productionPlantDistrictCode);
	}

	/**
	* Sets the production plant district name of this vr production plant.
	*
	* @param productionPlantDistrictName the production plant district name of this vr production plant
	*/
	@Override
	public void setProductionPlantDistrictName(
		java.lang.String productionPlantDistrictName) {
		_vrProductionPlant.setProductionPlantDistrictName(productionPlantDistrictName);
	}

	/**
	* Sets the production plant email of this vr production plant.
	*
	* @param productionPlantEmail the production plant email of this vr production plant
	*/
	@Override
	public void setProductionPlantEmail(java.lang.String productionPlantEmail) {
		_vrProductionPlant.setProductionPlantEmail(productionPlantEmail);
	}

	/**
	* Sets the production plant employees note of this vr production plant.
	*
	* @param productionPlantEmployeesNote the production plant employees note of this vr production plant
	*/
	@Override
	public void setProductionPlantEmployeesNote(
		java.lang.String productionPlantEmployeesNote) {
		_vrProductionPlant.setProductionPlantEmployeesNote(productionPlantEmployeesNote);
	}

	/**
	* Sets the production plant equipments note of this vr production plant.
	*
	* @param productionPlantEquipmentsNote the production plant equipments note of this vr production plant
	*/
	@Override
	public void setProductionPlantEquipmentsNote(
		java.lang.String productionPlantEquipmentsNote) {
		_vrProductionPlant.setProductionPlantEquipmentsNote(productionPlantEquipmentsNote);
	}

	/**
	* Sets the production plant fax of this vr production plant.
	*
	* @param productionPlantFax the production plant fax of this vr production plant
	*/
	@Override
	public void setProductionPlantFax(java.lang.String productionPlantFax) {
		_vrProductionPlant.setProductionPlantFax(productionPlantFax);
	}

	/**
	* Sets the production plant name of this vr production plant.
	*
	* @param productionPlantName the production plant name of this vr production plant
	*/
	@Override
	public void setProductionPlantName(java.lang.String productionPlantName) {
		_vrProductionPlant.setProductionPlantName(productionPlantName);
	}

	/**
	* Sets the production plant phone of this vr production plant.
	*
	* @param productionPlantPhone the production plant phone of this vr production plant
	*/
	@Override
	public void setProductionPlantPhone(java.lang.String productionPlantPhone) {
		_vrProductionPlant.setProductionPlantPhone(productionPlantPhone);
	}

	/**
	* Sets the production plant prod equipments note of this vr production plant.
	*
	* @param productionPlantProdEquipmentsNote the production plant prod equipments note of this vr production plant
	*/
	@Override
	public void setProductionPlantProdEquipmentsNote(
		java.lang.String productionPlantProdEquipmentsNote) {
		_vrProductionPlant.setProductionPlantProdEquipmentsNote(productionPlantProdEquipmentsNote);
	}

	/**
	* Sets the production plant province code of this vr production plant.
	*
	* @param productionPlantProvinceCode the production plant province code of this vr production plant
	*/
	@Override
	public void setProductionPlantProvinceCode(
		java.lang.String productionPlantProvinceCode) {
		_vrProductionPlant.setProductionPlantProvinceCode(productionPlantProvinceCode);
	}

	/**
	* Sets the production plant province name of this vr production plant.
	*
	* @param productionPlantProvinceName the production plant province name of this vr production plant
	*/
	@Override
	public void setProductionPlantProvinceName(
		java.lang.String productionPlantProvinceName) {
		_vrProductionPlant.setProductionPlantProvinceName(productionPlantProvinceName);
	}

	/**
	* Sets the production plant representative of this vr production plant.
	*
	* @param productionPlantRepresentative the production plant representative of this vr production plant
	*/
	@Override
	public void setProductionPlantRepresentative(
		java.lang.String productionPlantRepresentative) {
		_vrProductionPlant.setProductionPlantRepresentative(productionPlantRepresentative);
	}

	/**
	* Sets the production plant representative title of this vr production plant.
	*
	* @param productionPlantRepresentativeTitle the production plant representative title of this vr production plant
	*/
	@Override
	public void setProductionPlantRepresentativeTitle(
		java.lang.String productionPlantRepresentativeTitle) {
		_vrProductionPlant.setProductionPlantRepresentativeTitle(productionPlantRepresentativeTitle);
	}

	/**
	* Sets the production plant state code of this vr production plant.
	*
	* @param productionPlantStateCode the production plant state code of this vr production plant
	*/
	@Override
	public void setProductionPlantStateCode(
		java.lang.String productionPlantStateCode) {
		_vrProductionPlant.setProductionPlantStateCode(productionPlantStateCode);
	}

	/**
	* Sets the production plant state name of this vr production plant.
	*
	* @param productionPlantStateName the production plant state name of this vr production plant
	*/
	@Override
	public void setProductionPlantStateName(
		java.lang.String productionPlantStateName) {
		_vrProductionPlant.setProductionPlantStateName(productionPlantStateName);
	}

	/**
	* Sets the production plant status of this vr production plant.
	*
	* @param productionPlantStatus the production plant status of this vr production plant
	*/
	@Override
	public void setProductionPlantStatus(java.lang.String productionPlantStatus) {
		_vrProductionPlant.setProductionPlantStatus(productionPlantStatus);
	}

	/**
	* Sets the production plant type of this vr production plant.
	*
	* @param productionPlantType the production plant type of this vr production plant
	*/
	@Override
	public void setProductionPlantType(java.lang.String productionPlantType) {
		_vrProductionPlant.setProductionPlantType(productionPlantType);
	}

	/**
	* Sets the registration ID of this vr production plant.
	*
	* @param registrationId the registration ID of this vr production plant
	*/
	@Override
	public void setRegistrationId(long registrationId) {
		_vrProductionPlant.setRegistrationId(registrationId);
	}

	/**
	* Sets the sync date of this vr production plant.
	*
	* @param syncDate the sync date of this vr production plant
	*/
	@Override
	public void setSyncDate(Date syncDate) {
		_vrProductionPlant.setSyncDate(syncDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRProductionPlantWrapper)) {
			return false;
		}

		VRProductionPlantWrapper vrProductionPlantWrapper = (VRProductionPlantWrapper)obj;

		if (Objects.equals(_vrProductionPlant,
					vrProductionPlantWrapper._vrProductionPlant)) {
			return true;
		}

		return false;
	}

	@Override
	public VRProductionPlant getWrappedModel() {
		return _vrProductionPlant;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _vrProductionPlant.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _vrProductionPlant.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_vrProductionPlant.resetOriginalValues();
	}

	private final VRProductionPlant _vrProductionPlant;
}