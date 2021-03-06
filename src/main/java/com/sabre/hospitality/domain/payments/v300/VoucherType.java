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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Sub-balance type and amount
 * 
 * <p>Java class for VoucherType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VoucherType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="VoucherNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ExpireDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="VoucherType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ResponseCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VoucherRemarks1" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="InternalAccountNbr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VoucherType", propOrder = {
    "value"
})
public class VoucherType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "VoucherNumber")
    protected String voucherNumber;
    @XmlAttribute(name = "ExpireDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar expireDate;
    @XmlAttribute(name = "VoucherType")
    protected String voucherType;
    @XmlAttribute(name = "ResponseCode")
    protected String responseCode;
    @XmlAttribute(name = "VoucherRemarks1")
    protected String voucherRemarks1;
    @XmlAttribute(name = "InternalAccountNbr")
    protected String internalAccountNbr;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the voucherNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherNumber() {
        return voucherNumber;
    }

    /**
     * Sets the value of the voucherNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherNumber(String value) {
        this.voucherNumber = value;
    }

    /**
     * Gets the value of the expireDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpireDate(XMLGregorianCalendar value) {
        this.expireDate = value;
    }

    /**
     * Gets the value of the voucherType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherType() {
        return voucherType;
    }

    /**
     * Sets the value of the voucherType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherType(String value) {
        this.voucherType = value;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCode(String value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the voucherRemarks1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherRemarks1() {
        return voucherRemarks1;
    }

    /**
     * Sets the value of the voucherRemarks1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherRemarks1(String value) {
        this.voucherRemarks1 = value;
    }

    /**
     * Gets the value of the internalAccountNbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalAccountNbr() {
        return internalAccountNbr;
    }

    /**
     * Sets the value of the internalAccountNbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalAccountNbr(String value) {
        this.internalAccountNbr = value;
    }

}
