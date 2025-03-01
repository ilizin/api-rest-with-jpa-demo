package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Advertiser;

import java.util.List;

public interface AdvertiserService {

    List<Advertiser> findAll();

    Advertiser findById(int id);

    Advertiser save(Advertiser advertiser);

    void deleteById(int id);
}
