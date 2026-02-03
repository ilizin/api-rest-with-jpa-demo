package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions.AdvertiserNotFoundException;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(AdvertiserNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
