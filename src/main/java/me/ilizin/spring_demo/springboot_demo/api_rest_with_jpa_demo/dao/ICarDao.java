package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity.Car;

import java.util.List;

public interface ICarDao {

    List<Car> findAll();

    Car findById(int id);

    Car save(Car car);

    void deleteById(int id);
}
