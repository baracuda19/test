package com.sabre.hospitality.controller.v1.payments;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.WebDataBinder;

import com.sabre.hospitality.service.v1.payments.PaymentsRequest;
import com.sabre.hospitality.service.v1.payments.PaymentsService;
import com.sabre.radius.client.ice.IceSession;
import com.sabre.radius.client.ice.IceSessionPool;

/**
 * 
 * @author Vishal Bhasin
 *
 */
public class PaymentsControllerTest {

	PaymentsController cont = new PaymentsController();
	@Mock
	private IceSessionPool poolMock;
	@Mock
	private PaymentsService serviceMock;
	@Mock
	private HttpServletRequest httpServletRequestMock;
	private ObjectMapper objectMapper = new ObjectMapper();
	@Mock
	private PaymentsRequestValidator paymentsRequestValidatorMock;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		cont.setIceSessionPool(poolMock);
		cont.setObjectMapper(objectMapper);
		cont.setPaymentService(serviceMock);
		cont.setPaymentsRequestValidator(paymentsRequestValidatorMock);
	}
	
	@Test
	public void initBinder() {
		WebDataBinder webDataBinderMock = mock(WebDataBinder.class);
		cont.initBinder(webDataBinderMock);
		verify(webDataBinderMock).setValidator(paymentsRequestValidatorMock);
	}


	@Test
	public void authorizePayment() throws Exception {
		when(poolMock.borrowSession()).thenReturn(new IceSession());
		when(serviceMock.makePayment(anyObject(), anyString())).thenReturn(objectMapper.createObjectNode());
		PaymentsRequest request = new PaymentsRequest();
		assertNotNull(cont.authorizePayment(httpServletRequestMock, request));

	}

}
