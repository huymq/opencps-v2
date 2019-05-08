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

import com.fds.vr.business.model.VRProductionPlantEquipment;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VRProductionPlantEquipment in entity cache.
 *
 * @author LamTV
 * @see VRProductionPlantEquipment
 * @generated
 */
@ProviderType
public class VRProductionPlantEquipmentCacheModel implements CacheModel<VRProductionPlantEquipment>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRProductionPlantEquipmentCacheModel)) {
			return false;
		}

		VRProductionPlantEquipmentCacheModel vrProductionPlantEquipmentCacheModel =
			(VRProductionPlantEquipmentCacheModel)obj;

		if (id == vrProductionPlantEquipmentCacheModel.id) {
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
		StringBundler sb = new StringBundler(35);

		sb.append("{id=");
		sb.append(id);
		sb.append(", mtCore=");
		sb.append(mtCore);
		sb.append(", productPlantID=");
		sb.append(productPlantID);
		sb.append(", sequenceNo=");
		sb.append(sequenceNo);
		sb.append(", equipmentCode=");
		sb.append(equipmentCode);
		sb.append(", equipmentName=");
		sb.append(equipmentName);
		sb.append(", equipmentType=");
		sb.append(equipmentType);
		sb.append(", trademark=");
		sb.append(trademark);
		sb.append(", trademarkName=");
		sb.append(trademarkName);
		sb.append(", commercialName=");
		sb.append(commercialName);
		sb.append(", modelCode=");
		sb.append(modelCode);
		sb.append(", designSymbolNo=");
		sb.append(designSymbolNo);
		sb.append(", productionCountryCode=");
		sb.append(productionCountryCode);
		sb.append(", equipmentStatus=");
		sb.append(equipmentStatus);
		sb.append(", notes=");
		sb.append(notes);
		sb.append(", modifyDate=");
		sb.append(modifyDate);
		sb.append(", syncDate=");
		sb.append(syncDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VRProductionPlantEquipment toEntityModel() {
		VRProductionPlantEquipmentImpl vrProductionPlantEquipmentImpl = new VRProductionPlantEquipmentImpl();

		vrProductionPlantEquipmentImpl.setId(id);
		vrProductionPlantEquipmentImpl.setMtCore(mtCore);
		vrProductionPlantEquipmentImpl.setProductPlantID(productPlantID);
		vrProductionPlantEquipmentImpl.setSequenceNo(sequenceNo);

		if (equipmentCode == null) {
			vrProductionPlantEquipmentImpl.setEquipmentCode(StringPool.BLANK);
		}
		else {
			vrProductionPlantEquipmentImpl.setEquipmentCode(equipmentCode);
		}

		if (equipmentName == null) {
			vrProductionPlantEquipmentImpl.setEquipmentName(StringPool.BLANK);
		}
		else {
			vrProductionPlantEquipmentImpl.setEquipmentName(equipmentName);
		}

		if (equipmentType == null) {
			vrProductionPlantEquipmentImpl.setEquipmentType(StringPool.BLANK);
		}
		else {
			vrProductionPlantEquipmentImpl.setEquipmentType(equipmentType);
		}

		if (trademark == null) {
			vrProductionPlantEquipmentImpl.setTrademark(StringPool.BLANK);
		}
		else {
			vrProductionPlantEquipmentImpl.setTrademark(trademark);
		}

		if (trademarkName == null) {
			vrProductionPlantEquipmentImpl.setTrademarkName(StringPool.BLANK);
		}
		else {
			vrProductionPlantEquipmentImpl.setTrademarkName(trademarkName);
		}

		if (commercialName == null) {
			vrProductionPlantEquipmentImpl.setCommercialName(StringPool.BLANK);
		}
		else {
			vrProductionPlantEquipmentImpl.setCommercialName(commercialName);
		}

		if (modelCode == null) {
			vrProductionPlantEquipmentImpl.setModelCode(StringPool.BLANK);
		}
		else {
			vrProductionPlantEquipmentImpl.setModelCode(modelCode);
		}

		if (designSymbolNo == null) {
			vrProductionPlantEquipmentImpl.setDesignSymbolNo(StringPool.BLANK);
		}
		else {
			vrProductionPlantEquipmentImpl.setDesignSymbolNo(designSymbolNo);
		}

		if (productionCountryCode == null) {
			vrProductionPlantEquipmentImpl.setProductionCountryCode(StringPool.BLANK);
		}
		else {
			vrProductionPlantEquipmentImpl.setProductionCountryCode(productionCountryCode);
		}

		if (equipmentStatus == null) {
			vrProductionPlantEquipmentImpl.setEquipmentStatus(StringPool.BLANK);
		}
		else {
			vrProductionPlantEquipmentImpl.setEquipmentStatus(equipmentStatus);
		}

		if (notes == null) {
			vrProductionPlantEquipmentImpl.setNotes(StringPool.BLANK);
		}
		else {
			vrProductionPlantEquipmentImpl.setNotes(notes);
		}

		if (modifyDate == Long.MIN_VALUE) {
			vrProductionPlantEquipmentImpl.setModifyDate(null);
		}
		else {
			vrProductionPlantEquipmentImpl.setModifyDate(new Date(modifyDate));
		}

		if (syncDate == Long.MIN_VALUE) {
			vrProductionPlantEquipmentImpl.setSyncDate(null);
		}
		else {
			vrProductionPlantEquipmentImpl.setSyncDate(new Date(syncDate));
		}

		vrProductionPlantEquipmentImpl.resetOriginalValues();

		return vrProductionPlantEquipmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		mtCore = objectInput.readLong();

		productPlantID = objectInput.readLong();

		sequenceNo = objectInput.readLong();
		equipmentCode = objectInput.readUTF();
		equipmentName = objectInput.readUTF();
		equipmentType = objectInput.readUTF();
		trademark = objectInput.readUTF();
		trademarkName = objectInput.readUTF();
		commercialName = objectInput.readUTF();
		modelCode = objectInput.readUTF();
		designSymbolNo = objectInput.readUTF();
		productionCountryCode = objectInput.readUTF();
		equipmentStatus = objectInput.readUTF();
		notes = objectInput.readUTF();
		modifyDate = objectInput.readLong();
		syncDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(mtCore);

		objectOutput.writeLong(productPlantID);

		objectOutput.writeLong(sequenceNo);

		if (equipmentCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentCode);
		}

		if (equipmentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentName);
		}

		if (equipmentType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentType);
		}

		if (trademark == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(trademark);
		}

		if (trademarkName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(trademarkName);
		}

		if (commercialName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(commercialName);
		}

		if (modelCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(modelCode);
		}

		if (designSymbolNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(designSymbolNo);
		}

		if (productionCountryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productionCountryCode);
		}

		if (equipmentStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(equipmentStatus);
		}

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}

		objectOutput.writeLong(modifyDate);
		objectOutput.writeLong(syncDate);
	}

	public long id;
	public long mtCore;
	public long productPlantID;
	public long sequenceNo;
	public String equipmentCode;
	public String equipmentName;
	public String equipmentType;
	public String trademark;
	public String trademarkName;
	public String commercialName;
	public String modelCode;
	public String designSymbolNo;
	public String productionCountryCode;
	public String equipmentStatus;
	public String notes;
	public long modifyDate;
	public long syncDate;
}