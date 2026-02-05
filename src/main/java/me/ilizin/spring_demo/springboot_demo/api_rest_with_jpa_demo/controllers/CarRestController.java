package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions.CarNotFoundException;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions.ErrorResponse;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services.ICarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Car controller")
@RequestMapping("/api/v1")
public class CarRestController {

    private final ICarService carService;

    public CarRestController(ICarService carService) {
        this.carService = carService;
    }

    @Operation(summary = "Get all the cars")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved some data")
    })
    @GetMapping("/cars")
    public List<CarOutDto> findAll() {
        return carService.findAll();
    }

    @Operation(summary = "Find a car by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved some data"),
            @ApiResponse(responseCode = "404", description = "Car not found", content =
                    { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class),
                            examples = { @ExampleObject(value = "{\"status\": 404, \"message\":\"Car with id '1981'not found\"}")})
                    })
    })
    @GetMapping("/car/{carId}")
    public CarOutDto getCar(@Parameter(description = "The car identifier", example = "1981")
                                          @PathVariable int carId) throws CarNotFoundException {
        CarOutDto carOutDto = carService.findById(carId);
        if (carOutDto == null) {
            throw new CarNotFoundException("Car with id '" + carId + "'not found");
        }
        return carOutDto;
    }

    @Operation(summary = "Add a new car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added a new car")
    })
    @PostMapping("/car")
    public CarOutDto addCar(@RequestBody CarInDto carInDto) {
        // Just in case they pass an id in JSON, set the id to 0, to force a save of new item instead of update.
        //advertiserDto.setId(0);
        return carService.save(carInDto);
    }

    @Operation(summary = "Update an existing car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated an existing car"),
            @ApiResponse(responseCode = "404", description = "Car not found", content =
                    { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class),
                            examples = { @ExampleObject(value = "{\"status\": 404, \"message\":\"Car with id '1981' not found\"}")})
                    })
    })
    @PutMapping("/car/{carId}")
    public CarOutDto updateCar(@Parameter(description = "The car identifier", example = "1981")
                                             @PathVariable int carId, @RequestBody CarInDto carInDto)
            throws CarNotFoundException {

        CarOutDto carOutDto = carService.findById(carId);
        if (carOutDto == null) {
            throw new CarNotFoundException("Car with id '" + carId + "'not found");
        }
        return carService.update(carInDto, carId);
    }

    @Operation(summary = "Delete an existing car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted an existing car"),
            @ApiResponse(responseCode = "404", description = "Car not found", content =
                    { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class),
                            examples = { @ExampleObject(value = "{\"status\": 404, \"message\":\"Car with id '1981'not found\"}")})
                    })
    })
    @DeleteMapping("/car/{carId}")
    public void deleteCar(@Parameter(description = "The car identifier", example = "1981")
                                 @PathVariable int carId) throws CarNotFoundException {
        CarOutDto carOutDto = carService.findById(carId);
        if (carOutDto == null) {
            throw new CarNotFoundException("Car with id '" + carId + "'not found");
        }
        carService.deleteById(carId);
    }
}
