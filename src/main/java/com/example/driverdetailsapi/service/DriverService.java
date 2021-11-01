package com.example.driverdetailsapi.service;

import com.example.driverdetailsapi.model.Driver;
import com.example.driverdetailsapi.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final QuoteAmountService quoteAmountService;

    public DriverService(DriverRepository driverRepository, QuoteAmountService quoteAmountService) {
        this.driverRepository = driverRepository;
        this.quoteAmountService = quoteAmountService;
    }

    public Driver getDriverById(Long id) throws NoSuchElementException {
        return driverRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Driver with id " + id + " not found."));
    }

    public List<Driver> getAllDrivers (){
        return driverRepository.findAll();
    }

    public Driver postDriver(Driver driver){
        quoteAmountService.calculateQuoteAmount(driver);
        List<Driver> driverList = new ArrayList<>();
        driverList.add(driver);
        DisplayDriverDetails displayDriverDetails = new DisplayDriverDetails();
        displayDriverDetails.displayDriverDetails(driverList);
        return driverRepository.save(driver);
    }

     public Driver updateDriverById(Driver driverToUpdate, Long id){
        return driverRepository.findById(id)
                .map(driver -> {
                    driver.setAdditionalDrivers(driverToUpdate.getAdditionalDrivers());
                    driver.setAddressLine1(driverToUpdate.getAddressLine1());
                    driver.setAddressLine2(driverToUpdate.getAddressLine2());
                    driver.setCity(driverToUpdate.getCity());
                    driver.setCommercialUse(driverToUpdate.getCommercialUse());
                    driver.setCurrentValue(driverToUpdate.getCurrentValue());
                    driver.setEngineSize(driverToUpdate.getEngineSize());
                    driver.setFirstName(driverToUpdate.getFirstName());
                    driver.setLastName(driverToUpdate.getLastName());
                    driver.setOutsideStateUse(driverToUpdate.getOutsideStateUse());
                    driver.setPostcode(driverToUpdate.getPostcode());
                    driver.setPrefix(driverToUpdate.getPrefix());
                    driver.setDateRegistered(driverToUpdate.getDateRegistered());
                    driver.setTelephoneNumber(driverToUpdate.getTelephoneNumber());
                    driver.setVehicleBodyType(driverToUpdate.getVehicleBodyType());
                    return driverRepository.save(driver);
                })
                .orElseThrow(() -> new NoSuchElementException("Driver with id " + id + " not found."));
    }

    public void deleteDriverById(Long id) {
        driverRepository.deleteById(id);
    }
}
