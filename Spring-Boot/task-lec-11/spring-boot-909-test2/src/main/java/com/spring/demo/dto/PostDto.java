package com.spring.demo.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private Long id;
    @NonNull
    @Size(min = 20,message = "size must be at least 20")
    private String text;
    private String imagePath;
    private Long userId;
}
