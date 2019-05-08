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

import com.fds.vr.business.exception.NoSuchVRInspectionStandardException;
import com.fds.vr.business.model.VRInspectionStandard;
import com.fds.vr.business.model.impl.VRInspectionStandardImpl;
import com.fds.vr.business.model.impl.VRInspectionStandardModelImpl;
import com.fds.vr.business.service.persistence.VRInspectionStandardPersistence;

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
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the vr inspection standard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LamTV
 * @see VRInspectionStandardPersistence
 * @see com.fds.vr.business.service.persistence.VRInspectionStandardUtil
 * @generated
 */
@ProviderType
public class VRInspectionStandardPersistenceImpl extends BasePersistenceImpl<VRInspectionStandard>
	implements VRInspectionStandardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VRInspectionStandardUtil} to access the vr inspection standard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VRInspectionStandardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
			VRInspectionStandardModelImpl.FINDER_CACHE_ENABLED,
			VRInspectionStandardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
			VRInspectionStandardModelImpl.FINDER_CACHE_ENABLED,
			VRInspectionStandardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
			VRInspectionStandardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DELIVERABLECODE =
		new FinderPath(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
			VRInspectionStandardModelImpl.FINDER_CACHE_ENABLED,
			VRInspectionStandardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDeliverableCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELIVERABLECODE =
		new FinderPath(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
			VRInspectionStandardModelImpl.FINDER_CACHE_ENABLED,
			VRInspectionStandardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDeliverableCode",
			new String[] { String.class.getName() },
			VRInspectionStandardModelImpl.DELIVERABLECODE_COLUMN_BITMASK |
			VRInspectionStandardModelImpl.VEHICLECERTIFICATEID_COLUMN_BITMASK |
			VRInspectionStandardModelImpl.SEQUENCENO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DELIVERABLECODE = new FinderPath(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
			VRInspectionStandardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDeliverableCode", new String[] { String.class.getName() });

	/**
	 * Returns all the vr inspection standards where deliverableCode = &#63;.
	 *
	 * @param deliverableCode the deliverable code
	 * @return the matching vr inspection standards
	 */
	@Override
	public List<VRInspectionStandard> findByDeliverableCode(
		String deliverableCode) {
		return findByDeliverableCode(deliverableCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr inspection standards where deliverableCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRInspectionStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deliverableCode the deliverable code
	 * @param start the lower bound of the range of vr inspection standards
	 * @param end the upper bound of the range of vr inspection standards (not inclusive)
	 * @return the range of matching vr inspection standards
	 */
	@Override
	public List<VRInspectionStandard> findByDeliverableCode(
		String deliverableCode, int start, int end) {
		return findByDeliverableCode(deliverableCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr inspection standards where deliverableCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRInspectionStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deliverableCode the deliverable code
	 * @param start the lower bound of the range of vr inspection standards
	 * @param end the upper bound of the range of vr inspection standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr inspection standards
	 */
	@Override
	public List<VRInspectionStandard> findByDeliverableCode(
		String deliverableCode, int start, int end,
		OrderByComparator<VRInspectionStandard> orderByComparator) {
		return findByDeliverableCode(deliverableCode, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr inspection standards where deliverableCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRInspectionStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deliverableCode the deliverable code
	 * @param start the lower bound of the range of vr inspection standards
	 * @param end the upper bound of the range of vr inspection standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr inspection standards
	 */
	@Override
	public List<VRInspectionStandard> findByDeliverableCode(
		String deliverableCode, int start, int end,
		OrderByComparator<VRInspectionStandard> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELIVERABLECODE;
			finderArgs = new Object[] { deliverableCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DELIVERABLECODE;
			finderArgs = new Object[] {
					deliverableCode,
					
					start, end, orderByComparator
				};
		}

		List<VRInspectionStandard> list = null;

		if (retrieveFromCache) {
			list = (List<VRInspectionStandard>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRInspectionStandard vrInspectionStandard : list) {
					if (!Objects.equals(deliverableCode,
								vrInspectionStandard.getDeliverableCode())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VRINSPECTIONSTANDARD_WHERE);

			boolean bindDeliverableCode = false;

			if (deliverableCode == null) {
				query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_1);
			}
			else if (deliverableCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_3);
			}
			else {
				bindDeliverableCode = true;

				query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRInspectionStandardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeliverableCode) {
					qPos.add(deliverableCode);
				}

				if (!pagination) {
					list = (List<VRInspectionStandard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRInspectionStandard>)QueryUtil.list(q,
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
	 * Returns the first vr inspection standard in the ordered set where deliverableCode = &#63;.
	 *
	 * @param deliverableCode the deliverable code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr inspection standard
	 * @throws NoSuchVRInspectionStandardException if a matching vr inspection standard could not be found
	 */
	@Override
	public VRInspectionStandard findByDeliverableCode_First(
		String deliverableCode,
		OrderByComparator<VRInspectionStandard> orderByComparator)
		throws NoSuchVRInspectionStandardException {
		VRInspectionStandard vrInspectionStandard = fetchByDeliverableCode_First(deliverableCode,
				orderByComparator);

		if (vrInspectionStandard != null) {
			return vrInspectionStandard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deliverableCode=");
		msg.append(deliverableCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRInspectionStandardException(msg.toString());
	}

	/**
	 * Returns the first vr inspection standard in the ordered set where deliverableCode = &#63;.
	 *
	 * @param deliverableCode the deliverable code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr inspection standard, or <code>null</code> if a matching vr inspection standard could not be found
	 */
	@Override
	public VRInspectionStandard fetchByDeliverableCode_First(
		String deliverableCode,
		OrderByComparator<VRInspectionStandard> orderByComparator) {
		List<VRInspectionStandard> list = findByDeliverableCode(deliverableCode,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr inspection standard in the ordered set where deliverableCode = &#63;.
	 *
	 * @param deliverableCode the deliverable code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr inspection standard
	 * @throws NoSuchVRInspectionStandardException if a matching vr inspection standard could not be found
	 */
	@Override
	public VRInspectionStandard findByDeliverableCode_Last(
		String deliverableCode,
		OrderByComparator<VRInspectionStandard> orderByComparator)
		throws NoSuchVRInspectionStandardException {
		VRInspectionStandard vrInspectionStandard = fetchByDeliverableCode_Last(deliverableCode,
				orderByComparator);

		if (vrInspectionStandard != null) {
			return vrInspectionStandard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deliverableCode=");
		msg.append(deliverableCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRInspectionStandardException(msg.toString());
	}

	/**
	 * Returns the last vr inspection standard in the ordered set where deliverableCode = &#63;.
	 *
	 * @param deliverableCode the deliverable code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr inspection standard, or <code>null</code> if a matching vr inspection standard could not be found
	 */
	@Override
	public VRInspectionStandard fetchByDeliverableCode_Last(
		String deliverableCode,
		OrderByComparator<VRInspectionStandard> orderByComparator) {
		int count = countByDeliverableCode(deliverableCode);

		if (count == 0) {
			return null;
		}

		List<VRInspectionStandard> list = findByDeliverableCode(deliverableCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr inspection standards before and after the current vr inspection standard in the ordered set where deliverableCode = &#63;.
	 *
	 * @param id the primary key of the current vr inspection standard
	 * @param deliverableCode the deliverable code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr inspection standard
	 * @throws NoSuchVRInspectionStandardException if a vr inspection standard with the primary key could not be found
	 */
	@Override
	public VRInspectionStandard[] findByDeliverableCode_PrevAndNext(long id,
		String deliverableCode,
		OrderByComparator<VRInspectionStandard> orderByComparator)
		throws NoSuchVRInspectionStandardException {
		VRInspectionStandard vrInspectionStandard = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRInspectionStandard[] array = new VRInspectionStandardImpl[3];

			array[0] = getByDeliverableCode_PrevAndNext(session,
					vrInspectionStandard, deliverableCode, orderByComparator,
					true);

			array[1] = vrInspectionStandard;

			array[2] = getByDeliverableCode_PrevAndNext(session,
					vrInspectionStandard, deliverableCode, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VRInspectionStandard getByDeliverableCode_PrevAndNext(
		Session session, VRInspectionStandard vrInspectionStandard,
		String deliverableCode,
		OrderByComparator<VRInspectionStandard> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VRINSPECTIONSTANDARD_WHERE);

		boolean bindDeliverableCode = false;

		if (deliverableCode == null) {
			query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_1);
		}
		else if (deliverableCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_3);
		}
		else {
			bindDeliverableCode = true;

			query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_2);
		}

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
			query.append(VRInspectionStandardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDeliverableCode) {
			qPos.add(deliverableCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrInspectionStandard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRInspectionStandard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr inspection standards where deliverableCode = &#63; from the database.
	 *
	 * @param deliverableCode the deliverable code
	 */
	@Override
	public void removeByDeliverableCode(String deliverableCode) {
		for (VRInspectionStandard vrInspectionStandard : findByDeliverableCode(
				deliverableCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vrInspectionStandard);
		}
	}

	/**
	 * Returns the number of vr inspection standards where deliverableCode = &#63;.
	 *
	 * @param deliverableCode the deliverable code
	 * @return the number of matching vr inspection standards
	 */
	@Override
	public int countByDeliverableCode(String deliverableCode) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DELIVERABLECODE;

		Object[] finderArgs = new Object[] { deliverableCode };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VRINSPECTIONSTANDARD_WHERE);

			boolean bindDeliverableCode = false;

			if (deliverableCode == null) {
				query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_1);
			}
			else if (deliverableCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_3);
			}
			else {
				bindDeliverableCode = true;

				query.append(_FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeliverableCode) {
					qPos.add(deliverableCode);
				}

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

	private static final String _FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_1 =
		"vrInspectionStandard.deliverableCode IS NULL";
	private static final String _FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_2 =
		"vrInspectionStandard.deliverableCode = ?";
	private static final String _FINDER_COLUMN_DELIVERABLECODE_DELIVERABLECODE_3 =
		"(vrInspectionStandard.deliverableCode IS NULL OR vrInspectionStandard.deliverableCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VEHICLECERTIFICATEID =
		new FinderPath(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
			VRInspectionStandardModelImpl.FINDER_CACHE_ENABLED,
			VRInspectionStandardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByvehicleCertificateId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLECERTIFICATEID =
		new FinderPath(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
			VRInspectionStandardModelImpl.FINDER_CACHE_ENABLED,
			VRInspectionStandardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByvehicleCertificateId",
			new String[] { Long.class.getName(), Long.class.getName() },
			VRInspectionStandardModelImpl.VEHICLECERTIFICATEID_COLUMN_BITMASK |
			VRInspectionStandardModelImpl.MARKUPSTATUS_COLUMN_BITMASK |
			VRInspectionStandardModelImpl.SEQUENCENO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VEHICLECERTIFICATEID = new FinderPath(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
			VRInspectionStandardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByvehicleCertificateId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the vr inspection standards where vehicleCertificateId = &#63; and markupstatus = &#63;.
	 *
	 * @param vehicleCertificateId the vehicle certificate ID
	 * @param markupstatus the markupstatus
	 * @return the matching vr inspection standards
	 */
	@Override
	public List<VRInspectionStandard> findByvehicleCertificateId(
		long vehicleCertificateId, long markupstatus) {
		return findByvehicleCertificateId(vehicleCertificateId, markupstatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr inspection standards where vehicleCertificateId = &#63; and markupstatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRInspectionStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehicleCertificateId the vehicle certificate ID
	 * @param markupstatus the markupstatus
	 * @param start the lower bound of the range of vr inspection standards
	 * @param end the upper bound of the range of vr inspection standards (not inclusive)
	 * @return the range of matching vr inspection standards
	 */
	@Override
	public List<VRInspectionStandard> findByvehicleCertificateId(
		long vehicleCertificateId, long markupstatus, int start, int end) {
		return findByvehicleCertificateId(vehicleCertificateId, markupstatus,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr inspection standards where vehicleCertificateId = &#63; and markupstatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRInspectionStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehicleCertificateId the vehicle certificate ID
	 * @param markupstatus the markupstatus
	 * @param start the lower bound of the range of vr inspection standards
	 * @param end the upper bound of the range of vr inspection standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr inspection standards
	 */
	@Override
	public List<VRInspectionStandard> findByvehicleCertificateId(
		long vehicleCertificateId, long markupstatus, int start, int end,
		OrderByComparator<VRInspectionStandard> orderByComparator) {
		return findByvehicleCertificateId(vehicleCertificateId, markupstatus,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr inspection standards where vehicleCertificateId = &#63; and markupstatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRInspectionStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehicleCertificateId the vehicle certificate ID
	 * @param markupstatus the markupstatus
	 * @param start the lower bound of the range of vr inspection standards
	 * @param end the upper bound of the range of vr inspection standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr inspection standards
	 */
	@Override
	public List<VRInspectionStandard> findByvehicleCertificateId(
		long vehicleCertificateId, long markupstatus, int start, int end,
		OrderByComparator<VRInspectionStandard> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLECERTIFICATEID;
			finderArgs = new Object[] { vehicleCertificateId, markupstatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VEHICLECERTIFICATEID;
			finderArgs = new Object[] {
					vehicleCertificateId, markupstatus,
					
					start, end, orderByComparator
				};
		}

		List<VRInspectionStandard> list = null;

		if (retrieveFromCache) {
			list = (List<VRInspectionStandard>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRInspectionStandard vrInspectionStandard : list) {
					if ((vehicleCertificateId != vrInspectionStandard.getVehicleCertificateId()) ||
							(markupstatus != vrInspectionStandard.getMarkupstatus())) {
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

			query.append(_SQL_SELECT_VRINSPECTIONSTANDARD_WHERE);

			query.append(_FINDER_COLUMN_VEHICLECERTIFICATEID_VEHICLECERTIFICATEID_2);

			query.append(_FINDER_COLUMN_VEHICLECERTIFICATEID_MARKUPSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRInspectionStandardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vehicleCertificateId);

				qPos.add(markupstatus);

				if (!pagination) {
					list = (List<VRInspectionStandard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRInspectionStandard>)QueryUtil.list(q,
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
	 * Returns the first vr inspection standard in the ordered set where vehicleCertificateId = &#63; and markupstatus = &#63;.
	 *
	 * @param vehicleCertificateId the vehicle certificate ID
	 * @param markupstatus the markupstatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr inspection standard
	 * @throws NoSuchVRInspectionStandardException if a matching vr inspection standard could not be found
	 */
	@Override
	public VRInspectionStandard findByvehicleCertificateId_First(
		long vehicleCertificateId, long markupstatus,
		OrderByComparator<VRInspectionStandard> orderByComparator)
		throws NoSuchVRInspectionStandardException {
		VRInspectionStandard vrInspectionStandard = fetchByvehicleCertificateId_First(vehicleCertificateId,
				markupstatus, orderByComparator);

		if (vrInspectionStandard != null) {
			return vrInspectionStandard;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vehicleCertificateId=");
		msg.append(vehicleCertificateId);

		msg.append(", markupstatus=");
		msg.append(markupstatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRInspectionStandardException(msg.toString());
	}

	/**
	 * Returns the first vr inspection standard in the ordered set where vehicleCertificateId = &#63; and markupstatus = &#63;.
	 *
	 * @param vehicleCertificateId the vehicle certificate ID
	 * @param markupstatus the markupstatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr inspection standard, or <code>null</code> if a matching vr inspection standard could not be found
	 */
	@Override
	public VRInspectionStandard fetchByvehicleCertificateId_First(
		long vehicleCertificateId, long markupstatus,
		OrderByComparator<VRInspectionStandard> orderByComparator) {
		List<VRInspectionStandard> list = findByvehicleCertificateId(vehicleCertificateId,
				markupstatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr inspection standard in the ordered set where vehicleCertificateId = &#63; and markupstatus = &#63;.
	 *
	 * @param vehicleCertificateId the vehicle certificate ID
	 * @param markupstatus the markupstatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr inspection standard
	 * @throws NoSuchVRInspectionStandardException if a matching vr inspection standard could not be found
	 */
	@Override
	public VRInspectionStandard findByvehicleCertificateId_Last(
		long vehicleCertificateId, long markupstatus,
		OrderByComparator<VRInspectionStandard> orderByComparator)
		throws NoSuchVRInspectionStandardException {
		VRInspectionStandard vrInspectionStandard = fetchByvehicleCertificateId_Last(vehicleCertificateId,
				markupstatus, orderByComparator);

		if (vrInspectionStandard != null) {
			return vrInspectionStandard;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vehicleCertificateId=");
		msg.append(vehicleCertificateId);

		msg.append(", markupstatus=");
		msg.append(markupstatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRInspectionStandardException(msg.toString());
	}

	/**
	 * Returns the last vr inspection standard in the ordered set where vehicleCertificateId = &#63; and markupstatus = &#63;.
	 *
	 * @param vehicleCertificateId the vehicle certificate ID
	 * @param markupstatus the markupstatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr inspection standard, or <code>null</code> if a matching vr inspection standard could not be found
	 */
	@Override
	public VRInspectionStandard fetchByvehicleCertificateId_Last(
		long vehicleCertificateId, long markupstatus,
		OrderByComparator<VRInspectionStandard> orderByComparator) {
		int count = countByvehicleCertificateId(vehicleCertificateId,
				markupstatus);

		if (count == 0) {
			return null;
		}

		List<VRInspectionStandard> list = findByvehicleCertificateId(vehicleCertificateId,
				markupstatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr inspection standards before and after the current vr inspection standard in the ordered set where vehicleCertificateId = &#63; and markupstatus = &#63;.
	 *
	 * @param id the primary key of the current vr inspection standard
	 * @param vehicleCertificateId the vehicle certificate ID
	 * @param markupstatus the markupstatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr inspection standard
	 * @throws NoSuchVRInspectionStandardException if a vr inspection standard with the primary key could not be found
	 */
	@Override
	public VRInspectionStandard[] findByvehicleCertificateId_PrevAndNext(
		long id, long vehicleCertificateId, long markupstatus,
		OrderByComparator<VRInspectionStandard> orderByComparator)
		throws NoSuchVRInspectionStandardException {
		VRInspectionStandard vrInspectionStandard = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRInspectionStandard[] array = new VRInspectionStandardImpl[3];

			array[0] = getByvehicleCertificateId_PrevAndNext(session,
					vrInspectionStandard, vehicleCertificateId, markupstatus,
					orderByComparator, true);

			array[1] = vrInspectionStandard;

			array[2] = getByvehicleCertificateId_PrevAndNext(session,
					vrInspectionStandard, vehicleCertificateId, markupstatus,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VRInspectionStandard getByvehicleCertificateId_PrevAndNext(
		Session session, VRInspectionStandard vrInspectionStandard,
		long vehicleCertificateId, long markupstatus,
		OrderByComparator<VRInspectionStandard> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VRINSPECTIONSTANDARD_WHERE);

		query.append(_FINDER_COLUMN_VEHICLECERTIFICATEID_VEHICLECERTIFICATEID_2);

		query.append(_FINDER_COLUMN_VEHICLECERTIFICATEID_MARKUPSTATUS_2);

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
			query.append(VRInspectionStandardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(vehicleCertificateId);

		qPos.add(markupstatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrInspectionStandard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRInspectionStandard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr inspection standards where vehicleCertificateId = &#63; and markupstatus = &#63; from the database.
	 *
	 * @param vehicleCertificateId the vehicle certificate ID
	 * @param markupstatus the markupstatus
	 */
	@Override
	public void removeByvehicleCertificateId(long vehicleCertificateId,
		long markupstatus) {
		for (VRInspectionStandard vrInspectionStandard : findByvehicleCertificateId(
				vehicleCertificateId, markupstatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vrInspectionStandard);
		}
	}

	/**
	 * Returns the number of vr inspection standards where vehicleCertificateId = &#63; and markupstatus = &#63;.
	 *
	 * @param vehicleCertificateId the vehicle certificate ID
	 * @param markupstatus the markupstatus
	 * @return the number of matching vr inspection standards
	 */
	@Override
	public int countByvehicleCertificateId(long vehicleCertificateId,
		long markupstatus) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VEHICLECERTIFICATEID;

		Object[] finderArgs = new Object[] { vehicleCertificateId, markupstatus };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VRINSPECTIONSTANDARD_WHERE);

			query.append(_FINDER_COLUMN_VEHICLECERTIFICATEID_VEHICLECERTIFICATEID_2);

			query.append(_FINDER_COLUMN_VEHICLECERTIFICATEID_MARKUPSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vehicleCertificateId);

				qPos.add(markupstatus);

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

	private static final String _FINDER_COLUMN_VEHICLECERTIFICATEID_VEHICLECERTIFICATEID_2 =
		"vrInspectionStandard.vehicleCertificateId = ? AND ";
	private static final String _FINDER_COLUMN_VEHICLECERTIFICATEID_MARKUPSTATUS_2 =
		"vrInspectionStandard.markupstatus = ?";

	public VRInspectionStandardPersistenceImpl() {
		setModelClass(VRInspectionStandard.class);
	}

	/**
	 * Caches the vr inspection standard in the entity cache if it is enabled.
	 *
	 * @param vrInspectionStandard the vr inspection standard
	 */
	@Override
	public void cacheResult(VRInspectionStandard vrInspectionStandard) {
		entityCache.putResult(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
			VRInspectionStandardImpl.class,
			vrInspectionStandard.getPrimaryKey(), vrInspectionStandard);

		vrInspectionStandard.resetOriginalValues();
	}

	/**
	 * Caches the vr inspection standards in the entity cache if it is enabled.
	 *
	 * @param vrInspectionStandards the vr inspection standards
	 */
	@Override
	public void cacheResult(List<VRInspectionStandard> vrInspectionStandards) {
		for (VRInspectionStandard vrInspectionStandard : vrInspectionStandards) {
			if (entityCache.getResult(
						VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
						VRInspectionStandardImpl.class,
						vrInspectionStandard.getPrimaryKey()) == null) {
				cacheResult(vrInspectionStandard);
			}
			else {
				vrInspectionStandard.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vr inspection standards.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VRInspectionStandardImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vr inspection standard.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VRInspectionStandard vrInspectionStandard) {
		entityCache.removeResult(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
			VRInspectionStandardImpl.class, vrInspectionStandard.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VRInspectionStandard> vrInspectionStandards) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VRInspectionStandard vrInspectionStandard : vrInspectionStandards) {
			entityCache.removeResult(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
				VRInspectionStandardImpl.class,
				vrInspectionStandard.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vr inspection standard with the primary key. Does not add the vr inspection standard to the database.
	 *
	 * @param id the primary key for the new vr inspection standard
	 * @return the new vr inspection standard
	 */
	@Override
	public VRInspectionStandard create(long id) {
		VRInspectionStandard vrInspectionStandard = new VRInspectionStandardImpl();

		vrInspectionStandard.setNew(true);
		vrInspectionStandard.setPrimaryKey(id);

		return vrInspectionStandard;
	}

	/**
	 * Removes the vr inspection standard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vr inspection standard
	 * @return the vr inspection standard that was removed
	 * @throws NoSuchVRInspectionStandardException if a vr inspection standard with the primary key could not be found
	 */
	@Override
	public VRInspectionStandard remove(long id)
		throws NoSuchVRInspectionStandardException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the vr inspection standard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vr inspection standard
	 * @return the vr inspection standard that was removed
	 * @throws NoSuchVRInspectionStandardException if a vr inspection standard with the primary key could not be found
	 */
	@Override
	public VRInspectionStandard remove(Serializable primaryKey)
		throws NoSuchVRInspectionStandardException {
		Session session = null;

		try {
			session = openSession();

			VRInspectionStandard vrInspectionStandard = (VRInspectionStandard)session.get(VRInspectionStandardImpl.class,
					primaryKey);

			if (vrInspectionStandard == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVRInspectionStandardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vrInspectionStandard);
		}
		catch (NoSuchVRInspectionStandardException nsee) {
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
	protected VRInspectionStandard removeImpl(
		VRInspectionStandard vrInspectionStandard) {
		vrInspectionStandard = toUnwrappedModel(vrInspectionStandard);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vrInspectionStandard)) {
				vrInspectionStandard = (VRInspectionStandard)session.get(VRInspectionStandardImpl.class,
						vrInspectionStandard.getPrimaryKeyObj());
			}

			if (vrInspectionStandard != null) {
				session.delete(vrInspectionStandard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vrInspectionStandard != null) {
			clearCache(vrInspectionStandard);
		}

		return vrInspectionStandard;
	}

	@Override
	public VRInspectionStandard updateImpl(
		VRInspectionStandard vrInspectionStandard) {
		vrInspectionStandard = toUnwrappedModel(vrInspectionStandard);

		boolean isNew = vrInspectionStandard.isNew();

		VRInspectionStandardModelImpl vrInspectionStandardModelImpl = (VRInspectionStandardModelImpl)vrInspectionStandard;

		Session session = null;

		try {
			session = openSession();

			if (vrInspectionStandard.isNew()) {
				session.save(vrInspectionStandard);

				vrInspectionStandard.setNew(false);
			}
			else {
				vrInspectionStandard = (VRInspectionStandard)session.merge(vrInspectionStandard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VRInspectionStandardModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vrInspectionStandardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELIVERABLECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrInspectionStandardModelImpl.getOriginalDeliverableCode()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DELIVERABLECODE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELIVERABLECODE,
					args);

				args = new Object[] {
						vrInspectionStandardModelImpl.getDeliverableCode()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DELIVERABLECODE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELIVERABLECODE,
					args);
			}

			if ((vrInspectionStandardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLECERTIFICATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrInspectionStandardModelImpl.getOriginalVehicleCertificateId(),
						vrInspectionStandardModelImpl.getOriginalMarkupstatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VEHICLECERTIFICATEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLECERTIFICATEID,
					args);

				args = new Object[] {
						vrInspectionStandardModelImpl.getVehicleCertificateId(),
						vrInspectionStandardModelImpl.getMarkupstatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VEHICLECERTIFICATEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLECERTIFICATEID,
					args);
			}
		}

		entityCache.putResult(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
			VRInspectionStandardImpl.class,
			vrInspectionStandard.getPrimaryKey(), vrInspectionStandard, false);

		vrInspectionStandard.resetOriginalValues();

		return vrInspectionStandard;
	}

	protected VRInspectionStandard toUnwrappedModel(
		VRInspectionStandard vrInspectionStandard) {
		if (vrInspectionStandard instanceof VRInspectionStandardImpl) {
			return vrInspectionStandard;
		}

		VRInspectionStandardImpl vrInspectionStandardImpl = new VRInspectionStandardImpl();

		vrInspectionStandardImpl.setNew(vrInspectionStandard.isNew());
		vrInspectionStandardImpl.setPrimaryKey(vrInspectionStandard.getPrimaryKey());

		vrInspectionStandardImpl.setId(vrInspectionStandard.getId());
		vrInspectionStandardImpl.setVehicleCertificateId(vrInspectionStandard.getVehicleCertificateId());
		vrInspectionStandardImpl.setDeliverableCode(vrInspectionStandard.getDeliverableCode());
		vrInspectionStandardImpl.setSequenceNo(vrInspectionStandard.getSequenceNo());
		vrInspectionStandardImpl.setCircularno(vrInspectionStandard.getCircularno());
		vrInspectionStandardImpl.setCirculardate(vrInspectionStandard.getCirculardate());
		vrInspectionStandardImpl.setMarkupstatus(vrInspectionStandard.getMarkupstatus());
		vrInspectionStandardImpl.setModule(vrInspectionStandard.getModule());
		vrInspectionStandardImpl.setModifyDate(vrInspectionStandard.getModifyDate());
		vrInspectionStandardImpl.setSyncDate(vrInspectionStandard.getSyncDate());

		return vrInspectionStandardImpl;
	}

	/**
	 * Returns the vr inspection standard with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vr inspection standard
	 * @return the vr inspection standard
	 * @throws NoSuchVRInspectionStandardException if a vr inspection standard with the primary key could not be found
	 */
	@Override
	public VRInspectionStandard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVRInspectionStandardException {
		VRInspectionStandard vrInspectionStandard = fetchByPrimaryKey(primaryKey);

		if (vrInspectionStandard == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVRInspectionStandardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vrInspectionStandard;
	}

	/**
	 * Returns the vr inspection standard with the primary key or throws a {@link NoSuchVRInspectionStandardException} if it could not be found.
	 *
	 * @param id the primary key of the vr inspection standard
	 * @return the vr inspection standard
	 * @throws NoSuchVRInspectionStandardException if a vr inspection standard with the primary key could not be found
	 */
	@Override
	public VRInspectionStandard findByPrimaryKey(long id)
		throws NoSuchVRInspectionStandardException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the vr inspection standard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vr inspection standard
	 * @return the vr inspection standard, or <code>null</code> if a vr inspection standard with the primary key could not be found
	 */
	@Override
	public VRInspectionStandard fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
				VRInspectionStandardImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		VRInspectionStandard vrInspectionStandard = (VRInspectionStandard)serializable;

		if (vrInspectionStandard == null) {
			Session session = null;

			try {
				session = openSession();

				vrInspectionStandard = (VRInspectionStandard)session.get(VRInspectionStandardImpl.class,
						primaryKey);

				if (vrInspectionStandard != null) {
					cacheResult(vrInspectionStandard);
				}
				else {
					entityCache.putResult(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
						VRInspectionStandardImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
					VRInspectionStandardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vrInspectionStandard;
	}

	/**
	 * Returns the vr inspection standard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vr inspection standard
	 * @return the vr inspection standard, or <code>null</code> if a vr inspection standard with the primary key could not be found
	 */
	@Override
	public VRInspectionStandard fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, VRInspectionStandard> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, VRInspectionStandard> map = new HashMap<Serializable, VRInspectionStandard>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			VRInspectionStandard vrInspectionStandard = fetchByPrimaryKey(primaryKey);

			if (vrInspectionStandard != null) {
				map.put(primaryKey, vrInspectionStandard);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
					VRInspectionStandardImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (VRInspectionStandard)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VRINSPECTIONSTANDARD_WHERE_PKS_IN);

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

			for (VRInspectionStandard vrInspectionStandard : (List<VRInspectionStandard>)q.list()) {
				map.put(vrInspectionStandard.getPrimaryKeyObj(),
					vrInspectionStandard);

				cacheResult(vrInspectionStandard);

				uncachedPrimaryKeys.remove(vrInspectionStandard.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(VRInspectionStandardModelImpl.ENTITY_CACHE_ENABLED,
					VRInspectionStandardImpl.class, primaryKey, nullModel);
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
	 * Returns all the vr inspection standards.
	 *
	 * @return the vr inspection standards
	 */
	@Override
	public List<VRInspectionStandard> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr inspection standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRInspectionStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr inspection standards
	 * @param end the upper bound of the range of vr inspection standards (not inclusive)
	 * @return the range of vr inspection standards
	 */
	@Override
	public List<VRInspectionStandard> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr inspection standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRInspectionStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr inspection standards
	 * @param end the upper bound of the range of vr inspection standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vr inspection standards
	 */
	@Override
	public List<VRInspectionStandard> findAll(int start, int end,
		OrderByComparator<VRInspectionStandard> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr inspection standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRInspectionStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr inspection standards
	 * @param end the upper bound of the range of vr inspection standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of vr inspection standards
	 */
	@Override
	public List<VRInspectionStandard> findAll(int start, int end,
		OrderByComparator<VRInspectionStandard> orderByComparator,
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

		List<VRInspectionStandard> list = null;

		if (retrieveFromCache) {
			list = (List<VRInspectionStandard>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VRINSPECTIONSTANDARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VRINSPECTIONSTANDARD;

				if (pagination) {
					sql = sql.concat(VRInspectionStandardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VRInspectionStandard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRInspectionStandard>)QueryUtil.list(q,
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
	 * Removes all the vr inspection standards from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VRInspectionStandard vrInspectionStandard : findAll()) {
			remove(vrInspectionStandard);
		}
	}

	/**
	 * Returns the number of vr inspection standards.
	 *
	 * @return the number of vr inspection standards
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VRINSPECTIONSTANDARD);

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
		return VRInspectionStandardModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vr inspection standard persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(VRInspectionStandardImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_VRINSPECTIONSTANDARD = "SELECT vrInspectionStandard FROM VRInspectionStandard vrInspectionStandard";
	private static final String _SQL_SELECT_VRINSPECTIONSTANDARD_WHERE_PKS_IN = "SELECT vrInspectionStandard FROM VRInspectionStandard vrInspectionStandard WHERE id IN (";
	private static final String _SQL_SELECT_VRINSPECTIONSTANDARD_WHERE = "SELECT vrInspectionStandard FROM VRInspectionStandard vrInspectionStandard WHERE ";
	private static final String _SQL_COUNT_VRINSPECTIONSTANDARD = "SELECT COUNT(vrInspectionStandard) FROM VRInspectionStandard vrInspectionStandard";
	private static final String _SQL_COUNT_VRINSPECTIONSTANDARD_WHERE = "SELECT COUNT(vrInspectionStandard) FROM VRInspectionStandard vrInspectionStandard WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vrInspectionStandard.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VRInspectionStandard exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VRInspectionStandard exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(VRInspectionStandardPersistenceImpl.class);
}