package com.sabre.hospitality.service.v1.payments;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sabre.hospitality.PaymentConstants;
import com.sabre.hospitality.service.SWSRequestBuilder;
import com.sabre.hospitality.utils.CommonUtils;
import com.sabre.hospitality.domain.payments.v300.AddressType;
import com.sabre.hospitality.domain.payments.v300.CountryNameType;
import com.sabre.hospitality.domain.payments.v300.FOPType;
import com.sabre.hospitality.domain.payments.v300.HotelType;
import com.sabre.hospitality.domain.payments.v300.MerchantDetailType;
import com.sabre.hospitality.domain.payments.v300.POSType;
import com.sabre.hospitality.domain.payments.v300.POSType.BrowserDetail;
import com.sabre.hospitality.domain.payments.v300.POSType.BrowserDetail.HttpHeaders;
import com.sabre.hospitality.domain.payments.v300.POSType.BrowserDetail.HttpHeaders.HttpHeader;
import com.sabre.hospitality.domain.payments.v300.PaymentCardType;
import com.sabre.hospitality.domain.payments.v300.PaymentDetailType;
import com.sabre.hospitality.domain.payments.v300.PaymentDetailType.AmountDetail;
import com.sabre.hospitality.domain.payments.v300.PaymentDetailType.RoutingDetail;
import com.sabre.hospitality.domain.payments.v300.PaymentRQ;
import com.sabre.hospitality.domain.payments.v300.PaymentRQ.Action;
import com.sabre.hospitality.domain.payments.v300.PaymentRQ.CustomerDetail;
import com.sabre.hospitality.domain.payments.v300.PaymentRQ.OrderDetail;
import com.sabre.hospitality.domain.payments.v300.PhoneType;
import com.sabre.saap.commons.domain.soap.ebxml.Body;
import com.sabre.saap.commons.domain.soap.ebxml.Envelope;
import com.sabre.saap.commons.domain.soap.ebxml.Header;

/**
 * 
 * @author Vishal Bhasin
 *
 */
public class PaymentsRequestBuilder extends SWSRequestBuilder {

	private static final String PaymentRQ_Version = "3.0.0";
	private static final String PaymentRQ_SourceID = "Synxis";
	private static final String PaymentRQ_MerchantCategoryCode = "002";
	
	protected Logger log = LoggerFactory.getLogger(getClass());

	public Envelope build(PaymentsRequest paymentRequest, String athid,
			String cpaId) throws Exception {
		PaymentRQ paymentRQ = createPaymentRequest(paymentRequest, cpaId);
		String refID = paymentRequest.getReference()
				+ PaymentConstants.DOUBLE_COLON_SEPERATOR
				+ paymentRequest.getTransaction();
		Header header = buildSOAPHeader(cpaId, athid, refID);

		Body body = new Body();
		body.getAny().add(paymentRQ);
		Envelope envelope = new Envelope();
		envelope.getHeader().add(header);
		envelope.setBody(body);

		return envelope;
	}

	PaymentRQ createPaymentRequest(PaymentsRequest paymentRequest, String cpaId)
			throws Exception {
		PaymentRQ paymentRQ = new PaymentRQ();
		paymentRQ.setVersion(PaymentRQ_Version);

		Action action = new Action();
		action.setValue(paymentRequest.getAction());
		paymentRQ.setAction(action);

		paymentRQ.setPOS(getPOSType(paymentRequest, cpaId));

		Map<String, Object> merchantMap = (Map<String, Object>) paymentRequest
				.getMerchant();
		paymentRQ.setMerchantDetail(getMerchantDetail(merchantMap));

		List<PaymentDetailType> paymentDetailList = paymentRQ
				.getPaymentDetail();
		paymentDetailList.add(getPaymentDetailType(paymentRequest));
		
		paymentRQ.setOrderDetail(getOrderDetail(paymentRequest));
		
		paymentRQ.setCustomerDetail(getCustomerDetail(paymentRequest));

		return paymentRQ;
	}

	/**
	 * @param paymentRequest
	 * @return
	 */
	private CustomerDetail getCustomerDetail(PaymentsRequest paymentRequest) {
		CustomerDetail customerDetail = new CustomerDetail();
		Map<String, Object> guestInfo = (Map<String, Object>) paymentRequest
				.getGuest();
		AddressType address = new AddressType();
		address.setAddressLine1(guestInfo.get(PaymentConstants.ADDRESS)
				.toString());
		address.setCityName(guestInfo.get(PaymentConstants.CITY_NAME).toString());
		CountryNameType countryNameObj = new CountryNameType();
		countryNameObj.setCode(guestInfo.get(PaymentConstants.COUNTRY_CODE).toString());
		address.setCountry(countryNameObj);
		address.setPostalCode(guestInfo.get(PaymentConstants.ZIP_CODE)
				.toString());
		AddressType.StateProv stateProv = new AddressType.StateProv();
		stateProv
				.setStateCode(guestInfo.get(PaymentConstants.STATE_CODE).toString());
		address.setStateProv(stateProv);
		customerDetail.setAddress(address);
		customerDetail.setFirstName(guestInfo.get(PaymentConstants.FIRSTNAME).toString());
		customerDetail.setLastName(guestInfo.get(PaymentConstants.LASTNAME).toString());
		customerDetail.setEmailAddress(guestInfo.get(PaymentConstants.EMAIL_ADDRESS).toString());
		List<PhoneType> phonetypes = customerDetail.getPhoneNumber();
		PhoneType phoneType = new PhoneType();
		phoneType.setNumber(guestInfo.get(PaymentConstants.PHONE_NUMBER)
				.toString());
		phonetypes.add(phoneType);

		return customerDetail;
	}

