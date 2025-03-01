package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao.AdvertiserRepository;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Advertiser;
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
    public List<Advertiser> findAll() {
        return advertiserRepository.findAll();
    }

    @Override
    public Advertiser findById(int id) {
        Optional<Advertiser> optionalAdvertiser = advertiserRepository.findById(id);
        Advertiser advertiser = null;
        if (optionalAdvertiser.isPresent()) {
            advertiser = optionalAdvertiser.get();
        }
        return advertiser;
    }

    // We can remove @Transactional because JPA repository provides this functionality
    //@Transactional
    @Override
    public Advertiser save(Advertiser advertiser) {
        return advertiserRepository.save(advertiser);
    }

    //@Transactional
    @Override
    public void deleteById(int id) {
        advertiserRepository.deleteById(id);
    }
}
