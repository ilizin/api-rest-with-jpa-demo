package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity.Advertisement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdvertisementDaoJpaImpl implements AdvertisementDao {

    private final EntityManager entityManager;

    public AdvertisementDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Advertisement> findAll() {
        TypedQuery<Advertisement> query = entityManager.createQuery("from Advertisement", Advertisement.class);
        return query.getResultList();
    }

    @Override
    public Advertisement findById(int id) {
        return entityManager.find(Advertisement.class, id);
    }

    /* We don't use @Transactional at DAO layer, it will be handled at service layer. When you're making use of DAOs
       and services together, the best practice is that, the DAO does not handle the transactional, instead, it's managed
       at the service layer. */
    @Override
    public Advertisement save(Advertisement property) {
        /* This save or update depending on the property id, if the id == 0 then insert/save else update
           Return the db property, it has updated id from the database (in case of insert) */
        return entityManager.merge(property);
    }

    @Override
    public void deleteById(int id) {
        Advertisement property = findById(id);
        entityManager.remove(property);
    }
}
