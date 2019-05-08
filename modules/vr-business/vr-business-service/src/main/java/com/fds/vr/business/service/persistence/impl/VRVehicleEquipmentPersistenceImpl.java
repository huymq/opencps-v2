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

package com.fds.vr.business.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.fds.vr.business.exception.NoSuchVRVehicleEquipmentException;
import com.fds.vr.business.model.VRVehicleEquipment;
import com.fds.vr.business.model.impl.VRVehicleEquipmentImpl;
import com.fds.vr.business.model.impl.VRVehicleEquipmentModelImpl;
import com.fds.vr.business.service.persistence.VRVehicleEquipmentPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the vr vehicle equipment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LamTV
 * @see VRVehicleEquipmentPersistence
 * @see com.fds.vr.business.service.persistence.VRVehicleEquipmentUtil
 * @generated
 */
@ProviderType
public class VRVehicleEquipmentPersistenceImpl extends BasePersistenceImpl<VRVehicleEquipment>
	implements VRVehicleEquipmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VRVehicleEquipmentUtil} to access the vr vehicle equipment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VRVehicleEquipmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VRVehicleEquipmentModelImpl.ENTITY_CACHE_ENABLED,
			VRVehicleEquipmentModelImpl.FINDER_CACHE_ENABLED,
			VRVehicleEquipmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VRVehicleEquipmentModelImpl.ENTITY_CACHE_ENABLED,
			VRVehicleEquipmentModelImpl.FINDER_CACHE_ENABLED,
			VRVehicleEquipmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VRVehicleEquipmentModelImpl.ENTITY_CACHE_ENABLED,
			VRVehicleEquipmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public VRVehicleEquipmentPersistenceImpl() {
		setModelClass(VRVehicleEquipment.class);
	}

	/**
	 * Caches the vr vehicle equipment in the entity cache if it is enabled.
	 *
	 * @param vrVehicleEquipment the vr vehicle equipment
	 */
	@Override
	public void cacheResult(VRVehicleEquipment vrVehicleEquipment) {
		entityCache.putResult(VRVehicleEquipmentModelImpl.ENTITY_CACHE_ENABLED,
			VRVehicleEquipmentImpl.class, vrVehicleEquipment.getPrimaryKey(),
			vrVehicleEquipment);

		vrVehicleEquipment.resetOriginalValues();
	}

	/**
	 * Caches the vr vehicle equipments in the entity cache if it is enabled.
	 *
	 * @param vrVehicleEquipments the vr vehicle equipments
	 */
	@Override
	public void cacheResult(List<VRVehicleEquipment> vrVehicleEquipments) {
		for (VRVehicleEquipment vrVehicleEquipment : vrVehicleEquipments) {
			if (entityCache.getResult(
						VRVehicleEquipmentModelImpl.ENTITY_CACHE_ENABLED,
						VRVehicleEquipmentImpl.class,
						vrVehicleEquipment.getPrimaryKey()) == null) {
				cacheResult(vrVehicleEquipment);
			}
			else {
				vrVehicleEquipment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vr vehicle equipments.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VRVehicleEquipmentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vr vehicle equipment.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VRVehicleEquipment vrVehicleEquipment) {
		entityCache.removeResult(VRVehicleEquipmentModelImpl.ENTITY_CACHE_ENABLED,
			VRVehicleEquipmentImpl.class, vrVehicleEquipment.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VRVehicleEquipment> vrVehicleEquipments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VRVehicleEquipment vrVehicleEquipment : vrVehicleEquipments) {
			entityCache.removeResult(VRVehicleEquipmentModelImpl.ENTITY_CACHE_ENABLED,
				VRVehicleEquipmentImpl.class, vrVehicleEquipment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vr vehicle equipment with the primary key. Does not add the vr vehicle equipment to the database.
	 *
	 * @param id the primary key for the new vr vehicle equipment
	 * @return the new vr vehicle equipment
	 */
	@Override
	public VRVehicleEquipment create(long id) {
		VRVehicleEquipment vrVehicleEquipment = new VRVehicleEquipmentImpl();

		vrVehicleEquipment.setNew(true);
		vrVehicleEquipment.setPrimaryKey(id);

		return vrVehicleEquipment;
	}

	/**
	 * Removes the vr vehicle equipment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vr vehicle equipment
	 * @return the vr vehicle equipment that was removed
	 * @throws NoSuchVRVehicleEquipmentException if a vr vehicle equipment with the primary key could not be found
	 */
	@Override
	public VRVehicleEquipment remove(long id)
		throws NoSuchVRVehicleEquipmentException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the vr vehicle equipment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vr vehicle equipment
	 * @return the vr vehicle equipment that was removed
	 * @throws NoSuchVRVehicleEquipmentException if a vr vehicle equipment with the primary key could not be found
	 */
	@Override
	public VRVehicleEquipment remove(Serializable primaryKey)
		throws NoSuchVRVehicleEquipmentException {
		Session session = null;

		try {
			session = openSession();

			VRVehicleEquipment vrVehicleEquipment = (VRVehicleEquipment)session.get(VRVehicleEquipmentImpl.class,
					primaryKey);

			if (vrVehicleEquipment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVRVehicleEquipmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vrVehicleEquipment);
		}
		catch (NoSuchVRVehicleEquipmentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected VRVehicleEquipment removeImpl(
		VRVehicleEquipment vrVehicleEquipment) {
		vrVehicleEquipment = toUnwrappedModel(vrVehicleEquipment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vrVehicleEquipment)) {
				vrVehicleEquipment = (VRVehicleEquipment)session.get(VRVehicleEquipmentImpl.class,
						vrVehicleEquipment.getPrimaryKeyObj());
			}

			if (vrVehicleEquipment != null) {
				session.delete(vrVehicleEquipment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vrVehicleEquipment != null) {
			clearCache(vrVehicleEquipment);
		}

		return vrVehicleEquipment;
	}

	@Override
	public VRVehicleEquipment updateImpl(VRVehicleEquipment vrVehicleEquipment) {
		vrVehicleEquipment = toUnwrappedModel(vrVehicleEquipment);

		boolean isNew = vrVehicleEquipment.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vrVehicleEquipment.isNew()) {
				session.save(vrVehicleEquipment);

				vrVehicleEquipment.setNew(false);
			}
			else {
				vrVehicleEquipment = (VRVehicleEquipment)session.merge(vrVehicleEquipment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(VRVehicleEquipmentModelImpl.ENTITY_CACHE_ENABLED,
			VRVehicleEquipmentImpl.class, vrVehicleEquipment.getPrimaryKey(),
			vrVehicleEquipment, false);

		vrVehicleEquipment.resetOriginalValues();

		return vrVehicleEquipment;
	}

	protected VRVehicleEquipment toUnwrappedModel(
		VRVehicleEquipment vrVehicleEquipment) {
		if (vrVehicleEquipment instanceof VRVehicleEquipmentImpl) {
			return vrVehicleEquipment;
		}

		VRVehicleEquipmentImpl vrVehicleEquipmentImpl = new VRVehicleEquipmentImpl();

		vrVehicleEquipmentImpl.setNew(vrVehicleEquipment.isNew());
		vrVehicleEquipmentImpl.setPrimaryKey(vrVehicleEquipment.getPrimaryKey());

		vrVehicleEquipmentImpl.setId(vrVehicleEquipment.getId());
		vrVehicleEquipmentImpl.setVehicleCertificateId(vrVehicleEquipment.getVehicleCertificateId());
		vrVehicleEquipmentImpl.setCertificateRecordId(vrVehicleEquipment.getCertificateRecordId());
		vrVehicleEquipmentImpl.setModifyDate(vrVehicleEquipment.getModifyDate());
		vrVehicleEquipmentImpl.setSyncDate(vrVehicleEquipment.getSyncDate());

		return vrVehicleEquipmentImpl;
	}

	/**
	 * Returns the vr vehicle equipment with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vr vehicle equipment
	 * @return the vr vehicle equipment
	 * @throws NoSuchVRVehicleEquipmentException if a vr vehicle equipment with the primary key could not be found
	 */
	@Override
	public VRVehicleEquipment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVRVehicleEquipmentException {
		VRVehicleEquipment vrVehicleEquipment = fetchByPrimaryKey(primaryKey);

		if (vrVehicleEquipment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVRVehicleEquipmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vrVehicleEquipment;
	}

	/**
	 * Returns the vr vehicle equipment with the primary key or throws a {@link NoSuchVRVehicleEquipmentException} if it could not be found.
	 *
	 * @param id the primary key of the vr vehicle equipment
	 * @return the vr vehicle equipment
	 * @throws NoSuchVRVehicleEquipmentException if a vr vehicle equipment with the primary key could not be found
	 */
	@Override
	public VRVehicleEquipment findByPrimaryKey(long id)
		throws NoSuchVRVehicleEquipmentException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the vr vehicle equipment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vr vehicle equipment
	 * @return the vr vehicle equipment, or <code>null</code> if a vr vehicle equipment with the primary key could not be found
	 */
	@Override
	public VRVehicleEquipment fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(VRVehicleEquipmentModelImpl.ENTITY_CACHE_ENABLED,
				VRVehicleEquipmentImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		VRVehicleEquipment vrVehicleEquipment = (VRVehicleEquipment)serializable;

		if (vrVehicleEquipment == null) {
			Session session = null;

			try {
				session = openSession();

				vrVehicleEquipment = (VRVehicleEquipment)session.get(VRVehicleEquipmentImpl.class,
						primaryKey);

				if (vrVehicleEquipment != null) {
					cacheResult(vrVehicleEquipment);
				}
				else {
					entityCache.putResult(VRVehicleEquipmentModelImpl.ENTITY_CACHE_ENABLED,
						VRVehicleEquipmentImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(VRVehicleEquipmentModelImpl.ENTITY_CACHE_ENABLED,
					VRVehicleEquipmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vrVehicleEquipment;
	}

	/**
	 * Returns the vr vehicle equipment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vr vehicle equipment
	 * @return the vr vehicle equipment, or <code>null</code> if a vr vehicle equipment with the primary key could not be found
	 */
	@Override
	public VRVehicleEquipment fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, VRVehicleEquipment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, VRVehicleEquipment> map = new HashMap<Serializable, VRVehicleEquipment>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			VRVehicleEquipment vrVehicleEquipment = fetchByPrimaryKey(primaryKey);

			if (vrVehicleEquipment != null) {
				map.put(primaryKey, vrVehicleEquipment);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(VRVehicleEquipmentModelImpl.ENTITY_CACHE_ENABLED,
					VRVehicleEquipmentImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (VRVehicleEquipment)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VRVEHICLEEQUIPMENT_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (VRVehicleEquipment vrVehicleEquipment : (List<VRVehicleEquipment>)q.list()) {
				map.put(vrVehicleEquipment.getPrimaryKeyObj(),
					vrVehicleEquipment);

				cacheResult(vrVehicleEquipment);

				uncachedPrimaryKeys.remove(vrVehicleEquipment.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(VRVehicleEquipmentModelImpl.ENTITY_CACHE_ENABLED,
					VRVehicleEquipmentImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the vr vehicle equipments.
	 *
	 * @return the vr vehicle equipments
	 */
	@Override
	public List<VRVehicleEquipment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr vehicle equipments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRVehicleEquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr vehicle equipments
	 * @param end the upper bound of the range of vr vehicle equipments (not inclusive)
	 * @return the range of vr vehicle equipments
	 */
	@Override
	public List<VRVehicleEquipment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr vehicle equipments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRVehicleEquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr vehicle equipments
	 * @param end the upper bound of the range of vr vehicle equipments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vr vehicle equipments
	 */
	@Override
	public List<VRVehicleEquipment> findAll(int start, int end,
		OrderByComparator<VRVehicleEquipment> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr vehicle equipments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRVehicleEquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr vehicle equipments
	 * @param end the upper bound of the range of vr vehicle equipments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of vr vehicle equipments
	 */
	@Override
	public List<VRVehicleEquipment> findAll(int start, int end,
		OrderByComparator<VRVehicleEquipment> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<VRVehicleEquipment> list = null;

		if (retrieveFromCache) {
			list = (List<VRVehicleEquipment>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VRVEHICLEEQUIPMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VRVEHICLEEQUIPMENT;

				if (pagination) {
					sql = sql.concat(VRVehicleEquipmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VRVehicleEquipment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRVehicleEquipment>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the vr vehicle equipments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VRVehicleEquipment vrVehicleEquipment : findAll()) {
			remove(vrVehicleEquipment);
		}
	}

	/**
	 * Returns the number of vr vehicle equipments.
	 *
	 * @return the number of vr vehicle equipments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VRVEHICLEEQUIPMENT);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VRVehicleEquipmentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vr vehicle equipment persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(VRVehicleEquipmentImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_VRVEHICLEEQUIPMENT = "SELECT vrVehicleEquipment FROM VRVehicleEquipment vrVehicleEquipment";
	private static final String _SQL_SELECT_VRVEHICLEEQUIPMENT_WHERE_PKS_IN = "SELECT vrVehicleEquipment FROM VRVehicleEquipment vrVehicleEquipment WHERE id IN (";
	private static final String _SQL_COUNT_VRVEHICLEEQUIPMENT = "SELECT COUNT(vrVehicleEquipment) FROM VRVehicleEquipment vrVehicleEquipment";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vrVehicleEquipment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VRVehicleEquipment exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(VRVehicleEquipmentPersistenceImpl.class);
}