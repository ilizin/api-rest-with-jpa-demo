package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Advertiser;
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
    @GetMapping("/advertisers")
    public List<Advertiser> findAll() {
        return advertiserService.findAll();
    }

    @Operation(summary = "Find an advertiser by id")
    @GetMapping("/advertiser/{advertiserId}")
    public Advertiser getAdvertiser(@PathVariable int advertiserId) {
        Advertiser advertiser = advertiserService.findById(advertiserId);
        if (advertiser == null) {
            throw new RuntimeException("Advertiser id not found '" + advertiserId + "'");
        }
        return advertiser;
    }

    @Operation(summary = "Add a new advertiser")
    @PostMapping("/advertiser")
    public Advertiser addAdvertiser(@RequestBody Advertiser advertiser) {
        // Just in case they pass an id in JSON, set the id to 0, to force a save of new item instead of update.
        advertiser.setId(0);
        return advertiserService.save(advertiser);
    }

    @Operation(summary = "Update an existing advertiser")
    @PutMapping("/advertiser")
    public Advertiser updateAdvertiser(@RequestBody Advertiser advertiser) {
        return advertiserService.save(advertiser);
    }

    @Operation(summary = "Delete an existing advertiser")
    @DeleteMapping("/advertiser/{advertiserId}")
    public void deleteAdvertiser(@PathVariable int advertiserId) {
        Advertiser advertiser = advertiserService.findById(advertiserId);
        if (advertiser == null) {
            throw new RuntimeException("Property id not found '" + advertiserId + "'");
        }
        advertiserService.deleteById(advertiserId);
    }
}
