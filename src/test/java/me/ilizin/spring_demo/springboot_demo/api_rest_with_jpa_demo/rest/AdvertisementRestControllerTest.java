package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest;

import static org.assertj.core.api.Assertions.assertThat;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.PropertyInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Property;
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

    private static final String EXPECTED_ONE_ADVERTISEMENT = "{\"id\":1,\"title\":\"Studio in Culture Thonglor\",\"city\":\"Bangkok\"," +
            "\"country\":\"Thailand\",\"address\":\"Soi Yanat\",\"price\":8550700.0,\"description\":" +
            "\"A studio apartment available for Sale\",\"size\":120}";

    private static final String EXPECTED_LIST_OF_ONE_ADVERTISEMENT = "[" + EXPECTED_ONE_ADVERTISEMENT + "]";

    private static final String EXPECTED_EMPTY_LIST_OF_ADVERTISEMENT = "[]";

    private static final String EXPECTED_ONE_ADVERTISEMENT_WITH_UPDATED_PRICE = "{\"id\":1,\"title\":\"Studio in Culture Thonglor\",\"city\":\"Bangkok\"," +
            "\"country\":\"Thailand\",\"address\":\"Soi Yanat\",\"price\":8550000.0,\"description\":" +
            "\"A studio apartment available for Sale\",\"size\":120}";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void advertisementRestControllerTest() {

        assertThat(this.restTemplate.getForObject(getUrl(port, "/advertisements"), String.class))
                .contains(EXPECTED_EMPTY_LIST_OF_ADVERTISEMENT);

        PropertyInDto advertisement
                = new PropertyInDto("Studio in Culture Thonglor", "Bangkok", null, "Thailand", "Soi Yanat",
                8550700, "A studio apartment available for Sale", 120);
        HttpEntity<PropertyInDto> request = new HttpEntity<>(advertisement);

        assertThat(this.restTemplate.postForEntity(getUrl(port, "/advertisement"), request, String.class))
                .isNotNull();

        assertThat(this.restTemplate.getForObject(getUrl(port, "/advertisements"), String.class))
                .contains(EXPECTED_LIST_OF_ONE_ADVERTISEMENT);

        assertThat(this.restTemplate.getForObject(getUrl(port, "/advertisement/1"), String.class))
                .contains(EXPECTED_ONE_ADVERTISEMENT);

        advertisement.setPrice(advertisement.getPrice() - 700);
        request = new HttpEntity<>(advertisement);

        assertThat(this.restTemplate.exchange(getUrl(port, "/advertisement"), HttpMethod.PUT, request, Property.class))
                .isNotNull();

        assertThat(this.restTemplate.getForObject(getUrl(port, "/advertisement/1"), String.class))
                .contains(EXPECTED_ONE_ADVERTISEMENT_WITH_UPDATED_PRICE);

        assertThat(this.restTemplate.exchange(getUrl(port, "/advertisement/1"), HttpMethod.DELETE, HttpEntity.EMPTY, Void.class))
                .isNotNull();

        assertThat(this.restTemplate.getForObject(getUrl(port, "/advertisements"), String.class))
                .contains(EXPECTED_EMPTY_LIST_OF_ADVERTISEMENT);
    }

    private String getUrl(int port, String lastPart) {
        return "http://localhost:" + port + "/api-rest-with-jpa-demo/api/v1" + lastPart;
    }
}
