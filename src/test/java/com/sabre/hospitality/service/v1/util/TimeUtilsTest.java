package com.sabre.hospitality.service.v1.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sabre.hospitality.service.v1.util.TimeUtils;

public class TimeUtilsTest {

	@Test
	public void testGetHoursFromOffset() {
		assertEquals(0, TimeUtils.getHoursFromOffset(0.0));
		assertEquals(1, TimeUtils.getHoursFromOffset(1.5));
		assertEquals(-2, TimeUtils.getHoursFromOffset(-2.25));
	}
	
	@Test
	public void testGetMinutesFromOffset() {
		assertEquals(30, TimeUtils.getMinutesFromOffset(0.5));
		assertEquals(-15, TimeUtils.getMinutesFromOffset(-1.25));
		assertEquals(0, TimeUtils.getMinutesFromOffset(2.0));
	}

}
