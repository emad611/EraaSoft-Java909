package com.spring.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FineCreateDto {
        @NotBlank(message = "Reason is required")
        private String reason;

        @NotNull(message = "Amount is required")
        @Positive(message = "Amount must be positive")
        private Double amount;
    }

