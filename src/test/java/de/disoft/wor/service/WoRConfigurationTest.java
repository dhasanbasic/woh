package de.disoft.wor.service;

import de.disoft.wor.domain.card.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WoRConfigurationTest {

    private static final String RACES_NOT_NULL = "Races should not be null";

    private static final String RACES_NOT_EMPTY = "Races should not be empty";

    private static final String RACES_DATA_PRESENT = "Races should have data present";

    private static final String RACES_ABILITY_DATA_PRESENT = "Races should have ability data present";

    private static final String CARDS_NOT_NULL = "Cards should not be null";

    private static final String CARDS_NOT_EMPTY = "Cards should not be empty";

    private static final String NORMAL_HERO_CARDS_DATA_PRESENT = "Normal hero cards should have data present";

    private static final String NORMAL_HERO_CARDS_RACE_DATA_PRESENT = "Normal hero cards should have race data present";

    private static final String GIFTED_HERO_CARDS_DATA_PRESENT = "Gifted hero cards should have data present";

    private static final String GIFTED_HERO_CARDS_RACE_DATA_PRESENT = "Gifted hero cards should have race data present";

    private static final String GIFTED_HERO_CARDS_ABILITY_DATA_PRESENT = "Gifted hero cards should have ability data present";

    private static final String WEAPON_CARDS_DATA_PRESENT = "Weapon cards should have data present";

    private static final String WEAPON_CARDS_ABILITY_DATA_PRESENT = "Weapon cards should have ability data present";

    private static final String EXPECTED_VALUE = "Expecting a value here";

    @Autowired
    private WoRConfiguration configuration;

    @Test
    public void testGetRaces() {
        Races races = configuration.getRacesConfiguration();
        assertNotNull(RACES_NOT_NULL, races);
        assertNotNull(RACES_NOT_NULL, races.getRaces());
        assertFalse(RACES_NOT_EMPTY, races.getRaces().isEmpty());
        Race race = races.getRaces().stream().filter(r -> r.getAbility() != null).findFirst().orElse(null);
        assertNotNull(RACES_DATA_PRESENT, race);
        assertNotNull(RACES_DATA_PRESENT, race.getName());
        assertNotNull(RACES_DATA_PRESENT, race.getDescription());
        Ability ability = race.getAbility();
        assertNotNull(RACES_ABILITY_DATA_PRESENT, ability);
        assertNotNull(RACES_ABILITY_DATA_PRESENT, ability.getName());
        assertNotNull(RACES_ABILITY_DATA_PRESENT, ability.getDescription());
        assertNotNull(RACES_ABILITY_DATA_PRESENT, ability.getPattern());
    }

    @Test
    public void testGetCards() {
        Cards cards = configuration.getCardsConfiguration();
        assertNotNull(CARDS_NOT_NULL, cards);
        assertNotNull(CARDS_NOT_NULL, cards.getCards());
        assertFalse(CARDS_NOT_EMPTY, cards.getCards().isEmpty());
        Card card = cards.getCardById("001");
        assertNotNull(NORMAL_HERO_CARDS_DATA_PRESENT, card.getId());
        assertNotNull(NORMAL_HERO_CARDS_DATA_PRESENT, card.getName());
        assertNotNull(NORMAL_HERO_CARDS_DATA_PRESENT, card.getDescription());
        assertTrue(NORMAL_HERO_CARDS_DATA_PRESENT, card.getHealth() > 0);
        assertTrue(NORMAL_HERO_CARDS_DATA_PRESENT, card.getDamage() > 0);
        assertTrue(NORMAL_HERO_CARDS_DATA_PRESENT, card.getMana() > 0);
        assertNotNull(NORMAL_HERO_CARDS_RACE_DATA_PRESENT, card.getRaceName());
        assertNotNull(NORMAL_HERO_CARDS_RACE_DATA_PRESENT, card.getRace());
        assertNotNull(NORMAL_HERO_CARDS_RACE_DATA_PRESENT, card.getRace().getName());
        assertNotNull(NORMAL_HERO_CARDS_RACE_DATA_PRESENT, card.getRace().getDescription());
        card = cards.getCardById("002");
        assertNotNull(GIFTED_HERO_CARDS_DATA_PRESENT, card.getId());
        assertNotNull(GIFTED_HERO_CARDS_DATA_PRESENT, card.getName());
        assertNotNull(GIFTED_HERO_CARDS_DATA_PRESENT, card.getDescription());
        assertTrue(GIFTED_HERO_CARDS_DATA_PRESENT, card.getHealth() > 0);
        assertTrue(GIFTED_HERO_CARDS_DATA_PRESENT, card.getDamage() > 0);
        assertTrue(GIFTED_HERO_CARDS_DATA_PRESENT, card.getMana() > 0);
        assertNotNull(GIFTED_HERO_CARDS_RACE_DATA_PRESENT, card.getRaceName());
        assertNotNull(GIFTED_HERO_CARDS_RACE_DATA_PRESENT, card.getRace());
        assertNotNull(GIFTED_HERO_CARDS_RACE_DATA_PRESENT, card.getRace().getName());
        assertNotNull(GIFTED_HERO_CARDS_RACE_DATA_PRESENT, card.getRace().getDescription());
        Ability ability = card.getAbility();
        assertNotNull(GIFTED_HERO_CARDS_ABILITY_DATA_PRESENT, ability);
        assertNotNull(GIFTED_HERO_CARDS_ABILITY_DATA_PRESENT, ability.getName());
        assertNotNull(GIFTED_HERO_CARDS_ABILITY_DATA_PRESENT, ability.getDescription());
        assertNotNull(GIFTED_HERO_CARDS_ABILITY_DATA_PRESENT, ability.getPattern());
        card = cards.getCardById("003");
        assertNotNull(WEAPON_CARDS_DATA_PRESENT, card.getId());
        assertNotNull(WEAPON_CARDS_DATA_PRESENT, card.getName());
        assertNotNull(WEAPON_CARDS_DATA_PRESENT, card.getDescription());
        ability = card.getAbility();
        assertNotNull(WEAPON_CARDS_ABILITY_DATA_PRESENT, ability);
        assertNotNull(WEAPON_CARDS_ABILITY_DATA_PRESENT, ability.getName());
        assertNotNull(WEAPON_CARDS_ABILITY_DATA_PRESENT, ability.getDescription());
        assertNotNull(WEAPON_CARDS_ABILITY_DATA_PRESENT, ability.getPattern());
    }

    @Test
    public void testConfiguration() {
        assertTrue(EXPECTED_VALUE, configuration.getNumPlayers() > 0);
        assertTrue(EXPECTED_VALUE, configuration.getLifePoints() > 0);
    }

}
