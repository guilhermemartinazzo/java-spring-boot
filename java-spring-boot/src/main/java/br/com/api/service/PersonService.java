package br.com.api.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.api.entity.Person;
import br.com.api.exception.ResourceNotFoundException;
import br.com.api.repository.PersonRepository;
import jakarta.transaction.Transactional;

@Service
public class PersonService {

	private Logger logger = Logger.getLogger(PersonService.class.getName());
	private final PersonRepository personRepository;

	PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public Person findById(Long id) {
		logger.info("Finding person by id");
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person Not Found"));
	}

	public List<Person> findAll() {
		logger.info("Finding all people");
		return personRepository.findAll();

	}

	@Transactional
	public Person create(Person person) {
		logger.info("Creating a person");
		return personRepository.save(person);
		
	}

	@Transactional
	public Person update(Person person) {
		logger.info("Updating a person");
		var personEntity = personRepository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Person Not Found"));
		personEntity.setFirstName(person.getFirstName());
		personEntity.setLastName(person.getLastName());
		personEntity.setAddress(person.getAddress());
		personEntity.setGender(person.getGender());
		Person save = personRepository.save(personEntity);
		return save;
	}

	public void delete(Long id) {
		logger.info("Deleting a person");
		var personEntity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person Not Found"));
		personRepository.delete(personEntity);
	}

}
