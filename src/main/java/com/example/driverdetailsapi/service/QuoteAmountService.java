package com.example.driverdetailsapi.service;

import com.example.driverdetailsapi.model.Driver;
import org.springframework.stereotype.Service;

@Service
public class QuoteAmountService {

    public void calculateQuoteAmount(Driver driver) {

        double typeFactor = VehicleTypeFactor.calculateVehicleTypeFactor(driver.getVehicleBodyType());
        double engineSizeFactor = EngineSizeFactor.calculateEngineSizeFactor(driver.getEngineSize());
        double additionalDriversFactor = AdditionalDriversFactor.calculateAdditionalDriversFactor(driver.getAdditionalDrivers());
        double commercialUseFactor = CommercialUseFactor.calculateCommercialUseFactor(driver.getCommercialUse());
        double outsideStateFactor = OutsideStateUseFactor.calculateOutsideStateUseFactor(driver.getOutsideStateUse());
        double vehicleValueFactor = VehicleValueFactor.calculateVehicleValueFactor(driver.getCurrentValue());

        double quoteAmount = (100 * typeFactor * engineSizeFactor * additionalDriversFactor
                * commercialUseFactor * outsideStateFactor * vehicleValueFactor);

        driver.setFinalQuoteAmount(quoteAmount);
    }
}
