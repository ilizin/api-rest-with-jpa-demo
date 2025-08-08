package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.utilities.Range;

public class FlatmatesAgeRangeDto {

    @Positive
    @Schema(description = "The minimum age of your flatmates", example = "19")
    private Integer min;
    @Positive
    @Schema(description = "The maximum age of your flatmates", example = "52")
    private Integer max;

    public FlatmatesAgeRangeDto(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "FlatmatesAgeRangeDto{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }

}
