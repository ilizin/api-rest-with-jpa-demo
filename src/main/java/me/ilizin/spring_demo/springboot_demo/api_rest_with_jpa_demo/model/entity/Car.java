package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity;

import jakarta.persistence.*;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;

@Entity
@Table(name="car")
public class Car {

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

    @Column(name="bodyType")
    private BodyType bodyType;

    @Column(name="price")
    private int price;

    @Column(name="mileage")
    private int mileage;

    @Column(name="fuelType")
    private FuelType fuelType;

    @Column(name="gearBox")
    private GearBox gearBox;

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

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
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

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public GearBox getGearBox() {
        return gearBox;
    }

    public void setGearBox(GearBox gearBox) {
        this.gearBox = gearBox;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
