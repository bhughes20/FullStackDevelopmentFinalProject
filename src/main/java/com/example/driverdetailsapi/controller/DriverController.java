package com.example.driverdetailsapi.controller;

import com.example.driverdetailsapi.service.DriverService;
import com.example.driverdetailsapi.model.DriverDetails;
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
    DriverDetails getDriverById(@PathVariable Long id) throws Exception {
        return service.getDriverById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/drivers")
    List<DriverDetails> getAllDrivers(){ return service.getAllDrivers(); }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/drivers")
    DriverDetails postDriver(@RequestBody DriverDetails driverDetails){
        return service.postDriver(driverDetails);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/drivers/{id}")
    DriverDetails updateDriverById(@RequestBody DriverDetails driverDetailsToUpdate, @PathVariable Long id){
        return service.updateDriverById(driverDetailsToUpdate, id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/drivers/{id}")
    void deleteDriverById(@PathVariable Long id){
        service.deleteDriverById(id);
    }
}
