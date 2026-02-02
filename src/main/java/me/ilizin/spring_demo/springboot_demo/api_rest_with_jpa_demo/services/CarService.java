package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao.ICarDao;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity.Car;

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
                .map(this::mapCarToCarOutDto)
                .toList();
    }

    @Override
    public CarOutDto findById(int id) {
        Car car = carDao.findById(id);
        if (car == null) {
            return null;
        }
        return mapCarToCarOutDto(car);
    }

    @Override
    public CarOutDto save(CarInDto carInDto) {
        Car car = mapCarInDtoToCar(carInDto);
        Car savedCar = carDao.save(car);
        return mapCarToCarOutDto(savedCar);
    }

    @Override
    public CarOutDto update(CarInDto carInDto, int carId) {
        Car car = mapCarInDtoToCar(carInDto);
        car.setId(carId);
        Car savedCar = carDao.save(car);
        return mapCarToCarOutDto(savedCar);
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    private CarOutDto mapCarToCarOutDto(Car car) {
        CarOutDto carOutDto = new CarOutDto();
        carOutDto.setId(car.getId());
        carOutDto.setMake(car.getMake());
        return carOutDto;
    }
    private Car mapCarInDtoToCar(CarInDto carInDto) {
        Car car = new Car();
        car.setMake(carInDto.getMake());
        return car;
    }
}
