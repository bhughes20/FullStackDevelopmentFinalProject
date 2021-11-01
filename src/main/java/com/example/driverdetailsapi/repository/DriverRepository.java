package com.example.driverdetailsapi.repository;

import com.example.driverdetailsapi.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
