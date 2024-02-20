package com.example.javateam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JavaTeamApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaTeamApplication.class, args);
    }

}
