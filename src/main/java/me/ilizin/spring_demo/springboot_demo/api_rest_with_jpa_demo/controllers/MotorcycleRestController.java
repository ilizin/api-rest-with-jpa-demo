package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions.MotorcycleNotFoundException;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.MotorcycleInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.MotorcycleOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services.IMotorcycleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MotorcycleRestController {

    private final IMotorcycleService motorcycleService;

    public MotorcycleRestController(IMotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @GetMapping("/motorcycles")
    public List<MotorcycleOutDto> findAll() {
        return motorcycleService.findAll();
    }

    @GetMapping("/motorcycle/{motorcycleId}")
    public MotorcycleOutDto getMotorcycle(@PathVariable int motorcycleId) throws MotorcycleNotFoundException {
        MotorcycleOutDto motorcycleOutDto = motorcycleService.findById(motorcycleId);
        if (motorcycleOutDto == null) {
            throw new MotorcycleNotFoundException("Motorcycle with id '" + motorcycleId + "'not found");
        }
        return motorcycleOutDto;
    }

    @PostMapping("/motorcycle")
    public MotorcycleOutDto addMotorcycle(@RequestBody MotorcycleInDto motorcycleInDto) {
        // Just in case they pass an id in JSON, set the id to 0, to force a save of new item instead of update.
        //advertiserDto.setId(0);
        return motorcycleService.save(motorcycleInDto);
    }

    @PutMapping("/motorcycle/{motorcycleId}")
    public MotorcycleOutDto updateMotorcycle(@PathVariable int motorcycleId, @RequestBody MotorcycleInDto motorcycleInDto)
            throws MotorcycleNotFoundException {

        MotorcycleOutDto motorcycleOutDto = motorcycleService.findById(motorcycleId);
        if (motorcycleOutDto == null) {
            throw new MotorcycleNotFoundException("Motorcycle with id '" + motorcycleId + "'not found");
        }
        return motorcycleService.update(motorcycleInDto, motorcycleId);
    }

    @DeleteMapping("/motorcycle/{motorcycleId}")
    public void deleteMotorcycle(@PathVariable int motorcycleId) throws MotorcycleNotFoundException {
        MotorcycleOutDto motorcycleOutDto = motorcycleService.findById(motorcycleId);
        if (motorcycleOutDto == null) {
            throw new MotorcycleNotFoundException("Motorcycle with id '" + motorcycleId + "'not found");
        }
        motorcycleService.deleteById(motorcycleId);
    }
}
