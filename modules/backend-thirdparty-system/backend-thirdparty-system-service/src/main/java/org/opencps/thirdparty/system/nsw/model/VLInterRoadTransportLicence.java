//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.06 at 11:24:57 AM ICT 
//


package org.opencps.thirdparty.system.nsw.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VLInterRoadTransportLicence complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VLInterRoadTransportLicence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LicenceNo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FirstRegistrationDate">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[0-9]{4}-[01][0-9]-[0-3][0-9] [0-2][0-9]:[0-5][0-9]:[0-6][0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ValidUntil">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[0-9]{4}-[01][0-9]-[0-3][0-9] [0-2][0-9]:[0-5][0-9]:[0-6][0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TransportOperation">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="500"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{}Transporter" minOccurs="0"/>
 *         &lt;element ref="{}AttachedFile" maxOccurs="unbounded"/>
 *         &lt;element ref="{}IssuingAuthority"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VLInterRoadTransportLicence", propOrder = {
    "licenceNo",
    "firstRegistrationDate",
    "validUntil",
    "transportOperation",
    "transporter",
    "attachedFile",
    "issuingAuthority"
})
public class VLInterRoadTransportLicence {

    @XmlElement(name = "LicenceNo", required = true)
    protected String licenceNo;
    @XmlElement(name = "FirstRegistrationDate", required = true)
    protected String firstRegistrationDate;
    @XmlElement(name = "ValidUntil", required = true)
    protected String validUntil;
    @XmlElement(name = "TransportOperation", required = true)
    protected String transportOperation;
    @XmlElement(name = "Transporter")
    protected Transporter transporter;
    @XmlElement(name = "AttachedFile", required = true)
    protected List<AttachedFile> attachedFile;
    @XmlElement(name = "IssuingAuthority", required = true)
    protected IssuingAuthority issuingAuthority;

    /**
     * Gets the value of the licenceNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenceNo() {
        return licenceNo;
    }

    /**
     * Sets the value of the licenceNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenceNo(String value) {
        this.licenceNo = value;
    }

    /**
     * Gets the value of the firstRegistrationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    /**
     * Sets the value of the firstRegistrationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstRegistrationDate(String value) {
        this.firstRegistrationDate = value;
    }

    /**
     * Gets the value of the validUntil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidUntil() {
        return validUntil;
    }

    /**
     * Sets the value of the validUntil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidUntil(String value) {
        this.validUntil = value;
    }

    /**
     * Gets the value of the transportOperation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportOperation() {
        return transportOperation;
    }

    /**
     * Sets the value of the transportOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportOperation(String value) {
        this.transportOperation = value;
    }

    /**
     * Gets the value of the transporter property.
     * 
     * @return
     *     possible object is
     *     {@link Transporter }
     *     
     */
    public Transporter getTransporter() {
        return transporter;
    }

    /**
     * Sets the value of the transporter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Transporter }
     *     
     */
    public void setTransporter(Transporter value) {
        this.transporter = value;
    }

    /**
     * Gets the value of the attachedFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachedFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachedFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachedFile }
     * 
     * 
     */
    public List<AttachedFile> getAttachedFile() {
        if (attachedFile == null) {
            attachedFile = new ArrayList<AttachedFile>();
        }
        return this.attachedFile;
    }

    /**
     * Gets the value of the issuingAuthority property.
     * 
     * @return
     *     possible object is
     *     {@link IssuingAuthority }
     *     
     */
    public IssuingAuthority getIssuingAuthority() {
        return issuingAuthority;
    }

    /**
     * Sets the value of the issuingAuthority property.
     * 
     * @param value
     *     allowed object is
     *     {@link IssuingAuthority }
     *     
     */
    public void setIssuingAuthority(IssuingAuthority value) {
        this.issuingAuthority = value;
    }

}
