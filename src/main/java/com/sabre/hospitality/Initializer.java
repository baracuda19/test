package com.sabre.hospitality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;

import com.sabre.saap.commons.AbstractInitializer;

/**
 * 
 * @author Juan Hall
 */
public class Initializer extends AbstractInitializer {

	public Initializer() {
		super(WebAppConfig.class);
	}

	@Override
	protected Filter[] getServletFilters() {
		List<Filter> filters = new ArrayList<>();
		filters.addAll(Arrays.asList(super.getServletFilters()));
		filters.add(new JsonpCallbackFilter());
		filters.add(new SimpleCORSFilter());
		return filters.toArray(new Filter[filters.size()]);
	}
}
