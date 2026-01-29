package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.AdvertiserOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.AdvertiserInDto;

import java.util.List;

public interface AdvertiserService {

    List<AdvertiserOutDto> findAll();

    AdvertiserOutDto findById(int id);

    AdvertiserOutDto save(AdvertiserInDto advertiser);

    AdvertiserOutDto update(AdvertiserInDto advertiser, int advertiserId);

    void deleteById(int id);
}
