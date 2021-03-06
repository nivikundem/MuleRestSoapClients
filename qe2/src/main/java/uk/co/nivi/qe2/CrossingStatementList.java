//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.11 at 09:10:38 AM BST 
//


package uk.co.nivi.qe2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateGenerated" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="TimeGenerated" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *         &lt;element name="CrossingStatement" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DateGenerated" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="TimeGenerated" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *                   &lt;element name="AccountEntry">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}time"/>
 *                             &lt;element name="VehicleNumber" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="AmountPayable">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                                       &lt;element name="VAT" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
@XmlType(name = "", propOrder = {
    "dateGenerated",
    "timeGenerated",
    "crossingStatement"
})
@XmlRootElement(name = "CrossingStatementList")
public class CrossingStatementList {

    @XmlElement(name = "DateGenerated", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateGenerated;
    @XmlElement(name = "TimeGenerated", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar timeGenerated;
    @XmlElement(name = "CrossingStatement")
    protected List<CrossingStatementList.CrossingStatement> crossingStatement;

    /**
     * Gets the value of the dateGenerated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateGenerated() {
        return dateGenerated;
    }

    /**
     * Sets the value of the dateGenerated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateGenerated(XMLGregorianCalendar value) {
        this.dateGenerated = value;
    }

    /**
     * Gets the value of the timeGenerated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeGenerated() {
        return timeGenerated;
    }

    /**
     * Sets the value of the timeGenerated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeGenerated(XMLGregorianCalendar value) {
        this.timeGenerated = value;
    }

    /**
     * Gets the value of the crossingStatement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the crossingStatement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrossingStatement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CrossingStatementList.CrossingStatement }
     * 
     * 
     */
    public List<CrossingStatementList.CrossingStatement> getCrossingStatement() {
        if (crossingStatement == null) {
            crossingStatement = new ArrayList<CrossingStatementList.CrossingStatement>();
        }
        return this.crossingStatement;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DateGenerated" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="TimeGenerated" type="{http://www.w3.org/2001/XMLSchema}time"/>
     *         &lt;element name="AccountEntry">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}time"/>
     *                   &lt;element name="VehicleNumber" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="AmountPayable">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                             &lt;element name="VAT" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
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
    @XmlType(name = "", propOrder = {
        "dateGenerated",
        "timeGenerated",
        "accountEntry"
    })
    public static class CrossingStatement {

        @XmlElement(name = "DateGenerated", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar dateGenerated;
        @XmlElement(name = "TimeGenerated", required = true)
        @XmlSchemaType(name = "time")
        protected XMLGregorianCalendar timeGenerated;
        @XmlElement(name = "AccountEntry", required = true)
        protected CrossingStatementList.CrossingStatement.AccountEntry accountEntry;

        /**
         * Gets the value of the dateGenerated property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateGenerated() {
            return dateGenerated;
        }

        /**
         * Sets the value of the dateGenerated property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateGenerated(XMLGregorianCalendar value) {
            this.dateGenerated = value;
        }

        /**
         * Gets the value of the timeGenerated property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getTimeGenerated() {
            return timeGenerated;
        }

        /**
         * Sets the value of the timeGenerated property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTimeGenerated(XMLGregorianCalendar value) {
            this.timeGenerated = value;
        }

        /**
         * Gets the value of the accountEntry property.
         * 
         * @return
         *     possible object is
         *     {@link CrossingStatementList.CrossingStatement.AccountEntry }
         *     
         */
        public CrossingStatementList.CrossingStatement.AccountEntry getAccountEntry() {
            return accountEntry;
        }

        /**
         * Sets the value of the accountEntry property.
         * 
         * @param value
         *     allowed object is
         *     {@link CrossingStatementList.CrossingStatement.AccountEntry }
         *     
         */
        public void setAccountEntry(CrossingStatementList.CrossingStatement.AccountEntry value) {
            this.accountEntry = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="ReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}time"/>
         *         &lt;element name="VehicleNumber" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="AmountPayable">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *                   &lt;element name="VAT" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
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
        @XmlType(name = "", propOrder = {
            "referenceNumber",
            "startDate",
            "startTime",
            "vehicleNumber",
            "amountPayable"
        })
        public static class AccountEntry {

            @XmlElement(name = "ReferenceNumber", required = true)
            protected String referenceNumber;
            @XmlElement(name = "StartDate", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar startDate;
            @XmlElement(name = "StartTime", required = true)
            @XmlSchemaType(name = "time")
            protected XMLGregorianCalendar startTime;
            @XmlElement(name = "VehicleNumber")
            protected String vehicleNumber;
            @XmlElement(name = "AmountPayable", required = true)
            protected CrossingStatementList.CrossingStatement.AccountEntry.AmountPayable amountPayable;

            /**
             * Gets the value of the referenceNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReferenceNumber() {
                return referenceNumber;
            }

            /**
             * Sets the value of the referenceNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReferenceNumber(String value) {
                this.referenceNumber = value;
            }

            /**
             * Gets the value of the startDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getStartDate() {
                return startDate;
            }

            /**
             * Sets the value of the startDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setStartDate(XMLGregorianCalendar value) {
                this.startDate = value;
            }

            /**
             * Gets the value of the startTime property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getStartTime() {
                return startTime;
            }

            /**
             * Sets the value of the startTime property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setStartTime(XMLGregorianCalendar value) {
                this.startTime = value;
            }

            /**
             * Gets the value of the vehicleNumber property.
             * 
             */
            public String getVehicleNumber() {
                return vehicleNumber;
            }

            /**
             * Sets the value of the vehicleNumber property.
             * 
             */
            public void setVehicleNumber(String value) {
                this.vehicleNumber = value;
            }

            /**
             * Gets the value of the amountPayable property.
             * 
             * @return
             *     possible object is
             *     {@link CrossingStatementList.CrossingStatement.AccountEntry.AmountPayable }
             *     
             */
            public CrossingStatementList.CrossingStatement.AccountEntry.AmountPayable getAmountPayable() {
                return amountPayable;
            }

            /**
             * Sets the value of the amountPayable property.
             * 
             * @param value
             *     allowed object is
             *     {@link CrossingStatementList.CrossingStatement.AccountEntry.AmountPayable }
             *     
             */
            public void setAmountPayable(CrossingStatementList.CrossingStatement.AccountEntry.AmountPayable value) {
                this.amountPayable = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *         &lt;element name="VAT" type="{http://www.w3.org/2001/XMLSchema}float"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "amount",
                "vat"
            })
            public static class AmountPayable {

                @XmlElement(name = "Amount")
                protected float amount;
                @XmlElement(name = "VAT")
                protected float vat;

                /**
                 * Gets the value of the amount property.
                 * 
                 */
                public float getAmount() {
                    return amount;
                }

                /**
                 * Sets the value of the amount property.
                 * 
                 */
                public void setAmount(float value) {
                    this.amount = value;
                }

                /**
                 * Gets the value of the vat property.
                 * 
                 */
                public float getVAT() {
                    return vat;
                }

                /**
                 * Sets the value of the vat property.
                 * 
                 */
                public void setVAT(float value) {
                    this.vat = value;
                }

            }

        }

    }

}
