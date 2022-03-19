package ru.netology.jdata_homework8_4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdata_homework8_4.model.Persons;
import ru.netology.jdata_homework8_4.repository.Repository;

import java.util.List;

@RequestMapping("/persons")
@RestController
public class Controller {

    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city) {
        return repository.getPersonsByCity(city);
    }
}
