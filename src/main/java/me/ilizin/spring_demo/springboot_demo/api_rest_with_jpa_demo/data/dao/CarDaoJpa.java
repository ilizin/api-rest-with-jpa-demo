package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.data.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoJpa implements ICarDao {

    @Autowired
    private final EntityManager entityManager;

    public CarDaoJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Car> findAll() {
        TypedQuery<Car> query = entityManager.createQuery("from Car", Car.class);
        return query.getResultList();
    }

    @Override
    public Car findById(int id) {
        return entityManager.find(Car.class, id);
    }

    /* We don't use @Transactional at DAO layer, it will be handled at service layer. When you're making use of DAOs
       and services together, the best practice is that, the DAO does not handle the transactional, instead, it's managed
       at the service layer. */
    @Override
    public Car save(Car car) {
        /* This save or update depending on the property id, if the id == 0 then insert/save else update
           Return the db property, it has updated id from the database (in case of insert) */
        return entityManager.merge(car);
    }

    @Override
    public void deleteById(int id) {
        Car car = findById(id);
        entityManager.remove(car);
    }
}
