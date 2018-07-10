package de.disoft.wor;

import de.disoft.wor.domain.Cards;
import de.disoft.wor.domain.event.EventType;
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
    CommandLineRunner configurationTest() {
        return args -> {
            WoRGame game = beanFactory.getBean(WoRGame.class);
            System.out.println("--------------------\nRACES\n-------------------");
            game.getConfiguration().getRaces().getAll().forEach(System.out::println);
            System.out.println("\n--------------------\nCARDS\n-------------------");
            game.getConfiguration().getCards().getAll().forEach(System.out::println);
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
    CommandLineRunner gameTest_board() {
        return args -> {
            WoRGame game = beanFactory.getBean(WoRGame.class);
            Cards cards = game.getConfiguration().getCards();

            // sets up players
            Player p = new Player("A", 2000);
            p.setDeck(new ArrayList<>(cards.getAll()));
            game.addPlayer(p);
            HeroPlacement placement = new HeroPlacement(p);
            placement.setHeroCard(cards.getNormalHeroes().get(0));
            game.getEventLane().put(EventType.PlayerPlaceHero, p, placement);

            p = new Player("B", 3000);
            p.setDeck(new ArrayList<>(cards.getAll()));
            game.addPlayer(p);
            p = game.getPlayers().get(1);
            placement = new HeroPlacement(p);
            placement.setHeroCard(cards.getGiftedHeroes().get(0));
            placement.setWeaponCard(cards.getWeapons().get(0));
            game.getEventLane().put(EventType.PlayerPlaceHero, p, placement);

            System.out.println(("-------------------\nBOARD\n-------------------"));
            System.out.println("Players:         " + game.getPlayers().size());
            game.getPlayers().forEach(System.out::println);
            System.out.println();
            System.out.println("Placements:");
            System.out.println("------------------------");
            for (Player player : game.getPlayers()) {
                System.out.println("Player:  " + player.getName());
                for (HeroPlacement heroPlacement : game.getBoard().getHeroesByPlayer(player)) {
                    System.out.println("    Hero health:  " + heroPlacement.getHealth());
                    System.out.println("    Hero damage:  " + heroPlacement.getDamage());
                    System.out.println("    Hero mana:    " + heroPlacement.getMana());
                    System.out.println();
                }
            }
        };
    }

}
