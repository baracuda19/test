package com.sabre.hospitality.service.v1.payments.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import com.sabre.hospitality.service.v1.payments.PaymentsRequest;

/**
 * 
 * @author Vishal Bhasin
 *
 */
public class PaymentsTestUtils {

	private static ObjectMapper mapper = new ObjectMapper();
	protected Logger log = LoggerFactory.getLogger(getClass());

	public static PaymentsRequest createPaymentRequest() throws IOException {
		PaymentsRequest request = mapper.readValue(
				FileCopyUtils.copyToString(new InputStreamReader(Thread
						.currentThread().getContextClassLoader()
						.getResourceAsStream("authRQv1.json"))),
				PaymentsRequest.class);

		System.out.println(mapper.writeValueAsString(request));
		return request;
	}

}
