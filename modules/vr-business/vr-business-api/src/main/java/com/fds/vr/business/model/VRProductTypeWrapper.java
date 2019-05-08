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
 * This class is a wrapper for {@link VRProductType}.
 * </p>
 *
 * @author LamTV
 * @see VRProductType
 * @generated
 */
@ProviderType
public class VRProductTypeWrapper implements VRProductType,
	ModelWrapper<VRProductType> {
	public VRProductTypeWrapper(VRProductType vrProductType) {
		_vrProductType = vrProductType;
	}

	@Override
	public Class<?> getModelClass() {
		return VRProductType.class;
	}

	@Override
	public String getModelClassName() {
		return VRProductType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("mtCore", getMtCore());
		attributes.put("productPlantID", getProductPlantID());
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

		Long productPlantID = (Long)attributes.get("productPlantID");

		if (productPlantID != null) {
			setProductPlantID(productPlantID);
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
	public VRProductType toEscapedModel() {
		return new VRProductTypeWrapper(_vrProductType.toEscapedModel());
	}

	@Override
	public VRProductType toUnescapedModel() {
		return new VRProductTypeWrapper(_vrProductType.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _vrProductType.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _vrProductType.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _vrProductType.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _vrProductType.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<VRProductType> toCacheModel() {
		return _vrProductType.toCacheModel();
	}

	@Override
	public int compareTo(VRProductType vrProductType) {
		return _vrProductType.compareTo(vrProductType);
	}

	@Override
	public int hashCode() {
		return _vrProductType.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vrProductType.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new VRProductTypeWrapper((VRProductType)_vrProductType.clone());
	}

	/**
	* Returns the vehicle class of this vr product type.
	*
	* @return the vehicle class of this vr product type
	*/
	@Override
	public java.lang.String getVehicleClass() {
		return _vrProductType.getVehicleClass();
	}

	/**
	* Returns the vehicle type code of this vr product type.
	*
	* @return the vehicle type code of this vr product type
	*/
	@Override
	public java.lang.String getVehicleTypeCode() {
		return _vrProductType.getVehicleTypeCode();
	}

	/**
	* Returns the vehicle type description of this vr product type.
	*
	* @return the vehicle type description of this vr product type
	*/
	@Override
	public java.lang.String getVehicleTypeDescription() {
		return _vrProductType.getVehicleTypeDescription();
	}

	@Override
	public java.lang.String toString() {
		return _vrProductType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vrProductType.toXmlString();
	}

	/**
	* Returns the modify date of this vr product type.
	*
	* @return the modify date of this vr product type
	*/
	@Override
	public Date getModifyDate() {
		return _vrProductType.getModifyDate();
	}

	/**
	* Returns the sync date of this vr product type.
	*
	* @return the sync date of this vr product type
	*/
	@Override
	public Date getSyncDate() {
		return _vrProductType.getSyncDate();
	}

	/**
	* Returns the ID of this vr product type.
	*
	* @return the ID of this vr product type
	*/
	@Override
	public long getId() {
		return _vrProductType.getId();
	}

	/**
	* Returns the mt core of this vr product type.
	*
	* @return the mt core of this vr product type
	*/
	@Override
	public long getMtCore() {
		return _vrProductType.getMtCore();
	}

	/**
	* Returns the primary key of this vr product type.
	*
	* @return the primary key of this vr product type
	*/
	@Override
	public long getPrimaryKey() {
		return _vrProductType.getPrimaryKey();
	}

	/**
	* Returns the product plant ID of this vr product type.
	*
	* @return the product plant ID of this vr product type
	*/
	@Override
	public long getProductPlantID() {
		return _vrProductType.getProductPlantID();
	}

	/**
	* Returns the sequence no of this vr product type.
	*
	* @return the sequence no of this vr product type
	*/
	@Override
	public long getSequenceNo() {
		return _vrProductType.getSequenceNo();
	}

	@Override
	public void persist() {
		_vrProductType.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vrProductType.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_vrProductType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_vrProductType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_vrProductType.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this vr product type.
	*
	* @param id the ID of this vr product type
	*/
	@Override
	public void setId(long id) {
		_vrProductType.setId(id);
	}

	/**
	* Sets the modify date of this vr product type.
	*
	* @param modifyDate the modify date of this vr product type
	*/
	@Override
	public void setModifyDate(Date modifyDate) {
		_vrProductType.setModifyDate(modifyDate);
	}

	/**
	* Sets the mt core of this vr product type.
	*
	* @param mtCore the mt core of this vr product type
	*/
	@Override
	public void setMtCore(long mtCore) {
		_vrProductType.setMtCore(mtCore);
	}

	@Override
	public void setNew(boolean n) {
		_vrProductType.setNew(n);
	}

	/**
	* Sets the primary key of this vr product type.
	*
	* @param primaryKey the primary key of this vr product type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vrProductType.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_vrProductType.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the product plant ID of this vr product type.
	*
	* @param productPlantID the product plant ID of this vr product type
	*/
	@Override
	public void setProductPlantID(long productPlantID) {
		_vrProductType.setProductPlantID(productPlantID);
	}

	/**
	* Sets the sequence no of this vr product type.
	*
	* @param sequenceNo the sequence no of this vr product type
	*/
	@Override
	public void setSequenceNo(long sequenceNo) {
		_vrProductType.setSequenceNo(sequenceNo);
	}

	/**
	* Sets the sync date of this vr product type.
	*
	* @param syncDate the sync date of this vr product type
	*/
	@Override
	public void setSyncDate(Date syncDate) {
		_vrProductType.setSyncDate(syncDate);
	}

	/**
	* Sets the vehicle class of this vr product type.
	*
	* @param vehicleClass the vehicle class of this vr product type
	*/
	@Override
	public void setVehicleClass(java.lang.String vehicleClass) {
		_vrProductType.setVehicleClass(vehicleClass);
	}

	/**
	* Sets the vehicle type code of this vr product type.
	*
	* @param vehicleTypeCode the vehicle type code of this vr product type
	*/
	@Override
	public void setVehicleTypeCode(java.lang.String vehicleTypeCode) {
		_vrProductType.setVehicleTypeCode(vehicleTypeCode);
	}

	/**
	* Sets the vehicle type description of this vr product type.
	*
	* @param vehicleTypeDescription the vehicle type description of this vr product type
	*/
	@Override
	public void setVehicleTypeDescription(
		java.lang.String vehicleTypeDescription) {
		_vrProductType.setVehicleTypeDescription(vehicleTypeDescription);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRProductTypeWrapper)) {
			return false;
		}

		VRProductTypeWrapper vrProductTypeWrapper = (VRProductTypeWrapper)obj;

		if (Objects.equals(_vrProductType, vrProductTypeWrapper._vrProductType)) {
			return true;
		}

		return false;
	}

	@Override
	public VRProductType getWrappedModel() {
		return _vrProductType;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _vrProductType.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _vrProductType.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_vrProductType.resetOriginalValues();
	}

	private final VRProductType _vrProductType;
}