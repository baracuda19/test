package com.sabre.hospitality.service.v1.util;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.sabre.hospitality.service.v1.util.LinkUtils;

/**
 * 
 * @author Juan Hall
 */
public class LinkUtilsTest {
	
	@Test
	public void createUrl() throws Exception {
		Map<String, String> values = new HashMap<String, String>();
		values.put("code", "KRK");
		
		String url = LinkUtils.createUrl("http://host:80/cto-darwin-raf/v1/historical/flights/top/destinations", "http://{host}:{port}/cto-darwin-raf/v1/lists/supported/airports/{code}", values);
		assertEquals("http://host:80/cto-darwin-raf/v1/lists/supported/airports/KRK", url);
	}
}
