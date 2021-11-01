package com.example.driverdetailsapi.controller;

import com.example.driverdetailsapi.model.Driver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.example.driverdetailsapi.controller.DriverController.ID_NOT_FOUND_ERROR_MSG;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DriverControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    String prefix, firstName, lastName, telephoneNumber, updatedTelephoneNumber, addressLine1, addressLine2, city, postcode,
    vehicleBodyType, engineSize, commercialUse, outsideStateUse, dateRegistered;
    int additionalDrivers;
    double currentValue, finalQuoteAmount;
    long existingId, nonExistingId;

    Driver driver;

    @BeforeEach
    void setUp() {

        existingId = 1L;
        nonExistingId = 15L;
        updatedTelephoneNumber = "12345678901";

        prefix = "Ms";
        firstName = "Mary";
        lastName = "Poppins";
        telephoneNumber = "100000000000";
        addressLine1 = "Number 17";
        addressLine2 = "Cherry Tree Lane";
        city = "London";
        postcode = "NW1 4NR";
        vehicleBodyType = "Other";
        engineSize = "Other";
        additionalDrivers = 2;
        commercialUse = "yes";
        outsideStateUse = "yes";
        currentValue = 45000.00;
        dateRegistered = "23 December 1910";
        finalQuoteAmount = 0.00;

        driver = new Driver(null, prefix, firstName, lastName, telephoneNumber,
                addressLine1, addressLine2, city, postcode, vehicleBodyType, engineSize,
                additionalDrivers, commercialUse, outsideStateUse, currentValue, dateRegistered,
                finalQuoteAmount);
    }

    @Test
    void givenDBInitialisedWith4Drivers_whenGetDriverByExistingId_thenStatusShouldReturn200() throws Exception {

        mockMvc.perform(get("/drivers/" + existingId))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void givenDBInitialisedWith4Drivers_whenGetDriverByNonExistingId_thenShouldReturnNotFoundError() throws Exception {

        final MvcResult mvcResult = mockMvc
                .perform(get("/drivers/" + nonExistingId)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        String expectedErrorMessage = ID_NOT_FOUND_ERROR_MSG + nonExistingId;

        assertEquals(expectedErrorMessage, mvcResult.getResponse().getErrorMessage());

    }

    @Test
    void givenDBInitialisedWith4Drivers_whenGetAllDrivers_thenShouldReturn4Drivers() throws Exception {

        final MvcResult mvcResult = mockMvc
                .perform(get("/drivers"))
                .andDo(print())
                .andReturn();

        final String contentAsString = mvcResult.getResponse().getContentAsString();

        List<Driver> driversFromDB = objectMapper.readValue(contentAsString, new TypeReference<>(){});

        assertEquals(4, driversFromDB.size());
    }

    @Test
    void givenDBInitialisedWith4Drivers_whenGetAllDrivers_thenStatusShouldReturn200() throws Exception {

        mockMvc.perform(get("/drivers"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DirtiesContext
    void givenDBInitialisedWith4Drivers_whenPostDriver_thenShouldSaveAndReturnDriver() throws Exception {

        final String driverJSON = objectMapper.writeValueAsString(driver);

        final MvcResult mvcResult = mockMvc
                .perform(post("/drivers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(driverJSON)
                )
                .andDo(print())
                .andReturn();

        final String contentAsString = mvcResult.getResponse().getContentAsString();

        Driver savedDriver = objectMapper.readValue(contentAsString, Driver.class);

        assertAll(
                () -> assertNotNull(savedDriver.getId()),
                () -> assertEquals(prefix, savedDriver.getPrefix()),
                () -> assertEquals(firstName, savedDriver.getFirstName()),
                () -> assertEquals(lastName, savedDriver.getLastName()),
                () -> assertEquals(telephoneNumber, savedDriver.getTelephoneNumber()),
                () -> assertEquals(addressLine1, savedDriver.getAddressLine1()),
                () -> assertEquals(addressLine2, savedDriver.getAddressLine2()),
                () -> assertEquals(city, savedDriver.getCity()),
                () -> assertEquals(postcode, savedDriver.getPostcode()),
                () -> assertEquals(vehicleBodyType, savedDriver.getVehicleBodyType()),
                () -> assertEquals(engineSize, savedDriver.getEngineSize()),
                () -> assertEquals(additionalDrivers, savedDriver.getAdditionalDrivers()),
                () -> assertEquals(commercialUse, savedDriver.getCommercialUse()),
                () -> assertEquals(outsideStateUse, savedDriver.getOutsideStateUse()),
                () -> assertEquals(currentValue, savedDriver.getCurrentValue(), 0.2),
                () -> assertEquals(dateRegistered, savedDriver.getDateRegistered())
        );
    }

    @Test
    @DirtiesContext
    void givenDBInitialisedWith4Drivers_whenPostDriver_thenStatusShouldReturn200() throws Exception {

        final String driverJSON = objectMapper.writeValueAsString(driver);

        mockMvc.perform(post("/drivers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(driverJSON)
                )
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DirtiesContext
    void givenDBInitialisedWith4Drivers_whenUpdateDriverTelephoneNumberByExistingId_thenShouldReturnUpdatedTelephoneNumber() throws Exception {

        driver.setId(existingId);
        driver.setTelephoneNumber(updatedTelephoneNumber);

        final String driverJSON = objectMapper.writeValueAsString(driver);

        final MvcResult mvcResult = mockMvc
                .perform(put("/drivers/" + existingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(driverJSON)
                )
                .andDo(print())
                .andReturn();

        final String contentAsString = mvcResult.getResponse().getContentAsString();

        Driver updatedDriver = objectMapper.readValue(contentAsString, Driver.class);

        assertAll(
                () -> assertEquals(existingId, updatedDriver.getId()),
                () -> assertEquals(updatedTelephoneNumber, updatedDriver.getTelephoneNumber())
        );
    }

    @Test
    @DirtiesContext
    void givenDBInitialisedWith4Drivers_whenUpdateDriverTelephoneNumberByExistingId_thenStatusShouldReturn200() throws Exception {

        driver.setId(existingId);
        driver.setTelephoneNumber(updatedTelephoneNumber);

        final String driverJSON = objectMapper.writeValueAsString(driver);

        mockMvc.perform(put("/drivers/" + existingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(driverJSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DirtiesContext
    void givenDBInitialisedWith4Drivers_whenUpdateDriverTelephoneNumberByNonExistingId_thenShouldReturnNotFoundError() throws Exception {

        String updatedTelephoneNumber = "12345678901";
        driver.setId(nonExistingId);
        driver.setTelephoneNumber(updatedTelephoneNumber);

        final String driverJSON = objectMapper.writeValueAsString(driver);

        final MvcResult mvcResult = mockMvc
                .perform(put("/drivers/" + nonExistingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(driverJSON)
                )
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        String expectedErrorMessage = ID_NOT_FOUND_ERROR_MSG + nonExistingId;

        assertEquals(expectedErrorMessage, mvcResult.getResponse().getErrorMessage());
    }

    @Test
    @DirtiesContext
    void givenDBInitialisedWith4Drivers_whenDeleteDriverByExistingId_thenStatusShouldReturn200() throws Exception {

        mockMvc.perform(delete("/drivers/" + existingId)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DirtiesContext
    void givenDBInitialisedWith4Drivers_whenDeleteDriverByNonExistingId_thenShouldReturnNotFoundError() throws Exception {

        final MvcResult mvcResult = mockMvc
                .perform(delete("/drivers/" + nonExistingId)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        String expectedErrorMessage = ID_NOT_FOUND_ERROR_MSG + nonExistingId;

        assertEquals(expectedErrorMessage, mvcResult.getResponse().getErrorMessage());
    }
}