    package com.spring.demo.dto;

    import lombok.Getter;
    import lombok.Setter;

    import java.util.List;

    @Getter
    @Setter
    //Get
    public class VehicleDetailsDto {
        private Long id;
        private String plateNumber;
        private String model;
        private String brand;
        private Integer year;
        private String status;
        private String color;

        private UserDto user;
        private LicenseDto license;

        private List<InspectionDto> inspections;
        private List<FineDto> fines;
    }
