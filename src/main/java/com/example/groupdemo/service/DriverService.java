package com.example.groupdemo.service;

import com.example.groupdemo.model.Driver;
import com.example.groupdemo.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver getDriverById(Long id){
        return driverRepository.findById(id).get();
    }

    public List<Driver> getAllDrivers (){
        return driverRepository.findAll();
    }

    public Driver postDriver(Driver driver){
        return driverRepository.save(driver);
    }

     public Driver updateDriverById(Driver driverToUpdate, Long id){
        return driverRepository.findById(id)
                .map(driver -> {
                    driver.setAdditionalDrivers(driverToUpdate.getAdditionalDrivers());
                    driver.setAddressLine1(driverToUpdate.getAddressLine1());
                    driver.setAddressLine2(driverToUpdate.getAddressLine2());
                    driver.setCity(driverToUpdate.getCity());
                    driver.setCommercialPurposes(driverToUpdate.getCommercialPurposes());
                    driver.setCurrentValue(driverToUpdate.getCurrentValue());
                    driver.setEngineSize(driverToUpdate.getEngineSize());
                    driver.setFirstName(driverToUpdate.getFirstName());
                    driver.setLastName(driverToUpdate.getLastName());
                    driver.setOutOfRegisteredState(driverToUpdate.getOutOfRegisteredState());
                    driver.setPostcodeOrZip(driverToUpdate.getPostcodeOrZip());
                    driver.setPrefix(driverToUpdate.getPrefix());
                    driver.setRegistrationDate(driverToUpdate.getRegistrationDate());
                    driver.setTelephoneNumber(driverToUpdate.getTelephoneNumber());
                    driver.setVehicleType(driverToUpdate.getVehicleType());
                    return driverRepository.save(driver);
                })
                .orElseGet(() -> driverRepository.save(driverToUpdate));
    }

    public void deleteDriverById(Long id) {
        driverRepository.deleteById(id);
    }
}
