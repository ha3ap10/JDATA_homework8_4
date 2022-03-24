package ru.netology.jdata_homework8_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.jdata_homework8_4.model.Person;
import ru.netology.jdata_homework8_4.model.Persons;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Persons, Person> {

    List<Persons> findPersonsByCityOfLiving(String city);

    List<Persons> findPersonsByPersonAgeLessThan(int age);

    Optional<List<Persons>> findPersonsByPersonNameAndPersonSurname(String name, String surname);


}
