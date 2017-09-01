package com.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
public class DemoSpringBootDbApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoSpringBootDbApplication.class, args);
		PersonService personService = context.getBean(PersonService.class);
		Person vasya = new Person("Vasya");
		vasya.addEvents(new Event("AAA"),new Event("BBB"));
		personService.save(vasya);

		List<Person> people = personService.findByName("Vasya");
		for (Person person : people) {
			System.out.println("person = " + person);
		}
	}
}
