package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;

public class CarInDto {

    @Schema(description = "The car make", example = "Ferrari")
    @NotBlank
    private String make;

    @Schema(description = "The car model", example = "Testarossa")
    @NotBlank
    private String model;

    @Schema(description = "The date of first registration", example = "1984")
    @NotBlank
    private int firstRegistrationFrom;

    @Schema(description = "The car body type", allowableValues = {"COMPACT", "SUV", "TRANSPORTER", "CONVERTIBLE", "VAN", "SEDAN", "STATION_WAGON", "COUPE"}, example = "COUPE")
    @NotBlank
    private BodyType bodyType;

    @Schema(description = "The car price", example = "250000")
    @NotBlank
    private int price;

    @Schema(description = "The total distance a vehicle has traveled", example = "51122")
    @NotBlank
    private int mileage;

    @Schema(description = "The vehicle fuel type", allowableValues = {"GASOLINE", "DIESEL", "ELECTRIC", "HYBRID", "ALTERNATIVE_FUEL"}, example = "GASOLINE")
    @NotBlank
    private FuelType fuelType;

    @Schema(description = "The vehicle gearbox", allowableValues = {"MANUAL", "AUTOMATIC"}, example = "MANUAL")
    @NotBlank
    private GearBox gearBox;

    @Schema(description = "The vehicle power in horsepower", example = "380")
    @NotBlank
    private int power;

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
