package com.spring.demo.dao;

import com.spring.demo.model.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRepo extends JpaRepository<Inspection,Long> {
   //  آخر فحص للعربية
    Inspection findLatestByVehicleId(Long vehicleId);
}
