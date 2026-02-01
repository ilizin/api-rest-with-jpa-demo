package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions;

public class CarNotFoundException extends Exception {

    public CarNotFoundException() {
    }

    public CarNotFoundException(String message) {
        super(message);
    }
}
