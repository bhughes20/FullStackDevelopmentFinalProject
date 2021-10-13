package com.example.groupdemo.controller;

import com.example.groupdemo.model.Driver;
import com.example.groupdemo.service.DriverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {

    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping("/drivers")
    Driver getDriverById(@RequestParam("id") Long Id){
        return service.getDriverByID(Id);
    }


}
