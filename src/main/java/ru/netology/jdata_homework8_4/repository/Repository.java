package ru.netology.jdata_homework8_4.repository;

import ru.netology.jdata_homework8_4.model.Persons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    public Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Persons> getPersonsByCity(String city) {
        return entityManager.createQuery("select p from Persons p where lower(p.cityOfLiving) = :city", Persons.class)
                .setParameter("city", city)
                .getResultList();
    }
}
