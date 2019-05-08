package org.opencps.dossiermgt.listenner;

import java.util.Date;
import java.util.List;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.opencps.dossiermgt.model.Dossier;
import org.opencps.dossiermgt.model.DossierAction;
import org.opencps.dossiermgt.model.DossierFile;
import org.opencps.dossiermgt.model.DossierLog;
import org.opencps.dossiermgt.model.ProcessAction;
import org.opencps.dossiermgt.model.ServiceProcess;
import org.opencps.dossiermgt.service.DossierFileLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierLogLocalServiceUtil;
import org.opencps.dossiermgt.service.ProcessActionLocalServiceUtil;
import org.opencps.dossiermgt.service.ServiceProcessLocalServiceUtil;
import org.opencps.usermgt.action.impl.EmployeeActions;
import org.opencps.usermgt.action.impl.JobposActions;
import org.opencps.usermgt.model.Applicant;
import org.opencps.usermgt.model.Employee;
import org.opencps.usermgt.model.JobPos;
import org.opencps.usermgt.service.ApplicantLocalServiceUtil;
import org.opencps.usermgt.service.EmployeeLocalServiceUtil;
import com.fds.vr.business.model.VRRPDossierStatistics;
import com.fds.vr.business.model.impl.VRRPDossierStatisticsImpl;
import com.fds.vr.business.service.VRRPDossierStatisticsLocalServiceUtil;
import org.opencps.dossiermgt.action.keypay.util.HashFunction;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import backend.utils.APIDateTimeUtils;

