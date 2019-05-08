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

import com.fds.vr.business.exception.NoSuchVRIssueEquipmentCertificateException;
import com.fds.vr.business.model.VRIssueEquipmentCertificate;
import com.fds.vr.business.model.impl.VRIssueEquipmentCertificateImpl;
import com.fds.vr.business.model.impl.VRIssueEquipmentCertificateModelImpl;
import com.fds.vr.business.service.persistence.VRIssueEquipmentCertificatePersistence;

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
 * The persistence implementation for the vr issue equipment certificate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LamTV
 * @see VRIssueEquipmentCertificatePersistence
 * @see com.fds.vr.business.service.persistence.VRIssueEquipmentCertificateUtil
 * @generated
 */
@ProviderType
public class VRIssueEquipmentCertificatePersistenceImpl
	extends BasePersistenceImpl<VRIssueEquipmentCertificate>
	implements VRIssueEquipmentCertificatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VRIssueEquipmentCertificateUtil} to access the vr issue equipment certificate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VRIssueEquipmentCertificateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			VRIssueEquipmentCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			VRIssueEquipmentCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSUEVEHICLECERTIFICATEID =
		new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			VRIssueEquipmentCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIssueVehicleCertificateId",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUEVEHICLECERTIFICATEID =
		new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			VRIssueEquipmentCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByIssueVehicleCertificateId",
			new String[] { Integer.class.getName() },
			VRIssueEquipmentCertificateModelImpl.ISSUEVEHICLECERTIFICATEID_COLUMN_BITMASK |
			VRIssueEquipmentCertificateModelImpl.SYNCDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISSUEVEHICLECERTIFICATEID =
		new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIssueVehicleCertificateId",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the vr issue equipment certificates where issueVehicleCertificateId = &#63;.
	 *
	 * @param issueVehicleCertificateId the issue vehicle certificate ID
	 * @return the matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByIssueVehicleCertificateId(
		int issueVehicleCertificateId) {
		return findByIssueVehicleCertificateId(issueVehicleCertificateId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr issue equipment certificates where issueVehicleCertificateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param issueVehicleCertificateId the issue vehicle certificate ID
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @return the range of matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByIssueVehicleCertificateId(
		int issueVehicleCertificateId, int start, int end) {
		return findByIssueVehicleCertificateId(issueVehicleCertificateId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr issue equipment certificates where issueVehicleCertificateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param issueVehicleCertificateId the issue vehicle certificate ID
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByIssueVehicleCertificateId(
		int issueVehicleCertificateId, int start, int end,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator) {
		return findByIssueVehicleCertificateId(issueVehicleCertificateId,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr issue equipment certificates where issueVehicleCertificateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param issueVehicleCertificateId the issue vehicle certificate ID
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByIssueVehicleCertificateId(
		int issueVehicleCertificateId, int start, int end,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUEVEHICLECERTIFICATEID;
			finderArgs = new Object[] { issueVehicleCertificateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSUEVEHICLECERTIFICATEID;
			finderArgs = new Object[] {
					issueVehicleCertificateId,
					
					start, end, orderByComparator
				};
		}

		List<VRIssueEquipmentCertificate> list = null;

		if (retrieveFromCache) {
			list = (List<VRIssueEquipmentCertificate>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRIssueEquipmentCertificate vrIssueEquipmentCertificate : list) {
					if ((issueVehicleCertificateId != vrIssueEquipmentCertificate.getIssueVehicleCertificateId())) {
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

			query.append(_SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_ISSUEVEHICLECERTIFICATEID_ISSUEVEHICLECERTIFICATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRIssueEquipmentCertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(issueVehicleCertificateId);

				if (!pagination) {
					list = (List<VRIssueEquipmentCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRIssueEquipmentCertificate>)QueryUtil.list(q,
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
	 * Returns the first vr issue equipment certificate in the ordered set where issueVehicleCertificateId = &#63;.
	 *
	 * @param issueVehicleCertificateId the issue vehicle certificate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate findByIssueVehicleCertificateId_First(
		int issueVehicleCertificateId,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = fetchByIssueVehicleCertificateId_First(issueVehicleCertificateId,
				orderByComparator);

		if (vrIssueEquipmentCertificate != null) {
			return vrIssueEquipmentCertificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("issueVehicleCertificateId=");
		msg.append(issueVehicleCertificateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRIssueEquipmentCertificateException(msg.toString());
	}

	/**
	 * Returns the first vr issue equipment certificate in the ordered set where issueVehicleCertificateId = &#63;.
	 *
	 * @param issueVehicleCertificateId the issue vehicle certificate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate fetchByIssueVehicleCertificateId_First(
		int issueVehicleCertificateId,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator) {
		List<VRIssueEquipmentCertificate> list = findByIssueVehicleCertificateId(issueVehicleCertificateId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr issue equipment certificate in the ordered set where issueVehicleCertificateId = &#63;.
	 *
	 * @param issueVehicleCertificateId the issue vehicle certificate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate findByIssueVehicleCertificateId_Last(
		int issueVehicleCertificateId,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = fetchByIssueVehicleCertificateId_Last(issueVehicleCertificateId,
				orderByComparator);

		if (vrIssueEquipmentCertificate != null) {
			return vrIssueEquipmentCertificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("issueVehicleCertificateId=");
		msg.append(issueVehicleCertificateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRIssueEquipmentCertificateException(msg.toString());
	}

	/**
	 * Returns the last vr issue equipment certificate in the ordered set where issueVehicleCertificateId = &#63;.
	 *
	 * @param issueVehicleCertificateId the issue vehicle certificate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate fetchByIssueVehicleCertificateId_Last(
		int issueVehicleCertificateId,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator) {
		int count = countByIssueVehicleCertificateId(issueVehicleCertificateId);

		if (count == 0) {
			return null;
		}

		List<VRIssueEquipmentCertificate> list = findByIssueVehicleCertificateId(issueVehicleCertificateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr issue equipment certificates before and after the current vr issue equipment certificate in the ordered set where issueVehicleCertificateId = &#63;.
	 *
	 * @param id the primary key of the current vr issue equipment certificate
	 * @param issueVehicleCertificateId the issue vehicle certificate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a vr issue equipment certificate with the primary key could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate[] findByIssueVehicleCertificateId_PrevAndNext(
		long id, int issueVehicleCertificateId,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRIssueEquipmentCertificate[] array = new VRIssueEquipmentCertificateImpl[3];

			array[0] = getByIssueVehicleCertificateId_PrevAndNext(session,
					vrIssueEquipmentCertificate, issueVehicleCertificateId,
					orderByComparator, true);

			array[1] = vrIssueEquipmentCertificate;

			array[2] = getByIssueVehicleCertificateId_PrevAndNext(session,
					vrIssueEquipmentCertificate, issueVehicleCertificateId,
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

	protected VRIssueEquipmentCertificate getByIssueVehicleCertificateId_PrevAndNext(
		Session session,
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate,
		int issueVehicleCertificateId,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
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

		query.append(_SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE_WHERE);

		query.append(_FINDER_COLUMN_ISSUEVEHICLECERTIFICATEID_ISSUEVEHICLECERTIFICATEID_2);

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
			query.append(VRIssueEquipmentCertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(issueVehicleCertificateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrIssueEquipmentCertificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRIssueEquipmentCertificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr issue equipment certificates where issueVehicleCertificateId = &#63; from the database.
	 *
	 * @param issueVehicleCertificateId the issue vehicle certificate ID
	 */
	@Override
	public void removeByIssueVehicleCertificateId(int issueVehicleCertificateId) {
		for (VRIssueEquipmentCertificate vrIssueEquipmentCertificate : findByIssueVehicleCertificateId(
				issueVehicleCertificateId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vrIssueEquipmentCertificate);
		}
	}

	/**
	 * Returns the number of vr issue equipment certificates where issueVehicleCertificateId = &#63;.
	 *
	 * @param issueVehicleCertificateId the issue vehicle certificate ID
	 * @return the number of matching vr issue equipment certificates
	 */
	@Override
	public int countByIssueVehicleCertificateId(int issueVehicleCertificateId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISSUEVEHICLECERTIFICATEID;

		Object[] finderArgs = new Object[] { issueVehicleCertificateId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VRISSUEEQUIPMENTCERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_ISSUEVEHICLECERTIFICATEID_ISSUEVEHICLECERTIFICATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(issueVehicleCertificateId);

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

	private static final String _FINDER_COLUMN_ISSUEVEHICLECERTIFICATEID_ISSUEVEHICLECERTIFICATEID_2 =
		"vrIssueEquipmentCertificate.issueVehicleCertificateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VEHICLECERTIFICATERECORDNO =
		new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			VRIssueEquipmentCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVehiclecertificaterecordno",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLECERTIFICATERECORDNO =
		new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			VRIssueEquipmentCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVehiclecertificaterecordno",
			new String[] { String.class.getName() },
			VRIssueEquipmentCertificateModelImpl.VEHICLECERTIFICATERECORDNO_COLUMN_BITMASK |
			VRIssueEquipmentCertificateModelImpl.SYNCDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VEHICLECERTIFICATERECORDNO =
		new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVehiclecertificaterecordno",
			new String[] { String.class.getName() });

	/**
	 * Returns all the vr issue equipment certificates where vehiclecertificaterecordno = &#63;.
	 *
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @return the matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByVehiclecertificaterecordno(
		String vehiclecertificaterecordno) {
		return findByVehiclecertificaterecordno(vehiclecertificaterecordno,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr issue equipment certificates where vehiclecertificaterecordno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @return the range of matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByVehiclecertificaterecordno(
		String vehiclecertificaterecordno, int start, int end) {
		return findByVehiclecertificaterecordno(vehiclecertificaterecordno,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr issue equipment certificates where vehiclecertificaterecordno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByVehiclecertificaterecordno(
		String vehiclecertificaterecordno, int start, int end,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator) {
		return findByVehiclecertificaterecordno(vehiclecertificaterecordno,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr issue equipment certificates where vehiclecertificaterecordno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByVehiclecertificaterecordno(
		String vehiclecertificaterecordno, int start, int end,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLECERTIFICATERECORDNO;
			finderArgs = new Object[] { vehiclecertificaterecordno };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VEHICLECERTIFICATERECORDNO;
			finderArgs = new Object[] {
					vehiclecertificaterecordno,
					
					start, end, orderByComparator
				};
		}

		List<VRIssueEquipmentCertificate> list = null;

		if (retrieveFromCache) {
			list = (List<VRIssueEquipmentCertificate>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRIssueEquipmentCertificate vrIssueEquipmentCertificate : list) {
					if (!Objects.equals(vehiclecertificaterecordno,
								vrIssueEquipmentCertificate.getVehiclecertificaterecordno())) {
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

			query.append(_SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE_WHERE);

			boolean bindVehiclecertificaterecordno = false;

			if (vehiclecertificaterecordno == null) {
				query.append(_FINDER_COLUMN_VEHICLECERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_1);
			}
			else if (vehiclecertificaterecordno.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VEHICLECERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_3);
			}
			else {
				bindVehiclecertificaterecordno = true;

				query.append(_FINDER_COLUMN_VEHICLECERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRIssueEquipmentCertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVehiclecertificaterecordno) {
					qPos.add(vehiclecertificaterecordno);
				}

				if (!pagination) {
					list = (List<VRIssueEquipmentCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRIssueEquipmentCertificate>)QueryUtil.list(q,
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
	 * Returns the first vr issue equipment certificate in the ordered set where vehiclecertificaterecordno = &#63;.
	 *
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate findByVehiclecertificaterecordno_First(
		String vehiclecertificaterecordno,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = fetchByVehiclecertificaterecordno_First(vehiclecertificaterecordno,
				orderByComparator);

		if (vrIssueEquipmentCertificate != null) {
			return vrIssueEquipmentCertificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vehiclecertificaterecordno=");
		msg.append(vehiclecertificaterecordno);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRIssueEquipmentCertificateException(msg.toString());
	}

	/**
	 * Returns the first vr issue equipment certificate in the ordered set where vehiclecertificaterecordno = &#63;.
	 *
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate fetchByVehiclecertificaterecordno_First(
		String vehiclecertificaterecordno,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator) {
		List<VRIssueEquipmentCertificate> list = findByVehiclecertificaterecordno(vehiclecertificaterecordno,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr issue equipment certificate in the ordered set where vehiclecertificaterecordno = &#63;.
	 *
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate findByVehiclecertificaterecordno_Last(
		String vehiclecertificaterecordno,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = fetchByVehiclecertificaterecordno_Last(vehiclecertificaterecordno,
				orderByComparator);

		if (vrIssueEquipmentCertificate != null) {
			return vrIssueEquipmentCertificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vehiclecertificaterecordno=");
		msg.append(vehiclecertificaterecordno);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRIssueEquipmentCertificateException(msg.toString());
	}

	/**
	 * Returns the last vr issue equipment certificate in the ordered set where vehiclecertificaterecordno = &#63;.
	 *
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate fetchByVehiclecertificaterecordno_Last(
		String vehiclecertificaterecordno,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator) {
		int count = countByVehiclecertificaterecordno(vehiclecertificaterecordno);

		if (count == 0) {
			return null;
		}

		List<VRIssueEquipmentCertificate> list = findByVehiclecertificaterecordno(vehiclecertificaterecordno,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr issue equipment certificates before and after the current vr issue equipment certificate in the ordered set where vehiclecertificaterecordno = &#63;.
	 *
	 * @param id the primary key of the current vr issue equipment certificate
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a vr issue equipment certificate with the primary key could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate[] findByVehiclecertificaterecordno_PrevAndNext(
		long id, String vehiclecertificaterecordno,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRIssueEquipmentCertificate[] array = new VRIssueEquipmentCertificateImpl[3];

			array[0] = getByVehiclecertificaterecordno_PrevAndNext(session,
					vrIssueEquipmentCertificate, vehiclecertificaterecordno,
					orderByComparator, true);

			array[1] = vrIssueEquipmentCertificate;

			array[2] = getByVehiclecertificaterecordno_PrevAndNext(session,
					vrIssueEquipmentCertificate, vehiclecertificaterecordno,
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

	protected VRIssueEquipmentCertificate getByVehiclecertificaterecordno_PrevAndNext(
		Session session,
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate,
		String vehiclecertificaterecordno,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
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

		query.append(_SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE_WHERE);

		boolean bindVehiclecertificaterecordno = false;

		if (vehiclecertificaterecordno == null) {
			query.append(_FINDER_COLUMN_VEHICLECERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_1);
		}
		else if (vehiclecertificaterecordno.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_VEHICLECERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_3);
		}
		else {
			bindVehiclecertificaterecordno = true;

			query.append(_FINDER_COLUMN_VEHICLECERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_2);
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
			query.append(VRIssueEquipmentCertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindVehiclecertificaterecordno) {
			qPos.add(vehiclecertificaterecordno);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrIssueEquipmentCertificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRIssueEquipmentCertificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr issue equipment certificates where vehiclecertificaterecordno = &#63; from the database.
	 *
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 */
	@Override
	public void removeByVehiclecertificaterecordno(
		String vehiclecertificaterecordno) {
		for (VRIssueEquipmentCertificate vrIssueEquipmentCertificate : findByVehiclecertificaterecordno(
				vehiclecertificaterecordno, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vrIssueEquipmentCertificate);
		}
	}

	/**
	 * Returns the number of vr issue equipment certificates where vehiclecertificaterecordno = &#63;.
	 *
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @return the number of matching vr issue equipment certificates
	 */
	@Override
	public int countByVehiclecertificaterecordno(
		String vehiclecertificaterecordno) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VEHICLECERTIFICATERECORDNO;

		Object[] finderArgs = new Object[] { vehiclecertificaterecordno };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VRISSUEEQUIPMENTCERTIFICATE_WHERE);

			boolean bindVehiclecertificaterecordno = false;

			if (vehiclecertificaterecordno == null) {
				query.append(_FINDER_COLUMN_VEHICLECERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_1);
			}
			else if (vehiclecertificaterecordno.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VEHICLECERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_3);
			}
			else {
				bindVehiclecertificaterecordno = true;

				query.append(_FINDER_COLUMN_VEHICLECERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVehiclecertificaterecordno) {
					qPos.add(vehiclecertificaterecordno);
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

	private static final String _FINDER_COLUMN_VEHICLECERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_1 =
		"vrIssueEquipmentCertificate.vehiclecertificaterecordno IS NULL";
	private static final String _FINDER_COLUMN_VEHICLECERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_2 =
		"vrIssueEquipmentCertificate.vehiclecertificaterecordno = ?";
	private static final String _FINDER_COLUMN_VEHICLECERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_3 =
		"(vrIssueEquipmentCertificate.vehiclecertificaterecordno IS NULL OR vrIssueEquipmentCertificate.vehiclecertificaterecordno = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTNO_CERTIFICATERECORDNO =
		new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			VRIssueEquipmentCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByApplicantNo_CertificateRecordNo",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTNO_CERTIFICATERECORDNO =
		new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			VRIssueEquipmentCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByApplicantNo_CertificateRecordNo",
			new String[] { String.class.getName(), String.class.getName() },
			VRIssueEquipmentCertificateModelImpl.APPLICANTNO_COLUMN_BITMASK |
			VRIssueEquipmentCertificateModelImpl.VEHICLECERTIFICATERECORDNO_COLUMN_BITMASK |
			VRIssueEquipmentCertificateModelImpl.SYNCDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICANTNO_CERTIFICATERECORDNO =
		new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicantNo_CertificateRecordNo",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the vr issue equipment certificates where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	 *
	 * @param applicantNo the applicant no
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @return the matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByApplicantNo_CertificateRecordNo(
		String applicantNo, String vehiclecertificaterecordno) {
		return findByApplicantNo_CertificateRecordNo(applicantNo,
			vehiclecertificaterecordno, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vr issue equipment certificates where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantNo the applicant no
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @return the range of matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByApplicantNo_CertificateRecordNo(
		String applicantNo, String vehiclecertificaterecordno, int start,
		int end) {
		return findByApplicantNo_CertificateRecordNo(applicantNo,
			vehiclecertificaterecordno, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr issue equipment certificates where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantNo the applicant no
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByApplicantNo_CertificateRecordNo(
		String applicantNo, String vehiclecertificaterecordno, int start,
		int end,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator) {
		return findByApplicantNo_CertificateRecordNo(applicantNo,
			vehiclecertificaterecordno, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr issue equipment certificates where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantNo the applicant no
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByApplicantNo_CertificateRecordNo(
		String applicantNo, String vehiclecertificaterecordno, int start,
		int end,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTNO_CERTIFICATERECORDNO;
			finderArgs = new Object[] { applicantNo, vehiclecertificaterecordno };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTNO_CERTIFICATERECORDNO;
			finderArgs = new Object[] {
					applicantNo, vehiclecertificaterecordno,
					
					start, end, orderByComparator
				};
		}

		List<VRIssueEquipmentCertificate> list = null;

		if (retrieveFromCache) {
			list = (List<VRIssueEquipmentCertificate>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRIssueEquipmentCertificate vrIssueEquipmentCertificate : list) {
					if (!Objects.equals(applicantNo,
								vrIssueEquipmentCertificate.getApplicantNo()) ||
							!Objects.equals(vehiclecertificaterecordno,
								vrIssueEquipmentCertificate.getVehiclecertificaterecordno())) {
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

			query.append(_SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE_WHERE);

			boolean bindApplicantNo = false;

			if (applicantNo == null) {
				query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_APPLICANTNO_1);
			}
			else if (applicantNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_APPLICANTNO_3);
			}
			else {
				bindApplicantNo = true;

				query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_APPLICANTNO_2);
			}

			boolean bindVehiclecertificaterecordno = false;

			if (vehiclecertificaterecordno == null) {
				query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_1);
			}
			else if (vehiclecertificaterecordno.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_3);
			}
			else {
				bindVehiclecertificaterecordno = true;

				query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRIssueEquipmentCertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicantNo) {
					qPos.add(applicantNo);
				}

				if (bindVehiclecertificaterecordno) {
					qPos.add(vehiclecertificaterecordno);
				}

				if (!pagination) {
					list = (List<VRIssueEquipmentCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRIssueEquipmentCertificate>)QueryUtil.list(q,
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
	 * Returns the first vr issue equipment certificate in the ordered set where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	 *
	 * @param applicantNo the applicant no
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate findByApplicantNo_CertificateRecordNo_First(
		String applicantNo, String vehiclecertificaterecordno,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = fetchByApplicantNo_CertificateRecordNo_First(applicantNo,
				vehiclecertificaterecordno, orderByComparator);

		if (vrIssueEquipmentCertificate != null) {
			return vrIssueEquipmentCertificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantNo=");
		msg.append(applicantNo);

		msg.append(", vehiclecertificaterecordno=");
		msg.append(vehiclecertificaterecordno);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRIssueEquipmentCertificateException(msg.toString());
	}

	/**
	 * Returns the first vr issue equipment certificate in the ordered set where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	 *
	 * @param applicantNo the applicant no
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate fetchByApplicantNo_CertificateRecordNo_First(
		String applicantNo, String vehiclecertificaterecordno,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator) {
		List<VRIssueEquipmentCertificate> list = findByApplicantNo_CertificateRecordNo(applicantNo,
				vehiclecertificaterecordno, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr issue equipment certificate in the ordered set where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	 *
	 * @param applicantNo the applicant no
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate findByApplicantNo_CertificateRecordNo_Last(
		String applicantNo, String vehiclecertificaterecordno,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = fetchByApplicantNo_CertificateRecordNo_Last(applicantNo,
				vehiclecertificaterecordno, orderByComparator);

		if (vrIssueEquipmentCertificate != null) {
			return vrIssueEquipmentCertificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantNo=");
		msg.append(applicantNo);

		msg.append(", vehiclecertificaterecordno=");
		msg.append(vehiclecertificaterecordno);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRIssueEquipmentCertificateException(msg.toString());
	}

	/**
	 * Returns the last vr issue equipment certificate in the ordered set where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	 *
	 * @param applicantNo the applicant no
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate fetchByApplicantNo_CertificateRecordNo_Last(
		String applicantNo, String vehiclecertificaterecordno,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator) {
		int count = countByApplicantNo_CertificateRecordNo(applicantNo,
				vehiclecertificaterecordno);

		if (count == 0) {
			return null;
		}

		List<VRIssueEquipmentCertificate> list = findByApplicantNo_CertificateRecordNo(applicantNo,
				vehiclecertificaterecordno, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr issue equipment certificates before and after the current vr issue equipment certificate in the ordered set where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	 *
	 * @param id the primary key of the current vr issue equipment certificate
	 * @param applicantNo the applicant no
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a vr issue equipment certificate with the primary key could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate[] findByApplicantNo_CertificateRecordNo_PrevAndNext(
		long id, String applicantNo, String vehiclecertificaterecordno,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRIssueEquipmentCertificate[] array = new VRIssueEquipmentCertificateImpl[3];

			array[0] = getByApplicantNo_CertificateRecordNo_PrevAndNext(session,
					vrIssueEquipmentCertificate, applicantNo,
					vehiclecertificaterecordno, orderByComparator, true);

			array[1] = vrIssueEquipmentCertificate;

			array[2] = getByApplicantNo_CertificateRecordNo_PrevAndNext(session,
					vrIssueEquipmentCertificate, applicantNo,
					vehiclecertificaterecordno, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VRIssueEquipmentCertificate getByApplicantNo_CertificateRecordNo_PrevAndNext(
		Session session,
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate,
		String applicantNo, String vehiclecertificaterecordno,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
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

		query.append(_SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE_WHERE);

		boolean bindApplicantNo = false;

		if (applicantNo == null) {
			query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_APPLICANTNO_1);
		}
		else if (applicantNo.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_APPLICANTNO_3);
		}
		else {
			bindApplicantNo = true;

			query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_APPLICANTNO_2);
		}

		boolean bindVehiclecertificaterecordno = false;

		if (vehiclecertificaterecordno == null) {
			query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_1);
		}
		else if (vehiclecertificaterecordno.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_3);
		}
		else {
			bindVehiclecertificaterecordno = true;

			query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_2);
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
			query.append(VRIssueEquipmentCertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindApplicantNo) {
			qPos.add(applicantNo);
		}

		if (bindVehiclecertificaterecordno) {
			qPos.add(vehiclecertificaterecordno);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrIssueEquipmentCertificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRIssueEquipmentCertificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr issue equipment certificates where applicantNo = &#63; and vehiclecertificaterecordno = &#63; from the database.
	 *
	 * @param applicantNo the applicant no
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 */
	@Override
	public void removeByApplicantNo_CertificateRecordNo(String applicantNo,
		String vehiclecertificaterecordno) {
		for (VRIssueEquipmentCertificate vrIssueEquipmentCertificate : findByApplicantNo_CertificateRecordNo(
				applicantNo, vehiclecertificaterecordno, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vrIssueEquipmentCertificate);
		}
	}

	/**
	 * Returns the number of vr issue equipment certificates where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	 *
	 * @param applicantNo the applicant no
	 * @param vehiclecertificaterecordno the vehiclecertificaterecordno
	 * @return the number of matching vr issue equipment certificates
	 */
	@Override
	public int countByApplicantNo_CertificateRecordNo(String applicantNo,
		String vehiclecertificaterecordno) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICANTNO_CERTIFICATERECORDNO;

		Object[] finderArgs = new Object[] {
				applicantNo, vehiclecertificaterecordno
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VRISSUEEQUIPMENTCERTIFICATE_WHERE);

			boolean bindApplicantNo = false;

			if (applicantNo == null) {
				query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_APPLICANTNO_1);
			}
			else if (applicantNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_APPLICANTNO_3);
			}
			else {
				bindApplicantNo = true;

				query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_APPLICANTNO_2);
			}

			boolean bindVehiclecertificaterecordno = false;

			if (vehiclecertificaterecordno == null) {
				query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_1);
			}
			else if (vehiclecertificaterecordno.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_3);
			}
			else {
				bindVehiclecertificaterecordno = true;

				query.append(_FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicantNo) {
					qPos.add(applicantNo);
				}

				if (bindVehiclecertificaterecordno) {
					qPos.add(vehiclecertificaterecordno);
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

	private static final String _FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_APPLICANTNO_1 =
		"vrIssueEquipmentCertificate.applicantNo IS NULL AND ";
	private static final String _FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_APPLICANTNO_2 =
		"vrIssueEquipmentCertificate.applicantNo = ? AND ";
	private static final String _FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_APPLICANTNO_3 =
		"(vrIssueEquipmentCertificate.applicantNo IS NULL OR vrIssueEquipmentCertificate.applicantNo = '') AND ";
	private static final String _FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_1 =
		"vrIssueEquipmentCertificate.vehiclecertificaterecordno IS NULL";
	private static final String _FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_2 =
		"vrIssueEquipmentCertificate.vehiclecertificaterecordno = ?";
	private static final String _FINDER_COLUMN_APPLICANTNO_CERTIFICATERECORDNO_VEHICLECERTIFICATERECORDNO_3 =
		"(vrIssueEquipmentCertificate.vehiclecertificaterecordno IS NULL OR vrIssueEquipmentCertificate.vehiclecertificaterecordno = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTNO =
		new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			VRIssueEquipmentCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApplicantNo",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTNO =
		new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			VRIssueEquipmentCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByApplicantNo",
			new String[] { String.class.getName() },
			VRIssueEquipmentCertificateModelImpl.APPLICANTNO_COLUMN_BITMASK |
			VRIssueEquipmentCertificateModelImpl.SYNCDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICANTNO = new FinderPath(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicantNo", new String[] { String.class.getName() });

	/**
	 * Returns all the vr issue equipment certificates where applicantNo = &#63;.
	 *
	 * @param applicantNo the applicant no
	 * @return the matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByApplicantNo(
		String applicantNo) {
		return findByApplicantNo(applicantNo, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr issue equipment certificates where applicantNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantNo the applicant no
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @return the range of matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByApplicantNo(
		String applicantNo, int start, int end) {
		return findByApplicantNo(applicantNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr issue equipment certificates where applicantNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantNo the applicant no
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByApplicantNo(
		String applicantNo, int start, int end,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator) {
		return findByApplicantNo(applicantNo, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the vr issue equipment certificates where applicantNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantNo the applicant no
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findByApplicantNo(
		String applicantNo, int start, int end,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTNO;
			finderArgs = new Object[] { applicantNo };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTNO;
			finderArgs = new Object[] { applicantNo, start, end, orderByComparator };
		}

		List<VRIssueEquipmentCertificate> list = null;

		if (retrieveFromCache) {
			list = (List<VRIssueEquipmentCertificate>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VRIssueEquipmentCertificate vrIssueEquipmentCertificate : list) {
					if (!Objects.equals(applicantNo,
								vrIssueEquipmentCertificate.getApplicantNo())) {
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

			query.append(_SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE_WHERE);

			boolean bindApplicantNo = false;

			if (applicantNo == null) {
				query.append(_FINDER_COLUMN_APPLICANTNO_APPLICANTNO_1);
			}
			else if (applicantNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTNO_APPLICANTNO_3);
			}
			else {
				bindApplicantNo = true;

				query.append(_FINDER_COLUMN_APPLICANTNO_APPLICANTNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VRIssueEquipmentCertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicantNo) {
					qPos.add(applicantNo);
				}

				if (!pagination) {
					list = (List<VRIssueEquipmentCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRIssueEquipmentCertificate>)QueryUtil.list(q,
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
	 * Returns the first vr issue equipment certificate in the ordered set where applicantNo = &#63;.
	 *
	 * @param applicantNo the applicant no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate findByApplicantNo_First(
		String applicantNo,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = fetchByApplicantNo_First(applicantNo,
				orderByComparator);

		if (vrIssueEquipmentCertificate != null) {
			return vrIssueEquipmentCertificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantNo=");
		msg.append(applicantNo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRIssueEquipmentCertificateException(msg.toString());
	}

	/**
	 * Returns the first vr issue equipment certificate in the ordered set where applicantNo = &#63;.
	 *
	 * @param applicantNo the applicant no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate fetchByApplicantNo_First(
		String applicantNo,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator) {
		List<VRIssueEquipmentCertificate> list = findByApplicantNo(applicantNo,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vr issue equipment certificate in the ordered set where applicantNo = &#63;.
	 *
	 * @param applicantNo the applicant no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate findByApplicantNo_Last(
		String applicantNo,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = fetchByApplicantNo_Last(applicantNo,
				orderByComparator);

		if (vrIssueEquipmentCertificate != null) {
			return vrIssueEquipmentCertificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantNo=");
		msg.append(applicantNo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVRIssueEquipmentCertificateException(msg.toString());
	}

	/**
	 * Returns the last vr issue equipment certificate in the ordered set where applicantNo = &#63;.
	 *
	 * @param applicantNo the applicant no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate fetchByApplicantNo_Last(
		String applicantNo,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator) {
		int count = countByApplicantNo(applicantNo);

		if (count == 0) {
			return null;
		}

		List<VRIssueEquipmentCertificate> list = findByApplicantNo(applicantNo,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vr issue equipment certificates before and after the current vr issue equipment certificate in the ordered set where applicantNo = &#63;.
	 *
	 * @param id the primary key of the current vr issue equipment certificate
	 * @param applicantNo the applicant no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a vr issue equipment certificate with the primary key could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate[] findByApplicantNo_PrevAndNext(
		long id, String applicantNo,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			VRIssueEquipmentCertificate[] array = new VRIssueEquipmentCertificateImpl[3];

			array[0] = getByApplicantNo_PrevAndNext(session,
					vrIssueEquipmentCertificate, applicantNo,
					orderByComparator, true);

			array[1] = vrIssueEquipmentCertificate;

			array[2] = getByApplicantNo_PrevAndNext(session,
					vrIssueEquipmentCertificate, applicantNo,
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

	protected VRIssueEquipmentCertificate getByApplicantNo_PrevAndNext(
		Session session,
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate,
		String applicantNo,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
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

		query.append(_SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE_WHERE);

		boolean bindApplicantNo = false;

		if (applicantNo == null) {
			query.append(_FINDER_COLUMN_APPLICANTNO_APPLICANTNO_1);
		}
		else if (applicantNo.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPLICANTNO_APPLICANTNO_3);
		}
		else {
			bindApplicantNo = true;

			query.append(_FINDER_COLUMN_APPLICANTNO_APPLICANTNO_2);
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
			query.append(VRIssueEquipmentCertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindApplicantNo) {
			qPos.add(applicantNo);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vrIssueEquipmentCertificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VRIssueEquipmentCertificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vr issue equipment certificates where applicantNo = &#63; from the database.
	 *
	 * @param applicantNo the applicant no
	 */
	@Override
	public void removeByApplicantNo(String applicantNo) {
		for (VRIssueEquipmentCertificate vrIssueEquipmentCertificate : findByApplicantNo(
				applicantNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vrIssueEquipmentCertificate);
		}
	}

	/**
	 * Returns the number of vr issue equipment certificates where applicantNo = &#63;.
	 *
	 * @param applicantNo the applicant no
	 * @return the number of matching vr issue equipment certificates
	 */
	@Override
	public int countByApplicantNo(String applicantNo) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICANTNO;

		Object[] finderArgs = new Object[] { applicantNo };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VRISSUEEQUIPMENTCERTIFICATE_WHERE);

			boolean bindApplicantNo = false;

			if (applicantNo == null) {
				query.append(_FINDER_COLUMN_APPLICANTNO_APPLICANTNO_1);
			}
			else if (applicantNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTNO_APPLICANTNO_3);
			}
			else {
				bindApplicantNo = true;

				query.append(_FINDER_COLUMN_APPLICANTNO_APPLICANTNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicantNo) {
					qPos.add(applicantNo);
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

	private static final String _FINDER_COLUMN_APPLICANTNO_APPLICANTNO_1 = "vrIssueEquipmentCertificate.applicantNo IS NULL";
	private static final String _FINDER_COLUMN_APPLICANTNO_APPLICANTNO_2 = "vrIssueEquipmentCertificate.applicantNo = ?";
	private static final String _FINDER_COLUMN_APPLICANTNO_APPLICANTNO_3 = "(vrIssueEquipmentCertificate.applicantNo IS NULL OR vrIssueEquipmentCertificate.applicantNo = '')";

	public VRIssueEquipmentCertificatePersistenceImpl() {
		setModelClass(VRIssueEquipmentCertificate.class);
	}

	/**
	 * Caches the vr issue equipment certificate in the entity cache if it is enabled.
	 *
	 * @param vrIssueEquipmentCertificate the vr issue equipment certificate
	 */
	@Override
	public void cacheResult(
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate) {
		entityCache.putResult(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateImpl.class,
			vrIssueEquipmentCertificate.getPrimaryKey(),
			vrIssueEquipmentCertificate);

		vrIssueEquipmentCertificate.resetOriginalValues();
	}

	/**
	 * Caches the vr issue equipment certificates in the entity cache if it is enabled.
	 *
	 * @param vrIssueEquipmentCertificates the vr issue equipment certificates
	 */
	@Override
	public void cacheResult(
		List<VRIssueEquipmentCertificate> vrIssueEquipmentCertificates) {
		for (VRIssueEquipmentCertificate vrIssueEquipmentCertificate : vrIssueEquipmentCertificates) {
			if (entityCache.getResult(
						VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
						VRIssueEquipmentCertificateImpl.class,
						vrIssueEquipmentCertificate.getPrimaryKey()) == null) {
				cacheResult(vrIssueEquipmentCertificate);
			}
			else {
				vrIssueEquipmentCertificate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vr issue equipment certificates.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VRIssueEquipmentCertificateImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vr issue equipment certificate.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate) {
		entityCache.removeResult(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateImpl.class,
			vrIssueEquipmentCertificate.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<VRIssueEquipmentCertificate> vrIssueEquipmentCertificates) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VRIssueEquipmentCertificate vrIssueEquipmentCertificate : vrIssueEquipmentCertificates) {
			entityCache.removeResult(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
				VRIssueEquipmentCertificateImpl.class,
				vrIssueEquipmentCertificate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vr issue equipment certificate with the primary key. Does not add the vr issue equipment certificate to the database.
	 *
	 * @param id the primary key for the new vr issue equipment certificate
	 * @return the new vr issue equipment certificate
	 */
	@Override
	public VRIssueEquipmentCertificate create(long id) {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = new VRIssueEquipmentCertificateImpl();

		vrIssueEquipmentCertificate.setNew(true);
		vrIssueEquipmentCertificate.setPrimaryKey(id);

		return vrIssueEquipmentCertificate;
	}

	/**
	 * Removes the vr issue equipment certificate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vr issue equipment certificate
	 * @return the vr issue equipment certificate that was removed
	 * @throws NoSuchVRIssueEquipmentCertificateException if a vr issue equipment certificate with the primary key could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate remove(long id)
		throws NoSuchVRIssueEquipmentCertificateException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the vr issue equipment certificate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vr issue equipment certificate
	 * @return the vr issue equipment certificate that was removed
	 * @throws NoSuchVRIssueEquipmentCertificateException if a vr issue equipment certificate with the primary key could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate remove(Serializable primaryKey)
		throws NoSuchVRIssueEquipmentCertificateException {
		Session session = null;

		try {
			session = openSession();

			VRIssueEquipmentCertificate vrIssueEquipmentCertificate = (VRIssueEquipmentCertificate)session.get(VRIssueEquipmentCertificateImpl.class,
					primaryKey);

			if (vrIssueEquipmentCertificate == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVRIssueEquipmentCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vrIssueEquipmentCertificate);
		}
		catch (NoSuchVRIssueEquipmentCertificateException nsee) {
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
	protected VRIssueEquipmentCertificate removeImpl(
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate) {
		vrIssueEquipmentCertificate = toUnwrappedModel(vrIssueEquipmentCertificate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vrIssueEquipmentCertificate)) {
				vrIssueEquipmentCertificate = (VRIssueEquipmentCertificate)session.get(VRIssueEquipmentCertificateImpl.class,
						vrIssueEquipmentCertificate.getPrimaryKeyObj());
			}

			if (vrIssueEquipmentCertificate != null) {
				session.delete(vrIssueEquipmentCertificate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vrIssueEquipmentCertificate != null) {
			clearCache(vrIssueEquipmentCertificate);
		}

		return vrIssueEquipmentCertificate;
	}

	@Override
	public VRIssueEquipmentCertificate updateImpl(
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate) {
		vrIssueEquipmentCertificate = toUnwrappedModel(vrIssueEquipmentCertificate);

		boolean isNew = vrIssueEquipmentCertificate.isNew();

		VRIssueEquipmentCertificateModelImpl vrIssueEquipmentCertificateModelImpl =
			(VRIssueEquipmentCertificateModelImpl)vrIssueEquipmentCertificate;

		Session session = null;

		try {
			session = openSession();

			if (vrIssueEquipmentCertificate.isNew()) {
				session.save(vrIssueEquipmentCertificate);

				vrIssueEquipmentCertificate.setNew(false);
			}
			else {
				vrIssueEquipmentCertificate = (VRIssueEquipmentCertificate)session.merge(vrIssueEquipmentCertificate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!VRIssueEquipmentCertificateModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vrIssueEquipmentCertificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUEVEHICLECERTIFICATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrIssueEquipmentCertificateModelImpl.getOriginalIssueVehicleCertificateId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ISSUEVEHICLECERTIFICATEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUEVEHICLECERTIFICATEID,
					args);

				args = new Object[] {
						vrIssueEquipmentCertificateModelImpl.getIssueVehicleCertificateId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ISSUEVEHICLECERTIFICATEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUEVEHICLECERTIFICATEID,
					args);
			}

			if ((vrIssueEquipmentCertificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLECERTIFICATERECORDNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrIssueEquipmentCertificateModelImpl.getOriginalVehiclecertificaterecordno()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VEHICLECERTIFICATERECORDNO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLECERTIFICATERECORDNO,
					args);

				args = new Object[] {
						vrIssueEquipmentCertificateModelImpl.getVehiclecertificaterecordno()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VEHICLECERTIFICATERECORDNO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VEHICLECERTIFICATERECORDNO,
					args);
			}

			if ((vrIssueEquipmentCertificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTNO_CERTIFICATERECORDNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrIssueEquipmentCertificateModelImpl.getOriginalApplicantNo(),
						vrIssueEquipmentCertificateModelImpl.getOriginalVehiclecertificaterecordno()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTNO_CERTIFICATERECORDNO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTNO_CERTIFICATERECORDNO,
					args);

				args = new Object[] {
						vrIssueEquipmentCertificateModelImpl.getApplicantNo(),
						vrIssueEquipmentCertificateModelImpl.getVehiclecertificaterecordno()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTNO_CERTIFICATERECORDNO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTNO_CERTIFICATERECORDNO,
					args);
			}

			if ((vrIssueEquipmentCertificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vrIssueEquipmentCertificateModelImpl.getOriginalApplicantNo()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTNO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTNO,
					args);

				args = new Object[] {
						vrIssueEquipmentCertificateModelImpl.getApplicantNo()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICANTNO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTNO,
					args);
			}
		}

		entityCache.putResult(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
			VRIssueEquipmentCertificateImpl.class,
			vrIssueEquipmentCertificate.getPrimaryKey(),
			vrIssueEquipmentCertificate, false);

		vrIssueEquipmentCertificate.resetOriginalValues();

		return vrIssueEquipmentCertificate;
	}

	protected VRIssueEquipmentCertificate toUnwrappedModel(
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate) {
		if (vrIssueEquipmentCertificate instanceof VRIssueEquipmentCertificateImpl) {
			return vrIssueEquipmentCertificate;
		}

		VRIssueEquipmentCertificateImpl vrIssueEquipmentCertificateImpl = new VRIssueEquipmentCertificateImpl();

		vrIssueEquipmentCertificateImpl.setNew(vrIssueEquipmentCertificate.isNew());
		vrIssueEquipmentCertificateImpl.setPrimaryKey(vrIssueEquipmentCertificate.getPrimaryKey());

		vrIssueEquipmentCertificateImpl.setId(vrIssueEquipmentCertificate.getId());
		vrIssueEquipmentCertificateImpl.setMtcore(vrIssueEquipmentCertificate.getMtcore());
		vrIssueEquipmentCertificateImpl.setIssueId(vrIssueEquipmentCertificate.getIssueId());
		vrIssueEquipmentCertificateImpl.setIssueVehicleCertificateId(vrIssueEquipmentCertificate.getIssueVehicleCertificateId());
		vrIssueEquipmentCertificateImpl.setVehiclecertificaterecordno(vrIssueEquipmentCertificate.getVehiclecertificaterecordno());
		vrIssueEquipmentCertificateImpl.setEquipmentName(vrIssueEquipmentCertificate.getEquipmentName());
		vrIssueEquipmentCertificateImpl.setEquipmentType(vrIssueEquipmentCertificate.getEquipmentType());
		vrIssueEquipmentCertificateImpl.setEquipmentCertificateType(vrIssueEquipmentCertificate.getEquipmentCertificateType());
		vrIssueEquipmentCertificateImpl.setEquipmentDocumentNo(vrIssueEquipmentCertificate.getEquipmentDocumentNo());
		vrIssueEquipmentCertificateImpl.setEquipmentCertificateRecordNo(vrIssueEquipmentCertificate.getEquipmentCertificateRecordNo());
		vrIssueEquipmentCertificateImpl.setEquipmentExamRecordNo(vrIssueEquipmentCertificate.getEquipmentExamRecordNo());
		vrIssueEquipmentCertificateImpl.setEquipmentCertificateRecordId(vrIssueEquipmentCertificate.getEquipmentCertificateRecordId());
		vrIssueEquipmentCertificateImpl.setTotalQuantity(vrIssueEquipmentCertificate.getTotalQuantity());
		vrIssueEquipmentCertificateImpl.setTotalProductUsed(vrIssueEquipmentCertificate.getTotalProductUsed());
		vrIssueEquipmentCertificateImpl.setTotalInUse(vrIssueEquipmentCertificate.getTotalInUse());
		vrIssueEquipmentCertificateImpl.setTotalNotUsed(vrIssueEquipmentCertificate.getTotalNotUsed());
		vrIssueEquipmentCertificateImpl.setApplicantNo(vrIssueEquipmentCertificate.getApplicantNo());
		vrIssueEquipmentCertificateImpl.setApplicantname(vrIssueEquipmentCertificate.getApplicantname());
		vrIssueEquipmentCertificateImpl.setApplicantaddress(vrIssueEquipmentCertificate.getApplicantaddress());
		vrIssueEquipmentCertificateImpl.setProductionplantname(vrIssueEquipmentCertificate.getProductionplantname());
		vrIssueEquipmentCertificateImpl.setProductionplantaddress(vrIssueEquipmentCertificate.getProductionplantaddress());
		vrIssueEquipmentCertificateImpl.setModifyDate(vrIssueEquipmentCertificate.getModifyDate());
		vrIssueEquipmentCertificateImpl.setSyncDate(vrIssueEquipmentCertificate.getSyncDate());

		return vrIssueEquipmentCertificateImpl;
	}

	/**
	 * Returns the vr issue equipment certificate with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vr issue equipment certificate
	 * @return the vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a vr issue equipment certificate with the primary key could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVRIssueEquipmentCertificateException {
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = fetchByPrimaryKey(primaryKey);

		if (vrIssueEquipmentCertificate == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVRIssueEquipmentCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vrIssueEquipmentCertificate;
	}

	/**
	 * Returns the vr issue equipment certificate with the primary key or throws a {@link NoSuchVRIssueEquipmentCertificateException} if it could not be found.
	 *
	 * @param id the primary key of the vr issue equipment certificate
	 * @return the vr issue equipment certificate
	 * @throws NoSuchVRIssueEquipmentCertificateException if a vr issue equipment certificate with the primary key could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate findByPrimaryKey(long id)
		throws NoSuchVRIssueEquipmentCertificateException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the vr issue equipment certificate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vr issue equipment certificate
	 * @return the vr issue equipment certificate, or <code>null</code> if a vr issue equipment certificate with the primary key could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
				VRIssueEquipmentCertificateImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		VRIssueEquipmentCertificate vrIssueEquipmentCertificate = (VRIssueEquipmentCertificate)serializable;

		if (vrIssueEquipmentCertificate == null) {
			Session session = null;

			try {
				session = openSession();

				vrIssueEquipmentCertificate = (VRIssueEquipmentCertificate)session.get(VRIssueEquipmentCertificateImpl.class,
						primaryKey);

				if (vrIssueEquipmentCertificate != null) {
					cacheResult(vrIssueEquipmentCertificate);
				}
				else {
					entityCache.putResult(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
						VRIssueEquipmentCertificateImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
					VRIssueEquipmentCertificateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vrIssueEquipmentCertificate;
	}

	/**
	 * Returns the vr issue equipment certificate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vr issue equipment certificate
	 * @return the vr issue equipment certificate, or <code>null</code> if a vr issue equipment certificate with the primary key could not be found
	 */
	@Override
	public VRIssueEquipmentCertificate fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, VRIssueEquipmentCertificate> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, VRIssueEquipmentCertificate> map = new HashMap<Serializable, VRIssueEquipmentCertificate>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			VRIssueEquipmentCertificate vrIssueEquipmentCertificate = fetchByPrimaryKey(primaryKey);

			if (vrIssueEquipmentCertificate != null) {
				map.put(primaryKey, vrIssueEquipmentCertificate);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
					VRIssueEquipmentCertificateImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(VRIssueEquipmentCertificate)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE_WHERE_PKS_IN);

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

			for (VRIssueEquipmentCertificate vrIssueEquipmentCertificate : (List<VRIssueEquipmentCertificate>)q.list()) {
				map.put(vrIssueEquipmentCertificate.getPrimaryKeyObj(),
					vrIssueEquipmentCertificate);

				cacheResult(vrIssueEquipmentCertificate);

				uncachedPrimaryKeys.remove(vrIssueEquipmentCertificate.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(VRIssueEquipmentCertificateModelImpl.ENTITY_CACHE_ENABLED,
					VRIssueEquipmentCertificateImpl.class, primaryKey, nullModel);
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
	 * Returns all the vr issue equipment certificates.
	 *
	 * @return the vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vr issue equipment certificates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @return the range of vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vr issue equipment certificates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findAll(int start, int end,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vr issue equipment certificates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VRIssueEquipmentCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vr issue equipment certificates
	 * @param end the upper bound of the range of vr issue equipment certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of vr issue equipment certificates
	 */
	@Override
	public List<VRIssueEquipmentCertificate> findAll(int start, int end,
		OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
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

		List<VRIssueEquipmentCertificate> list = null;

		if (retrieveFromCache) {
			list = (List<VRIssueEquipmentCertificate>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE;

				if (pagination) {
					sql = sql.concat(VRIssueEquipmentCertificateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VRIssueEquipmentCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<VRIssueEquipmentCertificate>)QueryUtil.list(q,
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
	 * Removes all the vr issue equipment certificates from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VRIssueEquipmentCertificate vrIssueEquipmentCertificate : findAll()) {
			remove(vrIssueEquipmentCertificate);
		}
	}

	/**
	 * Returns the number of vr issue equipment certificates.
	 *
	 * @return the number of vr issue equipment certificates
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VRISSUEEQUIPMENTCERTIFICATE);

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
		return VRIssueEquipmentCertificateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vr issue equipment certificate persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(VRIssueEquipmentCertificateImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE = "SELECT vrIssueEquipmentCertificate FROM VRIssueEquipmentCertificate vrIssueEquipmentCertificate";
	private static final String _SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE_WHERE_PKS_IN =
		"SELECT vrIssueEquipmentCertificate FROM VRIssueEquipmentCertificate vrIssueEquipmentCertificate WHERE id IN (";
	private static final String _SQL_SELECT_VRISSUEEQUIPMENTCERTIFICATE_WHERE = "SELECT vrIssueEquipmentCertificate FROM VRIssueEquipmentCertificate vrIssueEquipmentCertificate WHERE ";
	private static final String _SQL_COUNT_VRISSUEEQUIPMENTCERTIFICATE = "SELECT COUNT(vrIssueEquipmentCertificate) FROM VRIssueEquipmentCertificate vrIssueEquipmentCertificate";
	private static final String _SQL_COUNT_VRISSUEEQUIPMENTCERTIFICATE_WHERE = "SELECT COUNT(vrIssueEquipmentCertificate) FROM VRIssueEquipmentCertificate vrIssueEquipmentCertificate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vrIssueEquipmentCertificate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VRIssueEquipmentCertificate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VRIssueEquipmentCertificate exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(VRIssueEquipmentCertificatePersistenceImpl.class);
}