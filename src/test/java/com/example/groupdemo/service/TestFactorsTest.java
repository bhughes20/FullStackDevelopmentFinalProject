package com.example.groupdemo.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFactorsTest {

    String validVehicleType1, validVehicleType2, invalidVehicleType;
    String validEngineSize1, validEngineSize2, invalidEngineSize;
    int validAdditionalDrivers1, validAdditionalDrivers2, invalidAdditionalDrivers1, invalidAdditionalDrivers2;

    @BeforeEach
    void setUp() throws IllegalArgumentException {

        validVehicleType1 = "Coupe";
        validVehicleType2 = "Hatchback";
        invalidVehicleType = "Not a vehicle";

        validEngineSize1 = "1000";
        validEngineSize2 = "Other";
        invalidEngineSize = "1.0";

        validAdditionalDrivers1 = 1;
        validAdditionalDrivers2 = 2;
        invalidAdditionalDrivers1 = 5;
        invalidAdditionalDrivers2 = -1;

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
    public void whenValidEngineSizeOf1000_thenCorrectEngineSizeFactorShouldBeReturned(){
        assertEquals(1.0, EngineSizeFactor.calculateEngineSizeFactor(validEngineSize1));
    }

    @Test
    public void whenValidEngineSizeOfOther_thenCorrectEngineSizeFactorShouldBeReturned(){
        assertEquals(3.5, EngineSizeFactor.calculateEngineSizeFactor(validEngineSize2));
    }

    @Test
    public void whenInvalidEngineSize_thenIllegalArgumentExceptionShouldBeThrown(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> EngineSizeFactor.calculateEngineSizeFactor(invalidEngineSize));

        String expectedMessage = "Invalid engine size provided";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenValidAdditionalDriversOf1_thenCorrectAdditionalDriversFactorShouldBeReturned(){
        assertEquals(1.1, AdditionalDriversFactor.calculateAdditionalDriversFactor(validAdditionalDrivers1));
    }

    @Test
    public void whenValidAdditionalDriversOf2_thenCorrectAdditionalDriversFactorShouldBeReturned(){
        assertEquals(1.2, AdditionalDriversFactor.calculateAdditionalDriversFactor(validAdditionalDrivers2));
    }

    @Test
    public void whenInvalidAdditionalDriversOf5_thenIllegalArgumentExceptionShouldBeThrown(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> AdditionalDriversFactor.calculateAdditionalDriversFactor(invalidAdditionalDrivers1));

        String expectedMessage = "Additional drivers must be between 0 and 4 (inclusive)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenInvalidAdditionalDriversOfNegative1_thenIllegalArgumentExceptionShouldBeThrown(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> AdditionalDriversFactor.calculateAdditionalDriversFactor(invalidAdditionalDrivers2));

        String expectedMessage = "Additional drivers must be between 0 and 4 (inclusive)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
