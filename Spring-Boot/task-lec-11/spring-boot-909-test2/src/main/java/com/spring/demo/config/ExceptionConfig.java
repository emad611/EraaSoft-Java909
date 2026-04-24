package com.spring.demo.config;

import com.spring.demo.help.ErrorMessage;
import com.spring.demo.help.InputErrorMessage;
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
    public ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException ex) {

        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage());

        return ResponseEntity
                .badRequest()
                .body(errorMessage);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<InputErrorMessage>> handleValidationException(
            MethodArgumentNotValidException ex) {

        List<InputErrorMessage> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(this::mapFieldError)
                .collect(Collectors.toList());

        return ResponseEntity
                .badRequest()
                .body(errors);
    }

    // 🔧 helper method (clean code)
    private InputErrorMessage mapFieldError(FieldError error) {
        return new InputErrorMessage(
                error.getField(),
                error.getDefaultMessage()
        );
    }
}