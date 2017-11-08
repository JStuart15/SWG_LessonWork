package com.sg.sps;

import com.sg.sps.model.User;
import com.sg.sps.repository.UserRepository;
import java.time.LocalDateTime;
import javafx.application.Application;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpsApplication {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Application.class);
    @Autowired
    UserRepository users;

    public static void main(String[] args) {
        SpringApplication.run(SpsApplication.class, args);

    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new User("steve@aol.com",
                    "Steve",
                    "Case",
                    "password",
                    LocalDateTime.now(),
                    LocalDateTime.now()));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");
        };
    }
}
