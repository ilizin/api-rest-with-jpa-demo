package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.MotorcycleInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.MotorcycleOutDto;

import java.util.List;

public interface IMotorcycleService {

    List<MotorcycleOutDto> findAll();

    MotorcycleOutDto findById(int id);

    MotorcycleOutDto save(MotorcycleInDto motorcycleInDto);

    MotorcycleOutDto update(MotorcycleInDto motorcycleInDto, int carId);

    void deleteById(int id);
}
