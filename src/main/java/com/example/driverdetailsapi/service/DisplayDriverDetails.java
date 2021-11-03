package com.example.driverdetailsapi.service;

import com.example.driverdetailsapi.model.Driver;

import java.text.ParseException;
import java.util.List;

public class DisplayDriverDetails {

    public void displayDriverDetails(List<Driver> driverList){

        System.out.printf("%-10s %10s %10s %15s %15s %15s %10s %10s %15s %15s %15s %15s %15s %10s %10s %10s %n",
                "Prefix", "First Name", "Last Name", "Telephone Number", "Address Line 1", "Address Line 2",
                "City", "Postcode", "Vehicle Type", "Engine Size", "Additional Drivers", "Commercial Use",
                "Outside of State Use", "Current Value", "Date Registered", "Final Quote Amount");


        for(Driver driver : driverList){
            System.out.printf("%-15s %5s %5s %5s %5s %5s %5s %5s %5s %15s %15d %15s %15s %15.2f %15s %15.2f %n",
                    driver.getPrefix(), driver.getFirstName(), driver.getLastName(), driver.getTelephoneNumber(),
                    driver.getAddressLine1(), driver.getAddressLine2(), driver.getCity(), driver.getPostcode(),
                    driver.getVehicleBodyType(), driver.getEngineSize(), driver.getAdditionalDrivers(),
                    driver.getCommercialUse(), driver.getOutsideStateUse(), driver.getCurrentValue(),
                    driver.formatDateRegistered(), driver.getFinalQuoteAmount());
        }
    }
}
