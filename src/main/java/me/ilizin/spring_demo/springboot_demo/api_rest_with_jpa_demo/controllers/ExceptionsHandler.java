package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions.CarNotFoundException;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions.ErrorResponse;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions.MotorcycleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(CarNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(MotorcycleNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
