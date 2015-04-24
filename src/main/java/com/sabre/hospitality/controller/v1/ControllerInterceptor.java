package com.sabre.hospitality.controller.v1;

import static com.sabre.saap.commons.util.LogUtils.logException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @author Juan Hall
 */
@Component
public class ControllerInterceptor extends HandlerInterceptorAdapter {

	private static final Logger log = LoggerFactory
			.getLogger(ControllerInterceptor.class);

	private static final String TIMING_KEY = "START_TIME";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute(TIMING_KEY, System.currentTimeMillis());

		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		try {
			super.afterCompletion(request, response, handler, ex);
		} finally {
			if (response.getStatus() >= 400) {
				try {
					long startTime = (long) ObjectUtils.defaultIfNull(
							request.getAttribute(TIMING_KEY), 0);
					long elapsedTime = System.currentTimeMillis() - startTime;

					if (elapsedTime < errorDelayInMillis) {
						long delay = errorDelayInMillis - elapsedTime;

						if (log.isTraceEnabled()) {
							log.trace("Sleeping {}ms on {} error", delay,
									response.getStatus());
						}

						sleep(delay);
					}
				} catch (Throwable th) {
					logException(getClass().getSimpleName(),
							"Error calculating error delay", th);
				}
			}
		}
	}

	protected void sleep(long elapsedTime) throws InterruptedException {
		Thread.sleep(errorDelayInMillis - elapsedTime);
	}

	@Value("${error.delay.inmillis}")
	private long errorDelayInMillis = 0;

	public void setErrorDelayInMillis(long errorDelayInMillis) {
		this.errorDelayInMillis = errorDelayInMillis;
	}
}
