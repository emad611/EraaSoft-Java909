package com.spring.demo.Service.Impl;

import com.spring.demo.Service.VehicleService;
import com.spring.demo.dao.UserRepo;
import com.spring.demo.dao.VehicleRepo;
import com.spring.demo.dto.VehicleDetailsDto;
import com.spring.demo.dto.VehicleDto;
import com.spring.demo.mapper.VehicleMapper;
import com.spring.demo.model.User;
import com.spring.demo.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepo vehicleRepo;
    private final UserRepo userRepo;
    private final VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepo vehicleRepo, UserRepo userRepo, VehicleMapper vehicleMapper) {
        this.vehicleRepo = vehicleRepo;
        this.userRepo = userRepo;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {

        // 1️⃣ Business Logic: لازم العربية تبقى مربوطة بـ user
        User user = userRepo.findById(vehicleDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Vehicle vehicle = vehicleMapper.toEntity(vehicleDto);

        // 3️⃣ ربط العربية بالـ user
        vehicle.setUser(user);

        // 4️⃣ Business Logic: أي عربية جديدة لازم تبقى pending
        vehicle.setStatus("PENDING");

        vehicle = vehicleRepo.save(vehicle);

        return vehicleMapper.toDto(vehicle);
    }

    @Override
    public VehicleDto updateVehicle(Long id, VehicleDto vehicleDto) {

        // 1️⃣ تأكد إن العربية موجودة
        Vehicle vehicle = vehicleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found to update"));


        vehicle.setPlateNumber(vehicleDto.getPlateNumber());

        vehicleRepo.save(vehicle);

        return vehicleMapper.toDto(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {

        // 1️⃣ check existence
        Vehicle vehicle = vehicleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found to delete"));




        vehicleRepo.delete(vehicle);
    }

    @Override
    public VehicleDetailsDto getVehicleById(Long id) {

        // 1️⃣ get entity
        Vehicle vehicle = vehicleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        //   Entity → Details DTO

        return vehicleMapper.toDetailsDto(vehicle);
    }

    @Override
    public List<VehicleDetailsDto> getVehicles(List<Long>ids) {

        List<Vehicle> vehicles = vehicleRepo.findAllById(ids);

        // ️ تحويل list → details DTO list
        return vehicleMapper.toDetailsDtoList(vehicles);
    }

    // approve
// اليوزر يسجل والادمن يقرر يوافق ولا لا وبعدين يبحث ويحط الحاله وتتحفظ فى الداتا بيز وبعدين يرجعها dto
    @Override
    public VehicleDto approveVehicle(Long id,Long adminId) {

        Vehicle vehicle = vehicleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        //  Admin decision
        vehicle.setStatus("APPROVED");

        vehicleRepo.save(vehicle);

        return vehicleMapper.toDto(vehicle);
    }

    @Override
    // reject
    public VehicleDto rejectVehicle(Long id,Long adminId) {

        Vehicle vehicle = vehicleRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        vehicle.setStatus("REJECTED");

        vehicleRepo.save(vehicle);

        return vehicleMapper.toDto(vehicle);
    }
}