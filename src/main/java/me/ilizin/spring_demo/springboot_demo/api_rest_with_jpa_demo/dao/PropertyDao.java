package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Property;

import java.util.List;

public interface PropertyDao {

    List<Property> findAll();

    Property findBId(int id);

    Property save(Property property);

    void deleteById(int id);
}
