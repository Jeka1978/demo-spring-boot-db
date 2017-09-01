package com.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Evegeny on 01/09/2017.
 */
@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    PersonService personService;
    @GetMapping("/ping")
    public Person ping() {

        return new Person("Anna");
    }


    @PostMapping("/save")
    public void handlePerson(@RequestBody Person person) {
        System.out.println("person = " + person);
    }














}
