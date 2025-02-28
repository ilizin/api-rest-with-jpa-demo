package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Property;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PropertyDaoJpaImpl implements PropertyDao {

    private final EntityManager entityManager;

    public PropertyDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Property> findAll() {
        TypedQuery<Property> query = entityManager.createQuery("from Property", Property.class);
        return query.getResultList();
    }

    @Override
    public Property findBId(int id) {
        return entityManager.find(Property.class, id);
    }

    /* We don't use @Transactional at DAO layer, it will be handled at service layer. When you're making use of DAOs
       and services together, the best practice is that, the DAO does not handle the transactional, instead, it's managed
       at the service layer. */
    @Override
    public Property save(Property property) {
        /* This save or update depending on the property id, if the id == 0 then insert/save else update
           Return the db property, it has updated id from the database (in case of insert) */
        return entityManager.merge(property);
    }

    @Override
    public void deleteById(int id) {
        Property property = findBId(id);
        entityManager.remove(property);
    }
}
