package com.sabre.hospitality;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.sabre.hospitality.WebAppConfig;
import com.sabre.hospitality.controller.v1.ControllerInterceptor;
import com.sabre.saap.commons.dao.MultiBucketKeyValueDao;
import com.sabre.saap.commons.log.LoggingAdvice;

/**
 * 
 * @author Juan Hall
 */
public class WebAppConfigTest {

	private WebAppConfig config;
	@Mock
	private MultiBucketKeyValueDao multiBucketKeyValueDaoMock;
	@Mock
	private ControllerInterceptor controllerInterceptorMock;
	@Mock
	private InterceptorRegistry interceptorRegistryMock;

	@Before
	public void setUp() {
		System.setProperty("unit.test", "true");

		MockitoAnnotations.initMocks(this);

		config = new WebAppConfig() {
			@Override
			@Bean
			public LoggingAdvice loggingAdvice() throws Exception {
				return new LoggingAdvice(null);
			}
		};
		config.setRuntimeEnvironment("development");
		config.setMomEnabled("false");
		config.setControllerInterceptor(controllerInterceptorMock);
	}

	@Test
	public void addInterceptors() {
		config.addInterceptors(interceptorRegistryMock);

		verify(interceptorRegistryMock).addInterceptor(
				controllerInterceptorMock);
	}

}
