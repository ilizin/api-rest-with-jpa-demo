package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao.AdvertisementDao;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao.ICarDao;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.AdvertiserType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.AdvertiserInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.AdvertiserOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity.Advertiser;
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
                .map(this::mapCarToCarDto)
                .toList();
    }

    @Override
    public CarOutDto findById(int id) {
        Car car = carDao.findById(id);
        if (car == null) {
            return null;
        }
        return mapCarToCarDto(car);
    }

    @Override
    public CarOutDto save(CarInDto carInDto) {
        Car car = mapCarDtoToCar(carInDto);
        Car savedCar = carDao.save(car);
        return mapCarToCarDto(savedCar);
    }

    @Override
    public CarOutDto update(CarInDto carInDto, int carId) {
        Car car = mapCarDtoToCar(carInDto);
        car.setId(carId);
        Car savedCar = carDao.save(car);
        return mapCarToCarDto(savedCar);
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    private CarOutDto mapCarToCarDto(Car car) {
        CarOutDto carOutDto = new CarOutDto();
        return carOutDto;
    }

    private Car mapCarDtoToCar(CarInDto carInDto) {
        Car car = new Car();
        return car;
    }
}
