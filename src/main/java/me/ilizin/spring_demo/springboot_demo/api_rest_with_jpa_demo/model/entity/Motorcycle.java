package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="motorcycle")
public class Motorcycle extends Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="bodyType")
    private String bodyTypeMotorcycle;

    public String getBodyType() {
        return bodyTypeMotorcycle;
    }

    public void setBodyTypeMotorcycle(String bodyTypeMotorcycle) {
        this.bodyTypeMotorcycle = bodyTypeMotorcycle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
