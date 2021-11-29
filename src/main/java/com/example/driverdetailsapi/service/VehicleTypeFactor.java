package com.example.driverdetailsapi.service;

public class VehicleTypeFactor {

    public static double calculateVehicleTypeFactor(String vehicleType) {

        String vehicleTypeToUpperCase = vehicleType.toUpperCase();
        switch (vehicleTypeToUpperCase) {
            case "CABRIOLET":
                return 1.3;
            case "COUPE":
                return 1.4;
            case "ESTATE":
                return 1.5;
            case "HATCHBACK":
                return 1.6;
            case "OTHER":
                return 1.7;
            default:
                throw new IllegalArgumentException("Invalid vehicle type provided");
        }
    }
}