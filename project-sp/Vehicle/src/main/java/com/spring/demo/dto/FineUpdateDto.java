package com.spring.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FineUpdateDto {
    private String reason;
    private Double amount;
    private String status;
}
