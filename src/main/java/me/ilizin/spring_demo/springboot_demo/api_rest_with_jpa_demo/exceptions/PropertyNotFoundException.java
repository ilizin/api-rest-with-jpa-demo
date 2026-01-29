package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions;

public class PropertyNotFoundException extends Exception {
    public PropertyNotFoundException() {
    }

    public PropertyNotFoundException(String message) {
        super(message);
    }
}
