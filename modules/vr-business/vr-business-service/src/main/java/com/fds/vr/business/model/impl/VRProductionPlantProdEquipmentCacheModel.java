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

import com.fds.vr.business.model.VRProductionPlantProdEquipment;

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
 * The cache model class for representing VRProductionPlantProdEquipment in entity cache.
 *
 * @author LamTV
 * @see VRProductionPlantProdEquipment
 * @generated
 */
@ProviderType
public class VRProductionPlantProdEquipmentCacheModel implements CacheModel<VRProductionPlantProdEquipment>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRProductionPlantProdEquipmentCacheModel)) {
			return false;
		}

		VRProductionPlantProdEquipmentCacheModel vrProductionPlantProdEquipmentCacheModel =
			(VRProductionPlantProdEquipmentCacheModel)obj;

		if (id == vrProductionPlantProdEquipmentCacheModel.id) {
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
	public VRProductionPlantProdEquipment toEntityModel() {
		VRProductionPlantProdEquipmentImpl vrProductionPlantProdEquipmentImpl = new VRProductionPlantProdEquipmentImpl();

		vrProductionPlantProdEquipmentImpl.setId(id);
		vrProductionPlantProdEquipmentImpl.setMtCore(mtCore);
		vrProductionPlantProdEquipmentImpl.setProductPlantID(productPlantID);
		vrProductionPlantProdEquipmentImpl.setSequenceNo(sequenceNo);

		if (equipmentCode == null) {
			vrProductionPlantProdEquipmentImpl.setEquipmentCode(StringPool.BLANK);
		}
		else {
			vrProductionPlantProdEquipmentImpl.setEquipmentCode(equipmentCode);
		}

		if (equipmentName == null) {
			vrProductionPlantProdEquipmentImpl.setEquipmentName(StringPool.BLANK);
		}
		else {
			vrProductionPlantProdEquipmentImpl.setEquipmentName(equipmentName);
		}

		if (equipmentType == null) {
			vrProductionPlantProdEquipmentImpl.setEquipmentType(StringPool.BLANK);
		}
		else {
			vrProductionPlantProdEquipmentImpl.setEquipmentType(equipmentType);
		}

		if (trademark == null) {
			vrProductionPlantProdEquipmentImpl.setTrademark(StringPool.BLANK);
		}
		else {
			vrProductionPlantProdEquipmentImpl.setTrademark(trademark);
		}

		if (trademarkName == null) {
			vrProductionPlantProdEquipmentImpl.setTrademarkName(StringPool.BLANK);
		}
		else {
			vrProductionPlantProdEquipmentImpl.setTrademarkName(trademarkName);
		}

		if (commercialName == null) {
			vrProductionPlantProdEquipmentImpl.setCommercialName(StringPool.BLANK);
		}
		else {
			vrProductionPlantProdEquipmentImpl.setCommercialName(commercialName);
		}

		if (modelCode == null) {
			vrProductionPlantProdEquipmentImpl.setModelCode(StringPool.BLANK);
		}
		else {
			vrProductionPlantProdEquipmentImpl.setModelCode(modelCode);
		}

		if (designSymbolNo == null) {
			vrProductionPlantProdEquipmentImpl.setDesignSymbolNo(StringPool.BLANK);
		}
		else {
			vrProductionPlantProdEquipmentImpl.setDesignSymbolNo(designSymbolNo);
		}

		if (productionCountryCode == null) {
			vrProductionPlantProdEquipmentImpl.setProductionCountryCode(StringPool.BLANK);
		}
		else {
			vrProductionPlantProdEquipmentImpl.setProductionCountryCode(productionCountryCode);
		}

		if (equipmentStatus == null) {
			vrProductionPlantProdEquipmentImpl.setEquipmentStatus(StringPool.BLANK);
		}
		else {
			vrProductionPlantProdEquipmentImpl.setEquipmentStatus(equipmentStatus);
		}

		if (notes == null) {
			vrProductionPlantProdEquipmentImpl.setNotes(StringPool.BLANK);
		}
		else {
			vrProductionPlantProdEquipmentImpl.setNotes(notes);
		}

		if (modifyDate == Long.MIN_VALUE) {
			vrProductionPlantProdEquipmentImpl.setModifyDate(null);
		}
		else {
			vrProductionPlantProdEquipmentImpl.setModifyDate(new Date(
					modifyDate));
		}

		if (syncDate == Long.MIN_VALUE) {
			vrProductionPlantProdEquipmentImpl.setSyncDate(null);
		}
		else {
			vrProductionPlantProdEquipmentImpl.setSyncDate(new Date(syncDate));
		}

		vrProductionPlantProdEquipmentImpl.resetOriginalValues();

		return vrProductionPlantProdEquipmentImpl;
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