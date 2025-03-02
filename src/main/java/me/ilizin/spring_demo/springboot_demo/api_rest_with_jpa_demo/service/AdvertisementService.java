package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Advertisement;

import java.util.List;

public interface AdvertisementService {

    List<Advertisement> findAll();

    Advertisement findById(int id);

    Advertisement save(Advertisement property);

    void deleteById(int id);
}
