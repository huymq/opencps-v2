package vn.gt.tool.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.opencps.dossiermgt.model.Dossier;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;

public class PushStatisticsUtil {
	private static final String BASE_URL = "http://10.21.51.55:8081/o/rest/v2/dossiers/publish";//PrefsPropsUtil.getString("push.statistics.api.url");
//	private static final String BASE_URL = "http://kiemthu.mt.gov.vn:9002/o/rest/v2/dossiers/publish";
	private static final String USER_NAME = "test@liferay.com";
	private static final String PASS_WORD = "Dvc@2020#";
	
	public static long postDossier(Dossier model) {

		long newDossierId = -1;
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse clientResponse = null;
		BufferedReader br = null;

		try {
			
			String authorization = Base64.encode((USER_NAME + ":" + PASS_WORD).getBytes());

			int timeout = 15;
			RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout * 1000)
					.setConnectionRequestTimeout(timeout * 1000).setSocketTimeout(timeout * 1000).build();

			httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

			List<NameValuePair> params = convertHttpParams(model);

			HttpPost postRequest = new HttpPost(BASE_URL);
			postRequest.setHeader("Accept", "application/json");
			postRequest.setHeader("groupId", "35166");
			
			postRequest.setHeader("Authorization", "Basic " + authorization);

			postRequest.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

			clientResponse = httpClient.execute(postRequest);

			_log.info("===clientResponse.getStatusLine().getStatusCode()==" + clientResponse.getStatusLine().getStatusCode());
			
			if (clientResponse.getStatusLine().getStatusCode() == 200) {
				br = new BufferedReader(new InputStreamReader((clientResponse.getEntity().getContent())));
				String output = "";

				StringBuilder jsonString = new StringBuilder();

				while ((output = br.readLine()) != null) {
					jsonString.append(output);
				}

				JSONObject json = JSONFactoryUtil.createJSONObject(jsonString.toString());
				
				_log.info(json.toString());
				
				newDossierId = GetterUtil.getLong(json.getString("dossierId"));
			} else {
				_log.info("===clientResponse.getStatusLine().getStatusCode()==" + clientResponse.getStatusLine().getStatusCode());
				
				br = new BufferedReader(new InputStreamReader((clientResponse.getEntity().getContent())));
				String output = "";

				StringBuilder jsonString = new StringBuilder();

				while ((output = br.readLine()) != null) {
					jsonString.append(output);
				}

				JSONObject json = JSONFactoryUtil.createJSONObject(jsonString.toString());
				
				_log.info(json.toString());
			}
		} catch (Exception e) {
			_log.error(e);
		} finally {

			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					_log.error(e);
				}
			}

			if (clientResponse != null) {
				try {
					clientResponse.close();
				} catch (IOException e) {
					_log.error(e);
				}
			}

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					_log.error(e);
				}
			}
		}

		return newDossierId;
	}

	public static List<NameValuePair> convertHttpParams(Dossier model) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();

//		params.add(new BasicNameValuePair("groupId", "35166"));
		params.add(new BasicNameValuePair("address", model.getAddress()));
		params.add(new BasicNameValuePair("applicantIdDate",
				model.getApplicantIdDate() == null ? "0" : String.valueOf(model.getApplicantIdDate().getTime())));
		params.add(new BasicNameValuePair("applicantIdNo", model.getApplicantIdNo()));
		params.add(new BasicNameValuePair("applicantIdType", model.getApplicantIdType()));
		params.add(new BasicNameValuePair("applicantName", model.getApplicantName()));
		params.add(new BasicNameValuePair("cityName", model.getCityName()));
		params.add(new BasicNameValuePair("contactEmail", model.getContactEmail()));
		params.add(new BasicNameValuePair("contactName", model.getContactName()));
		params.add(new BasicNameValuePair("contactTelNo", model.getContactTelNo()));
		params.add(new BasicNameValuePair("createDate",
				model.getCreateDate() == null ? "0" : String.valueOf(model.getCreateDate().getTime())));
		params.add(new BasicNameValuePair("delegateAddress", model.getDelegateAddress()));
		params.add(new BasicNameValuePair("delegateCityName", model.getDelegateCityName()));
		params.add(new BasicNameValuePair("delegateEmail", model.getDelegateEmail()));
		params.add(new BasicNameValuePair("delegateIdNo", model.getDelegateIdNo()));
		params.add(new BasicNameValuePair("delegateName", model.getDelegateName()));
		params.add(new BasicNameValuePair("delegateTelNo", model.getDelegateTelNo()));
		params.add(new BasicNameValuePair("delegateWardName", model.getDelegateWardName()));
		params.add(new BasicNameValuePair("districtName", model.getDistrictName()));
		params.add(new BasicNameValuePair("dossierName", model.getServiceName()));
		params.add(new BasicNameValuePair("dossierNo", model.getDossierNo()));
		params.add(new BasicNameValuePair("dossierStatus", model.getDossierStatus()));
		params.add(new BasicNameValuePair("dossierStatusText", model.getDossierStatusText()));
		params.add(new BasicNameValuePair("dossierTemplateNo", model.getDossierTemplateNo()));
		params.add(new BasicNameValuePair("dueDate",
				model.getDueDate() == null ? "0" : String.valueOf(model.getDueDate().getTime())));
		params.add(new BasicNameValuePair("durationCount", "2"));
		params.add(new BasicNameValuePair("durationUnit", "0"));
		params.add(new BasicNameValuePair("finishDate",
				model.getFinishDate() == null ? "0" : String.valueOf(model.getFinishDate().getTime())));
		params.add(new BasicNameValuePair("govAgencyCode", model.getGovAgencyCode()));
		params.add(new BasicNameValuePair("govAgencyName", model.getGovAgencyName()));
		params.add(new BasicNameValuePair("modifiedDate",
				model.getModifiedDate() == null ? "0" : String.valueOf(model.getModifiedDate().getTime())));
		params.add(new BasicNameValuePair("online", Boolean.toString(model.getOnline())));
		if (model.getOriginal()) {
			params.add(new BasicNameValuePair("originality", "1"));
		} else {
			params.add(new BasicNameValuePair("originality", "0"));
		}

		params.add(new BasicNameValuePair("receiveDate",
				model.getReceiveDate() == null ? "0" : String.valueOf(model.getReceiveDate().getTime())));
		params.add(new BasicNameValuePair("referenceUid", model.getReferenceUid()));
		params.add(new BasicNameValuePair("releaseDate",
				model.getFinishDate() == null ? "0" : String.valueOf(model.getFinishDate().getTime())));
		params.add(new BasicNameValuePair("serviceCode", model.getServiceCode()));
		params.add(new BasicNameValuePair("serviceName", model.getServiceName()));
		params.add(new BasicNameValuePair("submitDate",
				model.getSubmitDate() == null ? "0" : String.valueOf(model.getSubmitDate().getTime())));
		params.add(new BasicNameValuePair("systemId", "1"));
		params.add(new BasicNameValuePair("wardName", model.getWardName()));
		params.add(new BasicNameValuePair("dossierActionId", "10"));
		params.add(new BasicNameValuePair("systemCode", "QLVTQT"));
		
		StringBuilder sb = new StringBuilder();
		for(NameValuePair param : params) {
			sb.append("--data-urlencode '" + param.getName() + "=" + param.getValue() + "' ");
		}
		
		_log.info(sb);

		return params;
	}
	
	private static Log _log = LogFactoryUtil.getLog(PushStatisticsUtil.class);
}
