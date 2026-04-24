package com.spring.demo.dao;

import com.spring.demo.model.PostModel;
import com.spring.demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostModel,Long> {
}
