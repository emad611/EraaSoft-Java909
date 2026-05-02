package com.spring.demo.Service.Impl;

import com.spring.demo.Service.InspectionService;
import com.spring.demo.dao.InspectionRepo;
import com.spring.demo.dao.VehicleRepo;
import com.spring.demo.dto.InspectionDto;
import com.spring.demo.mapper.InspectionMapper;
import com.spring.demo.model.Inspection;
import com.spring.demo.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
@Service
public class InspectionServiceImpl implements InspectionService {
private InspectionRepo inspectionRepo;
private InspectionMapper inspectionMapper;
private VehicleRepo vehicleRepo;
    @Autowired
    public InspectionServiceImpl(InspectionRepo inspectionRepo, InspectionMapper inspectionMapper) {
        this.inspectionRepo = inspectionRepo;
        this.inspectionMapper = inspectionMapper;
    }

    @Override
    public InspectionDto createInspection(Long vehicleId) {
        Vehicle vehicle = vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        Inspection inspection = inspectionRepo.findLatestByVehicleId(vehicleId);
        if (inspection == null || inspection.getValidUntil().isBefore(LocalDate.now())) {
            throw new RuntimeException("Inspection is not valid. Cannot renew license.");
        }
        inspection=inspectionRepo.save(inspection);
       return inspectionMapper.toDto(inspection);
    }

    @Override
    public InspectionDto updateInspection(Long id,InspectionDto inspectionDto) {
        Inspection inspection=inspectionRepo.findById(id)
                .orElseThrow(()->new RuntimeException("not found inspection to update"));
        inspection.setInspectionDate(inspectionDto.getInspectionDate());
        inspection.setNotes(inspectionDto.getNotes());
        inspection.setResult(inspectionDto.getResult());

        inspection.setValidUntil(inspectionDto.getInspectionDate().plusMonths(6));

       inspection= inspectionRepo.save(inspection);
        return inspectionMapper.toDto(inspection);


    }

    @Override
    public void deleteInspection(Long id) {
Inspection inspection=inspectionRepo.findById(id)
        .orElseThrow(()->new RuntimeException("not found inspection to delete"));
        if (inspection.getValidUntil().isAfter(LocalDate.now())) {
            throw new RuntimeException("Cannot delete valid inspection");
        }
    inspectionRepo.deleteById(id);
    }

    @Override
    public InspectionDto getInspectionById(Long id) {
        Inspection inspection=inspectionRepo.findById(id)
                .orElseThrow(()->new RuntimeException("not found inspection to get "));
        return inspectionMapper.toDto(inspection);
    }

    @Override
    public List<InspectionDto> getInspections() {
       List<Inspection>inspections=inspectionRepo.findAll();
       return inspectionMapper.toDtoList(inspections);
    }
}
