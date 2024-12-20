package fr.sdv.m1dev2425.demodatarest.dal;

import fr.sdv.m1dev2425.demodatarest.bo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "personnes", collectionResourceRel = "data")
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @RestResource(path = "by-name")
    List<Person> findByLastName(@Param("name")String lastName);
}
