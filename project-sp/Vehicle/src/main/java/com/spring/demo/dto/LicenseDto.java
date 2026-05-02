package com.spring.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class LicenseDto {
    private Long id;

    private String licenseNumber;

    private LocalDate issueDate;

    private LocalDate expiryDate;

    private String status;
    @NotNull(message = "Vehicle ID is required")
    private Long vehicleId;
}
