package vn.gt.tool.rest.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.opencps.dossiermgt.model.Dossier;
import org.opencps.dossiermgt.model.DossierFile;
import org.opencps.dossiermgt.service.DossierFileLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;

import vn.gt.dao.model.CompressFileJob;
import vn.gt.dao.model.PushStatisticsLog;
import vn.gt.dao.service.CompressFileJobLocalServiceUtil;
import vn.gt.dao.service.PushStatisticsLogLocalServiceUtil;
import vn.gt.tool.context.provider.CompanyContextProvider;
import vn.gt.tool.context.provider.LocaleContextProvider;
import vn.gt.tool.context.provider.ServiceContextProvider;
import vn.gt.tool.context.provider.UserContextProvider;
import vn.gt.tool.util.CompressFileUtil;
import vn.gt.tool.util.PushStatisticsUtil;

/**
 * @author huymq
 */
@ApplicationPath("/files")
@Component(immediate = true, service = Application.class)
public class BackendToolApplication extends Application {

	public Set<Object> getSingletons() {
		
		Set<Object> singletons = new HashSet<Object>();
		singletons.add(this);
		
		singletons.add(_serviceContextProvider);
		singletons.add(_companyContextProvider);
		singletons.add(_localeContextProvider);
		singletons.add(_userContextProvider);
		
		return singletons;
	}
	
//	@PUT
//	@Path("/dossier/{dossierId}")
//	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
//	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	public Response compressDossier(@Context HttpServletRequest request, @Context HttpHeaders header,
//			@Context Company company, @Context Locale locale, @Context User user,
//			@Context ServiceContext serviceContext,  @PathParam("dossierId") long dossierId) {
//		
//		String ok = "ok";
//		
//		try {
//			if(dossierId > 0) {
//				Dossier dossier = DossierLocalServiceUtil.getDossier(dossierId);
//				
//				List<Dossier> listHoSo = new ArrayList<Dossier>();
//				listHoSo.add(dossier);
//				
//				doCompress(listHoSo);
//			}
//		} catch (Exception e) {
//			_log.error(e);
//			ok = "OH SHIT !";
//			return Response.status(500).entity(ok).build();
//		}
//		
//		return Response.status(200).entity(ok).build();
//		
//	}
//	
//	@POST
//	@Path("/dossiers")
//	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
//	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	public Response compressDossier(@Context HttpServletRequest request, @Context HttpHeaders header,
//			@Context Company company, @Context Locale locale, @Context User user,
//			@Context ServiceContext serviceContext,  @FormParam(value="dossierIds") String dossierIds) {
//		
//		String ok = "ok";
//		
//		try {
//			long[] lDossierIds = StringUtil.split(dossierIds, ",", 0l);
//			List<Dossier> listHoSo = new ArrayList<Dossier>(); 
//			
//			for(long lDossierId : lDossierIds) {
//				if(lDossierId > 0) {
//					Dossier dossier = DossierLocalServiceUtil.fetchDossier(lDossierId);
//					
//					if(dossier != null) {
//						listHoSo.add(dossier);
//					}
//				}
//			}
//			
//			doCompress(listHoSo);
//		} catch (Exception e) {
//			_log.error(e);
//			ok = "OH SHIT !";
//			return Response.status(500).entity(ok).build();
//		}
//		
//		return Response.status(200).entity(ok).build();
//		
//	}
//	
//	@PUT
//	@Path("/{count}")
//	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
//	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	public Response compressList(@Context HttpServletRequest request, @Context HttpHeaders header,
//			@Context Company company, @Context Locale locale, @Context User user,
//			@Context ServiceContext serviceContext,  @PathParam("count") int count) {
//		
//		String ok = "ok";
//		
//		try {
//			if(count == 0) {
//				count = 100;
//			}
//			
//			long lastedHoSoId = CompressFileJobLocalServiceUtil.getLastedHoSoId();
//			
//			DynamicQuery hosoQuery = DossierLocalServiceUtil.dynamicQuery();
//			
//			String[] trangThais = new String[]{TrangThaiHoSo.APPROVED,TrangThaiHoSo.CANCELED,TrangThaiHoSo.ENDED};
//			
//			hosoQuery.add(PropertyFactoryUtil.forName("groupId").eq(55301l));
//			hosoQuery.add(PropertyFactoryUtil.forName("dossierStatus").in(trangThais));
//			hosoQuery.add(PropertyFactoryUtil.forName("dossierId").gt(lastedHoSoId));
//			hosoQuery.addOrder(OrderFactoryUtil.asc("dossierId"));
//	
//			
//			List<Dossier> listHoSo = DossierLocalServiceUtil.dynamicQuery(hosoQuery, 0, count);
//			
//			doCompress(listHoSo);
//		} catch (Exception e) {
//			_log.error(e);
//			ok = "OH SHIT !";
//			return Response.status(500).entity(ok).build();
//		}
//		
//		return Response.status(200).entity(ok).build();
//		
//	}
//	
//	private static void doCompress(List<Dossier> listHoSo) throws SystemException, PortalException, IOException, InterruptedException, TimeoutException {
//		
//		if(listHoSo != null && listHoSo.size() > 0) {
//			CompressFileJob compressFileJob = CompressFileJobLocalServiceUtil.addJob(listHoSo);
//			
//			for(Dossier hoSo : listHoSo) {
//				_log.info("CompressFile:" + listHoSo.size() + ": " + hoSo.getDossierTemplateNo() + ": " + hoSo.getReferenceUid() + ": " + hoSo.getDossierNo());
//				
//				List<DossierFile> listGiayToDinhKemHoSo = DossierFileLocalServiceUtil.getDossierFilesByDossierId(hoSo.getDossierId());
//				
//				for(DossierFile giayToDinhKemHoSo : listGiayToDinhKemHoSo) {
//					if(giayToDinhKemHoSo.getDossierPartType() == 1) {
//						CompressFileUtil.compressFile(hoSo.getDossierId(), giayToDinhKemHoSo.getFileEntryId());
//					}
//				}
//			}
//			
//			CompressFileJobLocalServiceUtil.updateCompressFileJob(compressFileJob.getId());
//		}
//	}
	
