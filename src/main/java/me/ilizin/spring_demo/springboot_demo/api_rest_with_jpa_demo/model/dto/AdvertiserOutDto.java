package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class AdvertiserOutDto extends AdvertiserInDto {

    @Schema(description = "The advertiser identifier", example = "1981")
    @NotBlank
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
