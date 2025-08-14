package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.AdvertiserInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.AdvertiserOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.PropertyOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exception.AdvertiserNotFoundException;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exception.ErrorResponse;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exception.PropertyNotFoundException;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service.AdvertiserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Advertiser controller")
@RequestMapping("/api/v1")
public class AdvertiserRestController {

    private final AdvertiserService advertiserService;

    public AdvertiserRestController(AdvertiserService advertiserService) {
        this.advertiserService = advertiserService;
    }

    @Operation(summary = "Get all the advertisers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved some data")
    })
    @GetMapping("/advertisers")
    public List<AdvertiserOutDto> findAll() {
        return advertiserService.findAll();
    }

    @Operation(summary = "Find an advertiser by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved some data"),
            @ApiResponse(responseCode = "404", description = "Advertiser not found", content =
                    { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class),
                            examples = { @ExampleObject(value = "{\"status\": 404, \"message\":\"Advertiser with id '1981'not found\"}")})
                    })
    })
    @GetMapping("/advertiser/{advertiserId}")
    public AdvertiserOutDto getAdvertiser(@Parameter(description = "The advertiser identifier", example = "1981")
                                          @PathVariable int advertiserId) throws AdvertiserNotFoundException {
        AdvertiserOutDto advertiserOutDto = advertiserService.findById(advertiserId);
        if (advertiserOutDto == null) {
            throw new AdvertiserNotFoundException("Advertiser with id '" + advertiserId + "'not found");
        }
        return advertiserOutDto;
    }

    @Operation(summary = "Add a new advertiser")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added a new advertiser")
    })
    @PostMapping("/advertiser")
    public AdvertiserOutDto addAdvertiser(@RequestBody AdvertiserInDto advertiserDto) {
        // Just in case they pass an id in JSON, set the id to 0, to force a save of new item instead of update.
        //advertiserDto.setId(0);
        return advertiserService.save(advertiserDto);
    }

    @Operation(summary = "Update an existing advertiser")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated an existing advertiser"),
            @ApiResponse(responseCode = "404", description = "Advertiser not found", content =
                    { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class),
                            examples = { @ExampleObject(value = "{\"status\": 404, \"message\":\"Advertiser with id '1981'not found\"}")})
                    })
    })
    @PutMapping("/advertiser/{advertiserId}")
    public AdvertiserOutDto updateAdvertiser(@Parameter(description = "The advertiser identifier", example = "1981")
                                             @PathVariable int advertiserId, @RequestBody AdvertiserInDto advertiserDto)
                                                throws AdvertiserNotFoundException {

        AdvertiserOutDto advertiserOutDto = advertiserService.findById(advertiserId);
        if (advertiserOutDto == null) {
            throw new AdvertiserNotFoundException("Advertiser with id '" + advertiserId + "'not found");
        }
        return advertiserService.update(advertiserDto, advertiserId);
    }

    @Operation(summary = "Delete an existing advertiser")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted an existing advertiser"),
            @ApiResponse(responseCode = "404", description = "Advertiser not found", content =
                    { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class),
                            examples = { @ExampleObject(value = "{\"status\": 404, \"message\":\"Advertiser with id '1981'not found\"}")})
                    })
    })
    @DeleteMapping("/advertiser/{advertiserId}")
    public void deleteAdvertiser(@Parameter(description = "The advertiser identifier", example = "1981")
                                 @PathVariable int advertiserId) throws AdvertiserNotFoundException {
        AdvertiserOutDto advertiserDto = advertiserService.findById(advertiserId);
        if (advertiserDto == null) {
            throw new AdvertiserNotFoundException("Advertiser with id '" + advertiserId + "'not found");
        }
        advertiserService.deleteById(advertiserId);
    }
}
