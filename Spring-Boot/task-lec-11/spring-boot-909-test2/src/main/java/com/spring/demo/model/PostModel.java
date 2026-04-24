package com.spring.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String imagePath;
   @ManyToOne
   @JoinColumn(name = "user_model_id")
   private UserModel userModel;
}
