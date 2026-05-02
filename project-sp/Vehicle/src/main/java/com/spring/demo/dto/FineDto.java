package com.spring.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class FineDto {
    private Long id;
    @NotNull
    @Positive
    private Double amount;
    @NotBlank
    private String reason;

    private LocalDateTime date;

    private String status;
    @NotNull(message = "Vehicle ID is required")
    private Long vehicleId;
}
