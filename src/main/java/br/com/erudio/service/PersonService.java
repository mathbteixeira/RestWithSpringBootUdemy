package br.com.erudio.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Matheus");
		person.setLastName("Teixeira");
		person.setAddress("Tv. Israel 183, FRG");
		person.setGender("Male");
		return person;
	}
	
}
