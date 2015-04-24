package com.sabre.hospitality.service.v1.payments;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.InputStreamReader;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.util.FileCopyUtils;

import com.sabre.hospitality.service.v1.payments.utils.PaymentsTestUtils;
import com.sabre.saap.commons.dao.WebServiceDao;

/**
 * 
 * @author Vishal Bhasin
 *
 */
public class PaymentsServiceTest {

	PaymentsService service = new PaymentsService();
	private ObjectMapper objectMapper = new ObjectMapper();
	private static final String ATHID = "testathid";
	private static final String CPAID = "NQ2F";
	private static String URL = "http://host";
	@Mock
	private WebServiceDao webServiceDaoMock;
	private String request, response;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service.setObjectMapper(objectMapper);
		service.setUrl(URL.trim());
		service.setCpaId(CPAID);
		service.setWebServiceDao(webServiceDaoMock);
		request = FileCopyUtils.copyToString(new InputStreamReader(Thread
				.currentThread().getContextClassLoader()
				.getResourceAsStream("UnitTestPaymentRQ.xml")));
		response = FileCopyUtils.copyToString(new InputStreamReader(Thread
				.currentThread().getContextClassLoader()
				.getResourceAsStream("testPaymentRS.xml")));
	}

	@Test
	public void makePayment() throws Exception {
		PaymentsRequest map = PaymentsTestUtils.createPaymentRequest();
		when(
				webServiceDaoMock.postRequest(Mockito.anyString(),
						Mockito.anyString())).thenReturn(response);
		assertNotNull(service.makePayment(map, ATHID));
	}

}
