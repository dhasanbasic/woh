package de.disoft.wor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.disoft.wor.service.WoRConfiguration;

@SpringBootApplication
public class WoRApplication {
    @Autowired
    private WoRConfiguration configuration;

    public static void main(String[] args) {
        SpringApplication.run(WoRApplication.class, args);
    }

    @Bean
    CommandLineRunner testJson() {
        return args -> {
            System.out.println("--------------------\nRACES\n-------------------");
            configuration.getRaces().values().stream().forEach(r -> System.out.println(r));
            System.out.println();

            System.out.println("--------------------\nCARDS\n-------------------");
            configuration.getCards().getAll().stream().forEach(c -> {
                System.out.print(c.getClass().getSimpleName() + ": ");
                System.out.println(c);
            });
            System.out.println();


        };
    }
}
