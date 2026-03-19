package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;

import java.util.Objects;

public class CarOutDto extends CarInDto {

    @NotBlank
    private int id;

    public CarOutDto() {
        super();
    }

    public CarOutDto(CarInDto carInDto, int id) {

        this(carInDto.getMake(), carInDto.getModel(), carInDto.getSubModel(), carInDto.getFirstRegistrationFrom(),
                carInDto.getPrice(), carInDto.getMileage(), carInDto.getFuelType(), carInDto.getGearBox(),
                carInDto.getPower(), carInDto.getBodyType(), id);
    }

    public CarOutDto(String make, String model, String subModel, int firstRegistrationFrom, int price, int mileage, FuelType fuelType,
                     GearBox gearBox, int power, BodyType bodyType, int id) {
        super(make, model, subModel, firstRegistrationFrom, price, mileage, fuelType, gearBox, power, bodyType);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarOutDto carOutDto = (CarOutDto) o;
        return id == carOutDto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
