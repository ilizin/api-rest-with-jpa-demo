package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.services;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao.AdvertiserRepository;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.AdvertiserOutDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto.AdvertiserInDto;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity.Advertiser;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.AdvertiserType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertiserServiceImpl implements AdvertiserService {

    private final AdvertiserRepository advertiserRepository;

    public AdvertiserServiceImpl(AdvertiserRepository advertiserRepository) {
        this.advertiserRepository = advertiserRepository;
    }

    @Override
    public List<AdvertiserOutDto> findAll() {
        List<Advertiser> advertisers = advertiserRepository.findAll();
        return advertisers.stream()
                .map(this::mapAdvertiserToAdvertiserDto)
                .toList();
    }

    @Override
    public AdvertiserOutDto findById(int id) {
        Optional<Advertiser> optionalAdvertiser = advertiserRepository.findById(id);
        Advertiser advertiser = null;
        if (optionalAdvertiser.isPresent()) {
            advertiser = optionalAdvertiser.get();
            return mapAdvertiserToAdvertiserDto(advertiser);
        }
        return null;
    }

    // We can remove @Transactional because JPA repository provides this functionality
    //@Transactional
    @Override
    public AdvertiserOutDto save(AdvertiserInDto advertiserDto) {
        Advertiser advertiser = mapAdvertiserDtoToAdvertiser(advertiserDto);
        advertiser = advertiserRepository.save(advertiser);
        return mapAdvertiserToAdvertiserDto(advertiser);
    }

    @Override
    public AdvertiserOutDto update(AdvertiserInDto advertiserDto, int advertiserId) {
        Advertiser advertiser = mapAdvertiserDtoToAdvertiser(advertiserDto);
        advertiser.setId(advertiserId);
        advertiser = advertiserRepository.save(advertiser);
        return mapAdvertiserToAdvertiserDto(advertiser);
    }

    //@Transactional
    @Override
    public void deleteById(int id) {
        advertiserRepository.deleteById(id);
    }

    AdvertiserOutDto mapAdvertiserToAdvertiserDto(Advertiser advertiser) {
        AdvertiserOutDto advertiserDto = new AdvertiserOutDto();
        advertiserDto.setAdvertiserType(AdvertiserType.valueOf(advertiser.getAdvertiserType()));
        advertiserDto.setEmail(advertiser.getEmail());
        advertiserDto.setFirstSurname(advertiser.getFirstSurname());
        advertiserDto.setSecondSurname(advertiser.getSecondSurname());
        advertiserDto.setName(advertiser.getName());
        advertiserDto.setId(advertiser.getId());
        advertiserDto.setPhoneNumber(advertiser.getPhoneNumber());
        return advertiserDto;
    }

    Advertiser mapAdvertiserDtoToAdvertiser(AdvertiserInDto advertiserDto) {
        Advertiser advertiser = new Advertiser();
        advertiser.setAdvertiserType(advertiserDto.getAdvertiserType().toString());
        advertiser.setEmail(advertiserDto.getEmail());
        advertiser.setFirstSurname(advertiserDto.getFirstSurname());
        advertiser.setSecondSurname(advertiserDto.getSecondSurname());
        advertiser.setName(advertiserDto.getName());
        advertiser.setPhoneNumber(advertiserDto.getPhoneNumber());
        return advertiser;
    }
}
