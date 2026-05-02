package com.spring.demo.Contorller;

import com.spring.demo.Service.VehicleService;
import com.spring.demo.dto.VehicleDetailsDto;
import com.spring.demo.dto.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @PostMapping("/register")
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("vehicles/register")).body(vehicleService.createVehicle(vehicleDto));
    }
    @PutMapping("/{id}/approve")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable Long id,@RequestBody VehicleDto vehicleDto){
        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicleDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDetailsDto>getVehicleById(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }
    @GetMapping("/owner/ids")
    public ResponseEntity<List<VehicleDetailsDto>>getVehicles(@RequestParam("ids") List<Long> ids){
        return ResponseEntity.ok(vehicleService.getVehicles(ids));
    }


}
