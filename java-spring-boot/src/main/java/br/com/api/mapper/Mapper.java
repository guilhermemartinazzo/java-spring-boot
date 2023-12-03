package br.com.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

	private final ModelMapper modelMapper;

	public Mapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public <O, D> D parseObject(O origin, Class<D> destination) {
		return modelMapper.map(origin, destination);
	}

	public <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<>();
		origin.forEach(orig -> destinationObjects.add(modelMapper.map(orig, destination)));
		return destinationObjects;
	}
}
