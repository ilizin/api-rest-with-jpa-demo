package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarInDto;
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
public class CarRestControllerTest {

    private static final String EXPECTED_EMPTY_LIST_OF_ADVERTISEMENT = "[{\"make\":\"Lamborghini\",\"model\":\"Miura\",\"firstRegistrationFrom\":1970,\"price\":2700000,\"mileage\":48000,\"fuelType\":\"GASOLINE\",\"gearBox\":\"MANUAL\",\"power\":380,\"bodyType\":\"COUPE\",\"id\":1},{\"make\":\"Ferrari\",\"model\":\"Testarossa\",\"firstRegistrationFrom\":1984,\"price\":250000,\"mileage\":51000,\"fuelType\":\"GASOLINE\",\"gearBox\":\"MANUAL\",\"power\":380,\"bodyType\":\"COUPE\",\"id\":2},{\"make\":\"Citroën\",\"model\":\"XM\",\"firstRegistrationFrom\":1992,\"price\":13900,\"mileage\":75500,\"fuelType\":\"GASOLINE\",\"gearBox\":\"MANUAL\",\"power\":194,\"bodyType\":\"SEDAN\",\"id\":3},{\"make\":\"Ferrari\",\"model\":\"Enzo\",\"firstRegistrationFrom\":2003,\"price\":4800000,\"mileage\":32000,\"fuelType\":\"GASOLINE\",\"gearBox\":\"MANUAL\",\"power\":650,\"bodyType\":\"COUPE\",\"id\":4},{\"make\":\"Lamborghini\",\"model\":\"Countach\",\"firstRegistrationFrom\":1981,\"price\":700000,\"mileage\":73000,\"fuelType\":\"GASOLINE\",\"gearBox\":\"MANUAL\",\"power\":455,\"bodyType\":\"COUPE\",\"id\":5}]";
    private static final String EXPECTED_ONE_ADVERTISEMENT_WITH_UPDATED_PRICE = "{\"title\":\"Studio in Culture Thonglor\",\"province\":\"Bangkok\",\"municipality\":null,\"country\":\"Thailand\",\"address\":\"Soi Yanat\",\"price\":8550700.0,\"description\":\"A studio apartment available for Sale\",\"size\":120,\"floor\":2,\"totalRooms\":4,\"totalFlatmates\":4,\"totalBathrooms\":2,\"flatmatesGender\":\"MEN_AND_WOMEN\",\"flatmatesAge\":{\"min\":29,\"max\":49},\"hasLift\":false,\"id\":1,\"lgbtFriendly\":true}";
    private static final CarInDto CAR_IN_DTO  = new CarInDto("Lamborghini", "Urus", 0, 368000, 10, FuelType.GASOLINE, GearBox.AUTOMATIC, 799, BodyType.SUV);

    private static final String URL_LAST_PART_FOR_GETTING_ALL_CARS = "/cars";
    private static final String URL_LAST_PART_FOR_GETTING_CAR_WITH_ID1 = "/car/1";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void propertyRestControllerTest() {
        addCar();
    }

    private String getUrl(int port, String lastUrlPart) {
        return "http://localhost:" + port + "/api-rest-with-jpa-demo/api/v1" + lastUrlPart;
    }

    private void addCar() {
        assertThat(this.restTemplate.getForObject(getUrl(port, URL_LAST_PART_FOR_GETTING_ALL_CARS), String.class))
                .contains(EXPECTED_EMPTY_LIST_OF_ADVERTISEMENT);

        assertThat(this.restTemplate.postForEntity(getUrl(port, "/car"), new HttpEntity<>(CAR_IN_DTO),
                String.class)).isNotNull();
        
        assertThat(this.restTemplate.getForObject(getUrl(port, URL_LAST_PART_FOR_GETTING_ALL_CARS), String.class))
                .contains(EXPECTED_EMPTY_LIST_OF_ADVERTISEMENT);

       /* assertThat(this.restTemplate.getForObject(getUrl(port, URL_LAST_PART_FOR_GETTING_ALL_CARS), String.class))
                .contains(EXPECTED_LIST_OF_ONE_ADVERTISEMENT);
        assertThat(this.restTemplate.getForObject(getUrl(port, URL_LAST_PART_FOR_GETTING_ALL_CARS), String.class))
                .contains(EXPECTED_ONE_ADVERTISEMENT);*/
    }

    /*private void updatePropertyAndValidate() {
        PROPERTY_IN_DTO.setPrice(PROPERTY_IN_DTO.getPrice() - 700);
        assertThat(this.restTemplate.exchange(getUrl(port, "/property"), HttpMethod.PUT, new HttpEntity<>(PROPERTY_IN_DTO),
                Property.class)).isNotNull();
        assertThat(this.restTemplate.getForObject(getUrl(port, URL_LAST_PART_FOR_GETTING_PROPERTY_ONE), String.class))
                .contains(EXPECTED_ONE_ADVERTISEMENT_WITH_UPDATED_PRICE);
    }*/

    /*private void deletePropertyAndValidate() {
        assertThat(this.restTemplate.exchange(getUrl(port, URL_LAST_PART_FOR_GETTING_PROPERTY_ONE), HttpMethod.DELETE, HttpEntity.EMPTY, Void.class))
                .isNotNull();
        assertThat(this.restTemplate.getForObject(getUrl(port, URL_LAST_PART_FOR_GETTING_ALL_PROPERTIES), String.class))
                .contains(EXPECTED_EMPTY_LIST_OF_ADVERTISEMENT);
    }*/
}
