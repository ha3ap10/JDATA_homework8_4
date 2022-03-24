package ru.netology.jdata_homework8_4.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.jdata_homework8_4.model.Person;
import ru.netology.jdata_homework8_4.model.Persons;
import ru.netology.jdata_homework8_4.repository.Repository;

import java.util.List;
import java.util.Optional;

@RequestMapping("/persons")
@RestController
public class Controller {

    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city) {
        return repository.findPersonsByCityOfLiving(city);
    }

    @GetMapping("/by-age-less-than")
    public List<Persons> getPersonsByAge(@RequestParam("age") int age) {
        return repository.findPersonsByPersonAgeLessThan(age);
    }

    @GetMapping("/by-name-surname")
    public Optional<List<Persons>> getPersonsByNameSurname(@RequestParam("name") String name,
                                           @RequestParam("surname") String surname) {
        return repository.findPersonsByPersonNameAndPersonSurname(name, surname);
    }

    @GetMapping("/all")
    public List<Persons> getPersonsAll() {
        return repository.findAll();
    }

    @GetMapping("/count")
    public long getCount() {
        return repository.count();
    }

    @PostMapping("/create")
    public Persons savePersons(@RequestBody Persons persons) {
        return repository.save(persons);
    }

    @DeleteMapping("/delete-person")
    public void deletePerson(@RequestBody Person person) {
        repository.deleteById(person);
    }

    @DeleteMapping("/delete-all")
    public void deleteAll() {
        repository.deleteAll();
    }
}

