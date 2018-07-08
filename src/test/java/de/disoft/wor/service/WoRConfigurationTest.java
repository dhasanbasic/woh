package de.disoft.wor.service;

import de.disoft.wor.domain.*;
import de.disoft.wor.domain.card.GiftedHeroCard;
import de.disoft.wor.domain.card.HeroCard;
import de.disoft.wor.domain.card.WeaponCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WoRConfigurationTest {

    @Autowired
    private WoRConfiguration configuration;

    @Test
    public void testGetRaces() throws Exception {
        Races races = configuration.getRaces();

        assertNotNull("Races should not be null", races);
        assertNotNull("Races should not be null", races.getAll());
        assertFalse("Races should not be empty", races.getAll().isEmpty());

        Race race = races.getAll().stream().filter(r -> r.getAbility() != null).findFirst().get();
        assertNotNull("Races should have data present", race.getName());
        assertNotNull("Races should have data present", race.getDescription());

        Ability ability = race.getAbility();
        assertNotNull("Races should have ability data present", ability);
        assertNotNull("Races should have ability data present", ability.getName());
        assertNotNull("Races should have ability data present", ability.getDescription());
        assertNotNull("Races should have ability data present", ability.getValue());
    }

    @Test
    public void testGetCards() throws Exception {
        Cards cards = configuration.getCards();

        assertNotNull("Cards should not be null", cards);
        assertNotNull("Cards should not be null", cards.getAll());
        assertFalse("Cards should not be empty", cards.getAll().isEmpty());

        assertFalse("Normal hero cards should not be empty", cards.getNormalHeroes().isEmpty());
        HeroCard heroCard = cards.getNormalHeroes().get(0);
        assertNotNull("Normal hero cards should have data present", heroCard.getId());
        assertNotNull("Normal hero cards should have data present", heroCard.getName());
        assertNotNull("Normal hero cards should have data present", heroCard.getDescription());
        assertTrue("Normal hero cards should have data present", heroCard.getHealth() > 0);
        assertTrue("Normal hero cards should have data present", heroCard.getDamage() > 0);
        assertTrue("Normal hero cards should have data present", heroCard.getMana() > 0);

        assertNotNull("Normal hero cards should have race data present", heroCard.getRaceName());
        assertNotNull("Normal hero cards should have race data present", heroCard.getRace());
        assertNotNull("Normal hero cards should have race data present", heroCard.getRace().getName());
        assertNotNull("Normal hero cards should have race data present", heroCard.getRace().getDescription());

        assertFalse("Gifted hero cards should not be empty", cards.getGiftedHeroes().isEmpty());
        GiftedHeroCard giftedHeroCard = cards.getGiftedHeroes().get(0);
        assertNotNull("Gifted hero cards should have data present", giftedHeroCard.getId());
        assertNotNull("Gifted hero cards should have data present", giftedHeroCard.getName());
        assertNotNull("Gifted hero cards should have data present", giftedHeroCard.getDescription());
        assertTrue("Gifted hero cards should have data present", giftedHeroCard.getHealth() > 0);
        assertTrue("Gifted hero cards should have data present", giftedHeroCard.getDamage() > 0);
        assertTrue("Gifted hero cards should have data present", giftedHeroCard.getMana() > 0);

        assertNotNull("Gifted hero cards should have race data present", giftedHeroCard.getRaceName());
        assertNotNull("Gifted hero cards should have race data present", giftedHeroCard.getRace());
        assertNotNull("Gifted hero cards should have race data present", giftedHeroCard.getRace().getName());
        assertNotNull("Gifted hero cards should have race data present", giftedHeroCard.getRace().getDescription());

        Ability ability = giftedHeroCard.getAbility();
        assertNotNull("Gifted hero cards should have ability data present", ability);
        assertNotNull("Gifted hero cards should have ability data present", ability.getName());
        assertNotNull("Gifted hero cards should have ability data present", ability.getDescription());
        assertNotNull("Gifted hero cards should have ability data present", ability.getValue());

        assertFalse("Weapon cards should not be empty", cards.getWeapons().isEmpty());
        WeaponCard weaponCard = cards.getWeapons().get(0);
        assertNotNull("Weapon cards should have data present", heroCard.getId());
        assertNotNull("Weapon cards should have data present", heroCard.getName());
        assertNotNull("Weapon cards should have data present", heroCard.getDescription());
        assertTrue("Normal hero cards should have data present", heroCard.getHealth() > 0);
        assertTrue("Normal hero cards should have data present", heroCard.getDamage() > 0);
        assertTrue("Normal hero cards should have data present", heroCard.getMana() > 0);

        ability = weaponCard.getAbility();
        assertNotNull("Weapon cards should have ability data present", ability);
        assertNotNull("Weapon cards should have ability data present", ability.getName());
        assertNotNull("Weapon cards should have ability data present", ability.getDescription());
        assertNotNull("Weapon cards should have ability data present", ability.getValue());

    }

    @Test
    public void testConfiguration() throws Exception {
        assertTrue("Expecting a value here", configuration.getNumPlayers() > 0);
        assertTrue("Expecting a value here", configuration.getLifePoints() > 0);
    }
}
