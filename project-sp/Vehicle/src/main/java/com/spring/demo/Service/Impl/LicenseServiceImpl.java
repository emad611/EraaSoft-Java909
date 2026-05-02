package com.spring.demo.Service.Impl;

import com.spring.demo.Service.LicenseService;
import com.spring.demo.dao.*;
import com.spring.demo.dto.FineDto;
import com.spring.demo.dto.InspectionDto;
import com.spring.demo.dto.LicenseDto;
import com.spring.demo.dto.VehicleDto;
import com.spring.demo.mapper.LicenseMapper;
import com.spring.demo.mapper.UserMapper;
import com.spring.demo.model.Fine;
import com.spring.demo.model.Inspection;
import com.spring.demo.model.License;
import com.spring.demo.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class LicenseServiceImpl implements LicenseService {
    private LicenseRepo licenseRepo;
    private LicenseMapper licenseMapper;
    private VehicleRepo vehicleRepo;
    private InspectionRepo inspectionRepo;
    private FineRepo fineRepo;

    @Autowired
    public LicenseServiceImpl(LicenseRepo licenseRepo, LicenseMapper licenseMapper, VehicleRepo vehicleRepo, InspectionRepo inspectionRepo, FineRepo fineRepo) {
        this.licenseRepo = licenseRepo;
        this.licenseMapper = licenseMapper;
        this.vehicleRepo = vehicleRepo;
        this.inspectionRepo = inspectionRepo;
        this.fineRepo = fineRepo;
    }



    @Override
    public LicenseDto renewLicense(Long vehicleId) {
Vehicle vehicle=vehicleRepo.findById(vehicleId)
        .orElseThrow(()->new RuntimeException("Vehicle not found"));

         License license=vehicle.getLicense();
        if (license == null) {
            throw new RuntimeException("No license found for this vehicle");
        }
        Inspection inspection=inspectionRepo.findLatestByVehicleId(vehicleId);
        if(inspection==null||inspection.getValidUntil().isBefore(LocalDate.now())){
            throw new RuntimeException("Inspection is not valid. Cannot renew license.");
        }
         if(license.getExpiryDate().isBefore(LocalDate.now())){
             Fine fine=new Fine();
             fine.setAmount(300.0);
             fine.setStatus("UNPAID");
             fine.setDate(LocalDateTime.now());
             fine .setVehicle(vehicle);
             fineRepo.save(fine);

         }
        license.setExpiryDate(LocalDate.now().plusYears(1));
         license.setStatus("ACTIVE");
        license = licenseRepo.save(license);


        return licenseMapper.toDto(license);

    }

    @Override
    public LicenseDto getLicenseByVehicle(Long vehicleId) {
        Vehicle vehicle= vehicleRepo.findById(vehicleId)
                .orElseThrow(()->new RuntimeException("Vehicle not found"));
        License license= vehicle.getLicense();
        if (license == null) {
            throw new RuntimeException("No license found for this vehicle");
        }
        return licenseMapper.toDto(license);
    }

    @Override
    public List<LicenseDto> getExpiredLicenses() {
        List<License> licenses =
                licenseRepo.findByExpiryDateBefore(LocalDate.now());

        return licenseMapper.toDtoList(licenses);
    }

    @Override
    public LicenseDto createLicense(Long vehicleId) {
        Vehicle vehicle= vehicleRepo.findById(vehicleId)
                .orElseThrow(()->new RuntimeException("Vehicle not found"));
        License license=new License();
        license.setVehicle(vehicle);
        license.setIssueDate(LocalDate.now());
        license.setExpiryDate(LocalDate.now().plusYears(1));
        license.setStatus("ACTIVE");
        license=licenseRepo.save(license);
        return licenseMapper.toDto(license);
    }

    @Override
    public void deleteLicense(Long id) {
        License license = licenseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("License not found"));
        if (license.getVehicle() != null) {
            throw new RuntimeException("Cannot delete license linked to a vehicle");
        }

        if (license.getVehicle() != null &&
                !license.getVehicle().getFines().isEmpty()) {

            throw new RuntimeException("Cannot delete license with active fines");
        }
        if (license.getStatus().equals("ACTIVE")) {
            throw new RuntimeException("Cannot delete active license");
        }
        licenseRepo.delete(license);
    }
}
