package de.disoft.wor;

import de.disoft.wor.domain.card.Cards;
import de.disoft.wor.domain.game.HeroPlacement;
import de.disoft.wor.domain.game.Player;
import de.disoft.wor.service.WoRGame;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class WoRApplication {

    @Autowired
    private BeanFactory beanFactory;

    public static void main(String[] args) {
        SpringApplication.run(WoRApplication.class, args);
    }

    @Bean
    CommandLineRunner testConfiguration() {
        return args -> {
            WoRGame game = beanFactory.getBean(WoRGame.class);
            System.out.println("--------------------\nRACES\n-------------------");
            game.getConfiguration().getRacesConfiguration().getRaces().forEach(System.out::println);
            System.out.println("\n--------------------\nCARDS\n-------------------");
            game.getConfiguration().getCardsConfiguration().getCards().forEach(System.out::println);
            System.out.println();
            System.out.println("--------------------\nGAME\n-------------------");
            System.out.println("Number of players:     " + game.getConfiguration().getNumPlayers());
            System.out.println("Lifepoints:            " + game.getConfiguration().getLifePoints());
            System.out.println("Board:                 " + game.getBoard());
            System.out.println("Players:               " + game.getPlayers());
            System.out.println();
        };
    }

    @Bean
    CommandLineRunner testGameAndBoard() {
        return args -> {
            WoRGame game = beanFactory.getBean(WoRGame.class);
            Cards cards = game.getConfiguration().getCardsConfiguration();
            game.addPlayer("A", new ArrayList<>(cards.getCards()));
            Player player1 = game.getPlayers().get(0);
            HeroPlacement heroPlacement1 = new HeroPlacement(player1);
            heroPlacement1.setHeroCard(cards.getCardById("001"));
            game.getBoard().addAssignment(player1, heroPlacement1);
            game.addPlayer("B", new ArrayList<>(cards.getCards()));
            Player player2 = game.getPlayers().get(1);
            HeroPlacement heroPlacement2 = new HeroPlacement(player2);
            heroPlacement2 = new HeroPlacement(player2);
            heroPlacement2.setHeroCard(cards.getCardById("002"));
            heroPlacement2.setWeaponCard(cards.getCardById("003"));
            game.getBoard().addAssignment(player2, heroPlacement2);
            System.out.println(("-------------------\nBOARD\n-------------------"));
            System.out.println("Players:         " + game.getPlayers().size());
            game.getPlayers().forEach(System.out::println);
            System.out.println();
            System.out.println("Placements:");
            game.getBoard().getHeroPlacementsForPlayer(player1).forEach(System.out::println);
            game.getBoard().getHeroPlacementsForPlayer(player2).forEach(System.out::println);
            System.out.println("------------------------");
        };
    }

}
