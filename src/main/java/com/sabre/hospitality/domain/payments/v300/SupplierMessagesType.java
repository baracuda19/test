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
 * <p>Java class for SupplierMessagesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SupplierMessagesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResponseMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplierMessagesType", propOrder = {
    "requestMsg",
    "responseMsg"
})
public class SupplierMessagesType {

    @XmlElement(name = "RequestMsg")
    protected String requestMsg;
    @XmlElement(name = "ResponseMsg")
    protected String responseMsg;

    /**
     * Gets the value of the requestMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestMsg() {
        return requestMsg;
    }

    /**
     * Sets the value of the requestMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestMsg(String value) {
        this.requestMsg = value;
    }

    /**
     * Gets the value of the responseMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseMsg() {
        return responseMsg;
    }

    /**
     * Sets the value of the responseMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseMsg(String value) {
        this.responseMsg = value;
    }

}
