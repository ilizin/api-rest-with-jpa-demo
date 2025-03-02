package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Advertiser;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service.AdvertiserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdvertiserRestController {

    private final AdvertiserService advertiserService;

    public AdvertiserRestController(AdvertiserService advertiserService) {
        this.advertiserService = advertiserService;
    }

    @GetMapping("/advertisers")
    public List<Advertiser> findAll() {
        return advertiserService.findAll();
    }

    @GetMapping("/advertisers/{advertiserId}")
    public Advertiser getAdvertiser(@PathVariable int advertiserId) {
        Advertiser advertiser = advertiserService.findById(advertiserId);
        if (advertiser == null) {
            throw new RuntimeException("Advertiser id not found '" + advertiserId + "'");
        }
        return advertiser;
    }

    @PostMapping("/advertisers")
    public Advertiser addAdvertiser(@RequestBody Advertiser advertiser) {
        // Just in case they pass an id in JSON, set the id to 0, to force a save of new item instead of update.
        advertiser.setId(0);
        return advertiserService.save(advertiser);
    }

    @PutMapping("/advertisers")
    public Advertiser updateAdvertiser(@RequestBody Advertiser advertiser) {
        return advertiserService.save(advertiser);
    }

    @DeleteMapping("/advertisers/{advertiserId}")
    public void deleteAdvertiser(@PathVariable int advertiserId) {
        Advertiser advertiser = advertiserService.findById(advertiserId);
        if (advertiser == null) {
            throw new RuntimeException("Property id not found '" + advertiserId + "'");
        }
        advertiserService.deleteById(advertiserId);
    }
}
