package com.example.groupdemo.service;

public class VehicleTypeFactor {

    public static double calculateVehicleTypeFactor(String vehicleType) {

        switch (vehicleType){
            case "Cabriolet":
                return 1.3;
            case "Coupe":
                return 1.4;
            case "Estate":
                return 1.5;
            case "Hatchback":
                return 1.6;
            case "Other":
                return 1.7;
            default:
                throw new IllegalArgumentException("Invalid vehicle type provided");
        }
    }
}