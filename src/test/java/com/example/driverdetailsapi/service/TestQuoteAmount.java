package com.example.driverdetailsapi.service;

import com.example.driverdetailsapi.model.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQuoteAmount {

    String test1VehicleType, test1EngineSize, test1CommercialUse, test1OutsideStateUse;
    String test2VehicleType, test2EngineSize, test2CommercialUse, test2OutsideStateUse;
    String test3VehicleType, test3EngineSize, test3CommercialUse, test3OutsideStateUse;
    String test4VehicleType, test4EngineSize, test4CommercialUse, test4OutsideStateUse;
    int test1AdditionalDrivers, test2AdditionalDrivers, test3AdditionalDrivers, test4AdditionalDrivers;
    double test1VehicleValue, test2VehicleValue, test3VehicleValue, test4VehicleValue;
    Driver driver;

    @BeforeEach
    void setup() {

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

        test3VehicleType = "Estate";
        test3EngineSize = "Other";
        test3AdditionalDrivers = 0;
        test3CommercialUse = "yES";
        test3OutsideStateUse = "No";
        test3VehicleValue = 49999.99;

        test4VehicleType = "Other";
        test4EngineSize = "1000";
        test4AdditionalDrivers = 4;
        test4CommercialUse = "no";
        test4OutsideStateUse = "yes";
        test4VehicleValue = 0.01;
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void whenTest1DriverIsPassedToCalculateQuoteAmount_thenAFinalQuoteAmountIsCalculatedAndSet() {
        QuoteAmountService quoteAmountService = new QuoteAmountService();

        driver.setVehicleBodyType(test1VehicleType);
        driver.setEngineSize(test1EngineSize);
        driver.setAdditionalDrivers(test1AdditionalDrivers);
        driver.setCommercialUse(test1CommercialUse);
        driver.setOutsideStateUse(test1OutsideStateUse);
        driver.setCurrentValue(test1VehicleValue);

        quoteAmountService.calculateQuoteAmount(driver);
        assertEquals(371.712, driver.getFinalQuoteAmount(), 0.3);
    }

    @Test
    public void whenTest2DriverIsPassedToCalculateQuoteAmount_thenAFinalQuoteAmountIsCalculatedAndSet() {
        QuoteAmountService quoteAmountService = new QuoteAmountService();

        driver.setVehicleBodyType(test2VehicleType);
        driver.setEngineSize(test2EngineSize);
        driver.setAdditionalDrivers(test2AdditionalDrivers);
        driver.setCommercialUse(test2CommercialUse);
        driver.setOutsideStateUse(test2OutsideStateUse);
        driver.setCurrentValue(test2VehicleValue);

        quoteAmountService.calculateQuoteAmount(driver);
        assertEquals(514.80, driver.getFinalQuoteAmount(), 0.2);
    }

    @Test
    public void whenTest3DriverIsPassedToCalculateQuoteAmount_thenAFinalQuoteAmountIsCalculatedAndSet() {
        QuoteAmountService quoteAmountService = new QuoteAmountService();

        driver.setVehicleBodyType(test3VehicleType);
        driver.setEngineSize(test3EngineSize);
        driver.setAdditionalDrivers(test3AdditionalDrivers);
        driver.setCommercialUse(test3CommercialUse);
        driver.setOutsideStateUse(test3OutsideStateUse);
        driver.setCurrentValue(test3VehicleValue);

        quoteAmountService.calculateQuoteAmount(driver);
        assertEquals(762.30, driver.getFinalQuoteAmount(), 0.2);
    }

    @Test
    public void whenTest4DriverIsPassedToCalculateQuoteAmount_thenAFinalQuoteAmountIsCalculatedAndSet() {
        QuoteAmountService quoteAmountService = new QuoteAmountService();

        driver.setVehicleBodyType(test4VehicleType);
        driver.setEngineSize(test4EngineSize);
        driver.setAdditionalDrivers(test4AdditionalDrivers);
        driver.setCommercialUse(test4CommercialUse);
        driver.setOutsideStateUse(test4OutsideStateUse);
        driver.setCurrentValue(test4VehicleValue);

        quoteAmountService.calculateQuoteAmount(driver);
        assertEquals(224.40, driver.getFinalQuoteAmount(), 0.2);
    }

}
