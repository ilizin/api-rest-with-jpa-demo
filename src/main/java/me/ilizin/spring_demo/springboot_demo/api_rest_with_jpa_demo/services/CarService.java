package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarOutDto;

import java.util.List;

public class CarService implements ICarService {

    @Override
    public List<CarOutDto> findAll() {
        return List.of();
    }

    @Override
    public CarOutDto findById(int id) {
        return null;
    }

    @Override
    public CarOutDto save(CarInDto carInDto) {
        return null;
    }

    @Override
    public CarOutDto update(CarInDto carInDto, int carId) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
