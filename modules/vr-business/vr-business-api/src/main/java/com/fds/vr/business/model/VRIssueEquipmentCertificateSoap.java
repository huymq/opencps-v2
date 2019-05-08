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
public class VRIssueEquipmentCertificateSoap implements Serializable {
	public static VRIssueEquipmentCertificateSoap toSoapModel(
		VRIssueEquipmentCertificate model) {
		VRIssueEquipmentCertificateSoap soapModel = new VRIssueEquipmentCertificateSoap();

		soapModel.setId(model.getId());
		soapModel.setMtcore(model.getMtcore());
		soapModel.setIssueId(model.getIssueId());
		soapModel.setIssueVehicleCertificateId(model.getIssueVehicleCertificateId());
		soapModel.setVehiclecertificaterecordno(model.getVehiclecertificaterecordno());
		soapModel.setEquipmentName(model.getEquipmentName());
		soapModel.setEquipmentType(model.getEquipmentType());
		soapModel.setEquipmentCertificateType(model.getEquipmentCertificateType());
		soapModel.setEquipmentDocumentNo(model.getEquipmentDocumentNo());
		soapModel.setEquipmentCertificateRecordNo(model.getEquipmentCertificateRecordNo());
		soapModel.setEquipmentExamRecordNo(model.getEquipmentExamRecordNo());
		soapModel.setEquipmentCertificateRecordId(model.getEquipmentCertificateRecordId());
		soapModel.setTotalQuantity(model.getTotalQuantity());
		soapModel.setTotalProductUsed(model.getTotalProductUsed());
		soapModel.setTotalInUse(model.getTotalInUse());
		soapModel.setTotalNotUsed(model.getTotalNotUsed());
		soapModel.setApplicantNo(model.getApplicantNo());
		soapModel.setApplicantname(model.getApplicantname());
		soapModel.setApplicantaddress(model.getApplicantaddress());
		soapModel.setProductionplantname(model.getProductionplantname());
		soapModel.setProductionplantaddress(model.getProductionplantaddress());
		soapModel.setModifyDate(model.getModifyDate());
		soapModel.setSyncDate(model.getSyncDate());

		return soapModel;
	}

	public static VRIssueEquipmentCertificateSoap[] toSoapModels(
		VRIssueEquipmentCertificate[] models) {
		VRIssueEquipmentCertificateSoap[] soapModels = new VRIssueEquipmentCertificateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VRIssueEquipmentCertificateSoap[][] toSoapModels(
		VRIssueEquipmentCertificate[][] models) {
		VRIssueEquipmentCertificateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VRIssueEquipmentCertificateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VRIssueEquipmentCertificateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VRIssueEquipmentCertificateSoap[] toSoapModels(
		List<VRIssueEquipmentCertificate> models) {
		List<VRIssueEquipmentCertificateSoap> soapModels = new ArrayList<VRIssueEquipmentCertificateSoap>(models.size());

		for (VRIssueEquipmentCertificate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VRIssueEquipmentCertificateSoap[soapModels.size()]);
	}

	public VRIssueEquipmentCertificateSoap() {
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

	public int getMtcore() {
		return _mtcore;
	}

	public void setMtcore(int mtcore) {
		_mtcore = mtcore;
	}

	public int getIssueId() {
		return _issueId;
	}

	public void setIssueId(int issueId) {
		_issueId = issueId;
	}

	public int getIssueVehicleCertificateId() {
		return _issueVehicleCertificateId;
	}

	public void setIssueVehicleCertificateId(int issueVehicleCertificateId) {
		_issueVehicleCertificateId = issueVehicleCertificateId;
	}

	public String getVehiclecertificaterecordno() {
		return _vehiclecertificaterecordno;
	}

	public void setVehiclecertificaterecordno(String vehiclecertificaterecordno) {
		_vehiclecertificaterecordno = vehiclecertificaterecordno;
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

	public String getEquipmentCertificateType() {
		return _equipmentCertificateType;
	}

	public void setEquipmentCertificateType(String equipmentCertificateType) {
		_equipmentCertificateType = equipmentCertificateType;
	}

	public String getEquipmentDocumentNo() {
		return _equipmentDocumentNo;
	}

	public void setEquipmentDocumentNo(String equipmentDocumentNo) {
		_equipmentDocumentNo = equipmentDocumentNo;
	}

	public String getEquipmentCertificateRecordNo() {
		return _equipmentCertificateRecordNo;
	}

	public void setEquipmentCertificateRecordNo(
		String equipmentCertificateRecordNo) {
		_equipmentCertificateRecordNo = equipmentCertificateRecordNo;
	}

	public String getEquipmentExamRecordNo() {
		return _equipmentExamRecordNo;
	}

	public void setEquipmentExamRecordNo(String equipmentExamRecordNo) {
		_equipmentExamRecordNo = equipmentExamRecordNo;
	}

	public int getEquipmentCertificateRecordId() {
		return _EquipmentCertificateRecordId;
	}

	public void setEquipmentCertificateRecordId(
		int EquipmentCertificateRecordId) {
		_EquipmentCertificateRecordId = EquipmentCertificateRecordId;
	}

	public int getTotalQuantity() {
		return _TotalQuantity;
	}

	public void setTotalQuantity(int TotalQuantity) {
		_TotalQuantity = TotalQuantity;
	}

	public int getTotalProductUsed() {
		return _TotalProductUsed;
	}

	public void setTotalProductUsed(int TotalProductUsed) {
		_TotalProductUsed = TotalProductUsed;
	}

	public int getTotalInUse() {
		return _TotalInUse;
	}

	public void setTotalInUse(int TotalInUse) {
		_TotalInUse = TotalInUse;
	}

	public int getTotalNotUsed() {
		return _TotalNotUsed;
	}

	public void setTotalNotUsed(int TotalNotUsed) {
		_TotalNotUsed = TotalNotUsed;
	}

	public String getApplicantNo() {
		return _applicantNo;
	}

	public void setApplicantNo(String applicantNo) {
		_applicantNo = applicantNo;
	}

	public String getApplicantname() {
		return _applicantname;
	}

	public void setApplicantname(String applicantname) {
		_applicantname = applicantname;
	}

	public String getApplicantaddress() {
		return _applicantaddress;
	}

	public void setApplicantaddress(String applicantaddress) {
		_applicantaddress = applicantaddress;
	}

	public String getProductionplantname() {
		return _productionplantname;
	}

	public void setProductionplantname(String productionplantname) {
		_productionplantname = productionplantname;
	}

	public String getProductionplantaddress() {
		return _productionplantaddress;
	}

	public void setProductionplantaddress(String productionplantaddress) {
		_productionplantaddress = productionplantaddress;
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
	private int _mtcore;
	private int _issueId;
	private int _issueVehicleCertificateId;
	private String _vehiclecertificaterecordno;
	private String _equipmentName;
	private String _equipmentType;
	private String _equipmentCertificateType;
	private String _equipmentDocumentNo;
	private String _equipmentCertificateRecordNo;
	private String _equipmentExamRecordNo;
	private int _EquipmentCertificateRecordId;
	private int _TotalQuantity;
	private int _TotalProductUsed;
	private int _TotalInUse;
	private int _TotalNotUsed;
	private String _applicantNo;
	private String _applicantname;
	private String _applicantaddress;
	private String _productionplantname;
	private String _productionplantaddress;
	private Date _modifyDate;
	private Date _syncDate;
}