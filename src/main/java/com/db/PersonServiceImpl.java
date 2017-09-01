package com.db;

import lombok.SneakyThrows;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Evegeny on 01/09/2017.
 */
@Service
@Transactional(timeout = 2000, isolation = Isolation.READ_UNCOMMITTED)
public class PersonServiceImpl implements PersonService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Person person) {
        entityManager.persist(person);
        person.setName("Kolya");

    }

    @Override
    @SneakyThrows
    public List<Person> findByName(String name) {
        Query query = entityManager.createQuery("from Person p where p.name=:name");
        query.setParameter("name", name);
        List<Person> resultList = query.getResultList();

        for (Person person : resultList) {
            person.setName("dsfsde");
        }
        return resultList;
    }
}
















