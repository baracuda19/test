/**
 * 
 */
package com.sabre.hospitality.controller.v1.payments;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.Errors;
import org.springframework.web.client.HttpClientErrorException;

import com.sabre.hospitality.PaymentConstants;
import com.sabre.hospitality.service.v1.payments.PaymentsRequest;

/**
 * @author Vishal Bhasin
 *
 */
public class PaymentsRequestValidatorTest {

	private PaymentsRequestValidator validator;
	private PaymentsRequest request;
	@Mock
	private Errors errorsMock;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		validator = new PaymentsRequestValidator();
		request = new PaymentsRequest();
		Map<String, Object> context = new HashMap<String, Object>();
		request.setContext(context);
		Map<String, Object> guest = new HashMap<String, Object>();
		request.setGuest(guest);
		Map<String, Object> payment = new HashMap<String, Object>();
		request.setPayment(payment);
	}

	/**
	 * Test method for {@link com.sabre.hospitality.controller.v1.payments.PaymentsRequestValidator#validate(java.lang.Object, org.springframework.validation.Errors)}.
	 */
	@Test
	public void testValidate() {
		try {
			validator.validate(request, errorsMock);
			fail("An exception should have been thrown!");
		} catch (HttpClientErrorException ex) {
			assertEquals(
					"400 Parameter '" + PaymentConstants.PAYMENT_CODE + "' must be specified",
					ex.getMessage());
		}
		request.getPayment().put(PaymentConstants.PAYMENT_CODE, "test");
		request.getPayment().put(PaymentConstants.CREDIT_CARD_CCV, "test");
		try {
			validator.validate(request, errorsMock);
			fail("An exception should have been thrown!");
		} catch (HttpClientErrorException ex) {
			assertEquals(
					"400 Parameter '" + PaymentConstants.CREDIT_CARD_NUMBER + "' must be specified",
					ex.getMessage());
		}
		request.getPayment().put(PaymentConstants.FOP, "test");
		request.getPayment().put(PaymentConstants.AMOUNT, "test");
		request.getPayment().put(PaymentConstants.CURRENCY, "test");
		request.getPayment().put(PaymentConstants.CARD_HOLDER_NAME, "test");
		request.getPayment().put(PaymentConstants.CREDIT_CARD_EXP_DATE, "test");
		request.getPayment().put(PaymentConstants.CREDIT_CARD_NUMBER, "test");
		try {
			validator.validate(request, errorsMock);
		} catch (HttpClientErrorException ex) {
			ex.printStackTrace();
			fail("No exception expected!");
		}
		
	}

}
