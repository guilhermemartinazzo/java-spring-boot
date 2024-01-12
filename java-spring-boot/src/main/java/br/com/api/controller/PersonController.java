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

import br.com.api.service.PersonService;
import br.com.api.vo.PersonVO;
import br.com.api.vo.v2.PersonVO2;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	private final PersonService personService;

	PersonController(PersonService service) {
		this.personService = service;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{personId}")
	public ResponseEntity<PersonVO> findById(@PathVariable(name = "personId") Long personId) {
		return ResponseEntity.ok(personService.findById(personId));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersonVO>> findAll() {
		return ResponseEntity.ok(personService.findAll());
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonVO> create(@RequestBody PersonVO person) {
		return ResponseEntity.ok(personService.create(person));
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonVO> update(@RequestBody PersonVO person) {
		return ResponseEntity.ok(personService.update(person));
	}

	@DeleteMapping("/{personId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "personId") Long personId) {
		personService.delete(personId);
	}
	
	/**
	 * V2
	 */
	
	@PostMapping(value = "/v2", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonVO2> createV2(@RequestBody PersonVO2 person) {
		return ResponseEntity.ok(personService.createV2(person));
	}
	
}
