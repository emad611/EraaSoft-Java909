package com.spring.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeWithEmailsDTO {
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private float salary;
private List<EmailSummaryDTO> emailSummaryDTOList;

}
