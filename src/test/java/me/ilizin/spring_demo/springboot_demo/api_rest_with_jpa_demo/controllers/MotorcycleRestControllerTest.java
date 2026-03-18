package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.BodyTypeMotorcycle;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FuelType;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.GearBox;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.CarOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.MotorcycleInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.MotorcycleOutDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/schema.sql")
public class MotorcycleRestControllerTest {

    private static final String EXPECTED_LIST_OF_MOTORCYCLES_NO_CLOSING_ARRAY =
            "[{\"make\":\"Ducati\"," +
              "\"model\":\"620 Sport\"," +
              "\"subModel\":null," +
              "\"firstRegistrationFrom\":2004," +
              "\"price\":2700," +
              "\"mileage\":20000," +
              "\"fuelType\":\"GASOLINE\"," +
              "\"gearBox\":\"MANUAL\"," +
              "\"power\":60," +
              "\"bodyType\":\"SUPERSPORT\"," +
              "\"id\":6}" +

              ",{\"make\":\"Ducati\"," +
              "\"model\":\"Streetfighter\"," +
              "\"submodel\":\"V4S\"," +
              "\"firstRegistrationFrom\":2021," +
              "\"price\":20000," +
              "\"mileage\":15000," +
              "\"fuelType\":\"GASOLINE\"," +
              "\"gearBox\":\"MANUAL\"," +
              "\"power\":212," +
              "\"bodyType\":\"SUPERSPORT\"," +
              "\"id\":7}," +

              "{\"make\":\"Kawasaki\"," +
              "\"model\":\"Ninja\"," +
              "\"submodel\":\"500 SE\"," +
              "\"firstRegistrationFrom\":2024," +
              "\"price\":7000," +
              "\"mileage\":17320," +
              "\"fuelType\":\"GASOLINE\"," +
              "\"gearBox\":\"MANUAL\"," +
              "\"power\":48," +
              "\"bodyType\":\"SUPERSPORT\"," +
              "\"id\":8}," +

              "{\"make\":\"Honda\"," +
              "\"model\":\"NSR 50\"," +
              "\"subModel\":null," +
              "\"firstRegistrationFrom\":1990," +
              "\"price\":5500," +
              "\"mileage\":22000," +
              "\"fuelType\":\"GASOLINE\"," +
              "\"gearBox\":\"MANUAL\"," +
              "\"power\":14," +
              "\"bodyType\":\"SUPERSPORT\"," +
              "\"id\":9}," +

              "{\"make\":\"Yamaha\"," +
              "\"model\":\"FJ 1200\"," +
              "\"subModel\":null," +
              "\"firstRegistrationFrom\":1989," +
              "\"price\":4000," +
              "\"mileage\":68000," +
              "\"fuelType\":\"GASOLINE\"," +
              "\"gearBox\":\"MANUAL\"," +
              "\"power\":131," +
              "\"bodyType\":\"SUPERSPORT\"," +
              "\"id\":10}";
    private static final String EXPECTED_LIST_OF_MOTORCYCLES = EXPECTED_LIST_OF_MOTORCYCLES_NO_CLOSING_ARRAY + "]";
    private static final String EXPECTED_LIST_OF_MOTORCYCLES_AFTER_ADD = EXPECTED_LIST_OF_MOTORCYCLES_NO_CLOSING_ARRAY +
            ",{\"make\":\"Yamaha\"," +
            "\"model\":\"YZF-R1\"," +
            "\"subModel\":null," +
            "\"firstRegistrationFrom\":2016," +
            "\"price\":12500," +
            "\"mileage\":10," +
            "\"fuelType\":\"GASOLINE\"," +
            "\"gearBox\":\"MANUAL\"," +
            "\"power\":200," +
            "\"bodyType\":\"SUPERSPORT\"," +
            "\"id\":11}]";

    private static final String EXPECTED_LIST_OF_MOTORCYCLES_AFTER_DELETE =
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

    private final static String EXPECTED_MOTORCYCLES_NUMBER_6 =
            "{\"make\":\"Ducati\"," +
             "\"model\":\"620 Sport\"," +
             "\"subModel\":null," +
             "\"firstRegistrationFrom\":2004," +
             "\"price\":2700," +
             "\"mileage\":20000," +
             "\"fuelType\":\"GASOLINE\"," +
             "\"gearBox\":\"MANUAL\"," +
             "\"power\":60," +
             "\"bodyType\":\"SUPERSPORT\"," +
             "\"id\":6}";

