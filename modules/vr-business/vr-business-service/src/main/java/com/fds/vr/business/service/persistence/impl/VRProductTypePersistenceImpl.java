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

import com.fds.vr.business.exception.NoSuchVRProductTypeException;
import com.fds.vr.business.model.VRProductType;
import com.fds.vr.business.model.impl.VRProductTypeImpl;
import com.fds.vr.business.model.impl.VRProductTypeModelImpl;
import com.fds.vr.business.service.persistence.VRProductTypePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
 * The persistence implementation for the vr product type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LamTV
 * @see VRProductTypePersistence
 * @see com.fds.vr.business.service.persistence.VRProductTypeUtil
 * @generated
 */
@ProviderType
public class VRProductTypePersistenceImpl extends BasePersistenceImpl<VRProductType>
	implements VRProductTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VRProductTypeUtil} to access the vr product type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VRProductTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
			VRProductTypeModelImpl.FINDER_CACHE_ENABLED,
			VRProductTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
			VRProductTypeModelImpl.FINDER_CACHE_ENABLED,
			VRProductTypeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
			VRProductTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTPLANTID =
		new FinderPath(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
			VRProductTypeModelImpl.FINDER_CACHE_ENABLED,
			VRProductTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByproductPlantID",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTPLANTID =
		new FinderPath(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
			VRProductTypeModelImpl.FINDER_CACHE_ENABLED,
			VRProductTypeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByproductPlantID",
			new String[] { Long.class.getName(), Long.class.getName() },
			VRProductTypeModelImpl.MTCORE_COLUMN_BITMASK |
			VRProductTypeModelImpl.PRODUCTPLANTID_COLUMN_BITMASK |
			VRProductTypeModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTPLANTID = new FinderPath(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
			VRProductTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByproductPlantID",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the vr product types where mtCore = &#63; and productPlantID = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param productPlantID the product plant ID
	 * @return the matching vr product types
	 */
	@Override
	public List<VRProductType> findByproductPlantID(long mtCore,
		long productPlantID) {
		return findByproductPlantID(mtCore, productPlantID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr product types where mtCore = &#63; and productPlantID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRProductTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param productPlantID the product plant ID
	 * @param start the lower bound of the range of vr product types
	 * @param end the upper bound of the range of vr product types (not inclusive)
	 * @return the range of matching vr product types
	 */
	@Override
	public List<VRProductType> findByproductPlantID(long mtCore,
		long productPlantID, int start, int end) {
		return findByproductPlantID(mtCore, productPlantID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr product types where mtCore = &#63; and productPlantID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRProductTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param productPlantID the product plant ID
	 * @param start the lower bound of the range of vr product types
	 * @param end the upper bound of the range of vr product types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr product types
	 */
	@Override
	public List<VRProductType> findByproductPlantID(long mtCore,
		long productPlantID, int start, int end,
		OrderByComparator<VRProductType> orderByComparator) {
		return findByproductPlantID(mtCore, productPlantID, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr product types where mtCore = &#63; and productPlantID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRProductTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param productPlantID the product plant ID
	 * @param start the lower bound of the range of vr product types
	 * @param end the upper bound of the range of vr product types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr product types
	 */
	@Override
	public List<VRProductType> findByproductPlantID(long mtCore,
		long productPlantID, int start, int end,
		OrderByComparator<VRProductType> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTPLANTID;
			finderArgs = new Object[] { mtCore, productPlantID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTPLANTID;
			finderArgs = new Object[] {
					mtCore, productPlantID,
					
					start, end, orderByComparator
				};
		}

		List<VRProductType> list = null;

		if (retrieveFromCache) {
			list = (List<VRProductType>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRProductType vrProductType : list) {
					if ((mtCore != vrProductType.getMtCore()) ||
							(productPlantID != vrProductType.getProductPlantID())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VRPRODUCTTYPE_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTPLANTID_MTCORE_2);

			query.append(_FINDER_COLUMN_PRODUCTPLANTID_PRODUCTPLANTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRProductTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				qPos.add(productPlantID);

				if (!pagination) {
					list = (List<VRProductType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRProductType>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first vr product type in the ordered set where mtCore = &#63; and productPlantID = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param productPlantID the product plant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr product type
	 * @throws NoSuchVRProductTypeException if a matching vr product type could not be found
	 */
	@Override
	public VRProductType findByproductPlantID_First(long mtCore,
		long productPlantID, OrderByComparator<VRProductType> orderByComparator)
		throws NoSuchVRProductTypeException {
		VRProductType vrProductType = fetchByproductPlantID_First(mtCore,
				productPlantID, orderByComparator);

		if (vrProductType != null) {
			return vrProductType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", productPlantID=");
		msg.append(productPlantID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRProductTypeException(msg.toString());
	}

	/**
	 * Returns the first vr product type in the ordered set where mtCore = &#63; and productPlantID = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param productPlantID the product plant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr product type, or <code>null</code> if a matching vr product type could not be found
	 */
	@Override
	public VRProductType fetchByproductPlantID_First(long mtCore,
		long productPlantID, OrderByComparator<VRProductType> orderByComparator) {
		List<VRProductType> list = findByproductPlantID(mtCore, productPlantID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr product type in the ordered set where mtCore = &#63; and productPlantID = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param productPlantID the product plant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr product type
	 * @throws NoSuchVRProductTypeException if a matching vr product type could not be found
	 */
	@Override
	public VRProductType findByproductPlantID_Last(long mtCore,
		long productPlantID, OrderByComparator<VRProductType> orderByComparator)
		throws NoSuchVRProductTypeException {
		VRProductType vrProductType = fetchByproductPlantID_Last(mtCore,
				productPlantID, orderByComparator);

		if (vrProductType != null) {
			return vrProductType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", productPlantID=");
		msg.append(productPlantID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRProductTypeException(msg.toString());
	}

	/**
	 * Returns the last vr product type in the ordered set where mtCore = &#63; and productPlantID = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param productPlantID the product plant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr product type, or <code>null</code> if a matching vr product type could not be found
	 */
	@Override
	public VRProductType fetchByproductPlantID_Last(long mtCore,
		long productPlantID, OrderByComparator<VRProductType> orderByComparator) {
		int count = countByproductPlantID(mtCore, productPlantID);

		if (count == 0) {
			return null;
		}

		List<VRProductType> list = findByproductPlantID(mtCore, productPlantID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr product types before and after the current vr product type in the ordered set where mtCore = &#63; and productPlantID = &#63;.
	 *
	 * @param id the primary key of the current vr product type
	 * @param mtCore the mt core
	 * @param productPlantID the product plant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr product type
	 * @throws NoSuchVRProductTypeException if a vr product type with the primary key could not be found
	 */
	@Override
	public VRProductType[] findByproductPlantID_PrevAndNext(long id,
		long mtCore, long productPlantID,
		OrderByComparator<VRProductType> orderByComparator)
		throws NoSuchVRProductTypeException {
		VRProductType vrProductType = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRProductType[] array = new VRProductTypeImpl[3];

			array[0] = getByproductPlantID_PrevAndNext(session, vrProductType,
					mtCore, productPlantID, orderByComparator, true);

			array[1] = vrProductType;

			array[2] = getByproductPlantID_PrevAndNext(session, vrProductType,
					mtCore, productPlantID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VRProductType getByproductPlantID_PrevAndNext(Session session,
		VRProductType vrProductType, long mtCore, long productPlantID,
		OrderByComparator<VRProductType> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VRPRODUCTTYPE_WHERE);

		query.append(_FINDER_COLUMN_PRODUCTPLANTID_MTCORE_2);

		query.append(_FINDER_COLUMN_PRODUCTPLANTID_PRODUCTPLANTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VRProductTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mtCore);

		qPos.add(productPlantID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrProductType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRProductType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr product types where mtCore = &#63; and productPlantID = &#63; from the database.
	 *
	 * @param mtCore the mt core
	 * @param productPlantID the product plant ID
	 */
	@Override
	public void removeByproductPlantID(long mtCore, long productPlantID) {
		for (VRProductType vrProductType : findByproductPlantID(mtCore,
				productPlantID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vrProductType);
		}
	}

	/**
	 * Returns the number of vr product types where mtCore = &#63; and productPlantID = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param productPlantID the product plant ID
	 * @return the number of matching vr product types
	 */
	@Override
	public int countByproductPlantID(long mtCore, long productPlantID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCTPLANTID;

		Object[] finderArgs = new Object[] { mtCore, productPlantID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VRPRODUCTTYPE_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTPLANTID_MTCORE_2);

			query.append(_FINDER_COLUMN_PRODUCTPLANTID_PRODUCTPLANTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				qPos.add(productPlantID);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PRODUCTPLANTID_MTCORE_2 = "vrProductType.mtCore = ? AND ";
	private static final String _FINDER_COLUMN_PRODUCTPLANTID_PRODUCTPLANTID_2 = "vrProductType.productPlantID = ?";

	public VRProductTypePersistenceImpl() {
		setModelClass(VRProductType.class);
	}

	/**
	 * Caches the vr product type in the entity cache if it is enabled.
	 *
	 * @param vrProductType the vr product type
	 */
	@Override
	public void cacheResult(VRProductType vrProductType) {
		entityCache.putResult(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
			VRProductTypeImpl.class, vrProductType.getPrimaryKey(),
			vrProductType);

		vrProductType.resetOriginalValues();
	}

	/**
	 * Caches the vr product types in the entity cache if it is enabled.
	 *
	 * @param vrProductTypes the vr product types
	 */
	@Override
	public void cacheResult(List<VRProductType> vrProductTypes) {
		for (VRProductType vrProductType : vrProductTypes) {
			if (entityCache.getResult(
						VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
						VRProductTypeImpl.class, vrProductType.getPrimaryKey()) == null) {
				cacheResult(vrProductType);
			}
			else {
				vrProductType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vr product types.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VRProductTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vr product type.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VRProductType vrProductType) {
		entityCache.removeResult(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
			VRProductTypeImpl.class, vrProductType.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VRProductType> vrProductTypes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VRProductType vrProductType : vrProductTypes) {
			entityCache.removeResult(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
				VRProductTypeImpl.class, vrProductType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vr product type with the primary key. Does not add the vr product type to the database.
	 *
	 * @param id the primary key for the new vr product type
	 * @return the new vr product type
	 */
	@Override
	public VRProductType create(long id) {
		VRProductType vrProductType = new VRProductTypeImpl();

		vrProductType.setNew(true);
		vrProductType.setPrimaryKey(id);

		return vrProductType;
	}

	/**
	 * Removes the vr product type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vr product type
	 * @return the vr product type that was removed
	 * @throws NoSuchVRProductTypeException if a vr product type with the primary key could not be found
	 */
	@Override
	public VRProductType remove(long id) throws NoSuchVRProductTypeException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the vr product type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vr product type
	 * @return the vr product type that was removed
	 * @throws NoSuchVRProductTypeException if a vr product type with the primary key could not be found
	 */
	@Override
	public VRProductType remove(Serializable primaryKey)
		throws NoSuchVRProductTypeException {
		Session session = null;

		try {
			session = openSession();

			VRProductType vrProductType = (VRProductType)session.get(VRProductTypeImpl.class,
					primaryKey);

			if (vrProductType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVRProductTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vrProductType);
		}
		catch (NoSuchVRProductTypeException nsee) {
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
	protected VRProductType removeImpl(VRProductType vrProductType) {
		vrProductType = toUnwrappedModel(vrProductType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vrProductType)) {
				vrProductType = (VRProductType)session.get(VRProductTypeImpl.class,
						vrProductType.getPrimaryKeyObj());
			}

			if (vrProductType != null) {
				session.delete(vrProductType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vrProductType != null) {
			clearCache(vrProductType);
		}

		return vrProductType;
	}

	@Override
	public VRProductType updateImpl(VRProductType vrProductType) {
		vrProductType = toUnwrappedModel(vrProductType);

		boolean isNew = vrProductType.isNew();

		VRProductTypeModelImpl vrProductTypeModelImpl = (VRProductTypeModelImpl)vrProductType;

		Session session = null;

		try {
			session = openSession();

			if (vrProductType.isNew()) {
				session.save(vrProductType);

				vrProductType.setNew(false);
			}
			else {
				vrProductType = (VRProductType)session.merge(vrProductType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VRProductTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vrProductTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTPLANTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrProductTypeModelImpl.getOriginalMtCore(),
						vrProductTypeModelImpl.getOriginalProductPlantID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PRODUCTPLANTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTPLANTID,
					args);

				args = new Object[] {
						vrProductTypeModelImpl.getMtCore(),
						vrProductTypeModelImpl.getProductPlantID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PRODUCTPLANTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTPLANTID,
					args);
			}
		}

		entityCache.putResult(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
			VRProductTypeImpl.class, vrProductType.getPrimaryKey(),
			vrProductType, false);

		vrProductType.resetOriginalValues();

		return vrProductType;
	}

	protected VRProductType toUnwrappedModel(VRProductType vrProductType) {
		if (vrProductType instanceof VRProductTypeImpl) {
			return vrProductType;
		}

		VRProductTypeImpl vrProductTypeImpl = new VRProductTypeImpl();

		vrProductTypeImpl.setNew(vrProductType.isNew());
		vrProductTypeImpl.setPrimaryKey(vrProductType.getPrimaryKey());

		vrProductTypeImpl.setId(vrProductType.getId());
		vrProductTypeImpl.setMtCore(vrProductType.getMtCore());
		vrProductTypeImpl.setProductPlantID(vrProductType.getProductPlantID());
		vrProductTypeImpl.setSequenceNo(vrProductType.getSequenceNo());
		vrProductTypeImpl.setVehicleClass(vrProductType.getVehicleClass());
		vrProductTypeImpl.setVehicleTypeCode(vrProductType.getVehicleTypeCode());
		vrProductTypeImpl.setVehicleTypeDescription(vrProductType.getVehicleTypeDescription());
		vrProductTypeImpl.setModifyDate(vrProductType.getModifyDate());
		vrProductTypeImpl.setSyncDate(vrProductType.getSyncDate());

		return vrProductTypeImpl;
	}

	/**
	 * Returns the vr product type with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vr product type
	 * @return the vr product type
	 * @throws NoSuchVRProductTypeException if a vr product type with the primary key could not be found
	 */
	@Override
	public VRProductType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVRProductTypeException {
		VRProductType vrProductType = fetchByPrimaryKey(primaryKey);

		if (vrProductType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVRProductTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vrProductType;
	}

	/**
	 * Returns the vr product type with the primary key or throws a {@link NoSuchVRProductTypeException} if it could not be found.
	 *
	 * @param id the primary key of the vr product type
	 * @return the vr product type
	 * @throws NoSuchVRProductTypeException if a vr product type with the primary key could not be found
	 */
	@Override
	public VRProductType findByPrimaryKey(long id)
		throws NoSuchVRProductTypeException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the vr product type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vr product type
	 * @return the vr product type, or <code>null</code> if a vr product type with the primary key could not be found
	 */
	@Override
	public VRProductType fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
				VRProductTypeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		VRProductType vrProductType = (VRProductType)serializable;

		if (vrProductType == null) {
			Session session = null;

			try {
				session = openSession();

				vrProductType = (VRProductType)session.get(VRProductTypeImpl.class,
						primaryKey);

				if (vrProductType != null) {
					cacheResult(vrProductType);
				}
				else {
					entityCache.putResult(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
						VRProductTypeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
					VRProductTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vrProductType;
	}

	/**
	 * Returns the vr product type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vr product type
	 * @return the vr product type, or <code>null</code> if a vr product type with the primary key could not be found
	 */
	@Override
	public VRProductType fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, VRProductType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, VRProductType> map = new HashMap<Serializable, VRProductType>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			VRProductType vrProductType = fetchByPrimaryKey(primaryKey);

			if (vrProductType != null) {
				map.put(primaryKey, vrProductType);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
					VRProductTypeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (VRProductType)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VRPRODUCTTYPE_WHERE_PKS_IN);

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

			for (VRProductType vrProductType : (List<VRProductType>)q.list()) {
				map.put(vrProductType.getPrimaryKeyObj(), vrProductType);

				cacheResult(vrProductType);

				uncachedPrimaryKeys.remove(vrProductType.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(VRProductTypeModelImpl.ENTITY_CACHE_ENABLED,
					VRProductTypeImpl.class, primaryKey, nullModel);
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
	 * Returns all the vr product types.
	 *
	 * @return the vr product types
	 */
	@Override
	public List<VRProductType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr product types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRProductTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr product types
	 * @param end the upper bound of the range of vr product types (not inclusive)
	 * @return the range of vr product types
	 */
	@Override
	public List<VRProductType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr product types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRProductTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr product types
	 * @param end the upper bound of the range of vr product types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vr product types
	 */
	@Override
	public List<VRProductType> findAll(int start, int end,
		OrderByComparator<VRProductType> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr product types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRProductTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr product types
	 * @param end the upper bound of the range of vr product types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of vr product types
	 */
	@Override
	public List<VRProductType> findAll(int start, int end,
		OrderByComparator<VRProductType> orderByComparator,
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

		List<VRProductType> list = null;

		if (retrieveFromCache) {
			list = (List<VRProductType>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VRPRODUCTTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VRPRODUCTTYPE;

				if (pagination) {
					sql = sql.concat(VRProductTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VRProductType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRProductType>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the vr product types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VRProductType vrProductType : findAll()) {
			remove(vrProductType);
		}
	}

	/**
	 * Returns the number of vr product types.
	 *
	 * @return the number of vr product types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VRPRODUCTTYPE);

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
		return VRProductTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vr product type persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(VRProductTypeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_VRPRODUCTTYPE = "SELECT vrProductType FROM VRProductType vrProductType";
	private static final String _SQL_SELECT_VRPRODUCTTYPE_WHERE_PKS_IN = "SELECT vrProductType FROM VRProductType vrProductType WHERE id IN (";
	private static final String _SQL_SELECT_VRPRODUCTTYPE_WHERE = "SELECT vrProductType FROM VRProductType vrProductType WHERE ";
	private static final String _SQL_COUNT_VRPRODUCTTYPE = "SELECT COUNT(vrProductType) FROM VRProductType vrProductType";
	private static final String _SQL_COUNT_VRPRODUCTTYPE_WHERE = "SELECT COUNT(vrProductType) FROM VRProductType vrProductType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vrProductType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VRProductType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VRProductType exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(VRProductTypePersistenceImpl.class);
}