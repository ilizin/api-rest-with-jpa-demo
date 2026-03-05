package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.data.dao;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity.Vehicle;

import java.util.List;

public interface ICarDao {

    List<Vehicle> findAll();

    Vehicle findById(int id);

    Vehicle save(Vehicle car);

    void deleteById(int id);
}
