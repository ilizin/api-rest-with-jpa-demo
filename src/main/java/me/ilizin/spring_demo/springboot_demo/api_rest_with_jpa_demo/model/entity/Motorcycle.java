package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity;

import jakarta.persistence.*;

@Table(name="motorcycle")
public class Motorcycle extends Vehicle {

    @Column(name="bodyType")
    private String bodyTypeMotorcycle;

    public String getBodyType() {
        return bodyTypeMotorcycle;
    }

    public void setBodyTypeMotorcycle(String bodyTypeMotorcycle) {
        this.bodyTypeMotorcycle = bodyTypeMotorcycle;
    }
}
