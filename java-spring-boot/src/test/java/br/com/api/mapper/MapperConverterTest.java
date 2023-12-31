package br.com.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.api.entity.Person;
import br.com.api.mapper.mock.MockPerson;
import br.com.api.vo.PersonVO;

@ExtendWith(SpringExtension.class)
class MapperConverterTest {

	private MockPerson inputObject;

	@InjectMocks
	private Mapper mapper;

	@Spy
	private ModelMapper modelMapper;

	@BeforeEach
	public void setUp() {
		inputObject = new MockPerson();
	}

	@Test
	void parseEntityToVOTest() {
		PersonVO output = mapper.parseObject(inputObject.mockEntity(), PersonVO.class);
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("First Name Test0", output.getFirstName());
		assertEquals("Last Name Test0", output.getLastName());
		assertEquals("Addres Test0", output.getAddress());
		assertEquals("Male", output.getGender());
	}

	@Test
	void parseEntityListToVOListTest() {
		List<PersonVO> outputList = mapper.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
		PersonVO outputZero = outputList.get(0);

		assertEquals(Long.valueOf(0L), outputZero.getId());
		assertEquals("First Name Test0", outputZero.getFirstName());
		assertEquals("Last Name Test0", outputZero.getLastName());
		assertEquals("Addres Test0", outputZero.getAddress());
		assertEquals("Male", outputZero.getGender());

		PersonVO outputSeven = outputList.get(7);

		assertEquals(Long.valueOf(7L), outputSeven.getId());
		assertEquals("First Name Test7", outputSeven.getFirstName());
		assertEquals("Last Name Test7", outputSeven.getLastName());
		assertEquals("Addres Test7", outputSeven.getAddress());
		assertEquals("Female", outputSeven.getGender());

		PersonVO outputTwelve = outputList.get(12);

		assertEquals(Long.valueOf(12L), outputTwelve.getId());
		assertEquals("First Name Test12", outputTwelve.getFirstName());
		assertEquals("Last Name Test12", outputTwelve.getLastName());
		assertEquals("Addres Test12", outputTwelve.getAddress());
		assertEquals("Male", outputTwelve.getGender());
	}

	@Test
	void parseVOToEntityTest() {
		Person output = mapper.parseObject(inputObject.mockVO(), Person.class);
		assertEquals(Long.valueOf(0L), output.getId());
		assertEquals("First Name Test0", output.getFirstName());
		assertEquals("Last Name Test0", output.getLastName());
		assertEquals("Addres Test0", output.getAddress());
		assertEquals("Male", output.getGender());
	}

	@Test
	void parserVOListToEntityListTest() {
		List<Person> outputList = mapper.parseListObjects(inputObject.mockVOList(), Person.class);
		Person outputZero = outputList.get(0);

		assertEquals(Long.valueOf(0L), outputZero.getId());
		assertEquals("First Name Test0", outputZero.getFirstName());
		assertEquals("Last Name Test0", outputZero.getLastName());
		assertEquals("Addres Test0", outputZero.getAddress());
		assertEquals("Male", outputZero.getGender());

		Person outputSeven = outputList.get(7);

		assertEquals(Long.valueOf(7L), outputSeven.getId());
		assertEquals("First Name Test7", outputSeven.getFirstName());
		assertEquals("Last Name Test7", outputSeven.getLastName());
		assertEquals("Addres Test7", outputSeven.getAddress());
		assertEquals("Female", outputSeven.getGender());

		Person outputTwelve = outputList.get(12);

		assertEquals(Long.valueOf(12L), outputTwelve.getId());
		assertEquals("First Name Test12", outputTwelve.getFirstName());
		assertEquals("Last Name Test12", outputTwelve.getLastName());
		assertEquals("Addres Test12", outputTwelve.getAddress());
		assertEquals("Male", outputTwelve.getGender());
	}
}
