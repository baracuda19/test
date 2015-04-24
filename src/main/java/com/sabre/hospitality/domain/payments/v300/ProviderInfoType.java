//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.20 at 12:59:01 PM CDT 
//


package com.sabre.hospitality.domain.payments.v300;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProviderInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProviderInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProviderAddress" type="{http://www.opentravel.org/OTA/2003/05/beta}AddressType" minOccurs="0"/>
 *         &lt;element name="Contact" type="{http://www.opentravel.org/OTA/2003/05/beta}ContactInfoType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ProviderID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ProviderSiteID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ProviderSiteNote" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ProviderName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderInfoType", propOrder = {
    "providerAddress",
    "contact"
})
public class ProviderInfoType {

    @XmlElement(name = "ProviderAddress")
    protected AddressType providerAddress;
    @XmlElement(name = "Contact")
    protected ContactInfoType contact;
    @XmlAttribute(name = "ProviderID")
    protected String providerID;
    @XmlAttribute(name = "ProviderSiteID")
    protected String providerSiteID;
    @XmlAttribute(name = "ProviderSiteNote")
    protected String providerSiteNote;
    @XmlAttribute(name = "ProviderName", required = true)
    protected String providerName;

    /**
     * Gets the value of the providerAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getProviderAddress() {
        return providerAddress;
    }

    /**
     * Sets the value of the providerAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setProviderAddress(AddressType value) {
        this.providerAddress = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInfoType }
     *     
     */
    public ContactInfoType getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInfoType }
     *     
     */
    public void setContact(ContactInfoType value) {
        this.contact = value;
    }

    /**
     * Gets the value of the providerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderID() {
        return providerID;
    }

    /**
     * Sets the value of the providerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderID(String value) {
        this.providerID = value;
    }

    /**
     * Gets the value of the providerSiteID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderSiteID() {
        return providerSiteID;
    }

    /**
     * Sets the value of the providerSiteID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderSiteID(String value) {
        this.providerSiteID = value;
    }

    /**
     * Gets the value of the providerSiteNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderSiteNote() {
        return providerSiteNote;
    }

    /**
     * Sets the value of the providerSiteNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderSiteNote(String value) {
        this.providerSiteNote = value;
    }

    /**
     * Gets the value of the providerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the value of the providerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderName(String value) {
        this.providerName = value;
    }

}
