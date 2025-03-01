package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Advertiser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertiserRepository extends JpaRepository<Advertiser, Integer> {
}
