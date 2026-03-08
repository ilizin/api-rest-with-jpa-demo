package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.data.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MotorcycleCustomRepositoryImpl implements MotorcycleCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createQuery("from Vehicle where vehicleType = 'MOTORCYCLE'", Vehicle.class);
        return query.getResultList();
    }
}
