package com.dev.Demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Basic;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student dev= new Student( "devrishi sherawat");
            Student hurry= new Student( "hurry prasad");
            Student burry= new Student( "burry prasad");
            repository.saveAll(List.of(dev, hurry,burry));
        };
    }
}
