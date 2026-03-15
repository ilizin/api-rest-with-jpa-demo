package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;

import java.util.Objects;

public class VehicleInDto {

    @NotBlank
    private String make;

    @NotBlank
    private String model;

    @NotBlank
    private String subModel;

    @NotBlank
    private int firstRegistrationFrom;

    @NotBlank
    private int price;

    @NotBlank
    private int mileage;

    @NotBlank
    private FuelType fuelType;

    @NotBlank
    private GearBox gearBox;

    @NotBlank
    private int power;

    public VehicleInDto() {}
    
    public VehicleInDto(String make, String model, String subModel, int firstRegistrationFrom, int price, int mileage,
                        FuelType fuelType, GearBox gearBox, int power) {
        this.make = make;
        this.model = model;
        this.subModel = subModel;
        this.firstRegistrationFrom = firstRegistrationFrom;
        this.price = price;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.gearBox = gearBox;
        this.power = power;
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

    public void setModel(String subModel) {
        this.subModel = subModel;
    }

    public String getSubModel() {
        return subModel;
    }

    public void setSubModel(String subModel) {
        this.subModel = subModel;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VehicleInDto that = (VehicleInDto) o;
        return firstRegistrationFrom == that.firstRegistrationFrom && price == that.price && mileage == that.mileage && power == that.power && Objects.equals(make, that.make) && Objects.equals(model, that.model) && fuelType == that.fuelType && gearBox == that.gearBox;
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, firstRegistrationFrom, price, mileage, fuelType, gearBox, power);
    }
}
