
package com.itf.vehicle.casefile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="VehicleExists" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="errorLookingVehicle" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "vehicleExists",
    "errorLookingVehicle"
})
@XmlRootElement(name = "VehicleExistsResponse")
public class VehicleExistsResponse {

    @XmlElement(name = "VehicleExists")
    protected boolean vehicleExists;
    protected boolean errorLookingVehicle;

    /**
     * Gets the value of the vehicleExists property.
     * 
     */
    public boolean isVehicleExists() {
        return vehicleExists;
    }

    /**
     * Sets the value of the vehicleExists property.
     * 
     */
    public void setVehicleExists(boolean value) {
        this.vehicleExists = value;
    }

    /**
     * Gets the value of the errorLookingVehicle property.
     * 
     */
    public boolean isErrorLookingVehicle() {
        return errorLookingVehicle;
    }

    /**
     * Sets the value of the errorLookingVehicle property.
     * 
     */
    public void setErrorLookingVehicle(boolean value) {
        this.errorLookingVehicle = value;
    }

}
