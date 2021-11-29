package com.example.driverdetailsapi.service;

public class EngineSizeFactor {

    public static double calculateEngineSizeFactor(String engineSize) {

        String engineSizeToUpperCase = engineSize.toUpperCase();

        switch (engineSizeToUpperCase) {
            case "1000":
                return 1.0;
            case "1600":
                return 1.6;
            case "2000":
                return 2.0;
            case "2500":
                return 2.5;
            case "3000":
                return 3.0;
            case "OTHER":
                return 3.5;
            default:
                throw new IllegalArgumentException("Invalid engine size provided");
        }

    }
}
