package com.example.driverdetailsapi.repository;

import com.example.driverdetailsapi.model.DriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverDetails, Long> {
}
