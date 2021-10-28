package com.example.groupdemo.service;

public class EngineSizeFactor {

    public static double calculateEngineSizeFactor(String engineSize) {

        switch(engineSize){
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
            case "Other":
                return 3.5;
            default:
                throw new IllegalArgumentException("Invalid engine size provided");
        }

    }
}
