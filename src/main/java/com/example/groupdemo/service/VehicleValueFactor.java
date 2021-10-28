package com.example.groupdemo.service;

public class VehicleValueFactor {

    public static double calculateVehicleValueFactor(double currentValue) {

        if (currentValue >= 0 && currentValue <= 5000){
            return 1.0;
        } else if (currentValue > 5000 && currentValue <= 50000){
            return 1.2;
        } else {
            throw new IllegalArgumentException("Vehicle value must be between $0 and $50,000 (inclusive)");
        }

    }
}
