package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.MotorcycleInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.MotorcycleOutDto;

import java.util.List;

public class MotorcycleService implements IMotorcycleService {

    @Override
    public List<MotorcycleOutDto> findAll() {
        return List.of();
    }

    @Override
    public MotorcycleOutDto findById(int id) {
        return null;
    }

    @Override
    public MotorcycleOutDto save(MotorcycleInDto motorcycleInDto) {
        return null;
    }

    @Override
    public MotorcycleOutDto update(MotorcycleInDto motorcycleInDto, int carId) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
