package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.utilities.Range;

public class FlatmatesAgeRangeDto extends Range<Integer> {

    public FlatmatesAgeRangeDto(Integer min, Integer max) {
        super(min, max);
    }
}
