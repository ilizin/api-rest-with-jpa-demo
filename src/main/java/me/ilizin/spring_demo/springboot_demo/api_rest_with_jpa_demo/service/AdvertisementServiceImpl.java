package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao.AdvertisementDao;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.AdvertisementDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.AdvertisementResultDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Advertisement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementDao advertisementDao;

    public AdvertisementServiceImpl(AdvertisementDao advertisementDao) {
        this.advertisementDao = advertisementDao;
    }

    @Override
    public List<AdvertisementResultDto> findAll() {
        List<Advertisement> advertisements = advertisementDao.findAll();
        return advertisements
                .stream()
                .map(this::mapAdvertisementToAdvertisementResultDto)
                .toList();
    }

    @Override
    public AdvertisementResultDto findById(int id) {
        Advertisement advertisement = advertisementDao.findById(id);
        if (advertisement == null) {
            return null;
        }
        return mapAdvertisementToAdvertisementResultDto(advertisement);
    }

    @Transactional
    @Override
    public AdvertisementDto save(AdvertisementDto advertisementDto) {
        Advertisement advertisement = mapAdvertisementDtoToAdvertisement(advertisementDto);
        Advertisement advertisementSaved = advertisementDao.save(advertisement);
        return mapAdvertisementToAdvertisementResultDto(advertisementSaved);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        advertisementDao.deleteById(id);
    }

    AdvertisementResultDto mapAdvertisementToAdvertisementResultDto(Advertisement advertisement) {
        AdvertisementResultDto advertisementDto = new AdvertisementResultDto();
        advertisementDto.setCity(advertisement.getCity());
        advertisementDto.setCountry(advertisement.getCountry());
        advertisementDto.setDescription(advertisement.getDescription());
        advertisementDto.setId(advertisement.getId());
        advertisementDto.setAddress(advertisement.getAddress());
        advertisementDto.setSize(advertisement.getSize());
        advertisementDto.setTitle(advertisement.getTitle());
        advertisementDto.setPrice(advertisement.getPrice());
        return advertisementDto;
    }

    Advertisement mapAdvertisementDtoToAdvertisement(AdvertisementDto advertisementDto) {
        Advertisement advertisement = new Advertisement();
        advertisement.setCity(advertisementDto.getCity());
        advertisement.setCountry(advertisementDto.getCountry());
        advertisement.setDescription(advertisementDto.getDescription());
        advertisement.setAddress(advertisementDto.getAddress());
        advertisement.setSize(advertisementDto.getSize());
        advertisement.setTitle(advertisementDto.getTitle());
        advertisement.setPrice(advertisementDto.getPrice());
        return advertisement;
    }
}
