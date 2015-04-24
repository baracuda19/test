/**
 * 
 */
package com.sabre.hospitality.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sabre.hospitality.CommonConstants;
import com.sabre.hospitality.service.v1.util.TransformationUtils;

/**
 * @author Vishal Bhasin
 *
 */
public class CommonUtils {
	
	private static final Logger log = LoggerFactory
			.getLogger(TransformationUtils.class);
	
	public static String getHostName() {
		String hostname = "Unknown";
		try
		{
		    InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    hostname = addr.getHostName();
		}
		catch (UnknownHostException ex)
		{
		    log.warn("Hostname can not be resolved");
		}
		return hostname;
	}
	
	public static String covertDDYYtoDDYYY(String ddyy) throws ParseException{
	        DateFormat formatter;
	        Date date;
	        formatter = new SimpleDateFormat(CommonConstants.DATE_FORMAT_DDYY);
	        date = (Date) formatter.parse(ddyy);
	        formatter = new SimpleDateFormat(CommonConstants.DATE_FORMAT_DDYYYY);
	        return formatter.format(date).toString();
	}

}
