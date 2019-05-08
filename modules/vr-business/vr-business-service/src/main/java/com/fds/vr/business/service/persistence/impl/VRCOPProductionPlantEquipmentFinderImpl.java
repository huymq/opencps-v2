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

import com.fds.vr.business.model.VRCOPProductionPlantEquipment;
import com.fds.vr.business.model.impl.VRCOPProductionPlantEquipmentImpl;
import com.fds.vr.business.service.persistence.VRCOPProductionPlantEquipmentFinder;


public class VRCOPProductionPlantEquipmentFinderImpl extends VRCOPProductionPlantEquipmentFinderBaseImpl
	implements VRCOPProductionPlantEquipmentFinder {

	Log _log = LogFactoryUtil.getLog(VRCOPProductionPlantEquipmentFinderImpl.class);

	
}
