package br.com.erudio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Matheus");
		person.setLastName("Teixeira");
		person.setAddress("Tv. Israel 183, FRG");
		person.setGender("Male");
		return person;
	}
	
	public List<Person> findAll() {
		List<Person> personList = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			personList.add(person);
		}
		return personList;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person Name" + i);
		person.setLastName("Last Name" + i);
		person.setAddress("Address in Brazil" + i);
		person.setGender("Male" + i);
		return person;
	}
	
}
