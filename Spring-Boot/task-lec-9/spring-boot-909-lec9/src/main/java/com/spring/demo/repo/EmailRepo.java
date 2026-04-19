package com.spring.demo.repo;

import com.spring.demo.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmailRepo extends JpaRepository<EmailModel,Long> {
    EmailModel findEmailModelByName(String name);
    @Query("SELECT e FROM EmailModel e WHERE e.name IN :names")
    List<EmailModel> findEmailModelByNames(@Param("names") List<String> names);
    EmailModel findEmailModelByContent(String content);
}
