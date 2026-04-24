package com.spring.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    @Size(min = 8, message = "name must be more than 7 characters")
    @NotBlank(message = "name not null and unique")
    private String userName;
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).+$",
            message = "password must contain upper, lower, number and special character"
    )
    private String password;
    @Min(value = 18, message = "age must be 18 or more")
    private Integer age;

}
