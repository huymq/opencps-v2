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

package vn.gt.dao.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author huymq
 * @generated
 */
@ProviderType
public class PushStatisticsLogSoap implements Serializable {
	public static PushStatisticsLogSoap toSoapModel(PushStatisticsLog model) {
		PushStatisticsLogSoap soapModel = new PushStatisticsLogSoap();

		soapModel.setId(model.getId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setDossierId(model.getDossierId());
		soapModel.setFinishDate(model.getFinishDate());
		soapModel.setNewDossierId(model.getNewDossierId());
		soapModel.setStatus(model.getStatus());
		soapModel.setErrorMsg(model.getErrorMsg());

		return soapModel;
	}

	public static PushStatisticsLogSoap[] toSoapModels(
		PushStatisticsLog[] models) {
		PushStatisticsLogSoap[] soapModels = new PushStatisticsLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PushStatisticsLogSoap[][] toSoapModels(
		PushStatisticsLog[][] models) {
		PushStatisticsLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PushStatisticsLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PushStatisticsLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PushStatisticsLogSoap[] toSoapModels(
		List<PushStatisticsLog> models) {
		List<PushStatisticsLogSoap> soapModels = new ArrayList<PushStatisticsLogSoap>(models.size());

		for (PushStatisticsLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PushStatisticsLogSoap[soapModels.size()]);
	}

	public PushStatisticsLogSoap() {
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getDossierId() {
		return _dossierId;
	}

	public void setDossierId(long dossierId) {
		_dossierId = dossierId;
	}

	public Date getFinishDate() {
		return _finishDate;
	}

	public void setFinishDate(Date finishDate) {
		_finishDate = finishDate;
	}

	public long getNewDossierId() {
		return _newDossierId;
	}

	public void setNewDossierId(long newDossierId) {
		_newDossierId = newDossierId;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public String getErrorMsg() {
		return _errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		_errorMsg = errorMsg;
	}

	private long _id;
	private Date _createDate;
	private long _dossierId;
	private Date _finishDate;
	private long _newDossierId;
	private boolean _status;
	private String _errorMsg;
}