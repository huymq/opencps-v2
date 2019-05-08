package com.fds.vr.business.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.sql.Timestamp;
import java.util.Date;

import org.opencps.datamgt.model.DictItem;
import org.opencps.datamgt.model.impl.DictItemImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;

import com.fds.vr.business.model.VRProductionPlantProdEquipment;
import com.fds.vr.business.model.impl.VRProductionPlantProdEquipmentImpl;
import com.fds.vr.business.service.persistence.VRProductionPlantProdEquipmentFinder;


public class VRProductionPlantProdEquipmentFinderImpl extends VRProductionPlantProdEquipmentFinderBaseImpl
	implements VRProductionPlantProdEquipmentFinder {

	Log _log = LogFactoryUtil.getLog(VRProductionPlantProdEquipmentFinderImpl.class);

	
}
