package com.spring.demo.Service;

import com.spring.demo.dto.InspectionDto;

import java.util.List;

public interface InspectionService {
    InspectionDto createInspection(Long vehicleId);
    InspectionDto updateInspection(Long id,InspectionDto inspectionDto);
    void deleteInspection(Long id);
    InspectionDto getInspectionById(Long id);
    List<InspectionDto>getInspections();
}
