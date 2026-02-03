package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest;

import static org.assertj.core.api.Assertions.assertThat;

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
public class PropertyRestControllerTest {

    private static final String EXPECTED_ONE_ADVERTISEMENT = "{\"title\":\"Studio in Culture Thonglor\",\"province\":\"Bangkok\",\"municipality\":null,\"country\":\"Thailand\",\"address\":\"Soi Yanat\",\"price\":8550700.0,\"description\":\"A studio apartment available for Sale\",\"size\":120,\"floor\":2,\"totalRooms\":4,\"totalFlatmates\":4,\"totalBathrooms\":2,\"flatmatesGender\":\"MEN_AND_WOMEN\",\"flatmatesAge\":{\"min\":29,\"max\":49},\"hasLift\":false,\"id\":1,\"lgbtFriendly\":true}";
    private static final String EXPECTED_LIST_OF_ONE_ADVERTISEMENT = "[" + EXPECTED_ONE_ADVERTISEMENT + "]";
    private static final String EXPECTED_EMPTY_LIST_OF_ADVERTISEMENT = "[]";
    private static final String EXPECTED_ONE_ADVERTISEMENT_WITH_UPDATED_PRICE = "{\"title\":\"Studio in Culture Thonglor\",\"province\":\"Bangkok\",\"municipality\":null,\"country\":\"Thailand\",\"address\":\"Soi Yanat\",\"price\":8550700.0,\"description\":\"A studio apartment available for Sale\",\"size\":120,\"floor\":2,\"totalRooms\":4,\"totalFlatmates\":4,\"totalBathrooms\":2,\"flatmatesGender\":\"MEN_AND_WOMEN\",\"flatmatesAge\":{\"min\":29,\"max\":49},\"hasLift\":false,\"id\":1,\"lgbtFriendly\":true}";
    /*private static final PropertyInDto PROPERTY_IN_DTO  = new PropertyInDto("Studio in Culture Thonglor", "Bangkok", null, "Thailand", "Soi Yanat",
            8550700d, "A studio apartment available for Sale", 120, 2, 4, 4, 2, FlatMatesGender.MEN_AND_WOMEN,
            new FlatmatesAgeRangeDto(29, 49), true, false);
*/
    private static final String URL_LAST_PART_FOR_GETTING_ALL_PROPERTIES = "/properties";
    private static final String URL_LAST_PART_FOR_GETTING_PROPERTY_ONE = "/property/1";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void propertyRestControllerTest() {
       // addPropertyAndValidate();
       // updatePropertyAndValidate();
        deletePropertyAndValidate();
    }

    private String getUrl(int port, String lastUrlPart) {
        return "http://localhost:" + port + "/api-rest-with-jpa-demo/api/v1" + lastUrlPart;
    }

   /* private void addPropertyAndValidate() {
        assertThat(this.restTemplate.getForObject(getUrl(port, URL_LAST_PART_FOR_GETTING_ALL_PROPERTIES), String.class))
                .contains(EXPECTED_EMPTY_LIST_OF_ADVERTISEMENT);
        assertThat(this.restTemplate.postForEntity(getUrl(port, "/property"), new HttpEntity<>(PROPERTY_IN_DTO),
                String.class)).isNotNull();
        assertThat(this.restTemplate.getForObject(getUrl(port, URL_LAST_PART_FOR_GETTING_ALL_PROPERTIES), String.class))
                .contains(EXPECTED_LIST_OF_ONE_ADVERTISEMENT);
        assertThat(this.restTemplate.getForObject(getUrl(port, URL_LAST_PART_FOR_GETTING_PROPERTY_ONE), String.class))
                .contains(EXPECTED_ONE_ADVERTISEMENT);
    }*/

    /*private void updatePropertyAndValidate() {
        PROPERTY_IN_DTO.setPrice(PROPERTY_IN_DTO.getPrice() - 700);
        assertThat(this.restTemplate.exchange(getUrl(port, "/property"), HttpMethod.PUT, new HttpEntity<>(PROPERTY_IN_DTO),
                Property.class)).isNotNull();
        assertThat(this.restTemplate.getForObject(getUrl(port, URL_LAST_PART_FOR_GETTING_PROPERTY_ONE), String.class))
                .contains(EXPECTED_ONE_ADVERTISEMENT_WITH_UPDATED_PRICE);
    }*/

    private void deletePropertyAndValidate() {
        assertThat(this.restTemplate.exchange(getUrl(port, URL_LAST_PART_FOR_GETTING_PROPERTY_ONE), HttpMethod.DELETE, HttpEntity.EMPTY, Void.class))
                .isNotNull();
        assertThat(this.restTemplate.getForObject(getUrl(port, URL_LAST_PART_FOR_GETTING_ALL_PROPERTIES), String.class))
                .contains(EXPECTED_EMPTY_LIST_OF_ADVERTISEMENT);
    }
}
