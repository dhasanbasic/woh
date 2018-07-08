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
import org.springframework.util.Assert;

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
    private static final String NORMAL_HERO_CARDS_NOT_EMPTY = "Normal hero cards should not be empty";
    private static final String NORMAL_HERO_CARDS_DATA_PRESENT = "Normal hero cards should have data present";
    private static final String NORMAL_HERO_CARDS_RACE_DATA_PRESENT = "Normal hero cards should have race data present";
    private static final String GIFTED_HERO_CARDS_NOT_EMPTY = "Gifted hero cards should not be empty";
    private static final String GIFTED_HERO_CARDS_DATA_PRESENT = "Gifted hero cards should have data present";
    private static final String GIFTED_HERO_CARDS_RACE_DATA_PRESENT = "Gifted hero cards should have race data present";
    private static final String GIFTED_HERO_CARDS_ABILITY_DATA_PRESENT = "Gifted hero cards should have ability data present";
    private static final String WEAPON_CARDS_NOT_EMPTY = "Weapon cards should not be empty";
    private static final String WEAPON_CARDS_DATA_PRESENT = "Weapon cards should have data present";
    private static final String WEAPON_CARDS_ABILITY_DATA_PRESENT = "Weapon cards should have ability data present";
    private static final String EXPECTED_VALUE = "Expecting a value here";


    @Autowired
    private WoRConfiguration configuration;

    @Test
    public void testGetRaces() {
        Races races = configuration.getRaces();

        assertNotNull(RACES_NOT_NULL, races);
        assertNotNull(RACES_NOT_NULL, races.getAll());
        assertFalse(RACES_NOT_EMPTY, races.getAll().isEmpty());

        Race race = races.getAll().stream().filter(r -> r.getAbility() != null).findFirst().orElse(null);
        assertNotNull(RACES_DATA_PRESENT, race);
        assertNotNull(RACES_DATA_PRESENT, race.getName());
        assertNotNull(RACES_DATA_PRESENT, race.getDescription());

        Ability ability = race.getAbility();
        assertNotNull(RACES_ABILITY_DATA_PRESENT, ability);
        assertNotNull(RACES_ABILITY_DATA_PRESENT, ability.getName());
        assertNotNull(RACES_ABILITY_DATA_PRESENT, ability.getDescription());
        assertNotNull(RACES_ABILITY_DATA_PRESENT, ability.getValue());
    }

    @Test
    public void testGetCards() {
        Cards cards = configuration.getCards();

        assertNotNull(CARDS_NOT_NULL, cards);
        assertNotNull(CARDS_NOT_NULL, cards.getAll());
        assertFalse(CARDS_NOT_EMPTY, cards.getAll().isEmpty());

        assertFalse(NORMAL_HERO_CARDS_NOT_EMPTY, cards.getNormalHeroes().isEmpty());
        HeroCard heroCard = cards.getNormalHeroes().get(0);
        assertNotNull(NORMAL_HERO_CARDS_DATA_PRESENT, heroCard.getId());
        assertNotNull(NORMAL_HERO_CARDS_DATA_PRESENT, heroCard.getName());
        assertNotNull(NORMAL_HERO_CARDS_DATA_PRESENT, heroCard.getDescription());
        assertTrue(NORMAL_HERO_CARDS_DATA_PRESENT, heroCard.getHealth() > 0);
        assertTrue(NORMAL_HERO_CARDS_DATA_PRESENT, heroCard.getDamage() > 0);
        assertTrue(NORMAL_HERO_CARDS_DATA_PRESENT, heroCard.getMana() > 0);

        assertNotNull(NORMAL_HERO_CARDS_RACE_DATA_PRESENT, heroCard.getRaceName());
        assertNotNull(NORMAL_HERO_CARDS_RACE_DATA_PRESENT, heroCard.getRace());
        assertNotNull(NORMAL_HERO_CARDS_RACE_DATA_PRESENT, heroCard.getRace().getName());
        assertNotNull(NORMAL_HERO_CARDS_RACE_DATA_PRESENT, heroCard.getRace().getDescription());

        assertFalse(GIFTED_HERO_CARDS_NOT_EMPTY, cards.getGiftedHeroes().isEmpty());
        GiftedHeroCard giftedHeroCard = cards.getGiftedHeroes().get(0);
        assertNotNull(GIFTED_HERO_CARDS_DATA_PRESENT, giftedHeroCard.getId());
        assertNotNull(GIFTED_HERO_CARDS_DATA_PRESENT, giftedHeroCard.getName());
        assertNotNull(GIFTED_HERO_CARDS_DATA_PRESENT, giftedHeroCard.getDescription());
        assertTrue(GIFTED_HERO_CARDS_DATA_PRESENT, giftedHeroCard.getHealth() > 0);
        assertTrue(GIFTED_HERO_CARDS_DATA_PRESENT, giftedHeroCard.getDamage() > 0);
        assertTrue(GIFTED_HERO_CARDS_DATA_PRESENT, giftedHeroCard.getMana() > 0);

        assertNotNull(GIFTED_HERO_CARDS_RACE_DATA_PRESENT, giftedHeroCard.getRaceName());
        assertNotNull(GIFTED_HERO_CARDS_RACE_DATA_PRESENT, giftedHeroCard.getRace());
        assertNotNull(GIFTED_HERO_CARDS_RACE_DATA_PRESENT, giftedHeroCard.getRace().getName());
        assertNotNull(GIFTED_HERO_CARDS_RACE_DATA_PRESENT, giftedHeroCard.getRace().getDescription());

        Ability ability = giftedHeroCard.getAbility();
        assertNotNull(GIFTED_HERO_CARDS_ABILITY_DATA_PRESENT, ability);
        assertNotNull(GIFTED_HERO_CARDS_ABILITY_DATA_PRESENT, ability.getName());
        assertNotNull(GIFTED_HERO_CARDS_ABILITY_DATA_PRESENT, ability.getDescription());
        assertNotNull(GIFTED_HERO_CARDS_ABILITY_DATA_PRESENT, ability.getValue());

        assertFalse(WEAPON_CARDS_NOT_EMPTY, cards.getWeapons().isEmpty());
        WeaponCard weaponCard = cards.getWeapons().get(0);
        assertNotNull(WEAPON_CARDS_DATA_PRESENT, heroCard.getId());
        assertNotNull(WEAPON_CARDS_DATA_PRESENT, heroCard.getName());
        assertNotNull(WEAPON_CARDS_DATA_PRESENT, heroCard.getDescription());
        assertTrue(NORMAL_HERO_CARDS_DATA_PRESENT, heroCard.getHealth() > 0);
        assertTrue(NORMAL_HERO_CARDS_DATA_PRESENT, heroCard.getDamage() > 0);
        assertTrue(NORMAL_HERO_CARDS_DATA_PRESENT, heroCard.getMana() > 0);

        ability = weaponCard.getAbility();
        assertNotNull(WEAPON_CARDS_ABILITY_DATA_PRESENT, ability);
        assertNotNull(WEAPON_CARDS_ABILITY_DATA_PRESENT, ability.getName());
        assertNotNull(WEAPON_CARDS_ABILITY_DATA_PRESENT, ability.getDescription());
        assertNotNull(WEAPON_CARDS_ABILITY_DATA_PRESENT, ability.getValue());

    }

    @Test
    public void testConfiguration() {
        assertTrue(EXPECTED_VALUE, configuration.getNumPlayers() > 0);
        assertTrue(EXPECTED_VALUE, configuration.getLifePoints() > 0);
    }
}
