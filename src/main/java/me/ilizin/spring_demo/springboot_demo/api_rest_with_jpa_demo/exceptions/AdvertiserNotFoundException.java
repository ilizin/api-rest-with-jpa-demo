package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions;

public class AdvertiserNotFoundException extends Exception {

    public AdvertiserNotFoundException() {
    }

    public AdvertiserNotFoundException(String message) {
        super(message);
    }
}
