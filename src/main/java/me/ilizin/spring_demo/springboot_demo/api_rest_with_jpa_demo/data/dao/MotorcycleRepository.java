package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.data.dao;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Spring data rest instead of exposing /employees it'll expose /owners
This is often used to fix the spring pluralized form that is very basic as it just adds an 's' at the end of the word
@RepositoryRestResource(path="owners") */
public interface MotorcycleRepository extends JpaRepository<Motorcycle, Integer> {
}
