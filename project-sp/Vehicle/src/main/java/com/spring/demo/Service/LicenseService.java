package com.spring.demo.Service;

import com.spring.demo.dto.LicenseDto;

import java.util.List;
//اهم كلاس فى البروجكت عموما
public interface LicenseService {
    //اهم ميثود فى البروجكت
    LicenseDto renewLicense(Long vehicleId);

    LicenseDto getLicenseByVehicle(Long vehicleId);

    List<LicenseDto> getExpiredLicenses();

    LicenseDto createLicense(Long vehicleId);

    void deleteLicense(Long id);
}