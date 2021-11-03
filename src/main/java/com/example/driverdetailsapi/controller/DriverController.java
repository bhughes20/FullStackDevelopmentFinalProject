package com.example.driverdetailsapi.controller;

import com.example.driverdetailsapi.service.DriverService;
import com.example.driverdetailsapi.model.Driver;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class DriverController {

    private final DriverService service;
    public static final String ID_NOT_FOUND_ERROR_MSG = "Driver Not Found for ID: ";

    public DriverController(DriverService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/drivers/{id}")
    Driver getDriverById(@PathVariable Long id) {
        try{
            return service.getDriverById(id);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ID_NOT_FOUND_ERROR_MSG + id, noSuchElementException);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/drivers")
    List<Driver> getAllDrivers(){ return service.getAllDrivers(); }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/drivers")
    Driver postDriver(@RequestBody Driver driver){
        return service.postDriver(driver);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/drivers/{id}")
    Driver updateDriverById(@RequestBody Driver driverToUpdate, @PathVariable Long id){
        try{
            return service.updateDriverById(driverToUpdate, id);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ID_NOT_FOUND_ERROR_MSG + id, noSuchElementException);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/drivers/{id}")
    void deleteDriverById(@PathVariable Long id){
        try{
            service.getDriverById(id);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ID_NOT_FOUND_ERROR_MSG + id, noSuchElementException);
        }
        service.deleteDriverById(id);
    }
}