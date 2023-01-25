package br.com.restlabs.controllers;


import java.util.List;

import br.com.restlabs.util.MediaTypes;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restlabs.data.vo.v1.PersonVO;
import br.com.restlabs.data.vo.v2.PersonVOV2;
import br.com.restlabs.services.PersonServices;

@RestController
@RequestMapping("/person/v1")
public class PersonController {

	@Autowired
	private PersonServices service;

	@GetMapping(produces = {MediaTypes.typeJson,MediaTypes.typeXML,MediaTypes.typeYaml} )
	public List<PersonVO> findAll() throws Exception {
		return service.findAll() ;
	}

	@GetMapping( value = "/{id}",
			produces = {MediaTypes.typeJson, MediaTypes.typeXML, MediaTypes.typeYaml} )
	public PersonVO findById(
			@PathVariable(value = "id") Long id) throws Exception {
		return service.findById(id) ;
	}

	@PostMapping(consumes = { MediaTypes.typeJson, MediaTypes.typeXML,MediaTypes.typeYaml},
			     produces = { MediaTypes.typeJson, MediaTypes.typeXML,MediaTypes.typeYaml} )
	public PersonVO CreatePerson(	@RequestBody PersonVO Person) throws Exception {
		return service.PostPerson(Person) ;
	}

	@PostMapping(
			value= "/v2",
			consumes = {MediaTypes.typeJson, MediaTypes.typeXML,MediaTypes.typeYaml},
			produces = {MediaTypes.typeJson, MediaTypes.typeXML,MediaTypes.typeYaml})
	public PersonVOV2 CreatePersonv2(@RequestBody PersonVOV2 Person) throws Exception {
		return service.PostPersonV2(Person) ;
	}

	@PutMapping(consumes = {MediaTypes.typeJson, MediaTypes.typeXML,MediaTypes.typeYaml},
			produces = {MediaTypes.typeJson, MediaTypes.typeXML,MediaTypes.typeYaml} )
	public PersonVO PersonUpdate(
			@RequestBody PersonVO Person) throws Exception {
		return service.UpdatePerson(Person);
	}
	
	@DeleteMapping(	value = "/{id}")
	public ResponseEntity<?> DeletePerson(
			@PathVariable(value = "id") Long id) throws Exception {
		service.DeletePerson(id) ;
		return ResponseEntity.noContent().build();
	}

	

}
