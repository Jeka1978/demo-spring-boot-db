package com.db;

import java.util.List;

/**
 * Created by Evegeny on 01/09/2017.
 */
public interface PersonService {
    void save(Person person);

    List<Person> findByName(String name);
}
