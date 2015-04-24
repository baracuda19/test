/**
 * 
 */
package com.sabre.hospitality.utils;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

/**
 * @author Vishal Bhasin
 *
 */
public class CommonUtilsTest {
	
	private final String inputDate = "0120";
	private final String expectedDate = "012020";

	@Test
	public void covertDDYYtoDDYYY() {
		try {
			assertEquals(CommonUtils.covertDDYYtoDDYYY(inputDate), expectedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
