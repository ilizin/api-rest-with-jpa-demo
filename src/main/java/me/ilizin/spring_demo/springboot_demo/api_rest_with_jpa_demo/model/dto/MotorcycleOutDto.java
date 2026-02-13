package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class MotorcycleOutDto extends MotorcycleInDto {

    @Schema(description = "The motorcycle identifier", example = "1994")
    @NotBlank
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
