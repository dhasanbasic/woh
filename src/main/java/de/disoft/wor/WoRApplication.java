package de.disoft.wor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.disoft.wor.service.WoRGame;

@SpringBootApplication
public class WoRApplication {
    @Autowired
    private BeanFactory beanFactory;

    public static void main(String[] args) {
        SpringApplication.run(WoRApplication.class, args);
    }

    @Bean
    CommandLineRunner configurationTest() {
        return args -> {
            WoRGame game = beanFactory.getBean(WoRGame.class);

            System.out.println("--------------------\nRACES\n-------------------");
            game.getConfiguration().getRaces().values().stream().forEach(r -> System.out.println(r));
            System.out.println();

            System.out.println("--------------------\nCARDS\n-------------------");
            game.getConfiguration().getCards().getAll().stream().forEach(c -> {
                System.out.print(c.getClass().getSimpleName() + ": ");
                System.out.println(c);
            });
            System.out.println();

            System.out.println("--------------------\nGAME\n-------------------");
            System.out.println("Number of players:     " + game.getConfiguration().getNumPlayers());
            System.out.println("Lifepoints:            " + game.getConfiguration().getLifePoints());
            System.out.println("Board:                 " + game.getBoard());
            System.out.println("Players:               " + game.getPlayers());
            System.out.println();
        };
    }
}
