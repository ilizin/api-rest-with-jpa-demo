package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Property;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PropertyRestController {

    private final PropertyService propertyService;

    public PropertyRestController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/properties")
    public List<Property> findAll() {
        return propertyService.findAll();
    }

    @GetMapping("/property/{propertyId}")
    public Property getProperty(@PathVariable int propertyId) {
        Property property = propertyService.findBId(propertyId);
        if (property == null) {
            throw new RuntimeException("Property not found");
        }
        return property;
    }

    @PostMapping("/property")
    public Property addProperty(@RequestBody Property property) {

        // Just in case they pass an id in JSON, set the id to 0, to force a save of new item instead of update.
        property.setId(0);
        return propertyService.save(property);
    }
}
