package com.sabre.hospitality.controller.v1.example;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.sabre.hospitality.controller.v1.example.RadiusSessionPoolExampleController;
import com.sabre.radius.client.ice.IceSession;
import com.sabre.radius.client.ice.IceSessionPool;

/**
 * 
 * @author Vishal Bhasin
 */
public class RadiusSessionPoolExampleControllerTest {

	private RadiusSessionPoolExampleController controller;
	private ObjectMapper objectMapper;
	@Mock
	private IceSessionPool poolMock;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		objectMapper = new ObjectMapper();
		controller = new RadiusSessionPoolExampleController();
		controller.setObjectMapper(objectMapper);
		controller.setIceSessionPool(poolMock);
	}

	@Test
	public void getInput() {
		when(poolMock.borrowSession()).thenReturn(new IceSession());
		ResponseEntity<JsonNode> response = controller.getInput("1");

		assertNotNull(response);
	}
}
