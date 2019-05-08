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

package com.fds.vr.business.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.fds.vr.business.model.VRVehicleEquipment;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VRVehicleEquipment in entity cache.
 *
 * @author LamTV
 * @see VRVehicleEquipment
 * @generated
 */
@ProviderType
public class VRVehicleEquipmentCacheModel implements CacheModel<VRVehicleEquipment>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRVehicleEquipmentCacheModel)) {
			return false;
		}

		VRVehicleEquipmentCacheModel vrVehicleEquipmentCacheModel = (VRVehicleEquipmentCacheModel)obj;

		if (id == vrVehicleEquipmentCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", vehicleCertificateId=");
		sb.append(vehicleCertificateId);
		sb.append(", certificateRecordId=");
		sb.append(certificateRecordId);
		sb.append(", modifyDate=");
		sb.append(modifyDate);
		sb.append(", syncDate=");
		sb.append(syncDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VRVehicleEquipment toEntityModel() {
		VRVehicleEquipmentImpl vrVehicleEquipmentImpl = new VRVehicleEquipmentImpl();

		vrVehicleEquipmentImpl.setId(id);
		vrVehicleEquipmentImpl.setVehicleCertificateId(vehicleCertificateId);
		vrVehicleEquipmentImpl.setCertificateRecordId(certificateRecordId);

		if (modifyDate == Long.MIN_VALUE) {
			vrVehicleEquipmentImpl.setModifyDate(null);
		}
		else {
			vrVehicleEquipmentImpl.setModifyDate(new Date(modifyDate));
		}

		if (syncDate == Long.MIN_VALUE) {
			vrVehicleEquipmentImpl.setSyncDate(null);
		}
		else {
			vrVehicleEquipmentImpl.setSyncDate(new Date(syncDate));
		}

		vrVehicleEquipmentImpl.resetOriginalValues();

		return vrVehicleEquipmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		vehicleCertificateId = objectInput.readLong();

		certificateRecordId = objectInput.readLong();
		modifyDate = objectInput.readLong();
		syncDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(vehicleCertificateId);

		objectOutput.writeLong(certificateRecordId);
		objectOutput.writeLong(modifyDate);
		objectOutput.writeLong(syncDate);
	}

	public long id;
	public long vehicleCertificateId;
	public long certificateRecordId;
	public long modifyDate;
	public long syncDate;
}