package com.sabre.hospitality.service.v1.payments;

import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonProperty;
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;


import com.sabre.hospitality.PaymentConstants;

/**
 * 
 * @author Vishal Bhasin
 *
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentsRequest {
	
	@NotNull
	@Min(1)
	@JsonProperty(PaymentConstants.REFERENCE)
	private String reference;
	
	@NotNull
	@Min(1)
	@JsonProperty(PaymentConstants.TRANSACTION)
	private String transaction;
	
	@NotNull
	@Min(1)
	@JsonProperty(PaymentConstants.CONTEXT)
	private Map<String, Object> context;
	
	@NotNull
	@Min(1)
	@JsonProperty(PaymentConstants.MERCHANT)
	private Map<String, Object> merchant;
	
	@NotNull
	@Min(1)
	@JsonProperty(PaymentConstants.GUEST)
	private Map<String, Object> guest;
	
	@NotNull
	@Min(1)
	@JsonProperty(PaymentConstants.PAYMENT)
	private Map<String, Object> payment;
	
	@NotNull
	@Min(1)
	@JsonProperty(PaymentConstants.ORDER)
	private Map<String, Object> order;
	
	@NotNull
	@Min(1)
	@JsonProperty(PaymentConstants.ACTION)
	private String action;
	
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the order
	 */
	public Map<String, Object> getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Map<String, Object> order) {
		this.order = order;
	}

	/**
	 * @return the context
	 */
	public Map<String, Object> getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(Map<String, Object> context) {
		this.context = context;
	}

	/**
	 * @return the merchant
	 */
	public Map<String, Object> getMerchant() {
		return merchant;
	}

	/**
	 * @param merchant the merchant to set
	 */
	public void setMerchant(Map<String, Object> merchant) {
		this.merchant = merchant;
	}

	/**
	 * @return the guest
	 */
	public Map<String, Object> getGuest() {
		return guest;
	}

	/**
	 * @param guest the guest to set
	 */
	public void setGuest(Map<String, Object> guest) {
		this.guest = guest;
	}

	/**
	 * @return the payment
	 */
	public Map<String, Object> getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Map<String, Object> payment) {
		this.payment = payment;
	}

	/**
	 * @return the transaction
	 */
	public String getTransaction() {
		return transaction;
	}

	/**
	 * @param transaction the transaction to set
	 */
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

}
