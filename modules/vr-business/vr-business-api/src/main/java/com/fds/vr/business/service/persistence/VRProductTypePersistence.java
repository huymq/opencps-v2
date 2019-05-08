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

package com.fds.vr.business.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.fds.vr.business.exception.NoSuchVRProductTypeException;
import com.fds.vr.business.model.VRProductType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the vr product type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LamTV
 * @see com.fds.vr.business.service.persistence.impl.VRProductTypePersistenceImpl
 * @see VRProductTypeUtil
 * @generated
 */
@ProviderType
public interface VRProductTypePersistence extends BasePersistence<VRProductType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VRProductTypeUtil} to access the vr product type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the vr product types where mtCore = &#63; and productPlantID = &#63;.
	*
	* @param mtCore the mt core
	* @param productPlantID the product plant ID
	* @return the matching vr product types
	*/
	public java.util.List<VRProductType> findByproductPlantID(long mtCore,
		long productPlantID);

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
	public java.util.List<VRProductType> findByproductPlantID(long mtCore,
		long productPlantID, int start, int end);

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
	public java.util.List<VRProductType> findByproductPlantID(long mtCore,
		long productPlantID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRProductType> orderByComparator);

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
	public java.util.List<VRProductType> findByproductPlantID(long mtCore,
		long productPlantID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRProductType> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first vr product type in the ordered set where mtCore = &#63; and productPlantID = &#63;.
	*
	* @param mtCore the mt core
	* @param productPlantID the product plant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vr product type
	* @throws NoSuchVRProductTypeException if a matching vr product type could not be found
	*/
	public VRProductType findByproductPlantID_First(long mtCore,
		long productPlantID,
		com.liferay.portal.kernel.util.OrderByComparator<VRProductType> orderByComparator)
		throws NoSuchVRProductTypeException;

	/**
	* Returns the first vr product type in the ordered set where mtCore = &#63; and productPlantID = &#63;.
	*
	* @param mtCore the mt core
	* @param productPlantID the product plant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vr product type, or <code>null</code> if a matching vr product type could not be found
	*/
	public VRProductType fetchByproductPlantID_First(long mtCore,
		long productPlantID,
		com.liferay.portal.kernel.util.OrderByComparator<VRProductType> orderByComparator);

	/**
	* Returns the last vr product type in the ordered set where mtCore = &#63; and productPlantID = &#63;.
	*
	* @param mtCore the mt core
	* @param productPlantID the product plant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vr product type
	* @throws NoSuchVRProductTypeException if a matching vr product type could not be found
	*/
	public VRProductType findByproductPlantID_Last(long mtCore,
		long productPlantID,
		com.liferay.portal.kernel.util.OrderByComparator<VRProductType> orderByComparator)
		throws NoSuchVRProductTypeException;

	/**
	* Returns the last vr product type in the ordered set where mtCore = &#63; and productPlantID = &#63;.
	*
	* @param mtCore the mt core
	* @param productPlantID the product plant ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vr product type, or <code>null</code> if a matching vr product type could not be found
	*/
	public VRProductType fetchByproductPlantID_Last(long mtCore,
		long productPlantID,
		com.liferay.portal.kernel.util.OrderByComparator<VRProductType> orderByComparator);

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
	public VRProductType[] findByproductPlantID_PrevAndNext(long id,
		long mtCore, long productPlantID,
		com.liferay.portal.kernel.util.OrderByComparator<VRProductType> orderByComparator)
		throws NoSuchVRProductTypeException;

	/**
	* Removes all the vr product types where mtCore = &#63; and productPlantID = &#63; from the database.
	*
	* @param mtCore the mt core
	* @param productPlantID the product plant ID
	*/
	public void removeByproductPlantID(long mtCore, long productPlantID);

	/**
	* Returns the number of vr product types where mtCore = &#63; and productPlantID = &#63;.
	*
	* @param mtCore the mt core
	* @param productPlantID the product plant ID
	* @return the number of matching vr product types
	*/
	public int countByproductPlantID(long mtCore, long productPlantID);

	/**
	* Caches the vr product type in the entity cache if it is enabled.
	*
	* @param vrProductType the vr product type
	*/
	public void cacheResult(VRProductType vrProductType);

	/**
	* Caches the vr product types in the entity cache if it is enabled.
	*
	* @param vrProductTypes the vr product types
	*/
	public void cacheResult(java.util.List<VRProductType> vrProductTypes);

	/**
	* Creates a new vr product type with the primary key. Does not add the vr product type to the database.
	*
	* @param id the primary key for the new vr product type
	* @return the new vr product type
	*/
	public VRProductType create(long id);

	/**
	* Removes the vr product type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the vr product type
	* @return the vr product type that was removed
	* @throws NoSuchVRProductTypeException if a vr product type with the primary key could not be found
	*/
	public VRProductType remove(long id) throws NoSuchVRProductTypeException;

	public VRProductType updateImpl(VRProductType vrProductType);

	/**
	* Returns the vr product type with the primary key or throws a {@link NoSuchVRProductTypeException} if it could not be found.
	*
	* @param id the primary key of the vr product type
	* @return the vr product type
	* @throws NoSuchVRProductTypeException if a vr product type with the primary key could not be found
	*/
	public VRProductType findByPrimaryKey(long id)
		throws NoSuchVRProductTypeException;

	/**
	* Returns the vr product type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the vr product type
	* @return the vr product type, or <code>null</code> if a vr product type with the primary key could not be found
	*/
	public VRProductType fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, VRProductType> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the vr product types.
	*
	* @return the vr product types
	*/
	public java.util.List<VRProductType> findAll();

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
	public java.util.List<VRProductType> findAll(int start, int end);

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
	public java.util.List<VRProductType> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRProductType> orderByComparator);

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
	public java.util.List<VRProductType> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRProductType> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the vr product types from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of vr product types.
	*
	* @return the number of vr product types
	*/
	public int countAll();
}