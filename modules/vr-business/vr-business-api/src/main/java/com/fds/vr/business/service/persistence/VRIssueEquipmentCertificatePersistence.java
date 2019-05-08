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

import com.fds.vr.business.exception.NoSuchVRIssueEquipmentCertificateException;
import com.fds.vr.business.model.VRIssueEquipmentCertificate;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the vr issue equipment certificate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LamTV
 * @see com.fds.vr.business.service.persistence.impl.VRIssueEquipmentCertificatePersistenceImpl
 * @see VRIssueEquipmentCertificateUtil
 * @generated
 */
@ProviderType
public interface VRIssueEquipmentCertificatePersistence extends BasePersistence<VRIssueEquipmentCertificate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VRIssueEquipmentCertificateUtil} to access the vr issue equipment certificate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the vr issue equipment certificates where issueVehicleCertificateId = &#63;.
	*
	* @param issueVehicleCertificateId the issue vehicle certificate ID
	* @return the matching vr issue equipment certificates
	*/
	public java.util.List<VRIssueEquipmentCertificate> findByIssueVehicleCertificateId(
		int issueVehicleCertificateId);

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
	public java.util.List<VRIssueEquipmentCertificate> findByIssueVehicleCertificateId(
		int issueVehicleCertificateId, int start, int end);

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
	public java.util.List<VRIssueEquipmentCertificate> findByIssueVehicleCertificateId(
		int issueVehicleCertificateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator);

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
	public java.util.List<VRIssueEquipmentCertificate> findByIssueVehicleCertificateId(
		int issueVehicleCertificateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first vr issue equipment certificate in the ordered set where issueVehicleCertificateId = &#63;.
	*
	* @param issueVehicleCertificateId the issue vehicle certificate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vr issue equipment certificate
	* @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate findByIssueVehicleCertificateId_First(
		int issueVehicleCertificateId,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException;

	/**
	* Returns the first vr issue equipment certificate in the ordered set where issueVehicleCertificateId = &#63;.
	*
	* @param issueVehicleCertificateId the issue vehicle certificate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate fetchByIssueVehicleCertificateId_First(
		int issueVehicleCertificateId,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator);

	/**
	* Returns the last vr issue equipment certificate in the ordered set where issueVehicleCertificateId = &#63;.
	*
	* @param issueVehicleCertificateId the issue vehicle certificate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vr issue equipment certificate
	* @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate findByIssueVehicleCertificateId_Last(
		int issueVehicleCertificateId,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException;

	/**
	* Returns the last vr issue equipment certificate in the ordered set where issueVehicleCertificateId = &#63;.
	*
	* @param issueVehicleCertificateId the issue vehicle certificate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate fetchByIssueVehicleCertificateId_Last(
		int issueVehicleCertificateId,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator);

	/**
	* Returns the vr issue equipment certificates before and after the current vr issue equipment certificate in the ordered set where issueVehicleCertificateId = &#63;.
	*
	* @param id the primary key of the current vr issue equipment certificate
	* @param issueVehicleCertificateId the issue vehicle certificate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vr issue equipment certificate
	* @throws NoSuchVRIssueEquipmentCertificateException if a vr issue equipment certificate with the primary key could not be found
	*/
	public VRIssueEquipmentCertificate[] findByIssueVehicleCertificateId_PrevAndNext(
		long id, int issueVehicleCertificateId,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException;

	/**
	* Removes all the vr issue equipment certificates where issueVehicleCertificateId = &#63; from the database.
	*
	* @param issueVehicleCertificateId the issue vehicle certificate ID
	*/
	public void removeByIssueVehicleCertificateId(int issueVehicleCertificateId);

	/**
	* Returns the number of vr issue equipment certificates where issueVehicleCertificateId = &#63;.
	*
	* @param issueVehicleCertificateId the issue vehicle certificate ID
	* @return the number of matching vr issue equipment certificates
	*/
	public int countByIssueVehicleCertificateId(int issueVehicleCertificateId);

	/**
	* Returns all the vr issue equipment certificates where vehiclecertificaterecordno = &#63;.
	*
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	* @return the matching vr issue equipment certificates
	*/
	public java.util.List<VRIssueEquipmentCertificate> findByVehiclecertificaterecordno(
		java.lang.String vehiclecertificaterecordno);

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
	public java.util.List<VRIssueEquipmentCertificate> findByVehiclecertificaterecordno(
		java.lang.String vehiclecertificaterecordno, int start, int end);

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
	public java.util.List<VRIssueEquipmentCertificate> findByVehiclecertificaterecordno(
		java.lang.String vehiclecertificaterecordno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator);

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
	public java.util.List<VRIssueEquipmentCertificate> findByVehiclecertificaterecordno(
		java.lang.String vehiclecertificaterecordno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first vr issue equipment certificate in the ordered set where vehiclecertificaterecordno = &#63;.
	*
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vr issue equipment certificate
	* @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate findByVehiclecertificaterecordno_First(
		java.lang.String vehiclecertificaterecordno,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException;

	/**
	* Returns the first vr issue equipment certificate in the ordered set where vehiclecertificaterecordno = &#63;.
	*
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate fetchByVehiclecertificaterecordno_First(
		java.lang.String vehiclecertificaterecordno,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator);

	/**
	* Returns the last vr issue equipment certificate in the ordered set where vehiclecertificaterecordno = &#63;.
	*
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vr issue equipment certificate
	* @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate findByVehiclecertificaterecordno_Last(
		java.lang.String vehiclecertificaterecordno,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException;

	/**
	* Returns the last vr issue equipment certificate in the ordered set where vehiclecertificaterecordno = &#63;.
	*
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate fetchByVehiclecertificaterecordno_Last(
		java.lang.String vehiclecertificaterecordno,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator);

	/**
	* Returns the vr issue equipment certificates before and after the current vr issue equipment certificate in the ordered set where vehiclecertificaterecordno = &#63;.
	*
	* @param id the primary key of the current vr issue equipment certificate
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vr issue equipment certificate
	* @throws NoSuchVRIssueEquipmentCertificateException if a vr issue equipment certificate with the primary key could not be found
	*/
	public VRIssueEquipmentCertificate[] findByVehiclecertificaterecordno_PrevAndNext(
		long id, java.lang.String vehiclecertificaterecordno,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException;

	/**
	* Removes all the vr issue equipment certificates where vehiclecertificaterecordno = &#63; from the database.
	*
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	*/
	public void removeByVehiclecertificaterecordno(
		java.lang.String vehiclecertificaterecordno);

	/**
	* Returns the number of vr issue equipment certificates where vehiclecertificaterecordno = &#63;.
	*
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	* @return the number of matching vr issue equipment certificates
	*/
	public int countByVehiclecertificaterecordno(
		java.lang.String vehiclecertificaterecordno);

	/**
	* Returns all the vr issue equipment certificates where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	*
	* @param applicantNo the applicant no
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	* @return the matching vr issue equipment certificates
	*/
	public java.util.List<VRIssueEquipmentCertificate> findByApplicantNo_CertificateRecordNo(
		java.lang.String applicantNo,
		java.lang.String vehiclecertificaterecordno);

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
	public java.util.List<VRIssueEquipmentCertificate> findByApplicantNo_CertificateRecordNo(
		java.lang.String applicantNo,
		java.lang.String vehiclecertificaterecordno, int start, int end);

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
	public java.util.List<VRIssueEquipmentCertificate> findByApplicantNo_CertificateRecordNo(
		java.lang.String applicantNo,
		java.lang.String vehiclecertificaterecordno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator);

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
	public java.util.List<VRIssueEquipmentCertificate> findByApplicantNo_CertificateRecordNo(
		java.lang.String applicantNo,
		java.lang.String vehiclecertificaterecordno, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first vr issue equipment certificate in the ordered set where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	*
	* @param applicantNo the applicant no
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vr issue equipment certificate
	* @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate findByApplicantNo_CertificateRecordNo_First(
		java.lang.String applicantNo,
		java.lang.String vehiclecertificaterecordno,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException;

	/**
	* Returns the first vr issue equipment certificate in the ordered set where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	*
	* @param applicantNo the applicant no
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate fetchByApplicantNo_CertificateRecordNo_First(
		java.lang.String applicantNo,
		java.lang.String vehiclecertificaterecordno,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator);

	/**
	* Returns the last vr issue equipment certificate in the ordered set where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	*
	* @param applicantNo the applicant no
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vr issue equipment certificate
	* @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate findByApplicantNo_CertificateRecordNo_Last(
		java.lang.String applicantNo,
		java.lang.String vehiclecertificaterecordno,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException;

	/**
	* Returns the last vr issue equipment certificate in the ordered set where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	*
	* @param applicantNo the applicant no
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate fetchByApplicantNo_CertificateRecordNo_Last(
		java.lang.String applicantNo,
		java.lang.String vehiclecertificaterecordno,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator);

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
	public VRIssueEquipmentCertificate[] findByApplicantNo_CertificateRecordNo_PrevAndNext(
		long id, java.lang.String applicantNo,
		java.lang.String vehiclecertificaterecordno,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException;

	/**
	* Removes all the vr issue equipment certificates where applicantNo = &#63; and vehiclecertificaterecordno = &#63; from the database.
	*
	* @param applicantNo the applicant no
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	*/
	public void removeByApplicantNo_CertificateRecordNo(
		java.lang.String applicantNo,
		java.lang.String vehiclecertificaterecordno);

	/**
	* Returns the number of vr issue equipment certificates where applicantNo = &#63; and vehiclecertificaterecordno = &#63;.
	*
	* @param applicantNo the applicant no
	* @param vehiclecertificaterecordno the vehiclecertificaterecordno
	* @return the number of matching vr issue equipment certificates
	*/
	public int countByApplicantNo_CertificateRecordNo(
		java.lang.String applicantNo,
		java.lang.String vehiclecertificaterecordno);

	/**
	* Returns all the vr issue equipment certificates where applicantNo = &#63;.
	*
	* @param applicantNo the applicant no
	* @return the matching vr issue equipment certificates
	*/
	public java.util.List<VRIssueEquipmentCertificate> findByApplicantNo(
		java.lang.String applicantNo);

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
	public java.util.List<VRIssueEquipmentCertificate> findByApplicantNo(
		java.lang.String applicantNo, int start, int end);

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
	public java.util.List<VRIssueEquipmentCertificate> findByApplicantNo(
		java.lang.String applicantNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator);

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
	public java.util.List<VRIssueEquipmentCertificate> findByApplicantNo(
		java.lang.String applicantNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first vr issue equipment certificate in the ordered set where applicantNo = &#63;.
	*
	* @param applicantNo the applicant no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vr issue equipment certificate
	* @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate findByApplicantNo_First(
		java.lang.String applicantNo,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException;

	/**
	* Returns the first vr issue equipment certificate in the ordered set where applicantNo = &#63;.
	*
	* @param applicantNo the applicant no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate fetchByApplicantNo_First(
		java.lang.String applicantNo,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator);

	/**
	* Returns the last vr issue equipment certificate in the ordered set where applicantNo = &#63;.
	*
	* @param applicantNo the applicant no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vr issue equipment certificate
	* @throws NoSuchVRIssueEquipmentCertificateException if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate findByApplicantNo_Last(
		java.lang.String applicantNo,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException;

	/**
	* Returns the last vr issue equipment certificate in the ordered set where applicantNo = &#63;.
	*
	* @param applicantNo the applicant no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vr issue equipment certificate, or <code>null</code> if a matching vr issue equipment certificate could not be found
	*/
	public VRIssueEquipmentCertificate fetchByApplicantNo_Last(
		java.lang.String applicantNo,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator);

	/**
	* Returns the vr issue equipment certificates before and after the current vr issue equipment certificate in the ordered set where applicantNo = &#63;.
	*
	* @param id the primary key of the current vr issue equipment certificate
	* @param applicantNo the applicant no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vr issue equipment certificate
	* @throws NoSuchVRIssueEquipmentCertificateException if a vr issue equipment certificate with the primary key could not be found
	*/
	public VRIssueEquipmentCertificate[] findByApplicantNo_PrevAndNext(
		long id, java.lang.String applicantNo,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator)
		throws NoSuchVRIssueEquipmentCertificateException;

	/**
	* Removes all the vr issue equipment certificates where applicantNo = &#63; from the database.
	*
	* @param applicantNo the applicant no
	*/
	public void removeByApplicantNo(java.lang.String applicantNo);

	/**
	* Returns the number of vr issue equipment certificates where applicantNo = &#63;.
	*
	* @param applicantNo the applicant no
	* @return the number of matching vr issue equipment certificates
	*/
	public int countByApplicantNo(java.lang.String applicantNo);

	/**
	* Caches the vr issue equipment certificate in the entity cache if it is enabled.
	*
	* @param vrIssueEquipmentCertificate the vr issue equipment certificate
	*/
	public void cacheResult(
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate);

	/**
	* Caches the vr issue equipment certificates in the entity cache if it is enabled.
	*
	* @param vrIssueEquipmentCertificates the vr issue equipment certificates
	*/
	public void cacheResult(
		java.util.List<VRIssueEquipmentCertificate> vrIssueEquipmentCertificates);

	/**
	* Creates a new vr issue equipment certificate with the primary key. Does not add the vr issue equipment certificate to the database.
	*
	* @param id the primary key for the new vr issue equipment certificate
	* @return the new vr issue equipment certificate
	*/
	public VRIssueEquipmentCertificate create(long id);

	/**
	* Removes the vr issue equipment certificate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the vr issue equipment certificate
	* @return the vr issue equipment certificate that was removed
	* @throws NoSuchVRIssueEquipmentCertificateException if a vr issue equipment certificate with the primary key could not be found
	*/
	public VRIssueEquipmentCertificate remove(long id)
		throws NoSuchVRIssueEquipmentCertificateException;

	public VRIssueEquipmentCertificate updateImpl(
		VRIssueEquipmentCertificate vrIssueEquipmentCertificate);

	/**
	* Returns the vr issue equipment certificate with the primary key or throws a {@link NoSuchVRIssueEquipmentCertificateException} if it could not be found.
	*
	* @param id the primary key of the vr issue equipment certificate
	* @return the vr issue equipment certificate
	* @throws NoSuchVRIssueEquipmentCertificateException if a vr issue equipment certificate with the primary key could not be found
	*/
	public VRIssueEquipmentCertificate findByPrimaryKey(long id)
		throws NoSuchVRIssueEquipmentCertificateException;

	/**
	* Returns the vr issue equipment certificate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the vr issue equipment certificate
	* @return the vr issue equipment certificate, or <code>null</code> if a vr issue equipment certificate with the primary key could not be found
	*/
	public VRIssueEquipmentCertificate fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, VRIssueEquipmentCertificate> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the vr issue equipment certificates.
	*
	* @return the vr issue equipment certificates
	*/
	public java.util.List<VRIssueEquipmentCertificate> findAll();

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
	public java.util.List<VRIssueEquipmentCertificate> findAll(int start,
		int end);

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
	public java.util.List<VRIssueEquipmentCertificate> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator);

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
	public java.util.List<VRIssueEquipmentCertificate> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<VRIssueEquipmentCertificate> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the vr issue equipment certificates from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of vr issue equipment certificates.
	*
	* @return the number of vr issue equipment certificates
	*/
	public int countAll();
}