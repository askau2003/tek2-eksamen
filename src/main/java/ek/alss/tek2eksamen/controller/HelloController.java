package ek.alss.tek2eksamen.controller;

import ek.alss.tek2eksamen.model.Person;
import ek.alss.tek2eksamen.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final PersonRepository personRepository;

    public HelloController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hej verden!";
    }

    @GetMapping("/hello/{id}")
    public String sayHello(@PathVariable Long id) {
        return personRepository.findById(id)
                .map(person -> "Hej " + person.getName() + "!")
                .orElse("Person ikke fundet");
    }
}
