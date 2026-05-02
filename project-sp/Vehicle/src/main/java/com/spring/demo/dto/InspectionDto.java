package com.spring.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class InspectionDto {
    private Long id;

    private LocalDate inspectionDate;

    private String result; // PASS / FAIL

    private LocalDate validUntil;

    private String notes;
    @NotNull(message = "Vehicle ID is required")
    private Long vehicleId;

}
