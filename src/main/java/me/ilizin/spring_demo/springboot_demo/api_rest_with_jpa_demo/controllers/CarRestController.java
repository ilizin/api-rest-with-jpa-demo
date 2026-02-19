package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions.CarNotFoundException;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services.ICarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarRestController {

    private final ICarService carService;

    public CarRestController(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<CarOutDto> findAll() {
        return carService.findAll();
    }

    @GetMapping("/car/{carId}")
    public CarOutDto getCar(@PathVariable int carId) throws CarNotFoundException {
        CarOutDto carOutDto = carService.findById(carId);
        if (carOutDto == null) {
            throw new CarNotFoundException("Car with id '" + carId + "'not found");
        }
        return carOutDto;
    }

    @PostMapping("/car")
    public CarOutDto addCar(@RequestBody CarInDto carInDto) {
        // Just in case they pass an id in JSON, set the id to 0, to force a save of new item instead of update.
        //advertiserDto.setId(0);
        return carService.save(carInDto);
    }

    @PutMapping("/car/{carId}")
    public CarOutDto updateCar(@PathVariable int carId, @RequestBody CarInDto carInDto)
            throws CarNotFoundException {

        CarOutDto carOutDto = carService.findById(carId);
        if (carOutDto == null) {
            throw new CarNotFoundException("Car with id '" + carId + "'not found");
        }
        return carService.update(carInDto, carId);
    }

    @DeleteMapping("/car/{carId}")
    public void deleteCar(@PathVariable int carId) throws CarNotFoundException {
        CarOutDto carOutDto = carService.findById(carId);
        if (carOutDto == null) {
            throw new CarNotFoundException("Car with id '" + carId + "'not found");
        }
        carService.deleteById(carId);
    }
}
