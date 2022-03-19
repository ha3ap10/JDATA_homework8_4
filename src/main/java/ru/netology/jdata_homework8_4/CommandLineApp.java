package ru.netology.jdata_homework8_4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.jdata_homework8_4.model.Person;
import ru.netology.jdata_homework8_4.model.Persons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class CommandLineApp implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var names = List.of("Alexey", "Vasya", "Ivan", "Petya", "Oleg", "Sidor");
        var surnames = List.of("Ivanov", "Petrov", "Sidorov", "Vasilev");
        var cities = List.of("MSK", "NN", "StP");
        var random = new Random();
        IntStream.range(0, 20)
                .forEach(i -> {
                    var persons = Persons.builder()
                            .person(Person.builder()
                                    .name(names.get(random.nextInt(names.size())))
                                    .surname(surnames.get(random.nextInt(surnames.size())))
                                    .age(random.nextInt(50))
                                    .build())
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .phoneNumber(89095653236L)
                            .build();

                    entityManager.persist(persons);
                });
    }
}
