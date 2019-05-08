package org.opencps.datamgt.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.sql.Timestamp;
import java.util.Date;

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
import org.opencps.datamgt.model.DictCollection;
import org.opencps.datamgt.model.DictGroup;
import org.opencps.datamgt.model.impl.DictCollectionImpl;
import org.opencps.datamgt.model.impl.DictCollectionModelImpl;
import org.opencps.datamgt.service.DictCollectionLocalServiceUtil;
import org.opencps.datamgt.service.DictGroupLocalServiceUtil;
import org.opencps.datamgt.service.DictItemGroupLocalServiceUtil;
import org.opencps.datamgt.service.persistence.DictCollectionPersistence;
import org.opencps.datamgt.service.persistence.DictItemFinder;
import org.opencps.datamgt.model.DictItem;
import org.opencps.datamgt.model.impl.DictItemImpl;
import org.opencps.datamgt.model.impl.DictItemModelImpl;
import org.opencps.datamgt.service.persistence.DictItemPersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;

public class DictItemFinderImpl extends DictItemFinderBaseImpl implements DictItemFinder {
	
	private static Log log = LogFactoryUtil.getLog(DictItemFinderImpl.class);
	
	public List<DictItem> findByCollection_Level_OrderBy(long groupId, String collectionCode, String level, String OrderBy ) {
		Session session = null;
		try {
			session = openSession();
			
			StringBuilder query = new StringBuilder();
			query.append("SELECT * FROM opencps_dictitem ");
			if (Validator.isNull(level)) {
				// bo qua
			} else if ((Validator.isNotNull(level)) && level.equalsIgnoreCase("0")){
				// bo qua INNER JOIN parentItem
			} else {
				query.append("INNER JOIN opencps_dictitem parent  ");
				query.append("ON opencps_dictitem.dictCollectionId = parent.dictCollectionId  ");
				query.append("AND opencps_dictitem.parentItemId = parent.dictItemId  ");
				if (Validator.isNotNull(level) && Long.parseLong(level.trim()) > 0) {
					query.append("AND parent.level < " + level +" ");
				} else {
					query.append("AND parent.level in (0, 1)  ");
				}
			}			
			
			query.append("INNER JOIN opencps_dictcollection collection  ");
			query.append("ON opencps_dictitem.dictCollectionId = collection.dictCollectionId  ");
			query.append("AND collection.collectionCode in ('" + collectionCode + "')  ");
			query.append("WHERE  1=1 ");
			if (groupId > 0 ) {
				query.append(" and opencps_dictitem.groupId =   " + groupId +" ");
			} else { 
				query.append(" and opencps_dictitem.groupId = 55301  ");	
			}
			
			if (Validator.isNull(level)) {
				// bo qua
			} else if ((Validator.isNotNull(level)) && level.equalsIgnoreCase("0")){
				query.append(" and opencps_dictitem.level = 0  ");
			} else {
				query.append(" and opencps_dictitem.parentItemId > 0  ");
			}
			
			if (Validator.isNotNull(OrderBy) && OrderBy.contains("name")) {
				query.append("order by opencps_dictitem.parentItemId, CONVERT(opencps_dictitem.itemName USING utf8) COLLATE utf8_polish_ci ");
			} else if (Validator.isNotNull(OrderBy) && OrderBy.contains("sibling")) {
				query.append("order by opencps_dictitem.parentItemId, LENGTH(sibling), sibling ");
			} else {
				query.append("order by opencps_dictitem.parentItemId, CONVERT(opencps_dictitem.itemName USING utf8) COLLATE utf8_polish_ci ");
			}
			
					
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(DictItemImpl.TABLE_NAME, DictItemImpl.class);
			
			log.info("=========findByCollection_Level_OrderBy===" + query.toString() );
			QueryPos qPos = QueryPos.getInstance(q);
			
			
			return (List<DictItem>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			log.error(e);
		} finally {
			closeSession(session);
		}
		
		return new ArrayList<DictItem>();
	}
	
	public List<DictItem> findByCollection_Parent_Level_OrderBy(long groupId, String collectionCode, String parentItemCode, String level, String OrderBy ) {
		Session session = null;
		try {
			session = openSession();
			
			StringBuilder query = new StringBuilder();
			query.append("SELECT * FROM opencps_dictitem ");
			if (Validator.isNull(level)) {
				// bo qua
			} else if ((Validator.isNotNull(level)) && level.equalsIgnoreCase("0")){
				// bo qua INNER JOIN parentItem
			} else {
				query.append("INNER JOIN opencps_dictitem parent  ");
				query.append("ON opencps_dictitem.dictCollectionId = parent.dictCollectionId  ");
				query.append("AND opencps_dictitem.parentItemId = parent.dictItemId  ");
				if (Validator.isNotNull(level) && Long.parseLong(level.trim()) > 0) {
					query.append("AND parent.level < " + level +" ");
				} else {
					query.append("AND parent.level in (0, 1)  ");
				}			
				
				String parentFilter = StringPool.BLANK;
				if (Validator.isNotNull(parentItemCode)) {
					String[] arrGroupCode = StringUtil.split(parentItemCode);
					if (arrGroupCode != null && arrGroupCode.length > 0) {
						for (int i = 0; i < arrGroupCode.length; i++) {
							if (Validator.isNotNull(arrGroupCode[i])) {
								if (Validator.isNotNull(parentFilter)) {
									parentFilter = parentFilter + " OR  " + "parent.itemCode like '"+arrGroupCode[i].trim()+"%' ";
								} else {
									parentFilter = " AND ( "  + "parent.itemCode like '"+arrGroupCode[i].trim()+"%' ";
								}
								
							}

						}
					}
				}
				if (Validator.isNotNull(parentFilter)) {
					query.append(parentFilter + " )  ");
				}
			}			
			
			query.append("INNER JOIN opencps_dictcollection collection  ");
			query.append("ON opencps_dictitem.dictCollectionId = collection.dictCollectionId  ");
			query.append("AND collection.collectionCode in ('" + collectionCode + "')  ");
			query.append("WHERE  1=1 ");
			if (groupId > 0 ) {
				query.append(" and opencps_dictitem.groupId =   " + groupId +" ");
			} else { 
				query.append(" and opencps_dictitem.groupId = 55301  ");	
			}
			
			if (Validator.isNull(level)) {
				// bo qua
			} else if ((Validator.isNotNull(level)) && level.equalsIgnoreCase("0")){
				query.append(" and opencps_dictitem.level = 0  ");
			} else {
				query.append(" and opencps_dictitem.parentItemId > 0  ");
			}
			
			if (Validator.isNotNull(OrderBy) && OrderBy.contains("name")) {
				query.append("order by opencps_dictitem.parentItemId, CONVERT(opencps_dictitem.itemName USING utf8) COLLATE utf8_polish_ci ");
			} else if (Validator.isNotNull(OrderBy) && OrderBy.contains("sibling")) {
				query.append("order by opencps_dictitem.parentItemId, LENGTH(sibling), sibling ");
			} else {
				query.append("order by opencps_dictitem.parentItemId, CONVERT(opencps_dictitem.itemName USING utf8) COLLATE utf8_polish_ci ");
			}
			
					
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(DictItemImpl.TABLE_NAME, DictItemImpl.class);
			
			log.info("=========findByCollection_Parent_Level_OrderBy===" + query.toString() );
			QueryPos qPos = QueryPos.getInstance(q);
			
			
			return (List<DictItem>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			log.error(e);
		} finally {
			closeSession(session);
		}
		
		return new ArrayList<DictItem>();
	}
	
	
	public List<DictItem> findByCollection_Group_Level_OrderBy(long groupId, String collectionCode, String groupCode , String level, String OrderBy ) {
		Session session = null;
		try {
			session = openSession();
			
			StringBuilder query = new StringBuilder();
			query.append("SELECT * FROM opencps_dictitem ");
			if (Validator.isNull(level)) {
				// bo qua
			} else if ((Validator.isNotNull(level)) && level.equalsIgnoreCase("0")){
				// bo qua INNER JOIN parentItem
			} else {
				query.append("INNER JOIN opencps_dictitem parent  ");
				query.append("ON opencps_dictitem.dictCollectionId = parent.dictCollectionId  ");
				query.append("AND opencps_dictitem.parentItemId = parent.dictItemId  ");
				if (Validator.isNotNull(level) && Long.parseLong(level.trim()) > 0) {
					query.append("AND parent.level < " + level +" ");
				} else {
					query.append("AND parent.level in (0, 1)  ");
				}	
			}			

			query.append("INNER JOIN opencps_dictcollection collection  ");
			query.append("ON opencps_dictitem.dictCollectionId = collection.dictCollectionId  ");
			query.append("AND collection.collectionCode in ('" + collectionCode + "')  ");
			
			query.append("INNER JOIN opencps_dictgroup dictgroup  ");
			query.append("ON opencps_dictitem.dictCollectionId = dictgroup.dictCollectionId  ");
			query.append("INNER JOIN opencps_dictitemgroup itemgroup  ");
			query.append("ON opencps_dictitem.dictItemId = itemgroup.dictItemId  ");
			query.append("AND itemgroup.dictGroupId = dictgroup.dictGroupId  ");
			
			String groupCodeFilter = StringPool.BLANK;
			if (Validator.isNotNull(groupCode)) {
				String[] arrGroupCode = StringUtil.split(groupCode);
				if (arrGroupCode != null && arrGroupCode.length > 0) {
					for (int i = 0; i < arrGroupCode.length; i++) {
						if (Validator.isNotNull(arrGroupCode[i])) {
							if (Validator.isNotNull(groupCodeFilter)) {
								groupCodeFilter = groupCodeFilter + " OR  " + "itemgroup.dictGroupName in ('"+arrGroupCode[i].trim()+"' ) ";
							} else {
								groupCodeFilter = " AND ( "  + "itemgroup.dictGroupName in ('"+arrGroupCode[i].trim()+"' ) ";
							}
							
						}

					}
				}
			}
			if (Validator.isNotNull(groupCodeFilter)) {
				query.append(groupCodeFilter + " )  ");
			}			
			
			query.append("WHERE  1=1 ");
			if (groupId > 0 ) {
				query.append(" and opencps_dictitem.groupId =   " + groupId +" ");
			} else { 
				query.append(" and opencps_dictitem.groupId = 55301  ");	
			}
			
			if (Validator.isNull(level)) {
				// bo qua
			} else if ((Validator.isNotNull(level)) && level.equalsIgnoreCase("0")){
				query.append(" and opencps_dictitem.level = 0  ");
			} else {
				query.append(" and opencps_dictitem.parentItemId > 0  ");
			}
			
			if (Validator.isNotNull(OrderBy) && OrderBy.contains("name")) {
				query.append("order by opencps_dictitem.parentItemId, CONVERT(opencps_dictitem.itemName USING utf8) COLLATE utf8_polish_ci ");
			} else if (Validator.isNotNull(OrderBy) && OrderBy.contains("sibling")) {
				query.append("order by opencps_dictitem.parentItemId, LENGTH(sibling), sibling ");
			} else {
				query.append("order by opencps_dictitem.parentItemId, CONVERT(opencps_dictitem.itemName USING utf8) COLLATE utf8_polish_ci ");
			}
			
					
			SQLQuery q = session.createSQLQuery(query.toString());
			q.setCacheable(false);
			q.addEntity(DictItemImpl.TABLE_NAME, DictItemImpl.class);
			
			log.info("=========findByCollection_Group_Level_OrderBy===" + query.toString() );
			QueryPos qPos = QueryPos.getInstance(q);
			
			
			return (List<DictItem>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			log.error(e);
		} finally {
			closeSession(session);
		}
		
		return new ArrayList<DictItem>();
	}
	
	
}
