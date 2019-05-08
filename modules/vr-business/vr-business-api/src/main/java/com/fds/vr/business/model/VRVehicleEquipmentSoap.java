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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author LamTV
 * @generated
 */
@ProviderType
public class VRVehicleEquipmentSoap implements Serializable {
	public static VRVehicleEquipmentSoap toSoapModel(VRVehicleEquipment model) {
		VRVehicleEquipmentSoap soapModel = new VRVehicleEquipmentSoap();

		soapModel.setId(model.getId());
		soapModel.setVehicleCertificateId(model.getVehicleCertificateId());
		soapModel.setCertificateRecordId(model.getCertificateRecordId());
		soapModel.setModifyDate(model.getModifyDate());
		soapModel.setSyncDate(model.getSyncDate());

		return soapModel;
	}

	public static VRVehicleEquipmentSoap[] toSoapModels(
		VRVehicleEquipment[] models) {
		VRVehicleEquipmentSoap[] soapModels = new VRVehicleEquipmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VRVehicleEquipmentSoap[][] toSoapModels(
		VRVehicleEquipment[][] models) {
		VRVehicleEquipmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VRVehicleEquipmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VRVehicleEquipmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VRVehicleEquipmentSoap[] toSoapModels(
		List<VRVehicleEquipment> models) {
		List<VRVehicleEquipmentSoap> soapModels = new ArrayList<VRVehicleEquipmentSoap>(models.size());

		for (VRVehicleEquipment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VRVehicleEquipmentSoap[soapModels.size()]);
	}

	public VRVehicleEquipmentSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getVehicleCertificateId() {
		return _vehicleCertificateId;
	}

	public void setVehicleCertificateId(long vehicleCertificateId) {
		_vehicleCertificateId = vehicleCertificateId;
	}

	public long getCertificateRecordId() {
		return _certificateRecordId;
	}

	public void setCertificateRecordId(long certificateRecordId) {
		_certificateRecordId = certificateRecordId;
	}

	public Date getModifyDate() {
		return _modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		_modifyDate = modifyDate;
	}

	public Date getSyncDate() {
		return _syncDate;
	}

	public void setSyncDate(Date syncDate) {
		_syncDate = syncDate;
	}

	private long _id;
	private long _vehicleCertificateId;
	private long _certificateRecordId;
	private Date _modifyDate;
	private Date _syncDate;
}