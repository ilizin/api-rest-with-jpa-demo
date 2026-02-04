package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="car")
public class Car extends Vehicle {

    @Column(name="bodyType")
    private String bodyType;

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
}
