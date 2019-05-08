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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for VRCOPProductionPlantEmployee. This utility wraps
 * {@link com.fds.vr.business.service.impl.VRCOPProductionPlantEmployeeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author LamTV
 * @see VRCOPProductionPlantEmployeeLocalService
 * @see com.fds.vr.business.service.base.VRCOPProductionPlantEmployeeLocalServiceBaseImpl
 * @see com.fds.vr.business.service.impl.VRCOPProductionPlantEmployeeLocalServiceImpl
 * @generated
 */
@ProviderType
public class VRCOPProductionPlantEmployeeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.fds.vr.business.service.impl.VRCOPProductionPlantEmployeeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the vrcop production plant employee to the database. Also notifies the appropriate model listeners.
	*
	* @param vrcopProductionPlantEmployee the vrcop production plant employee
	* @return the vrcop production plant employee that was added
	*/
	public static com.fds.vr.business.model.VRCOPProductionPlantEmployee addVRCOPProductionPlantEmployee(
		com.fds.vr.business.model.VRCOPProductionPlantEmployee vrcopProductionPlantEmployee) {
		return getService()
				   .addVRCOPProductionPlantEmployee(vrcopProductionPlantEmployee);
	}

	/**
	* Creates a new vrcop production plant employee with the primary key. Does not add the vrcop production plant employee to the database.
	*
	* @param id the primary key for the new vrcop production plant employee
	* @return the new vrcop production plant employee
	*/
	public static com.fds.vr.business.model.VRCOPProductionPlantEmployee createVRCOPProductionPlantEmployee(
		long id) {
		return getService().createVRCOPProductionPlantEmployee(id);
	}

	/**
	* Deletes the vrcop production plant employee from the database. Also notifies the appropriate model listeners.
	*
	* @param vrcopProductionPlantEmployee the vrcop production plant employee
	* @return the vrcop production plant employee that was removed
	*/
	public static com.fds.vr.business.model.VRCOPProductionPlantEmployee deleteVRCOPProductionPlantEmployee(
		com.fds.vr.business.model.VRCOPProductionPlantEmployee vrcopProductionPlantEmployee) {
		return getService()
				   .deleteVRCOPProductionPlantEmployee(vrcopProductionPlantEmployee);
	}

	/**
	* Deletes the vrcop production plant employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the vrcop production plant employee
	* @return the vrcop production plant employee that was removed
	* @throws PortalException if a vrcop production plant employee with the primary key could not be found
	*/
	public static com.fds.vr.business.model.VRCOPProductionPlantEmployee deleteVRCOPProductionPlantEmployee(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteVRCOPProductionPlantEmployee(id);
	}

	public static com.fds.vr.business.model.VRCOPProductionPlantEmployee fetchVRCOPProductionPlantEmployee(
		long id) {
		return getService().fetchVRCOPProductionPlantEmployee(id);
	}

	/**
	* Returns the vrcop production plant employee with the primary key.
	*
	* @param id the primary key of the vrcop production plant employee
	* @return the vrcop production plant employee
	* @throws PortalException if a vrcop production plant employee with the primary key could not be found
	*/
	public static com.fds.vr.business.model.VRCOPProductionPlantEmployee getVRCOPProductionPlantEmployee(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getVRCOPProductionPlantEmployee(id);
	}

	/**
	* Updates the vrcop production plant employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vrcopProductionPlantEmployee the vrcop production plant employee
	* @return the vrcop production plant employee that was updated
	*/
	public static com.fds.vr.business.model.VRCOPProductionPlantEmployee updateVRCOPProductionPlantEmployee(
		com.fds.vr.business.model.VRCOPProductionPlantEmployee vrcopProductionPlantEmployee) {
		return getService()
				   .updateVRCOPProductionPlantEmployee(vrcopProductionPlantEmployee);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of vrcop production plant employees.
	*
	* @return the number of vrcop production plant employees
	*/
	public static int getVRCOPProductionPlantEmployeesCount() {
		return getService().getVRCOPProductionPlantEmployeesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRCOPProductionPlantEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRCOPProductionPlantEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.fds.vr.business.model.VRCOPProductionPlantEmployee> findBycopReportNo(
		long mtCore, java.lang.String copReportNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findBycopReportNo(mtCore, copReportNo);
	}

	public static java.util.List<com.fds.vr.business.model.VRCOPProductionPlantEmployee> findBycopReportRepositoryID(
		long mtCore, long copReportRepositoryID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findBycopReportRepositoryID(mtCore, copReportRepositoryID);
	}

	/**
	* Returns a range of all the vrcop production plant employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRCOPProductionPlantEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vrcop production plant employees
	* @param end the upper bound of the range of vrcop production plant employees (not inclusive)
	* @return the range of vrcop production plant employees
	*/
	public static java.util.List<com.fds.vr.business.model.VRCOPProductionPlantEmployee> getVRCOPProductionPlantEmployees(
		int start, int end) {
		return getService().getVRCOPProductionPlantEmployees(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static VRCOPProductionPlantEmployeeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VRCOPProductionPlantEmployeeLocalService, VRCOPProductionPlantEmployeeLocalService> _serviceTracker =
		ServiceTrackerFactory.open(VRCOPProductionPlantEmployeeLocalService.class);
}