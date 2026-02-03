package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers.CarRestController;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services.AdvertiserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApiRestWithJpaDemoApplicationTest {

	@Autowired
	private CarRestController carRestController;
	@Autowired
	private AdvertiserService advertiserService;

	@Test
	void contextLoads() {
		assertThat(carRestController).isNotNull();
		assertThat(advertiserService).isNotNull();
	}
}
