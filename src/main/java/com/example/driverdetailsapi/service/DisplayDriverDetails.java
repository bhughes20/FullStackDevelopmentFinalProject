package com.example.driverdetailsapi.service;

import com.example.driverdetailsapi.model.Driver;

import java.util.List;

public class DisplayDriverDetails {

    public void displayDriverDetails(List<Driver> driverDetails){

        System.out.printf("%-8s %8s %8s %15s %15s %15s %8s %15s %8s %8s",
                "Prefix", "First Name", "Last Name", "Telephone Number", "Address Line 1", "Address Line 2",
                "City", "Postcode", "Vehicle Type", "Engine Size", "Additional Drivers");
    }
}
