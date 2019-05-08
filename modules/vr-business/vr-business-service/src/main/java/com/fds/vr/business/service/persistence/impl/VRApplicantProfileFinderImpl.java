package com.fds.vr.business.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.sql.Timestamp;
import java.util.Date;

import org.opencps.datamgt.model.DictItem;
import org.opencps.datamgt.model.impl.DictItemImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;

import com.fds.vr.business.model.VRApplicantProfile;
import com.fds.vr.business.model.impl.VRApplicantProfileImpl;
import com.fds.vr.business.service.persistence.VRApplicantProfileFinder;



public class VRApplicantProfileFinderImpl extends VRApplicantProfileFinderBaseImpl
	implements VRApplicantProfileFinder {

	Log log = LogFactoryUtil.getLog(VRApplicantProfileFinderImpl.class);

	
	
	public List<VRApplicantProfile> findByMappingApplicantProfile(long groupId, String applicantcode, String applicantname ) {
		Session session = null;
		try {
			session = openSession();
			
			StringBuilder query = new StringBuilder();
			query.append("SELECT {vr_applicantprofile.*} FROM vr_applicantprofile ");			
			query.append("WHERE  1=1 and vr_applicantprofile.mtcore = 0  ");		
			
			
			if ((Validator.isNotNull(applicantcode)) && applicantcode.trim().length() > 0 ){
				query.append("AND (vr_applicantprofile.applicantcode in (" + applicantcode.trim() + ")  ");
				query.append("OR vr_applicantprofile.applicantcode  is null    ");
				query.append("OR LENGTH(vr_applicantprofile.applicantcode) = 0   ");
				query.append(" ) ");
			} else {
				query.append("AND (vr_applicantprofile.applicantcode  is null    ");
				query.append("OR LENGTH(vr_applicantprofile.applicantcode) = 0   ");
				query.append(" ) ");
			}
			
			if ((Validator.isNotNull(applicantname)) && applicantname.trim().length() > 0 ){
				query.append("AND (vr_applicantprofile.mappingTEN_CTY like '" + applicantname.trim()+"%' ");
				query.append("OR vr_applicantprofile.mappingDIA_CHI_CTY like '" + applicantname.trim()+"%'  ");
				query.append(" ) ");
			}
			query.append("order by CONVERT(vr_applicantprofile.mappingTEN_CTY USING utf8) COLLATE utf8_polish_ci ");
			
					
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(VRApplicantProfileImpl.TABLE_NAME, DictItemImpl.class);
			
			log.info("=========findByMappingApplicantProfile===" + query.toString() );
			QueryPos qPos = QueryPos.getInstance(q);
			
			
			return (List<VRApplicantProfile>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			log.error(e);
		} finally {
			closeSession(session);
		}
		
		return new ArrayList<VRApplicantProfile>();
	}
	
	public List<VRApplicantProfile> findByMappedNoteApplicantProfile(long groupId, String applicantcode, String mappingMA_CTY) {
		Session session = null;
		try {
			session = openSession();
			
			StringBuilder query = new StringBuilder();
			query.append("SELECT {vr_applicantprofile.*} FROM vr_applicantprofile ");			
			query.append("WHERE  1=1 and vr_applicantprofile.mtcore = 1  ");		
			
			
			if ((Validator.isNotNull(applicantcode)) && applicantcode.trim().length() > 0 ){
				query.append("AND vr_applicantprofile.applicantcode in (" + applicantcode.trim() + ")  ");				
			}
			query.append("AND LENGTH(vr_applicantprofile.mappingMA_CTY) > 0   ");
			query.append("AND LENGTH(vr_applicantprofile.mappingTEN_CTY) > 0   ");
			
			if ((Validator.isNotNull(mappingMA_CTY)) && mappingMA_CTY.trim().length() > 0 ){
				query.append("AND vr_applicantprofile.mappingMA_CTY in (" + mappingMA_CTY.trim() + ")  ");				
			}
			query.append("order by CONVERT(vr_applicantprofile.applicantname USING utf8) COLLATE utf8_polish_ci ");
			
					
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(VRApplicantProfileImpl.TABLE_NAME, DictItemImpl.class);
			
			log.info("=========findByMappedNoteApplicantProfile===" + query.toString() );
			QueryPos qPos = QueryPos.getInstance(q);
			
			
			return (List<VRApplicantProfile>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			log.error(e);
		} finally {
			closeSession(session);
		}
		
		return new ArrayList<VRApplicantProfile>();
	}
	
	public List<VRApplicantProfile> findByGeneratingMappingNote(long groupId, String applicantcode, String mappingMA_CTY) {
		Session session = null;
		String mappingNote = StringPool.BLANK;
		try {
			session = openSession();
			
			StringBuilder query = new StringBuilder();
			query.append("SELECT {vr_applicantprofile.*} FROM vr_applicantprofile ");		
			
			if (((Validator.isNotNull(applicantcode)) && applicantcode.trim().length() > 0 )
					&& ((Validator.isNull(mappingMA_CTY) || mappingMA_CTY.trim().length() == 0 ))){
				// tra ve 01 dong Du lieu moi, da anh xa
				query.append("WHERE  1=1 and vr_applicantprofile.mtcore = 1  ");
				query.append("AND vr_applicantprofile.applicantcode in (" + applicantcode.trim() + ")  ");
				query.append("AND LENGTH(vr_applicantprofile.mappingMA_CTY) > 0   ");
				query.append("AND LENGTH(vr_applicantprofile.mappingTEN_CTY) > 0   ");
				
			} else if (((Validator.isNotNull(applicantcode)) && applicantcode.trim().length() > 0 )
					&& ((Validator.isNotNull(mappingMA_CTY)) && mappingMA_CTY.trim().length() > 0 )){
				// tra ve 02 dong Du lieu cu, Du lieu moi
				query.append("WHERE  1=1 ");
				query.append("AND ( ");
				query.append("(vr_applicantprofile.mtcore = 1  ");
				query.append("AND vr_applicantprofile.applicantcode in (" + applicantcode.trim() + ") ) ");
				query.append(" OR (vr_applicantprofile.mtcore = 0  ");
				query.append("AND vr_applicantprofile.mappingMA_CTY in (" + mappingMA_CTY.trim() + ")  ");	
				query.append("AND LENGTH(vr_applicantprofile.mappingTEN_CTY) > 0   ");
				query.append(" )) ");
				
			} else {
				return new ArrayList<VRApplicantProfile>();
			}
			

			query.append("order by vr_applicantprofile.mtcore desc ");
			
					
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(VRApplicantProfileImpl.TABLE_NAME, DictItemImpl.class);
			
			log.info("=========findByGeneratingMappingNote===" + query.toString() );
			QueryPos qPos = QueryPos.getInstance(q);
			
			
			return (List<VRApplicantProfile>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			
		} catch (Exception e) {
			log.error(e);
		} finally {
			closeSession(session);
		}
		
		return new ArrayList<VRApplicantProfile>();
	}
	
	public int COUNTMappingApplicantProfile(long groupId, String applicantcode, String applicantname ) {
		Session session = null;
		try {
			session = openSession();
			
			StringBuilder query = new StringBuilder();
			query.append("SELECT COUNT(*) AS COUNT_VALUE FROM vr_applicantprofile ");			
			query.append("WHERE  1=1 and vr_applicantprofile.mtcore = 0  ");		
			
			
			if ((Validator.isNotNull(applicantcode)) && applicantcode.trim().length() > 0 ){
				query.append("AND (vr_applicantprofile.applicantcode in (" + applicantcode + ")  ");
				query.append("OR vr_applicantprofile.applicantcode  is null    ");
				query.append("OR LENGTH(vr_applicantprofile.applicantcode) = 0   ");
				query.append(" ) ");
			} else {
				query.append("AND (vr_applicantprofile.applicantcode  is null    ");
				query.append("OR LENGTH(vr_applicantprofile.applicantcode) = 0   ");
				query.append(" ) ");
			}
			
			if ((Validator.isNotNull(applicantname)) && applicantname.trim().length() > 0 ){
				query.append("AND (vr_applicantprofile.mappingTEN_CTY like '" + applicantname.trim()+"%' ");
				query.append("OR vr_applicantprofile.mappingDIA_CHI_CTY like '" + applicantname.trim()+"%'  ");
				query.append(" ) ");
			}
			//query.append("order by CONVERT(vr_applicantprofile.mappingTEN_CTY USING utf8) COLLATE utf8_polish_ci ");
					
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			Iterator itr = q.iterate();
			
			if(itr.hasNext()) {
				Long count = (Long)itr.next();
				
				if(count != null) {
					return count.intValue();
				}
			}
			
			return 0;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return 0;
		
	}
	
	
	public int COUNTMappedNoteApplicantProfile(long groupId, String applicantcode, String mappingMA_CTY) {
		Session session = null;
		try {
			session = openSession();
			
			StringBuilder query = new StringBuilder();
			query.append("SELECT COUNT(*) AS COUNT_VALUE FROM vr_applicantprofile ");			
			query.append("WHERE  1=1 and vr_applicantprofile.mtcore = 1  ");		
			
			
			if ((Validator.isNotNull(applicantcode)) && applicantcode.trim().length() > 0 ){
				query.append("AND vr_applicantprofile.applicantcode in (" + applicantcode + ")  ");				
			}
			query.append("AND LENGTH(vr_applicantprofile.mappingMA_CTY) > 0   ");
			query.append("AND LENGTH(vr_applicantprofile.mappingTEN_CTY) > 0   ");

			if ((Validator.isNotNull(mappingMA_CTY)) && mappingMA_CTY.trim().length() > 0 ){
				query.append("AND vr_applicantprofile.mappingMA_CTY in (" + mappingMA_CTY.trim() + ")  ");				
			}
			//query.append("order by CONVERT(vr_applicantprofile.applicantname USING utf8) COLLATE utf8_polish_ci ");
			
					
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			Iterator itr = q.iterate();
			
			if(itr.hasNext()) {
				Long count = (Long)itr.next();
				
				if(count != null) {
					return count.intValue();
				}
			}
			
			return 0;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return 0;

	}
	

	public int COUNTDuplicateSupplier(long groupId, String supplierType, String supplierName, String supplierAddress) {
		Session session = null;
		try {
			session = openSession();
			
			StringBuilder query = new StringBuilder();
			
			String sqlConditions = StringPool.BLANK;
			if (groupId == 0) {
				groupId = 55301; // dat gia tri mac dinh neu ko co
			}
			sqlConditions += " WHERE 1=1  AND opencps_dictitem.groupId = "+ groupId + "  ";
			
			if ((Validator.isNotNull(supplierName)) && supplierName.trim().length() > 0 ){
				sqlConditions += "AND (opencps_dictitem.itemName like '" + supplierName.trim()+"%' ";
			}
			if ((Validator.isNotNull(supplierAddress)) && supplierAddress.trim().length() > 0 ){
				sqlConditions += "AND (opencps_dictitem.itemNameEN like '" + supplierAddress.trim()+"%' ";
			}
						
			if ((Validator.isNotNull(supplierType)) && supplierType.trim().length() > 0 
					&& supplierType.equalsIgnoreCase("CSSX")){
				query.append("SELECT COUNT(*) AS COUNT_VALUE FROM ( ");
				query.append("Select DISTINCT opencps_dictitem.* from opencps_dictitem  ");
				query.append("INNER JOIN opencps_dictcollection ON  opencps_dictcollection.dictCollectionId = opencps_dictitem.dictCollectionId "); 
				query.append("AND opencps_dictcollection.collectionCode = 'VR86' and opencps_dictcollection.groupId = 55217 ");
				query.append("INNER JOIN opencps_dictitemgroup where opencps_dictitemgroup.dictItemId = opencps_dictitem.dictItemId ");
				query.append("AND opencps_dictitemgroup.groupId = "+ groupId + "  ");
				query.append("AND opencps_dictitemgroup.dictGroupName = 'CSSX' ");
				query.append(sqlConditions);
				query.append(") SUPPLIER ");
				
			} else if ((Validator.isNotNull(supplierType)) && supplierType.trim().length() > 0 
					&& supplierType.equalsIgnoreCase("NHAXUONG")){
				query.append("SELECT COUNT(*) AS COUNT_VALUE FROM ( ");
				query.append("(Select DISTINCT opencps_dictitem.* from opencps_dictitem  ");
				query.append("INNER JOIN opencps_dictcollection ON  opencps_dictcollection.dictCollectionId = opencps_dictitem.dictCollectionId  ");
				query.append("AND opencps_dictcollection.collectionCode = 'VR86' and opencps_dictcollection.groupId = 55217 ");
				query.append("INNER JOIN opencps_dictitemgroup ON opencps_dictitemgroup.dictItemId = opencps_dictitem.dictItemId ");
				query.append("AND opencps_dictitemgroup.groupId = "+ groupId + "  ");
				query.append("AND opencps_dictitemgroup.dictGroupName = 'NHAXUONG' ");
				query.append("INNER JOIN opencps_dictitem parent ON parent.dictItemId = opencps_dictitem.parentItemId  ");
				query.append("AND parent.groupId = "+ groupId + "  ");
				query.append("AND opencps_dictitem.parentItemId > 0 ");
				query.append(sqlConditions);
				query.append(") ");
				query.append(") SUPPLIER ");
			} else {
				query.append("SELECT COUNT(*) AS COUNT_VALUE FROM ( ");
				query.append("(Select DISTINCT opencps_dictitem.* from opencps_dictitem  ");
				query.append("INNER JOIN opencps_dictcollection ON  opencps_dictcollection.dictCollectionId = opencps_dictitem.dictCollectionId  ");
				query.append("AND opencps_dictcollection.collectionCode = 'VR86' and opencps_dictcollection.groupId = 55217 ");
				query.append("INNER JOIN opencps_dictitemgroup ON opencps_dictitemgroup.dictItemId = opencps_dictitem.dictItemId ");
				query.append("AND opencps_dictitemgroup.groupId = "+ groupId + "  ");
				query.append("AND opencps_dictitemgroup.dictGroupName = 'NHAXUONG' ");
				query.append("INNER JOIN opencps_dictitem parent ON parent.dictItemId = opencps_dictitem.parentItemId  ");
				query.append("AND parent.groupId = "+ groupId + "  ");
				query.append("AND opencps_dictitem.parentItemId > 0 ");
				query.append(sqlConditions);

				query.append(")  ");
				query.append("UNION  ");
				query.append("(  ");
				query.append("Select DISTINCT opencps_dictitem.* from opencps_dictitem  ");
				query.append("INNER JOIN opencps_dictcollection ON  opencps_dictcollection.dictCollectionId = opencps_dictitem.dictCollectionId "); 
				query.append("AND opencps_dictcollection.collectionCode = 'VR86' and opencps_dictcollection.groupId = 55217 ");
				query.append("INNER JOIN opencps_dictitemgroup where opencps_dictitemgroup.dictItemId = opencps_dictitem.dictItemId ");
				query.append("AND opencps_dictitemgroup.groupId = "+ groupId + "  ");
				query.append("AND opencps_dictitemgroup.dictGroupName = 'CSSX' ");
				query.append(sqlConditions);
				query.append(") ");
				query.append(") SUPPLIER ");
			}
			log.info("=========COUNTDuplicateSupplier===" + query.toString() );
			
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			Iterator itr = q.iterate();
			
			if(itr.hasNext()) {
				Long count = (Long)itr.next();
				
				if(count != null) {
					return count.intValue();
				}
			}
			
			return 0;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return 0;

	}
	
}
