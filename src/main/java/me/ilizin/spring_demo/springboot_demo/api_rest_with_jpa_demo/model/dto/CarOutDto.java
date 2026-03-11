package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;

public class CarOutDto extends CarInDto {

    @NotBlank
    private int id;

    public CarOutDto() {
        super();
    }

    public CarOutDto(String make, String model, int firstRegistrationFrom, int price, int mileage, FuelType fuelType,
                     GearBox gearBox, int power, BodyType bodyType, int id) {
        super(make, model, firstRegistrationFrom, price, mileage, fuelType, gearBox, power, bodyType);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
