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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VRCOPProductionPlantEquipmentLocalService}.
 *
 * @author LamTV
 * @see VRCOPProductionPlantEquipmentLocalService
 * @generated
 */
@ProviderType
public class VRCOPProductionPlantEquipmentLocalServiceWrapper
	implements VRCOPProductionPlantEquipmentLocalService,
		ServiceWrapper<VRCOPProductionPlantEquipmentLocalService> {
	public VRCOPProductionPlantEquipmentLocalServiceWrapper(
		VRCOPProductionPlantEquipmentLocalService vrcopProductionPlantEquipmentLocalService) {
		_vrcopProductionPlantEquipmentLocalService = vrcopProductionPlantEquipmentLocalService;
	}

	/**
	* Adds the vrcop production plant equipment to the database. Also notifies the appropriate model listeners.
	*
	* @param vrcopProductionPlantEquipment the vrcop production plant equipment
	* @return the vrcop production plant equipment that was added
	*/
	@Override
	public com.fds.vr.business.model.VRCOPProductionPlantEquipment addVRCOPProductionPlantEquipment(
		com.fds.vr.business.model.VRCOPProductionPlantEquipment vrcopProductionPlantEquipment) {
		return _vrcopProductionPlantEquipmentLocalService.addVRCOPProductionPlantEquipment(vrcopProductionPlantEquipment);
	}

	/**
	* Creates a new vrcop production plant equipment with the primary key. Does not add the vrcop production plant equipment to the database.
	*
	* @param id the primary key for the new vrcop production plant equipment
	* @return the new vrcop production plant equipment
	*/
	@Override
	public com.fds.vr.business.model.VRCOPProductionPlantEquipment createVRCOPProductionPlantEquipment(
		long id) {
		return _vrcopProductionPlantEquipmentLocalService.createVRCOPProductionPlantEquipment(id);
	}

	/**
	* Deletes the vrcop production plant equipment from the database. Also notifies the appropriate model listeners.
	*
	* @param vrcopProductionPlantEquipment the vrcop production plant equipment
	* @return the vrcop production plant equipment that was removed
	*/
	@Override
	public com.fds.vr.business.model.VRCOPProductionPlantEquipment deleteVRCOPProductionPlantEquipment(
		com.fds.vr.business.model.VRCOPProductionPlantEquipment vrcopProductionPlantEquipment) {
		return _vrcopProductionPlantEquipmentLocalService.deleteVRCOPProductionPlantEquipment(vrcopProductionPlantEquipment);
	}

	/**
	* Deletes the vrcop production plant equipment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the vrcop production plant equipment
	* @return the vrcop production plant equipment that was removed
	* @throws PortalException if a vrcop production plant equipment with the primary key could not be found
	*/
	@Override
	public com.fds.vr.business.model.VRCOPProductionPlantEquipment deleteVRCOPProductionPlantEquipment(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _vrcopProductionPlantEquipmentLocalService.deleteVRCOPProductionPlantEquipment(id);
	}

	@Override
	public com.fds.vr.business.model.VRCOPProductionPlantEquipment fetchVRCOPProductionPlantEquipment(
		long id) {
		return _vrcopProductionPlantEquipmentLocalService.fetchVRCOPProductionPlantEquipment(id);
	}

	/**
	* Returns the vrcop production plant equipment with the primary key.
	*
	* @param id the primary key of the vrcop production plant equipment
	* @return the vrcop production plant equipment
	* @throws PortalException if a vrcop production plant equipment with the primary key could not be found
	*/
	@Override
	public com.fds.vr.business.model.VRCOPProductionPlantEquipment getVRCOPProductionPlantEquipment(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _vrcopProductionPlantEquipmentLocalService.getVRCOPProductionPlantEquipment(id);
	}

	@Override
	public com.fds.vr.business.model.VRCOPProductionPlantEquipment updateCOPProductionPlantEquipment(
		java.util.LinkedHashMap<java.lang.String, java.lang.String> mapValues) {
		return _vrcopProductionPlantEquipmentLocalService.updateCOPProductionPlantEquipment(mapValues);
	}

	/**
	* Updates the vrcop production plant equipment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vrcopProductionPlantEquipment the vrcop production plant equipment
	* @return the vrcop production plant equipment that was updated
	*/
	@Override
	public com.fds.vr.business.model.VRCOPProductionPlantEquipment updateVRCOPProductionPlantEquipment(
		com.fds.vr.business.model.VRCOPProductionPlantEquipment vrcopProductionPlantEquipment) {
		return _vrcopProductionPlantEquipmentLocalService.updateVRCOPProductionPlantEquipment(vrcopProductionPlantEquipment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _vrcopProductionPlantEquipmentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vrcopProductionPlantEquipmentLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _vrcopProductionPlantEquipmentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _vrcopProductionPlantEquipmentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _vrcopProductionPlantEquipmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of vrcop production plant equipments.
	*
	* @return the number of vrcop production plant equipments
	*/
	@Override
	public int getVRCOPProductionPlantEquipmentsCount() {
		return _vrcopProductionPlantEquipmentLocalService.getVRCOPProductionPlantEquipmentsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _vrcopProductionPlantEquipmentLocalService.getOSGiServiceIdentifier();
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
		return _vrcopProductionPlantEquipmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRCOPProductionPlantEquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vrcopProductionPlantEquipmentLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRCOPProductionPlantEquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vrcopProductionPlantEquipmentLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.fds.vr.business.model.VRCOPProductionPlantEquipment> findBycopReportNo(
		long mtCore, java.lang.String copReportNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vrcopProductionPlantEquipmentLocalService.findBycopReportNo(mtCore,
			copReportNo);
	}

	@Override
	public java.util.List<com.fds.vr.business.model.VRCOPProductionPlantEquipment> findBycopReportRepositoryID(
		long mtCore, long copReportRepositoryID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vrcopProductionPlantEquipmentLocalService.findBycopReportRepositoryID(mtCore,
			copReportRepositoryID);
	}

	/**
	* Returns a range of all the vrcop production plant equipments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fds.vr.business.model.impl.VRCOPProductionPlantEquipmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vrcop production plant equipments
	* @param end the upper bound of the range of vrcop production plant equipments (not inclusive)
	* @return the range of vrcop production plant equipments
	*/
	@Override
	public java.util.List<com.fds.vr.business.model.VRCOPProductionPlantEquipment> getVRCOPProductionPlantEquipments(
		int start, int end) {
		return _vrcopProductionPlantEquipmentLocalService.getVRCOPProductionPlantEquipments(start,
			end);
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
		return _vrcopProductionPlantEquipmentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vrcopProductionPlantEquipmentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public VRCOPProductionPlantEquipmentLocalService getWrappedService() {
		return _vrcopProductionPlantEquipmentLocalService;
	}

	@Override
	public void setWrappedService(
		VRCOPProductionPlantEquipmentLocalService vrcopProductionPlantEquipmentLocalService) {
		_vrcopProductionPlantEquipmentLocalService = vrcopProductionPlantEquipmentLocalService;
	}

	private VRCOPProductionPlantEquipmentLocalService _vrcopProductionPlantEquipmentLocalService;
}