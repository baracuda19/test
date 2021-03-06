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
 * Passenger detail
 * 
 * <p>Java class for PassengerDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PassengerDetailType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Identifications" type="{http://www.opentravel.org/OTA/2003/05/beta}PersonID_Type" minOccurs="0"/>
 *         &lt;element name="Document" maxOccurs="99" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05/beta}DocumentType">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FlightDetail" type="{http://www.opentravel.org/OTA/2003/05/beta}FlightDetailType" maxOccurs="32" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05/beta}PersonNameGroup"/>
 *       &lt;attribute name="NameInPNR" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="NameNumberInPNR" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PsgrType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Gender" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BirthDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="FrequentFlyerID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FrequentFlyerStatus" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FrequentFlierID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FrequentFlierStatus" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PassengerDetailType", propOrder = {
    "identifications",
    "document",
    "flightDetail"
})
public class PassengerDetailType {

    @XmlElement(name = "Identifications")
    protected PersonIDType identifications;
    @XmlElement(name = "Document")
    protected List<PassengerDetailType.Document> document;
    @XmlElement(name = "FlightDetail")
    protected List<FlightDetailType> flightDetail;
    @XmlAttribute(name = "NameInPNR")
    protected String nameInPNR;
    @XmlAttribute(name = "NameNumberInPNR")
    protected String nameNumberInPNR;
    @XmlAttribute(name = "PsgrType")
    protected String psgrType;
    @XmlAttribute(name = "Gender")
    protected String gender;
    @XmlAttribute(name = "BirthDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDate;
    @XmlAttribute(name = "FrequentFlyerID")
    protected String frequentFlyerID;
    @XmlAttribute(name = "FrequentFlyerStatus")
    protected String frequentFlyerStatus;
    @XmlAttribute(name = "FrequentFlierID")
    protected String frequentFlierID;
    @XmlAttribute(name = "FrequentFlierStatus")
    protected String frequentFlierStatus;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "FirstName")
    protected String firstName;
    @XmlAttribute(name = "LastName")
    protected String lastName;

    /**
     * Gets the value of the identifications property.
     * 
     * @return
     *     possible object is
     *     {@link PersonIDType }
     *     
     */
    public PersonIDType getIdentifications() {
        return identifications;
    }

    /**
     * Sets the value of the identifications property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonIDType }
     *     
     */
    public void setIdentifications(PersonIDType value) {
        this.identifications = value;
    }

    /**
     * Gets the value of the document property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the document property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PassengerDetailType.Document }
     * 
     * 
     */
    public List<PassengerDetailType.Document> getDocument() {
        if (document == null) {
            document = new ArrayList<PassengerDetailType.Document>();
        }
        return this.document;
    }

    /**
     * Gets the value of the flightDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flightDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlightDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FlightDetailType }
     * 
     * 
     */
    public List<FlightDetailType> getFlightDetail() {
        if (flightDetail == null) {
            flightDetail = new ArrayList<FlightDetailType>();
        }
        return this.flightDetail;
    }

    /**
     * Gets the value of the nameInPNR property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameInPNR() {
        return nameInPNR;
    }

    /**
     * Sets the value of the nameInPNR property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameInPNR(String value) {
        this.nameInPNR = value;
    }

    /**
     * Gets the value of the nameNumberInPNR property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameNumberInPNR() {
        return nameNumberInPNR;
    }

    /**
     * Sets the value of the nameNumberInPNR property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameNumberInPNR(String value) {
        this.nameNumberInPNR = value;
    }

    /**
     * Gets the value of the psgrType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsgrType() {
        return psgrType;
    }

    /**
     * Sets the value of the psgrType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsgrType(String value) {
        this.psgrType = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the frequentFlyerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrequentFlyerID() {
        return frequentFlyerID;
    }

    /**
     * Sets the value of the frequentFlyerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrequentFlyerID(String value) {
        this.frequentFlyerID = value;
    }

    /**
     * Gets the value of the frequentFlyerStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrequentFlyerStatus() {
        return frequentFlyerStatus;
    }

    /**
     * Sets the value of the frequentFlyerStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrequentFlyerStatus(String value) {
        this.frequentFlyerStatus = value;
    }

    /**
     * Gets the value of the frequentFlierID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrequentFlierID() {
        return frequentFlierID;
    }

    /**
     * Sets the value of the frequentFlierID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrequentFlierID(String value) {
        this.frequentFlierID = value;
    }

    /**
     * Gets the value of the frequentFlierStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrequentFlierStatus() {
        return frequentFlierStatus;
    }

    /**
     * Sets the value of the frequentFlierStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrequentFlierStatus(String value) {
        this.frequentFlierStatus = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05/beta}DocumentType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Document
        extends DocumentType
    {


    }

}
