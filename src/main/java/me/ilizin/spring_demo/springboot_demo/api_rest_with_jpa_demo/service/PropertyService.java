package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.PropertyInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.PropertyOutDto;

import java.util.List;

public interface PropertyService {

    List<PropertyOutDto> findAll();

    PropertyOutDto findById(int id);

    PropertyOutDto save(PropertyInDto property);

    PropertyOutDto update(PropertyInDto property, int advertisementId);

    void deleteById(int id);
}
