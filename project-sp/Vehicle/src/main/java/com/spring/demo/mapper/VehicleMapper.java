package com.spring.demo.mapper;

import com.spring.demo.dto.VehicleDetailsDto;
import com.spring.demo.dto.VehicleDto;
import com.spring.demo.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface VehicleMapper {
    // Entity → DTO (للـ API)
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "license.id", target = "licenseId")
    VehicleDto toDto(Vehicle vehicle);
    Vehicle toEntity(VehicleDto vehicleDto);
    VehicleDetailsDto toDetailsDto(Vehicle vehicle);
    List<VehicleDetailsDto> toDetailsDtoList(List<Vehicle>vehicles);

}

// mapper : حول من object to object