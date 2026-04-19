package com.spring.demo.controller;

import com.spring.demo.dto.EmailDto;
import com.spring.demo.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {
private EmailService emailService;
@Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping
    public EmailDto createEmail(@RequestBody @Valid EmailDto emailDto){
    return emailService.createEmail(emailDto);
    }
    @PutMapping("/{id}")
    public EmailDto updateEmail( @PathVariable Long id, @RequestBody @Valid EmailDto emailDto){
        return emailService.updateEmail(id,emailDto);
    }
    @DeleteMapping("/{id}")
    public void removeEmail(@PathVariable Long id){
    emailService.removeEmail(id);
    }
    @GetMapping
    public List<EmailDto> getEmails(){
    return emailService.getEmails();
    }
    @GetMapping("/name/{name}")
    public EmailDto getEmailByName(@PathVariable String name){
    return emailService.getEmailByName(name);
    }
    @GetMapping("/names")
    public List<EmailDto>getEmailsByNames(@RequestParam("names") List<String>names){
    return emailService.getEmailsByNames(names);
    }
    @GetMapping("/content")
    public EmailDto getEmailByContent(@RequestParam("content") String content){
    return emailService.getEmailByContent(content);
    }

}
