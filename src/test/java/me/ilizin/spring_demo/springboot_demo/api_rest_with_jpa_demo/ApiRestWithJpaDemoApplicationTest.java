package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers.AdvertiserRestController;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers.PropertyRestController;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services.AdvertiserService;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services.PropertyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApiRestWithJpaDemoApplicationTest {

	@Autowired
	private AdvertiserRestController advertiserRestController;
	@Autowired
	private PropertyRestController advertisementRestController;
	@Autowired
	private AdvertiserService advertiserService;
	@Autowired
	private PropertyService advertisementService;

	@Test
	void contextLoads() {
		assertThat(advertiserRestController).isNotNull();
		assertThat(advertisementRestController).isNotNull();
		assertThat(advertiserService).isNotNull();
		assertThat(advertisementService).isNotNull();
	}
}
