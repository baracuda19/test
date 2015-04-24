//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.20 at 12:59:01 PM CDT 
//


package com.sabre.hospitality.domain.payments.v300;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for HotelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HotelType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProviderInfo" type="{http://www.opentravel.org/OTA/2003/05/beta}ProviderInfoType"/>
 *         &lt;element name="Room" type="{http://www.opentravel.org/OTA/2003/05/beta}RoomStayType" maxOccurs="5" minOccurs="0"/>
 *         &lt;element name="Cost" type="{http://www.opentravel.org/OTA/2003/05/beta}CostType"/>
 *         &lt;element name="PaymentInfo" type="{http://www.opentravel.org/OTA/2003/05/beta}PaymentInfoType" minOccurs="0"/>
 *         &lt;element name="ServiceNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AgreementNbr" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LodgingType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CheckInCity" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CheckInDate" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="CheckOutDate" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="ReferenceNbr" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelType", propOrder = {
    "providerInfo",
    "room",
    "cost",
    "paymentInfo",
    "serviceNote"
})
public class HotelType {

    @XmlElement(name = "ProviderInfo", required = true)
    protected ProviderInfoType providerInfo;
    @XmlElement(name = "Room")
    protected List<RoomStayType> room;
    @XmlElement(name = "Cost", required = true)
    protected CostType cost;
    @XmlElement(name = "PaymentInfo")
    protected PaymentInfoType paymentInfo;
    @XmlElement(name = "ServiceNote")
    protected String serviceNote;
    @XmlAttribute(name = "AgreementNbr", required = true)
    protected String agreementNbr;
    @XmlAttribute(name = "LodgingType")
    protected String lodgingType;
    @XmlAttribute(name = "CheckInCity")
    protected String checkInCity;
    @XmlAttribute(name = "CheckInDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar checkInDate;
    @XmlAttribute(name = "CheckOutDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar checkOutDate;
    @XmlAttribute(name = "ReferenceNbr", required = true)
    protected String referenceNbr;

    /**
     * Gets the value of the providerInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ProviderInfoType }
     *     
     */
    public ProviderInfoType getProviderInfo() {
        return providerInfo;
    }

    /**
     * Sets the value of the providerInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProviderInfoType }
     *     
     */
    public void setProviderInfo(ProviderInfoType value) {
        this.providerInfo = value;
    }

    /**
     * Gets the value of the room property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the room property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomStayType }
     * 
     * 
     */
    public List<RoomStayType> getRoom() {
        if (room == null) {
            room = new ArrayList<RoomStayType>();
        }
        return this.room;
    }

    /**
     * Gets the value of the cost property.
     * 
     * @return
     *     possible object is
     *     {@link CostType }
     *     
     */
    public CostType getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link CostType }
     *     
     */
    public void setCost(CostType value) {
        this.cost = value;
    }

    /**
     * Gets the value of the paymentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentInfoType }
     *     
     */
    public PaymentInfoType getPaymentInfo() {
        return paymentInfo;
    }

    /**
     * Sets the value of the paymentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInfoType }
     *     
     */
    public void setPaymentInfo(PaymentInfoType value) {
        this.paymentInfo = value;
    }

    /**
     * Gets the value of the serviceNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceNote() {
        return serviceNote;
    }

    /**
     * Sets the value of the serviceNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceNote(String value) {
        this.serviceNote = value;
    }

    /**
     * Gets the value of the agreementNbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgreementNbr() {
        return agreementNbr;
    }

    /**
     * Sets the value of the agreementNbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgreementNbr(String value) {
        this.agreementNbr = value;
    }

    /**
     * Gets the value of the lodgingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLodgingType() {
        return lodgingType;
    }

    /**
     * Sets the value of the lodgingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLodgingType(String value) {
        this.lodgingType = value;
    }

    /**
     * Gets the value of the checkInCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckInCity() {
        return checkInCity;
    }

    /**
     * Sets the value of the checkInCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckInCity(String value) {
        this.checkInCity = value;
    }

    /**
     * Gets the value of the checkInDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckInDate() {
        return checkInDate;
    }

    /**
     * Sets the value of the checkInDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckInDate(XMLGregorianCalendar value) {
        this.checkInDate = value;
    }

    /**
     * Gets the value of the checkOutDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Sets the value of the checkOutDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckOutDate(XMLGregorianCalendar value) {
        this.checkOutDate = value;
    }

    /**
     * Gets the value of the referenceNbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceNbr() {
        return referenceNbr;
    }

    /**
     * Sets the value of the referenceNbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceNbr(String value) {
        this.referenceNbr = value;
    }

}