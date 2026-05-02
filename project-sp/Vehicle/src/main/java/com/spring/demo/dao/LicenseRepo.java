package com.spring.demo.dao;

import com.spring.demo.dto.InspectionDto;
import com.spring.demo.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface LicenseRepo extends JpaRepository<License,Long> {
   List< License> findByExpiryDateBefore(LocalDate today);
}
