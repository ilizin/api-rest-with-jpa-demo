package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.AdvertisementDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.AdvertisementResultDto;

import java.util.List;

public interface AdvertisementService {

    List<AdvertisementResultDto> findAll();

    AdvertisementResultDto findById(int id);

    AdvertisementResultDto save(AdvertisementDto property);

    AdvertisementResultDto update(AdvertisementDto property, int advertisementId);

    void deleteById(int id);
}
