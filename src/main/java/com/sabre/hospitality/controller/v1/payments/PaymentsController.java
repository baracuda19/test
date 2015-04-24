package com.sabre.hospitality.controller.v1.payments;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sabre.hospitality.service.v1.payments.PaymentsRequest;
import com.sabre.hospitality.service.v1.payments.PaymentsService;
import com.sabre.radius.client.ice.IceSession;
import com.sabre.radius.client.ice.IceSessionPool;
import com.sabre.saap.commons.controller.AbstractController;
import com.sabre.saap.commons.log.LogMetrics;


/**
 * 
 * @author Vishal Bhasin
 */
@RequestMapping("/v1/payments")
@Controller
public class PaymentsController extends AbstractController {
	
	@Autowired
	private IceSessionPool pool;

	void setIceSessionPool(IceSessionPool pool) {
		this.pool = pool;
	}
	
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PaymentsRequestValidator paymentsRequestValidator;
	
	/**
	 * @return the paymentsRequestValidator
	 */
	public PaymentsRequestValidator getPaymentsRequestValidator() {
		return paymentsRequestValidator;
	}

	/**
	 * @param paymentsRequestValidator the paymentsRequestValidator to set
	 */
	public void setPaymentsRequestValidator(
			PaymentsRequestValidator paymentsRequestValidator) {
		this.paymentsRequestValidator = paymentsRequestValidator;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(paymentsRequestValidator);
	}

	@RequestMapping(value = "/authorize", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@LogMetrics
	public @ResponseBody ResponseEntity<JsonNode> authorizePayment(HttpServletRequest servletRequest,
			@Valid @RequestBody PaymentsRequest paymentRequest) throws Exception {				

		IceSession session = pool.borrowSession();
        String athid = session.getAthId();
        //TODO - take action if ATHID is null (or times out)
        log.info(athid);
        
        JsonNode response = paymentService.makePayment(paymentRequest, athid);
        
        pool.returnSession(session);
                
		return new ResponseEntity<JsonNode>(response, HttpStatus.OK);		
	}
	
	@Autowired
	private PaymentsService paymentService;

	public PaymentsService getPaymentService() {
		return paymentService;
	}


	public void setPaymentService(PaymentsService paymentService) {
		this.paymentService = paymentService;
	}
}
