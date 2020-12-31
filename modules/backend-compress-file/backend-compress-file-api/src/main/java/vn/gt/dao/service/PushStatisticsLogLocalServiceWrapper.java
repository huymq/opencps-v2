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

package vn.gt.dao.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PushStatisticsLogLocalService}.
 *
 * @author huymq
 * @see PushStatisticsLogLocalService
 * @generated
 */
@ProviderType
public class PushStatisticsLogLocalServiceWrapper
	implements PushStatisticsLogLocalService,
		ServiceWrapper<PushStatisticsLogLocalService> {
	public PushStatisticsLogLocalServiceWrapper(
		PushStatisticsLogLocalService pushStatisticsLogLocalService) {
		_pushStatisticsLogLocalService = pushStatisticsLogLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _pushStatisticsLogLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pushStatisticsLogLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _pushStatisticsLogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pushStatisticsLogLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pushStatisticsLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of push statistics logs.
	*
	* @return the number of push statistics logs
	*/
	@Override
	public int getPushStatisticsLogsCount() {
		return _pushStatisticsLogLocalService.getPushStatisticsLogsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _pushStatisticsLogLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _pushStatisticsLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.gt.dao.model.impl.PushStatisticsLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _pushStatisticsLogLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.gt.dao.model.impl.PushStatisticsLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _pushStatisticsLogLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the push statistics logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.gt.dao.model.impl.PushStatisticsLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of push statistics logs
	* @param end the upper bound of the range of push statistics logs (not inclusive)
	* @return the range of push statistics logs
	*/
	@Override
	public java.util.List<vn.gt.dao.model.PushStatisticsLog> getPushStatisticsLogs(
		int start, int end) {
		return _pushStatisticsLogLocalService.getPushStatisticsLogs(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _pushStatisticsLogLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _pushStatisticsLogLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.gt.dao.model.PushStatisticsLog addLog(long dossierId,
		long newDossierId, java.util.Date finishDate) {
		return _pushStatisticsLogLocalService.addLog(dossierId, newDossierId,
			finishDate);
	}

	/**
	* Adds the push statistics log to the database. Also notifies the appropriate model listeners.
	*
	* @param pushStatisticsLog the push statistics log
	* @return the push statistics log that was added
	*/
	@Override
	public vn.gt.dao.model.PushStatisticsLog addPushStatisticsLog(
		vn.gt.dao.model.PushStatisticsLog pushStatisticsLog) {
		return _pushStatisticsLogLocalService.addPushStatisticsLog(pushStatisticsLog);
	}

	/**
	* Creates a new push statistics log with the primary key. Does not add the push statistics log to the database.
	*
	* @param id the primary key for the new push statistics log
	* @return the new push statistics log
	*/
	@Override
	public vn.gt.dao.model.PushStatisticsLog createPushStatisticsLog(long id) {
		return _pushStatisticsLogLocalService.createPushStatisticsLog(id);
	}

	/**
	* Deletes the push statistics log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the push statistics log
	* @return the push statistics log that was removed
	* @throws PortalException if a push statistics log with the primary key could not be found
	*/
	@Override
	public vn.gt.dao.model.PushStatisticsLog deletePushStatisticsLog(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pushStatisticsLogLocalService.deletePushStatisticsLog(id);
	}

	/**
	* Deletes the push statistics log from the database. Also notifies the appropriate model listeners.
	*
	* @param pushStatisticsLog the push statistics log
	* @return the push statistics log that was removed
	*/
	@Override
	public vn.gt.dao.model.PushStatisticsLog deletePushStatisticsLog(
		vn.gt.dao.model.PushStatisticsLog pushStatisticsLog) {
		return _pushStatisticsLogLocalService.deletePushStatisticsLog(pushStatisticsLog);
	}

	@Override
	public vn.gt.dao.model.PushStatisticsLog fetchPushStatisticsLog(long id) {
		return _pushStatisticsLogLocalService.fetchPushStatisticsLog(id);
	}

	@Override
	public vn.gt.dao.model.PushStatisticsLog getLasted()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pushStatisticsLogLocalService.getLasted();
	}

	/**
	* Returns the push statistics log with the primary key.
	*
	* @param id the primary key of the push statistics log
	* @return the push statistics log
	* @throws PortalException if a push statistics log with the primary key could not be found
	*/
	@Override
	public vn.gt.dao.model.PushStatisticsLog getPushStatisticsLog(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pushStatisticsLogLocalService.getPushStatisticsLog(id);
	}

	/**
	* Updates the push statistics log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pushStatisticsLog the push statistics log
	* @return the push statistics log that was updated
	*/
	@Override
	public vn.gt.dao.model.PushStatisticsLog updatePushStatisticsLog(
		vn.gt.dao.model.PushStatisticsLog pushStatisticsLog) {
		return _pushStatisticsLogLocalService.updatePushStatisticsLog(pushStatisticsLog);
	}

	@Override
	public PushStatisticsLogLocalService getWrappedService() {
		return _pushStatisticsLogLocalService;
	}

	@Override
	public void setWrappedService(
		PushStatisticsLogLocalService pushStatisticsLogLocalService) {
		_pushStatisticsLogLocalService = pushStatisticsLogLocalService;
	}

	private PushStatisticsLogLocalService _pushStatisticsLogLocalService;
}