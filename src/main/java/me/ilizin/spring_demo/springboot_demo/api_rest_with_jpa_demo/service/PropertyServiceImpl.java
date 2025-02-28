package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.service;

import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao.PropertyDao;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Property;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyDao propertyDao;

    public PropertyServiceImpl(PropertyDao propertyDao) {
        this.propertyDao = propertyDao;
    }

    @Override
    public List<Property> findAll() {
        return propertyDao.findAll();
    }

    @Override
    public Property findBId(int id) {
        return propertyDao.findBId(id);
    }

    @Transactional
    @Override
    public Property save(Property property) {
        return propertyDao.save(property);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        propertyDao.deleteById(id);
    }
}
