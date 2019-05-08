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

import com.fds.vr.business.exception.NoSuchVRApplicantProfileException;
import com.fds.vr.business.model.VRApplicantProfile;
import com.fds.vr.business.model.impl.VRApplicantProfileImpl;
import com.fds.vr.business.model.impl.VRApplicantProfileModelImpl;
import com.fds.vr.business.service.persistence.VRApplicantProfilePersistence;

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
 * The persistence implementation for the vr applicant profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LamTV
 * @see VRApplicantProfilePersistence
 * @see com.fds.vr.business.service.persistence.VRApplicantProfileUtil
 * @generated
 */
@ProviderType
public class VRApplicantProfilePersistenceImpl extends BasePersistenceImpl<VRApplicantProfile>
	implements VRApplicantProfilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VRApplicantProfileUtil} to access the vr applicant profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VRApplicantProfileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAPPINGSTATUS =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymappingStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGSTATUS =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymappingStatus",
			new String[] { Long.class.getName(), String.class.getName() },
			VRApplicantProfileModelImpl.MTCORE_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.MAPPINGSTATUS_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAPPINGSTATUS = new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymappingStatus",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the vr applicant profiles where mtCore = &#63; and mappingStatus = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingStatus the mapping status
	 * @return the matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findBymappingStatus(long mtCore,
		String mappingStatus) {
		return findBymappingStatus(mtCore, mappingStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr applicant profiles where mtCore = &#63; and mappingStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param mappingStatus the mapping status
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @return the range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findBymappingStatus(long mtCore,
		String mappingStatus, int start, int end) {
		return findBymappingStatus(mtCore, mappingStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and mappingStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param mappingStatus the mapping status
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findBymappingStatus(long mtCore,
		String mappingStatus, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		return findBymappingStatus(mtCore, mappingStatus, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and mappingStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param mappingStatus the mapping status
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findBymappingStatus(long mtCore,
		String mappingStatus, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGSTATUS;
			finderArgs = new Object[] { mtCore, mappingStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAPPINGSTATUS;
			finderArgs = new Object[] {
					mtCore, mappingStatus,
					
					start, end, orderByComparator
				};
		}

		List<VRApplicantProfile> list = null;

		if (retrieveFromCache) {
			list = (List<VRApplicantProfile>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRApplicantProfile vrApplicantProfile : list) {
					if ((mtCore != vrApplicantProfile.getMtCore()) ||
							!Objects.equals(mappingStatus,
								vrApplicantProfile.getMappingStatus())) {
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

			query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_MAPPINGSTATUS_MTCORE_2);

			boolean bindMappingStatus = false;

			if (mappingStatus == null) {
				query.append(_FINDER_COLUMN_MAPPINGSTATUS_MAPPINGSTATUS_1);
			}
			else if (mappingStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MAPPINGSTATUS_MAPPINGSTATUS_3);
			}
			else {
				bindMappingStatus = true;

				query.append(_FINDER_COLUMN_MAPPINGSTATUS_MAPPINGSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindMappingStatus) {
					qPos.add(mappingStatus);
				}

				if (!pagination) {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
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
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and mappingStatus = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingStatus the mapping status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findBymappingStatus_First(long mtCore,
		String mappingStatus,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchBymappingStatus_First(mtCore,
				mappingStatus, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", mappingStatus=");
		msg.append(mappingStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and mappingStatus = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingStatus the mapping status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchBymappingStatus_First(long mtCore,
		String mappingStatus,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		List<VRApplicantProfile> list = findBymappingStatus(mtCore,
				mappingStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and mappingStatus = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingStatus the mapping status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findBymappingStatus_Last(long mtCore,
		String mappingStatus,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchBymappingStatus_Last(mtCore,
				mappingStatus, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", mappingStatus=");
		msg.append(mappingStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and mappingStatus = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingStatus the mapping status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchBymappingStatus_Last(long mtCore,
		String mappingStatus,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		int count = countBymappingStatus(mtCore, mappingStatus);

		if (count == 0) {
			return null;
		}

		List<VRApplicantProfile> list = findBymappingStatus(mtCore,
				mappingStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr applicant profiles before and after the current vr applicant profile in the ordered set where mtCore = &#63; and mappingStatus = &#63;.
	 *
	 * @param id the primary key of the current vr applicant profile
	 * @param mtCore the mt core
	 * @param mappingStatus the mapping status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a vr applicant profile with the primary key could not be found
	 */
	@Override
	public VRApplicantProfile[] findBymappingStatus_PrevAndNext(long id,
		long mtCore, String mappingStatus,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRApplicantProfile[] array = new VRApplicantProfileImpl[3];

			array[0] = getBymappingStatus_PrevAndNext(session,
					vrApplicantProfile, mtCore, mappingStatus,
					orderByComparator, true);

			array[1] = vrApplicantProfile;

			array[2] = getBymappingStatus_PrevAndNext(session,
					vrApplicantProfile, mtCore, mappingStatus,
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

	protected VRApplicantProfile getBymappingStatus_PrevAndNext(
		Session session, VRApplicantProfile vrApplicantProfile, long mtCore,
		String mappingStatus,
		OrderByComparator<VRApplicantProfile> orderByComparator,
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

		query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

		query.append(_FINDER_COLUMN_MAPPINGSTATUS_MTCORE_2);

		boolean bindMappingStatus = false;

		if (mappingStatus == null) {
			query.append(_FINDER_COLUMN_MAPPINGSTATUS_MAPPINGSTATUS_1);
		}
		else if (mappingStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MAPPINGSTATUS_MAPPINGSTATUS_3);
		}
		else {
			bindMappingStatus = true;

			query.append(_FINDER_COLUMN_MAPPINGSTATUS_MAPPINGSTATUS_2);
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
			query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mtCore);

		if (bindMappingStatus) {
			qPos.add(mappingStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrApplicantProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRApplicantProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr applicant profiles where mtCore = &#63; and mappingStatus = &#63; from the database.
	 *
	 * @param mtCore the mt core
	 * @param mappingStatus the mapping status
	 */
	@Override
	public void removeBymappingStatus(long mtCore, String mappingStatus) {
		for (VRApplicantProfile vrApplicantProfile : findBymappingStatus(
				mtCore, mappingStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(vrApplicantProfile);
		}
	}

	/**
	 * Returns the number of vr applicant profiles where mtCore = &#63; and mappingStatus = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingStatus the mapping status
	 * @return the number of matching vr applicant profiles
	 */
	@Override
	public int countBymappingStatus(long mtCore, String mappingStatus) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MAPPINGSTATUS;

		Object[] finderArgs = new Object[] { mtCore, mappingStatus };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_MAPPINGSTATUS_MTCORE_2);

			boolean bindMappingStatus = false;

			if (mappingStatus == null) {
				query.append(_FINDER_COLUMN_MAPPINGSTATUS_MAPPINGSTATUS_1);
			}
			else if (mappingStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MAPPINGSTATUS_MAPPINGSTATUS_3);
			}
			else {
				bindMappingStatus = true;

				query.append(_FINDER_COLUMN_MAPPINGSTATUS_MAPPINGSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindMappingStatus) {
					qPos.add(mappingStatus);
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

	private static final String _FINDER_COLUMN_MAPPINGSTATUS_MTCORE_2 = "vrApplicantProfile.mtCore = ? AND ";
	private static final String _FINDER_COLUMN_MAPPINGSTATUS_MAPPINGSTATUS_1 = "vrApplicantProfile.mappingStatus IS NULL";
	private static final String _FINDER_COLUMN_MAPPINGSTATUS_MAPPINGSTATUS_2 = "vrApplicantProfile.mappingStatus = ?";
	private static final String _FINDER_COLUMN_MAPPINGSTATUS_MAPPINGSTATUS_3 = "(vrApplicantProfile.mappingStatus IS NULL OR vrApplicantProfile.mappingStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTCODE =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByapplicantCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTCODE =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByapplicantCode",
			new String[] { Long.class.getName(), String.class.getName() },
			VRApplicantProfileModelImpl.MTCORE_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.APPLICANTCODE_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICANTCODE = new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByapplicantCode",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the vr applicant profiles where mtCore = &#63; and applicantCode = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantCode the applicant code
	 * @return the matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantCode(long mtCore,
		String applicantCode) {
		return findByapplicantCode(mtCore, applicantCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr applicant profiles where mtCore = &#63; and applicantCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param applicantCode the applicant code
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @return the range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantCode(long mtCore,
		String applicantCode, int start, int end) {
		return findByapplicantCode(mtCore, applicantCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and applicantCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param applicantCode the applicant code
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantCode(long mtCore,
		String applicantCode, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		return findByapplicantCode(mtCore, applicantCode, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and applicantCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param applicantCode the applicant code
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantCode(long mtCore,
		String applicantCode, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTCODE;
			finderArgs = new Object[] { mtCore, applicantCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTCODE;
			finderArgs = new Object[] {
					mtCore, applicantCode,
					
					start, end, orderByComparator
				};
		}

		List<VRApplicantProfile> list = null;

		if (retrieveFromCache) {
			list = (List<VRApplicantProfile>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRApplicantProfile vrApplicantProfile : list) {
					if ((mtCore != vrApplicantProfile.getMtCore()) ||
							!Objects.equals(applicantCode,
								vrApplicantProfile.getApplicantCode())) {
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

			query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_APPLICANTCODE_MTCORE_2);

			boolean bindApplicantCode = false;

			if (applicantCode == null) {
				query.append(_FINDER_COLUMN_APPLICANTCODE_APPLICANTCODE_1);
			}
			else if (applicantCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTCODE_APPLICANTCODE_3);
			}
			else {
				bindApplicantCode = true;

				query.append(_FINDER_COLUMN_APPLICANTCODE_APPLICANTCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindApplicantCode) {
					qPos.add(applicantCode);
				}

				if (!pagination) {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
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
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and applicantCode = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantCode the applicant code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findByapplicantCode_First(long mtCore,
		String applicantCode,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchByapplicantCode_First(mtCore,
				applicantCode, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", applicantCode=");
		msg.append(applicantCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and applicantCode = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantCode the applicant code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchByapplicantCode_First(long mtCore,
		String applicantCode,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		List<VRApplicantProfile> list = findByapplicantCode(mtCore,
				applicantCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and applicantCode = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantCode the applicant code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findByapplicantCode_Last(long mtCore,
		String applicantCode,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchByapplicantCode_Last(mtCore,
				applicantCode, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", applicantCode=");
		msg.append(applicantCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and applicantCode = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantCode the applicant code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchByapplicantCode_Last(long mtCore,
		String applicantCode,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		int count = countByapplicantCode(mtCore, applicantCode);

		if (count == 0) {
			return null;
		}

		List<VRApplicantProfile> list = findByapplicantCode(mtCore,
				applicantCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr applicant profiles before and after the current vr applicant profile in the ordered set where mtCore = &#63; and applicantCode = &#63;.
	 *
	 * @param id the primary key of the current vr applicant profile
	 * @param mtCore the mt core
	 * @param applicantCode the applicant code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a vr applicant profile with the primary key could not be found
	 */
	@Override
	public VRApplicantProfile[] findByapplicantCode_PrevAndNext(long id,
		long mtCore, String applicantCode,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRApplicantProfile[] array = new VRApplicantProfileImpl[3];

			array[0] = getByapplicantCode_PrevAndNext(session,
					vrApplicantProfile, mtCore, applicantCode,
					orderByComparator, true);

			array[1] = vrApplicantProfile;

			array[2] = getByapplicantCode_PrevAndNext(session,
					vrApplicantProfile, mtCore, applicantCode,
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

	protected VRApplicantProfile getByapplicantCode_PrevAndNext(
		Session session, VRApplicantProfile vrApplicantProfile, long mtCore,
		String applicantCode,
		OrderByComparator<VRApplicantProfile> orderByComparator,
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

		query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

		query.append(_FINDER_COLUMN_APPLICANTCODE_MTCORE_2);

		boolean bindApplicantCode = false;

		if (applicantCode == null) {
			query.append(_FINDER_COLUMN_APPLICANTCODE_APPLICANTCODE_1);
		}
		else if (applicantCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPLICANTCODE_APPLICANTCODE_3);
		}
		else {
			bindApplicantCode = true;

			query.append(_FINDER_COLUMN_APPLICANTCODE_APPLICANTCODE_2);
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
			query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mtCore);

		if (bindApplicantCode) {
			qPos.add(applicantCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrApplicantProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRApplicantProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr applicant profiles where mtCore = &#63; and applicantCode = &#63; from the database.
	 *
	 * @param mtCore the mt core
	 * @param applicantCode the applicant code
	 */
	@Override
	public void removeByapplicantCode(long mtCore, String applicantCode) {
		for (VRApplicantProfile vrApplicantProfile : findByapplicantCode(
				mtCore, applicantCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(vrApplicantProfile);
		}
	}

	/**
	 * Returns the number of vr applicant profiles where mtCore = &#63; and applicantCode = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantCode the applicant code
	 * @return the number of matching vr applicant profiles
	 */
	@Override
	public int countByapplicantCode(long mtCore, String applicantCode) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICANTCODE;

		Object[] finderArgs = new Object[] { mtCore, applicantCode };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_APPLICANTCODE_MTCORE_2);

			boolean bindApplicantCode = false;

			if (applicantCode == null) {
				query.append(_FINDER_COLUMN_APPLICANTCODE_APPLICANTCODE_1);
			}
			else if (applicantCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTCODE_APPLICANTCODE_3);
			}
			else {
				bindApplicantCode = true;

				query.append(_FINDER_COLUMN_APPLICANTCODE_APPLICANTCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindApplicantCode) {
					qPos.add(applicantCode);
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

	private static final String _FINDER_COLUMN_APPLICANTCODE_MTCORE_2 = "vrApplicantProfile.mtCore = ? AND ";
	private static final String _FINDER_COLUMN_APPLICANTCODE_APPLICANTCODE_1 = "vrApplicantProfile.applicantCode IS NULL";
	private static final String _FINDER_COLUMN_APPLICANTCODE_APPLICANTCODE_2 = "vrApplicantProfile.applicantCode = ?";
	private static final String _FINDER_COLUMN_APPLICANTCODE_APPLICANTCODE_3 = "(vrApplicantProfile.applicantCode IS NULL OR vrApplicantProfile.applicantCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAPPINGMA_CTY =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymappingMA_CTY",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGMA_CTY =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymappingMA_CTY",
			new String[] { Long.class.getName(), String.class.getName() },
			VRApplicantProfileModelImpl.MTCORE_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.MAPPINGMA_CTY_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAPPINGMA_CTY = new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymappingMA_CTY",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the vr applicant profiles where mtCore = &#63; and mappingMA_CTY = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingMA_CTY the mapping ma_cty
	 * @return the matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findBymappingMA_CTY(long mtCore,
		String mappingMA_CTY) {
		return findBymappingMA_CTY(mtCore, mappingMA_CTY, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr applicant profiles where mtCore = &#63; and mappingMA_CTY = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param mappingMA_CTY the mapping ma_cty
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @return the range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findBymappingMA_CTY(long mtCore,
		String mappingMA_CTY, int start, int end) {
		return findBymappingMA_CTY(mtCore, mappingMA_CTY, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and mappingMA_CTY = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param mappingMA_CTY the mapping ma_cty
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findBymappingMA_CTY(long mtCore,
		String mappingMA_CTY, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		return findBymappingMA_CTY(mtCore, mappingMA_CTY, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and mappingMA_CTY = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param mappingMA_CTY the mapping ma_cty
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findBymappingMA_CTY(long mtCore,
		String mappingMA_CTY, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGMA_CTY;
			finderArgs = new Object[] { mtCore, mappingMA_CTY };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAPPINGMA_CTY;
			finderArgs = new Object[] {
					mtCore, mappingMA_CTY,
					
					start, end, orderByComparator
				};
		}

		List<VRApplicantProfile> list = null;

		if (retrieveFromCache) {
			list = (List<VRApplicantProfile>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRApplicantProfile vrApplicantProfile : list) {
					if ((mtCore != vrApplicantProfile.getMtCore()) ||
							!Objects.equals(mappingMA_CTY,
								vrApplicantProfile.getMappingMA_CTY())) {
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

			query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_MAPPINGMA_CTY_MTCORE_2);

			boolean bindMappingMA_CTY = false;

			if (mappingMA_CTY == null) {
				query.append(_FINDER_COLUMN_MAPPINGMA_CTY_MAPPINGMA_CTY_1);
			}
			else if (mappingMA_CTY.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MAPPINGMA_CTY_MAPPINGMA_CTY_3);
			}
			else {
				bindMappingMA_CTY = true;

				query.append(_FINDER_COLUMN_MAPPINGMA_CTY_MAPPINGMA_CTY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindMappingMA_CTY) {
					qPos.add(mappingMA_CTY);
				}

				if (!pagination) {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
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
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and mappingMA_CTY = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingMA_CTY the mapping ma_cty
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findBymappingMA_CTY_First(long mtCore,
		String mappingMA_CTY,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchBymappingMA_CTY_First(mtCore,
				mappingMA_CTY, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", mappingMA_CTY=");
		msg.append(mappingMA_CTY);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and mappingMA_CTY = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingMA_CTY the mapping ma_cty
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchBymappingMA_CTY_First(long mtCore,
		String mappingMA_CTY,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		List<VRApplicantProfile> list = findBymappingMA_CTY(mtCore,
				mappingMA_CTY, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and mappingMA_CTY = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingMA_CTY the mapping ma_cty
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findBymappingMA_CTY_Last(long mtCore,
		String mappingMA_CTY,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchBymappingMA_CTY_Last(mtCore,
				mappingMA_CTY, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", mappingMA_CTY=");
		msg.append(mappingMA_CTY);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and mappingMA_CTY = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingMA_CTY the mapping ma_cty
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchBymappingMA_CTY_Last(long mtCore,
		String mappingMA_CTY,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		int count = countBymappingMA_CTY(mtCore, mappingMA_CTY);

		if (count == 0) {
			return null;
		}

		List<VRApplicantProfile> list = findBymappingMA_CTY(mtCore,
				mappingMA_CTY, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr applicant profiles before and after the current vr applicant profile in the ordered set where mtCore = &#63; and mappingMA_CTY = &#63;.
	 *
	 * @param id the primary key of the current vr applicant profile
	 * @param mtCore the mt core
	 * @param mappingMA_CTY the mapping ma_cty
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a vr applicant profile with the primary key could not be found
	 */
	@Override
	public VRApplicantProfile[] findBymappingMA_CTY_PrevAndNext(long id,
		long mtCore, String mappingMA_CTY,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRApplicantProfile[] array = new VRApplicantProfileImpl[3];

			array[0] = getBymappingMA_CTY_PrevAndNext(session,
					vrApplicantProfile, mtCore, mappingMA_CTY,
					orderByComparator, true);

			array[1] = vrApplicantProfile;

			array[2] = getBymappingMA_CTY_PrevAndNext(session,
					vrApplicantProfile, mtCore, mappingMA_CTY,
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

	protected VRApplicantProfile getBymappingMA_CTY_PrevAndNext(
		Session session, VRApplicantProfile vrApplicantProfile, long mtCore,
		String mappingMA_CTY,
		OrderByComparator<VRApplicantProfile> orderByComparator,
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

		query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

		query.append(_FINDER_COLUMN_MAPPINGMA_CTY_MTCORE_2);

		boolean bindMappingMA_CTY = false;

		if (mappingMA_CTY == null) {
			query.append(_FINDER_COLUMN_MAPPINGMA_CTY_MAPPINGMA_CTY_1);
		}
		else if (mappingMA_CTY.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MAPPINGMA_CTY_MAPPINGMA_CTY_3);
		}
		else {
			bindMappingMA_CTY = true;

			query.append(_FINDER_COLUMN_MAPPINGMA_CTY_MAPPINGMA_CTY_2);
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
			query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mtCore);

		if (bindMappingMA_CTY) {
			qPos.add(mappingMA_CTY);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrApplicantProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRApplicantProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr applicant profiles where mtCore = &#63; and mappingMA_CTY = &#63; from the database.
	 *
	 * @param mtCore the mt core
	 * @param mappingMA_CTY the mapping ma_cty
	 */
	@Override
	public void removeBymappingMA_CTY(long mtCore, String mappingMA_CTY) {
		for (VRApplicantProfile vrApplicantProfile : findBymappingMA_CTY(
				mtCore, mappingMA_CTY, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(vrApplicantProfile);
		}
	}

	/**
	 * Returns the number of vr applicant profiles where mtCore = &#63; and mappingMA_CTY = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingMA_CTY the mapping ma_cty
	 * @return the number of matching vr applicant profiles
	 */
	@Override
	public int countBymappingMA_CTY(long mtCore, String mappingMA_CTY) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MAPPINGMA_CTY;

		Object[] finderArgs = new Object[] { mtCore, mappingMA_CTY };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_MAPPINGMA_CTY_MTCORE_2);

			boolean bindMappingMA_CTY = false;

			if (mappingMA_CTY == null) {
				query.append(_FINDER_COLUMN_MAPPINGMA_CTY_MAPPINGMA_CTY_1);
			}
			else if (mappingMA_CTY.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MAPPINGMA_CTY_MAPPINGMA_CTY_3);
			}
			else {
				bindMappingMA_CTY = true;

				query.append(_FINDER_COLUMN_MAPPINGMA_CTY_MAPPINGMA_CTY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindMappingMA_CTY) {
					qPos.add(mappingMA_CTY);
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

	private static final String _FINDER_COLUMN_MAPPINGMA_CTY_MTCORE_2 = "vrApplicantProfile.mtCore = ? AND ";
	private static final String _FINDER_COLUMN_MAPPINGMA_CTY_MAPPINGMA_CTY_1 = "vrApplicantProfile.mappingMA_CTY IS NULL";
	private static final String _FINDER_COLUMN_MAPPINGMA_CTY_MAPPINGMA_CTY_2 = "vrApplicantProfile.mappingMA_CTY = ?";
	private static final String _FINDER_COLUMN_MAPPINGMA_CTY_MAPPINGMA_CTY_3 = "(vrApplicantProfile.mappingMA_CTY IS NULL OR vrApplicantProfile.mappingMA_CTY = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAPPINGTEN_CTY =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymappingTEN_CTY",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGTEN_CTY =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymappingTEN_CTY",
			new String[] { Long.class.getName(), String.class.getName() },
			VRApplicantProfileModelImpl.MTCORE_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.MAPPINGTEN_CTY_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAPPINGTEN_CTY = new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymappingTEN_CTY",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the vr applicant profiles where mtCore = &#63; and mappingTEN_CTY = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingTEN_CTY the mapping ten_cty
	 * @return the matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findBymappingTEN_CTY(long mtCore,
		String mappingTEN_CTY) {
		return findBymappingTEN_CTY(mtCore, mappingTEN_CTY, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr applicant profiles where mtCore = &#63; and mappingTEN_CTY = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param mappingTEN_CTY the mapping ten_cty
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @return the range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findBymappingTEN_CTY(long mtCore,
		String mappingTEN_CTY, int start, int end) {
		return findBymappingTEN_CTY(mtCore, mappingTEN_CTY, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and mappingTEN_CTY = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param mappingTEN_CTY the mapping ten_cty
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findBymappingTEN_CTY(long mtCore,
		String mappingTEN_CTY, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		return findBymappingTEN_CTY(mtCore, mappingTEN_CTY, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and mappingTEN_CTY = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param mappingTEN_CTY the mapping ten_cty
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findBymappingTEN_CTY(long mtCore,
		String mappingTEN_CTY, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGTEN_CTY;
			finderArgs = new Object[] { mtCore, mappingTEN_CTY };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAPPINGTEN_CTY;
			finderArgs = new Object[] {
					mtCore, mappingTEN_CTY,
					
					start, end, orderByComparator
				};
		}

		List<VRApplicantProfile> list = null;

		if (retrieveFromCache) {
			list = (List<VRApplicantProfile>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRApplicantProfile vrApplicantProfile : list) {
					if ((mtCore != vrApplicantProfile.getMtCore()) ||
							!Objects.equals(mappingTEN_CTY,
								vrApplicantProfile.getMappingTEN_CTY())) {
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

			query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_MAPPINGTEN_CTY_MTCORE_2);

			boolean bindMappingTEN_CTY = false;

			if (mappingTEN_CTY == null) {
				query.append(_FINDER_COLUMN_MAPPINGTEN_CTY_MAPPINGTEN_CTY_1);
			}
			else if (mappingTEN_CTY.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MAPPINGTEN_CTY_MAPPINGTEN_CTY_3);
			}
			else {
				bindMappingTEN_CTY = true;

				query.append(_FINDER_COLUMN_MAPPINGTEN_CTY_MAPPINGTEN_CTY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindMappingTEN_CTY) {
					qPos.add(mappingTEN_CTY);
				}

				if (!pagination) {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
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
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and mappingTEN_CTY = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingTEN_CTY the mapping ten_cty
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findBymappingTEN_CTY_First(long mtCore,
		String mappingTEN_CTY,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchBymappingTEN_CTY_First(mtCore,
				mappingTEN_CTY, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", mappingTEN_CTY=");
		msg.append(mappingTEN_CTY);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and mappingTEN_CTY = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingTEN_CTY the mapping ten_cty
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchBymappingTEN_CTY_First(long mtCore,
		String mappingTEN_CTY,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		List<VRApplicantProfile> list = findBymappingTEN_CTY(mtCore,
				mappingTEN_CTY, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and mappingTEN_CTY = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingTEN_CTY the mapping ten_cty
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findBymappingTEN_CTY_Last(long mtCore,
		String mappingTEN_CTY,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchBymappingTEN_CTY_Last(mtCore,
				mappingTEN_CTY, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", mappingTEN_CTY=");
		msg.append(mappingTEN_CTY);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and mappingTEN_CTY = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingTEN_CTY the mapping ten_cty
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchBymappingTEN_CTY_Last(long mtCore,
		String mappingTEN_CTY,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		int count = countBymappingTEN_CTY(mtCore, mappingTEN_CTY);

		if (count == 0) {
			return null;
		}

		List<VRApplicantProfile> list = findBymappingTEN_CTY(mtCore,
				mappingTEN_CTY, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr applicant profiles before and after the current vr applicant profile in the ordered set where mtCore = &#63; and mappingTEN_CTY = &#63;.
	 *
	 * @param id the primary key of the current vr applicant profile
	 * @param mtCore the mt core
	 * @param mappingTEN_CTY the mapping ten_cty
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a vr applicant profile with the primary key could not be found
	 */
	@Override
	public VRApplicantProfile[] findBymappingTEN_CTY_PrevAndNext(long id,
		long mtCore, String mappingTEN_CTY,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRApplicantProfile[] array = new VRApplicantProfileImpl[3];

			array[0] = getBymappingTEN_CTY_PrevAndNext(session,
					vrApplicantProfile, mtCore, mappingTEN_CTY,
					orderByComparator, true);

			array[1] = vrApplicantProfile;

			array[2] = getBymappingTEN_CTY_PrevAndNext(session,
					vrApplicantProfile, mtCore, mappingTEN_CTY,
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

	protected VRApplicantProfile getBymappingTEN_CTY_PrevAndNext(
		Session session, VRApplicantProfile vrApplicantProfile, long mtCore,
		String mappingTEN_CTY,
		OrderByComparator<VRApplicantProfile> orderByComparator,
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

		query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

		query.append(_FINDER_COLUMN_MAPPINGTEN_CTY_MTCORE_2);

		boolean bindMappingTEN_CTY = false;

		if (mappingTEN_CTY == null) {
			query.append(_FINDER_COLUMN_MAPPINGTEN_CTY_MAPPINGTEN_CTY_1);
		}
		else if (mappingTEN_CTY.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MAPPINGTEN_CTY_MAPPINGTEN_CTY_3);
		}
		else {
			bindMappingTEN_CTY = true;

			query.append(_FINDER_COLUMN_MAPPINGTEN_CTY_MAPPINGTEN_CTY_2);
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
			query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mtCore);

		if (bindMappingTEN_CTY) {
			qPos.add(mappingTEN_CTY);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrApplicantProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRApplicantProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr applicant profiles where mtCore = &#63; and mappingTEN_CTY = &#63; from the database.
	 *
	 * @param mtCore the mt core
	 * @param mappingTEN_CTY the mapping ten_cty
	 */
	@Override
	public void removeBymappingTEN_CTY(long mtCore, String mappingTEN_CTY) {
		for (VRApplicantProfile vrApplicantProfile : findBymappingTEN_CTY(
				mtCore, mappingTEN_CTY, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(vrApplicantProfile);
		}
	}

	/**
	 * Returns the number of vr applicant profiles where mtCore = &#63; and mappingTEN_CTY = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param mappingTEN_CTY the mapping ten_cty
	 * @return the number of matching vr applicant profiles
	 */
	@Override
	public int countBymappingTEN_CTY(long mtCore, String mappingTEN_CTY) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MAPPINGTEN_CTY;

		Object[] finderArgs = new Object[] { mtCore, mappingTEN_CTY };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_MAPPINGTEN_CTY_MTCORE_2);

			boolean bindMappingTEN_CTY = false;

			if (mappingTEN_CTY == null) {
				query.append(_FINDER_COLUMN_MAPPINGTEN_CTY_MAPPINGTEN_CTY_1);
			}
			else if (mappingTEN_CTY.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MAPPINGTEN_CTY_MAPPINGTEN_CTY_3);
			}
			else {
				bindMappingTEN_CTY = true;

				query.append(_FINDER_COLUMN_MAPPINGTEN_CTY_MAPPINGTEN_CTY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindMappingTEN_CTY) {
					qPos.add(mappingTEN_CTY);
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

	private static final String _FINDER_COLUMN_MAPPINGTEN_CTY_MTCORE_2 = "vrApplicantProfile.mtCore = ? AND ";
	private static final String _FINDER_COLUMN_MAPPINGTEN_CTY_MAPPINGTEN_CTY_1 = "vrApplicantProfile.mappingTEN_CTY IS NULL";
	private static final String _FINDER_COLUMN_MAPPINGTEN_CTY_MAPPINGTEN_CTY_2 = "vrApplicantProfile.mappingTEN_CTY = ?";
	private static final String _FINDER_COLUMN_MAPPINGTEN_CTY_MAPPINGTEN_CTY_3 = "(vrApplicantProfile.mappingTEN_CTY IS NULL OR vrApplicantProfile.mappingTEN_CTY = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTREGION =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByapplicantRegion",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTREGION =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByapplicantRegion",
			new String[] { Long.class.getName(), String.class.getName() },
			VRApplicantProfileModelImpl.MTCORE_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.APPLICANTREGION_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICANTREGION = new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByapplicantRegion",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the vr applicant profiles where mtCore = &#63; and applicantRegion = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantRegion the applicant region
	 * @return the matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantRegion(long mtCore,
		String applicantRegion) {
		return findByapplicantRegion(mtCore, applicantRegion,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr applicant profiles where mtCore = &#63; and applicantRegion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param applicantRegion the applicant region
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @return the range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantRegion(long mtCore,
		String applicantRegion, int start, int end) {
		return findByapplicantRegion(mtCore, applicantRegion, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and applicantRegion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param applicantRegion the applicant region
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantRegion(long mtCore,
		String applicantRegion, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		return findByapplicantRegion(mtCore, applicantRegion, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and applicantRegion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param applicantRegion the applicant region
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantRegion(long mtCore,
		String applicantRegion, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTREGION;
			finderArgs = new Object[] { mtCore, applicantRegion };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTREGION;
			finderArgs = new Object[] {
					mtCore, applicantRegion,
					
					start, end, orderByComparator
				};
		}

		List<VRApplicantProfile> list = null;

		if (retrieveFromCache) {
			list = (List<VRApplicantProfile>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRApplicantProfile vrApplicantProfile : list) {
					if ((mtCore != vrApplicantProfile.getMtCore()) ||
							!Objects.equals(applicantRegion,
								vrApplicantProfile.getApplicantRegion())) {
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

			query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_APPLICANTREGION_MTCORE_2);

			boolean bindApplicantRegion = false;

			if (applicantRegion == null) {
				query.append(_FINDER_COLUMN_APPLICANTREGION_APPLICANTREGION_1);
			}
			else if (applicantRegion.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTREGION_APPLICANTREGION_3);
			}
			else {
				bindApplicantRegion = true;

				query.append(_FINDER_COLUMN_APPLICANTREGION_APPLICANTREGION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindApplicantRegion) {
					qPos.add(applicantRegion);
				}

				if (!pagination) {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
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
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and applicantRegion = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantRegion the applicant region
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findByapplicantRegion_First(long mtCore,
		String applicantRegion,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchByapplicantRegion_First(mtCore,
				applicantRegion, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", applicantRegion=");
		msg.append(applicantRegion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and applicantRegion = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantRegion the applicant region
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchByapplicantRegion_First(long mtCore,
		String applicantRegion,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		List<VRApplicantProfile> list = findByapplicantRegion(mtCore,
				applicantRegion, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and applicantRegion = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantRegion the applicant region
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findByapplicantRegion_Last(long mtCore,
		String applicantRegion,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchByapplicantRegion_Last(mtCore,
				applicantRegion, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", applicantRegion=");
		msg.append(applicantRegion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and applicantRegion = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantRegion the applicant region
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchByapplicantRegion_Last(long mtCore,
		String applicantRegion,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		int count = countByapplicantRegion(mtCore, applicantRegion);

		if (count == 0) {
			return null;
		}

		List<VRApplicantProfile> list = findByapplicantRegion(mtCore,
				applicantRegion, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr applicant profiles before and after the current vr applicant profile in the ordered set where mtCore = &#63; and applicantRegion = &#63;.
	 *
	 * @param id the primary key of the current vr applicant profile
	 * @param mtCore the mt core
	 * @param applicantRegion the applicant region
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a vr applicant profile with the primary key could not be found
	 */
	@Override
	public VRApplicantProfile[] findByapplicantRegion_PrevAndNext(long id,
		long mtCore, String applicantRegion,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRApplicantProfile[] array = new VRApplicantProfileImpl[3];

			array[0] = getByapplicantRegion_PrevAndNext(session,
					vrApplicantProfile, mtCore, applicantRegion,
					orderByComparator, true);

			array[1] = vrApplicantProfile;

			array[2] = getByapplicantRegion_PrevAndNext(session,
					vrApplicantProfile, mtCore, applicantRegion,
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

	protected VRApplicantProfile getByapplicantRegion_PrevAndNext(
		Session session, VRApplicantProfile vrApplicantProfile, long mtCore,
		String applicantRegion,
		OrderByComparator<VRApplicantProfile> orderByComparator,
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

		query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

		query.append(_FINDER_COLUMN_APPLICANTREGION_MTCORE_2);

		boolean bindApplicantRegion = false;

		if (applicantRegion == null) {
			query.append(_FINDER_COLUMN_APPLICANTREGION_APPLICANTREGION_1);
		}
		else if (applicantRegion.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPLICANTREGION_APPLICANTREGION_3);
		}
		else {
			bindApplicantRegion = true;

			query.append(_FINDER_COLUMN_APPLICANTREGION_APPLICANTREGION_2);
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
			query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mtCore);

		if (bindApplicantRegion) {
			qPos.add(applicantRegion);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrApplicantProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRApplicantProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr applicant profiles where mtCore = &#63; and applicantRegion = &#63; from the database.
	 *
	 * @param mtCore the mt core
	 * @param applicantRegion the applicant region
	 */
	@Override
	public void removeByapplicantRegion(long mtCore, String applicantRegion) {
		for (VRApplicantProfile vrApplicantProfile : findByapplicantRegion(
				mtCore, applicantRegion, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(vrApplicantProfile);
		}
	}

	/**
	 * Returns the number of vr applicant profiles where mtCore = &#63; and applicantRegion = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantRegion the applicant region
	 * @return the number of matching vr applicant profiles
	 */
	@Override
	public int countByapplicantRegion(long mtCore, String applicantRegion) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICANTREGION;

		Object[] finderArgs = new Object[] { mtCore, applicantRegion };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_APPLICANTREGION_MTCORE_2);

			boolean bindApplicantRegion = false;

			if (applicantRegion == null) {
				query.append(_FINDER_COLUMN_APPLICANTREGION_APPLICANTREGION_1);
			}
			else if (applicantRegion.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTREGION_APPLICANTREGION_3);
			}
			else {
				bindApplicantRegion = true;

				query.append(_FINDER_COLUMN_APPLICANTREGION_APPLICANTREGION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindApplicantRegion) {
					qPos.add(applicantRegion);
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

	private static final String _FINDER_COLUMN_APPLICANTREGION_MTCORE_2 = "vrApplicantProfile.mtCore = ? AND ";
	private static final String _FINDER_COLUMN_APPLICANTREGION_APPLICANTREGION_1 =
		"vrApplicantProfile.applicantRegion IS NULL";
	private static final String _FINDER_COLUMN_APPLICANTREGION_APPLICANTREGION_2 =
		"vrApplicantProfile.applicantRegion = ?";
	private static final String _FINDER_COLUMN_APPLICANTREGION_APPLICANTREGION_3 =
		"(vrApplicantProfile.applicantRegion IS NULL OR vrApplicantProfile.applicantRegion = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTCITY =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByapplicantCity",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTCITY =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByapplicantCity",
			new String[] { Long.class.getName(), String.class.getName() },
			VRApplicantProfileModelImpl.MTCORE_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.APPLICANTCITY_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICANTCITY = new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByapplicantCity",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the vr applicant profiles where mtCore = &#63; and applicantCity = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantCity the applicant city
	 * @return the matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantCity(long mtCore,
		String applicantCity) {
		return findByapplicantCity(mtCore, applicantCity, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr applicant profiles where mtCore = &#63; and applicantCity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param applicantCity the applicant city
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @return the range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantCity(long mtCore,
		String applicantCity, int start, int end) {
		return findByapplicantCity(mtCore, applicantCity, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and applicantCity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param applicantCity the applicant city
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantCity(long mtCore,
		String applicantCity, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		return findByapplicantCity(mtCore, applicantCity, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and applicantCity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param applicantCity the applicant city
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantCity(long mtCore,
		String applicantCity, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTCITY;
			finderArgs = new Object[] { mtCore, applicantCity };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTCITY;
			finderArgs = new Object[] {
					mtCore, applicantCity,
					
					start, end, orderByComparator
				};
		}

		List<VRApplicantProfile> list = null;

		if (retrieveFromCache) {
			list = (List<VRApplicantProfile>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRApplicantProfile vrApplicantProfile : list) {
					if ((mtCore != vrApplicantProfile.getMtCore()) ||
							!Objects.equals(applicantCity,
								vrApplicantProfile.getApplicantCity())) {
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

			query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_APPLICANTCITY_MTCORE_2);

			boolean bindApplicantCity = false;

			if (applicantCity == null) {
				query.append(_FINDER_COLUMN_APPLICANTCITY_APPLICANTCITY_1);
			}
			else if (applicantCity.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTCITY_APPLICANTCITY_3);
			}
			else {
				bindApplicantCity = true;

				query.append(_FINDER_COLUMN_APPLICANTCITY_APPLICANTCITY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindApplicantCity) {
					qPos.add(applicantCity);
				}

				if (!pagination) {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
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
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and applicantCity = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantCity the applicant city
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findByapplicantCity_First(long mtCore,
		String applicantCity,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchByapplicantCity_First(mtCore,
				applicantCity, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", applicantCity=");
		msg.append(applicantCity);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and applicantCity = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantCity the applicant city
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchByapplicantCity_First(long mtCore,
		String applicantCity,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		List<VRApplicantProfile> list = findByapplicantCity(mtCore,
				applicantCity, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and applicantCity = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantCity the applicant city
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findByapplicantCity_Last(long mtCore,
		String applicantCity,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchByapplicantCity_Last(mtCore,
				applicantCity, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", applicantCity=");
		msg.append(applicantCity);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and applicantCity = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantCity the applicant city
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchByapplicantCity_Last(long mtCore,
		String applicantCity,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		int count = countByapplicantCity(mtCore, applicantCity);

		if (count == 0) {
			return null;
		}

		List<VRApplicantProfile> list = findByapplicantCity(mtCore,
				applicantCity, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr applicant profiles before and after the current vr applicant profile in the ordered set where mtCore = &#63; and applicantCity = &#63;.
	 *
	 * @param id the primary key of the current vr applicant profile
	 * @param mtCore the mt core
	 * @param applicantCity the applicant city
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a vr applicant profile with the primary key could not be found
	 */
	@Override
	public VRApplicantProfile[] findByapplicantCity_PrevAndNext(long id,
		long mtCore, String applicantCity,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRApplicantProfile[] array = new VRApplicantProfileImpl[3];

			array[0] = getByapplicantCity_PrevAndNext(session,
					vrApplicantProfile, mtCore, applicantCity,
					orderByComparator, true);

			array[1] = vrApplicantProfile;

			array[2] = getByapplicantCity_PrevAndNext(session,
					vrApplicantProfile, mtCore, applicantCity,
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

	protected VRApplicantProfile getByapplicantCity_PrevAndNext(
		Session session, VRApplicantProfile vrApplicantProfile, long mtCore,
		String applicantCity,
		OrderByComparator<VRApplicantProfile> orderByComparator,
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

		query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

		query.append(_FINDER_COLUMN_APPLICANTCITY_MTCORE_2);

		boolean bindApplicantCity = false;

		if (applicantCity == null) {
			query.append(_FINDER_COLUMN_APPLICANTCITY_APPLICANTCITY_1);
		}
		else if (applicantCity.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPLICANTCITY_APPLICANTCITY_3);
		}
		else {
			bindApplicantCity = true;

			query.append(_FINDER_COLUMN_APPLICANTCITY_APPLICANTCITY_2);
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
			query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mtCore);

		if (bindApplicantCity) {
			qPos.add(applicantCity);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrApplicantProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRApplicantProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr applicant profiles where mtCore = &#63; and applicantCity = &#63; from the database.
	 *
	 * @param mtCore the mt core
	 * @param applicantCity the applicant city
	 */
	@Override
	public void removeByapplicantCity(long mtCore, String applicantCity) {
		for (VRApplicantProfile vrApplicantProfile : findByapplicantCity(
				mtCore, applicantCity, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(vrApplicantProfile);
		}
	}

	/**
	 * Returns the number of vr applicant profiles where mtCore = &#63; and applicantCity = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantCity the applicant city
	 * @return the number of matching vr applicant profiles
	 */
	@Override
	public int countByapplicantCity(long mtCore, String applicantCity) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICANTCITY;

		Object[] finderArgs = new Object[] { mtCore, applicantCity };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_APPLICANTCITY_MTCORE_2);

			boolean bindApplicantCity = false;

			if (applicantCity == null) {
				query.append(_FINDER_COLUMN_APPLICANTCITY_APPLICANTCITY_1);
			}
			else if (applicantCity.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTCITY_APPLICANTCITY_3);
			}
			else {
				bindApplicantCity = true;

				query.append(_FINDER_COLUMN_APPLICANTCITY_APPLICANTCITY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindApplicantCity) {
					qPos.add(applicantCity);
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

	private static final String _FINDER_COLUMN_APPLICANTCITY_MTCORE_2 = "vrApplicantProfile.mtCore = ? AND ";
	private static final String _FINDER_COLUMN_APPLICANTCITY_APPLICANTCITY_1 = "vrApplicantProfile.applicantCity IS NULL";
	private static final String _FINDER_COLUMN_APPLICANTCITY_APPLICANTCITY_2 = "vrApplicantProfile.applicantCity = ?";
	private static final String _FINDER_COLUMN_APPLICANTCITY_APPLICANTCITY_3 = "(vrApplicantProfile.applicantCity IS NULL OR vrApplicantProfile.applicantCity = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTSTATUS =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByapplicantStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTSTATUS =
		new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED,
			VRApplicantProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByapplicantStatus",
			new String[] { Long.class.getName(), String.class.getName() },
			VRApplicantProfileModelImpl.MTCORE_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.APPLICANTSTATUS_COLUMN_BITMASK |
			VRApplicantProfileModelImpl.MODIFYDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICANTSTATUS = new FinderPath(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByapplicantStatus",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the vr applicant profiles where mtCore = &#63; and applicantStatus = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantStatus the applicant status
	 * @return the matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantStatus(long mtCore,
		String applicantStatus) {
		return findByapplicantStatus(mtCore, applicantStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr applicant profiles where mtCore = &#63; and applicantStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param applicantStatus the applicant status
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @return the range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantStatus(long mtCore,
		String applicantStatus, int start, int end) {
		return findByapplicantStatus(mtCore, applicantStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and applicantStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param applicantStatus the applicant status
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantStatus(long mtCore,
		String applicantStatus, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		return findByapplicantStatus(mtCore, applicantStatus, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles where mtCore = &#63; and applicantStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mtCore the mt core
	 * @param applicantStatus the applicant status
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findByapplicantStatus(long mtCore,
		String applicantStatus, int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTSTATUS;
			finderArgs = new Object[] { mtCore, applicantStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTSTATUS;
			finderArgs = new Object[] {
					mtCore, applicantStatus,
					
					start, end, orderByComparator
				};
		}

		List<VRApplicantProfile> list = null;

		if (retrieveFromCache) {
			list = (List<VRApplicantProfile>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRApplicantProfile vrApplicantProfile : list) {
					if ((mtCore != vrApplicantProfile.getMtCore()) ||
							!Objects.equals(applicantStatus,
								vrApplicantProfile.getApplicantStatus())) {
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

			query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_APPLICANTSTATUS_MTCORE_2);

			boolean bindApplicantStatus = false;

			if (applicantStatus == null) {
				query.append(_FINDER_COLUMN_APPLICANTSTATUS_APPLICANTSTATUS_1);
			}
			else if (applicantStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTSTATUS_APPLICANTSTATUS_3);
			}
			else {
				bindApplicantStatus = true;

				query.append(_FINDER_COLUMN_APPLICANTSTATUS_APPLICANTSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindApplicantStatus) {
					qPos.add(applicantStatus);
				}

				if (!pagination) {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
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
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and applicantStatus = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantStatus the applicant status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findByapplicantStatus_First(long mtCore,
		String applicantStatus,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchByapplicantStatus_First(mtCore,
				applicantStatus, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", applicantStatus=");
		msg.append(applicantStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the first vr applicant profile in the ordered set where mtCore = &#63; and applicantStatus = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantStatus the applicant status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchByapplicantStatus_First(long mtCore,
		String applicantStatus,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		List<VRApplicantProfile> list = findByapplicantStatus(mtCore,
				applicantStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and applicantStatus = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantStatus the applicant status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile findByapplicantStatus_Last(long mtCore,
		String applicantStatus,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchByapplicantStatus_Last(mtCore,
				applicantStatus, orderByComparator);

		if (vrApplicantProfile != null) {
			return vrApplicantProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mtCore=");
		msg.append(mtCore);

		msg.append(", applicantStatus=");
		msg.append(applicantStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRApplicantProfileException(msg.toString());
	}

	/**
	 * Returns the last vr applicant profile in the ordered set where mtCore = &#63; and applicantStatus = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantStatus the applicant status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr applicant profile, or <code>null</code> if a matching vr applicant profile could not be found
	 */
	@Override
	public VRApplicantProfile fetchByapplicantStatus_Last(long mtCore,
		String applicantStatus,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		int count = countByapplicantStatus(mtCore, applicantStatus);

		if (count == 0) {
			return null;
		}

		List<VRApplicantProfile> list = findByapplicantStatus(mtCore,
				applicantStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr applicant profiles before and after the current vr applicant profile in the ordered set where mtCore = &#63; and applicantStatus = &#63;.
	 *
	 * @param id the primary key of the current vr applicant profile
	 * @param mtCore the mt core
	 * @param applicantStatus the applicant status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a vr applicant profile with the primary key could not be found
	 */
	@Override
	public VRApplicantProfile[] findByapplicantStatus_PrevAndNext(long id,
		long mtCore, String applicantStatus,
		OrderByComparator<VRApplicantProfile> orderByComparator)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRApplicantProfile[] array = new VRApplicantProfileImpl[3];

			array[0] = getByapplicantStatus_PrevAndNext(session,
					vrApplicantProfile, mtCore, applicantStatus,
					orderByComparator, true);

			array[1] = vrApplicantProfile;

			array[2] = getByapplicantStatus_PrevAndNext(session,
					vrApplicantProfile, mtCore, applicantStatus,
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

	protected VRApplicantProfile getByapplicantStatus_PrevAndNext(
		Session session, VRApplicantProfile vrApplicantProfile, long mtCore,
		String applicantStatus,
		OrderByComparator<VRApplicantProfile> orderByComparator,
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

		query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE);

		query.append(_FINDER_COLUMN_APPLICANTSTATUS_MTCORE_2);

		boolean bindApplicantStatus = false;

		if (applicantStatus == null) {
			query.append(_FINDER_COLUMN_APPLICANTSTATUS_APPLICANTSTATUS_1);
		}
		else if (applicantStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPLICANTSTATUS_APPLICANTSTATUS_3);
		}
		else {
			bindApplicantStatus = true;

			query.append(_FINDER_COLUMN_APPLICANTSTATUS_APPLICANTSTATUS_2);
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
			query.append(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mtCore);

		if (bindApplicantStatus) {
			qPos.add(applicantStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrApplicantProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRApplicantProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr applicant profiles where mtCore = &#63; and applicantStatus = &#63; from the database.
	 *
	 * @param mtCore the mt core
	 * @param applicantStatus the applicant status
	 */
	@Override
	public void removeByapplicantStatus(long mtCore, String applicantStatus) {
		for (VRApplicantProfile vrApplicantProfile : findByapplicantStatus(
				mtCore, applicantStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(vrApplicantProfile);
		}
	}

	/**
	 * Returns the number of vr applicant profiles where mtCore = &#63; and applicantStatus = &#63;.
	 *
	 * @param mtCore the mt core
	 * @param applicantStatus the applicant status
	 * @return the number of matching vr applicant profiles
	 */
	@Override
	public int countByapplicantStatus(long mtCore, String applicantStatus) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICANTSTATUS;

		Object[] finderArgs = new Object[] { mtCore, applicantStatus };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VRAPPLICANTPROFILE_WHERE);

			query.append(_FINDER_COLUMN_APPLICANTSTATUS_MTCORE_2);

			boolean bindApplicantStatus = false;

			if (applicantStatus == null) {
				query.append(_FINDER_COLUMN_APPLICANTSTATUS_APPLICANTSTATUS_1);
			}
			else if (applicantStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTSTATUS_APPLICANTSTATUS_3);
			}
			else {
				bindApplicantStatus = true;

				query.append(_FINDER_COLUMN_APPLICANTSTATUS_APPLICANTSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mtCore);

				if (bindApplicantStatus) {
					qPos.add(applicantStatus);
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

	private static final String _FINDER_COLUMN_APPLICANTSTATUS_MTCORE_2 = "vrApplicantProfile.mtCore = ? AND ";
	private static final String _FINDER_COLUMN_APPLICANTSTATUS_APPLICANTSTATUS_1 =
		"vrApplicantProfile.applicantStatus IS NULL";
	private static final String _FINDER_COLUMN_APPLICANTSTATUS_APPLICANTSTATUS_2 =
		"vrApplicantProfile.applicantStatus = ?";
	private static final String _FINDER_COLUMN_APPLICANTSTATUS_APPLICANTSTATUS_3 =
		"(vrApplicantProfile.applicantStatus IS NULL OR vrApplicantProfile.applicantStatus = '')";

	public VRApplicantProfilePersistenceImpl() {
		setModelClass(VRApplicantProfile.class);
	}

	/**
	 * Caches the vr applicant profile in the entity cache if it is enabled.
	 *
	 * @param vrApplicantProfile the vr applicant profile
	 */
	@Override
	public void cacheResult(VRApplicantProfile vrApplicantProfile) {
		entityCache.putResult(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileImpl.class, vrApplicantProfile.getPrimaryKey(),
			vrApplicantProfile);

		vrApplicantProfile.resetOriginalValues();
	}

	/**
	 * Caches the vr applicant profiles in the entity cache if it is enabled.
	 *
	 * @param vrApplicantProfiles the vr applicant profiles
	 */
	@Override
	public void cacheResult(List<VRApplicantProfile> vrApplicantProfiles) {
		for (VRApplicantProfile vrApplicantProfile : vrApplicantProfiles) {
			if (entityCache.getResult(
						VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
						VRApplicantProfileImpl.class,
						vrApplicantProfile.getPrimaryKey()) == null) {
				cacheResult(vrApplicantProfile);
			}
			else {
				vrApplicantProfile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vr applicant profiles.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VRApplicantProfileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vr applicant profile.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VRApplicantProfile vrApplicantProfile) {
		entityCache.removeResult(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileImpl.class, vrApplicantProfile.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VRApplicantProfile> vrApplicantProfiles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VRApplicantProfile vrApplicantProfile : vrApplicantProfiles) {
			entityCache.removeResult(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
				VRApplicantProfileImpl.class, vrApplicantProfile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vr applicant profile with the primary key. Does not add the vr applicant profile to the database.
	 *
	 * @param id the primary key for the new vr applicant profile
	 * @return the new vr applicant profile
	 */
	@Override
	public VRApplicantProfile create(long id) {
		VRApplicantProfile vrApplicantProfile = new VRApplicantProfileImpl();

		vrApplicantProfile.setNew(true);
		vrApplicantProfile.setPrimaryKey(id);

		return vrApplicantProfile;
	}

	/**
	 * Removes the vr applicant profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vr applicant profile
	 * @return the vr applicant profile that was removed
	 * @throws NoSuchVRApplicantProfileException if a vr applicant profile with the primary key could not be found
	 */
	@Override
	public VRApplicantProfile remove(long id)
		throws NoSuchVRApplicantProfileException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the vr applicant profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vr applicant profile
	 * @return the vr applicant profile that was removed
	 * @throws NoSuchVRApplicantProfileException if a vr applicant profile with the primary key could not be found
	 */
	@Override
	public VRApplicantProfile remove(Serializable primaryKey)
		throws NoSuchVRApplicantProfileException {
		Session session = null;

		try {
			session = openSession();

			VRApplicantProfile vrApplicantProfile = (VRApplicantProfile)session.get(VRApplicantProfileImpl.class,
					primaryKey);

			if (vrApplicantProfile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVRApplicantProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vrApplicantProfile);
		}
		catch (NoSuchVRApplicantProfileException nsee) {
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
	protected VRApplicantProfile removeImpl(
		VRApplicantProfile vrApplicantProfile) {
		vrApplicantProfile = toUnwrappedModel(vrApplicantProfile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vrApplicantProfile)) {
				vrApplicantProfile = (VRApplicantProfile)session.get(VRApplicantProfileImpl.class,
						vrApplicantProfile.getPrimaryKeyObj());
			}

			if (vrApplicantProfile != null) {
				session.delete(vrApplicantProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vrApplicantProfile != null) {
			clearCache(vrApplicantProfile);
		}

		return vrApplicantProfile;
	}

	@Override
	public VRApplicantProfile updateImpl(VRApplicantProfile vrApplicantProfile) {
		vrApplicantProfile = toUnwrappedModel(vrApplicantProfile);

		boolean isNew = vrApplicantProfile.isNew();

		VRApplicantProfileModelImpl vrApplicantProfileModelImpl = (VRApplicantProfileModelImpl)vrApplicantProfile;

		Session session = null;

		try {
			session = openSession();

			if (vrApplicantProfile.isNew()) {
				session.save(vrApplicantProfile);

				vrApplicantProfile.setNew(false);
			}
			else {
				vrApplicantProfile = (VRApplicantProfile)session.merge(vrApplicantProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VRApplicantProfileModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vrApplicantProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrApplicantProfileModelImpl.getOriginalMtCore(),
						vrApplicantProfileModelImpl.getOriginalMappingStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MAPPINGSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGSTATUS,
					args);

				args = new Object[] {
						vrApplicantProfileModelImpl.getMtCore(),
						vrApplicantProfileModelImpl.getMappingStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MAPPINGSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGSTATUS,
					args);
			}

			if ((vrApplicantProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrApplicantProfileModelImpl.getOriginalMtCore(),
						vrApplicantProfileModelImpl.getOriginalApplicantCode()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTCODE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTCODE,
					args);

				args = new Object[] {
						vrApplicantProfileModelImpl.getMtCore(),
						vrApplicantProfileModelImpl.getApplicantCode()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTCODE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTCODE,
					args);
			}

			if ((vrApplicantProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGMA_CTY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrApplicantProfileModelImpl.getOriginalMtCore(),
						vrApplicantProfileModelImpl.getOriginalMappingMA_CTY()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MAPPINGMA_CTY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGMA_CTY,
					args);

				args = new Object[] {
						vrApplicantProfileModelImpl.getMtCore(),
						vrApplicantProfileModelImpl.getMappingMA_CTY()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MAPPINGMA_CTY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGMA_CTY,
					args);
			}

			if ((vrApplicantProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGTEN_CTY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrApplicantProfileModelImpl.getOriginalMtCore(),
						vrApplicantProfileModelImpl.getOriginalMappingTEN_CTY()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MAPPINGTEN_CTY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGTEN_CTY,
					args);

				args = new Object[] {
						vrApplicantProfileModelImpl.getMtCore(),
						vrApplicantProfileModelImpl.getMappingTEN_CTY()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MAPPINGTEN_CTY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAPPINGTEN_CTY,
					args);
			}

			if ((vrApplicantProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTREGION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrApplicantProfileModelImpl.getOriginalMtCore(),
						vrApplicantProfileModelImpl.getOriginalApplicantRegion()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTREGION,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTREGION,
					args);

				args = new Object[] {
						vrApplicantProfileModelImpl.getMtCore(),
						vrApplicantProfileModelImpl.getApplicantRegion()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTREGION,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTREGION,
					args);
			}

			if ((vrApplicantProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTCITY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrApplicantProfileModelImpl.getOriginalMtCore(),
						vrApplicantProfileModelImpl.getOriginalApplicantCity()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTCITY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTCITY,
					args);

				args = new Object[] {
						vrApplicantProfileModelImpl.getMtCore(),
						vrApplicantProfileModelImpl.getApplicantCity()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTCITY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTCITY,
					args);
			}

			if ((vrApplicantProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrApplicantProfileModelImpl.getOriginalMtCore(),
						vrApplicantProfileModelImpl.getOriginalApplicantStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTSTATUS,
					args);

				args = new Object[] {
						vrApplicantProfileModelImpl.getMtCore(),
						vrApplicantProfileModelImpl.getApplicantStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTSTATUS,
					args);
			}
		}

		entityCache.putResult(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
			VRApplicantProfileImpl.class, vrApplicantProfile.getPrimaryKey(),
			vrApplicantProfile, false);

		vrApplicantProfile.resetOriginalValues();

		return vrApplicantProfile;
	}

	protected VRApplicantProfile toUnwrappedModel(
		VRApplicantProfile vrApplicantProfile) {
		if (vrApplicantProfile instanceof VRApplicantProfileImpl) {
			return vrApplicantProfile;
		}

		VRApplicantProfileImpl vrApplicantProfileImpl = new VRApplicantProfileImpl();

		vrApplicantProfileImpl.setNew(vrApplicantProfile.isNew());
		vrApplicantProfileImpl.setPrimaryKey(vrApplicantProfile.getPrimaryKey());

		vrApplicantProfileImpl.setId(vrApplicantProfile.getId());
		vrApplicantProfileImpl.setMtCore(vrApplicantProfile.getMtCore());
		vrApplicantProfileImpl.setMappingMA_CTY(vrApplicantProfile.getMappingMA_CTY());
		vrApplicantProfileImpl.setMappingTEN_CTY(vrApplicantProfile.getMappingTEN_CTY());
		vrApplicantProfileImpl.setMappingDIA_CHI_CTY(vrApplicantProfile.getMappingDIA_CHI_CTY());
		vrApplicantProfileImpl.setMappingNote(vrApplicantProfile.getMappingNote());
		vrApplicantProfileImpl.setMappingStatus(vrApplicantProfile.getMappingStatus());
		vrApplicantProfileImpl.setApplicantCode(vrApplicantProfile.getApplicantCode());
		vrApplicantProfileImpl.setApplicantName(vrApplicantProfile.getApplicantName());
		vrApplicantProfileImpl.setApplicantAddress(vrApplicantProfile.getApplicantAddress());
		vrApplicantProfileImpl.setApplicantPhone(vrApplicantProfile.getApplicantPhone());
		vrApplicantProfileImpl.setApplicantEmail(vrApplicantProfile.getApplicantEmail());
		vrApplicantProfileImpl.setApplicantFax(vrApplicantProfile.getApplicantFax());
		vrApplicantProfileImpl.setApplicantRepresentative(vrApplicantProfile.getApplicantRepresentative());
		vrApplicantProfileImpl.setApplicantRepresentativeTitle(vrApplicantProfile.getApplicantRepresentativeTitle());
		vrApplicantProfileImpl.setApplicantContactName(vrApplicantProfile.getApplicantContactName());
		vrApplicantProfileImpl.setApplicantContactEmail(vrApplicantProfile.getApplicantContactEmail());
		vrApplicantProfileImpl.setApplicantContactPhone(vrApplicantProfile.getApplicantContactPhone());
		vrApplicantProfileImpl.setApplicantNationality(vrApplicantProfile.getApplicantNationality());
		vrApplicantProfileImpl.setApplicantRegion(vrApplicantProfile.getApplicantRegion());
		vrApplicantProfileImpl.setApplicantCity(vrApplicantProfile.getApplicantCity());
		vrApplicantProfileImpl.setMarkupCorporation(vrApplicantProfile.getMarkupCorporation());
		vrApplicantProfileImpl.setCorporationId(vrApplicantProfile.getCorporationId());
		vrApplicantProfileImpl.setMarkupDesigner(vrApplicantProfile.getMarkupDesigner());
		vrApplicantProfileImpl.setMarkupOverseasManufacturer(vrApplicantProfile.getMarkupOverseasManufacturer());
		vrApplicantProfileImpl.setMarkupDomesticsManufacturer(vrApplicantProfile.getMarkupDomesticsManufacturer());
		vrApplicantProfileImpl.setMarkupImporter(vrApplicantProfile.getMarkupImporter());
		vrApplicantProfileImpl.setMarkupComponentXCG(vrApplicantProfile.getMarkupComponentXCG());
		vrApplicantProfileImpl.setMarkupComponentXMY(vrApplicantProfile.getMarkupComponentXMY());
		vrApplicantProfileImpl.setMarkupComponentXCD(vrApplicantProfile.getMarkupComponentXCD());
		vrApplicantProfileImpl.setMarkupComponentXDD(vrApplicantProfile.getMarkupComponentXDD());
		vrApplicantProfileImpl.setMarkupComponentXCN(vrApplicantProfile.getMarkupComponentXCN());
		vrApplicantProfileImpl.setMarkupComponentXCH(vrApplicantProfile.getMarkupComponentXCH());
		vrApplicantProfileImpl.setMarkupXCG(vrApplicantProfile.getMarkupXCG());
		vrApplicantProfileImpl.setMarkupXMY(vrApplicantProfile.getMarkupXMY());
		vrApplicantProfileImpl.setMarkupXCD(vrApplicantProfile.getMarkupXCD());
		vrApplicantProfileImpl.setMarkupXDD(vrApplicantProfile.getMarkupXDD());
		vrApplicantProfileImpl.setMarkupXCN(vrApplicantProfile.getMarkupXCN());
		vrApplicantProfileImpl.setMarkupXCH(vrApplicantProfile.getMarkupXCH());
		vrApplicantProfileImpl.setIssueTypeXCG(vrApplicantProfile.getIssueTypeXCG());
		vrApplicantProfileImpl.setIssueTypeXMY(vrApplicantProfile.getIssueTypeXMY());
		vrApplicantProfileImpl.setIssueTypeXCD(vrApplicantProfile.getIssueTypeXCD());
		vrApplicantProfileImpl.setIssueTypeXDD(vrApplicantProfile.getIssueTypeXDD());
		vrApplicantProfileImpl.setIssueTypeXCN(vrApplicantProfile.getIssueTypeXCN());
		vrApplicantProfileImpl.setIssueTypeXCH(vrApplicantProfile.getIssueTypeXCH());
		vrApplicantProfileImpl.setIssueTypeDescription(vrApplicantProfile.getIssueTypeDescription());
		vrApplicantProfileImpl.setApplicantCeremonyDate(vrApplicantProfile.getApplicantCeremonyDate());
		vrApplicantProfileImpl.setApplicantOperationPeriod(vrApplicantProfile.getApplicantOperationPeriod());
		vrApplicantProfileImpl.setApplicantBusinessType(vrApplicantProfile.getApplicantBusinessType());
		vrApplicantProfileImpl.setApplicantMetadata(vrApplicantProfile.getApplicantMetadata());
		vrApplicantProfileImpl.setApplicantStatus(vrApplicantProfile.getApplicantStatus());
		vrApplicantProfileImpl.setModifyDate(vrApplicantProfile.getModifyDate());
		vrApplicantProfileImpl.setSyncDate(vrApplicantProfile.getSyncDate());

		return vrApplicantProfileImpl;
	}

	/**
	 * Returns the vr applicant profile with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vr applicant profile
	 * @return the vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a vr applicant profile with the primary key could not be found
	 */
	@Override
	public VRApplicantProfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVRApplicantProfileException {
		VRApplicantProfile vrApplicantProfile = fetchByPrimaryKey(primaryKey);

		if (vrApplicantProfile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVRApplicantProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vrApplicantProfile;
	}

	/**
	 * Returns the vr applicant profile with the primary key or throws a {@link NoSuchVRApplicantProfileException} if it could not be found.
	 *
	 * @param id the primary key of the vr applicant profile
	 * @return the vr applicant profile
	 * @throws NoSuchVRApplicantProfileException if a vr applicant profile with the primary key could not be found
	 */
	@Override
	public VRApplicantProfile findByPrimaryKey(long id)
		throws NoSuchVRApplicantProfileException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the vr applicant profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vr applicant profile
	 * @return the vr applicant profile, or <code>null</code> if a vr applicant profile with the primary key could not be found
	 */
	@Override
	public VRApplicantProfile fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
				VRApplicantProfileImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		VRApplicantProfile vrApplicantProfile = (VRApplicantProfile)serializable;

		if (vrApplicantProfile == null) {
			Session session = null;

			try {
				session = openSession();

				vrApplicantProfile = (VRApplicantProfile)session.get(VRApplicantProfileImpl.class,
						primaryKey);

				if (vrApplicantProfile != null) {
					cacheResult(vrApplicantProfile);
				}
				else {
					entityCache.putResult(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
						VRApplicantProfileImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
					VRApplicantProfileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vrApplicantProfile;
	}

	/**
	 * Returns the vr applicant profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vr applicant profile
	 * @return the vr applicant profile, or <code>null</code> if a vr applicant profile with the primary key could not be found
	 */
	@Override
	public VRApplicantProfile fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, VRApplicantProfile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, VRApplicantProfile> map = new HashMap<Serializable, VRApplicantProfile>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			VRApplicantProfile vrApplicantProfile = fetchByPrimaryKey(primaryKey);

			if (vrApplicantProfile != null) {
				map.put(primaryKey, vrApplicantProfile);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
					VRApplicantProfileImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (VRApplicantProfile)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VRAPPLICANTPROFILE_WHERE_PKS_IN);

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

			for (VRApplicantProfile vrApplicantProfile : (List<VRApplicantProfile>)q.list()) {
				map.put(vrApplicantProfile.getPrimaryKeyObj(),
					vrApplicantProfile);

				cacheResult(vrApplicantProfile);

				uncachedPrimaryKeys.remove(vrApplicantProfile.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(VRApplicantProfileModelImpl.ENTITY_CACHE_ENABLED,
					VRApplicantProfileImpl.class, primaryKey, nullModel);
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
	 * Returns all the vr applicant profiles.
	 *
	 * @return the vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr applicant profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @return the range of vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findAll(int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr applicant profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRApplicantProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr applicant profiles
	 * @param end the upper bound of the range of vr applicant profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of vr applicant profiles
	 */
	@Override
	public List<VRApplicantProfile> findAll(int start, int end,
		OrderByComparator<VRApplicantProfile> orderByComparator,
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

		List<VRApplicantProfile> list = null;

		if (retrieveFromCache) {
			list = (List<VRApplicantProfile>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VRAPPLICANTPROFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VRAPPLICANTPROFILE;

				if (pagination) {
					sql = sql.concat(VRApplicantProfileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRApplicantProfile>)QueryUtil.list(q,
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
	 * Removes all the vr applicant profiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VRApplicantProfile vrApplicantProfile : findAll()) {
			remove(vrApplicantProfile);
		}
	}

	/**
	 * Returns the number of vr applicant profiles.
	 *
	 * @return the number of vr applicant profiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VRAPPLICANTPROFILE);

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
		return VRApplicantProfileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vr applicant profile persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(VRApplicantProfileImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_VRAPPLICANTPROFILE = "SELECT vrApplicantProfile FROM VRApplicantProfile vrApplicantProfile";
	private static final String _SQL_SELECT_VRAPPLICANTPROFILE_WHERE_PKS_IN = "SELECT vrApplicantProfile FROM VRApplicantProfile vrApplicantProfile WHERE id IN (";
	private static final String _SQL_SELECT_VRAPPLICANTPROFILE_WHERE = "SELECT vrApplicantProfile FROM VRApplicantProfile vrApplicantProfile WHERE ";
	private static final String _SQL_COUNT_VRAPPLICANTPROFILE = "SELECT COUNT(vrApplicantProfile) FROM VRApplicantProfile vrApplicantProfile";
	private static final String _SQL_COUNT_VRAPPLICANTPROFILE_WHERE = "SELECT COUNT(vrApplicantProfile) FROM VRApplicantProfile vrApplicantProfile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vrApplicantProfile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VRApplicantProfile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VRApplicantProfile exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(VRApplicantProfilePersistenceImpl.class);
}