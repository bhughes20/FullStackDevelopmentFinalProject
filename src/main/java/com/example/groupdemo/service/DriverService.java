package com.example.groupdemo.service;

import com.example.groupdemo.model.Driver;
import com.example.groupdemo.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver getDriverByID(Long Id){
        return driverRepository.getById(Id);
    }
}
