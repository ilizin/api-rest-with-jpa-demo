package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;

import jakarta.validation.constraints.NotBlank;

public class CarOutDto extends CarInDto {

    @NotBlank
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
