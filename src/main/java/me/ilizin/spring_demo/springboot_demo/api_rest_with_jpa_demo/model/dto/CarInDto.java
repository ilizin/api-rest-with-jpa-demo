package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyType;

public class CarInDto extends VehicleInDto {

    //@Schema(description = "The car body type", allowableValues = {"COMPACT", "SUV", "TRANSPORTER", "CONVERTIBLE", "VAN", "SEDAN", "STATION_WAGON", "COUPE"}, example = "COUPE")
    @NotBlank
    private BodyType bodyType;

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }
}
