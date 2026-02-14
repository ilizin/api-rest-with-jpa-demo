package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;

public class MotorcycleNotFoundException extends Exception {

    public MotorcycleNotFoundException() {
    }

    public MotorcycleNotFoundException(String message) {
        super(message);
    }
}
