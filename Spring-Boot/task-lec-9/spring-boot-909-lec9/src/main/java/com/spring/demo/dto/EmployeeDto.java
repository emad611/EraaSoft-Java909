package com.spring.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;
import org.aspectj.bridge.Message;

@Getter
@Setter
public class EmployeeDto {
   @NonNull
    private Long id;
   @Size(min = 3,max=50,message = "name between 3-50")
    private String name;
   @Min(value = 18,message = "must be at least 18")
   @Max(value = 100,message = "must not be at  more 100")
    private Integer age;
    @NotBlank(message = "requeired address")
    private String address;
    @DecimalMin(value = "3000",message = "less 3000 not allowed")
    private float salary;

}
