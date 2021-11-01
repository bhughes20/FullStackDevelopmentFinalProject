package com.example.driverdetailsapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "DRIVER_DETAILS")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prefix;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postcode;
    private String vehicleBodyType;
    private String engineSize;
    private int additionalDrivers;
    private String commercialUse;
    private String outsideStateUse;
    private double currentValue;
    private String dateRegistered;
    private double finalQuoteAmount;

    public Driver() {
    }

    public Driver(Long id, String prefix, String firstName, String lastName, String telephoneNumber, String addressLine1, String addressLine2, String city, String postcode, String vehicleBodyType, String engineSize, int additionalDrivers, String commercialUse, String outsideStateUse, double currentValue, String dateRegistered, double finalQuoteAmount) {
        this.id = id;
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postcode = postcode;
        this.vehicleBodyType = vehicleBodyType;
        this.engineSize = engineSize;
        this.additionalDrivers = additionalDrivers;
        this.commercialUse = commercialUse;
        this.outsideStateUse = outsideStateUse;
        this.currentValue = currentValue;
        this.dateRegistered = dateRegistered;
        this.finalQuoteAmount = finalQuoteAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcodeOrZip) {
        this.postcode = postcodeOrZip;
    }

    public String getVehicleBodyType() {
        return vehicleBodyType;
    }

    public void setVehicleBodyType(String vehicleType) {
        this.vehicleBodyType = vehicleType;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public int getAdditionalDrivers() {
        return additionalDrivers;
    }

    public void setAdditionalDrivers(int additionalDrivers) {
        this.additionalDrivers = additionalDrivers;
    }

    public String getCommercialUse() {
        return commercialUse;
    }

    public void setCommercialUse(String commercialPurposes) {
        this.commercialUse = commercialPurposes;
    }

    public String getOutsideStateUse() {
        return outsideStateUse;
    }

    public void setOutsideStateUse(String outOfRegisteredState) {
        this.outsideStateUse = outOfRegisteredState;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String registrationDate) {
        this.dateRegistered = registrationDate;
    }

    public double getFinalQuoteAmount() {
        return finalQuoteAmount;
    }

    public void setFinalQuoteAmount(double finalQuoteAmount) {
        this.finalQuoteAmount = finalQuoteAmount;
    }
}
