package br.com.devopsorbital.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.devopsorbital.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public List<Person> findAll(){
		logger.info("Finding all people!");
		
		var persons = new ArrayList<Person>();
		for(int i = 0; i < 8; i++) {
			var person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	public Person findById(String id) {
		logger.info("Finding one person!");
		var person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Leandro");
		person.setLastName("Costa");
		person.setAddress("Uberlândia - Minas Gerais - Brasil");
		person.setGender("Male");
		return person;
	}	
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one person!");
	}
	
	private Person mockPerson(int i) {
		var person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Some address in Brasil " + i);
		person.setGender("Male");
		return person;
	}	
}
