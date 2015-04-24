package com.sabre.hospitality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.sabre.saap.commons.ConfigurationChangeEvent;

/**
 * 
 * @author Juan Hall
 */
@Component
public class ConfigurationChangeEventListener implements
		ApplicationListener<ConfigurationChangeEvent> {

	@Override
	public void onApplicationEvent(ConfigurationChangeEvent event) {
		configurableApplicationContext.refresh();
	}

	@Autowired
	private ConfigurableApplicationContext configurableApplicationContext;

	void setConfigurableApplicationContext(
			ConfigurableApplicationContext configurableApplicationContext) {
		this.configurableApplicationContext = configurableApplicationContext;
	}
}
