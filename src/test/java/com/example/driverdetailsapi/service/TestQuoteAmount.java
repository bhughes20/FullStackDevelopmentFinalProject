package com.example.driverdetailsapi.service;

import com.example.driverdetailsapi.model.DriverDetails;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQuoteAmount {

    String test1VehicleType, test1EngineSize, test1CommercialUse, test1OutsideStateUse;
    String test2VehicleType, test2EngineSize, test2CommercialUse, test2OutsideStateUse;
    int test1AdditionalDrivers;
    int test2AdditionalDrivers;
    double test1VehicleValue;
    double test2VehicleValue;
    DriverDetails driverDetails;

    @BeforeEach
    void setup(){

        driverDetails = new DriverDetails();

        test1VehicleType = "Hatchback";
        test1EngineSize = "1600";
        test1AdditionalDrivers = 3;
        test1CommercialUse = "yes";
        test1OutsideStateUse = "yes";
        test1VehicleValue = 5000;

        test2VehicleType = "Cabriolet";
        test2EngineSize = "3000";
        test2AdditionalDrivers = 1;
        test2CommercialUse = "NO";
        test2OutsideStateUse = "NO";
        test2VehicleValue = 15000;
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void whenTest1DriverIsPassedToCalculateQuoteAmount_thenAFinalQuoteAmountIsCalculatedAndSet(){
        QuoteAmountService quoteAmountService = new QuoteAmountService();

        driverDetails.setVehicleBodyType(test1VehicleType);
        driverDetails.setEngineSize(test1EngineSize);
        driverDetails.setAdditionalDrivers(test1AdditionalDrivers);
        driverDetails.setCommercialUse(test1CommercialUse);
        driverDetails.setOutsideStateUse(test1OutsideStateUse);
        driverDetails.setCurrentValue(test1VehicleValue);

        quoteAmountService.calculateQuoteAmount(driverDetails);
        assertEquals(371.712, driverDetails.getFinalQuoteAmount(), 0.3);
    }

    @Test
    public void whenTest2DriverIsPassedToCalculateQuoteAmount_thenAFinalQuoteAmountIsCalculatedAndSet(){
        QuoteAmountService quoteAmountService = new QuoteAmountService();

        driverDetails.setVehicleBodyType(test2VehicleType);
        driverDetails.setEngineSize(test2EngineSize);
        driverDetails.setAdditionalDrivers(test2AdditionalDrivers);
        driverDetails.setCommercialUse(test2CommercialUse);
        driverDetails.setOutsideStateUse(test2OutsideStateUse);
        driverDetails.setCurrentValue(test2VehicleValue);

        quoteAmountService.calculateQuoteAmount(driverDetails);
        assertEquals(514.80, driverDetails.getFinalQuoteAmount(), 0.2);
    }

}
