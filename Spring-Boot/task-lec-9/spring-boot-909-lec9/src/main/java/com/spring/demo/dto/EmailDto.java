package com.spring.demo.dto;

import com.spring.demo.model.Employee;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class EmailDto {
   @NonNull
    private Long id;
    @NotBlank(message = "email type is required")
    private String name;
   @Email
    private String content;
    private Long employeeId;



}
