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

package vn.gt.dao.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;

import aQute.bnd.annotation.ProviderType;
import vn.gt.dao.model.PushStatisticsLog;
import vn.gt.dao.model.impl.PushStatisticsLogImpl;
import vn.gt.dao.service.base.PushStatisticsLogLocalServiceBaseImpl;

/**
 * The implementation of the push statistics log local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.gt.dao.service.PushStatisticsLogLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author huymq
 * @see PushStatisticsLogLocalServiceBaseImpl
 * @see vn.gt.dao.service.PushStatisticsLogLocalServiceUtil
 */
@ProviderType
public class PushStatisticsLogLocalServiceImpl
	extends PushStatisticsLogLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link vn.gt.dao.service.PushStatisticsLogLocalServiceUtil} to access the push statistics log local service.
	 */
	
	public PushStatisticsLog addLog(long dossierId, long newDossierId, Date finishDate) {
		long id = counterLocalService.increment(PushStatisticsLog.class.getName());
		PushStatisticsLog compressFileLog = pushStatisticsLogPersistence.create(id);

		compressFileLog.setCreateDate(new Date());
		if(finishDate != null) {
			compressFileLog.setFinishDate(finishDate);
		}
		compressFileLog.setDossierId(dossierId);
		compressFileLog.setNewDossierId(newDossierId);

		if (newDossierId > 0) {
			compressFileLog.setStatus(true);
		} else {
			compressFileLog.setStatus(false);
		}

		return pushStatisticsLogPersistence.update(compressFileLog);
	}
	
	public PushStatisticsLog getLasted() throws SystemException {
		OrderByComparator<PushStatisticsLog> comparator = OrderByComparatorFactoryUtil.create(
				PushStatisticsLogImpl.TABLE_NAME, "finishDate", false);
		List<PushStatisticsLog> pushStatisticsLogs = pushStatisticsLogPersistence.findAll(0, 1, comparator);
		
		if(pushStatisticsLogs != null && pushStatisticsLogs.size() > 0) {
			return pushStatisticsLogs.get(0);
		} else {
			return null;
		}
	}
}