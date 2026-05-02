package com.spring.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// put/ post return just ids//delete too
public class VehicleDto {
    private Long id;
    @NotBlank(message = "Plate number is required")
    private String plateNumber;
    @NotNull(message = "User is required")
    private Long userId;
    @NotNull(message = "License is required")
    private Long licenseId;
}
