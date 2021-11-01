package com.example.driverdetailsapi.service;

import com.example.driverdetailsapi.model.DriverDetails;
import com.example.driverdetailsapi.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final QuoteAmountService quoteAmountService;

    public DriverService(DriverRepository driverRepository, QuoteAmountService quoteAmountService) {
        this.driverRepository = driverRepository;
        this.quoteAmountService = quoteAmountService;
    }

    public DriverDetails getDriverById(Long id) throws Exception {

        return driverRepository.findById(id)
                .orElseThrow(() -> new Exception("Driver with id " + id + " not found."));
    }

    public List<DriverDetails> getAllDrivers (){
        return driverRepository.findAll();
    }

    public DriverDetails postDriver(DriverDetails driverDetails){
        quoteAmountService.calculateQuoteAmount(driverDetails);
        return driverRepository.save(driverDetails);
    }

     public DriverDetails updateDriverById(DriverDetails driverDetailsToUpdate, Long id){
        return driverRepository.findById(id)
                .map(driver -> {
                    driver.setAdditionalDrivers(driverDetailsToUpdate.getAdditionalDrivers());
                    driver.setAddressLine1(driverDetailsToUpdate.getAddressLine1());
                    driver.setAddressLine2(driverDetailsToUpdate.getAddressLine2());
                    driver.setCity(driverDetailsToUpdate.getCity());
                    driver.setCommercialUse(driverDetailsToUpdate.getCommercialUse());
                    driver.setCurrentValue(driverDetailsToUpdate.getCurrentValue());
                    driver.setEngineSize(driverDetailsToUpdate.getEngineSize());
                    driver.setFirstName(driverDetailsToUpdate.getFirstName());
                    driver.setLastName(driverDetailsToUpdate.getLastName());
                    driver.setOutsideStateUse(driverDetailsToUpdate.getOutsideStateUse());
                    driver.setPostcode(driverDetailsToUpdate.getPostcode());
                    driver.setPrefix(driverDetailsToUpdate.getPrefix());
                    driver.setDateRegistered(driverDetailsToUpdate.getDateRegistered());
                    driver.setTelephoneNumber(driverDetailsToUpdate.getTelephoneNumber());
                    driver.setVehicleBodyType(driverDetailsToUpdate.getVehicleBodyType());
                    return driverRepository.save(driver);
                })
                .orElseGet(() -> driverRepository.save(driverDetailsToUpdate));
    }

    public void deleteDriverById(Long id) {
        driverRepository.deleteById(id);
    }
}
