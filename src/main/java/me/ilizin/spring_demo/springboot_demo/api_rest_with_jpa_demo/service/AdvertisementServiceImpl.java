package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao.AdvertisementDao;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.PropertyInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto.PropertyOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Property;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements PropertyService {

    private final AdvertisementDao advertisementDao;

    public AdvertisementServiceImpl(AdvertisementDao advertisementDao) {
        this.advertisementDao = advertisementDao;
    }

    @Override
    public List<PropertyOutDto> findAll() {
        List<Property> advertisements = advertisementDao.findAll();
        return advertisements
                .stream()
                .map(this::mapAdvertisementToAdvertisementResultDto)
                .toList();
    }

    @Override
    public PropertyOutDto findById(int id) {
        Property advertisement = advertisementDao.findById(id);
        if (advertisement == null) {
            return null;
        }
        return mapAdvertisementToAdvertisementResultDto(advertisement);
    }

    @Transactional
    @Override
    public PropertyOutDto save(PropertyInDto advertisementDto) {
        Property advertisement = mapAdvertisementDtoToAdvertisement(advertisementDto);
        Property advertisementSaved = advertisementDao.save(advertisement);
        return mapAdvertisementToAdvertisementResultDto(advertisementSaved);
    }

    @Transactional
    @Override
    public PropertyOutDto update(PropertyInDto property, int advertisementId) {
        Property advertisement = mapAdvertisementDtoToAdvertisement(property);
        advertisement.setId(advertisementId);
        Property advertisementSaved = advertisementDao.save(advertisement);
        return mapAdvertisementToAdvertisementResultDto(advertisementSaved);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        advertisementDao.deleteById(id);
    }

    PropertyOutDto mapAdvertisementToAdvertisementResultDto(Property advertisement) {
        PropertyOutDto advertisementDto = new PropertyOutDto();
        advertisementDto.setProvince(advertisement.getProvince());
        advertisementDto.setMunicipality(advertisement.getMunicipality());
        advertisementDto.setCountry(advertisement.getCountry());
        advertisementDto.setDescription(advertisement.getDescription());
        advertisementDto.setId(advertisement.getId());
        advertisementDto.setAddress(advertisement.getAddress());
        advertisementDto.setSize(advertisement.getSize());
        advertisementDto.setTitle(advertisement.getTitle());
        advertisementDto.setPrice(advertisement.getPrice());
        return advertisementDto;
    }

    Property mapAdvertisementDtoToAdvertisement(PropertyInDto advertisementDto) {
        Property advertisement = new Property();
        advertisement.setProvince(advertisementDto.getProvince());
        advertisement.setMunicipality(advertisementDto.getMunicipality());
        advertisement.setCountry(advertisementDto.getCountry());
        advertisement.setDescription(advertisementDto.getDescription());
        advertisement.setAddress(advertisementDto.getAddress());
        advertisement.setSize(advertisementDto.getSize());
        advertisement.setTitle(advertisementDto.getTitle());
        advertisement.setPrice(advertisementDto.getPrice());
        return advertisement;
    }
}
