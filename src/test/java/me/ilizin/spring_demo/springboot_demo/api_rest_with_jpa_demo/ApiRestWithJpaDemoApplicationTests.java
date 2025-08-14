package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest.AdvertiserRestController;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.rest.PropertyRestController;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service.AdvertiserService;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service.PropertyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApiRestWithJpaDemoApplicationTests {

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
