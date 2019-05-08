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
public class VRIssueVehiclecertificateSoap implements Serializable {
	public static VRIssueVehiclecertificateSoap toSoapModel(
		VRIssueVehiclecertificate model) {
		VRIssueVehiclecertificateSoap soapModel = new VRIssueVehiclecertificateSoap();

		soapModel.setId(model.getId());
		soapModel.setMtCore(model.getMtCore());
		soapModel.setIssueId(model.getIssueId());
		soapModel.setDossierId(model.getDossierId());
		soapModel.setCertificateId(model.getCertificateId());
		soapModel.setVehiclePrice(model.getVehiclePrice());
		soapModel.setTotalQuantity(model.getTotalQuantity());
		soapModel.setUnitPrice(model.getUnitPrice());
		soapModel.setCertificaterecordno(model.getCertificaterecordno());
		soapModel.setProductionexamreportno(model.getProductionexamreportno());
		soapModel.setProductyear(model.getProductyear());
		soapModel.setProductmonth(model.getProductmonth());
		soapModel.setTotalstamp(model.getTotalstamp());
		soapModel.setTotalproduct(model.getTotalproduct());
		soapModel.setModifyDate(model.getModifyDate());

		return soapModel;
	}

	public static VRIssueVehiclecertificateSoap[] toSoapModels(
		VRIssueVehiclecertificate[] models) {
		VRIssueVehiclecertificateSoap[] soapModels = new VRIssueVehiclecertificateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VRIssueVehiclecertificateSoap[][] toSoapModels(
		VRIssueVehiclecertificate[][] models) {
		VRIssueVehiclecertificateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VRIssueVehiclecertificateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VRIssueVehiclecertificateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VRIssueVehiclecertificateSoap[] toSoapModels(
		List<VRIssueVehiclecertificate> models) {
		List<VRIssueVehiclecertificateSoap> soapModels = new ArrayList<VRIssueVehiclecertificateSoap>(models.size());

		for (VRIssueVehiclecertificate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VRIssueVehiclecertificateSoap[soapModels.size()]);
	}

	public VRIssueVehiclecertificateSoap() {
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

	public long getIssueId() {
		return _issueId;
	}

	public void setIssueId(long issueId) {
		_issueId = issueId;
	}

	public long getDossierId() {
		return _dossierId;
	}

	public void setDossierId(long dossierId) {
		_dossierId = dossierId;
	}

	public long getCertificateId() {
		return _certificateId;
	}

	public void setCertificateId(long certificateId) {
		_certificateId = certificateId;
	}

	public long getVehiclePrice() {
		return _vehiclePrice;
	}

	public void setVehiclePrice(long vehiclePrice) {
		_vehiclePrice = vehiclePrice;
	}

	public long getTotalQuantity() {
		return _totalQuantity;
	}

	public void setTotalQuantity(long totalQuantity) {
		_totalQuantity = totalQuantity;
	}

	public long getUnitPrice() {
		return _unitPrice;
	}

	public void setUnitPrice(long unitPrice) {
		_unitPrice = unitPrice;
	}

	public String getCertificaterecordno() {
		return _certificaterecordno;
	}

	public void setCertificaterecordno(String certificaterecordno) {
		_certificaterecordno = certificaterecordno;
	}

	public String getProductionexamreportno() {
		return _productionexamreportno;
	}

	public void setProductionexamreportno(String productionexamreportno) {
		_productionexamreportno = productionexamreportno;
	}

	public String getProductyear() {
		return _productyear;
	}

	public void setProductyear(String productyear) {
		_productyear = productyear;
	}

	public int getProductmonth() {
		return _productmonth;
	}

	public void setProductmonth(int productmonth) {
		_productmonth = productmonth;
	}

	public int getTotalstamp() {
		return _totalstamp;
	}

	public void setTotalstamp(int totalstamp) {
		_totalstamp = totalstamp;
	}

	public int getTotalproduct() {
		return _totalproduct;
	}

	public void setTotalproduct(int totalproduct) {
		_totalproduct = totalproduct;
	}

	public Date getModifyDate() {
		return _modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		_modifyDate = modifyDate;
	}

	private long _id;
	private long _mtCore;
	private long _issueId;
	private long _dossierId;
	private long _certificateId;
	private long _vehiclePrice;
	private long _totalQuantity;
	private long _unitPrice;
	private String _certificaterecordno;
	private String _productionexamreportno;
	private String _productyear;
	private int _productmonth;
	private int _totalstamp;
	private int _totalproduct;
	private Date _modifyDate;
}