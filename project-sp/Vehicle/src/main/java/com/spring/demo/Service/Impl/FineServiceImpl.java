package com.spring.demo.Service.Impl;

import com.spring.demo.Service.FineService;
import com.spring.demo.dao.FineRepo;
import com.spring.demo.dao.VehicleRepo;
import com.spring.demo.dto.FineCreateDto;
import com.spring.demo.dto.FineDto;
import com.spring.demo.dto.FineUpdateDto;
import com.spring.demo.mapper.FineMapper;
import com.spring.demo.model.Fine;
import com.spring.demo.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class FineServiceImpl implements FineService {
    private FineRepo fineRepo;
    private FineMapper fineMapper;
    private VehicleRepo vehicleRepo;
    @Autowired
    public FineServiceImpl(FineRepo fineRepo, FineMapper fineMapper) {
        this.fineRepo = fineRepo;
        this.fineMapper = fineMapper;
    }

    @Override
    public FineDto createFine(Long vehicleId, FineCreateDto fineCreateDto) {
        Vehicle vehicle = vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Fine fine = new Fine();
        fine.setVehicle(vehicle);
        fine.setStatus("UNPAID");
        fine.setDate(LocalDateTime.now());

        fine = fineRepo.save(fine);

        return fineMapper.toDto(fine);
    }

    @Override
    public FineDto updateFine(Long id, FineUpdateDto fineUpdateDto) {
        Fine fine=fineRepo.findById(id)
                .orElseThrow(()->new RuntimeException("not found Fine to update"));

        fine=fineRepo.save(fine);
        return fineMapper.toDto(fine);
    }

    @Override
    public void deleteFine(Long id) {
        Fine fine=fineRepo.findById(id)
                .orElseThrow(()->new RuntimeException("not found fine to delete "));

        if (fine.getStatus().equals("PAID")) {
            throw new RuntimeException("Cannot delete paid fine");
        }
        fineRepo.deleteById(id);
    }

    @Override
    public FineDto getFineById(Long id) {
        Fine fine = fineRepo.findById(id)
                .orElseThrow(()->new RuntimeException("not found fine to get by id"));
        return fineMapper.toDto(fine);
    }

    @Override
    public List<FineDto> getFinesByIds(List<Long>ids) {
      List<Fine>fines=fineRepo.findAllById(ids);
      return fineMapper.toDtoList(fines);
    }
}
