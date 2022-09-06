package com.example.demo.Item;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner commandLineRunner(
        ItemRepository repository) {
            return args -> {
                Item jacket = new Item(
                    "Jacket",
                    "Winter Jacket",
                    LocalDate.of(2022, Month.JULY, 5),
                    1000
                );

                Item pants = new Item(
                    "pants",
                    "Winter Pants",
                    LocalDate.of(2022, Month.JULY, 3),
                    500
                );
                
                repository.save(jacket);
                repository.save(pants);
            };
        }
    
}