package com.example.driverdetailsapi.service;

public class OutsideStateUseFactor {

    public static double calculateOutsideStateUseFactor(String outsideStateUse) {

        if(outsideStateUse.equalsIgnoreCase("yes")){
            return 1.1;
        } else if (outsideStateUse.equalsIgnoreCase("no")){
            return 1.0;
        } else {
            throw new IllegalArgumentException("Outside state use must be \"yes\" or \"no\"");
        }
    }
}
