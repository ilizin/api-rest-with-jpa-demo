package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.AdvertisementDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Advertisement;
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
    public List<AdvertisementDto> findAll() {
        return advertisementService.findAll();
    }

    @Operation(summary = "Find an advertisement by id")
    @GetMapping("/advertisement/{advertisementId}")
    public AdvertisementDto getAdvertisement(@PathVariable int advertisementId) {
        AdvertisementDto advertisementDto = advertisementService.findById(advertisementId);
        if (advertisementDto == null) {
            throw new RuntimeException("Advertisement id not found '" + advertisementId + "'");
        }
        return advertisementDto;
    }

    @Operation(summary = "Add a new advertisement")
    @PostMapping("/advertisement")
    public AdvertisementDto addAdvertisement(@RequestBody AdvertisementDto advertisementDto) {
        // Just in case they pass an id in JSON, set the id to 0, to force a save of new item instead of update.
        // advertisementDto.setId(0); //We don't pass the id from the json
        return advertisementService.save(advertisementDto);
    }

    @Operation(summary = "Update an existing advertisement")
    @PutMapping("/advertisement")
    public AdvertisementDto updateAdvertisement(@RequestBody AdvertisementDto advertisementDto) {
        return advertisementService.save(advertisementDto);
    }

    @Operation(summary = "Delete an existing advertisement")
    @DeleteMapping("/advertisement/{advertisementId}")
    public void deleteAdvertisement(@PathVariable int advertisementId) {
        AdvertisementDto advertisementDto = advertisementService.findById(advertisementId);
        if (advertisementDto == null) {
            throw new RuntimeException("Advertisement id not found '" + advertisementId + "'");
        }
        advertisementService.deleteById(advertisementId);
    }
}
