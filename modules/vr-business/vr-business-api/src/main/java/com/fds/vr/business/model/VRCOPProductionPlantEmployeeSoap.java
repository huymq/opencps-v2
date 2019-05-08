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
public class VRCOPProductionPlantEmployeeSoap implements Serializable {
	public static VRCOPProductionPlantEmployeeSoap toSoapModel(
		VRCOPProductionPlantEmployee model) {
		VRCOPProductionPlantEmployeeSoap soapModel = new VRCOPProductionPlantEmployeeSoap();

		soapModel.setId(model.getId());
		soapModel.setMtCore(model.getMtCore());
		soapModel.setCopReportRepositoryID(model.getCopReportRepositoryID());
		soapModel.setCopReportNo(model.getCopReportNo());
		soapModel.setSequenceNo(model.getSequenceNo());
		soapModel.setEmployeeName(model.getEmployeeName());
		soapModel.setEmployeeCertificateNo(model.getEmployeeCertificateNo());
		soapModel.setModifyDate(model.getModifyDate());
		soapModel.setSyncDate(model.getSyncDate());

		return soapModel;
	}

	public static VRCOPProductionPlantEmployeeSoap[] toSoapModels(
		VRCOPProductionPlantEmployee[] models) {
		VRCOPProductionPlantEmployeeSoap[] soapModels = new VRCOPProductionPlantEmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VRCOPProductionPlantEmployeeSoap[][] toSoapModels(
		VRCOPProductionPlantEmployee[][] models) {
		VRCOPProductionPlantEmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VRCOPProductionPlantEmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VRCOPProductionPlantEmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VRCOPProductionPlantEmployeeSoap[] toSoapModels(
		List<VRCOPProductionPlantEmployee> models) {
		List<VRCOPProductionPlantEmployeeSoap> soapModels = new ArrayList<VRCOPProductionPlantEmployeeSoap>(models.size());

		for (VRCOPProductionPlantEmployee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VRCOPProductionPlantEmployeeSoap[soapModels.size()]);
	}

	public VRCOPProductionPlantEmployeeSoap() {
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

	public long getCopReportRepositoryID() {
		return _copReportRepositoryID;
	}

	public void setCopReportRepositoryID(long copReportRepositoryID) {
		_copReportRepositoryID = copReportRepositoryID;
	}

	public String getCopReportNo() {
		return _copReportNo;
	}

	public void setCopReportNo(String copReportNo) {
		_copReportNo = copReportNo;
	}

	public long getSequenceNo() {
		return _sequenceNo;
	}

	public void setSequenceNo(long sequenceNo) {
		_sequenceNo = sequenceNo;
	}

	public String getEmployeeName() {
		return _employeeName;
	}

	public void setEmployeeName(String employeeName) {
		_employeeName = employeeName;
	}

	public String getEmployeeCertificateNo() {
		return _employeeCertificateNo;
	}

	public void setEmployeeCertificateNo(String employeeCertificateNo) {
		_employeeCertificateNo = employeeCertificateNo;
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
	private long _copReportRepositoryID;
	private String _copReportNo;
	private long _sequenceNo;
	private String _employeeName;
	private String _employeeCertificateNo;
	private Date _modifyDate;
	private Date _syncDate;
}