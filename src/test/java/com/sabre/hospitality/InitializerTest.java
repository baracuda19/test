package com.sabre.hospitality;

import static org.junit.Assert.assertEquals;

import javax.servlet.Filter;

import org.junit.Before;
import org.junit.Test;

import com.sabre.hospitality.Initializer;
import com.sabre.hospitality.JsonpCallbackFilter;
import com.sabre.hospitality.SimpleCORSFilter;
import com.sabre.saap.commons.filter.trimmer.TrimmingFilter;
import com.sabre.saap.commons.log.LoggingFilter;

/**
 * 
 * @author Juan Hall
 */
public class InitializerTest {

	private Initializer initializer;

	@Before
	public void setUp() {
		initializer = new Initializer();
	}

	@Test
	public void getServletFilters() {
		Filter[] filters = initializer.getServletFilters();

		assertEquals(4, filters.length);
		assertEquals(LoggingFilter.class, filters[0].getClass());
		assertEquals(TrimmingFilter.class, filters[1].getClass());
		assertEquals(JsonpCallbackFilter.class, filters[2].getClass());
		assertEquals(SimpleCORSFilter.class, filters[3].getClass());
	}
}
