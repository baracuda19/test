package com.sabre.hospitality.service.v1.util;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sabre.hospitality.domain.payments.v300.PaymentRQ;
import com.sabre.hospitality.domain.payments.v300.PaymentRS;
import com.sabre.saap.commons.domain.soap.ebxml.Envelope;
import com.sabre.saap.commons.domain.soap.wsse.Security;

/**
 * 
 * @author Vishal Bhasin
 *
 */
public class TransformationUtils {
	
	private static final Logger log = LoggerFactory
			.getLogger(TransformationUtils.class);
	
	private static JAXBContext jaxbContext;
	static {
		try {
			jaxbContext = JAXBContext.newInstance(
					Envelope.class, PaymentRQ.class, PaymentRS.class, Security.class);
	
			log.debug("Using JAXBContext: {}", jaxbContext.toString());
	
		} catch (Exception ex) {
			throw new IllegalStateException(
					"Unable to initialize JAXBContext", ex);
		}
	}
	
	public static String convertPaymentRQToString(Object input) throws Exception {
		StringWriter writer = new StringWriter();
		jaxbContext.createMarshaller().marshal(input, writer);
		
		return writer.toString();
	}
	
	public static PaymentRS convertStringToPaymentRS(String response) throws JAXBException {
		Envelope env = (Envelope) jaxbContext.createUnmarshaller()
                .unmarshal(new StringReader(response));
		
		 return ((PaymentRS) env.getBody().getAny().get(0));
	}

}
