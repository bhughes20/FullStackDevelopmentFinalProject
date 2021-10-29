package com.example.groupdemo.service;

import com.example.groupdemo.model.Driver;
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
    Driver driver;

    @BeforeEach
    void setup(){

        driver = new Driver();

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

        driver.setVehicleType(test1VehicleType);
        driver.setEngineSize(test1EngineSize);
        driver.setAdditionalDrivers(test1AdditionalDrivers);
        driver.setCommercialPurposes(test1CommercialUse);
        driver.setOutOfRegisteredState(test1OutsideStateUse);
        driver.setCurrentValue(test1VehicleValue);

        quoteAmountService.calculateQuoteAmount(driver);
        assertEquals(371.712, driver.getFinalQuoteAmount(), 0.3);
    }

    @Test
    public void whenTest2DriverIsPassedToCalculateQuoteAmount_thenAFinalQuoteAmountIsCalculatedAndSet(){
        QuoteAmountService quoteAmountService = new QuoteAmountService();

        driver.setVehicleType(test2VehicleType);
        driver.setEngineSize(test2EngineSize);
        driver.setAdditionalDrivers(test2AdditionalDrivers);
        driver.setCommercialPurposes(test2CommercialUse);
        driver.setOutOfRegisteredState(test2OutsideStateUse);
        driver.setCurrentValue(test2VehicleValue);

        quoteAmountService.calculateQuoteAmount(driver);
        assertEquals(514.80, driver.getFinalQuoteAmount(), 0.2);
    }

}