    private static final MotorcycleInDto MOTORCYCLE_IN_DTO  = new MotorcycleInDto("Yamaha", "YZF-R1", null, 2016, 12500, 10, FuelType.GASOLINE, GearBox.MANUAL, 200, BodyTypeMotorcycle.SUPERSPORT);
    private static final MotorcycleOutDto MOTORCYCLE_OUT_DTO  = new MotorcycleOutDto("Yamaha", "YZF-R1", null, 2016, 12500, 10, FuelType.GASOLINE, GearBox.MANUAL, 200, BodyTypeMotorcycle.SUPERSPORT, 11);
    private static final CarInDto MOTORCYCLE_IN_DTO_WITH_DIFFERENT_PRICE = new CarInDto("Lamborghini", "Miura", null, 1970, 2000000, 48000, FuelType.GASOLINE, GearBox.MANUAL, 380, BodyType.COUPE);
    private static final CarInDto MOTORCYCLE_OUT_DTO_WITH_DIFFERENT_PRICE = new CarOutDto("Lamborghini", "Miura",  null, 1970, 2000000, 48000, FuelType.GASOLINE, GearBox.MANUAL, 380, BodyType.COUPE, 1);

    private static final String GET_ALL_MOTORCYCLES_URL = "/motorcycles";
    private static final String GET_MOTORCYCLE_NUMBER6_URL = "/motorcycle/6";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void addMotorcycle() {
        /*assertThat(this.restTemplate.getForObject(getUrl(port, GET_ALL_MOTORCYCLES_URL), String.class))
                .isEqualTo(EXPECTED_LIST_OF_MOTORCYCLES);
*/
        assertThat(this.restTemplate.postForEntity(getUrl(port, "/motorcycle"), new HttpEntity<>(MOTORCYCLE_IN_DTO),
                MotorcycleOutDto.class).getBody()).usingRecursiveComparison().isEqualTo(MOTORCYCLE_OUT_DTO);

        assertThat(this.restTemplate.getForObject(getUrl(port, GET_ALL_MOTORCYCLES_URL), String.class))
                .isEqualTo(EXPECTED_LIST_OF_MOTORCYCLES_AFTER_ADD);
    }

    @Test
    public void deleteMotorcycle() {
        assertThat(this.restTemplate.getForObject(getUrl(port, GET_ALL_MOTORCYCLES_URL), String.class))
                .isEqualTo(EXPECTED_LIST_OF_MOTORCYCLES);

        assertThat(this.restTemplate.exchange(getUrl(port, GET_MOTORCYCLE_NUMBER6_URL), HttpMethod.DELETE, HttpEntity.EMPTY, Void.class
        ).getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));

        assertThat(this.restTemplate.getForObject(getUrl(port, GET_ALL_MOTORCYCLES_URL), String.class))
                .isEqualTo(EXPECTED_LIST_OF_MOTORCYCLES_AFTER_DELETE);
    }

    @Test
    public void getMotorcycle() {
        assertThat(this.restTemplate.getForObject(getUrl(port, GET_MOTORCYCLE_NUMBER6_URL), String.class))
                .isEqualTo(EXPECTED_MOTORCYCLES_NUMBER_6);
    }

    @Test
    public void updateMotorcycle() {
        assertThat(this.restTemplate.exchange(getUrl(port, GET_MOTORCYCLE_NUMBER6_URL), HttpMethod.PUT, new HttpEntity<>(MOTORCYCLE_IN_DTO_WITH_DIFFERENT_PRICE),
                CarOutDto.class).getBody()).usingRecursiveComparison().isEqualTo(MOTORCYCLE_OUT_DTO_WITH_DIFFERENT_PRICE);

        assertThat(this.restTemplate.getForObject(getUrl(port, GET_MOTORCYCLE_NUMBER6_URL), CarOutDto.class))
                .isEqualTo(MOTORCYCLE_OUT_DTO_WITH_DIFFERENT_PRICE);
    }

    private String getUrl(int port, String lastUrlPart) {
        return "http://localhost:" + port + "/api-rest-with-jpa-demo/api/v1" + lastUrlPart;
    }
}
