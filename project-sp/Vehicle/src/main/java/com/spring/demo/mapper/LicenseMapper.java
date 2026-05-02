package com.spring.demo.mapper;

import com.spring.demo.dto.LicenseDto;
import com.spring.demo.model.License;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface LicenseMapper {
    @Mapping(source = "vehicle.id",target ="vehicleId" )
    LicenseDto toDto(License license);
    License toEntity(LicenseDto licenseDto);
    List<LicenseDto> toDtoList(List<License> licenses);
    List<License> toEntityList(List<LicenseDto>dtoList);
}


