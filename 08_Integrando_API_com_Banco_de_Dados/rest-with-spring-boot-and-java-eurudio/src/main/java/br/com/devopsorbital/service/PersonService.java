package br.com.devopsorbital.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devopsorbital.exceptions.ResourceNotFoundException;
import br.com.devopsorbital.model.Person;
import br.com.devopsorbital.repository.PersonRepository;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	private PersonRepository personRepository;

	public List<Person> findAll(){
		logger.info("Finding all people!");
		return personRepository.findAll();
	}
	
	public Person findById(Long id) {
		logger.info("Finding one person!");
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
	}	
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return personRepository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		
		var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return personRepository.save(entity);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");
		var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No record found for this ID!"));
		personRepository.delete(entity);
	}
}
