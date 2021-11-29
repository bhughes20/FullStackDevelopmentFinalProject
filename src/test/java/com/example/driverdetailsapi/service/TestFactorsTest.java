package com.example.driverdetailsapi.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFactorsTest {

    String validVehicleType1, validVehicleType2, invalidVehicleType;
    String validEngineSize1, validEngineSize2, invalidEngineSize;
    int validAdditionalDrivers1, validAdditionalDrivers2, invalidAdditionalDrivers1, invalidAdditionalDrivers2;
    String validCommercialUse1, validCommercialUse2, invalidCommercialUse;
    String validOutsideStateUse1, validOutsideStateUse2, invalidOutsideStateUse;
    double validVehicleValue1, validVehicleValue2, invalidVehicleValue;

    @BeforeEach
    void setUp() throws IllegalArgumentException {

        validVehicleType1 = "COUPE";
        validVehicleType2 = "Hatchback";
        invalidVehicleType = "Not a vehicle";

        validEngineSize1 = "1000";
        validEngineSize2 = "Other";
        invalidEngineSize = "1.0";

        validAdditionalDrivers1 = 1;
        validAdditionalDrivers2 = 2;
        invalidAdditionalDrivers1 = 5;
        invalidAdditionalDrivers2 = -1;

        validCommercialUse1 = "yEs";
        validCommercialUse2 = "NO";
        invalidCommercialUse = "N/A";

        validOutsideStateUse1 = "yes";
        validOutsideStateUse2 = "No";
        invalidOutsideStateUse = "None";

        validVehicleValue1 = 4999;
        validVehicleValue2 = 5000.99;
        invalidVehicleValue = 50000.01;
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void whenValidVehicleTypeOfCoupe_thenCorrectVehicleTypeFactorShouldBeReturned() {
        assertEquals(1.4, VehicleTypeFactor.calculateVehicleTypeFactor(validVehicleType1));
    }

    @Test
    public void whenValidVehicleTypeOfHatchback_thenCorrectVehicleTypeFactorShouldBeReturned() {
        assertEquals(1.6, VehicleTypeFactor.calculateVehicleTypeFactor(validVehicleType2));
    }

    @Test
    public void whenInvalidVehicleType_thenIllegalArgumentExceptionShouldBeThrown() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> VehicleTypeFactor.calculateVehicleTypeFactor(invalidVehicleType));

        String expectedMessage = "Invalid vehicle type provided";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenValidEngineSizeOf1000_thenCorrectEngineSizeFactorShouldBeReturned() {
        assertEquals(1.0, EngineSizeFactor.calculateEngineSizeFactor(validEngineSize1));
    }

    @Test
    public void whenValidEngineSizeOfOther_thenCorrectEngineSizeFactorShouldBeReturned() {
        assertEquals(3.5, EngineSizeFactor.calculateEngineSizeFactor(validEngineSize2));
    }

    @Test
    public void whenInvalidEngineSize_thenIllegalArgumentExceptionShouldBeThrown() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> EngineSizeFactor.calculateEngineSizeFactor(invalidEngineSize));

        String expectedMessage = "Invalid engine size provided";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenValidAdditionalDriversOf1_thenCorrectAdditionalDriversFactorShouldBeReturned() {
        assertEquals(1.1, AdditionalDriversFactor.calculateAdditionalDriversFactor(validAdditionalDrivers1));
    }

    @Test
    public void whenValidAdditionalDriversOf2_thenCorrectAdditionalDriversFactorShouldBeReturned() {
        assertEquals(1.2, AdditionalDriversFactor.calculateAdditionalDriversFactor(validAdditionalDrivers2));
    }

    @Test
    public void whenInvalidAdditionalDriversOf5_thenIllegalArgumentExceptionShouldBeThrown() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> AdditionalDriversFactor.calculateAdditionalDriversFactor(invalidAdditionalDrivers1));

        String expectedMessage = "Additional drivers must be between 0 and 4 (inclusive)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenInvalidAdditionalDriversOfNegative1_thenIllegalArgumentExceptionShouldBeThrown() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> AdditionalDriversFactor.calculateAdditionalDriversFactor(invalidAdditionalDrivers2));

        String expectedMessage = "Additional drivers must be between 0 and 4 (inclusive)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenValidCommercialUseOfYes_thenCorrectCommercialUseFactorShouldBeThrown() {
        assertEquals(1.1, CommercialUseFactor.calculateCommercialUseFactor(validCommercialUse1));
    }

    @Test
    public void whenValidCommercialUseOfNo_thenCorrectCommercialUseFactorShouldBeThrown() {
        assertEquals(1.0, CommercialUseFactor.calculateCommercialUseFactor(validCommercialUse2));
    }

    @Test
    public void whenInvalidCommercialUse_thenIllegalArgumentExceptionShouldBeThrown() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> CommercialUseFactor.calculateCommercialUseFactor(invalidCommercialUse));

        String expectedMessage = "Commercial use must be \"yes\" or \"no\"";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenValidOutsideStateUseOfYes_thenCorrectOutsideStateUseFactorShouldBeThrown() {
        assertEquals(1.1, OutsideStateUseFactor.calculateOutsideStateUseFactor(validOutsideStateUse1));
    }

    @Test
    public void whenValidOutsideStateUseOfNo_thenCorrectOutsideStateUseFactorShouldBeThrown() {
        assertEquals(1.0, OutsideStateUseFactor.calculateOutsideStateUseFactor(validOutsideStateUse2));
    }

    @Test
    public void whenInvalidOutsideStateUse_thenIllegalArgumentExceptionShouldBeThrown() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OutsideStateUseFactor.calculateOutsideStateUseFactor(invalidOutsideStateUse));

        String expectedMessage = "Outside state use must be \"yes\" or \"no\"";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenValidVehicleValueOf4999_thenCorrectVehicleValueFactorShouldBeReturned() {
        assertEquals(1.0, VehicleValueFactor.calculateVehicleValueFactor(validVehicleValue1));
    }

    @Test
    public void whenValidVehicleValueOf5000And99c_thenCorrectVehicleValueFactorShouldBeReturned() {
        assertEquals(1.2, VehicleValueFactor.calculateVehicleValueFactor(validVehicleValue2));
    }

    @Test
    public void whenInvalidVehicleValue_thenIllegalArgumentExceptionShouldBeThrown() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> VehicleValueFactor.calculateVehicleValueFactor(invalidVehicleValue));

        String expectedMessage = "Vehicle value must be between $0 and $50,000 (inclusive)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
