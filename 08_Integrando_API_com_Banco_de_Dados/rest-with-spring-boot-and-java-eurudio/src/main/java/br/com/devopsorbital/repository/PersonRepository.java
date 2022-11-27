package br.com.devopsorbital.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devopsorbital.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
