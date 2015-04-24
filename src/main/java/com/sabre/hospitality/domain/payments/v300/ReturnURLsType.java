//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.20 at 12:59:01 PM CDT 
//


package com.sabre.hospitality.domain.payments.v300;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReturnURLsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReturnURLsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DefaultURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ApprovedURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeclinedURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PendingURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CancelURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnURLsType", propOrder = {
    "defaultURL",
    "approvedURL",
    "declinedURL",
    "pendingURL",
    "cancelURL",
    "errorURL"
})
public class ReturnURLsType {

    @XmlElement(name = "DefaultURL")
    protected String defaultURL;
    @XmlElement(name = "ApprovedURL")
    protected String approvedURL;
    @XmlElement(name = "DeclinedURL")
    protected String declinedURL;
    @XmlElement(name = "PendingURL")
    protected String pendingURL;
    @XmlElement(name = "CancelURL")
    protected String cancelURL;
    @XmlElement(name = "ErrorURL")
    protected String errorURL;

    /**
     * Gets the value of the defaultURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultURL() {
        return defaultURL;
    }

    /**
     * Sets the value of the defaultURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultURL(String value) {
        this.defaultURL = value;
    }

    /**
     * Gets the value of the approvedURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovedURL() {
        return approvedURL;
    }

    /**
     * Sets the value of the approvedURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovedURL(String value) {
        this.approvedURL = value;
    }

    /**
     * Gets the value of the declinedURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeclinedURL() {
        return declinedURL;
    }

    /**
     * Sets the value of the declinedURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeclinedURL(String value) {
        this.declinedURL = value;
    }

    /**
     * Gets the value of the pendingURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPendingURL() {
        return pendingURL;
    }

    /**
     * Sets the value of the pendingURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPendingURL(String value) {
        this.pendingURL = value;
    }

    /**
     * Gets the value of the cancelURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelURL() {
        return cancelURL;
    }

    /**
     * Sets the value of the cancelURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelURL(String value) {
        this.cancelURL = value;
    }

    /**
     * Gets the value of the errorURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorURL() {
        return errorURL;
    }

    /**
     * Sets the value of the errorURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorURL(String value) {
        this.errorURL = value;
    }

}