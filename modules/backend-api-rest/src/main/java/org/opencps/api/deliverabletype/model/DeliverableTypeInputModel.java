//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.20 at 03:28:36 PM ICT 
//


package org.opencps.api.deliverabletype.model;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeliverableTypeInputModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliverableTypeInputModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deliverableType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deliverableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formScript" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formReport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codePattern" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="counter" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="mappingData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliverableTypeInputModel", propOrder = {
    "deliverableType",
    "deliverableName",
    "formScript",
    "formReport",
    "codePattern",
    "counter",
    "mappingData"
})
public class DeliverableTypeInputModel {

	@FormParam(value = "deliverableType")
    protected String deliverableType;
	@FormParam(value = "deliverableName")
    protected String deliverableName;
	@FormParam(value = "formScript")
    protected String formScript;
	@FormParam(value = "formReport")
    protected String formReport;
	@FormParam(value = "codePattern")
    protected String codePattern;
	@FormParam(value = "counter")
    protected Long counter;
	@FormParam(value = "mappingData")
    protected String mappingData;

    /**
     * Gets the value of the deliverableType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliverableType() {
        return deliverableType;
    }

    /**
     * Sets the value of the deliverableType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliverableType(String value) {
        this.deliverableType = value;
    }

    /**
     * Gets the value of the deliverableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliverableName() {
        return deliverableName;
    }

    /**
     * Sets the value of the deliverableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliverableName(String value) {
        this.deliverableName = value;
    }

    /**
     * Gets the value of the formScript property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormScript() {
        return formScript;
    }

    /**
     * Sets the value of the formScript property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormScript(String value) {
        this.formScript = value;
    }

    /**
     * Gets the value of the formReport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormReport() {
        return formReport;
    }

    /**
     * Sets the value of the formReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormReport(String value) {
        this.formReport = value;
    }

    /**
     * Gets the value of the codePattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePattern() {
        return codePattern;
    }

    /**
     * Sets the value of the codePattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePattern(String value) {
        this.codePattern = value;
    }

    /**
     * Gets the value of the counter property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCounter() {
        return counter;
    }

    /**
     * Sets the value of the counter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCounter(Long value) {
        this.counter = value;
    }

    /**
     * Gets the value of the mappingData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMappingData() {
        return mappingData;
    }

    /**
     * Sets the value of the mappingData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMappingData(String value) {
        this.mappingData = value;
    }

}
