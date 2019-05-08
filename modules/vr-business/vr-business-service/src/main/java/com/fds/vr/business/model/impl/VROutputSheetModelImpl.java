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

import com.fds.vr.business.model.VROutputSheet;
import com.fds.vr.business.model.VROutputSheetModel;

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
 * The base model implementation for the VROutputSheet service. Represents a row in the &quot;vr_outputsheet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link VROutputSheetModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VROutputSheetImpl}.
 * </p>
 *
 * @author LamTV
 * @see VROutputSheetImpl
 * @see VROutputSheet
 * @see VROutputSheetModel
 * @generated
 */
@ProviderType
public class VROutputSheetModelImpl extends BaseModelImpl<VROutputSheet>
	implements VROutputSheetModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vr output sheet model instance should use the {@link VROutputSheet} interface instead.
	 */
	public static final String TABLE_NAME = "vr_outputsheet";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "mtCore", Types.BIGINT },
			{ "outputSheetNo", Types.VARCHAR },
			{ "outputSheetDate", Types.TIMESTAMP },
			{ "originalDocumentNo", Types.VARCHAR },
			{ "supplierCorporationId", Types.VARCHAR },
			{ "outputSheetType", Types.BIGINT },
			{ "maker", Types.VARCHAR },
			{ "checker", Types.VARCHAR },
			{ "approver", Types.VARCHAR },
			{ "receiverName", Types.VARCHAR },
			{ "receiverPlace", Types.VARCHAR },
			{ "receiverRequest", Types.VARCHAR },
			{ "inventoryName", Types.VARCHAR },
			{ "inventoryPlace", Types.VARCHAR },
			{ "inventoryDate", Types.TIMESTAMP },
			{ "dossierId", Types.BIGINT },
			{ "issueId", Types.BIGINT },
			{ "purchaserId", Types.VARCHAR },
			{ "purchaserCorporationId", Types.VARCHAR },
			{ "bookIDList", Types.VARCHAR },
			{ "isApproval", Types.BIGINT },
			{ "totalQuantities", Types.BIGINT },
			{ "totalAmount", Types.BIGINT },
			{ "amountInWords", Types.VARCHAR },
			{ "remark", Types.VARCHAR },
			{ "modifyDate", Types.TIMESTAMP },
			{ "syncDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("mtCore", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("outputSheetNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("outputSheetDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("originalDocumentNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("supplierCorporationId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("outputSheetType", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("maker", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("checker", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("approver", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("receiverName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("receiverPlace", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("receiverRequest", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("inventoryName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("inventoryPlace", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("inventoryDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dossierId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("issueId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("purchaserId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("purchaserCorporationId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bookIDList", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isApproval", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalQuantities", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalAmount", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("amountInWords", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("remark", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifyDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("syncDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table vr_outputsheet (id LONG not null primary key,mtCore LONG,outputSheetNo VARCHAR(75) null,outputSheetDate DATE null,originalDocumentNo VARCHAR(75) null,supplierCorporationId VARCHAR(75) null,outputSheetType LONG,maker VARCHAR(75) null,checker VARCHAR(75) null,approver VARCHAR(75) null,receiverName VARCHAR(75) null,receiverPlace VARCHAR(75) null,receiverRequest VARCHAR(75) null,inventoryName VARCHAR(75) null,inventoryPlace VARCHAR(75) null,inventoryDate DATE null,dossierId LONG,issueId LONG,purchaserId VARCHAR(75) null,purchaserCorporationId VARCHAR(75) null,bookIDList VARCHAR(75) null,isApproval LONG,totalQuantities LONG,totalAmount LONG,amountInWords VARCHAR(75) null,remark VARCHAR(75) null,modifyDate DATE null,syncDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table vr_outputsheet";
	public static final String ORDER_BY_JPQL = " ORDER BY vrOutputSheet.modifyDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vr_outputsheet.modifyDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fds.vr.business.model.VROutputSheet"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fds.vr.business.model.VROutputSheet"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.fds.vr.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.fds.vr.business.model.VROutputSheet"),
			true);
	public static final long DOSSIERID_COLUMN_BITMASK = 1L;
	public static final long MTCORE_COLUMN_BITMASK = 2L;
	public static final long OUTPUTSHEETNO_COLUMN_BITMASK = 4L;
	public static final long OUTPUTSHEETTYPE_COLUMN_BITMASK = 8L;
	public static final long PURCHASERCORPORATIONID_COLUMN_BITMASK = 16L;
	public static final long SUPPLIERCORPORATIONID_COLUMN_BITMASK = 32L;
	public static final long MODIFYDATE_COLUMN_BITMASK = 64L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.fds.vr.service.util.ServiceProps.get(
				"lock.expiration.time.com.fds.vr.business.model.VROutputSheet"));

	public VROutputSheetModelImpl() {
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
		return VROutputSheet.class;
	}

	@Override
	public String getModelClassName() {
		return VROutputSheet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("mtCore", getMtCore());
		attributes.put("outputSheetNo", getOutputSheetNo());
		attributes.put("outputSheetDate", getOutputSheetDate());
		attributes.put("originalDocumentNo", getOriginalDocumentNo());
		attributes.put("supplierCorporationId", getSupplierCorporationId());
		attributes.put("outputSheetType", getOutputSheetType());
		attributes.put("maker", getMaker());
		attributes.put("checker", getChecker());
		attributes.put("approver", getApprover());
		attributes.put("receiverName", getReceiverName());
		attributes.put("receiverPlace", getReceiverPlace());
		attributes.put("receiverRequest", getReceiverRequest());
		attributes.put("inventoryName", getInventoryName());
		attributes.put("inventoryPlace", getInventoryPlace());
		attributes.put("inventoryDate", getInventoryDate());
		attributes.put("dossierId", getDossierId());
		attributes.put("issueId", getIssueId());
		attributes.put("purchaserId", getPurchaserId());
		attributes.put("purchaserCorporationId", getPurchaserCorporationId());
		attributes.put("bookIDList", getBookIDList());
		attributes.put("isApproval", getIsApproval());
		attributes.put("totalQuantities", getTotalQuantities());
		attributes.put("totalAmount", getTotalAmount());
		attributes.put("amountInWords", getAmountInWords());
		attributes.put("remark", getRemark());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("syncDate", getSyncDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long mtCore = (Long)attributes.get("mtCore");

		if (mtCore != null) {
			setMtCore(mtCore);
		}

		String outputSheetNo = (String)attributes.get("outputSheetNo");

		if (outputSheetNo != null) {
			setOutputSheetNo(outputSheetNo);
		}

		Date outputSheetDate = (Date)attributes.get("outputSheetDate");

		if (outputSheetDate != null) {
			setOutputSheetDate(outputSheetDate);
		}

		String originalDocumentNo = (String)attributes.get("originalDocumentNo");

		if (originalDocumentNo != null) {
			setOriginalDocumentNo(originalDocumentNo);
		}

		String supplierCorporationId = (String)attributes.get(
				"supplierCorporationId");

		if (supplierCorporationId != null) {
			setSupplierCorporationId(supplierCorporationId);
		}

		Long outputSheetType = (Long)attributes.get("outputSheetType");

		if (outputSheetType != null) {
			setOutputSheetType(outputSheetType);
		}

		String maker = (String)attributes.get("maker");

		if (maker != null) {
			setMaker(maker);
		}

		String checker = (String)attributes.get("checker");

		if (checker != null) {
			setChecker(checker);
		}

		String approver = (String)attributes.get("approver");

		if (approver != null) {
			setApprover(approver);
		}

		String receiverName = (String)attributes.get("receiverName");

		if (receiverName != null) {
			setReceiverName(receiverName);
		}

		String receiverPlace = (String)attributes.get("receiverPlace");

		if (receiverPlace != null) {
			setReceiverPlace(receiverPlace);
		}

		String receiverRequest = (String)attributes.get("receiverRequest");

		if (receiverRequest != null) {
			setReceiverRequest(receiverRequest);
		}

		String inventoryName = (String)attributes.get("inventoryName");

		if (inventoryName != null) {
			setInventoryName(inventoryName);
		}

		String inventoryPlace = (String)attributes.get("inventoryPlace");

		if (inventoryPlace != null) {
			setInventoryPlace(inventoryPlace);
		}

		Date inventoryDate = (Date)attributes.get("inventoryDate");

		if (inventoryDate != null) {
			setInventoryDate(inventoryDate);
		}

		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
		}

		Long issueId = (Long)attributes.get("issueId");

		if (issueId != null) {
			setIssueId(issueId);
		}

		String purchaserId = (String)attributes.get("purchaserId");

		if (purchaserId != null) {
			setPurchaserId(purchaserId);
		}

		String purchaserCorporationId = (String)attributes.get(
				"purchaserCorporationId");

		if (purchaserCorporationId != null) {
			setPurchaserCorporationId(purchaserCorporationId);
		}

		String bookIDList = (String)attributes.get("bookIDList");

		if (bookIDList != null) {
			setBookIDList(bookIDList);
		}

		Long isApproval = (Long)attributes.get("isApproval");

		if (isApproval != null) {
			setIsApproval(isApproval);
		}

		Long totalQuantities = (Long)attributes.get("totalQuantities");

		if (totalQuantities != null) {
			setTotalQuantities(totalQuantities);
		}

		Long totalAmount = (Long)attributes.get("totalAmount");

		if (totalAmount != null) {
			setTotalAmount(totalAmount);
		}

		String amountInWords = (String)attributes.get("amountInWords");

		if (amountInWords != null) {
			setAmountInWords(amountInWords);
		}

		String remark = (String)attributes.get("remark");

		if (remark != null) {
			setRemark(remark);
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
		_columnBitmask |= MTCORE_COLUMN_BITMASK;

		if (!_setOriginalMtCore) {
			_setOriginalMtCore = true;

			_originalMtCore = _mtCore;
		}

		_mtCore = mtCore;
	}

	public long getOriginalMtCore() {
		return _originalMtCore;
	}

	@Override
	public String getOutputSheetNo() {
		if (_outputSheetNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _outputSheetNo;
		}
	}

	@Override
	public void setOutputSheetNo(String outputSheetNo) {
		_columnBitmask |= OUTPUTSHEETNO_COLUMN_BITMASK;

		if (_originalOutputSheetNo == null) {
			_originalOutputSheetNo = _outputSheetNo;
		}

		_outputSheetNo = outputSheetNo;
	}

	public String getOriginalOutputSheetNo() {
		return GetterUtil.getString(_originalOutputSheetNo);
	}

	@Override
	public Date getOutputSheetDate() {
		return _outputSheetDate;
	}

	@Override
	public void setOutputSheetDate(Date outputSheetDate) {
		_outputSheetDate = outputSheetDate;
	}

	@Override
	public String getOriginalDocumentNo() {
		if (_originalDocumentNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _originalDocumentNo;
		}
	}

	@Override
	public void setOriginalDocumentNo(String originalDocumentNo) {
		_originalDocumentNo = originalDocumentNo;
	}

	@Override
	public String getSupplierCorporationId() {
		if (_supplierCorporationId == null) {
			return StringPool.BLANK;
		}
		else {
			return _supplierCorporationId;
		}
	}

	@Override
	public void setSupplierCorporationId(String supplierCorporationId) {
		_columnBitmask |= SUPPLIERCORPORATIONID_COLUMN_BITMASK;

		if (_originalSupplierCorporationId == null) {
			_originalSupplierCorporationId = _supplierCorporationId;
		}

		_supplierCorporationId = supplierCorporationId;
	}

	public String getOriginalSupplierCorporationId() {
		return GetterUtil.getString(_originalSupplierCorporationId);
	}

	@Override
	public long getOutputSheetType() {
		return _outputSheetType;
	}

	@Override
	public void setOutputSheetType(long outputSheetType) {
		_columnBitmask |= OUTPUTSHEETTYPE_COLUMN_BITMASK;

		if (!_setOriginalOutputSheetType) {
			_setOriginalOutputSheetType = true;

			_originalOutputSheetType = _outputSheetType;
		}

		_outputSheetType = outputSheetType;
	}

	public long getOriginalOutputSheetType() {
		return _originalOutputSheetType;
	}

	@Override
	public String getMaker() {
		if (_maker == null) {
			return StringPool.BLANK;
		}
		else {
			return _maker;
		}
	}

	@Override
	public void setMaker(String maker) {
		_maker = maker;
	}

	@Override
	public String getChecker() {
		if (_checker == null) {
			return StringPool.BLANK;
		}
		else {
			return _checker;
		}
	}

	@Override
	public void setChecker(String checker) {
		_checker = checker;
	}

	@Override
	public String getApprover() {
		if (_approver == null) {
			return StringPool.BLANK;
		}
		else {
			return _approver;
		}
	}

	@Override
	public void setApprover(String approver) {
		_approver = approver;
	}

	@Override
	public String getReceiverName() {
		if (_receiverName == null) {
			return StringPool.BLANK;
		}
		else {
			return _receiverName;
		}
	}

	@Override
	public void setReceiverName(String receiverName) {
		_receiverName = receiverName;
	}

	@Override
	public String getReceiverPlace() {
		if (_receiverPlace == null) {
			return StringPool.BLANK;
		}
		else {
			return _receiverPlace;
		}
	}

	@Override
	public void setReceiverPlace(String receiverPlace) {
		_receiverPlace = receiverPlace;
	}

	@Override
	public String getReceiverRequest() {
		if (_receiverRequest == null) {
			return StringPool.BLANK;
		}
		else {
			return _receiverRequest;
		}
	}

	@Override
	public void setReceiverRequest(String receiverRequest) {
		_receiverRequest = receiverRequest;
	}

	@Override
	public String getInventoryName() {
		if (_inventoryName == null) {
			return StringPool.BLANK;
		}
		else {
			return _inventoryName;
		}
	}

	@Override
	public void setInventoryName(String inventoryName) {
		_inventoryName = inventoryName;
	}

	@Override
	public String getInventoryPlace() {
		if (_inventoryPlace == null) {
			return StringPool.BLANK;
		}
		else {
			return _inventoryPlace;
		}
	}

	@Override
	public void setInventoryPlace(String inventoryPlace) {
		_inventoryPlace = inventoryPlace;
	}

	@Override
	public Date getInventoryDate() {
		return _inventoryDate;
	}

	@Override
	public void setInventoryDate(Date inventoryDate) {
		_inventoryDate = inventoryDate;
	}

	@Override
	public long getDossierId() {
		return _dossierId;
	}

	@Override
	public void setDossierId(long dossierId) {
		_columnBitmask |= DOSSIERID_COLUMN_BITMASK;

		if (!_setOriginalDossierId) {
			_setOriginalDossierId = true;

			_originalDossierId = _dossierId;
		}

		_dossierId = dossierId;
	}

	public long getOriginalDossierId() {
		return _originalDossierId;
	}

	@Override
	public long getIssueId() {
		return _issueId;
	}

	@Override
	public void setIssueId(long issueId) {
		_issueId = issueId;
	}

	@Override
	public String getPurchaserId() {
		if (_purchaserId == null) {
			return StringPool.BLANK;
		}
		else {
			return _purchaserId;
		}
	}

	@Override
	public void setPurchaserId(String purchaserId) {
		_purchaserId = purchaserId;
	}

	@Override
	public String getPurchaserCorporationId() {
		if (_purchaserCorporationId == null) {
			return StringPool.BLANK;
		}
		else {
			return _purchaserCorporationId;
		}
	}

	@Override
	public void setPurchaserCorporationId(String purchaserCorporationId) {
		_columnBitmask |= PURCHASERCORPORATIONID_COLUMN_BITMASK;

		if (_originalPurchaserCorporationId == null) {
			_originalPurchaserCorporationId = _purchaserCorporationId;
		}

		_purchaserCorporationId = purchaserCorporationId;
	}

	public String getOriginalPurchaserCorporationId() {
		return GetterUtil.getString(_originalPurchaserCorporationId);
	}

	@Override
	public String getBookIDList() {
		if (_bookIDList == null) {
			return StringPool.BLANK;
		}
		else {
			return _bookIDList;
		}
	}

	@Override
	public void setBookIDList(String bookIDList) {
		_bookIDList = bookIDList;
	}

	@Override
	public long getIsApproval() {
		return _isApproval;
	}

	@Override
	public void setIsApproval(long isApproval) {
		_isApproval = isApproval;
	}

	@Override
	public long getTotalQuantities() {
		return _totalQuantities;
	}

	@Override
	public void setTotalQuantities(long totalQuantities) {
		_totalQuantities = totalQuantities;
	}

	@Override
	public long getTotalAmount() {
		return _totalAmount;
	}

	@Override
	public void setTotalAmount(long totalAmount) {
		_totalAmount = totalAmount;
	}

	@Override
	public String getAmountInWords() {
		if (_amountInWords == null) {
			return StringPool.BLANK;
		}
		else {
			return _amountInWords;
		}
	}

	@Override
	public void setAmountInWords(String amountInWords) {
		_amountInWords = amountInWords;
	}

	@Override
	public String getRemark() {
		if (_remark == null) {
			return StringPool.BLANK;
		}
		else {
			return _remark;
		}
	}

	@Override
	public void setRemark(String remark) {
		_remark = remark;
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
			VROutputSheet.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VROutputSheet toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VROutputSheet)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VROutputSheetImpl vrOutputSheetImpl = new VROutputSheetImpl();

		vrOutputSheetImpl.setId(getId());
		vrOutputSheetImpl.setMtCore(getMtCore());
		vrOutputSheetImpl.setOutputSheetNo(getOutputSheetNo());
		vrOutputSheetImpl.setOutputSheetDate(getOutputSheetDate());
		vrOutputSheetImpl.setOriginalDocumentNo(getOriginalDocumentNo());
		vrOutputSheetImpl.setSupplierCorporationId(getSupplierCorporationId());
		vrOutputSheetImpl.setOutputSheetType(getOutputSheetType());
		vrOutputSheetImpl.setMaker(getMaker());
		vrOutputSheetImpl.setChecker(getChecker());
		vrOutputSheetImpl.setApprover(getApprover());
		vrOutputSheetImpl.setReceiverName(getReceiverName());
		vrOutputSheetImpl.setReceiverPlace(getReceiverPlace());
		vrOutputSheetImpl.setReceiverRequest(getReceiverRequest());
		vrOutputSheetImpl.setInventoryName(getInventoryName());
		vrOutputSheetImpl.setInventoryPlace(getInventoryPlace());
		vrOutputSheetImpl.setInventoryDate(getInventoryDate());
		vrOutputSheetImpl.setDossierId(getDossierId());
		vrOutputSheetImpl.setIssueId(getIssueId());
		vrOutputSheetImpl.setPurchaserId(getPurchaserId());
		vrOutputSheetImpl.setPurchaserCorporationId(getPurchaserCorporationId());
		vrOutputSheetImpl.setBookIDList(getBookIDList());
		vrOutputSheetImpl.setIsApproval(getIsApproval());
		vrOutputSheetImpl.setTotalQuantities(getTotalQuantities());
		vrOutputSheetImpl.setTotalAmount(getTotalAmount());
		vrOutputSheetImpl.setAmountInWords(getAmountInWords());
		vrOutputSheetImpl.setRemark(getRemark());
		vrOutputSheetImpl.setModifyDate(getModifyDate());
		vrOutputSheetImpl.setSyncDate(getSyncDate());

		vrOutputSheetImpl.resetOriginalValues();

		return vrOutputSheetImpl;
	}

	@Override
	public int compareTo(VROutputSheet vrOutputSheet) {
		int value = 0;

		value = DateUtil.compareTo(getModifyDate(),
				vrOutputSheet.getModifyDate());

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

		if (!(obj instanceof VROutputSheet)) {
			return false;
		}

		VROutputSheet vrOutputSheet = (VROutputSheet)obj;

		long primaryKey = vrOutputSheet.getPrimaryKey();

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
		VROutputSheetModelImpl vrOutputSheetModelImpl = this;

		vrOutputSheetModelImpl._originalMtCore = vrOutputSheetModelImpl._mtCore;

		vrOutputSheetModelImpl._setOriginalMtCore = false;

		vrOutputSheetModelImpl._originalOutputSheetNo = vrOutputSheetModelImpl._outputSheetNo;

		vrOutputSheetModelImpl._originalSupplierCorporationId = vrOutputSheetModelImpl._supplierCorporationId;

		vrOutputSheetModelImpl._originalOutputSheetType = vrOutputSheetModelImpl._outputSheetType;

		vrOutputSheetModelImpl._setOriginalOutputSheetType = false;

		vrOutputSheetModelImpl._originalDossierId = vrOutputSheetModelImpl._dossierId;

		vrOutputSheetModelImpl._setOriginalDossierId = false;

		vrOutputSheetModelImpl._originalPurchaserCorporationId = vrOutputSheetModelImpl._purchaserCorporationId;

		vrOutputSheetModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VROutputSheet> toCacheModel() {
		VROutputSheetCacheModel vrOutputSheetCacheModel = new VROutputSheetCacheModel();

		vrOutputSheetCacheModel.id = getId();

		vrOutputSheetCacheModel.mtCore = getMtCore();

		vrOutputSheetCacheModel.outputSheetNo = getOutputSheetNo();

		String outputSheetNo = vrOutputSheetCacheModel.outputSheetNo;

		if ((outputSheetNo != null) && (outputSheetNo.length() == 0)) {
			vrOutputSheetCacheModel.outputSheetNo = null;
		}

		Date outputSheetDate = getOutputSheetDate();

		if (outputSheetDate != null) {
			vrOutputSheetCacheModel.outputSheetDate = outputSheetDate.getTime();
		}
		else {
			vrOutputSheetCacheModel.outputSheetDate = Long.MIN_VALUE;
		}

		vrOutputSheetCacheModel.originalDocumentNo = getOriginalDocumentNo();

		String originalDocumentNo = vrOutputSheetCacheModel.originalDocumentNo;

		if ((originalDocumentNo != null) && (originalDocumentNo.length() == 0)) {
			vrOutputSheetCacheModel.originalDocumentNo = null;
		}

		vrOutputSheetCacheModel.supplierCorporationId = getSupplierCorporationId();

		String supplierCorporationId = vrOutputSheetCacheModel.supplierCorporationId;

		if ((supplierCorporationId != null) &&
				(supplierCorporationId.length() == 0)) {
			vrOutputSheetCacheModel.supplierCorporationId = null;
		}

		vrOutputSheetCacheModel.outputSheetType = getOutputSheetType();

		vrOutputSheetCacheModel.maker = getMaker();

		String maker = vrOutputSheetCacheModel.maker;

		if ((maker != null) && (maker.length() == 0)) {
			vrOutputSheetCacheModel.maker = null;
		}

		vrOutputSheetCacheModel.checker = getChecker();

		String checker = vrOutputSheetCacheModel.checker;

		if ((checker != null) && (checker.length() == 0)) {
			vrOutputSheetCacheModel.checker = null;
		}

		vrOutputSheetCacheModel.approver = getApprover();

		String approver = vrOutputSheetCacheModel.approver;

		if ((approver != null) && (approver.length() == 0)) {
			vrOutputSheetCacheModel.approver = null;
		}

		vrOutputSheetCacheModel.receiverName = getReceiverName();

		String receiverName = vrOutputSheetCacheModel.receiverName;

		if ((receiverName != null) && (receiverName.length() == 0)) {
			vrOutputSheetCacheModel.receiverName = null;
		}

		vrOutputSheetCacheModel.receiverPlace = getReceiverPlace();

		String receiverPlace = vrOutputSheetCacheModel.receiverPlace;

		if ((receiverPlace != null) && (receiverPlace.length() == 0)) {
			vrOutputSheetCacheModel.receiverPlace = null;
		}

		vrOutputSheetCacheModel.receiverRequest = getReceiverRequest();

		String receiverRequest = vrOutputSheetCacheModel.receiverRequest;

		if ((receiverRequest != null) && (receiverRequest.length() == 0)) {
			vrOutputSheetCacheModel.receiverRequest = null;
		}

		vrOutputSheetCacheModel.inventoryName = getInventoryName();

		String inventoryName = vrOutputSheetCacheModel.inventoryName;

		if ((inventoryName != null) && (inventoryName.length() == 0)) {
			vrOutputSheetCacheModel.inventoryName = null;
		}

		vrOutputSheetCacheModel.inventoryPlace = getInventoryPlace();

		String inventoryPlace = vrOutputSheetCacheModel.inventoryPlace;

		if ((inventoryPlace != null) && (inventoryPlace.length() == 0)) {
			vrOutputSheetCacheModel.inventoryPlace = null;
		}

		Date inventoryDate = getInventoryDate();

		if (inventoryDate != null) {
			vrOutputSheetCacheModel.inventoryDate = inventoryDate.getTime();
		}
		else {
			vrOutputSheetCacheModel.inventoryDate = Long.MIN_VALUE;
		}

		vrOutputSheetCacheModel.dossierId = getDossierId();

		vrOutputSheetCacheModel.issueId = getIssueId();

		vrOutputSheetCacheModel.purchaserId = getPurchaserId();

		String purchaserId = vrOutputSheetCacheModel.purchaserId;

		if ((purchaserId != null) && (purchaserId.length() == 0)) {
			vrOutputSheetCacheModel.purchaserId = null;
		}

		vrOutputSheetCacheModel.purchaserCorporationId = getPurchaserCorporationId();

		String purchaserCorporationId = vrOutputSheetCacheModel.purchaserCorporationId;

		if ((purchaserCorporationId != null) &&
				(purchaserCorporationId.length() == 0)) {
			vrOutputSheetCacheModel.purchaserCorporationId = null;
		}

		vrOutputSheetCacheModel.bookIDList = getBookIDList();

		String bookIDList = vrOutputSheetCacheModel.bookIDList;

		if ((bookIDList != null) && (bookIDList.length() == 0)) {
			vrOutputSheetCacheModel.bookIDList = null;
		}

		vrOutputSheetCacheModel.isApproval = getIsApproval();

		vrOutputSheetCacheModel.totalQuantities = getTotalQuantities();

		vrOutputSheetCacheModel.totalAmount = getTotalAmount();

		vrOutputSheetCacheModel.amountInWords = getAmountInWords();

		String amountInWords = vrOutputSheetCacheModel.amountInWords;

		if ((amountInWords != null) && (amountInWords.length() == 0)) {
			vrOutputSheetCacheModel.amountInWords = null;
		}

		vrOutputSheetCacheModel.remark = getRemark();

		String remark = vrOutputSheetCacheModel.remark;

		if ((remark != null) && (remark.length() == 0)) {
			vrOutputSheetCacheModel.remark = null;
		}

		Date modifyDate = getModifyDate();

		if (modifyDate != null) {
			vrOutputSheetCacheModel.modifyDate = modifyDate.getTime();
		}
		else {
			vrOutputSheetCacheModel.modifyDate = Long.MIN_VALUE;
		}

		Date syncDate = getSyncDate();

		if (syncDate != null) {
			vrOutputSheetCacheModel.syncDate = syncDate.getTime();
		}
		else {
			vrOutputSheetCacheModel.syncDate = Long.MIN_VALUE;
		}

		return vrOutputSheetCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", mtCore=");
		sb.append(getMtCore());
		sb.append(", outputSheetNo=");
		sb.append(getOutputSheetNo());
		sb.append(", outputSheetDate=");
		sb.append(getOutputSheetDate());
		sb.append(", originalDocumentNo=");
		sb.append(getOriginalDocumentNo());
		sb.append(", supplierCorporationId=");
		sb.append(getSupplierCorporationId());
		sb.append(", outputSheetType=");
		sb.append(getOutputSheetType());
		sb.append(", maker=");
		sb.append(getMaker());
		sb.append(", checker=");
		sb.append(getChecker());
		sb.append(", approver=");
		sb.append(getApprover());
		sb.append(", receiverName=");
		sb.append(getReceiverName());
		sb.append(", receiverPlace=");
		sb.append(getReceiverPlace());
		sb.append(", receiverRequest=");
		sb.append(getReceiverRequest());
		sb.append(", inventoryName=");
		sb.append(getInventoryName());
		sb.append(", inventoryPlace=");
		sb.append(getInventoryPlace());
		sb.append(", inventoryDate=");
		sb.append(getInventoryDate());
		sb.append(", dossierId=");
		sb.append(getDossierId());
		sb.append(", issueId=");
		sb.append(getIssueId());
		sb.append(", purchaserId=");
		sb.append(getPurchaserId());
		sb.append(", purchaserCorporationId=");
		sb.append(getPurchaserCorporationId());
		sb.append(", bookIDList=");
		sb.append(getBookIDList());
		sb.append(", isApproval=");
		sb.append(getIsApproval());
		sb.append(", totalQuantities=");
		sb.append(getTotalQuantities());
		sb.append(", totalAmount=");
		sb.append(getTotalAmount());
		sb.append(", amountInWords=");
		sb.append(getAmountInWords());
		sb.append(", remark=");
		sb.append(getRemark());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", syncDate=");
		sb.append(getSyncDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(88);

		sb.append("<model><model-name>");
		sb.append("com.fds.vr.business.model.VROutputSheet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mtCore</column-name><column-value><![CDATA[");
		sb.append(getMtCore());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outputSheetNo</column-name><column-value><![CDATA[");
		sb.append(getOutputSheetNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outputSheetDate</column-name><column-value><![CDATA[");
		sb.append(getOutputSheetDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>originalDocumentNo</column-name><column-value><![CDATA[");
		sb.append(getOriginalDocumentNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supplierCorporationId</column-name><column-value><![CDATA[");
		sb.append(getSupplierCorporationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outputSheetType</column-name><column-value><![CDATA[");
		sb.append(getOutputSheetType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maker</column-name><column-value><![CDATA[");
		sb.append(getMaker());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checker</column-name><column-value><![CDATA[");
		sb.append(getChecker());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approver</column-name><column-value><![CDATA[");
		sb.append(getApprover());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiverName</column-name><column-value><![CDATA[");
		sb.append(getReceiverName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiverPlace</column-name><column-value><![CDATA[");
		sb.append(getReceiverPlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiverRequest</column-name><column-value><![CDATA[");
		sb.append(getReceiverRequest());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inventoryName</column-name><column-value><![CDATA[");
		sb.append(getInventoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inventoryPlace</column-name><column-value><![CDATA[");
		sb.append(getInventoryPlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inventoryDate</column-name><column-value><![CDATA[");
		sb.append(getInventoryDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierId</column-name><column-value><![CDATA[");
		sb.append(getDossierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issueId</column-name><column-value><![CDATA[");
		sb.append(getIssueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>purchaserId</column-name><column-value><![CDATA[");
		sb.append(getPurchaserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>purchaserCorporationId</column-name><column-value><![CDATA[");
		sb.append(getPurchaserCorporationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookIDList</column-name><column-value><![CDATA[");
		sb.append(getBookIDList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isApproval</column-name><column-value><![CDATA[");
		sb.append(getIsApproval());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalQuantities</column-name><column-value><![CDATA[");
		sb.append(getTotalQuantities());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalAmount</column-name><column-value><![CDATA[");
		sb.append(getTotalAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amountInWords</column-name><column-value><![CDATA[");
		sb.append(getAmountInWords());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remark</column-name><column-value><![CDATA[");
		sb.append(getRemark());
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

	private static final ClassLoader _classLoader = VROutputSheet.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			VROutputSheet.class
		};
	private long _id;
	private long _mtCore;
	private long _originalMtCore;
	private boolean _setOriginalMtCore;
	private String _outputSheetNo;
	private String _originalOutputSheetNo;
	private Date _outputSheetDate;
	private String _originalDocumentNo;
	private String _supplierCorporationId;
	private String _originalSupplierCorporationId;
	private long _outputSheetType;
	private long _originalOutputSheetType;
	private boolean _setOriginalOutputSheetType;
	private String _maker;
	private String _checker;
	private String _approver;
	private String _receiverName;
	private String _receiverPlace;
	private String _receiverRequest;
	private String _inventoryName;
	private String _inventoryPlace;
	private Date _inventoryDate;
	private long _dossierId;
	private long _originalDossierId;
	private boolean _setOriginalDossierId;
	private long _issueId;
	private String _purchaserId;
	private String _purchaserCorporationId;
	private String _originalPurchaserCorporationId;
	private String _bookIDList;
	private long _isApproval;
	private long _totalQuantities;
	private long _totalAmount;
	private String _amountInWords;
	private String _remark;
	private Date _modifyDate;
	private Date _syncDate;
	private long _columnBitmask;
	private VROutputSheet _escapedModel;
}