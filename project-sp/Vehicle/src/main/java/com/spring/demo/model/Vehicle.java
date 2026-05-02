package com.spring.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plateNumber;

    private String model;

    private String brand;

    private Integer year;

    private String status; // ACTIVE / SUSPENDED / EXPIRED

    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "vehicle")
    private License license;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<Inspection> inspections;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<Fine> fines;
}
