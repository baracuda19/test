package com.sabre.hospitality.service.v1.payments;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sabre.hospitality.domain.payments.v300.PaymentRQ;
import com.sabre.hospitality.service.v1.payments.utils.PaymentsTestUtils;
import com.sabre.hospitality.service.v1.util.TransformationUtils;
import com.sabre.saap.commons.domain.soap.ebxml.Envelope;

/**
 * 
 * @author Vishal Bhasin
 *
 */
public class PaymentsRequestBuilderTest {

	private static final String cpaId = "1234";
	private static final String athId = "testATHID";
	
	protected Logger log = LoggerFactory.getLogger(getClass());

	PaymentsRequestBuilder builder = new PaymentsRequestBuilder();

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void build() throws Exception {
		
		PaymentsRequest map = PaymentsTestUtils.createPaymentRequest();
		Envelope request = builder.build(map, athId, cpaId);
		String requestStr = TransformationUtils.convertPaymentRQToString(request);
		log.info("Request XML:\n{}",requestStr);
		System.out.println(requestStr);
		assertTrue(((PaymentRQ) request.getBody().getAny().get(0)).getPOS()
				.getPseudoCityCode().equals(cpaId));
	}

}
