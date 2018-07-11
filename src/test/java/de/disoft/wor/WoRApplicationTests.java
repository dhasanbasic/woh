package de.disoft.wor;

import de.disoft.wor.domain.card.Card;
import de.disoft.wor.domain.card.Cards;
import de.disoft.wor.domain.card.Races;
import de.disoft.wor.service.WoRConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WoRApplicationTests {

    @Autowired
    private WoRConfiguration configuration;

    @Test
    public void testRaceLoader() {
        Races races = configuration.getRacesConfiguration();
        assertNotNull(races);
        assertNotNull(races.getRaces());
        assertNotNull(races.getRaceByName("Nocturnal"));
        assertEquals("Nocturnal", races.getRaceByName("Nocturnal").getName());
        assertNotNull(races.getRaceByName("Enigma"));
        assertEquals("Enigma", races.getRaceByName("Enigma").getName());
    }

    @Test
    public void testNormalHeroCardLoader() {
        Cards cards = configuration.getCardsConfiguration();
        assertNotNull(cards);
        assertNotNull(cards.getCards());
        Card card = cards.getCardById("001");
        assertNotNull(card);
        assertNotNull(card.getType());
        assertEquals("NormalHeroCard", card.getType());
        assertNotNull(card.getId());
        assertNotNull(card.getName());
        assertNotNull(card.getDescription());
        assertNotNull(card.getRace());
        assertNotNull(card.getRace().getName());
        assertNotNull(card.getRace().getDescription());
        assertNotNull(card.getRace().getAbility());
        assertNotNull(card.getRace().getAbility().getName());
        assertNotNull(card.getRace().getAbility().getDescription());
        assertNotNull(card.getRace().getAbility().getPattern());
        assertNotNull(card.getHealth());
        assertNotNull(card.getDamage());
        assertNotNull(card.getMana());
        assertNull(card.getAbility());
    }

    @Test
    public void testGiftedHeroCardLoader() {
        Cards cards = configuration.getCardsConfiguration();
        assertNotNull(cards);
        assertNotNull(cards.getCards());
        Card card = cards.getCardById("002");
        assertNotNull(card);
        assertNotNull(card.getType());
        assertEquals("GiftedHeroCard", card.getType());
        assertNotNull(card.getId());
        assertNotNull(card.getName());
        assertNotNull(card.getDescription());
        assertNotNull(card.getRace());
        assertNotNull(card.getRace().getName());
        assertNotNull(card.getRace().getDescription());
        assertNotNull(card.getRace().getAbility());
        assertNotNull(card.getRace().getAbility().getName());
        assertNotNull(card.getRace().getAbility().getDescription());
        assertNotNull(card.getRace().getAbility().getPattern());
        assertNotNull(card.getHealth());
        assertNotNull(card.getDamage());
        assertNotNull(card.getMana());
        assertNotNull(card.getAbility());
        assertNotNull(card.getAbility().getName());
        assertNotNull(card.getAbility().getDescription());
        assertNotNull(card.getAbility().getPattern());
    }

    @Test
    public void testWeaponCardLoader() {
        Cards cards = configuration.getCardsConfiguration();
        assertNotNull(cards);
        assertNotNull(cards.getCards());
        Card card = cards.getCardById("003");
        assertNotNull(card);
        assertNotNull(card.getType());
        assertEquals("WeaponCard", card.getType());
        assertNotNull(card.getId());
        assertNotNull(card.getName());
        assertNotNull(card.getDescription());
        assertNull(card.getRace());
        assertNull(card.getHealth());
        assertNull(card.getDamage());
        assertNull(card.getMana());
        assertNotNull(card.getAbility());
        assertNotNull(card.getAbility().getName());
        assertNotNull(card.getAbility().getDescription());
        assertNotNull(card.getAbility().getPattern());
    }

}
