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

package com.fds.vr.business.service;

import aQute.bnd.annotation.ProviderType;

import com.fds.vr.business.model.VRApplicantProfileHistory;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for VRApplicantProfileHistory. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author LamTV
 * @see VRApplicantProfileHistoryLocalServiceUtil
 * @see com.fds.vr.business.service.base.VRApplicantProfileHistoryLocalServiceBaseImpl
 * @see com.fds.vr.business.service.impl.VRApplicantProfileHistoryLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VRApplicantProfileHistoryLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VRApplicantProfileHistoryLocalServiceUtil} to access the vr applicant profile history local service. Add custom service methods to {@link com.fds.vr.business.service.impl.VRApplicantProfileHistoryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the vr applicant profile history to the database. Also notifies the appropriate model listeners.
	*
	* @param vrApplicantProfileHistory the vr applicant profile history
	* @return the vr applicant profile history that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public VRApplicantProfileHistory addVRApplicantProfileHistory(
		VRApplicantProfileHistory vrApplicantProfileHistory);

	/**
	* Creates a new vr applicant profile history with the primary key. Does not add the vr applicant profile history to the database.
	*
	* @param id the primary key for the new vr applicant profile history
	* @return the new vr applicant profile history
	*/
	public VRApplicantProfileHistory createVRApplicantProfileHistory(long id);

	/**
	* Deletes the vr applicant profile history from the database. Also notifies the appropriate model listeners.
	*
	* @param vrApplicantProfileHistory the vr applicant profile history
	* @return the vr applicant profile history that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public VRApplicantProfileHistory deleteVRApplicantProfileHistory(
		VRApplicantProfileHistory vrApplicantProfileHistory);

	/**
	* Deletes the vr applicant profile history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the vr applicant profile history
	* @return the vr applicant profile history that was removed
	* @throws PortalException if a vr applicant profile history with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public VRApplicantProfileHistory deleteVRApplicantProfileHistory(long id)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public VRApplicantProfileHistory fetchVRApplicantProfileHistory(long id);

	/**
	* Returns the vr applicant profile history with the primary key.
	*
	* @param id the primary key of the vr applicant profile history
	* @return the vr applicant profile history
	* @throws PortalException if a vr applicant profile history with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public VRApplicantProfileHistory getVRApplicantProfileHistory(long id)
		throws PortalException;

	/**
	* Updates the vr applicant profile history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vrApplicantProfileHistory the vr applicant profile history
	* @return the vr applicant profile history that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public VRApplicantProfileHistory updateVRApplicantProfileHistory(
		VRApplicantProfileHistory vrApplicantProfileHistory);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of vr applicant profile histories.
	*
	* @return the number of vr applicant profile histories
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVRApplicantProfileHistoriesCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRApplicantProfileHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRApplicantProfileHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	public List<VRApplicantProfileHistory> findByapplicantCity(long mtCore,
		java.lang.String applicantCity) throws SystemException;

	public List<VRApplicantProfileHistory> findByapplicantCode(long mtCore,
		java.lang.String applicantCode) throws SystemException;

	public List<VRApplicantProfileHistory> findByapplicantRegion(long mtCore,
		java.lang.String applicantRegion) throws SystemException;

	public List<VRApplicantProfileHistory> findByapplicantStatus(long mtCore,
		java.lang.String applicantStatus) throws SystemException;

	public List<VRApplicantProfileHistory> findBymappingMA_CTY(long mtCore,
		java.lang.String mappingMA_CTY) throws SystemException;

	public List<VRApplicantProfileHistory> findBymappingStatus(long mtCore,
		java.lang.String mappingStatus) throws SystemException;

	public List<VRApplicantProfileHistory> findBymappingTEN_CTY(long mtCore,
		java.lang.String mappingTEN_CTY) throws SystemException;

	/**
	* Returns a range of all the vr applicant profile histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRApplicantProfileHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vr applicant profile histories
	* @param end the upper bound of the range of vr applicant profile histories (not inclusive)
	* @return the range of vr applicant profile histories
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<VRApplicantProfileHistory> getVRApplicantProfileHistories(
		int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}