@Component(immediate = true, service = ModelListener.class)
public class DossierActionListenner extends BaseModelListener<DossierAction> {
	@Override
	public void onAfterCreate(DossierAction model) throws ModelListenerException {

		_log.info("START Dossier Action");
		Indexer<DossierLog> indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(DossierLog.class);
		if (true) {

			ServiceContext serviceContext = new ServiceContext();

			EmployeeActions employeeActions = new EmployeeActions();

			JobposActions jobposActions = new JobposActions();

			try {

				long userId = model.getUserId();

				Employee employee = employeeActions.getEmployeeByMappingUserId(model.getGroupId(), userId);

				long mainJobposId = employee != null ? employee.getMainJobPostId() : 0;

				long dossierId = model.getDossierId();

				String jobPosName = StringPool.BLANK;

				if (mainJobposId > 0) {

					JobPos jobPos = jobposActions.getJobPos(mainJobposId);

					jobPosName = (jobPos != null && Validator.isNotNull(jobPos.getTitle())) ? jobPos.getTitle()
							: StringPool.BLANK;
				}

				String content = model.getActionNote();

				JSONObject payload = JSONFactoryUtil.createJSONObject();

				JSONArray files = JSONFactoryUtil.createJSONArray();

				if (dossierId > 0) {
					long now = System.currentTimeMillis();
					_log.info("START Dossier Action11111: " + (System.currentTimeMillis() - now));
					List<DossierLog> dossierLogs = DossierLogLocalServiceUtil.getByDossierAndType(dossierId,
							DossierFileListenerMessageKeys.DOSSIER_LOG_CREATE_TYPE, QueryUtil.ALL_POS,
							QueryUtil.ALL_POS);
					_log.info("START Dossier Action2222: " + (System.currentTimeMillis() - now));
					for (DossierLog log : dossierLogs) {
						long dossierFileId = 0;

						try {
							JSONObject payloadFile = JSONFactoryUtil.createJSONObject(log.getPayload());

							dossierFileId = GetterUtil.getLong(payloadFile.get("dossierFileId"));
						} catch (Exception e) {

						}
						_log.info("START Dossier Action333: " + (System.currentTimeMillis() - now));
						if (dossierFileId != 0) {
							DossierFile dossierFile = DossierFileLocalServiceUtil.fetchDossierFile(dossierFileId);

							if (Validator.isNotNull(dossierFile)) {
								JSONObject file = JSONFactoryUtil.createJSONObject();

								file.put("dossierFileId", dossierFile.getDossierFileId());
								file.put("fileName", dossierFile.getDisplayName());
								file.put("createDate", APIDateTimeUtils.convertDateToString(dossierFile.getCreateDate(),
										APIDateTimeUtils._TIMESTAMP));
								files.put(file);
							}
						}

						//DossierLogLocalServiceUtil.deleteDossierLog(log);
						indexer.delete(log);
					}
					DossierLogLocalServiceUtil.deleteByDossierAndType(dossierId,
							DossierFileListenerMessageKeys.DOSSIER_LOG_CREATE_TYPE);
					_log.info("START Dossier Action4444: " + (System.currentTimeMillis() - now));
				}

				payload.put("jobPosName", jobPosName);
				payload.put("stepName", model.getActionName());
				payload.put("stepInstruction", model.getStepInstruction());
				payload.put("files", files);

				serviceContext.setCompanyId(model.getCompanyId());
				serviceContext.setUserId(userId);

				ProcessAction processAction = ProcessActionLocalServiceUtil
						.getByNameActionNo(model.getServiceProcessId(), model.getActionCode(), model.getActionName());

				boolean ok = true;

				if (Validator.isNotNull(processAction)) {
					if ((processAction.getPreCondition().contains("cancelling")
							&& processAction.getAutoEvent().contains("timmer"))
							|| (processAction.getPreCondition().contains("correcting")
									&& processAction.getAutoEvent().contains("timmer"))
							|| (processAction.getPreCondition().contains("submitting"))
									&& processAction.getAutoEvent().contains("timmer")) {
						ok = false;

					}
				}

				if (processAction.getPreCondition().contains("reject_cancelling")
						|| processAction.getPreCondition().contains("reject_correcting")
						|| processAction.getPreCondition().contains("reject_submitting")) {
					ok = false;
				}

				_log.debug("content: "+content);
				if (ok) {
					_log.info("START Dossier Action11111");
					DossierLog dossierLog = DossierLogLocalServiceUtil.addDossierLog(model.getGroupId(), model.getDossierId(),
							model.getActionUser(), content, "PROCESS_TYPE", payload.toString(),
							serviceContext);
					//_log.debug("dossierLog: "+dossierLog);
					
					// SONVH bosung 25/03/2019: Ghi vao vr_rp_dossierstatistics
					String processNo = UpdateRPdossierstatistics(model, payload.toString());
				}

			} catch (SystemException | PortalException e) {
				_log.error(e);
			}
		}

		if (Validator.isNotNull(model.getSyncActionCode()) && model.getSyncActionCode().length() != 0) {
			String content = "On DossiserAction Created";
			String notificationType = "";
			String payload = "";

			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setCompanyId(model.getCompanyId());
			serviceContext.setUserId(model.getUserId());

			try {
				_log.info("START Dossier Action11111");
				DossierLogLocalServiceUtil.addDossierLog(model.getGroupId(), model.getDossierId(), model.getUserName(),
						content, notificationType, payload, serviceContext);
			} catch (SystemException | PortalException e) {
				_log.error(e);
			}
		}
	}

	private String getUserName(long userId, long groupId) {
		String userName = StringPool.BLANK;

		Employee employee = null;

		Applicant applicant = null;

		employee = EmployeeLocalServiceUtil.fetchByF_mappingUserId(groupId, userId);

		if (Validator.isNotNull(employee)) {
			return employee.getFullName();

		}

		applicant = ApplicantLocalServiceUtil.fetchByMappingID(userId);

		if (Validator.isNotNull(applicant)) {
			return applicant.getApplicantName();
		}

		return userName;
	}
	
