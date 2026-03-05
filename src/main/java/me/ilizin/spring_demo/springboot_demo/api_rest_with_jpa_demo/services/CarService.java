package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.data.dao.ICarDao;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity.Vehicle;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService implements ICarService {

    private final ICarDao carDao;

    public CarService(ICarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<CarOutDto> findAll() {
        List<Vehicle> cars = carDao.findAll();
        return cars
                .stream()
                .map(this::mapCarToCarOutDto)
                .toList();
    }

    @Override
    public CarOutDto findById(int id) {
        Vehicle car = carDao.findById(id);
        if (car == null) {
            return null;
        }
        return mapCarToCarOutDto(car);
    }

    @Transactional
    @Override
    public CarOutDto save(CarInDto carInDto) {
        Vehicle car = mapCarInDtoToCar(carInDto);
        Vehicle savedCar = carDao.save(car);
        return mapCarToCarOutDto(savedCar);
    }

    @Transactional
    @Override
    public CarOutDto update(CarInDto carInDto, int carId) {
        Vehicle car = mapCarInDtoToCar(carInDto);
        car.setId(carId);
        Vehicle savedCar = carDao.save(car);
        return mapCarToCarOutDto(savedCar);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    private CarOutDto mapCarToCarOutDto(Vehicle car) {
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
    private Vehicle mapCarInDtoToCar(CarInDto carInDto) {
        Vehicle car = new Vehicle();
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
