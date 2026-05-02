package com.spring.demo.Service;

import com.spring.demo.dto.VehicleDetailsDto;
import com.spring.demo.dto.VehicleDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface VehicleService {
    VehicleDto createVehicle(VehicleDto vehicleDto);

    VehicleDto updateVehicle(Long id,VehicleDto vehicleDto);

    void deleteVehicle(Long id);

    VehicleDetailsDto getVehicleById(Long id);
    List<VehicleDetailsDto> getVehicles(List<Long>ids);
    VehicleDto approveVehicle(Long id,Long adminId);
    VehicleDto rejectVehicle(Long id,Long adminId);

}
