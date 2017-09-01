package com.db;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Evegeny on 01/09/2017.
 */
@Entity
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Event> events = new ArrayList<>();

    public void addEvents(Event... events) {
        this.events.addAll(Arrays.asList(events));
    }

    private String name;


    public Person(String name) {
        this.name = name;
    }
}


