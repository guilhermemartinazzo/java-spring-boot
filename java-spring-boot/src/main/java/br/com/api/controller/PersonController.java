package br.com.api.controller;

import br.com.api.service.PersonService;
import br.com.api.utils.MediaTypeUtils;
import br.com.api.vo.PersonVO;
import br.com.api.vo.v2.PersonVO2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    private final PersonService personService;

    PersonController(PersonService service) {
        this.personService = service;
    }

    @GetMapping(produces = {MediaTypeUtils.APPLICATION_JSON, MediaTypeUtils.APPLICATION_XML, MediaTypeUtils.APPLICATION_YML}, value = "/{personId}")
    public ResponseEntity<PersonVO> findById(@PathVariable(name = "personId") Long personId) {
        return ResponseEntity.ok(personService.findById(personId));
    }

    @GetMapping(produces = {MediaTypeUtils.APPLICATION_JSON, MediaTypeUtils.APPLICATION_XML, MediaTypeUtils.APPLICATION_YML})
    public ResponseEntity<List<PersonVO>> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @PostMapping(produces = {MediaTypeUtils.APPLICATION_JSON, MediaTypeUtils.APPLICATION_XML, MediaTypeUtils.APPLICATION_YML},
            consumes = {MediaTypeUtils.APPLICATION_JSON, MediaTypeUtils.APPLICATION_XML, MediaTypeUtils.APPLICATION_YML})
    public ResponseEntity<PersonVO> create(@RequestBody PersonVO person) {
        return ResponseEntity.ok(personService.create(person));
    }

    @PutMapping(produces = {MediaTypeUtils.APPLICATION_JSON, MediaTypeUtils.APPLICATION_XML, MediaTypeUtils.APPLICATION_YML},
            consumes = {MediaTypeUtils.APPLICATION_JSON, MediaTypeUtils.APPLICATION_XML, MediaTypeUtils.APPLICATION_YML})
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

    @PostMapping(value = "/v2",
            produces = {MediaTypeUtils.APPLICATION_JSON, MediaTypeUtils.APPLICATION_XML, MediaTypeUtils.APPLICATION_YML},
            consumes = {MediaTypeUtils.APPLICATION_JSON, MediaTypeUtils.APPLICATION_XML, MediaTypeUtils.APPLICATION_YML})
    public ResponseEntity<PersonVO2> createV2(@RequestBody PersonVO2 person) {
        return ResponseEntity.ok(personService.createV2(person));
    }

}
