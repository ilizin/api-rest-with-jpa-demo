package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exceptions.MotorcycleNotFoundException;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.MotorcycleInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.MotorcycleOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services.IMotorcycleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Tag(name = "Motorcycle controller")
@RequestMapping("/api/v1")
public class MotorcycleRestController {

    private final IMotorcycleService motorcycleService;

    public MotorcycleRestController(IMotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    /*@Operation(summary = "Get all the motorcycles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved some data")
    })*/
    @GetMapping("/motorcycles")
    public List<MotorcycleOutDto> findAll() {
        return motorcycleService.findAll();
    }

    /*@Operation(summary = "Find a motorcycle by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved some data"),
            @ApiResponse(responseCode = "404", description = "Motorcycle not found", content =
                    { @Content(mediaType = "application/json", schema = @Schema(implementation = MotorcycleNotFoundException.ErrorResponse.class),
                            examples = { @ExampleObject(value = "{\"status\": 404, \"message\":\"Motorcycle with id '1981'not found\"}")})
                    })
    })*/
    @GetMapping("/motorcycle/{motorcycleId}")
    public MotorcycleOutDto getMotorcycle(@Parameter(description = "The motorcycle identifier", example = "1981")
                            @PathVariable int motorcycleId) throws MotorcycleNotFoundException {
        MotorcycleOutDto motorcycleOutDto = motorcycleService.findById(motorcycleId);
        if (motorcycleOutDto == null) {
            throw new MotorcycleNotFoundException("Motorcycle with id '" + motorcycleId + "'not found");
        }
        return motorcycleOutDto;
    }

    /*@Operation(summary = "Add a new motorcycle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added a new motorcycle")
    })*/
    @PostMapping("/motorcycle")
    public MotorcycleOutDto addMotorcycle(@RequestBody MotorcycleInDto motorcycleInDto) {
        // Just in case they pass an id in JSON, set the id to 0, to force a save of new item instead of update.
        //advertiserDto.setId(0);
        return motorcycleService.save(motorcycleInDto);
    }

    /*@Operation(summary = "Update an existing motorcycle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated an existing motorcycle"),
            @ApiResponse(responseCode = "404", description = "Motorcycle not found", content =
                    { @Content(mediaType = "application/json", schema = @Schema(implementation = MotorcycleNotFoundException.ErrorResponse.class),
                            examples = { @ExampleObject(value = "{\"status\": 404, \"message\":\"Motorcycle with id '1981' not found\"}")})
                    })
    })*/
    @PutMapping("/motorcycle/{motorcycleId}")
    public MotorcycleOutDto updateMotorcycle(@Parameter(description = "The motorcycle identifier", example = "1981")
                               @PathVariable int motorcycleId, @RequestBody MotorcycleInDto motorcycleInDto)
            throws MotorcycleNotFoundException {

        MotorcycleOutDto motorcycleOutDto = motorcycleService.findById(motorcycleId);
        if (motorcycleOutDto == null) {
            throw new MotorcycleNotFoundException("Motorcycle with id '" + motorcycleId + "'not found");
        }
        return motorcycleService.update(motorcycleInDto, motorcycleId);
    }

    /*@Operation(summary = "Delete an existing motorcycle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted an existing motorcycle"),
            @ApiResponse(responseCode = "404", description = "motorcycle not found", content =
                    { @Content(mediaType = "application/json", schema = @Schema(implementation = MotorcycleNotFoundException.ErrorResponse.class),
                            examples = { @ExampleObject(value = "{\"status\": 404, \"message\":\"Motorcycle with id '1981'not found\"}")})
                    })
    })*/
    @DeleteMapping("/motorcycle/{motorcycleId}")
    public void deleteMotorcycle(@Parameter(description = "The motorcycleId identifier", example = "1981")
                          @PathVariable int motorcycleId) throws MotorcycleNotFoundException {
        MotorcycleOutDto motorcycleOutDto = motorcycleService.findById(motorcycleId);
        if (motorcycleOutDto == null) {
            throw new MotorcycleNotFoundException("Motorcycle with id '" + motorcycleId + "'not found");
        }
        motorcycleService.deleteById(motorcycleId);
    }
}
