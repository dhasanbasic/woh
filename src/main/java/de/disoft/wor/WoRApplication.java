package de.disoft.wor;

import de.disoft.wor.service.WoRConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WoRApplication {
    @Autowired
    private WoRConfiguration worConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(WoRApplication.class, args);
    }

    /*
    @Bean
    CommandLineRunner testJson() {
        return args -> {
            System.out.println("--------------------\nRACES\n-------------------");
            worConfiguration.getRaces().getAll().forEach(System.out::println);
            System.out.println("\n--------------------\nCARDS\n-------------------");
            worConfiguration.getCards().getAll().forEach(System.out::println);
            System.out.println();
        };
    }
    */
}
