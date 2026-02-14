package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyTypeMotorcycle;

public class MotorcycleInDto extends VehicleInDto {

    //@Schema(description = "The motorcycle body type", allowableValues = {"SUPERSPORT"}, example = "SUPERSPORT")
    @NotBlank
    private BodyTypeMotorcycle bodyType;

    public BodyTypeMotorcycle getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyTypeMotorcycle bodyType) {
        this.bodyType = bodyType;
    }
}
