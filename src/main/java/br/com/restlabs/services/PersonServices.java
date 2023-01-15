package br.com.restlabs.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restlabs.data.vo.v1.PersonVO;
import br.com.restlabs.exceptions.ResourceNotFoundException;
import br.com.restlabs.mapper.dozerMapper;
import br.com.restlabs.models.Person;
import br.com.restlabs.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<PersonVO> findAll() {
		logger.info("Return all person");
		return dozerMapper.parserListObject(repository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {
		logger.info("Return person");				
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sorry, no records for this Id"));
	    return dozerMapper.parserObject(entity, PersonVO.class);
	}

	public PersonVO PostPerson(PersonVO person) {
		var entity = dozerMapper.parserObject(person, Person.class);
		
		PersonVO vo =  dozerMapper.parserObject(repository.save(entity), PersonVO.class);
		return vo;
		
	}

	public PersonVO UpdatePerson(PersonVO person) {
		logger.info("Updated person");
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Sorry, no records for this Id"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		PersonVO vo =  dozerMapper.parserObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public void DeletePerson(Long id) {
		logger.info("Delete person");
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sorry, no records for this Id"));

		repository.delete(entity);

	}

}
