package br.com.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.entity.Person;
import br.com.api.service.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	private final PersonService personService;

	PersonController(PersonService service) {
		this.personService = service;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{personId}")
	public ResponseEntity<Person> findById(@PathVariable(name = "personId") Long personId) {
		return ResponseEntity.ok(personService.findById(personId));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> findById() {
		return ResponseEntity.ok(personService.findAll());
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> create(@RequestBody Person person) {
		return ResponseEntity.ok(personService.create(person));
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> update(@RequestBody Person person) {
		return ResponseEntity.ok(personService.update(person));
	}

	@DeleteMapping("/{personId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "personId") Long personId) {
		personService.delete(personId);
	}
}
