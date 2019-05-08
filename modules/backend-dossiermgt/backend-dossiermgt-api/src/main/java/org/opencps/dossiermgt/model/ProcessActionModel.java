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
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ProcessAction service. Represents a row in the &quot;opencps_processaction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.opencps.dossiermgt.model.impl.ProcessActionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.opencps.dossiermgt.model.impl.ProcessActionImpl}.
 * </p>
 *
 * @author huymq
 * @see ProcessAction
 * @see org.opencps.dossiermgt.model.impl.ProcessActionImpl
 * @see org.opencps.dossiermgt.model.impl.ProcessActionModelImpl
 * @generated
 */
@ProviderType
public interface ProcessActionModel extends BaseModel<ProcessAction>,
	GroupedModel, ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a process action model instance should use the {@link ProcessAction} interface instead.
	 */

	/**
	 * Returns the primary key of this process action.
	 *
	 * @return the primary key of this process action
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this process action.
	 *
	 * @param primaryKey the primary key of this process action
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this process action.
	 *
	 * @return the uuid of this process action
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this process action.
	 *
	 * @param uuid the uuid of this process action
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the process action ID of this process action.
	 *
	 * @return the process action ID of this process action
	 */
	public long getProcessActionId();

	/**
	 * Sets the process action ID of this process action.
	 *
	 * @param processActionId the process action ID of this process action
	 */
	public void setProcessActionId(long processActionId);

	/**
	 * Returns the company ID of this process action.
	 *
	 * @return the company ID of this process action
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this process action.
	 *
	 * @param companyId the company ID of this process action
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this process action.
	 *
	 * @return the group ID of this process action
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this process action.
	 *
	 * @param groupId the group ID of this process action
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this process action.
	 *
	 * @return the user ID of this process action
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this process action.
	 *
	 * @param userId the user ID of this process action
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this process action.
	 *
	 * @return the user uuid of this process action
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this process action.
	 *
	 * @param userUuid the user uuid of this process action
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this process action.
	 *
	 * @return the user name of this process action
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this process action.
	 *
	 * @param userName the user name of this process action
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this process action.
	 *
	 * @return the create date of this process action
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this process action.
	 *
	 * @param createDate the create date of this process action
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this process action.
	 *
	 * @return the modified date of this process action
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this process action.
	 *
	 * @param modifiedDate the modified date of this process action
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the service process ID of this process action.
	 *
	 * @return the service process ID of this process action
	 */
	public long getServiceProcessId();

	/**
	 * Sets the service process ID of this process action.
	 *
	 * @param serviceProcessId the service process ID of this process action
	 */
	public void setServiceProcessId(long serviceProcessId);

	/**
	 * Returns the pre step code of this process action.
	 *
	 * @return the pre step code of this process action
	 */
	@AutoEscape
	public String getPreStepCode();

	/**
	 * Sets the pre step code of this process action.
	 *
	 * @param preStepCode the pre step code of this process action
	 */
	public void setPreStepCode(String preStepCode);

	/**
	 * Returns the post step code of this process action.
	 *
	 * @return the post step code of this process action
	 */
	@AutoEscape
	public String getPostStepCode();

	/**
	 * Sets the post step code of this process action.
	 *
	 * @param postStepCode the post step code of this process action
	 */
	public void setPostStepCode(String postStepCode);

	/**
	 * Returns the auto event of this process action.
	 *
	 * @return the auto event of this process action
	 */
	@AutoEscape
	public String getAutoEvent();

	/**
	 * Sets the auto event of this process action.
	 *
	 * @param autoEvent the auto event of this process action
	 */
	public void setAutoEvent(String autoEvent);

	/**
	 * Returns the pre condition of this process action.
	 *
	 * @return the pre condition of this process action
	 */
	@AutoEscape
	public String getPreCondition();

	/**
	 * Sets the pre condition of this process action.
	 *
	 * @param preCondition the pre condition of this process action
	 */
	public void setPreCondition(String preCondition);

	/**
	 * Returns the action code of this process action.
	 *
	 * @return the action code of this process action
	 */
	@AutoEscape
	public String getActionCode();

	/**
	 * Sets the action code of this process action.
	 *
	 * @param actionCode the action code of this process action
	 */
	public void setActionCode(String actionCode);

	/**
	 * Returns the action name of this process action.
	 *
	 * @return the action name of this process action
	 */
	@AutoEscape
	public String getActionName();

	/**
	 * Sets the action name of this process action.
	 *
	 * @param actionName the action name of this process action
	 */
	public void setActionName(String actionName);

	/**
	 * Returns the allow assign user of this process action.
	 *
	 * @return the allow assign user of this process action
	 */
	public boolean getAllowAssignUser();

	/**
	 * Returns <code>true</code> if this process action is allow assign user.
	 *
	 * @return <code>true</code> if this process action is allow assign user; <code>false</code> otherwise
	 */
	public boolean isAllowAssignUser();

	/**
	 * Sets whether this process action is allow assign user.
	 *
	 * @param allowAssignUser the allow assign user of this process action
	 */
	public void setAllowAssignUser(boolean allowAssignUser);

	/**
	 * Returns the assign user ID of this process action.
	 *
	 * @return the assign user ID of this process action
	 */
	public long getAssignUserId();

	/**
	 * Sets the assign user ID of this process action.
	 *
	 * @param assignUserId the assign user ID of this process action
	 */
	public void setAssignUserId(long assignUserId);

	/**
	 * Returns the assign user uuid of this process action.
	 *
	 * @return the assign user uuid of this process action
	 */
	public String getAssignUserUuid();

	/**
	 * Sets the assign user uuid of this process action.
	 *
	 * @param assignUserUuid the assign user uuid of this process action
	 */
	public void setAssignUserUuid(String assignUserUuid);

	/**
	 * Returns the request payment of this process action.
	 *
	 * @return the request payment of this process action
	 */
	public boolean getRequestPayment();

	/**
	 * Returns <code>true</code> if this process action is request payment.
	 *
	 * @return <code>true</code> if this process action is request payment; <code>false</code> otherwise
	 */
	public boolean isRequestPayment();

	/**
	 * Sets whether this process action is request payment.
	 *
	 * @param requestPayment the request payment of this process action
	 */
	public void setRequestPayment(boolean requestPayment);

	/**
	 * Returns the payment fee of this process action.
	 *
	 * @return the payment fee of this process action
	 */
	@AutoEscape
	public String getPaymentFee();

	/**
	 * Sets the payment fee of this process action.
	 *
	 * @param paymentFee the payment fee of this process action
	 */
	public void setPaymentFee(String paymentFee);

	/**
	 * Returns the create dossier files of this process action.
	 *
	 * @return the create dossier files of this process action
	 */
	@AutoEscape
	public String getCreateDossierFiles();

	/**
	 * Sets the create dossier files of this process action.
	 *
	 * @param createDossierFiles the create dossier files of this process action
	 */
	public void setCreateDossierFiles(String createDossierFiles);

	/**
	 * Returns the return dossier files of this process action.
	 *
	 * @return the return dossier files of this process action
	 */
	@AutoEscape
	public String getReturnDossierFiles();

	/**
	 * Sets the return dossier files of this process action.
	 *
	 * @param returnDossierFiles the return dossier files of this process action
	 */
	public void setReturnDossierFiles(String returnDossierFiles);

	/**
	 * Returns the make brief note of this process action.
	 *
	 * @return the make brief note of this process action
	 */
	@AutoEscape
	public String getMakeBriefNote();

	/**
	 * Sets the make brief note of this process action.
	 *
	 * @param makeBriefNote the make brief note of this process action
	 */
	public void setMakeBriefNote(String makeBriefNote);

	/**
	 * Returns the sync action code of this process action.
	 *
	 * @return the sync action code of this process action
	 */
	@AutoEscape
	public String getSyncActionCode();

	/**
	 * Sets the sync action code of this process action.
	 *
	 * @param syncActionCode the sync action code of this process action
	 */
	public void setSyncActionCode(String syncActionCode);

	/**
	 * Returns the rollbackable of this process action.
	 *
	 * @return the rollbackable of this process action
	 */
	public boolean getRollbackable();

	/**
	 * Returns <code>true</code> if this process action is rollbackable.
	 *
	 * @return <code>true</code> if this process action is rollbackable; <code>false</code> otherwise
	 */
	public boolean isRollbackable();

	/**
	 * Sets whether this process action is rollbackable.
	 *
	 * @param rollbackable the rollbackable of this process action
	 */
	public void setRollbackable(boolean rollbackable);

	/**
	 * Returns the create dossier no of this process action.
	 *
	 * @return the create dossier no of this process action
	 */
	public boolean getCreateDossierNo();

	/**
	 * Returns <code>true</code> if this process action is create dossier no.
	 *
	 * @return <code>true</code> if this process action is create dossier no; <code>false</code> otherwise
	 */
	public boolean isCreateDossierNo();

	/**
	 * Sets whether this process action is create dossier no.
	 *
	 * @param createDossierNo the create dossier no of this process action
	 */
	public void setCreateDossierNo(boolean createDossierNo);

	/**
	 * Returns the e signature of this process action.
	 *
	 * @return the e signature of this process action
	 */
	public boolean getESignature();

	/**
	 * Returns <code>true</code> if this process action is e signature.
	 *
	 * @return <code>true</code> if this process action is e signature; <code>false</code> otherwise
	 */
	public boolean isESignature();

	/**
	 * Sets whether this process action is e signature.
	 *
	 * @param eSignature the e signature of this process action
	 */
	public void setESignature(boolean eSignature);

	/**
	 * Returns the config note of this process action.
	 *
	 * @return the config note of this process action
	 */
	@AutoEscape
	public String getConfigNote();

	/**
	 * Sets the config note of this process action.
	 *
	 * @param configNote the config note of this process action
	 */
	public void setConfigNote(String configNote);

	/**
	 * Returns the dossier template no of this process action.
	 *
	 * @return the dossier template no of this process action
	 */
	@AutoEscape
	public String getDossierTemplateNo();

	/**
	 * Sets the dossier template no of this process action.
	 *
	 * @param dossierTemplateNo the dossier template no of this process action
	 */
	public void setDossierTemplateNo(String dossierTemplateNo);

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
	public int compareTo(ProcessAction processAction);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ProcessAction> toCacheModel();

	@Override
	public ProcessAction toEscapedModel();

	@Override
	public ProcessAction toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}