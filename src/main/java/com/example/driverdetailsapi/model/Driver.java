package com.example.driverdetailsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "DRIVER_DETAILS")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prefix;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postcode;
    private String vehicleBodyType;
    private String engineSize;
    private int additionalDrivers;
    private String commercialUse;
    private String outsideStateUse;
    private double currentValue;
    private Date dateRegistered;
    private double finalQuoteAmount;

    public String formatDateRegistered(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(dateRegistered);
    }

    public String formatCurrency(double value){
        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.format(value);
    }
}
