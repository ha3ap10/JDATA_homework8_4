package ru.netology.jdata_homework8_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.netology.jdata_homework8_4.model.Person;
import ru.netology.jdata_homework8_4.model.Persons;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Persons, Person> {

    @Query("select p from Persons p where p.cityOfLiving = :city")
    List<Persons> findPersonsByCityOfLiving(@Param("city") String city);

    @Query("select p from Persons p where p.person.age < :age")
    List<Persons> findPersonsByPersonAgeLessThan(@Param("age") int age);

    @Query("select p from Persons p where p.person.name = :pName and p.person.surname = :pSurname")
    Optional<List<Persons>> findPersonsByPersonNameAndPersonSurname(@Param("pName") String name,
                                                                    @Param("pSurname") String surname);


}
