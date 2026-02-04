package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers.CarRestController;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.controllers.MotorcycleRestController;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services.ICarService;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services.IMotorcycleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApiRestWithJpaDemoApplicationTest {

	@Autowired
	private CarRestController carRestController;
	@Autowired
	private MotorcycleRestController motorcycleRestController;
	@Autowired
	private ICarService carService;
	@Autowired
	private IMotorcycleService motorcycleService;

	@Test
	void contextLoads() {
		assertThat(carRestController).isNotNull();
		assertThat(motorcycleRestController).isNotNull();
		assertThat(carService).isNotNull();
		assertThat(motorcycleService).isNotNull();
	}
}
