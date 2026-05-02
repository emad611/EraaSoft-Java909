package com.spring.demo.dao;

import com.spring.demo.model.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepo extends JpaRepository<Fine,Long> {
}
