package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.AdvertisementInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.AdvertisementOutDto;

import java.util.List;

public interface AdvertisementService {

    List<AdvertisementOutDto> findAll();

    AdvertisementOutDto findById(int id);

    AdvertisementOutDto save(AdvertisementInDto property);

    AdvertisementOutDto update(AdvertisementInDto property, int advertisementId);

    void deleteById(int id);
}
