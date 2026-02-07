package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.data.dao.ICarDao;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        carOutDto.setBodyType(BodyType.valueOf(car.getBodyType()));
        carOutDto.setMileage(car.getMileage());
        carOutDto.setFuelType(FuelType.valueOf(car.getFuelType()));
        carOutDto.setFirstRegistrationFrom(car.getFirstRegistrationFrom());
        carOutDto.setGearBox(GearBox.valueOf(car.getGearBox()));
        carOutDto.setModel(car.getModel());
        carOutDto.setPower(car.getPower());
        carOutDto.setPrice(car.getPrice());
        return carOutDto;
    }
    private Car mapCarInDtoToCar(CarInDto carInDto) {
        Car car = new Car();
        car.setMake(carInDto.getMake());
        car.setBodyType(carInDto.getBodyType().toString());
        car.setMileage(carInDto.getMileage());
        car.setFuelType(carInDto.getFuelType().toString());
        car.setFirstRegistrationFrom(carInDto.getFirstRegistrationFrom());
        car.setGearBox(carInDto.getGearBox().toString());
        car.setModel(carInDto.getModel());
        car.setPower(carInDto.getPower());
        car.setPrice(carInDto.getPrice());
        return car;
    }
}
