package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao.AdvertisementDao;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.AdvertisementDto;
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
    public List<AdvertisementDto> findAll() {
        List<Advertisement> advertisements = advertisementDao.findAll();
        return advertisements
                .stream()
                .map(this::mapAdvertisementToAdvertisementDto)
                .toList();
    }

    @Override
    public AdvertisementDto findById(int id) {
        Advertisement advertisement = advertisementDao.findById(id);
        return mapAdvertisementToAdvertisementDto(advertisement);
    }

    @Transactional
    @Override
    public AdvertisementDto save(AdvertisementDto advertisementDto) {
        Advertisement advertisement = mapAdvertisementDtoToAdvertisement(advertisementDto);
        Advertisement advertisementSaved = advertisementDao.save(advertisement);
        return mapAdvertisementToAdvertisementDto(advertisementSaved);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        advertisementDao.deleteById(id);
    }

    AdvertisementDto mapAdvertisementToAdvertisementDto(Advertisement advertisement) {
        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setCity(advertisement.getCity());
        advertisementDto.setCountry(advertisement.getCountry());
        advertisementDto.setDescription(advertisement.getDescription());
        //advertisementDto.setId(advertisement.getId());
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
        //advertisement.setId(advertisementDto.getId());
        advertisement.setAddress(advertisementDto.getAddress());
        advertisement.setSize(advertisementDto.getSize());
        advertisement.setTitle(advertisementDto.getTitle());
        advertisement.setPrice(advertisementDto.getPrice());
        return advertisement;
    }
}
