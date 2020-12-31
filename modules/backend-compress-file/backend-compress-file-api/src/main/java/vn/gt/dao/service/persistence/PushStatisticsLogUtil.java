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

package vn.gt.dao.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import vn.gt.dao.model.PushStatisticsLog;

import java.util.List;

/**
 * The persistence utility for the push statistics log service. This utility wraps {@link vn.gt.dao.service.persistence.impl.PushStatisticsLogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author huymq
 * @see PushStatisticsLogPersistence
 * @see vn.gt.dao.service.persistence.impl.PushStatisticsLogPersistenceImpl
 * @generated
 */
@ProviderType
public class PushStatisticsLogUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(PushStatisticsLog pushStatisticsLog) {
		getPersistence().clearCache(pushStatisticsLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PushStatisticsLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PushStatisticsLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PushStatisticsLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PushStatisticsLog> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PushStatisticsLog update(PushStatisticsLog pushStatisticsLog) {
		return getPersistence().update(pushStatisticsLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PushStatisticsLog update(
		PushStatisticsLog pushStatisticsLog, ServiceContext serviceContext) {
		return getPersistence().update(pushStatisticsLog, serviceContext);
	}

	/**
	* Returns the push statistics log where dossierId = &#63; or throws a {@link NoSuchPushStatisticsLogException} if it could not be found.
	*
	* @param dossierId the dossier ID
	* @return the matching push statistics log
	* @throws NoSuchPushStatisticsLogException if a matching push statistics log could not be found
	*/
	public static PushStatisticsLog findByDossierId(long dossierId)
		throws vn.gt.dao.exception.NoSuchPushStatisticsLogException {
		return getPersistence().findByDossierId(dossierId);
	}

	/**
	* Returns the push statistics log where dossierId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dossierId the dossier ID
	* @return the matching push statistics log, or <code>null</code> if a matching push statistics log could not be found
	*/
	public static PushStatisticsLog fetchByDossierId(long dossierId) {
		return getPersistence().fetchByDossierId(dossierId);
	}

	/**
	* Returns the push statistics log where dossierId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dossierId the dossier ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching push statistics log, or <code>null</code> if a matching push statistics log could not be found
	*/
	public static PushStatisticsLog fetchByDossierId(long dossierId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByDossierId(dossierId, retrieveFromCache);
	}

	/**
	* Removes the push statistics log where dossierId = &#63; from the database.
	*
	* @param dossierId the dossier ID
	* @return the push statistics log that was removed
	*/
	public static PushStatisticsLog removeByDossierId(long dossierId)
		throws vn.gt.dao.exception.NoSuchPushStatisticsLogException {
		return getPersistence().removeByDossierId(dossierId);
	}

	/**
	* Returns the number of push statistics logs where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @return the number of matching push statistics logs
	*/
	public static int countByDossierId(long dossierId) {
		return getPersistence().countByDossierId(dossierId);
	}

	/**
	* Caches the push statistics log in the entity cache if it is enabled.
	*
	* @param pushStatisticsLog the push statistics log
	*/
	public static void cacheResult(PushStatisticsLog pushStatisticsLog) {
		getPersistence().cacheResult(pushStatisticsLog);
	}

	/**
	* Caches the push statistics logs in the entity cache if it is enabled.
	*
	* @param pushStatisticsLogs the push statistics logs
	*/
	public static void cacheResult(List<PushStatisticsLog> pushStatisticsLogs) {
		getPersistence().cacheResult(pushStatisticsLogs);
	}

	/**
	* Creates a new push statistics log with the primary key. Does not add the push statistics log to the database.
	*
	* @param id the primary key for the new push statistics log
	* @return the new push statistics log
	*/
	public static PushStatisticsLog create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the push statistics log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the push statistics log
	* @return the push statistics log that was removed
	* @throws NoSuchPushStatisticsLogException if a push statistics log with the primary key could not be found
	*/
	public static PushStatisticsLog remove(long id)
		throws vn.gt.dao.exception.NoSuchPushStatisticsLogException {
		return getPersistence().remove(id);
	}

	public static PushStatisticsLog updateImpl(
		PushStatisticsLog pushStatisticsLog) {
		return getPersistence().updateImpl(pushStatisticsLog);
	}

	/**
	* Returns the push statistics log with the primary key or throws a {@link NoSuchPushStatisticsLogException} if it could not be found.
	*
	* @param id the primary key of the push statistics log
	* @return the push statistics log
	* @throws NoSuchPushStatisticsLogException if a push statistics log with the primary key could not be found
	*/
	public static PushStatisticsLog findByPrimaryKey(long id)
		throws vn.gt.dao.exception.NoSuchPushStatisticsLogException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the push statistics log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the push statistics log
	* @return the push statistics log, or <code>null</code> if a push statistics log with the primary key could not be found
	*/
	public static PushStatisticsLog fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, PushStatisticsLog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the push statistics logs.
	*
	* @return the push statistics logs
	*/
	public static List<PushStatisticsLog> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the push statistics logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PushStatisticsLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of push statistics logs
	* @param end the upper bound of the range of push statistics logs (not inclusive)
	* @return the range of push statistics logs
	*/
	public static List<PushStatisticsLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the push statistics logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PushStatisticsLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of push statistics logs
	* @param end the upper bound of the range of push statistics logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of push statistics logs
	*/
	public static List<PushStatisticsLog> findAll(int start, int end,
		OrderByComparator<PushStatisticsLog> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the push statistics logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PushStatisticsLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of push statistics logs
	* @param end the upper bound of the range of push statistics logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of push statistics logs
	*/
	public static List<PushStatisticsLog> findAll(int start, int end,
		OrderByComparator<PushStatisticsLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the push statistics logs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of push statistics logs.
	*
	* @return the number of push statistics logs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PushStatisticsLogPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PushStatisticsLogPersistence, PushStatisticsLogPersistence> _serviceTracker =
		ServiceTrackerFactory.open(PushStatisticsLogPersistence.class);
}