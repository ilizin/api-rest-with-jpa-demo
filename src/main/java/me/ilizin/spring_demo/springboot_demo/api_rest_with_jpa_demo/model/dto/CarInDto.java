package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;

import java.util.Objects;

public class CarInDto extends VehicleInDto {

    @NotBlank
    private BodyType bodyType;

    public CarInDto() {}

    public CarInDto(String make, String model, String subModel, int firstRegistrationFrom, int price, int mileage, FuelType fuelType,
                    GearBox gearBox, int power, BodyType bodyType) {
        super(make, model, subModel, firstRegistrationFrom, price, mileage, fuelType, gearBox, power);
        this.bodyType = bodyType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarInDto carInDto = (CarInDto) o;
        return bodyType == carInDto.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyType);
    }
}
