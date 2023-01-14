package br.com.restlabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.restlabs.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
