package ek.alss.tek2eksamen;

import ek.alss.tek2eksamen.model.Person;
import ek.alss.tek2eksamen.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tek2EksamenApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tek2EksamenApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(PersonRepository repository) {
        return args -> {
            repository.save(new Person(null,"Alice"));
            repository.save(new Person(null,"Bob"));
        };
    }
}
