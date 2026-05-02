package com.spring.demo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class UserDto {
    private Long id;
    @NotBlank (message = "error.invalid.username")
    @Column(unique = true, nullable = false)
    private String name;
    @Email(message = "must be contain email")
    private String email;
    private String password;
    @NotBlank(message = "must be contain phone")
    @Column(unique = true, nullable = false)
    private String phone;

    private String address;

    private String role; // ADMIN / USER

    private List<VehicleSummaryDto> vehicles;
}
