package com.sabre.hospitality;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;

import com.sabre.hospitality.ConfigurationChangeEventListener;
import com.sabre.saap.commons.ConfigurationChangeEvent;

/**
 * 
 * @author Juan Hall
 */
public class ConfigurationChangeEventListenerTest {

	private ConfigurationChangeEventListener listener;
	private ConfigurableApplicationContext configurableApplicationContextMock;

	@Before
	public void setUp() {
		configurableApplicationContextMock = mock(ConfigurableApplicationContext.class);

		listener = new ConfigurationChangeEventListener();
		listener.setConfigurableApplicationContext(configurableApplicationContextMock);
	}

	@Test
	public void onApplicationEvent() {
		Properties expectedProperties = new Properties();

		ConfigurationChangeEvent event = new ConfigurationChangeEvent(this,
				expectedProperties);

		listener.onApplicationEvent(event);

		verify(configurableApplicationContextMock).refresh();
	}
}
