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

import com.fds.vr.business.model.VRProductionPlantSupplier;
import com.fds.vr.business.model.VRProductionPlantSupplierModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the VRProductionPlantSupplier service. Represents a row in the &quot;vr_productionplantsupplier&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link VRProductionPlantSupplierModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VRProductionPlantSupplierImpl}.
 * </p>
 *
 * @author LamTV
 * @see VRProductionPlantSupplierImpl
 * @see VRProductionPlantSupplier
 * @see VRProductionPlantSupplierModel
 * @generated
 */
@ProviderType
public class VRProductionPlantSupplierModelImpl extends BaseModelImpl<VRProductionPlantSupplier>
	implements VRProductionPlantSupplierModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vr production plant supplier model instance should use the {@link VRProductionPlantSupplier} interface instead.
	 */
	public static final String TABLE_NAME = "vr_productionplantsupplier";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "id", Types.BIGINT },
			{ "mtCore", Types.BIGINT },
			{ "supplierid", Types.VARCHAR },
			{ "suppliername", Types.VARCHAR },
			{ "supplieraddress", Types.VARCHAR },
			{ "corporationCode", Types.VARCHAR },
			{ "corporationName", Types.VARCHAR },
			{ "corporationAddress", Types.VARCHAR },
			{ "applicantprofileid", Types.BIGINT },
			{ "ProductPlantID", Types.BIGINT },
			{ "productionPlantCode", Types.VARCHAR },
			{ "productionPlantName", Types.VARCHAR },
			{ "productionPlantAddress", Types.VARCHAR },
			{ "markupImporter", Types.INTEGER },
			{ "mappingMA_CTY", Types.VARCHAR },
			{ "mappingTEN_CTY", Types.VARCHAR },
			{ "mappingDIA_CHI_CTY", Types.VARCHAR },
			{ "mappingMA_XUONG_LR", Types.VARCHAR },
			{ "mappingTEN_XUONG_LR", Types.VARCHAR },
			{ "mappingDIA_CHI_XUONG_LR", Types.VARCHAR },
			{ "modifyDate", Types.TIMESTAMP },
			{ "syncDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("mtCore", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("supplierid", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("suppliername", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("supplieraddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("corporationCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("corporationName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("corporationAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("applicantprofileid", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ProductPlantID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("productionPlantCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("productionPlantName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("productionPlantAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("markupImporter", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("mappingMA_CTY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mappingTEN_CTY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mappingDIA_CHI_CTY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mappingMA_XUONG_LR", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mappingTEN_XUONG_LR", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mappingDIA_CHI_XUONG_LR", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifyDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("syncDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table vr_productionplantsupplier (uuid_ VARCHAR(75) null,id LONG not null primary key,mtCore LONG,supplierid VARCHAR(75) null,suppliername VARCHAR(75) null,supplieraddress VARCHAR(75) null,corporationCode VARCHAR(75) null,corporationName VARCHAR(75) null,corporationAddress VARCHAR(75) null,applicantprofileid LONG,ProductPlantID LONG,productionPlantCode VARCHAR(75) null,productionPlantName VARCHAR(75) null,productionPlantAddress VARCHAR(75) null,markupImporter INTEGER,mappingMA_CTY VARCHAR(75) null,mappingTEN_CTY VARCHAR(75) null,mappingDIA_CHI_CTY VARCHAR(75) null,mappingMA_XUONG_LR VARCHAR(75) null,mappingTEN_XUONG_LR VARCHAR(75) null,mappingDIA_CHI_XUONG_LR VARCHAR(75) null,modifyDate DATE null,syncDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table vr_productionplantsupplier";
	public static final String ORDER_BY_JPQL = " ORDER BY vrProductionPlantSupplier.modifyDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vr_productionplantsupplier.modifyDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fds.vr.business.model.VRProductionPlantSupplier"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fds.vr.business.model.VRProductionPlantSupplier"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.fds.vr.business.model.VRProductionPlantSupplier"),
			true);
	public static final long UUID_COLUMN_BITMASK = 1L;
	public static final long MODIFYDATE_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.fds.vr.service.util.ServiceProps.get(
				"lock.expiration.time.com.fds.vr.business.model.VRProductionPlantSupplier"));

	public VRProductionPlantSupplierModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return VRProductionPlantSupplier.class;
	}

	@Override
	public String getModelClassName() {
		return VRProductionPlantSupplier.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("mtCore", getMtCore());
		attributes.put("supplierId", getSupplierId());
		attributes.put("supplierName", getSupplierName());
		attributes.put("supplieraddress", getSupplieraddress());
		attributes.put("corporationCode", getCorporationCode());
		attributes.put("corporationName", getCorporationName());
		attributes.put("corporationAddress", getCorporationAddress());
		attributes.put("applicantprofileId", getApplicantprofileId());
		attributes.put("productPlantID", getProductPlantID());
		attributes.put("productionPlantCode", getProductionPlantCode());
		attributes.put("productionPlantName", getProductionPlantName());
		attributes.put("productionPlantAddress", getProductionPlantAddress());
		attributes.put("markupImporter", getMarkupImporter());
		attributes.put("mappingMA_CTY", getMappingMA_CTY());
		attributes.put("mappingTEN_CTY", getMappingTEN_CTY());
		attributes.put("mappingDIA_CHI_CTY", getMappingDIA_CHI_CTY());
		attributes.put("mappingMA_XUONG_LR", getMappingMA_XUONG_LR());
		attributes.put("mappingTEN_XUONG_LR", getMappingTEN_XUONG_LR());
		attributes.put("mappingDIA_CHI_XUONG_LR", getMappingDIA_CHI_XUONG_LR());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("syncDate", getSyncDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long mtCore = (Long)attributes.get("mtCore");

		if (mtCore != null) {
			setMtCore(mtCore);
		}

		String supplierId = (String)attributes.get("supplierId");

		if (supplierId != null) {
			setSupplierId(supplierId);
		}

		String supplierName = (String)attributes.get("supplierName");

		if (supplierName != null) {
			setSupplierName(supplierName);
		}

		String supplieraddress = (String)attributes.get("supplieraddress");

		if (supplieraddress != null) {
			setSupplieraddress(supplieraddress);
		}

		String corporationCode = (String)attributes.get("corporationCode");

		if (corporationCode != null) {
			setCorporationCode(corporationCode);
		}

		String corporationName = (String)attributes.get("corporationName");

		if (corporationName != null) {
			setCorporationName(corporationName);
		}

		String corporationAddress = (String)attributes.get("corporationAddress");

		if (corporationAddress != null) {
			setCorporationAddress(corporationAddress);
		}

		Long applicantprofileId = (Long)attributes.get("applicantprofileId");

		if (applicantprofileId != null) {
			setApplicantprofileId(applicantprofileId);
		}

		Long productPlantID = (Long)attributes.get("productPlantID");

		if (productPlantID != null) {
			setProductPlantID(productPlantID);
		}

		String productionPlantCode = (String)attributes.get(
				"productionPlantCode");

		if (productionPlantCode != null) {
			setProductionPlantCode(productionPlantCode);
		}

		String productionPlantName = (String)attributes.get(
				"productionPlantName");

		if (productionPlantName != null) {
			setProductionPlantName(productionPlantName);
		}

		String productionPlantAddress = (String)attributes.get(
				"productionPlantAddress");

		if (productionPlantAddress != null) {
			setProductionPlantAddress(productionPlantAddress);
		}

		Integer markupImporter = (Integer)attributes.get("markupImporter");

		if (markupImporter != null) {
			setMarkupImporter(markupImporter);
		}

		String mappingMA_CTY = (String)attributes.get("mappingMA_CTY");

		if (mappingMA_CTY != null) {
			setMappingMA_CTY(mappingMA_CTY);
		}

		String mappingTEN_CTY = (String)attributes.get("mappingTEN_CTY");

		if (mappingTEN_CTY != null) {
			setMappingTEN_CTY(mappingTEN_CTY);
		}

		String mappingDIA_CHI_CTY = (String)attributes.get("mappingDIA_CHI_CTY");

		if (mappingDIA_CHI_CTY != null) {
			setMappingDIA_CHI_CTY(mappingDIA_CHI_CTY);
		}

		String mappingMA_XUONG_LR = (String)attributes.get("mappingMA_XUONG_LR");

		if (mappingMA_XUONG_LR != null) {
			setMappingMA_XUONG_LR(mappingMA_XUONG_LR);
		}

		String mappingTEN_XUONG_LR = (String)attributes.get(
				"mappingTEN_XUONG_LR");

		if (mappingTEN_XUONG_LR != null) {
			setMappingTEN_XUONG_LR(mappingTEN_XUONG_LR);
		}

		String mappingDIA_CHI_XUONG_LR = (String)attributes.get(
				"mappingDIA_CHI_XUONG_LR");

		if (mappingDIA_CHI_XUONG_LR != null) {
			setMappingDIA_CHI_XUONG_LR(mappingDIA_CHI_XUONG_LR);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		Date syncDate = (Date)attributes.get("syncDate");

		if (syncDate != null) {
			setSyncDate(syncDate);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public long getMtCore() {
		return _mtCore;
	}

	@Override
	public void setMtCore(long mtCore) {
		_mtCore = mtCore;
	}

	@Override
	public String getSupplierId() {
		if (_supplierId == null) {
			return StringPool.BLANK;
		}
		else {
			return _supplierId;
		}
	}

	@Override
	public void setSupplierId(String supplierId) {
		_supplierId = supplierId;
	}

	@Override
	public String getSupplierName() {
		if (_supplierName == null) {
			return StringPool.BLANK;
		}
		else {
			return _supplierName;
		}
	}

	@Override
	public void setSupplierName(String supplierName) {
		_supplierName = supplierName;
	}

	@Override
	public String getSupplieraddress() {
		if (_supplieraddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _supplieraddress;
		}
	}

	@Override
	public void setSupplieraddress(String supplieraddress) {
		_supplieraddress = supplieraddress;
	}

	@Override
	public String getCorporationCode() {
		if (_corporationCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _corporationCode;
		}
	}

	@Override
	public void setCorporationCode(String corporationCode) {
		_corporationCode = corporationCode;
	}

	@Override
	public String getCorporationName() {
		if (_corporationName == null) {
			return StringPool.BLANK;
		}
		else {
			return _corporationName;
		}
	}

	@Override
	public void setCorporationName(String corporationName) {
		_corporationName = corporationName;
	}

	@Override
	public String getCorporationAddress() {
		if (_corporationAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _corporationAddress;
		}
	}

	@Override
	public void setCorporationAddress(String corporationAddress) {
		_corporationAddress = corporationAddress;
	}

	@Override
	public long getApplicantprofileId() {
		return _applicantprofileId;
	}

	@Override
	public void setApplicantprofileId(long applicantprofileId) {
		_applicantprofileId = applicantprofileId;
	}

	@Override
	public long getProductPlantID() {
		return _productPlantID;
	}

	@Override
	public void setProductPlantID(long productPlantID) {
		_productPlantID = productPlantID;
	}

	@Override
	public String getProductionPlantCode() {
		if (_productionPlantCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _productionPlantCode;
		}
	}

	@Override
	public void setProductionPlantCode(String productionPlantCode) {
		_productionPlantCode = productionPlantCode;
	}

	@Override
	public String getProductionPlantName() {
		if (_productionPlantName == null) {
			return StringPool.BLANK;
		}
		else {
			return _productionPlantName;
		}
	}

	@Override
	public void setProductionPlantName(String productionPlantName) {
		_productionPlantName = productionPlantName;
	}

	@Override
	public String getProductionPlantAddress() {
		if (_productionPlantAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _productionPlantAddress;
		}
	}

	@Override
	public void setProductionPlantAddress(String productionPlantAddress) {
		_productionPlantAddress = productionPlantAddress;
	}

	@Override
	public int getMarkupImporter() {
		return _markupImporter;
	}

	@Override
	public void setMarkupImporter(int markupImporter) {
		_markupImporter = markupImporter;
	}

	@Override
	public String getMappingMA_CTY() {
		if (_mappingMA_CTY == null) {
			return StringPool.BLANK;
		}
		else {
			return _mappingMA_CTY;
		}
	}

	@Override
	public void setMappingMA_CTY(String mappingMA_CTY) {
		_mappingMA_CTY = mappingMA_CTY;
	}

	@Override
	public String getMappingTEN_CTY() {
		if (_mappingTEN_CTY == null) {
			return StringPool.BLANK;
		}
		else {
			return _mappingTEN_CTY;
		}
	}

	@Override
	public void setMappingTEN_CTY(String mappingTEN_CTY) {
		_mappingTEN_CTY = mappingTEN_CTY;
	}

	@Override
	public String getMappingDIA_CHI_CTY() {
		if (_mappingDIA_CHI_CTY == null) {
			return StringPool.BLANK;
		}
		else {
			return _mappingDIA_CHI_CTY;
		}
	}

	@Override
	public void setMappingDIA_CHI_CTY(String mappingDIA_CHI_CTY) {
		_mappingDIA_CHI_CTY = mappingDIA_CHI_CTY;
	}

	@Override
	public String getMappingMA_XUONG_LR() {
		if (_mappingMA_XUONG_LR == null) {
			return StringPool.BLANK;
		}
		else {
			return _mappingMA_XUONG_LR;
		}
	}

	@Override
	public void setMappingMA_XUONG_LR(String mappingMA_XUONG_LR) {
		_mappingMA_XUONG_LR = mappingMA_XUONG_LR;
	}

	@Override
	public String getMappingTEN_XUONG_LR() {
		if (_mappingTEN_XUONG_LR == null) {
			return StringPool.BLANK;
		}
		else {
			return _mappingTEN_XUONG_LR;
		}
	}

	@Override
	public void setMappingTEN_XUONG_LR(String mappingTEN_XUONG_LR) {
		_mappingTEN_XUONG_LR = mappingTEN_XUONG_LR;
	}

	@Override
	public String getMappingDIA_CHI_XUONG_LR() {
		if (_mappingDIA_CHI_XUONG_LR == null) {
			return StringPool.BLANK;
		}
		else {
			return _mappingDIA_CHI_XUONG_LR;
		}
	}

	@Override
	public void setMappingDIA_CHI_XUONG_LR(String mappingDIA_CHI_XUONG_LR) {
		_mappingDIA_CHI_XUONG_LR = mappingDIA_CHI_XUONG_LR;
	}

	@Override
	public Date getModifyDate() {
		return _modifyDate;
	}

	@Override
	public void setModifyDate(Date modifyDate) {
		_columnBitmask = -1L;

		_modifyDate = modifyDate;
	}

	@Override
	public Date getSyncDate() {
		return _syncDate;
	}

	@Override
	public void setSyncDate(Date syncDate) {
		_syncDate = syncDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			VRProductionPlantSupplier.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VRProductionPlantSupplier toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VRProductionPlantSupplier)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VRProductionPlantSupplierImpl vrProductionPlantSupplierImpl = new VRProductionPlantSupplierImpl();

		vrProductionPlantSupplierImpl.setUuid(getUuid());
		vrProductionPlantSupplierImpl.setId(getId());
		vrProductionPlantSupplierImpl.setMtCore(getMtCore());
		vrProductionPlantSupplierImpl.setSupplierId(getSupplierId());
		vrProductionPlantSupplierImpl.setSupplierName(getSupplierName());
		vrProductionPlantSupplierImpl.setSupplieraddress(getSupplieraddress());
		vrProductionPlantSupplierImpl.setCorporationCode(getCorporationCode());
		vrProductionPlantSupplierImpl.setCorporationName(getCorporationName());
		vrProductionPlantSupplierImpl.setCorporationAddress(getCorporationAddress());
		vrProductionPlantSupplierImpl.setApplicantprofileId(getApplicantprofileId());
		vrProductionPlantSupplierImpl.setProductPlantID(getProductPlantID());
		vrProductionPlantSupplierImpl.setProductionPlantCode(getProductionPlantCode());
		vrProductionPlantSupplierImpl.setProductionPlantName(getProductionPlantName());
		vrProductionPlantSupplierImpl.setProductionPlantAddress(getProductionPlantAddress());
		vrProductionPlantSupplierImpl.setMarkupImporter(getMarkupImporter());
		vrProductionPlantSupplierImpl.setMappingMA_CTY(getMappingMA_CTY());
		vrProductionPlantSupplierImpl.setMappingTEN_CTY(getMappingTEN_CTY());
		vrProductionPlantSupplierImpl.setMappingDIA_CHI_CTY(getMappingDIA_CHI_CTY());
		vrProductionPlantSupplierImpl.setMappingMA_XUONG_LR(getMappingMA_XUONG_LR());
		vrProductionPlantSupplierImpl.setMappingTEN_XUONG_LR(getMappingTEN_XUONG_LR());
		vrProductionPlantSupplierImpl.setMappingDIA_CHI_XUONG_LR(getMappingDIA_CHI_XUONG_LR());
		vrProductionPlantSupplierImpl.setModifyDate(getModifyDate());
		vrProductionPlantSupplierImpl.setSyncDate(getSyncDate());

		vrProductionPlantSupplierImpl.resetOriginalValues();

		return vrProductionPlantSupplierImpl;
	}

	@Override
	public int compareTo(VRProductionPlantSupplier vrProductionPlantSupplier) {
		int value = 0;

		value = DateUtil.compareTo(getModifyDate(),
				vrProductionPlantSupplier.getModifyDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VRProductionPlantSupplier)) {
			return false;
		}

		VRProductionPlantSupplier vrProductionPlantSupplier = (VRProductionPlantSupplier)obj;

		long primaryKey = vrProductionPlantSupplier.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		VRProductionPlantSupplierModelImpl vrProductionPlantSupplierModelImpl = this;

		vrProductionPlantSupplierModelImpl._originalUuid = vrProductionPlantSupplierModelImpl._uuid;

		vrProductionPlantSupplierModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VRProductionPlantSupplier> toCacheModel() {
		VRProductionPlantSupplierCacheModel vrProductionPlantSupplierCacheModel = new VRProductionPlantSupplierCacheModel();

		vrProductionPlantSupplierCacheModel.uuid = getUuid();

		String uuid = vrProductionPlantSupplierCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			vrProductionPlantSupplierCacheModel.uuid = null;
		}

		vrProductionPlantSupplierCacheModel.id = getId();

		vrProductionPlantSupplierCacheModel.mtCore = getMtCore();

		vrProductionPlantSupplierCacheModel.supplierId = getSupplierId();

		String supplierId = vrProductionPlantSupplierCacheModel.supplierId;

		if ((supplierId != null) && (supplierId.length() == 0)) {
			vrProductionPlantSupplierCacheModel.supplierId = null;
		}

		vrProductionPlantSupplierCacheModel.supplierName = getSupplierName();

		String supplierName = vrProductionPlantSupplierCacheModel.supplierName;

		if ((supplierName != null) && (supplierName.length() == 0)) {
			vrProductionPlantSupplierCacheModel.supplierName = null;
		}

		vrProductionPlantSupplierCacheModel.supplieraddress = getSupplieraddress();

		String supplieraddress = vrProductionPlantSupplierCacheModel.supplieraddress;

		if ((supplieraddress != null) && (supplieraddress.length() == 0)) {
			vrProductionPlantSupplierCacheModel.supplieraddress = null;
		}

		vrProductionPlantSupplierCacheModel.corporationCode = getCorporationCode();

		String corporationCode = vrProductionPlantSupplierCacheModel.corporationCode;

		if ((corporationCode != null) && (corporationCode.length() == 0)) {
			vrProductionPlantSupplierCacheModel.corporationCode = null;
		}

		vrProductionPlantSupplierCacheModel.corporationName = getCorporationName();

		String corporationName = vrProductionPlantSupplierCacheModel.corporationName;

		if ((corporationName != null) && (corporationName.length() == 0)) {
			vrProductionPlantSupplierCacheModel.corporationName = null;
		}

		vrProductionPlantSupplierCacheModel.corporationAddress = getCorporationAddress();

		String corporationAddress = vrProductionPlantSupplierCacheModel.corporationAddress;

		if ((corporationAddress != null) && (corporationAddress.length() == 0)) {
			vrProductionPlantSupplierCacheModel.corporationAddress = null;
		}

		vrProductionPlantSupplierCacheModel.applicantprofileId = getApplicantprofileId();

		vrProductionPlantSupplierCacheModel.productPlantID = getProductPlantID();

		vrProductionPlantSupplierCacheModel.productionPlantCode = getProductionPlantCode();

		String productionPlantCode = vrProductionPlantSupplierCacheModel.productionPlantCode;

		if ((productionPlantCode != null) &&
				(productionPlantCode.length() == 0)) {
			vrProductionPlantSupplierCacheModel.productionPlantCode = null;
		}

		vrProductionPlantSupplierCacheModel.productionPlantName = getProductionPlantName();

		String productionPlantName = vrProductionPlantSupplierCacheModel.productionPlantName;

		if ((productionPlantName != null) &&
				(productionPlantName.length() == 0)) {
			vrProductionPlantSupplierCacheModel.productionPlantName = null;
		}

		vrProductionPlantSupplierCacheModel.productionPlantAddress = getProductionPlantAddress();

		String productionPlantAddress = vrProductionPlantSupplierCacheModel.productionPlantAddress;

		if ((productionPlantAddress != null) &&
				(productionPlantAddress.length() == 0)) {
			vrProductionPlantSupplierCacheModel.productionPlantAddress = null;
		}

		vrProductionPlantSupplierCacheModel.markupImporter = getMarkupImporter();

		vrProductionPlantSupplierCacheModel.mappingMA_CTY = getMappingMA_CTY();

		String mappingMA_CTY = vrProductionPlantSupplierCacheModel.mappingMA_CTY;

		if ((mappingMA_CTY != null) && (mappingMA_CTY.length() == 0)) {
			vrProductionPlantSupplierCacheModel.mappingMA_CTY = null;
		}

		vrProductionPlantSupplierCacheModel.mappingTEN_CTY = getMappingTEN_CTY();

		String mappingTEN_CTY = vrProductionPlantSupplierCacheModel.mappingTEN_CTY;

		if ((mappingTEN_CTY != null) && (mappingTEN_CTY.length() == 0)) {
			vrProductionPlantSupplierCacheModel.mappingTEN_CTY = null;
		}

		vrProductionPlantSupplierCacheModel.mappingDIA_CHI_CTY = getMappingDIA_CHI_CTY();

		String mappingDIA_CHI_CTY = vrProductionPlantSupplierCacheModel.mappingDIA_CHI_CTY;

		if ((mappingDIA_CHI_CTY != null) && (mappingDIA_CHI_CTY.length() == 0)) {
			vrProductionPlantSupplierCacheModel.mappingDIA_CHI_CTY = null;
		}

		vrProductionPlantSupplierCacheModel.mappingMA_XUONG_LR = getMappingMA_XUONG_LR();

		String mappingMA_XUONG_LR = vrProductionPlantSupplierCacheModel.mappingMA_XUONG_LR;

		if ((mappingMA_XUONG_LR != null) && (mappingMA_XUONG_LR.length() == 0)) {
			vrProductionPlantSupplierCacheModel.mappingMA_XUONG_LR = null;
		}

		vrProductionPlantSupplierCacheModel.mappingTEN_XUONG_LR = getMappingTEN_XUONG_LR();

		String mappingTEN_XUONG_LR = vrProductionPlantSupplierCacheModel.mappingTEN_XUONG_LR;

		if ((mappingTEN_XUONG_LR != null) &&
				(mappingTEN_XUONG_LR.length() == 0)) {
			vrProductionPlantSupplierCacheModel.mappingTEN_XUONG_LR = null;
		}

		vrProductionPlantSupplierCacheModel.mappingDIA_CHI_XUONG_LR = getMappingDIA_CHI_XUONG_LR();

		String mappingDIA_CHI_XUONG_LR = vrProductionPlantSupplierCacheModel.mappingDIA_CHI_XUONG_LR;

		if ((mappingDIA_CHI_XUONG_LR != null) &&
				(mappingDIA_CHI_XUONG_LR.length() == 0)) {
			vrProductionPlantSupplierCacheModel.mappingDIA_CHI_XUONG_LR = null;
		}

		Date modifyDate = getModifyDate();

		if (modifyDate != null) {
			vrProductionPlantSupplierCacheModel.modifyDate = modifyDate.getTime();
		}
		else {
			vrProductionPlantSupplierCacheModel.modifyDate = Long.MIN_VALUE;
		}

		Date syncDate = getSyncDate();

		if (syncDate != null) {
			vrProductionPlantSupplierCacheModel.syncDate = syncDate.getTime();
		}
		else {
			vrProductionPlantSupplierCacheModel.syncDate = Long.MIN_VALUE;
		}

		return vrProductionPlantSupplierCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", mtCore=");
		sb.append(getMtCore());
		sb.append(", supplierId=");
		sb.append(getSupplierId());
		sb.append(", supplierName=");
		sb.append(getSupplierName());
		sb.append(", supplieraddress=");
		sb.append(getSupplieraddress());
		sb.append(", corporationCode=");
		sb.append(getCorporationCode());
		sb.append(", corporationName=");
		sb.append(getCorporationName());
		sb.append(", corporationAddress=");
		sb.append(getCorporationAddress());
		sb.append(", applicantprofileId=");
		sb.append(getApplicantprofileId());
		sb.append(", productPlantID=");
		sb.append(getProductPlantID());
		sb.append(", productionPlantCode=");
		sb.append(getProductionPlantCode());
		sb.append(", productionPlantName=");
		sb.append(getProductionPlantName());
		sb.append(", productionPlantAddress=");
		sb.append(getProductionPlantAddress());
		sb.append(", markupImporter=");
		sb.append(getMarkupImporter());
		sb.append(", mappingMA_CTY=");
		sb.append(getMappingMA_CTY());
		sb.append(", mappingTEN_CTY=");
		sb.append(getMappingTEN_CTY());
		sb.append(", mappingDIA_CHI_CTY=");
		sb.append(getMappingDIA_CHI_CTY());
		sb.append(", mappingMA_XUONG_LR=");
		sb.append(getMappingMA_XUONG_LR());
		sb.append(", mappingTEN_XUONG_LR=");
		sb.append(getMappingTEN_XUONG_LR());
		sb.append(", mappingDIA_CHI_XUONG_LR=");
		sb.append(getMappingDIA_CHI_XUONG_LR());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", syncDate=");
		sb.append(getSyncDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("com.fds.vr.business.model.VRProductionPlantSupplier");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mtCore</column-name><column-value><![CDATA[");
		sb.append(getMtCore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supplierId</column-name><column-value><![CDATA[");
		sb.append(getSupplierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supplierName</column-name><column-value><![CDATA[");
		sb.append(getSupplierName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supplieraddress</column-name><column-value><![CDATA[");
		sb.append(getSupplieraddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corporationCode</column-name><column-value><![CDATA[");
		sb.append(getCorporationCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corporationName</column-name><column-value><![CDATA[");
		sb.append(getCorporationName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corporationAddress</column-name><column-value><![CDATA[");
		sb.append(getCorporationAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantprofileId</column-name><column-value><![CDATA[");
		sb.append(getApplicantprofileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productPlantID</column-name><column-value><![CDATA[");
		sb.append(getProductPlantID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productionPlantCode</column-name><column-value><![CDATA[");
		sb.append(getProductionPlantCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productionPlantName</column-name><column-value><![CDATA[");
		sb.append(getProductionPlantName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productionPlantAddress</column-name><column-value><![CDATA[");
		sb.append(getProductionPlantAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>markupImporter</column-name><column-value><![CDATA[");
		sb.append(getMarkupImporter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappingMA_CTY</column-name><column-value><![CDATA[");
		sb.append(getMappingMA_CTY());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappingTEN_CTY</column-name><column-value><![CDATA[");
		sb.append(getMappingTEN_CTY());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappingDIA_CHI_CTY</column-name><column-value><![CDATA[");
		sb.append(getMappingDIA_CHI_CTY());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappingMA_XUONG_LR</column-name><column-value><![CDATA[");
		sb.append(getMappingMA_XUONG_LR());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappingTEN_XUONG_LR</column-name><column-value><![CDATA[");
		sb.append(getMappingTEN_XUONG_LR());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappingDIA_CHI_XUONG_LR</column-name><column-value><![CDATA[");
		sb.append(getMappingDIA_CHI_XUONG_LR());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifyDate</column-name><column-value><![CDATA[");
		sb.append(getModifyDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>syncDate</column-name><column-value><![CDATA[");
		sb.append(getSyncDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = VRProductionPlantSupplier.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			VRProductionPlantSupplier.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _id;
	private long _mtCore;
	private String _supplierId;
	private String _supplierName;
	private String _supplieraddress;
	private String _corporationCode;
	private String _corporationName;
	private String _corporationAddress;
	private long _applicantprofileId;
	private long _productPlantID;
	private String _productionPlantCode;
	private String _productionPlantName;
	private String _productionPlantAddress;
	private int _markupImporter;
	private String _mappingMA_CTY;
	private String _mappingTEN_CTY;
	private String _mappingDIA_CHI_CTY;
	private String _mappingMA_XUONG_LR;
	private String _mappingTEN_XUONG_LR;
	private String _mappingDIA_CHI_XUONG_LR;
	private Date _modifyDate;
	private Date _syncDate;
	private long _columnBitmask;
	private VRProductionPlantSupplier _escapedModel;
}