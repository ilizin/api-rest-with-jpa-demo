package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions.CarNotFoundException;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions.MotorcycleNotFoundException;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> handleException(CarNotFoundException exception) {
        ErrorResponseDto errorResponse = new ErrorResponseDto();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> handleException(MotorcycleNotFoundException exception) {
        ErrorResponseDto errorResponse = new ErrorResponseDto();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
