package fr.sdv.m1dev2425.demodatarest.dal;

import fr.sdv.m1dev2425.demodatarest.bo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    private PersonRepository dao;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public PersonRepositoryTest(PersonRepository dao, PasswordEncoder passwordEncoder) {
        this.dao = dao;
        this.passwordEncoder = passwordEncoder;
    }

    @Test
    public void testSave() {
        //A => Arrangement
        Person person = new Person("Séga", "SYLLA");
        System.out.println("#"+passwordEncoder.encode("SYLLA")+"#");

        //A => Action
        Person savedPerson = dao.save(person);

        //A => Assertion
        assertEquals(savedPerson.getId(), person.getId());
    }
}