package br.com.api.mapper.custom;

import java.sql.Date;
import java.time.Instant;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.api.entity.Person;
import br.com.api.vo.v2.PersonVO2;

@Component
public class PersonMapper {

	
	public Person convertVOToEntity(PersonVO2 vo) {
		Person entity = new Person();
		entity.setAddress(vo.getAddress());
		entity.setFirstName(vo.getFirstName());
		entity.setGender(vo.getGender());
		entity.setLastName(vo.getLastName());
		entity.setId(vo.getId());
		BeanUtils.copyProperties(vo, entity, "birthDay");
		return entity;
	}
	
	public PersonVO2 convertEntityToVO(Person person) {
		PersonVO2 vo = new PersonVO2();
		BeanUtils.copyProperties(person, vo);
		vo.setBirthDay(Date.from(Instant.now()));
		return vo;
	}
}
