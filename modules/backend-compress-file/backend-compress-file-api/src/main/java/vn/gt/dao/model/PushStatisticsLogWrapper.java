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
 * This class is a wrapper for {@link PushStatisticsLog}.
 * </p>
 *
 * @author huymq
 * @see PushStatisticsLog
 * @generated
 */
@ProviderType
public class PushStatisticsLogWrapper implements PushStatisticsLog,
	ModelWrapper<PushStatisticsLog> {
	public PushStatisticsLogWrapper(PushStatisticsLog pushStatisticsLog) {
		_pushStatisticsLog = pushStatisticsLog;
	}

	@Override
	public Class<?> getModelClass() {
		return PushStatisticsLog.class;
	}

	@Override
	public String getModelClassName() {
		return PushStatisticsLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("createDate", getCreateDate());
		attributes.put("dossierId", getDossierId());
		attributes.put("finishDate", getFinishDate());
		attributes.put("newDossierId", getNewDossierId());
		attributes.put("status", getStatus());
		attributes.put("errorMsg", getErrorMsg());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
		}

		Date finishDate = (Date)attributes.get("finishDate");

		if (finishDate != null) {
			setFinishDate(finishDate);
		}

		Long newDossierId = (Long)attributes.get("newDossierId");

		if (newDossierId != null) {
			setNewDossierId(newDossierId);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String errorMsg = (String)attributes.get("errorMsg");

		if (errorMsg != null) {
			setErrorMsg(errorMsg);
		}
	}

	/**
	* Returns the status of this push statistics log.
	*
	* @return the status of this push statistics log
	*/
	@Override
	public boolean getStatus() {
		return _pushStatisticsLog.getStatus();
	}

	@Override
	public boolean isCachedModel() {
		return _pushStatisticsLog.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _pushStatisticsLog.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _pushStatisticsLog.isNew();
	}

	/**
	* Returns <code>true</code> if this push statistics log is status.
	*
	* @return <code>true</code> if this push statistics log is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _pushStatisticsLog.isStatus();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _pushStatisticsLog.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<vn.gt.dao.model.PushStatisticsLog> toCacheModel() {
		return _pushStatisticsLog.toCacheModel();
	}

	@Override
	public int compareTo(vn.gt.dao.model.PushStatisticsLog pushStatisticsLog) {
		return _pushStatisticsLog.compareTo(pushStatisticsLog);
	}

	@Override
	public int hashCode() {
		return _pushStatisticsLog.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pushStatisticsLog.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PushStatisticsLogWrapper((PushStatisticsLog)_pushStatisticsLog.clone());
	}

	/**
	* Returns the error msg of this push statistics log.
	*
	* @return the error msg of this push statistics log
	*/
	@Override
	public java.lang.String getErrorMsg() {
		return _pushStatisticsLog.getErrorMsg();
	}

	@Override
	public java.lang.String toString() {
		return _pushStatisticsLog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _pushStatisticsLog.toXmlString();
	}

	/**
	* Returns the create date of this push statistics log.
	*
	* @return the create date of this push statistics log
	*/
	@Override
	public Date getCreateDate() {
		return _pushStatisticsLog.getCreateDate();
	}

	/**
	* Returns the finish date of this push statistics log.
	*
	* @return the finish date of this push statistics log
	*/
	@Override
	public Date getFinishDate() {
		return _pushStatisticsLog.getFinishDate();
	}

	/**
	* Returns the dossier ID of this push statistics log.
	*
	* @return the dossier ID of this push statistics log
	*/
	@Override
	public long getDossierId() {
		return _pushStatisticsLog.getDossierId();
	}

	/**
	* Returns the ID of this push statistics log.
	*
	* @return the ID of this push statistics log
	*/
	@Override
	public long getId() {
		return _pushStatisticsLog.getId();
	}

	/**
	* Returns the new dossier ID of this push statistics log.
	*
	* @return the new dossier ID of this push statistics log
	*/
	@Override
	public long getNewDossierId() {
		return _pushStatisticsLog.getNewDossierId();
	}

	/**
	* Returns the primary key of this push statistics log.
	*
	* @return the primary key of this push statistics log
	*/
	@Override
	public long getPrimaryKey() {
		return _pushStatisticsLog.getPrimaryKey();
	}

	@Override
	public vn.gt.dao.model.PushStatisticsLog toEscapedModel() {
		return new PushStatisticsLogWrapper(_pushStatisticsLog.toEscapedModel());
	}

	@Override
	public vn.gt.dao.model.PushStatisticsLog toUnescapedModel() {
		return new PushStatisticsLogWrapper(_pushStatisticsLog.toUnescapedModel());
	}

	@Override
	public void persist() {
		_pushStatisticsLog.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_pushStatisticsLog.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this push statistics log.
	*
	* @param createDate the create date of this push statistics log
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_pushStatisticsLog.setCreateDate(createDate);
	}

	/**
	* Sets the dossier ID of this push statistics log.
	*
	* @param dossierId the dossier ID of this push statistics log
	*/
	@Override
	public void setDossierId(long dossierId) {
		_pushStatisticsLog.setDossierId(dossierId);
	}

	/**
	* Sets the error msg of this push statistics log.
	*
	* @param errorMsg the error msg of this push statistics log
	*/
	@Override
	public void setErrorMsg(java.lang.String errorMsg) {
		_pushStatisticsLog.setErrorMsg(errorMsg);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_pushStatisticsLog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_pushStatisticsLog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_pushStatisticsLog.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the finish date of this push statistics log.
	*
	* @param finishDate the finish date of this push statistics log
	*/
	@Override
	public void setFinishDate(Date finishDate) {
		_pushStatisticsLog.setFinishDate(finishDate);
	}

	/**
	* Sets the ID of this push statistics log.
	*
	* @param id the ID of this push statistics log
	*/
	@Override
	public void setId(long id) {
		_pushStatisticsLog.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_pushStatisticsLog.setNew(n);
	}

	/**
	* Sets the new dossier ID of this push statistics log.
	*
	* @param newDossierId the new dossier ID of this push statistics log
	*/
	@Override
	public void setNewDossierId(long newDossierId) {
		_pushStatisticsLog.setNewDossierId(newDossierId);
	}

	/**
	* Sets the primary key of this push statistics log.
	*
	* @param primaryKey the primary key of this push statistics log
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_pushStatisticsLog.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_pushStatisticsLog.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this push statistics log is status.
	*
	* @param status the status of this push statistics log
	*/
	@Override
	public void setStatus(boolean status) {
		_pushStatisticsLog.setStatus(status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PushStatisticsLogWrapper)) {
			return false;
		}

		PushStatisticsLogWrapper pushStatisticsLogWrapper = (PushStatisticsLogWrapper)obj;

		if (Objects.equals(_pushStatisticsLog,
					pushStatisticsLogWrapper._pushStatisticsLog)) {
			return true;
		}

		return false;
	}

	@Override
	public PushStatisticsLog getWrappedModel() {
		return _pushStatisticsLog;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _pushStatisticsLog.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _pushStatisticsLog.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_pushStatisticsLog.resetOriginalValues();
	}

	private final PushStatisticsLog _pushStatisticsLog;
}