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
public class VRCOPReportRepositorySoap implements Serializable {
	public static VRCOPReportRepositorySoap toSoapModel(
		VRCOPReportRepository model) {
		VRCOPReportRepositorySoap soapModel = new VRCOPReportRepositorySoap();

		soapModel.setId(model.getId());
		soapModel.setMtCore(model.getMtCore());
		soapModel.setApplicantProfileId(model.getApplicantProfileId());
		soapModel.setApplicantName(model.getApplicantName());
		soapModel.setApplicantAddress(model.getApplicantAddress());
		soapModel.setOverseasManufacturerId(model.getOverseasManufacturerId());
		soapModel.setOverseasManufacturerName(model.getOverseasManufacturerName());
		soapModel.setOverseasManufacturerAddress(model.getOverseasManufacturerAddress());
		soapModel.setProductionPlantId(model.getProductionPlantId());
		soapModel.setProductionPlantCode(model.getProductionPlantCode());
		soapModel.setProductionPlantName(model.getProductionPlantName());
		soapModel.setProductionPlantAddress(model.getProductionPlantAddress());
		soapModel.setCopReportNo(model.getCopReportNo());
		soapModel.setCopReportStatus(model.getCopReportStatus());
		soapModel.setCopReportType(model.getCopReportType());
		soapModel.setCopReportMetadata(model.getCopReportMetadata());
		soapModel.setCopReportSignName(model.getCopReportSignName());
		soapModel.setCopReportSignTitle(model.getCopReportSignTitle());
		soapModel.setCopReportSignPlace(model.getCopReportSignPlace());
		soapModel.setCopReportDate(model.getCopReportDate());
		soapModel.setCopReportApprovedDate(model.getCopReportApprovedDate());
		soapModel.setCopReportExpiredDate(model.getCopReportExpiredDate());
		soapModel.setModifyDate(model.getModifyDate());
		soapModel.setSyncDate(model.getSyncDate());

		return soapModel;
	}

	public static VRCOPReportRepositorySoap[] toSoapModels(
		VRCOPReportRepository[] models) {
		VRCOPReportRepositorySoap[] soapModels = new VRCOPReportRepositorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VRCOPReportRepositorySoap[][] toSoapModels(
		VRCOPReportRepository[][] models) {
		VRCOPReportRepositorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VRCOPReportRepositorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VRCOPReportRepositorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VRCOPReportRepositorySoap[] toSoapModels(
		List<VRCOPReportRepository> models) {
		List<VRCOPReportRepositorySoap> soapModels = new ArrayList<VRCOPReportRepositorySoap>(models.size());

		for (VRCOPReportRepository model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VRCOPReportRepositorySoap[soapModels.size()]);
	}

	public VRCOPReportRepositorySoap() {
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

	public long getApplicantProfileId() {
		return _applicantProfileId;
	}

	public void setApplicantProfileId(long applicantProfileId) {
		_applicantProfileId = applicantProfileId;
	}

	public String getApplicantName() {
		return _applicantName;
	}

	public void setApplicantName(String applicantName) {
		_applicantName = applicantName;
	}

	public String getApplicantAddress() {
		return _applicantAddress;
	}

	public void setApplicantAddress(String applicantAddress) {
		_applicantAddress = applicantAddress;
	}

	public long getOverseasManufacturerId() {
		return _overseasManufacturerId;
	}

	public void setOverseasManufacturerId(long overseasManufacturerId) {
		_overseasManufacturerId = overseasManufacturerId;
	}

	public String getOverseasManufacturerName() {
		return _overseasManufacturerName;
	}

	public void setOverseasManufacturerName(String overseasManufacturerName) {
		_overseasManufacturerName = overseasManufacturerName;
	}

	public String getOverseasManufacturerAddress() {
		return _overseasManufacturerAddress;
	}

	public void setOverseasManufacturerAddress(
		String overseasManufacturerAddress) {
		_overseasManufacturerAddress = overseasManufacturerAddress;
	}

	public long getProductionPlantId() {
		return _productionPlantId;
	}

	public void setProductionPlantId(long productionPlantId) {
		_productionPlantId = productionPlantId;
	}

	public String getProductionPlantCode() {
		return _productionPlantCode;
	}

	public void setProductionPlantCode(String productionPlantCode) {
		_productionPlantCode = productionPlantCode;
	}

	public String getProductionPlantName() {
		return _productionPlantName;
	}

	public void setProductionPlantName(String productionPlantName) {
		_productionPlantName = productionPlantName;
	}

	public String getProductionPlantAddress() {
		return _productionPlantAddress;
	}

	public void setProductionPlantAddress(String productionPlantAddress) {
		_productionPlantAddress = productionPlantAddress;
	}

	public String getCopReportNo() {
		return _copReportNo;
	}

	public void setCopReportNo(String copReportNo) {
		_copReportNo = copReportNo;
	}

	public String getCopReportStatus() {
		return _copReportStatus;
	}

	public void setCopReportStatus(String copReportStatus) {
		_copReportStatus = copReportStatus;
	}

	public String getCopReportType() {
		return _copReportType;
	}

	public void setCopReportType(String copReportType) {
		_copReportType = copReportType;
	}

	public String getCopReportMetadata() {
		return _copReportMetadata;
	}

	public void setCopReportMetadata(String copReportMetadata) {
		_copReportMetadata = copReportMetadata;
	}

	public String getCopReportSignName() {
		return _copReportSignName;
	}

	public void setCopReportSignName(String copReportSignName) {
		_copReportSignName = copReportSignName;
	}

	public String getCopReportSignTitle() {
		return _copReportSignTitle;
	}

	public void setCopReportSignTitle(String copReportSignTitle) {
		_copReportSignTitle = copReportSignTitle;
	}

	public String getCopReportSignPlace() {
		return _copReportSignPlace;
	}

	public void setCopReportSignPlace(String copReportSignPlace) {
		_copReportSignPlace = copReportSignPlace;
	}

	public Date getCopReportDate() {
		return _copReportDate;
	}

	public void setCopReportDate(Date copReportDate) {
		_copReportDate = copReportDate;
	}

	public Date getCopReportApprovedDate() {
		return _copReportApprovedDate;
	}

	public void setCopReportApprovedDate(Date copReportApprovedDate) {
		_copReportApprovedDate = copReportApprovedDate;
	}

	public Date getCopReportExpiredDate() {
		return _copReportExpiredDate;
	}

	public void setCopReportExpiredDate(Date copReportExpiredDate) {
		_copReportExpiredDate = copReportExpiredDate;
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
	private long _applicantProfileId;
	private String _applicantName;
	private String _applicantAddress;
	private long _overseasManufacturerId;
	private String _overseasManufacturerName;
	private String _overseasManufacturerAddress;
	private long _productionPlantId;
	private String _productionPlantCode;
	private String _productionPlantName;
	private String _productionPlantAddress;
	private String _copReportNo;
	private String _copReportStatus;
	private String _copReportType;
	private String _copReportMetadata;
	private String _copReportSignName;
	private String _copReportSignTitle;
	private String _copReportSignPlace;
	private Date _copReportDate;
	private Date _copReportApprovedDate;
	private Date _copReportExpiredDate;
	private Date _modifyDate;
	private Date _syncDate;
}