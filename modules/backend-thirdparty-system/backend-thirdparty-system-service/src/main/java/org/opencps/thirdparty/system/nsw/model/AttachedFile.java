//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.06 at 11:24:57 AM ICT 
//


package org.opencps.thirdparty.system.nsw.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AttachedFile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttachedFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AttachedTypeCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AttachedTypeName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AttachedNote">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FullFileName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FileURL">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachedFile", propOrder = {
    "attachedTypeCode",
    "attachedTypeName",
    "attachedNote",
    "fullFileName",
    "fileURL"
})
public class AttachedFile {

    @XmlElement(name = "AttachedTypeCode", required = true)
    protected String attachedTypeCode;
    @XmlElement(name = "AttachedTypeName", required = true)
    protected String attachedTypeName;
    @XmlElement(name = "AttachedNote", required = true)
    protected String attachedNote;
    @XmlElement(name = "FullFileName", required = true)
    protected String fullFileName;
    @XmlElement(name = "FileURL", required = true)
    protected String fileURL;

    /**
     * Gets the value of the attachedTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachedTypeCode() {
        return attachedTypeCode;
    }

    /**
     * Sets the value of the attachedTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachedTypeCode(String value) {
        this.attachedTypeCode = value;
    }

    /**
     * Gets the value of the attachedTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachedTypeName() {
        return attachedTypeName;
    }

    /**
     * Sets the value of the attachedTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachedTypeName(String value) {
        this.attachedTypeName = value;
    }

    /**
     * Gets the value of the attachedNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachedNote() {
        return attachedNote;
    }

    /**
     * Sets the value of the attachedNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachedNote(String value) {
        this.attachedNote = value;
    }

    /**
     * Gets the value of the fullFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullFileName() {
        return fullFileName;
    }

    /**
     * Sets the value of the fullFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullFileName(String value) {
        this.fullFileName = value;
    }

    /**
     * Gets the value of the fileURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileURL() {
        return fileURL;
    }

    /**
     * Sets the value of the fileURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileURL(String value) {
        this.fileURL = value;
    }

}
