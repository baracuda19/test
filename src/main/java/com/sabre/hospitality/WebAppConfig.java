package com.sabre.hospitality;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.sabre.hospitality.controller.v1.ControllerInterceptor;
import com.sabre.radius.client.ice.IceSessionPool;
import com.sabre.radius.client.ice.IceSessionPoolImpl;
import com.sabre.saap.commons.AbstractWebAppConfig;
import com.sabre.saap.commons.HealthCheck;
import com.sabre.saap.commons.util.HealthCheckUtils;
import com.sabre.saap.commons.util.LogUtils;

/**
 * 
 * @author Juan Hall, Vishal Bhasin
 */
@Configuration
@ComponentScan("com.sabre")
@PropertySource("classpath:/${environment}/application.properties")
@EnableWebMvc
@EnableScheduling
public class WebAppConfig extends AbstractWebAppConfig {
	private static final String CLASS_NAME = WebAppConfig.class.getSimpleName();

	@SuppressWarnings("deprecation")
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		new RequestMappingHandlerAdapter()
				.getMessageConverters()
				.stream()
				.filter(m -> !(m instanceof MappingJackson2HttpMessageConverter))
				.forEach(m -> converters.add(m));

		converters
				.add(new org.springframework.http.converter.json.MappingJacksonHttpMessageConverter());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);

		registry.addInterceptor(controllerInterceptor);
	}

	@Override
	public List<HealthCheck> performChecks(HttpServletRequest request) {
		List<HealthCheck> checks = super.performChecks(request);

		if ("true".equalsIgnoreCase(momEnabled)) {
			try {
				checks.add(HealthCheckUtils.performMomHealthCheck(
						loggingAdvice(), "MOM-2SG", runtimeEnvironment
								+ "-SHSService"));
			} catch (Exception ex) {
				checks.add(new HealthCheck("MOM-2SG", false, ex.getMessage()));
				LogUtils.logException(CLASS_NAME, "performChecks",
						"Unable to perform MOM 2SG health check", ex);
			}
		}

		return checks;
	}

	@Value("${environment}")
	private String runtimeEnvironment = "local";

	void setRuntimeEnvironment(String runtimeEnvironment) {
		this.runtimeEnvironment = runtimeEnvironment;
	}

	@Value("${mom.service.provider.enabled}")
	private String momEnabled;

	void setMomEnabled(String momEnabled) {
		this.momEnabled = momEnabled;
	}

	@Autowired
	private ControllerInterceptor controllerInterceptor;

	void setControllerInterceptor(ControllerInterceptor controllerInterceptor) {
		this.controllerInterceptor = controllerInterceptor;
	}
	
	@Value("${sws.url}")
	private String url;
	@Value("${sws.cpaId}")
	private String cpaId;
	@Value("${sws.userName}")
	private String userName;
	@Value("${sws.password}")
	private String password;
	@Value("${sws.domain}")
	private String domain;
	@Value("${sws.maxPoolSize}")
	private int maxPoolSize;
	@Value("${sws.maxBorrowWait}")
	private int maxBorrowWait;
	@Value("${sws.usePing}")
	private boolean usePing;
	@Value("${sws.minEvictableIdleTimeMillis}")
	private long minEvictableIdleTimeMillis;
	@Value("${sws.timeBetweenEvictionRunsMillis}")
	private long timeBetweenEvictionRunsMillis;
	
	@Bean(destroyMethod = "destroy")
	public IceSessionPool iceSessionPool() throws Exception {
		IceSessionPool pool = new IceSessionPoolImpl();
		((IceSessionPoolImpl) pool).setUrl(url);
		((IceSessionPoolImpl) pool).setCpaId(cpaId);
		((IceSessionPoolImpl) pool).setUserName(userName);
		((IceSessionPoolImpl) pool).setPassword(IceSessionPoolImpl.encrypt(password));
		((IceSessionPoolImpl) pool).setDomain(domain);
		((IceSessionPoolImpl) pool).setMaxPoolSize(maxPoolSize);
		((IceSessionPoolImpl) pool).setMaxBorrowWait(maxBorrowWait);
		((IceSessionPoolImpl) pool).setUsePing(usePing);
		((IceSessionPoolImpl) pool).setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		((IceSessionPoolImpl) pool).setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		((IceSessionPoolImpl) pool).afterPropertiesSet();
		
		return proxy(IceSessionPool.class, pool);
	}
}
