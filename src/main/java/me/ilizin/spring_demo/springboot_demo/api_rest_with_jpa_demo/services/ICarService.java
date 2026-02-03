package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarOutDto;

import java.util.List;

public interface ICarService {

    List<CarOutDto> findAll();

    CarOutDto findById(int id);

    CarOutDto save(CarInDto carInDto);

    CarOutDto update(CarInDto carInDto, int carId);

    void deleteById(int id);
}
