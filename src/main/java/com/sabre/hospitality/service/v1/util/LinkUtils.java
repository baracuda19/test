package com.sabre.hospitality.service.v1.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.sabre.saap.commons.util.RestUtils;

/**
 * 
 * @author Juan Hall
 */
public class LinkUtils {

	public static String createUrl(String requestUrl, String targetUrl,
			Map<String, String> additionalVariables)
			throws MalformedURLException {
		URL url = new URL(requestUrl);

		Map<String, String> values = new HashMap<>(
				RestUtils.parseQueryString(url.getQuery()));

		values.put("host", url.getHost());
		values.put("port", RestUtils.getPort(url));
		values.putAll(additionalVariables);

		return RestUtils.buildUrl(targetUrl, values);
	}
}
