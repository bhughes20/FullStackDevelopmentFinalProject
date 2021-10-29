package com.example.groupdemo.service;

import com.example.groupdemo.model.Driver;
import org.springframework.stereotype.Service;

@Service
public class QuoteAmountService {

    public void calculateQuoteAmount(Driver driver) {

        double typeFactor = VehicleTypeFactor.calculateVehicleTypeFactor(driver.getVehicleType());
        double engineSizeFactor = EngineSizeFactor.calculateEngineSizeFactor(driver.getEngineSize());
        double additionalDriversFactor = AdditionalDriversFactor.calculateAdditionalDriversFactor(driver.getAdditionalDrivers());
        double commercialUseFactor = CommercialUseFactor.calculateCommercialUseFactor(driver.getCommercialPurposes());
        double outsideStateFactor = OutsideStateUseFactor.calculateOutsideStateUseFactor(driver.getOutOfRegisteredState());
        double vehicleValueFactor = VehicleValueFactor.calculateVehicleValueFactor(driver.getCurrentValue());

        double quoteAmount = (100 * typeFactor * engineSizeFactor * additionalDriversFactor
                * commercialUseFactor * outsideStateFactor * vehicleValueFactor);

        driver.setFinalQuoteAmount(quoteAmount);
    }
}
