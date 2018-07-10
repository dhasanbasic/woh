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

//    @Bean
//    CommandLineRunner gameTest_board() {
//        return args -> {
//            WoRGame game = beanFactory.getBean(WoRGame.class);
//            Cards cards = game.getConfiguration().getCards();
//
//            // sets up players
//            game.addPlayer("A", new ArrayList<>(cards.getAll()));
//            Player p = game.getPlayers().get(0);
//            HeroPlacement placement = new HeroPlacement(p);
//            placement.setHeroCard(cards.getNormalHeroes().get(0));
//            game.getBoard().addAssignment(p, placement);
//
//            game.addPlayer("B", new ArrayList<>(cards.getAll()));
//            p = game.getPlayers().get(1);
//            placement = new HeroPlacement(p);
//            placement.setHeroCard(cards.getGiftedHeroes().get(0));
//            placement.setWeaponCard(cards.getWeapons().get(0));
//            game.getBoard().addAssignment(p, placement);
//
//            System.out.println(("-------------------\nBOARD\n-------------------"));
//            System.out.println("Players:         " + game.getPlayers().size());
//            game.getPlayers().forEach(System.out::println);
//            System.out.println();
//            System.out.println("Placements:");
//            System.out.println("------------------------");
//            for (Player player : game.getPlayers()) {
//                System.out.println("Player:  " + player.getName());
//                for (HeroPlacement heroPlacement : game.getBoard().getHeroPlacementsForPlayer(player)) {
//                    System.out.println("    Hero health:  " + heroPlacement.getHealth());
//                    System.out.println("    Hero damage:  " + heroPlacement.getDamage());
//                    System.out.println("    Hero mana:    " + heroPlacement.getMana());
//                    System.out.println();
//                }
//            }
//        };
//    }

}
