package com.sabre.hospitality.service.v1.payments;

import static com.sabre.saap.commons.util.LogUtils.logException;

import javax.annotation.PostConstruct;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.sabre.hospitality.service.v1.util.TransformationUtils;
import com.sabre.saap.commons.dao.WebServiceDao;
import com.sabre.saap.commons.domain.soap.ebxml.Envelope;
import com.sabre.saap.commons.log.LogMetrics;
import com.sabre.saap.commons.service.util.TransformUtils;

/**
 * 
 * @author Vishal Bhasin
 *
 */
@Service
public class PaymentsService {
	private final static String CLASS_NAME = PaymentsService.class
			.getSimpleName();

	protected Logger log = LoggerFactory.getLogger(getClass());

	@Value("${sws.url}")
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Value("${sws.cpaId}")
	private String cpaId;

	public String getCpaId() {
		return cpaId;
	}

	public void setCpaId(String cpaId) {
		this.cpaId = cpaId;
	}

	@PostConstruct
	public void init() {
	}

	//TODO WIP
	@LogMetrics
	public JsonNode makePayment(PaymentsRequest paymentRequest, String athid) throws Exception {
		JsonNode response;
		try {
			log.info("Payment Request :\n"+objectMapper.writeValueAsString(paymentRequest));
			Envelope requestRQ = new PaymentsRequestBuilder().build(paymentRequest, athid, cpaId);
			log.info("Envelope :\n"+objectMapper.writeValueAsString(requestRQ));
			String requestStr = TransformationUtils.convertPaymentRQToString(requestRQ);
			//TODO Filter CC info
			log.info("Request XML:\n{}",requestStr);
			Document responseDoc = callSWS(requestStr, athid);
			log.info("Response XML:\n" + responseDoc.asXML());
			response = objectMapper.readTree(TransformUtils.xmlToJson(responseDoc.asXML()).toString());
			log.info("Response JSON:\n" + response.toString());
		} catch (Exception e) {
				logException(CLASS_NAME, "makePayment",
						"Unable to process payment", e);
				throw e;
		}
		return response;
	}

	@LogMetrics
	private Document callSWS(String request, String athid)
			throws DocumentException, Exception {
		
		return DocumentHelper.parseText(webServiceDao.postRequest(url, request));
	}

	@Autowired
	private ObjectMapper objectMapper;

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Autowired
	private WebServiceDao webServiceDao;

	public void setWebServiceDao(WebServiceDao webServiceDao) {
		this.webServiceDao = webServiceDao;
	}
}
