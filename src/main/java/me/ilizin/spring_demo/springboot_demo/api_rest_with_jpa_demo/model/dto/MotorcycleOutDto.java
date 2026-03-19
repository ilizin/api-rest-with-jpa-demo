package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyTypeMotorcycle;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;

public class MotorcycleOutDto extends MotorcycleInDto {

    @NotBlank
    private int id;

    public MotorcycleOutDto() {}

    public MotorcycleOutDto(MotorcycleInDto motorcycleInDto, int id) {

        this(motorcycleInDto.getMake(), motorcycleInDto.getModel(), motorcycleInDto.getSubModel(), motorcycleInDto.getFirstRegistrationFrom(),
                motorcycleInDto.getPrice(), motorcycleInDto.getMileage(), motorcycleInDto.getFuelType(), motorcycleInDto.getGearBox(),
                motorcycleInDto.getPower(), motorcycleInDto.getBodyType(), id);
    }
    public MotorcycleOutDto(String make, String model, String subModel, int firstRegistrationFrom, int price,
                            int mileage, FuelType fuelType, GearBox gearBox, int power, BodyTypeMotorcycle bodyType, int id) {
        super(make, model, subModel, firstRegistrationFrom, price, mileage, fuelType, gearBox, power, bodyType);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
