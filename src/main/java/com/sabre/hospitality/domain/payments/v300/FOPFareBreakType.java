//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.20 at 12:59:01 PM CDT 
//


package com.sabre.hospitality.domain.payments.v300;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Farebreak at FOP level
 * 
 * <p>Java class for FOP_FareBreakType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FOP_FareBreakType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="FOP_Type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FOP_Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CardNbr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TokenizedCardNbr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ExpireDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ApprovalCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FOP_TotalAmt" use="required" type="{http://www.opentravel.org/OTA/2003/05/beta}Money" />
 *       &lt;attribute name="BaseFare" type="{http://www.opentravel.org/OTA/2003/05/beta}Money" />
 *       &lt;attribute name="Taxes" type="{http://www.opentravel.org/OTA/2003/05/beta}Money" />
 *       &lt;attribute name="Fees" type="{http://www.opentravel.org/OTA/2003/05/beta}Money" />
 *       &lt;attribute name="PaymentCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PaymentCurrencyAmt" type="{http://www.opentravel.org/OTA/2003/05/beta}Money" />
 *       &lt;attribute name="FOP_TotalPoints" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="BasePoints" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="TaxPoints" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="FeePoints" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FOP_FareBreakType")
public class FOPFareBreakType {

    @XmlAttribute(name = "FOP_Type", required = true)
    protected String fopType;
    @XmlAttribute(name = "FOP_Code")
    protected String fopCode;
    @XmlAttribute(name = "CardNbr")
    protected String cardNbr;
    @XmlAttribute(name = "TokenizedCardNbr")
    protected String tokenizedCardNbr;
    @XmlAttribute(name = "ExpireDate")
    protected String expireDate;
    @XmlAttribute(name = "ApprovalCode")
    protected String approvalCode;
    @XmlAttribute(name = "CurrencyCode")
    protected String currencyCode;
    @XmlAttribute(name = "FOP_TotalAmt", required = true)
    protected BigDecimal fopTotalAmt;
    @XmlAttribute(name = "BaseFare")
    protected BigDecimal baseFare;
    @XmlAttribute(name = "Taxes")
    protected BigDecimal taxes;
    @XmlAttribute(name = "Fees")
    protected BigDecimal fees;
    @XmlAttribute(name = "PaymentCurrencyCode")
    protected String paymentCurrencyCode;
    @XmlAttribute(name = "PaymentCurrencyAmt")
    protected BigDecimal paymentCurrencyAmt;
    @XmlAttribute(name = "FOP_TotalPoints")
    protected BigInteger fopTotalPoints;
    @XmlAttribute(name = "BasePoints")
    protected BigInteger basePoints;
    @XmlAttribute(name = "TaxPoints")
    protected BigInteger taxPoints;
    @XmlAttribute(name = "FeePoints")
    protected BigInteger feePoints;

    /**
     * Gets the value of the fopType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFOPType() {
        return fopType;
    }

    /**
     * Sets the value of the fopType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFOPType(String value) {
        this.fopType = value;
    }

    /**
     * Gets the value of the fopCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFOPCode() {
        return fopCode;
    }

    /**
     * Sets the value of the fopCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFOPCode(String value) {
        this.fopCode = value;
    }

    /**
     * Gets the value of the cardNbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNbr() {
        return cardNbr;
    }

    /**
     * Sets the value of the cardNbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNbr(String value) {
        this.cardNbr = value;
    }

    /**
     * Gets the value of the tokenizedCardNbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenizedCardNbr() {
        return tokenizedCardNbr;
    }

    /**
     * Sets the value of the tokenizedCardNbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenizedCardNbr(String value) {
        this.tokenizedCardNbr = value;
    }

    /**
     * Gets the value of the expireDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpireDate(String value) {
        this.expireDate = value;
    }

    /**
     * Gets the value of the approvalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovalCode() {
        return approvalCode;
    }

    /**
     * Sets the value of the approvalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovalCode(String value) {
        this.approvalCode = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the fopTotalAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFOPTotalAmt() {
        return fopTotalAmt;
    }

    /**
     * Sets the value of the fopTotalAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFOPTotalAmt(BigDecimal value) {
        this.fopTotalAmt = value;
    }

    /**
     * Gets the value of the baseFare property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBaseFare() {
        return baseFare;
    }

    /**
     * Sets the value of the baseFare property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBaseFare(BigDecimal value) {
        this.baseFare = value;
    }

    /**
     * Gets the value of the taxes property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxes() {
        return taxes;
    }

    /**
     * Sets the value of the taxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxes(BigDecimal value) {
        this.taxes = value;
    }

    /**
     * Gets the value of the fees property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFees() {
        return fees;
    }

    /**
     * Sets the value of the fees property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFees(BigDecimal value) {
        this.fees = value;
    }

    /**
     * Gets the value of the paymentCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentCurrencyCode() {
        return paymentCurrencyCode;
    }

    /**
     * Sets the value of the paymentCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentCurrencyCode(String value) {
        this.paymentCurrencyCode = value;
    }

    /**
     * Gets the value of the paymentCurrencyAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPaymentCurrencyAmt() {
        return paymentCurrencyAmt;
    }

    /**
     * Sets the value of the paymentCurrencyAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPaymentCurrencyAmt(BigDecimal value) {
        this.paymentCurrencyAmt = value;
    }

    /**
     * Gets the value of the fopTotalPoints property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFOPTotalPoints() {
        return fopTotalPoints;
    }

    /**
     * Sets the value of the fopTotalPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFOPTotalPoints(BigInteger value) {
        this.fopTotalPoints = value;
    }

    /**
     * Gets the value of the basePoints property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBasePoints() {
        return basePoints;
    }

    /**
     * Sets the value of the basePoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBasePoints(BigInteger value) {
        this.basePoints = value;
    }

    /**
     * Gets the value of the taxPoints property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTaxPoints() {
        return taxPoints;
    }

    /**
     * Sets the value of the taxPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTaxPoints(BigInteger value) {
        this.taxPoints = value;
    }

    /**
     * Gets the value of the feePoints property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFeePoints() {
        return feePoints;
    }

    /**
     * Sets the value of the feePoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFeePoints(BigInteger value) {
        this.feePoints = value;
    }

}