	@PUT
	@Path("/{count}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response pushList(@Context HttpServletRequest request, @Context HttpHeaders header,
			@Context Company company, @Context Locale locale, @Context User user,
			@Context ServiceContext serviceContext,  @PathParam("count") int count) {
		
		String ok = "ok";
		
		try {
			if(count == 0) {
				count = 100;
			}
			
			PushStatisticsLog lastedPushStatisticsLog = PushStatisticsLogLocalServiceUtil.getLasted();
			
			DynamicQuery hosoQuery = DossierLocalServiceUtil.dynamicQuery();
			
			hosoQuery.add(PropertyFactoryUtil.forName("groupId").eq(55301l));
			hosoQuery.add(PropertyFactoryUtil.forName("dossierStatus").eq(TrangThaiHoSo.APPROVED));
			if(lastedPushStatisticsLog != null) {
				hosoQuery.add(PropertyFactoryUtil.forName("finishDate").gt(lastedPushStatisticsLog.getFinishDate()));
			}
			hosoQuery.addOrder(OrderFactoryUtil.asc("finishDate"));
	
			
			List<Dossier> listHoSo = DossierLocalServiceUtil.dynamicQuery(hosoQuery, 0, count);
			
			doPush(listHoSo);
		} catch (Exception e) {
			_log.error(e);
			ok = "OH SHIT !";
			return Response.status(500).entity(ok).build();
		}
		
		return Response.status(200).entity(ok).build();
		
	}
	
	private static void doPush(List<Dossier> listHoSo) throws SystemException, PortalException, IOException, InterruptedException, TimeoutException {
		
		if(listHoSo != null && listHoSo.size() > 0) {
			for(Dossier hoSo : listHoSo) {
				_log.info("PushDossier:" + hoSo.getDossierId());
				
				long newDossierId = PushStatisticsUtil.postDossier(hoSo);
				
				PushStatisticsLogLocalServiceUtil.addLog(hoSo.getDossierId(), newDossierId, hoSo.getFinishDate());
			}
		}
	}
	
	private static interface TrangThaiHoSo{
		final public static String APPROVED = "done";
		final public static String ENDED = "ended";
		final public static String CANCELED = "cancelled";
	}	
	
	@Reference
	private CompanyContextProvider _companyContextProvider;

	@Reference
	private LocaleContextProvider _localeContextProvider;

	@Reference
	private UserContextProvider _userContextProvider;

	@Reference
	private ServiceContextProvider _serviceContextProvider;
	
	private static final Log _log = LogFactoryUtil.getLog(BackendToolApplication.class);

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

}