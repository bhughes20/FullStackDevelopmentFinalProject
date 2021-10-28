package com.example.groupdemo.service;

public class AdditionalDriversFactor {

    public static double calculateAdditionalDriversFactor(int additionalDrivers) {

        if(additionalDrivers >= 0 && additionalDrivers < 2){
            return 1.1;
        } else if (additionalDrivers >= 2 && additionalDrivers <= 4) {
            return 1.2;
        } else {
            throw new IllegalArgumentException("Additional drivers must be between 0 and 4 (inclusive)");
        }
    }
}
