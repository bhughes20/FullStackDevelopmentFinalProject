package com.example.driverdetailsapi.controller;

import com.example.driverdetailsapi.service.DriverService;
import com.example.driverdetailsapi.model.Driver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class DriverController {

    private final DriverService service;
    public static final String ID_NOT_FOUND_ERROR_MSG = "Driver Not Found for ID: ";

    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping("/drivers/{id}")
    Driver getDriverById(@PathVariable Long id) {
        try {
            return service.getDriverById(id);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ID_NOT_FOUND_ERROR_MSG + id, noSuchElementException);
        }
    }

    @GetMapping("/drivers")
    List<Driver> getAllDrivers() {
        return service.getAllDrivers();
    }

    @PostMapping("/drivers")
    Driver postDriver(@RequestBody Driver driver) {
        return service.postDriver(driver);
    }

    @PutMapping("/drivers/{id}")
    Driver updateDriverById(@RequestBody Driver driverToUpdate, @PathVariable Long id) {
        try {
            return service.updateDriverById(driverToUpdate, id);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ID_NOT_FOUND_ERROR_MSG + id, noSuchElementException);
        }
    }

    @DeleteMapping("/drivers/{id}")
    void deleteDriverById(@PathVariable Long id) {
        try {
            service.getDriverById(id);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ID_NOT_FOUND_ERROR_MSG + id, noSuchElementException);
        }
        service.deleteDriverById(id);
    }
}
