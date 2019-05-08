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
 * This class is a wrapper for {@link VRCOPProductType}.
 * </p>
 *
 * @author LamTV
 * @see VRCOPProductType
 * @generated
 */
@ProviderType
public class VRCOPProductTypeWrapper implements VRCOPProductType,
	ModelWrapper<VRCOPProductType> {
	public VRCOPProductTypeWrapper(VRCOPProductType vrcopProductType) {
		_vrcopProductType = vrcopProductType;
	}

	@Override
	public Class<?> getModelClass() {
		return VRCOPProductType.class;
	}

	@Override
	public String getModelClassName() {
		return VRCOPProductType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("mtCore", getMtCore());
		attributes.put("copReportRepositoryID", getCopReportRepositoryID());
		attributes.put("copReportNo", getCopReportNo());
		attributes.put("sequenceNo", getSequenceNo());
		attributes.put("vehicleClass", getVehicleClass());
		attributes.put("vehicleTypeCode", getVehicleTypeCode());
		attributes.put("vehicleTypeDescription", getVehicleTypeDescription());
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

		Long copReportRepositoryID = (Long)attributes.get(
				"copReportRepositoryID");

		if (copReportRepositoryID != null) {
			setCopReportRepositoryID(copReportRepositoryID);
		}

		String copReportNo = (String)attributes.get("copReportNo");

		if (copReportNo != null) {
			setCopReportNo(copReportNo);
		}

		Long sequenceNo = (Long)attributes.get("sequenceNo");

		if (sequenceNo != null) {
			setSequenceNo(sequenceNo);
		}

		String vehicleClass = (String)attributes.get("vehicleClass");

		if (vehicleClass != null) {
			setVehicleClass(vehicleClass);
		}

		String vehicleTypeCode = (String)attributes.get("vehicleTypeCode");

		if (vehicleTypeCode != null) {
			setVehicleTypeCode(vehicleTypeCode);
		}

		String vehicleTypeDescription = (String)attributes.get(
				"vehicleTypeDescription");

		if (vehicleTypeDescription != null) {
			setVehicleTypeDescription(vehicleTypeDescription);
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
	public VRCOPProductType toEscapedModel() {
		return new VRCOPProductTypeWrapper(_vrcopProductType.toEscapedModel());
	}

	@Override
	public VRCOPProductType toUnescapedModel() {
		return new VRCOPProductTypeWrapper(_vrcopProductType.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _vrcopProductType.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _vrcopProductType.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _vrcopProductType.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _vrcopProductType.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<VRCOPProductType> toCacheModel() {
		return _vrcopProductType.toCacheModel();
	}

	@Override
	public int compareTo(VRCOPProductType vrcopProductType) {
		return _vrcopProductType.compareTo(vrcopProductType);
	}

	@Override
	public int hashCode() {
		return _vrcopProductType.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vrcopProductType.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new VRCOPProductTypeWrapper((VRCOPProductType)_vrcopProductType.clone());
	}

	/**
	* Returns the cop report no of this vrcop product type.
	*
	* @return the cop report no of this vrcop product type
	*/
	@Override
	public java.lang.String getCopReportNo() {
		return _vrcopProductType.getCopReportNo();
	}

	/**
	* Returns the vehicle class of this vrcop product type.
	*
	* @return the vehicle class of this vrcop product type
	*/
	@Override
	public java.lang.String getVehicleClass() {
		return _vrcopProductType.getVehicleClass();
	}

	/**
	* Returns the vehicle type code of this vrcop product type.
	*
	* @return the vehicle type code of this vrcop product type
	*/
	@Override
	public java.lang.String getVehicleTypeCode() {
		return _vrcopProductType.getVehicleTypeCode();
	}

	/**
	* Returns the vehicle type description of this vrcop product type.
	*
	* @return the vehicle type description of this vrcop product type
	*/
	@Override
	public java.lang.String getVehicleTypeDescription() {
		return _vrcopProductType.getVehicleTypeDescription();
	}

	@Override
	public java.lang.String toString() {
		return _vrcopProductType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vrcopProductType.toXmlString();
	}

	/**
	* Returns the modify date of this vrcop product type.
	*
	* @return the modify date of this vrcop product type
	*/
	@Override
	public Date getModifyDate() {
		return _vrcopProductType.getModifyDate();
	}

	/**
	* Returns the sync date of this vrcop product type.
	*
	* @return the sync date of this vrcop product type
	*/
	@Override
	public Date getSyncDate() {
		return _vrcopProductType.getSyncDate();
	}

	/**
	* Returns the cop report repository ID of this vrcop product type.
	*
	* @return the cop report repository ID of this vrcop product type
	*/
	@Override
	public long getCopReportRepositoryID() {
		return _vrcopProductType.getCopReportRepositoryID();
	}

	/**
	* Returns the ID of this vrcop product type.
	*
	* @return the ID of this vrcop product type
	*/
	@Override
	public long getId() {
		return _vrcopProductType.getId();
	}

	/**
	* Returns the mt core of this vrcop product type.
	*
	* @return the mt core of this vrcop product type
	*/
	@Override
	public long getMtCore() {
		return _vrcopProductType.getMtCore();
	}

	/**
	* Returns the primary key of this vrcop product type.
	*
	* @return the primary key of this vrcop product type
	*/
	@Override
	public long getPrimaryKey() {
		return _vrcopProductType.getPrimaryKey();
	}

	/**
	* Returns the sequence no of this vrcop product type.
	*
	* @return the sequence no of this vrcop product type
	*/
	@Override
	public long getSequenceNo() {
		return _vrcopProductType.getSequenceNo();
	}

	@Override
	public void persist() {
		_vrcopProductType.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vrcopProductType.setCachedModel(cachedModel);
	}

	/**
	* Sets the cop report no of this vrcop product type.
	*
	* @param copReportNo the cop report no of this vrcop product type
	*/
	@Override
	public void setCopReportNo(java.lang.String copReportNo) {
		_vrcopProductType.setCopReportNo(copReportNo);
	}

	/**
	* Sets the cop report repository ID of this vrcop product type.
	*
	* @param copReportRepositoryID the cop report repository ID of this vrcop product type
	*/
	@Override
	public void setCopReportRepositoryID(long copReportRepositoryID) {
		_vrcopProductType.setCopReportRepositoryID(copReportRepositoryID);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_vrcopProductType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_vrcopProductType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_vrcopProductType.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this vrcop product type.
	*
	* @param id the ID of this vrcop product type
	*/
	@Override
	public void setId(long id) {
		_vrcopProductType.setId(id);
	}

	/**
	* Sets the modify date of this vrcop product type.
	*
	* @param modifyDate the modify date of this vrcop product type
	*/
	@Override
	public void setModifyDate(Date modifyDate) {
		_vrcopProductType.setModifyDate(modifyDate);
	}

	/**
	* Sets the mt core of this vrcop product type.
	*
	* @param mtCore the mt core of this vrcop product type
	*/
	@Override
	public void setMtCore(long mtCore) {
		_vrcopProductType.setMtCore(mtCore);
	}

	@Override
	public void setNew(boolean n) {
		_vrcopProductType.setNew(n);
	}

	/**
	* Sets the primary key of this vrcop product type.
	*
	* @param primaryKey the primary key of this vrcop product type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vrcopProductType.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_vrcopProductType.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the sequence no of this vrcop product type.
	*
	* @param sequenceNo the sequence no of this vrcop product type
	*/
	@Override
	public void setSequenceNo(long sequenceNo) {
		_vrcopProductType.setSequenceNo(sequenceNo);
	}

	/**
	* Sets the sync date of this vrcop product type.
	*
	* @param syncDate the sync date of this vrcop product type
	*/
	@Override
	public void setSyncDate(Date syncDate) {
		_vrcopProductType.setSyncDate(syncDate);
	}

	/**
	* Sets the vehicle class of this vrcop product type.
	*
	* @param vehicleClass the vehicle class of this vrcop product type
	*/
	@Override
	public void setVehicleClass(java.lang.String vehicleClass) {
		_vrcopProductType.setVehicleClass(vehicleClass);
	}

	/**
	* Sets the vehicle type code of this vrcop product type.
	*
	* @param vehicleTypeCode the vehicle type code of this vrcop product type
	*/
	@Override
	public void setVehicleTypeCode(java.lang.String vehicleTypeCode) {
		_vrcopProductType.setVehicleTypeCode(vehicleTypeCode);
	}

	/**
	* Sets the vehicle type description of this vrcop product type.
	*
	* @param vehicleTypeDescription the vehicle type description of this vrcop product type
	*/
	@Override
	public void setVehicleTypeDescription(
		java.lang.String vehicleTypeDescription) {
		_vrcopProductType.setVehicleTypeDescription(vehicleTypeDescription);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRCOPProductTypeWrapper)) {
			return false;
		}

		VRCOPProductTypeWrapper vrcopProductTypeWrapper = (VRCOPProductTypeWrapper)obj;

		if (Objects.equals(_vrcopProductType,
					vrcopProductTypeWrapper._vrcopProductType)) {
			return true;
		}

		return false;
	}

	@Override
	public VRCOPProductType getWrappedModel() {
		return _vrcopProductType;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _vrcopProductType.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _vrcopProductType.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_vrcopProductType.resetOriginalValues();
	}

	private final VRCOPProductType _vrcopProductType;
}