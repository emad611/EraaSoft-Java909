    package com.spring.demo.model;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

    import java.time.LocalDateTime;

    @Entity
    @Getter
    @Setter
    public class Fine {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Double amount;

        private String reason;
    @Column(name = "fine_date")
        private LocalDateTime date;

        private String status; // PAID / UNPAID

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "vehicle_id")
        private Vehicle vehicle;
    }
