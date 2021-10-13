package com.example.groupdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
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
    private String postcodeOrZip;
    private String vehicleType;
    private String engineSize;
    private int additionalDrivers;
    private String commercialPurpose;
    private String outOfRegisteredState;
    private String currentValue;
    private Date registrationDate;

    public Driver() {
    }

    public Driver(Long id, String prefix, String firstName, String lastName, String telephoneNumber, String addressLine1, String addressLine2, String city, String postcodeOrZip, String vehicleType, String engineSize, int additionalDrivers, String commercialPurpose, String outOfRegisteredState, String currentValue, Date registrationDate) {
        this.id = id;
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postcodeOrZip = postcodeOrZip;
        this.vehicleType = vehicleType;
        this.engineSize = engineSize;
        this.additionalDrivers = additionalDrivers;
        this.commercialPurpose = commercialPurpose;
        this.outOfRegisteredState = outOfRegisteredState;
        this.currentValue = currentValue;
        this.registrationDate = registrationDate;
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

    public String getPostcodeOrZip() {
        return postcodeOrZip;
    }

    public void setPostcodeOrZip(String postcodeOrZip) {
        this.postcodeOrZip = postcodeOrZip;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
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

    public String getCommercialPurpose() {
        return commercialPurpose;
    }

    public void setCommercialPurpose(String commercialPurpose) {
        this.commercialPurpose = commercialPurpose;
    }

    public String getOutOfRegisteredState() {
        return outOfRegisteredState;
    }

    public void setOutOfRegisteredState(String outOfRegisteredState) {
        this.outOfRegisteredState = outOfRegisteredState;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
