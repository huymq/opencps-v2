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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PushStatisticsLog service. Represents a row in the &quot;compressfile_PushStatisticsLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.gt.dao.model.impl.PushStatisticsLogModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.gt.dao.model.impl.PushStatisticsLogImpl}.
 * </p>
 *
 * @author huymq
 * @see PushStatisticsLog
 * @see vn.gt.dao.model.impl.PushStatisticsLogImpl
 * @see vn.gt.dao.model.impl.PushStatisticsLogModelImpl
 * @generated
 */
@ProviderType
public interface PushStatisticsLogModel extends BaseModel<PushStatisticsLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a push statistics log model instance should use the {@link PushStatisticsLog} interface instead.
	 */

	/**
	 * Returns the primary key of this push statistics log.
	 *
	 * @return the primary key of this push statistics log
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this push statistics log.
	 *
	 * @param primaryKey the primary key of this push statistics log
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this push statistics log.
	 *
	 * @return the ID of this push statistics log
	 */
	public long getId();

	/**
	 * Sets the ID of this push statistics log.
	 *
	 * @param id the ID of this push statistics log
	 */
	public void setId(long id);

	/**
	 * Returns the create date of this push statistics log.
	 *
	 * @return the create date of this push statistics log
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this push statistics log.
	 *
	 * @param createDate the create date of this push statistics log
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the dossier ID of this push statistics log.
	 *
	 * @return the dossier ID of this push statistics log
	 */
	public long getDossierId();

	/**
	 * Sets the dossier ID of this push statistics log.
	 *
	 * @param dossierId the dossier ID of this push statistics log
	 */
	public void setDossierId(long dossierId);

	/**
	 * Returns the finish date of this push statistics log.
	 *
	 * @return the finish date of this push statistics log
	 */
	public Date getFinishDate();

	/**
	 * Sets the finish date of this push statistics log.
	 *
	 * @param finishDate the finish date of this push statistics log
	 */
	public void setFinishDate(Date finishDate);

	/**
	 * Returns the new dossier ID of this push statistics log.
	 *
	 * @return the new dossier ID of this push statistics log
	 */
	public long getNewDossierId();

	/**
	 * Sets the new dossier ID of this push statistics log.
	 *
	 * @param newDossierId the new dossier ID of this push statistics log
	 */
	public void setNewDossierId(long newDossierId);

	/**
	 * Returns the status of this push statistics log.
	 *
	 * @return the status of this push statistics log
	 */
	public boolean getStatus();

	/**
	 * Returns <code>true</code> if this push statistics log is status.
	 *
	 * @return <code>true</code> if this push statistics log is status; <code>false</code> otherwise
	 */
	public boolean isStatus();

	/**
	 * Sets whether this push statistics log is status.
	 *
	 * @param status the status of this push statistics log
	 */
	public void setStatus(boolean status);

	/**
	 * Returns the error msg of this push statistics log.
	 *
	 * @return the error msg of this push statistics log
	 */
	@AutoEscape
	public String getErrorMsg();

	/**
	 * Sets the error msg of this push statistics log.
	 *
	 * @param errorMsg the error msg of this push statistics log
	 */
	public void setErrorMsg(String errorMsg);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(vn.gt.dao.model.PushStatisticsLog pushStatisticsLog);

	@Override
	public int hashCode();

	@Override
	public CacheModel<vn.gt.dao.model.PushStatisticsLog> toCacheModel();

	@Override
	public vn.gt.dao.model.PushStatisticsLog toEscapedModel();

	@Override
	public vn.gt.dao.model.PushStatisticsLog toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}