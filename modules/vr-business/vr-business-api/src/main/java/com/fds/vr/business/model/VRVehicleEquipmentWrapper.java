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
 * This class is a wrapper for {@link VRVehicleEquipment}.
 * </p>
 *
 * @author LamTV
 * @see VRVehicleEquipment
 * @generated
 */
@ProviderType
public class VRVehicleEquipmentWrapper implements VRVehicleEquipment,
	ModelWrapper<VRVehicleEquipment> {
	public VRVehicleEquipmentWrapper(VRVehicleEquipment vrVehicleEquipment) {
		_vrVehicleEquipment = vrVehicleEquipment;
	}

	@Override
	public Class<?> getModelClass() {
		return VRVehicleEquipment.class;
	}

	@Override
	public String getModelClassName() {
		return VRVehicleEquipment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("vehicleCertificateId", getVehicleCertificateId());
		attributes.put("certificateRecordId", getCertificateRecordId());
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

		Long vehicleCertificateId = (Long)attributes.get("vehicleCertificateId");

		if (vehicleCertificateId != null) {
			setVehicleCertificateId(vehicleCertificateId);
		}

		Long certificateRecordId = (Long)attributes.get("certificateRecordId");

		if (certificateRecordId != null) {
			setCertificateRecordId(certificateRecordId);
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
	public VRVehicleEquipment toEscapedModel() {
		return new VRVehicleEquipmentWrapper(_vrVehicleEquipment.toEscapedModel());
	}

	@Override
	public VRVehicleEquipment toUnescapedModel() {
		return new VRVehicleEquipmentWrapper(_vrVehicleEquipment.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _vrVehicleEquipment.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _vrVehicleEquipment.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _vrVehicleEquipment.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _vrVehicleEquipment.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<VRVehicleEquipment> toCacheModel() {
		return _vrVehicleEquipment.toCacheModel();
	}

	@Override
	public int compareTo(VRVehicleEquipment vrVehicleEquipment) {
		return _vrVehicleEquipment.compareTo(vrVehicleEquipment);
	}

	@Override
	public int hashCode() {
		return _vrVehicleEquipment.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vrVehicleEquipment.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new VRVehicleEquipmentWrapper((VRVehicleEquipment)_vrVehicleEquipment.clone());
	}

	@Override
	public java.lang.String toString() {
		return _vrVehicleEquipment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vrVehicleEquipment.toXmlString();
	}

	/**
	* Returns the modify date of this vr vehicle equipment.
	*
	* @return the modify date of this vr vehicle equipment
	*/
	@Override
	public Date getModifyDate() {
		return _vrVehicleEquipment.getModifyDate();
	}

	/**
	* Returns the sync date of this vr vehicle equipment.
	*
	* @return the sync date of this vr vehicle equipment
	*/
	@Override
	public Date getSyncDate() {
		return _vrVehicleEquipment.getSyncDate();
	}

	/**
	* Returns the certificate record ID of this vr vehicle equipment.
	*
	* @return the certificate record ID of this vr vehicle equipment
	*/
	@Override
	public long getCertificateRecordId() {
		return _vrVehicleEquipment.getCertificateRecordId();
	}

	/**
	* Returns the ID of this vr vehicle equipment.
	*
	* @return the ID of this vr vehicle equipment
	*/
	@Override
	public long getId() {
		return _vrVehicleEquipment.getId();
	}

	/**
	* Returns the primary key of this vr vehicle equipment.
	*
	* @return the primary key of this vr vehicle equipment
	*/
	@Override
	public long getPrimaryKey() {
		return _vrVehicleEquipment.getPrimaryKey();
	}

	/**
	* Returns the vehicle certificate ID of this vr vehicle equipment.
	*
	* @return the vehicle certificate ID of this vr vehicle equipment
	*/
	@Override
	public long getVehicleCertificateId() {
		return _vrVehicleEquipment.getVehicleCertificateId();
	}

	@Override
	public void persist() {
		_vrVehicleEquipment.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vrVehicleEquipment.setCachedModel(cachedModel);
	}

	/**
	* Sets the certificate record ID of this vr vehicle equipment.
	*
	* @param certificateRecordId the certificate record ID of this vr vehicle equipment
	*/
	@Override
	public void setCertificateRecordId(long certificateRecordId) {
		_vrVehicleEquipment.setCertificateRecordId(certificateRecordId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_vrVehicleEquipment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_vrVehicleEquipment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_vrVehicleEquipment.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this vr vehicle equipment.
	*
	* @param id the ID of this vr vehicle equipment
	*/
	@Override
	public void setId(long id) {
		_vrVehicleEquipment.setId(id);
	}

	/**
	* Sets the modify date of this vr vehicle equipment.
	*
	* @param modifyDate the modify date of this vr vehicle equipment
	*/
	@Override
	public void setModifyDate(Date modifyDate) {
		_vrVehicleEquipment.setModifyDate(modifyDate);
	}

	@Override
	public void setNew(boolean n) {
		_vrVehicleEquipment.setNew(n);
	}

	/**
	* Sets the primary key of this vr vehicle equipment.
	*
	* @param primaryKey the primary key of this vr vehicle equipment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vrVehicleEquipment.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_vrVehicleEquipment.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the sync date of this vr vehicle equipment.
	*
	* @param syncDate the sync date of this vr vehicle equipment
	*/
	@Override
	public void setSyncDate(Date syncDate) {
		_vrVehicleEquipment.setSyncDate(syncDate);
	}

	/**
	* Sets the vehicle certificate ID of this vr vehicle equipment.
	*
	* @param vehicleCertificateId the vehicle certificate ID of this vr vehicle equipment
	*/
	@Override
	public void setVehicleCertificateId(long vehicleCertificateId) {
		_vrVehicleEquipment.setVehicleCertificateId(vehicleCertificateId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRVehicleEquipmentWrapper)) {
			return false;
		}

		VRVehicleEquipmentWrapper vrVehicleEquipmentWrapper = (VRVehicleEquipmentWrapper)obj;

		if (Objects.equals(_vrVehicleEquipment,
					vrVehicleEquipmentWrapper._vrVehicleEquipment)) {
			return true;
		}

		return false;
	}

	@Override
	public VRVehicleEquipment getWrappedModel() {
		return _vrVehicleEquipment;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _vrVehicleEquipment.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _vrVehicleEquipment.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_vrVehicleEquipment.resetOriginalValues();
	}

	private final VRVehicleEquipment _vrVehicleEquipment;
}