package com.fahreza.amigoscode.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student andy = new Student(
                    "Andy",
                    LocalDate.of(2000, 5, 1)
            );

            Student brandy = new Student(
                    "Brandy",
                    LocalDate.of(2002, 5, 1)
            );

            studentRepository.saveAll(
                    List.of(andy, brandy)
            );
        };

    }
}
