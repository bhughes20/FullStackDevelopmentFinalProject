package com.example.groupdemo.controller;

import com.example.groupdemo.model.Driver;
import com.example.groupdemo.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {

    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/drivers/{id}")
    Driver getDriverById(@PathVariable Long id) throws Exception {
        return service.getDriverById(id);
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
        return service.updateDriverById(driverToUpdate, id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/drivers/{id}")
    void deleteDriverById(@PathVariable Long id){
        service.deleteDriverById(id);
    }
}
