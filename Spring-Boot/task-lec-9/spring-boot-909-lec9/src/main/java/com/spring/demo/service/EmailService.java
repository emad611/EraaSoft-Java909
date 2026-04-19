package com.spring.demo.service;

import com.spring.demo.dto.EmailDto;
import com.spring.demo.model.EmailModel;

import java.util.List;

public interface EmailService {
    EmailDto createEmail(EmailDto emailDto);
    EmailDto updateEmail(Long id,EmailDto emailDto);
    void removeEmail(Long id);
    List<EmailDto> getEmails();
    EmailDto getEmailByName(String name);
    List<EmailDto>getEmailsByNames(List<String>names);
    EmailDto getEmailByContent(String content);

}
