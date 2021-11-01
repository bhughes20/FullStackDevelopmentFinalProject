package com.example.driverdetailsapi.service;

import com.example.driverdetailsapi.model.DriverDetails;
import org.springframework.stereotype.Service;

@Service
public class QuoteAmountService {

    public void calculateQuoteAmount(DriverDetails driverDetails) {

        double typeFactor = VehicleTypeFactor.calculateVehicleTypeFactor(driverDetails.getVehicleBodyType());
        double engineSizeFactor = EngineSizeFactor.calculateEngineSizeFactor(driverDetails.getEngineSize());
        double additionalDriversFactor = AdditionalDriversFactor.calculateAdditionalDriversFactor(driverDetails.getAdditionalDrivers());
        double commercialUseFactor = CommercialUseFactor.calculateCommercialUseFactor(driverDetails.getCommercialUse());
        double outsideStateFactor = OutsideStateUseFactor.calculateOutsideStateUseFactor(driverDetails.getOutsideStateUse());
        double vehicleValueFactor = VehicleValueFactor.calculateVehicleValueFactor(driverDetails.getCurrentValue());

        double quoteAmount = (100 * typeFactor * engineSizeFactor * additionalDriversFactor
                * commercialUseFactor * outsideStateFactor * vehicleValueFactor);

        driverDetails.setFinalQuoteAmount(quoteAmount);
    }
}
