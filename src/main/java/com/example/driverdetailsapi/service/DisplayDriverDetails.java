package com.example.driverdetailsapi.service;

import com.example.driverdetailsapi.model.Driver;

import java.util.List;

public class DisplayDriverDetails {

    public static void displayDriverDetails(List<Driver> driverList) {

        System.out.printf("%-10.10s %-15.15s %-15.15s %-20.20s %-25.25s %-25.25s %-20.20s %-15.15s %-15.15s %-15.15s %-20.20s %-15.15s %-25.25s %-15.15s %-20.20s %-20.20s %n",
                "Prefix", "First Name", "Last Name", "Telephone Number", "Address Line 1", "Address Line 2",
                "City", "Postcode", "Vehicle Type", "Engine Size", "Additional Drivers", "Commercial Use",
                "Outside of State Use", "Current Value", "Date Registered", "Final Quote Amount");

        for (Driver driver : driverList) {
            String currentValueFormatted = driver.formatCurrency(driver.getCurrentValue());
            String finalQuoteAmountFormatted = driver.formatCurrency(driver.getFinalQuoteAmount());

            System.out.printf("%-10.10s %-15.15s %-15.15s %-20.20s %-25.25s %-25.25s %-20.20s %-15.15s %-15.15s %-15.15s %-20d %-15.15s %-25.25s %-15.15s %-20.20s %-20.20s %n",
                    driver.getPrefix(), driver.getFirstName(), driver.getLastName(), driver.getTelephoneNumber(),
                    driver.getAddressLine1(), driver.getAddressLine2(), driver.getCity(), driver.getPostcode(),
                    driver.getVehicleBodyType(), driver.getEngineSize(), driver.getAdditionalDrivers(),
                    driver.getCommercialUse(), driver.getOutsideStateUse(), currentValueFormatted,
                    driver.formatDateRegistered(), finalQuoteAmountFormatted);
        }
    }
}
