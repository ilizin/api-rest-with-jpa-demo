package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarOutDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.test.context.jdbc.Sql;

/* Note the use of webEnvironment=RANDOM_PORT to start the server with a random port (useful to avoid conflicts
   in test environments) and the injection of the port with @LocalServerPort. Also, note that Spring Boot has automatically
   provided a TestRestTemplate for you. */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/schema.sql")
public class CarRestControllerTest {

    private static final String EXPECTED_LIST_OF_CARS_AFTER_DELETE =
            "[{\"make\":\"Ferrari\"," +
            "\"model\":\"Testarossa\"," +
            "\"subModel\":null," +
            "\"firstRegistrationFrom\":1984," +
            "\"price\":250000," +
            "\"mileage\":51000," +
            "\"fuelType\":\"GASOLINE\"," +
            "\"gearBox\":\"MANUAL\"," +
            "\"power\":380," +
            "\"bodyType\":\"COUPE\"," +
            "\"id\":2}," +

            "{\"make\":\"Citroën\"," +
            "\"model\":\"XM\"," +
            "\"subModel\":null," +
            "\"firstRegistrationFrom\":1992," +
            "\"price\":13900," +
            "\"mileage\":75500," +
            "\"fuelType\":\"GASOLINE\"," +
            "\"gearBox\":\"MANUAL\"," +
            "\"power\":194," +
            "\"bodyType\":\"SEDAN\"," +
            "\"id\":3}," +

            "{\"make\":\"Ferrari\"," +
            "\"model\":\"Enzo\"," +
            "\"subModel\":null," +
            "\"firstRegistrationFrom\":2003," +
            "\"price\":4800000," +
            "\"mileage\":32000," +
            "\"fuelType\":\"GASOLINE\"," +
            "\"gearBox\":\"MANUAL\"," +
            "\"power\":650," +
            "\"bodyType\":\"COUPE\"," +
            "\"id\":4}," +

            "{\"make\":\"Lamborghini\"," +
            "\"model\":\"Countach\"," +
            "\"subModel\":null," +
            "\"firstRegistrationFrom\":1981," +
            "\"price\":700000," +
            "\"mileage\":73000," +
            "\"fuelType\":\"GASOLINE\"," +
            "\"gearBox\":\"MANUAL\"," +
            "\"power\":455," +
            "\"bodyType\":\"COUPE\"," +
            "\"id\":5}]";

    private static final String EXPECTED_LIST_OF_CARS =
            "[{\"make\":\"Lamborghini\"," +
                    "\"model\":\"Miura\"," +
                    "\"subModel\":null," +
                    "\"firstRegistrationFrom\":1970," +
                    "\"price\":2700000," +
                    "\"mileage\":48000," +
                    "\"fuelType\":\"GASOLINE\"," +
                    "\"gearBox\":\"MANUAL\"," +
                    "\"power\":380,\"bodyType\":\"COUPE\"," +
                    "\"id\":1}" + "," + EXPECTED_LIST_OF_CARS_AFTER_DELETE.replace("[", "");

    private static final String EXPECTED_LIST_OF_CARS_AFTER_ADD = EXPECTED_LIST_OF_CARS.replace("]", "") +
            ",{\"make\":\"Lamborghini\"," +
            "\"model\":\"Urus\"," +
            "\"subModel\":null," +
            "\"firstRegistrationFrom\":0," +
            "\"price\":368000," +
            "\"mileage\":10," +
            "\"fuelType\":\"GASOLINE\"," +
            "\"gearBox\":\"AUTOMATIC\"," +
            "\"power\":799," +
            "\"bodyType\":\"SUV\"," +
            "\"id\":11}]";

    private final static String EXPECTED_CAR_NUMBER_1 =
            "{\"make\":\"Lamborghini\"," +
            "\"model\":\"Miura\"," +
            "\"subModel\":null," +
            "\"firstRegistrationFrom\":1970," +
            "\"price\":2700000," +
            "\"mileage\":48000," +
            "\"fuelType\":\"GASOLINE\"," +
            "\"gearBox\":\"MANUAL\"," +
            "\"power\":380,\"bodyType\":\"COUPE\"," +
            "\"id\":1}";

    private static final CarInDto CAR_IN_DTO  = new CarInDto("Lamborghini", "Urus", null, 0, 368000, 10, FuelType.GASOLINE, GearBox.AUTOMATIC, 799, BodyType.SUV);
    private static final CarInDto CAR_OUT_DTO  = new CarOutDto(CAR_IN_DTO, 11);
    private static final CarInDto CAR_IN_DTO_WITH_DIFFERENT_PRICE = new CarInDto("Lamborghini", "Miura", null, 1970, 2000000, 48000, FuelType.GASOLINE, GearBox.MANUAL, 380, BodyType.COUPE);
    private static final CarInDto CAR_OUT_DTO_WITH_DIFFERENT_PRICE = new CarOutDto(CAR_IN_DTO_WITH_DIFFERENT_PRICE, 1);

    private static final String GET_ALL_CARS_URL = "/cars";
    private static final String GET_CAR_NUMBER1_URL = "/car/1";

    public static String getUrl(int port, String lastUrlPart) {
        return "http://localhost:" + port + "/api-rest-with-jpa-demo/api/v1" + lastUrlPart;
    }

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void addCar() {
        assertThat(this.restTemplate.getForObject(getUrl(port, GET_ALL_CARS_URL), String.class))
                .isEqualTo(EXPECTED_LIST_OF_CARS);

        assertThat(this.restTemplate.postForEntity(getUrl(port, "/car"), new HttpEntity<>(CAR_IN_DTO),
                CarOutDto.class).getBody()).usingRecursiveComparison().isEqualTo(CAR_OUT_DTO);

        assertThat(this.restTemplate.getForObject(getUrl(port, GET_ALL_CARS_URL), String.class))
                .isEqualTo(EXPECTED_LIST_OF_CARS_AFTER_ADD);
    }

    @Test
    public void deleteCar() {
        assertThat(this.restTemplate.getForObject(getUrl(port, GET_ALL_CARS_URL), String.class))
                .isEqualTo(EXPECTED_LIST_OF_CARS);

        assertThat(this.restTemplate.exchange(getUrl(port, GET_CAR_NUMBER1_URL), HttpMethod.DELETE, HttpEntity.EMPTY, Void.class
                ).getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));

        assertThat(this.restTemplate.getForObject(getUrl(port, GET_ALL_CARS_URL), String.class))
                .isEqualTo(EXPECTED_LIST_OF_CARS_AFTER_DELETE);
    }

    @Test
    public void getCar() {
        assertThat(this.restTemplate.getForObject(getUrl(port, GET_CAR_NUMBER1_URL), String.class))
                .isEqualTo(EXPECTED_CAR_NUMBER_1);
    }

    @Test
    public void updateCar() {
        assertThat(this.restTemplate.exchange(getUrl(port, GET_CAR_NUMBER1_URL), HttpMethod.PUT, new HttpEntity<>(CAR_IN_DTO_WITH_DIFFERENT_PRICE),
                CarOutDto.class).getBody()).usingRecursiveComparison().isEqualTo(CAR_OUT_DTO_WITH_DIFFERENT_PRICE);

        assertThat(this.restTemplate.getForObject(getUrl(port, GET_CAR_NUMBER1_URL), CarOutDto.class))
                .isEqualTo(CAR_OUT_DTO_WITH_DIFFERENT_PRICE);
    }
}
