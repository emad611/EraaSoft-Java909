package com.spring.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class EmailSummaryDTO {
    private Long id;
    private String name;
    private String content;
}
