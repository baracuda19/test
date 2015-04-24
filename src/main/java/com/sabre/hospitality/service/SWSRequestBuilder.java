/**
 * 
 */
package com.sabre.hospitality.service;

import java.util.Map;

import com.sabre.hospitality.PaymentConstants;
import com.sabre.hospitality.utils.CommonUtils;
import com.sabre.saap.commons.domain.soap.ebxml.From;
import com.sabre.saap.commons.domain.soap.ebxml.Header;
import com.sabre.saap.commons.domain.soap.ebxml.MessageHeader;
import com.sabre.saap.commons.domain.soap.ebxml.PartyId;
import com.sabre.saap.commons.domain.soap.ebxml.Service;
import com.sabre.saap.commons.domain.soap.ebxml.To;
import com.sabre.saap.commons.domain.soap.wsse.Security;

/**
 * @author Vishal Bhasin
 *
 */
public abstract class SWSRequestBuilder {

	protected Header buildSOAPHeader(String cpaId, String athid, String refID){

		MessageHeader messageHeader = buildMessageHeader(cpaId, refID);

		Security security = new Security();
		security.setBinarySecurityToken(athid);

		Header header = new Header();
		header.getAny().add(messageHeader);
		header.getAny().add(security);
		
		return header;
	}
	
	protected MessageHeader buildMessageHeader(String cpaid, String refID) {
		String msgID = buildMsgID(refID);
		MessageHeader messageHeader = new MessageHeader();
		messageHeader.setAction(PaymentConstants.SWS_PAYMENTRQ_ACTION);
		messageHeader.setCPAId(cpaid);
		messageHeader.setConversationId(msgID);

		Service service = new Service();
		service.setValue(PaymentConstants.SWS_PAYMENTRQ_ACTION);
		messageHeader.setService(service);
		
		From from = new From();
		To to = new To();
		PartyId fromPartyid = new PartyId();
		fromPartyid.setValue(PaymentConstants.SHS);
		from.getPartyId().add(fromPartyid);
		PartyId toPartyid = new PartyId();
		toPartyid.setValue(PaymentConstants.SEPG);
		to.getPartyId().add(toPartyid);
		messageHeader.setFrom(from);
		messageHeader.setTo(to);
		
		return messageHeader;
	}
	
	private String buildMsgID(String refID) {
		StringBuilder sb = new StringBuilder();
		return (sb.append(PaymentConstants.SHS)
		.append(PaymentConstants.DOUBLE_COLON_SEPERATOR)
		//TODO - ok to add hostname?
		.append(CommonUtils.getHostName())
		.append(PaymentConstants.DOUBLE_COLON_SEPERATOR)
		.append(refID).toString());
	}

}
