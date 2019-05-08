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

package org.opencps.dossiermgt.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UserInfoLog service. Represents a row in the &quot;opencps_userinfolog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.opencps.dossiermgt.model.impl.UserInfoLogModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.opencps.dossiermgt.model.impl.UserInfoLogImpl}.
 * </p>
 *
 * @author huymq
 * @see UserInfoLog
 * @see org.opencps.dossiermgt.model.impl.UserInfoLogImpl
 * @see org.opencps.dossiermgt.model.impl.UserInfoLogModelImpl
 * @generated
 */
@ProviderType
public interface UserInfoLogModel extends BaseModel<UserInfoLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user info log model instance should use the {@link UserInfoLog} interface instead.
	 */

	/**
	 * Returns the primary key of this user info log.
	 *
	 * @return the primary key of this user info log
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user info log.
	 *
	 * @param primaryKey the primary key of this user info log
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this user info log.
	 *
	 * @return the uuid of this user info log
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this user info log.
	 *
	 * @param uuid the uuid of this user info log
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the user log ID of this user info log.
	 *
	 * @return the user log ID of this user info log
	 */
	public long getUserLogId();

	/**
	 * Sets the user log ID of this user info log.
	 *
	 * @param userLogId the user log ID of this user info log
	 */
	public void setUserLogId(long userLogId);

	/**
	 * Returns the user ID of this user info log.
	 *
	 * @return the user ID of this user info log
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this user info log.
	 *
	 * @param userId the user ID of this user info log
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this user info log.
	 *
	 * @return the user uuid of this user info log
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this user info log.
	 *
	 * @param userUuid the user uuid of this user info log
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this user info log.
	 *
	 * @return the create date of this user info log
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this user info log.
	 *
	 * @param createDate the create date of this user info log
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the payload of this user info log.
	 *
	 * @return the payload of this user info log
	 */
	@AutoEscape
	public String getPayload();

	/**
	 * Sets the payload of this user info log.
	 *
	 * @param payload the payload of this user info log
	 */
	public void setPayload(String payload);

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
	public int compareTo(UserInfoLog userInfoLog);

	@Override
	public int hashCode();

	@Override
	public CacheModel<UserInfoLog> toCacheModel();

	@Override
	public UserInfoLog toEscapedModel();

	@Override
	public UserInfoLog toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}