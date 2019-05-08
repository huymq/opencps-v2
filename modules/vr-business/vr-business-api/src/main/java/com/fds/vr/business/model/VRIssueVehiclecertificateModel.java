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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the VRIssueVehiclecertificate service. Represents a row in the &quot;vr_issue_vehiclecertificate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fds.vr.business.model.impl.VRIssueVehiclecertificateModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fds.vr.business.model.impl.VRIssueVehiclecertificateImpl}.
 * </p>
 *
 * @author LamTV
 * @see VRIssueVehiclecertificate
 * @see com.fds.vr.business.model.impl.VRIssueVehiclecertificateImpl
 * @see com.fds.vr.business.model.impl.VRIssueVehiclecertificateModelImpl
 * @generated
 */
@ProviderType
public interface VRIssueVehiclecertificateModel extends BaseModel<VRIssueVehiclecertificate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vr issue vehiclecertificate model instance should use the {@link VRIssueVehiclecertificate} interface instead.
	 */

	/**
	 * Returns the primary key of this vr issue vehiclecertificate.
	 *
	 * @return the primary key of this vr issue vehiclecertificate
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this vr issue vehiclecertificate.
	 *
	 * @param primaryKey the primary key of this vr issue vehiclecertificate
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this vr issue vehiclecertificate.
	 *
	 * @return the ID of this vr issue vehiclecertificate
	 */
	public long getId();

	/**
	 * Sets the ID of this vr issue vehiclecertificate.
	 *
	 * @param id the ID of this vr issue vehiclecertificate
	 */
	public void setId(long id);

	/**
	 * Returns the mt core of this vr issue vehiclecertificate.
	 *
	 * @return the mt core of this vr issue vehiclecertificate
	 */
	public long getMtCore();

	/**
	 * Sets the mt core of this vr issue vehiclecertificate.
	 *
	 * @param mtCore the mt core of this vr issue vehiclecertificate
	 */
	public void setMtCore(long mtCore);

	/**
	 * Returns the issue ID of this vr issue vehiclecertificate.
	 *
	 * @return the issue ID of this vr issue vehiclecertificate
	 */
	public long getIssueId();

	/**
	 * Sets the issue ID of this vr issue vehiclecertificate.
	 *
	 * @param issueId the issue ID of this vr issue vehiclecertificate
	 */
	public void setIssueId(long issueId);

	/**
	 * Returns the dossier ID of this vr issue vehiclecertificate.
	 *
	 * @return the dossier ID of this vr issue vehiclecertificate
	 */
	public long getDossierId();

	/**
	 * Sets the dossier ID of this vr issue vehiclecertificate.
	 *
	 * @param dossierId the dossier ID of this vr issue vehiclecertificate
	 */
	public void setDossierId(long dossierId);

	/**
	 * Returns the certificate ID of this vr issue vehiclecertificate.
	 *
	 * @return the certificate ID of this vr issue vehiclecertificate
	 */
	public long getCertificateId();

	/**
	 * Sets the certificate ID of this vr issue vehiclecertificate.
	 *
	 * @param certificateId the certificate ID of this vr issue vehiclecertificate
	 */
	public void setCertificateId(long certificateId);

	/**
	 * Returns the vehicle price of this vr issue vehiclecertificate.
	 *
	 * @return the vehicle price of this vr issue vehiclecertificate
	 */
	public long getVehiclePrice();

	/**
	 * Sets the vehicle price of this vr issue vehiclecertificate.
	 *
	 * @param vehiclePrice the vehicle price of this vr issue vehiclecertificate
	 */
	public void setVehiclePrice(long vehiclePrice);

	/**
	 * Returns the total quantity of this vr issue vehiclecertificate.
	 *
	 * @return the total quantity of this vr issue vehiclecertificate
	 */
	public long getTotalQuantity();

	/**
	 * Sets the total quantity of this vr issue vehiclecertificate.
	 *
	 * @param totalQuantity the total quantity of this vr issue vehiclecertificate
	 */
	public void setTotalQuantity(long totalQuantity);

	/**
	 * Returns the unit price of this vr issue vehiclecertificate.
	 *
	 * @return the unit price of this vr issue vehiclecertificate
	 */
	public long getUnitPrice();

	/**
	 * Sets the unit price of this vr issue vehiclecertificate.
	 *
	 * @param unitPrice the unit price of this vr issue vehiclecertificate
	 */
	public void setUnitPrice(long unitPrice);

	/**
	 * Returns the certificaterecordno of this vr issue vehiclecertificate.
	 *
	 * @return the certificaterecordno of this vr issue vehiclecertificate
	 */
	@AutoEscape
	public String getCertificaterecordno();

	/**
	 * Sets the certificaterecordno of this vr issue vehiclecertificate.
	 *
	 * @param certificaterecordno the certificaterecordno of this vr issue vehiclecertificate
	 */
	public void setCertificaterecordno(String certificaterecordno);

	/**
	 * Returns the productionexamreportno of this vr issue vehiclecertificate.
	 *
	 * @return the productionexamreportno of this vr issue vehiclecertificate
	 */
	@AutoEscape
	public String getProductionexamreportno();

	/**
	 * Sets the productionexamreportno of this vr issue vehiclecertificate.
	 *
	 * @param productionexamreportno the productionexamreportno of this vr issue vehiclecertificate
	 */
	public void setProductionexamreportno(String productionexamreportno);

	/**
	 * Returns the productyear of this vr issue vehiclecertificate.
	 *
	 * @return the productyear of this vr issue vehiclecertificate
	 */
	@AutoEscape
	public String getProductyear();

	/**
	 * Sets the productyear of this vr issue vehiclecertificate.
	 *
	 * @param productyear the productyear of this vr issue vehiclecertificate
	 */
	public void setProductyear(String productyear);

	/**
	 * Returns the productmonth of this vr issue vehiclecertificate.
	 *
	 * @return the productmonth of this vr issue vehiclecertificate
	 */
	public int getProductmonth();

	/**
	 * Sets the productmonth of this vr issue vehiclecertificate.
	 *
	 * @param productmonth the productmonth of this vr issue vehiclecertificate
	 */
	public void setProductmonth(int productmonth);

	/**
	 * Returns the totalstamp of this vr issue vehiclecertificate.
	 *
	 * @return the totalstamp of this vr issue vehiclecertificate
	 */
	public int getTotalstamp();

	/**
	 * Sets the totalstamp of this vr issue vehiclecertificate.
	 *
	 * @param totalstamp the totalstamp of this vr issue vehiclecertificate
	 */
	public void setTotalstamp(int totalstamp);

	/**
	 * Returns the totalproduct of this vr issue vehiclecertificate.
	 *
	 * @return the totalproduct of this vr issue vehiclecertificate
	 */
	public int getTotalproduct();

	/**
	 * Sets the totalproduct of this vr issue vehiclecertificate.
	 *
	 * @param totalproduct the totalproduct of this vr issue vehiclecertificate
	 */
	public void setTotalproduct(int totalproduct);

	/**
	 * Returns the modify date of this vr issue vehiclecertificate.
	 *
	 * @return the modify date of this vr issue vehiclecertificate
	 */
	public Date getModifyDate();

	/**
	 * Sets the modify date of this vr issue vehiclecertificate.
	 *
	 * @param modifyDate the modify date of this vr issue vehiclecertificate
	 */
	public void setModifyDate(Date modifyDate);

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
	public int compareTo(VRIssueVehiclecertificate vrIssueVehiclecertificate);

	@Override
	public int hashCode();

	@Override
	public CacheModel<VRIssueVehiclecertificate> toCacheModel();

	@Override
	public VRIssueVehiclecertificate toEscapedModel();

	@Override
	public VRIssueVehiclecertificate toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}