	/**
	 * @param paymentRequest
	 * @return
	 * @throws DatatypeConfigurationException 
	 */
	private OrderDetail getOrderDetail(PaymentsRequest paymentRequest) throws DatatypeConfigurationException {
		OrderDetail orderDetail = new OrderDetail();
		Map<String, Object> orderMap = (Map<String, Object>) paymentRequest.getOrder();
		orderDetail.setRecordLocator(orderMap.get(PaymentConstants.RECORD_LOCATOR).toString());
		
		HotelType hotel = new HotelType();
		hotel.setCheckInDate(DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(orderMap.get(PaymentConstants.ARRIVAL).toString()));
		hotel.setCheckOutDate(DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(orderMap.get(PaymentConstants.DEPARTURE).toString()));
		List<HotelType> hotels = orderDetail.getHotel();
		hotels.add(hotel);
		
		return orderDetail;
	}

	private POSType getPOSType(PaymentsRequest paymentRequest, String cpaId)
			throws DatatypeConfigurationException {
		POSType pos = new POSType();
		pos.setPseudoCityCode(cpaId);
		pos.setStationNumber(cpaId);
		pos.setLocalDateTime(DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(LocalDateTime.now().toString()));
		pos.setSourceID(PaymentRQ_SourceID);

		Map<String, Object> contextMap = (Map<String, Object>) paymentRequest
				.getContext();
		BrowserDetail browserDetails = getBrowserDetails(contextMap);
		pos.setBrowserDetail(browserDetails);
		pos.setChannelID(contextMap.get(PaymentConstants.CHANNEL).toString());

		return pos;
	}

	private PaymentDetailType getPaymentDetailType(
			PaymentsRequest paymentRequest) throws ParseException {
		Map<String, Object> paymentInfo = (Map<String, Object>) paymentRequest
				.getPayment();
		PaymentDetailType paymentDetailType = new PaymentDetailType();
		FOPType foptype = new FOPType();
		foptype.setType(paymentInfo.get(PaymentConstants.FOP).toString());
		paymentDetailType.setFOP(foptype);

		PaymentDetailType.PaymentCard paymentCard = new PaymentDetailType.PaymentCard();
		paymentCard.setCardCode(paymentInfo.get(PaymentConstants.PAYMENT_CODE)
				.toString());
		paymentCard.setCardNumber(paymentInfo.get(
				PaymentConstants.CREDIT_CARD_NUMBER).toString());
		paymentCard.setCardSecurityCode(paymentInfo.get(
				PaymentConstants.CREDIT_CARD_CCV).toString());
		paymentCard.setExpireDate(CommonUtils.covertDDYYtoDDYYY(paymentInfo.get(
				PaymentConstants.CREDIT_CARD_EXP_DATE).toString()));

		PaymentCardType.CardHolderName cardHolderName = new PaymentCardType.CardHolderName();
		cardHolderName.setName(paymentInfo.get(PaymentConstants.CARD_HOLDER_NAME)
				.toString());
		paymentCard.setCardHolderName(cardHolderName);
		paymentDetailType.setPaymentCard(paymentCard);
		
		Map<String, Object> merchantInfo = (Map<String, Object>) paymentRequest.getMerchant();
		RoutingDetail routingDetail = new RoutingDetail();
		routingDetail.setSupplierID(merchantInfo.get(PaymentConstants.SUPPLIER).toString());
		routingDetail.setMerchantAccountNumber(merchantInfo.get(PaymentConstants.ACCOUNT_NUMBER).toString());
		routingDetail.setUserName(merchantInfo.get(PaymentConstants.USERNAME).toString());
		routingDetail.setPassword(merchantInfo.get(PaymentConstants.PASSWORD).toString());
		paymentDetailType.setRoutingDetail(routingDetail);

		AmountDetail amountDetail = new AmountDetail();
		amountDetail.setAmount(new BigDecimal(paymentInfo.get(
				PaymentConstants.AMOUNT).toString()));
		amountDetail.setCurrencyCode(paymentInfo.get(PaymentConstants.CURRENCY)
				.toString());
		paymentDetailType.setAmountDetail(amountDetail);

		return paymentDetailType;
	}

	private MerchantDetailType getMerchantDetail(Map<String, Object> merchantMap) {
		MerchantDetailType merchantDetail = new MerchantDetailType();
		merchantDetail.setMerchantID(merchantMap.get(PaymentConstants.HOTELID)
				.toString());
		merchantDetail.setMerchantName(merchantMap.get(
				PaymentConstants.HOTEL_NAME).toString());
		merchantDetail.setMerchantCategoryCode(PaymentRQ_MerchantCategoryCode);

		return merchantDetail;
	}

	@SuppressWarnings("rawtypes")
	private BrowserDetail getBrowserDetails(Map<String, Object> contextMap) {
		BrowserDetail browserDetails = new BrowserDetail();
		HttpHeaders httpHeaders = new HttpHeaders();
		@SuppressWarnings("unchecked")
		ArrayList<String> list = (ArrayList<String>) contextMap
				.get(PaymentConstants.HTTP_HEADERS);
		List<HttpHeader> httpHeaderList = httpHeaders.getHttpHeader();
		for (Object item : list) {
			HttpHeader httpHeader = new HttpHeader();
			httpHeader.setName(((Map) item).get(PaymentConstants.NAME)
					.toString());
			httpHeader.setValue(((Map) item).get(PaymentConstants.VALUE)
					.toString());
			httpHeaderList.add(httpHeader);
		}
		browserDetails.setHttpHeaders(httpHeaders);
		return browserDetails;
	}

}
