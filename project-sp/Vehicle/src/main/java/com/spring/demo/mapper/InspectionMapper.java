package com.spring.demo.mapper;

import com.spring.demo.dto.InspectionDto;
import com.spring.demo.model.Inspection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface InspectionMapper {
    @Mapping(source = "vehicle.id",target = "vehicleId")
    InspectionDto toDto(Inspection inspection);
    @Mapping(source ="vehicleId" ,target = "vehicle.id")
    Inspection toEntity(InspectionDto inspectionDto);
    List<InspectionDto> toDtoList(List<Inspection> inspections);
    List<Inspection>toEntityList(List<InspectionDto>dtoList);
}

