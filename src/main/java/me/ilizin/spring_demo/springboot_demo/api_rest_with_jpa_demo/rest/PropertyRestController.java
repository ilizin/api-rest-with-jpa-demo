package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.PropertyInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.PropertyOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exception.ErrorResponse;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exception.PropertyNotFoundException;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Property controller")
@RequestMapping("/api/v1")
public class PropertyRestController {

    private final PropertyService propertyService;

    public PropertyRestController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @Operation(summary = "Get all the properties")
    @GetMapping("/properties")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieved all the properties"),
    })
    public List<PropertyOutDto> findAll() {
        return propertyService.findAll();
    }

    @Operation(summary = "Find a property by id")
    @GetMapping("/property/{propertyId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieved a property"),
            @ApiResponse(responseCode = "404", description = "Property not found", content =
                            { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class),
                                       examples = { @ExampleObject(value = "{\"status\": 404, \"message\":\"Property not found\"}")})
                            })
    })
    public PropertyOutDto getProperty(@Parameter(description = "The property identifier", example = "1981")
                                      @PathVariable int propertyId) throws PropertyNotFoundException {
        PropertyOutDto propertyOutDto = propertyService.findById(propertyId);
        if (propertyOutDto == null) {
            throw new PropertyNotFoundException("Property with id '" + propertyId + "'not found");
        }
        return propertyOutDto;
    }

    @Operation(summary = "Add a new property")
    @PostMapping("/property")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful added a properties"),
    })
    public PropertyOutDto addProperty(@RequestBody PropertyInDto propertyInDto) {
        // Just in case they pass an id in JSON, set the id to 0, to force a save of new item instead of update.
        // advertisementDto.setId(0); //We don't pass the id from the json
        return propertyService.save(propertyInDto);
    }

    @Operation(summary = "Update an existing property")
    @PutMapping("/property/{propertyId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful updated a property"),
            @ApiResponse(responseCode = "404", description = "Property not found", content =
                    { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class),
                            examples = { @ExampleObject(value = "{\"status\": 404, \"message\":\"Property not found\"}")})
                    })
    })
    public PropertyOutDto updateProperty(@Parameter(description = "The property identifier", example = "1981")
                                         @PathVariable int propertyId, @RequestBody PropertyInDto propertyInDto)
                                        throws PropertyNotFoundException {
        PropertyOutDto propertyOutDto = propertyService.findById(propertyId);
        if (propertyOutDto == null) {
            throw new PropertyNotFoundException("Property with id '" + propertyId + "'not found");
        }
        return propertyService.update(propertyInDto, propertyId);
    }

    @Operation(summary = "Delete an existing property")
    @DeleteMapping("/property/{propertyId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful deleted a property"),
            @ApiResponse(responseCode = "404", description = "Property not found", content =
                    { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class),
                            examples = { @ExampleObject(value = "{\"status\": 404, \"message\":\"Property not found\"}")})
                    })
    })
    public void deleteProperty(@Parameter(description = "The property identifier", example = "1981")
                               @PathVariable int propertyId) throws PropertyNotFoundException {
        PropertyOutDto propertyOutDto = propertyService.findById(propertyId);
        if (propertyOutDto == null) {
            throw new PropertyNotFoundException("Property with id '" + propertyId + "'not found");
        }
        propertyService.deleteById(propertyId);
    }
}
