package com.spring.demo.service.Impl;

import com.spring.demo.dto.EmailDto;
import com.spring.demo.model.EmailModel;
import com.spring.demo.model.Employee;
import com.spring.demo.repo.EmailRepo;
import com.spring.demo.repo.EmployeeRepo;
import com.spring.demo.service.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailServiceImpl implements EmailService {

    private final EmailRepo emailRepo;
    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    public EmailServiceImpl(EmailRepo emailRepo, EmployeeRepo employeeRepo, ModelMapper modelMapper) {
        this.emailRepo = emailRepo;
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmailDto createEmail(EmailDto emailDto) {

        Employee employee = employeeRepo.findById(emailDto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + emailDto.getEmployeeId()));

        EmailModel emailModel = modelMapper.map(emailDto, EmailModel.class);
        emailModel.setEmployee(employee);

        EmailModel saved = emailRepo.save(emailModel);
        return modelMapper.map(saved, EmailDto.class);
    }

    @Override
    public EmailDto updateEmail(Long id, EmailDto emailDto) {

        EmailModel existingEmail = emailRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Email not found with id: " + id));

        existingEmail.setName(emailDto.getName());
        existingEmail.setContent(emailDto.getContent());

        if (emailDto.getEmployeeId() != null) {
            Employee employee = employeeRepo.findById(emailDto.getEmployeeId())
                    .orElseThrow(() -> new RuntimeException("Employee not found with id: " + emailDto.getEmployeeId()));
            existingEmail.setEmployee(employee);
        }

        EmailModel updated = emailRepo.save(existingEmail);
        return modelMapper.map(updated, EmailDto.class);
    }

    @Override
    public void removeEmail(Long id) {
        emailRepo.deleteById(id);
    }

    @Override
    public List<EmailDto> getEmails() {
        List<EmailModel> emailModels = emailRepo.findAll();
        return emailModels.stream()
                .map(emailModel -> modelMapper.map(emailModel, EmailDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmailDto getEmailByName(String name) {
        EmailModel emailModel = emailRepo.findEmailModelByName(name);
        if (emailModel == null) {
            throw new RuntimeException("Email not found with name: " + name);
        }
        return modelMapper.map(emailModel, EmailDto.class);
    }

    @Override
    public List<EmailDto> getEmailsByNames(List<String> names) {
        List<EmailModel> emailModels = emailRepo.findEmailModelByNames(names);
        return emailModels.stream()
                .map(emailModel -> modelMapper.map(emailModel, EmailDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmailDto getEmailByContent(String content) {
        EmailModel emailModel = emailRepo.findEmailModelByContent(content);
        if (emailModel == null) {
            throw new RuntimeException("Email not found with content: " + content);
        }
        return modelMapper.map(emailModel, EmailDto.class);
    }
}