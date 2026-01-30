package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao.AdvertisementDao;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao.ICarDao;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity.Car;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity.Property;

import java.util.List;

public class CarService implements ICarService {

    private final ICarDao carDao;

    public CarService(ICarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<CarOutDto> findAll() {
        List<Car> cars = carDao.findAll();
        return cars
                .stream()
                .map(this::mapAdvertisementToAdvertisementResultDto)
                .toList();
    }

    @Override
    public CarOutDto findById(int id) {
        Car car = carDao.findById(id);
        if (car == null) {
            return null;
        }
        return mapAdvertisementToAdvertisementResultDto(car);
    }

    @Override
    public CarOutDto save(CarInDto carInDto) {
        Car car = mapAdvertisementDtoToAdvertisement(carInDto);
        Car savedCar = advertisementDao.save(car);
        return mapAdvertisementToAdvertisementResultDto(savedCar);
    }

    @Override
    public CarOutDto update(CarInDto carInDto, int carId) {
        Car car = mapAdvertisementDtoToAdvertisement(carInDto);
        car.setId(carId);
        Car savedCar = carDao.save(car);
        return mapAdvertisementToAdvertisementResultDto(savedCar);
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }
}
