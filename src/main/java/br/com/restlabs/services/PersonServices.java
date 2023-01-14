package br.com.restlabs.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restlabs.exceptions.ResourceNotFoundException;
import br.com.restlabs.models.Person;
import br.com.restlabs.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<Person> findAll() {
		logger.info("Return all person");
		return repository.findAll();
	}

	public Person findById(Long id) {
		logger.info("Return person");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sorry, no records for this Id"));
	}

	public Person PostPerson(Person person) {
		return repository.save(person);
	}

	public Person UpdatePerson(Person person) {
		logger.info("Updated person");
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Sorry, no records for this Id"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(entity);
	}

	public void DeletePerson(Long id) {
		logger.info("Delete person");
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sorry, no records for this Id"));

		repository.delete(entity);

	}

}
