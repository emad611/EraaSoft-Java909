package com.spring.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class usersWithPostDto {
    private Long id;
    private String name;
    private List<PostDto> posts;
}
