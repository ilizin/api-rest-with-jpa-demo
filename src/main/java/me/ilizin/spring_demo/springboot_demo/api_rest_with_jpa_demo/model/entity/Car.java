package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;

@Entity
@Table(name="car")
public class Car {
    private String make;
    private String model;
    private int firstRegistrationFrom;
    private BodyType bodyType;
    private int price;
    private int mileage;
    private FuelType fuelType;
    private GearBox gearBox;
    private int power;
}
