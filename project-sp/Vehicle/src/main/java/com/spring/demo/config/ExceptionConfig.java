package com.spring.demo.config;

import com.spring.demo.Service.helper.BundleMessageService;
import com.spring.demo.helpers.ErrorMessage;
import com.spring.demo.helpers.InputErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage>handleRuntimeException(RuntimeException exception){
        ErrorMessage errorMessage=new ErrorMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(errorMessage);
    }
    @ExceptionHandler(MethodArgumentNotValidException .class)
    public ResponseEntity<List<InputErrorMessage>>handleMethodArgumentException(MethodArgumentNotValidException exception){
        List<FieldError>fieldErrors=  exception.getBindingResult().getFieldErrors();
        List<InputErrorMessage>messages=fieldErrors.stream().
                map(fieldError ->
                        new InputErrorMessage(fieldError.getField(),
                                BundleMessageService.getMessage(fieldError.getDefaultMessage()))).
                collect(Collectors.toList());
        return ResponseEntity.badRequest().body(messages);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String>handleThrowableException(Throwable throwable){
        return ResponseEntity.badRequest().body(throwable.getMessage());
    }
}
