package br.com.api.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.api.entity.Person;
import br.com.api.vo.PersonVO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

	private final ModelMapper modelMapper;

	public Mapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public <O, D> D parseObject(O origin, Class<D> destination) {
		modelMapper.typeMap(Person.class, PersonVO.class).addMappings(mapper -> {
			mapper.map(src -> src.getId(), PersonVO::setKey);
		});
		modelMapper.typeMap(PersonVO.class, Person.class).addMappings(mapper -> {
			mapper.map(src -> src.getKey(), Person::setId);
		});
		return modelMapper.map(origin, destination);
	}

	public <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<>();
		origin.forEach(orig -> destinationObjects.add(parseObject(orig, destination)));
		return destinationObjects;
	}
}
