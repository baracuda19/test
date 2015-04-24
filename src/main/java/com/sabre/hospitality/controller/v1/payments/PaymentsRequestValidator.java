/**
 * 
 */
package com.sabre.hospitality.controller.v1.payments;

import static com.sabre.saap.commons.controller.util.ValidationUtils.validateRequiredParameter;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sabre.hospitality.PaymentConstants;
import com.sabre.hospitality.service.v1.payments.PaymentsRequest;

/**
 * @author Vishal Bhasin
 *
 */
//TODO - finish validation
@Component
public class PaymentsRequestValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return PaymentsRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		PaymentsRequest request = (PaymentsRequest) target;
		validateRequiredPaymentFields(request);
	}

	private void validateRequiredPaymentFields(PaymentsRequest request) {
		Map<String, Object> paymentInfo = (Map<String, Object>) request.getPayment();
		if (paymentInfo.get(PaymentConstants.PAYMENT_CODE) == null)
			validateRequiredParameter(null, PaymentConstants.PAYMENT_CODE);
		if (paymentInfo.get(PaymentConstants.CREDIT_CARD_NUMBER) == null) 
			validateRequiredParameter(null, PaymentConstants.CREDIT_CARD_NUMBER);
		if (paymentInfo.get(PaymentConstants.CREDIT_CARD_CCV) == null)
			validateRequiredParameter(null, PaymentConstants.CREDIT_CARD_CCV);
		if (paymentInfo.get(PaymentConstants.FOP) == null) 
			validateRequiredParameter(null, PaymentConstants.FOP);
		if (paymentInfo.get(PaymentConstants.AMOUNT) == null) 
			validateRequiredParameter(null, PaymentConstants.AMOUNT);
		if (paymentInfo.get(PaymentConstants.CURRENCY) == null) 
			validateRequiredParameter(null, PaymentConstants.CURRENCY);
		if (paymentInfo.get(PaymentConstants.CARD_HOLDER_NAME) == null) 
			validateRequiredParameter(null, PaymentConstants.CARD_HOLDER_NAME);
		if (paymentInfo.get(PaymentConstants.CREDIT_CARD_EXP_DATE) == null)
			validateRequiredParameter(null, PaymentConstants.CREDIT_CARD_EXP_DATE);
	}

}
