package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyTypeMotorcycle;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;

public class MotorcycleInDto extends VehicleInDto {

    @NotBlank
    private BodyTypeMotorcycle bodyType;

    public MotorcycleInDto() {}

    public MotorcycleInDto(String make, String model, int firstRegistrationFrom, int price, int mileage, FuelType fuelType,
                           GearBox gearBox, int power, BodyTypeMotorcycle bodyType) {
        super(make, model, firstRegistrationFrom, price, mileage, fuelType, gearBox, power);
        this.bodyType = bodyType;
    }

    public BodyTypeMotorcycle getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyTypeMotorcycle bodyType) {
        this.bodyType = bodyType;
    }
}
