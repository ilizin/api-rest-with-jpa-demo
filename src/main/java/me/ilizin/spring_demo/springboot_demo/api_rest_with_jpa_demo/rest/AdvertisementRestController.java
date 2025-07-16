package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public List<Advertisement> findAll() {
        return advertisementService.findAll();
    }

    @Operation(summary = "Find an advertisement by id")
    @GetMapping("/advertisement/{advertisementId}")
    public Advertisement getAdvertisement(@PathVariable int advertisementId) {
        Advertisement advertisement = advertisementService.findById(advertisementId);
        if (advertisement == null) {
            throw new RuntimeException("Advertisement id not found '" + advertisementId + "'");
        }
        return advertisement;
    }

    @Operation(summary = "Add a new advertisement")
    @PostMapping("/advertisement")
    public Advertisement addAdvertisement(@RequestBody Advertisement advertisement) {
        // Just in case they pass an id in JSON, set the id to 0, to force a save of new item instead of update.
        advertisement.setId(0);
        return advertisementService.save(advertisement);
    }

    @Operation(summary = "Update an existing advertisement")
    @PutMapping("/advertisement")
    public Advertisement updateAdvertisement(@RequestBody Advertisement property) {
        return advertisementService.save(property);
    }

    @Operation(summary = "Delete an advertisement")
    @DeleteMapping("/advertisement/{advertisementId}")
    public void deleteAdvertisement(@PathVariable int advertisementId) {
        Advertisement advertisement = advertisementService.findById(advertisementId);
        if (advertisement == null) {
            throw new RuntimeException("Advertisement id not found '" + advertisementId + "'");
        }
        advertisementService.deleteById(advertisementId);
    }
}
