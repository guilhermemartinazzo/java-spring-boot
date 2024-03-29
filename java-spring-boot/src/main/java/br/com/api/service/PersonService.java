package br.com.api.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.api.entity.Person;
import br.com.api.exception.ResourceNotFoundException;
import br.com.api.mapper.Mapper;
import br.com.api.mapper.custom.PersonMapper;
import br.com.api.repository.PersonRepository;
import br.com.api.vo.PersonVO;
import br.com.api.vo.v2.PersonVO2;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

	private static final String PERSON_NOT_FOUND = "Person Not Found";
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	private final PersonRepository personRepository;
	private final Mapper mapper;
	private final PersonMapper personMapper;


	public PersonVO findById(Long id) {
		logger.info("Finding person by id");
		var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(PERSON_NOT_FOUND));
		return mapper.parseObject(entity, PersonVO.class);
	}

	public List<PersonVO> findAll() {
		logger.info("Finding all people");
		return mapper.parseListObjects(personRepository.findAll(), PersonVO.class);
	}

	@Transactional
	public PersonVO create(PersonVO person) {
		logger.info("Creating a person");
		Person personEntity = mapper.parseObject(person, Person.class);
		return mapper.parseObject(personRepository.save(personEntity), PersonVO.class);
	}
	
	@Transactional
	public PersonVO2 createV2(PersonVO2 person) {
		logger.info("Creating a person v2");
		Person entity = personMapper.convertVOToEntity(person);
		return personMapper.convertEntityToVO(personRepository.save(entity));
	}

	@Transactional
	public PersonVO update(PersonVO person) {
		logger.info("Updating a person");
		var personEntity = personRepository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException(PERSON_NOT_FOUND));
		personEntity.setFirstName(person.getFirstName());
		personEntity.setLastName(person.getLastName());
		personEntity.setAddress(person.getAddress());
		personEntity.setGender(person.getGender());
		Person save = personRepository.save(personEntity);
		return mapper.parseObject(save, PersonVO.class);
	}

	public void delete(Long id) {
		logger.info("Deleting a person");
		var personEntity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(PERSON_NOT_FOUND));
		personRepository.delete(personEntity);
	}

}
