package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;

public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="make")
    private String make;

    @Column(name="model")
    private String model;

    @Column(name="firstRegistrationFrom")
    private int firstRegistrationFrom;

    @Column(name="price")
    private int price;

    @Column(name="mileage")
    private int mileage;

    @Column(name="fuelType")
    private String fuelType;

    @Column(name="gearBox")
    private String gearBox;

    @Column(name="power")
    private int power;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getFirstRegistrationFrom() {
        return firstRegistrationFrom;
    }

    public void setFirstRegistrationFrom(int firstRegistrationFrom) {
        this.firstRegistrationFrom = firstRegistrationFrom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
