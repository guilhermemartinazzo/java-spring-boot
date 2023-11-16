package br.com.api.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.api.entity.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public Person findById(Long id) {
		logger.info("Finding person by id");
		Person person = buildPersonMock();
		return person;
	}

	public List<Person> findAll() {
		logger.info("Finding all people");
		return List.of(buildPersonMock(), buildPersonMock(), buildPersonMock(), buildPersonMock(), buildPersonMock(),
				buildPersonMock(), buildPersonMock(), buildPersonMock());

	}

	public Person create(Person person) {
		logger.info("Creating a person");
		return person;
	}

	public Person update(Person person) {
		logger.info("Updating a person");
		return person;
	}

	public void delete(Long id) {
		logger.info("Deleting a person");
	}

	private Person buildPersonMock() {
		Person person = new Person();
		long id = counter.incrementAndGet();
		person.setId(id);
		person.setFirstName("Person name " + id);
		person.setLastName("Last name " + id);
		person.setAddress("Some address in Brazil " + id);
		person.setGender("Male");
		return person;
	}
}
