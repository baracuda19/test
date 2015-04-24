/**
 * 
 */
package com.sabre.hospitality.service.v1.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.util.FileCopyUtils;

import com.sabre.hospitality.domain.payments.v300.PaymentRQ;
import com.sabre.hospitality.domain.payments.v300.PaymentRS;
import com.sabre.hospitality.service.v1.payments.PaymentsRequest;
import com.sabre.hospitality.service.v1.payments.PaymentsRequestBuilder;
import com.sabre.hospitality.service.v1.payments.utils.PaymentsTestUtils;
import com.sabre.saap.commons.domain.soap.ebxml.Envelope;

/**
 * @author Vishal Bhasin
 *
 */
public class TransformationUtilsTest {

	private static final String CPAID = "cpaid";
	private static final String ATHID = "athid";
	PaymentRQ request;
	String responseStr;
	ObjectMapper mapper;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mapper = new ObjectMapper();
		PaymentsRequestBuilder builder = new PaymentsRequestBuilder();
		PaymentsRequest map = PaymentsTestUtils.createPaymentRequest();
		Envelope env = builder.build(map, ATHID, CPAID);
		request = ((PaymentRQ) env.getBody().getAny().get(0));
		
		responseStr = FileCopyUtils.copyToString(new InputStreamReader(Thread
				.currentThread().getContextClassLoader()
				.getResourceAsStream("testPaymentRS_3.0.0.xml")));
	}
	
	@Test
	public void jaxbToString() {
		try {
			assertTrue(TransformationUtils.convertPaymentRQToString(request).contains(CPAID));
		} catch (Exception e) {
			fail("Not expecting an exception");
			e.printStackTrace();
		}
	}
	
	@Test
	public void stringToJaxb() {
		try {
			PaymentRS paymentRS = TransformationUtils.convertStringToPaymentRS(responseStr);
			assertNotNull(paymentRS.getSabreTransactionID());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Not expecting an exception");
		}
		
	}
}
