package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

/* Note the use of webEnvironment=RANDOM_PORT to start the server with a random port (useful to avoid conflicts
   in test environments) and the injection of the port with @LocalServerPort. Also, note that Spring Boot has automatically
   provided a TestRestTemplate for you. */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdvertisementRestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/advertisements", String.class)).contains("[]");
    }
}
