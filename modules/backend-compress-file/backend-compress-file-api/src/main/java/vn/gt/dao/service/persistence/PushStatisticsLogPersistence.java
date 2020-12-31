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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import vn.gt.dao.exception.NoSuchPushStatisticsLogException;
import vn.gt.dao.model.PushStatisticsLog;

/**
 * The persistence interface for the push statistics log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author huymq
 * @see vn.gt.dao.service.persistence.impl.PushStatisticsLogPersistenceImpl
 * @see PushStatisticsLogUtil
 * @generated
 */
@ProviderType
public interface PushStatisticsLogPersistence extends BasePersistence<PushStatisticsLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PushStatisticsLogUtil} to access the push statistics log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the push statistics log where dossierId = &#63; or throws a {@link NoSuchPushStatisticsLogException} if it could not be found.
	*
	* @param dossierId the dossier ID
	* @return the matching push statistics log
	* @throws NoSuchPushStatisticsLogException if a matching push statistics log could not be found
	*/
	public PushStatisticsLog findByDossierId(long dossierId)
		throws NoSuchPushStatisticsLogException;

	/**
	* Returns the push statistics log where dossierId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dossierId the dossier ID
	* @return the matching push statistics log, or <code>null</code> if a matching push statistics log could not be found
	*/
	public PushStatisticsLog fetchByDossierId(long dossierId);

	/**
	* Returns the push statistics log where dossierId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dossierId the dossier ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching push statistics log, or <code>null</code> if a matching push statistics log could not be found
	*/
	public PushStatisticsLog fetchByDossierId(long dossierId,
		boolean retrieveFromCache);

	/**
	* Removes the push statistics log where dossierId = &#63; from the database.
	*
	* @param dossierId the dossier ID
	* @return the push statistics log that was removed
	*/
	public PushStatisticsLog removeByDossierId(long dossierId)
		throws NoSuchPushStatisticsLogException;

	/**
	* Returns the number of push statistics logs where dossierId = &#63;.
	*
	* @param dossierId the dossier ID
	* @return the number of matching push statistics logs
	*/
	public int countByDossierId(long dossierId);

	/**
	* Caches the push statistics log in the entity cache if it is enabled.
	*
	* @param pushStatisticsLog the push statistics log
	*/
	public void cacheResult(PushStatisticsLog pushStatisticsLog);

	/**
	* Caches the push statistics logs in the entity cache if it is enabled.
	*
	* @param pushStatisticsLogs the push statistics logs
	*/
	public void cacheResult(
		java.util.List<PushStatisticsLog> pushStatisticsLogs);

	/**
	* Creates a new push statistics log with the primary key. Does not add the push statistics log to the database.
	*
	* @param id the primary key for the new push statistics log
	* @return the new push statistics log
	*/
	public PushStatisticsLog create(long id);

	/**
	* Removes the push statistics log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the push statistics log
	* @return the push statistics log that was removed
	* @throws NoSuchPushStatisticsLogException if a push statistics log with the primary key could not be found
	*/
	public PushStatisticsLog remove(long id)
		throws NoSuchPushStatisticsLogException;

	public PushStatisticsLog updateImpl(PushStatisticsLog pushStatisticsLog);

	/**
	* Returns the push statistics log with the primary key or throws a {@link NoSuchPushStatisticsLogException} if it could not be found.
	*
	* @param id the primary key of the push statistics log
	* @return the push statistics log
	* @throws NoSuchPushStatisticsLogException if a push statistics log with the primary key could not be found
	*/
	public PushStatisticsLog findByPrimaryKey(long id)
		throws NoSuchPushStatisticsLogException;

	/**
	* Returns the push statistics log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the push statistics log
	* @return the push statistics log, or <code>null</code> if a push statistics log with the primary key could not be found
	*/
	public PushStatisticsLog fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, PushStatisticsLog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the push statistics logs.
	*
	* @return the push statistics logs
	*/
	public java.util.List<PushStatisticsLog> findAll();

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
	public java.util.List<PushStatisticsLog> findAll(int start, int end);

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
	public java.util.List<PushStatisticsLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PushStatisticsLog> orderByComparator);

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
	public java.util.List<PushStatisticsLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PushStatisticsLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the push statistics logs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of push statistics logs.
	*
	* @return the number of push statistics logs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}