package com.example.driverdetailsapi.service;

public class CommercialUseFactor {
    public static double calculateCommercialUseFactor(String commercialUse) {

        if(commercialUse.equalsIgnoreCase("yes")){
            return 1.1;
        } else if (commercialUse.equalsIgnoreCase("no")){
            return 1.0;
        } else {
            throw new IllegalArgumentException("Commercial use must be \"yes\" or \"no\"");
        }

    }
}
