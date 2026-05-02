package com.spring.demo.Contorller;

import com.spring.demo.Service.LicenseService;
import com.spring.demo.dto.LicenseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/licenses")
public class LicenseController {
    private LicenseService licenseService;
    @Autowired
    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }
    @PostMapping("/renew/{vehicleId}")
    public ResponseEntity<LicenseDto> renewLicense(@PathVariable Long vehicleId) throws URISyntaxException {
        return ResponseEntity.created(new URI("/licenses/renew/{vehicleId}"))
                .body(licenseService.renewLicense(vehicleId));
    }
    @GetMapping("/{vehicleId}")
    public ResponseEntity<LicenseDto>getLicenseByVehicle(@PathVariable Long vehicleId){
    return ResponseEntity.ok(licenseService.getLicenseByVehicle(vehicleId));
    }
    @GetMapping("/expired")
    public ResponseEntity<List<LicenseDto>>getExpiredLicenses(){
        return ResponseEntity.ok(licenseService.getExpiredLicenses());
    }
    
}
