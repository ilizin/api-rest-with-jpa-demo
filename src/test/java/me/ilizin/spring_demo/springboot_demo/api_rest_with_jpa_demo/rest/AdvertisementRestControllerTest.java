package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest;

import static org.assertj.core.api.Assertions.assertThat;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.FlatmatesAgeRangeDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.PropertyInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Property;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FlatMatesGender;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.utilities.Range;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

/* Note the use of webEnvironment=RANDOM_PORT to start the server with a random port (useful to avoid conflicts
   in test environments) and the injection of the port with @LocalServerPort. Also, note that Spring Boot has automatically
   provided a TestRestTemplate for you. */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdvertisementRestControllerTest {

    private static final String EXPECTED_ONE_ADVERTISEMENT = "{\"title\":\"Studio in Culture Thonglor\",\"province\":\"Bangkok\",\"municipality\":null,\"country\":\"Thailand\",\"address\":\"Soi Yanat\",\"price\":8550700.0,\"description\":\"A studio apartment available for Sale\",\"size\":120,\"floor\":2,\"totalRooms\":4,\"totalFlatmates\":4,\"totalBathrooms\":2,\"flatmatesGender\":\"MEN_AND_WOMEN\",\"flatmatesAge\":{\"min\":29,\"max\":49},\"hasLift\":false,\"id\":1,\"lgbtFriendly\":true}";

    private static final String EXPECTED_LIST_OF_ONE_ADVERTISEMENT = "[" + EXPECTED_ONE_ADVERTISEMENT + "]";

    private static final String EXPECTED_EMPTY_LIST_OF_ADVERTISEMENT = "[]";

    private static final String EXPECTED_ONE_ADVERTISEMENT_WITH_UPDATED_PRICE = "{\"title\":\"Studio in Culture Thonglor\",\"province\":\"Bangkok\",\"municipality\":null,\"country\":\"Thailand\",\"address\":\"Soi Yanat\",\"price\":8550700.0,\"description\":\"A studio apartment available for Sale\",\"size\":120,\"floor\":2,\"totalRooms\":4,\"totalFlatmates\":4,\"totalBathrooms\":2,\"flatmatesGender\":\"MEN_AND_WOMEN\",\"flatmatesAge\":{\"min\":29,\"max\":49},\"hasLift\":false,\"id\":1,\"lgbtFriendly\":true}";

    private static final PropertyInDto PROPERTY_IN_DTO  = new PropertyInDto("Studio in Culture Thonglor", "Bangkok", null, "Thailand", "Soi Yanat",
            8550700d, "A studio apartment available for Sale", 120, 2, 4, 4, 2, FlatMatesGender.MEN_AND_WOMEN,
            new FlatmatesAgeRangeDto(29, 49), true, false);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void advertisementRestControllerTest() {

        assertThat(this.restTemplate.getForObject(getUrl(port, "/properties"), String.class))
                .contains(EXPECTED_EMPTY_LIST_OF_ADVERTISEMENT);

        HttpEntity<PropertyInDto> request = new HttpEntity<>(PROPERTY_IN_DTO);

        assertThat(this.restTemplate.postForEntity(getUrl(port, "/property"), request, String.class))
                .isNotNull();

        assertThat(this.restTemplate.getForObject(getUrl(port, "/properties"), String.class))
                .contains(EXPECTED_LIST_OF_ONE_ADVERTISEMENT);

        assertThat(this.restTemplate.getForObject(getUrl(port, "/property/1"), String.class))
                .contains(EXPECTED_ONE_ADVERTISEMENT);

        PROPERTY_IN_DTO.setPrice(PROPERTY_IN_DTO.getPrice() - 700);
        request = new HttpEntity<>(PROPERTY_IN_DTO);

        assertThat(this.restTemplate.exchange(getUrl(port, "/property"), HttpMethod.PUT, request, Property.class))
                .isNotNull();

        assertThat(this.restTemplate.getForObject(getUrl(port, "/property/1"), String.class))
                .contains(EXPECTED_ONE_ADVERTISEMENT_WITH_UPDATED_PRICE);

        assertThat(this.restTemplate.exchange(getUrl(port, "/property/1"), HttpMethod.DELETE, HttpEntity.EMPTY, Void.class))
                .isNotNull();

        assertThat(this.restTemplate.getForObject(getUrl(port, "/properties"), String.class))
                .contains(EXPECTED_EMPTY_LIST_OF_ADVERTISEMENT);
    }

    private String getUrl(int port, String lastPart) {
        return "http://localhost:" + port + "/api-rest-with-jpa-demo/api/v1" + lastPart;
    }
}
