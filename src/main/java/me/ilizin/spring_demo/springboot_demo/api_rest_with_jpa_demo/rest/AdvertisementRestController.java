package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Advertisement;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service.AdvertisementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdvertisementRestController {

    private final AdvertisementService advertisementService;

    public AdvertisementRestController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping("/advertisements")
    public List<Advertisement> findAll() {
        return advertisementService.findAll();
    }

    @GetMapping("/advertisements/{advertisementId}")
    public Advertisement getProperty(@PathVariable int advertisementId) {
        Advertisement advertisement = advertisementService.findById(advertisementId);
        if (advertisement == null) {
            throw new RuntimeException("Property id not found '" + advertisementId + "'");
        }
        return advertisement;
    }

    @PostMapping("/advertisements")
    public Advertisement addProperty(@RequestBody Advertisement advertisement) {
        // Just in case they pass an id in JSON, set the id to 0, to force a save of new item instead of update.
        advertisement.setId(0);
        return advertisementService.save(advertisement);
    }

    @PutMapping("/advertisements")
    public Advertisement updateProperty(@RequestBody Advertisement property) {
        return advertisementService.save(property);
    }

    @DeleteMapping("/advertisements/{advertisementId}")
    public void deleteProperty(@PathVariable int advertisementId) {
        Advertisement advertisement = advertisementService.findById(advertisementId);
        if (advertisement == null) {
            throw new RuntimeException("Property id not found '" + advertisementId + "'");
        }
        advertisementService.deleteById(advertisementId);
    }
}