	public String UpdateRPdossierstatistics(DossierAction dossierActionModel, String payload) throws PortalException {
		try {
			//Lan luot tung quy trinh
			String processNo = StringPool.BLANK;
			String postStepCode = dossierActionModel.getStepCode();
			String actionUserName =  dossierActionModel.getActionUser();
			String actionCode =  dossierActionModel.getActionCode();
			boolean flagUpdate = true; 
			long groupId = dossierActionModel.getGroupId(); 
			
			Dossier sourceDossier = DossierLocalServiceUtil.fetchDossier(dossierActionModel.getDossierId());
			ServiceProcess serviceProcess = ServiceProcessLocalServiceUtil.fetchServiceProcess(dossierActionModel.getServiceProcessId());
			processNo = (serviceProcess != null ) ? serviceProcess.getProcessNo() : (sourceDossier != null ? sourceDossier.getServiceCode() : StringPool.BLANK);
			
			if (Validator.isNotNull(processNo) && groupId == 55301) {
				VRRPDossierStatistics statistics = new VRRPDossierStatisticsImpl();				
				// finder
				List<VRRPDossierStatistics> lstVRRPDossierStatistics = VRRPDossierStatisticsLocalServiceUtil.findByDossierId(dossierActionModel.getDossierId());
				if (dossierActionModel.getDossierId() > 0 && lstVRRPDossierStatistics !=null && lstVRRPDossierStatistics.size() > 0) {
					statistics = lstVRRPDossierStatistics.get(0);
				}
				
				if (Validator.isNull(statistics) || statistics.getDossierid() == 0) {
					flagUpdate = false;
					statistics = new VRRPDossierStatisticsImpl();
					statistics.setId(CounterLocalServiceUtil.increment(VRRPDossierStatistics.class.getName()));
					if (dossierActionModel.getDossierId() > 0) {
						statistics.setDossierid(dossierActionModel.getDossierId());
					}
					if (sourceDossier != null && sourceDossier.getReferenceUid().length() > 0 ) {
						//binhth index dossierId CTN
						// TODO
						
						MessageDigest md5 = null;
						
						byte[] ba = null;
	
						try {
							
							md5 = MessageDigest.getInstance("MD5");
							
							ba = md5.digest(sourceDossier.getReferenceUid().getBytes("UTF-8"));
							
						} catch (Exception e) {
						} 
	
						DateFormat df = new SimpleDateFormat("yy");
						
						String formattedDate = df.format(Calendar.getInstance().getTime());
						
						String dossierIDCTN = StringPool.BLANK;
						
						dossierIDCTN = formattedDate + HashFunction.hexShort(ba);
						statistics.setDossierIdCTN(dossierIDCTN);
					}
				}
				
				if (sourceDossier != null && sourceDossier.getReferenceUid().length() > 0 ) {
					// set values 
					statistics.setDossierno(sourceDossier.getDossierNo());
					statistics.setApplicantNo(sourceDossier.getApplicantIdNo());
					statistics.setApplicantname(sourceDossier.getApplicantName());
					statistics.setApplicantaddress(sourceDossier.getAddress());
					statistics.setDossiersubstatus(sourceDossier.getDossierSubStatusText());
					statistics.setModifyDate(new Date());
					statistics.setSyncDate(new Date());
				
				}
				switch (processNo) {
				case "TT302011BGTVTTTKXCG":  //Tham dinh thiet ke Xe co gioi
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "205": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "215": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "227": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "136": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
						statistics.setDossiersubmittingdate(dossiersubmittingdate);
						statistics.setMen2submitting(actionUserName);
						break;
					case "300": //7. Ngay ky giay chung nhan moi, duoc lanh dao Cuc ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
					case "201": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "206": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1161") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1137") || actionCode.equalsIgnoreCase("1160"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1174"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						break;
					
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}		
				
					break;
				case "TT302011BGTVTTDTKXMCD": //Tham dinh thiet ke Xe may chuyen dung 
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "205": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "215": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "227": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "136": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
						statistics.setDossiersubmittingdate(dossiersubmittingdate);
						statistics.setMen2submitting(actionUserName);
						break;
					case "300": //7. Ngay ky giay chung nhan moi, duoc lanh dao Cuc ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
					case "201": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "206": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1161") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1137") || actionCode.equalsIgnoreCase("1160"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1174"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						break;
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}		
				
					break;
				
				case "TT302011BGTVTKTSPMXCG": //Kiem tra san pham mau Xe co gioi
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "205": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "215": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "227": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "138": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1115")) {
							Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
							statistics.setDossiersubmittingdate(dossiersubmittingdate);
							statistics.setMen2submitting(actionUserName);
						}
						
						break;
					case "301": //7. Ngay ky giay chung nhan moi, duoc lanh dao Cuc ky moi dossierfirstcertificatesigndate / men2firstcertificate
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1129")) {
							Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
							statistics.setMen2firstcertificate(actionUserName);
						}
						
