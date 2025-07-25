package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.AdvertisementInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.AdvertisementOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.exception.AdvertisementNotFoundException;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service.AdvertisementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Advertisement controller")
@RequestMapping("/api/v1")
public class AdvertisementRestController {

    private final AdvertisementService advertisementService;

    public AdvertisementRestController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @Operation(summary = "Get all the advertisements")
    @GetMapping("/advertisements")
    public List<AdvertisementOutDto> findAll() {
        List<AdvertisementOutDto> advertisementsResultDto = advertisementService.findAll();
        return advertisementsResultDto;
    }

    @Operation(summary = "Find an advertisement by id")
    @GetMapping("/advertisement/{advertisementId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful retrieved an advertisement"),
            @ApiResponse(responseCode = "404", description = "Advertisement not found")
    })
    public AdvertisementOutDto getAdvertisement(@Parameter(description = "The advertisement identifier", example = "1981")
                                                   @PathVariable int advertisementId) throws AdvertisementNotFoundException {
        AdvertisementOutDto advertisementResultDto = advertisementService.findById(advertisementId);
        if (advertisementResultDto == null) {
            throw new AdvertisementNotFoundException();
        }
        return advertisementResultDto;
    }

    @Operation(summary = "Add a new advertisement")
    @PostMapping("/advertisement")
    public AdvertisementOutDto addAdvertisement(@RequestBody AdvertisementInDto advertisementDto) {
        // Just in case they pass an id in JSON, set the id to 0, to force a save of new item instead of update.
        // advertisementDto.setId(0); //We don't pass the id from the json
        return advertisementService.save(advertisementDto);
    }

    @Operation(summary = "Update an existing advertisement")
    @PutMapping("/advertisement/{advertisementId}")
    public AdvertisementOutDto updateAdvertisement(@PathVariable int advertisementId,
                                                   @RequestBody AdvertisementInDto advertisementDto) {
        return advertisementService.update(advertisementDto, advertisementId);
    }

    @Operation(summary = "Delete an existing advertisement")
    @DeleteMapping("/advertisement/{advertisementId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful deleted an advertisement"),
            @ApiResponse(responseCode = "404", description = "Advertisement not found")
    })
    public void deleteAdvertisement(@Parameter(description = "The advertisement identifier", example = "1981")
                                    @PathVariable int advertisementId) throws AdvertisementNotFoundException {
        AdvertisementInDto advertisementDto = advertisementService.findById(advertisementId);
        if (advertisementDto == null) {
            throw new AdvertisementNotFoundException();
        }
        advertisementService.deleteById(advertisementId);
    }
}
