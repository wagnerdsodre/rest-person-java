package br.com.restlabs.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restlabs.models.Person;
import br.com.restlabs.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@GetMapping(			
			produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Person> findAll() throws Exception {
		return service.findAll() ;
	}	
	
	@GetMapping(
			value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE )
	public Person findById(
			@PathVariable(value = "id") Long id) throws Exception {
		return service.findById(id) ;
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE )
	public Person CreatePerson(	@RequestBody Person person) throws Exception {
		return service.PostPerson(person) ;
	}
	
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE )
	public Person PersonUpdate(
			@RequestBody Person person) throws Exception {
		return service.UpdatePerson(person);
	}
	
	@DeleteMapping(	value = "/{id}")
	public ResponseEntity<?> DeletePerson(
			@PathVariable(value = "id") Long id) throws Exception {
		service.DeletePerson(id) ;
		return ResponseEntity.noContent().build();
	}

	

}