						break;
					case "201": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;					
					case "206": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1161") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "300": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1153")) {
							Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
							statistics.setMen2lastcertificatesign(actionUserName);
						}
						//15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1128"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1153"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						break;
						
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}	

					break;
				case "TT302011BGTVTKTSPMXBBCN": //Kiem tra san pham mau Xe cho nguoi bon banh co gan dong co
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "205": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "215": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "227": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "138": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1115")) {
							Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
							statistics.setDossiersubmittingdate(dossiersubmittingdate);
							statistics.setMen2submitting(actionUserName);
						}
						
						break;
					case "301": //7. Ngay ky giay chung nhan moi, duoc lanh dao Cuc ky moi dossierfirstcertificatesigndate / men2firstcertificate
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1129")) {
							Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
							statistics.setMen2firstcertificate(actionUserName);
						}
						
						break;
					case "201": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;					
					case "206": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1161") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "300": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1153")) {
							Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
							statistics.setMen2lastcertificatesign(actionUserName);
						}
						//15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1128"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1153"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						break;
						
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}
					break;
				
				case "TT302011BGTVTCOP": //Danh gia COP
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "205": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "302": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "303": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "138": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1115")) {
							Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
							statistics.setDossiersubmittingdate(dossiersubmittingdate);
							statistics.setMen2submitting(actionUserName);
						}
						
						break;
					
					case "201": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "206": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1161") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1132"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1174"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						//7. Ngay ky giay chung nhan moi, duoc To truong to COP ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
						
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}	

					break;
				case "TT302011BGTVTKTTBLANDAU": //Kiem tra tinh trang hoat dong thiet bi kiem tra
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "205": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "302": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "303": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "138": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1115")) {
							Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
							statistics.setDossiersubmittingdate(dossiersubmittingdate);
							statistics.setMen2submitting(actionUserName);
						}
						
						break;
					
					case "201": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "206": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1161") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1132"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1174"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						//7. Ngay ky giay chung nhan moi, duoc To truong to COP ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
						
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}	

					break;
				
				case "TT192012TTBGTVTDGLD": //Kiem tra, danh gia co so bao hanh bao duong
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "205": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "302": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "303": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "138": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1115")) {
							Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
							statistics.setDossiersubmittingdate(dossiersubmittingdate);
							statistics.setMen2submitting(actionUserName);
						}
						
						break;
					
					case "201": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "206": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1161") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1132"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1174"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						//7. Ngay ky giay chung nhan moi, duoc To truong to COP ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
						
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}	

					break;
				case "432014TTLTBGTVTBCTTTNLNK": //Dang ky chung nhan muc tieu thu nhien lieu doi voi xe o to nhap khau 
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "205": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "215": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "227": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "136": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
						statistics.setDossiersubmittingdate(dossiersubmittingdate);
						statistics.setMen2submitting(actionUserName);
						break;
					case "300": //7. Ngay ky giay chung nhan moi, duoc lanh dao Cuc ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
					case "201": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "206": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1161") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1137") || actionCode.equalsIgnoreCase("1160"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1174"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						break;
					
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}	

					break;
				case "432014TTLTBGTVTBCTTTNLSXLR": //Dang ky chung nhan muc tieu thu nhien lieu doi voi xe o to san xuat, lap rap
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "205": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "215": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "227": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "136": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
						statistics.setDossiersubmittingdate(dossiersubmittingdate);
						statistics.setMen2submitting(actionUserName);
						break;
					case "300": //7. Ngay ky giay chung nhan moi, duoc lanh dao Cuc ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
					case "201": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "206": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1161") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1137") || actionCode.equalsIgnoreCase("1160"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1174"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						break;
					
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}	

					break;
				case "TT302011BGTVTCNCLKLLKXCG": //Chung nhan chat luong kieu loai linh kien Xe co gioi
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "204": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "215": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "227": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "136": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
						statistics.setDossiersubmittingdate(dossiersubmittingdate);
						statistics.setMen2submitting(actionUserName);
						break;
					case "300": //7. Ngay ky giay chung nhan moi, duoc lanh dao Cuc ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
					case "200": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "205": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1139") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1137") || actionCode.equalsIgnoreCase("1160"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1167"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						break;
					
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}	

					break;
				case "TT302011BGTVTCNCLKLLKXM": //Chung nhan chat luong kieu loai linh kien Xe mo to, xe gan may
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "204": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "215": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "227": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "136": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
						statistics.setDossiersubmittingdate(dossiersubmittingdate);
						statistics.setMen2submitting(actionUserName);
						break;
					case "300": //7. Ngay ky giay chung nhan moi, duoc lanh dao Cuc ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
					case "200": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "205": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1139") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1137") || actionCode.equalsIgnoreCase("1160"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1167"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						break;
					
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}	

					break;
				
				case "TT302011BGTVTCNCLKLTXXCG": //Chung nhan chat luong kieu loai toan xe Xe co gioi
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "204": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "215": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "227": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "136": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
						statistics.setDossiersubmittingdate(dossiersubmittingdate);
						statistics.setMen2submitting(actionUserName);
						break;
					case "300": //7. Ngay ky giay chung nhan moi, duoc lanh dao Cuc ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
					case "200": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "205": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1139") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1137") || actionCode.equalsIgnoreCase("1160"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1167"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						break;
					
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}	

					break;
				case "TT302011BGTVTCNCLKLTXXMTGM": //Chung nhan chat luong kieu loai toan xe Xe mo to, xe gan may
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "204": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "215": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "227": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "136": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
						statistics.setDossiersubmittingdate(dossiersubmittingdate);
						statistics.setMen2submitting(actionUserName);
						break;
					case "300": //7. Ngay ky giay chung nhan moi, duoc lanh dao Cuc ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
					case "200": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "205": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1139") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1137") || actionCode.equalsIgnoreCase("1160"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1167"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						break;
					
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}	
					break;
				case "TT302011BGTVTCNCLKLTXXDD": //Chung nhan chat luong kieu loai toan xe Xe dap dien
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "204": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "215": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "227": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "136": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
						statistics.setDossiersubmittingdate(dossiersubmittingdate);
						statistics.setMen2submitting(actionUserName);
						break;
					case "300": //7. Ngay ky giay chung nhan moi, duoc lanh dao Cuc ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
					case "200": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "205": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1139") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1137") || actionCode.equalsIgnoreCase("1160"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1167"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						break;
					
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}	
					break;
				case "TT302011BGTVTCNCLKLTXXBBCN": //Chung nhan chat luong kieu loai toan xe Xe cho nguoi bon banh co gan dong co
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "204": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "215": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "227": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "136": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
						statistics.setDossiersubmittingdate(dossiersubmittingdate);
						statistics.setMen2submitting(actionUserName);
						break;
					case "300": //7. Ngay ky giay chung nhan moi, duoc lanh dao Cuc ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
					case "200": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "205": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1139") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1137") || actionCode.equalsIgnoreCase("1160"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1167"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						break;
					
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}	
					break;
				case "TT302011BGTVTCNCLKLTXXBBCH": //Chung nhan chat luong kieu loai toan xe Xe cho hang bon banh co gan dong co
					switch (postStepCode) {
					
					case "130": //1. Nop ho so truc tuyen (hstt) lan dau dossiersendingdate / 
						Date dossiersendingdate = dossierActionModel.getCreateDate();
						statistics.setDossiersendingdate(dossiersendingdate);
						break;
					case "133": //2. Can bo tiep nhan hstt, chuyen to truong dossierreceivingdate / men2receiving
						Date dossierreceivingdate =  dossierActionModel.getCreateDate();						
						statistics.setDossierreceivingdate(dossierreceivingdate);
						statistics.setMen2receiving(actionUserName);
						break;
					case "131": //3. Ngay yeu cau bo sung hstt lan dau dossierfirstupdatingdate / men2firstupdating
						Date dossierfirstupdatingdate  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierfirstupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "204": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "215": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate2  =  dossierActionModel.getCreateDate();
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate2);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;
					case "225": //4. Ngay yeu cau bo sung hstt lan cuoi dossierlastupdatingdate / men2lastupdating
						Date dossierlastupdatingdate3  =  dossierActionModel.getCreateDate();						
						if (Validator.isNotNull(statistics) && Validator.isNotNull(statistics.getDossierfirstupdatingdate())) {
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						} else {
							statistics.setDossierfirstupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2firstupdating(actionUserName);
							statistics.setDossierlastupdatingdate(dossierlastupdatingdate3);
							statistics.setMen2lastupdating(actionUserName);
						}
						break;	
					case "134": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate);
						break;
					case "227": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate2 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate2);
						break;
					case "234": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate3 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate3);
						break;
					case "235": //5. Ngay nop BSSD hstt lan cuoi dossierendorsementdate / men2endorsement
						Date dossierendorsementdate4 = dossierActionModel.getCreateDate();
						statistics.setDossierendorsementdate(dossierendorsementdate4);
						break;
					case "136": //6. Ngay cap so hstt, duoc to truong chap thuan ho so dang ky dossiersubmittingdate / men2submitting
						Date dossiersubmittingdate  = dossierActionModel.getCreateDate();						
						statistics.setDossiersubmittingdate(dossiersubmittingdate);
						statistics.setMen2submitting(actionUserName);
						break;
					case "300": //7. Ngay ky giay chung nhan moi, duoc lanh dao Cuc ky moi dossierfirstcertificatesigndate / men2firstcertificate
						Date dossierfirstcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierfirstcertificatesigndate(dossierfirstcertificatesigndate);
						statistics.setMen2firstcertificate(actionUserName);
						break;
					case "200": //8. Ngay phan cong DKV lan dau (hstt cap moi, cap mo rong) dossierfirstassignmentdate / men2firstassignment
						// Phai lay tu phieu phan cong PPC
						if (Validator.isNotNull(statistics) && actionCode.equalsIgnoreCase("1118")) {
							Date dossierfirstassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierfirstassignmentdate(dossierfirstassignmentdate);
							statistics.setMen2firstassignment(actionUserName);
						}
						break;
					case "205": //9. Ngay bat dau soat xet hstt lan dau dossierfirstreviewdate / men2firstreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() == 0) {
							Date dossierfirstreviewdate  = dossierActionModel.getCreateDate();
							statistics.setDossierfirstreviewdate(dossierfirstreviewdate);
							statistics.setMen2firstreview(actionUserName);
						}
						break;
					case "208": //10. Ngay ket thuc soat xet hstt lan dau dossiernexttreviewdate / men2nexttreview
						if (Validator.isNotNull(statistics) && statistics.getMen2firstreview().trim().length() > 0) {
							Date dossiernexttreviewdate  = dossierActionModel.getCreateDate();							
							statistics.setDossiernexttreviewdate(dossiernexttreviewdate);
							statistics.setMen2nexttreview(actionUserName);
						}
						break;
					case "211": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1138") || actionCode.equalsIgnoreCase("1320"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "221": //11. Ngay phan cong DKV lan cuoi (hstt cap lai, cap bo sung) dossierlastassignmentdate / men2lastassignment
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1139") || actionCode.equalsIgnoreCase("1322"))) {
							Date dossierlastassignmentdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastassignmentdate(dossierlastassignmentdate);
							statistics.setMen2lastassignment(actionUserName);
						}
						break;
					case "216": //12. Ngay soat xet hstt dieu chinh (do cap lai, bo sung) dossierreviewadjustdate / men2reviewadjust
						if (Validator.isNotNull(statistics)) {
							Date dossierreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierreviewadjustdate(dossierreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "218": //13. Ngay ket thuc soat xet hstt dieu chinh lan cuoi (do cap lai) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						}
					case "226": //13. Ngay bat dau soat xet hstt dieu chinh lan cuoi (do bo sung) dossierlastreviewadjustdate / men2lastreviewadjust
						if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
						} else if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() == 0 ) {
							Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
							statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2lastreviewadjust(actionUserName);
							statistics.setDossierreviewadjustdate(dossierlastreviewadjustdate);
							statistics.setMen2reviewadjust(actionUserName);
						}
						break;
					case "301": //14. Ngay ky giay chung nhan cap lai, lan cuoi, dossierlastcertificatesigndate / men2lastcertificatesign
						Date dossierlastcertificatesigndate   =  dossierActionModel.getCreateDate();						
						statistics.setDossierlastcertificatesigndate(dossierlastcertificatesigndate);
						statistics.setMen2lastcertificatesign(actionUserName);
						break;
					
					case "400": //15. Ngay ho so den han tra ket qua dossierdeadline /
						//16. Ngay tra ket qua truc tuyen dossierfinisheddate / men2finished
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1137") || actionCode.equalsIgnoreCase("1160"))) {
							Date dossierfinisheddate   =  dossierActionModel.getCreateDate();						
							statistics.setDossierfinisheddate(dossierfinisheddate);
							statistics.setMen2finished(actionUserName);
						}
						//Ngay soat xet hstt va chap thuan dieu chinh (do cap lai, bo sung) 
						if (Validator.isNotNull(statistics) && (actionCode.equalsIgnoreCase("1167"))) {
							if (Validator.isNotNull(statistics) && statistics.getMen2reviewadjust().trim().length() > 0 ) {
								Date dossierlastreviewadjustdate  = dossierActionModel.getCreateDate();							
								statistics.setDossierlastreviewadjustdate(dossierlastreviewadjustdate);
								statistics.setMen2lastreviewadjust(actionUserName);
							}							
						}
						break;
					
					case "229": //17. Ngay ho so dong y huy dossiercancellingdate / men2cancelled
						Date dossiercancellingdate   =  dossierActionModel.getCreateDate();						
						statistics.setDossiercancellingdate(dossiercancellingdate);
						statistics.setMen2cancelled(actionUserName);
						break;
					case "+++": //18. Ngay giay chung nhan phai xem xet hieu luc dossierexpiredate / men2expired
					
						break;
					case "++++": //19. Ngay xem xet ho so tam dinh chi hieu luc / thu  hoi dossierviolatingdate / men2violated
					
						break;
					case "+++++": //20. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi tu ngay dossierviolatingfromdate
					//21. Ngay giay chung nhan tam dinh chi hieu luc/ thu hoi den ngay dossierviolatingtodate					
					
						break;
					default:
						break;
					}	
					break;
				case "TT302011BGTVTCPPXCG": //Cap phat va su dung phieu kiem tra chat luong xuat xuong Xe co gioi
					
					break;
				case "TT302011BGTVTCPPXMTGM": //Cap phat va su dung phieu kiem tra chat luong xuat xuong Xe mo to, xe gan may
					
					break;
				case "TT302011BGTVTCPPXDD": //Cap phat va su dung tem hop quy Xe dap dien 
					
					break;
				case "TT302011BGTVTCPPXBBCN": //Cap phat va su dung phieu kiem tra chat luong xuat xuong Xe cho nguoi bon banh co gan dong co
					
					break;
				
				case "TT302011BGTVTCPPXBBCH": //Cap phat va su dung phieu kiem tra chat luong xuat xuong Xe cho hang bon banh co gan dong co
					
					break;
				case "TT302011BGTVTCPPXCD": //Cap phat va su dung phieu kiem tra chat luong xuat xuong Xe may chuyen dung
					
					break;
				
				case "TT302011BGTVTCNCLKLXMCD": //Chung nhan chat luong kieu loai toan xe Xe may chuyen dung
					
					break;
				case "TT302011BGTVTCNCLKLLKXCD": //Chung nhan chat luong kieu loai linh kien Xe may chuyen dung
					
					break;
				
				case "TT302011BGTVTCNCLKLLKXDD": //Chung nhan chat luong kieu loai linh kien Xe dap dien
					
					break;
				case "TT302011BGTVTCNCLKLLKXCN": //Chung nhan chat luong kieu loai linh kien Xe cho nguoi bon banh co gan dong co
					
					break;
				case "TT302011BGTVTCNCLKLLKXCH": //Chung nhan chat luong kieu loai linh kien Xe cho hang bon banh co gan dong co
					
					break;
				case "TT302011BGTVTTHSPNK": //Trieu hoi san pham Xe co gioi nhap khau linh kien de san xuat lap rap xe
					
					break;
				case "TT302011BGTVTTHSPSXLR": //Trieu hoi san pham Xe co gioi san xuat, lap rap linh kien de san xuat lap rap xe
					
					break;
				
				default:
					break;
				}
			
				
				
				
				if (flagUpdate == true) {
					VRRPDossierStatisticsLocalServiceUtil.updateVRRPDossierStatistics(statistics);
				} else {
					VRRPDossierStatisticsLocalServiceUtil.addVRRPDossierStatistics(statistics);
				}
			}
			
			return processNo;	
		} catch (SystemException e) {
			_log.error(e);
			return "";
		}
	}
	
	private Log _log = LogFactoryUtil.getLog(DossierActionListenner.class.getName());
}