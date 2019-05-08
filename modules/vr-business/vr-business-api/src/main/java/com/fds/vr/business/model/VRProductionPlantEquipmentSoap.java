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
public class VRProductionPlantEquipmentSoap implements Serializable {
	public static VRProductionPlantEquipmentSoap toSoapModel(
		VRProductionPlantEquipment model) {
		VRProductionPlantEquipmentSoap soapModel = new VRProductionPlantEquipmentSoap();

		soapModel.setId(model.getId());
		soapModel.setMtCore(model.getMtCore());
		soapModel.setProductPlantID(model.getProductPlantID());
		soapModel.setSequenceNo(model.getSequenceNo());
		soapModel.setEquipmentCode(model.getEquipmentCode());
		soapModel.setEquipmentName(model.getEquipmentName());
		soapModel.setEquipmentType(model.getEquipmentType());
		soapModel.setTrademark(model.getTrademark());
		soapModel.setTrademarkName(model.getTrademarkName());
		soapModel.setCommercialName(model.getCommercialName());
		soapModel.setModelCode(model.getModelCode());
		soapModel.setDesignSymbolNo(model.getDesignSymbolNo());
		soapModel.setProductionCountryCode(model.getProductionCountryCode());
		soapModel.setEquipmentStatus(model.getEquipmentStatus());
		soapModel.setNotes(model.getNotes());
		soapModel.setModifyDate(model.getModifyDate());
		soapModel.setSyncDate(model.getSyncDate());

		return soapModel;
	}

	public static VRProductionPlantEquipmentSoap[] toSoapModels(
		VRProductionPlantEquipment[] models) {
		VRProductionPlantEquipmentSoap[] soapModels = new VRProductionPlantEquipmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VRProductionPlantEquipmentSoap[][] toSoapModels(
		VRProductionPlantEquipment[][] models) {
		VRProductionPlantEquipmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VRProductionPlantEquipmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VRProductionPlantEquipmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VRProductionPlantEquipmentSoap[] toSoapModels(
		List<VRProductionPlantEquipment> models) {
		List<VRProductionPlantEquipmentSoap> soapModels = new ArrayList<VRProductionPlantEquipmentSoap>(models.size());

		for (VRProductionPlantEquipment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VRProductionPlantEquipmentSoap[soapModels.size()]);
	}

	public VRProductionPlantEquipmentSoap() {
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

	public long getMtCore() {
		return _mtCore;
	}

	public void setMtCore(long mtCore) {
		_mtCore = mtCore;
	}

	public long getProductPlantID() {
		return _productPlantID;
	}

	public void setProductPlantID(long productPlantID) {
		_productPlantID = productPlantID;
	}

	public long getSequenceNo() {
		return _sequenceNo;
	}

	public void setSequenceNo(long sequenceNo) {
		_sequenceNo = sequenceNo;
	}

	public String getEquipmentCode() {
		return _equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		_equipmentCode = equipmentCode;
	}

	public String getEquipmentName() {
		return _equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		_equipmentName = equipmentName;
	}

	public String getEquipmentType() {
		return _equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		_equipmentType = equipmentType;
	}

	public String getTrademark() {
		return _trademark;
	}

	public void setTrademark(String trademark) {
		_trademark = trademark;
	}

	public String getTrademarkName() {
		return _trademarkName;
	}

	public void setTrademarkName(String trademarkName) {
		_trademarkName = trademarkName;
	}

	public String getCommercialName() {
		return _commercialName;
	}

	public void setCommercialName(String commercialName) {
		_commercialName = commercialName;
	}

	public String getModelCode() {
		return _modelCode;
	}

	public void setModelCode(String modelCode) {
		_modelCode = modelCode;
	}

	public String getDesignSymbolNo() {
		return _designSymbolNo;
	}

	public void setDesignSymbolNo(String designSymbolNo) {
		_designSymbolNo = designSymbolNo;
	}

	public String getProductionCountryCode() {
		return _productionCountryCode;
	}

	public void setProductionCountryCode(String productionCountryCode) {
		_productionCountryCode = productionCountryCode;
	}

	public String getEquipmentStatus() {
		return _equipmentStatus;
	}

	public void setEquipmentStatus(String equipmentStatus) {
		_equipmentStatus = equipmentStatus;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
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
	private long _mtCore;
	private long _productPlantID;
	private long _sequenceNo;
	private String _equipmentCode;
	private String _equipmentName;
	private String _equipmentType;
	private String _trademark;
	private String _trademarkName;
	private String _commercialName;
	private String _modelCode;
	private String _designSymbolNo;
	private String _productionCountryCode;
	private String _equipmentStatus;
	private String _notes;
	private Date _modifyDate;
	private Date _syncDate;
}