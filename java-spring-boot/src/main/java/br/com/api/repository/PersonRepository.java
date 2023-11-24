package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

}
