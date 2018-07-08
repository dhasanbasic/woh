package de.disoft.wor;

import de.disoft.wor.domain.*;
import de.disoft.wor.service.WoRConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WoRApplicationTests {

    @Autowired
    private WoRConfiguration configuration;

    private static final String NOCTURNAL_NAME = "Nocturnal";
    private static final String NOCTURNAL_DESCRIPTION = "Creature of the night with more damage and increased health.";
    private static final String NOCTURNAL_ABILITY_NAME = "Night Hunter";
    private static final String NOCTURNAL_ABILITY_DESCRIPTION = "When recruited Nocturnal heroes get 10% more health points and 20 damage points.";
    private static final String NOCTURNAL_ABILITY_VALUE = "H+10%|D+20";

    private static final String DAYLIGHTER_NAME = "Daylighter";
    private static final String DAYLIGHTER_DESCRIPTION = "Light creature, less power but hard to kill.";
    private static final String DAYLIGHTER_ABILITY_NAME = "Light Beam";
    private static final String DAYLIGHTER_ABILITY_DESCRIPTION = "A beam of light is sent from the sky which increased 10% health, decresead 10% damage and increased 10% mana of each Daylighter.";
    private static final String DAYLIGHTER_ABILITY_VALUE = "H+10%|D-10%|M+10%";

    private static final String GAIA_NAME = "Gaia";
    private static final String GAIA_DESCRIPTION = "Creature of nature.";

    private static final String ATLANTIC_NAME = "Atlantic";
    private static final String ATLANTIC_DESCRIPTION = "Water creature.";

    @Test
    public void testRaceLoader() {
        Races races = configuration.getRaces();

        Assert.assertNotNull(races);
        Assert.assertNotNull(races.getAll());

        Assert.assertNotNull(races.getRaceByName("Nocturnal"));
        Assert.assertEquals(NOCTURNAL_NAME, races.getRaceByName("Nocturnal").getName());
        Assert.assertEquals(NOCTURNAL_DESCRIPTION, races.getRaceByName("Nocturnal").getDescription());
        Assert.assertNotNull(races.getRaceByName("Nocturnal").getAbility());
        Assert.assertEquals(NOCTURNAL_ABILITY_NAME, races.getRaceByName("Nocturnal").getAbility().getName());
        Assert.assertEquals(NOCTURNAL_ABILITY_DESCRIPTION, races.getRaceByName("Nocturnal").getAbility().getDescription());
        Assert.assertEquals(NOCTURNAL_ABILITY_VALUE, races.getRaceByName("Nocturnal").getAbility().getValue());

        Assert.assertNotNull(races.getRaceByName("Daylighter"));
        Assert.assertEquals(DAYLIGHTER_NAME, races.getRaceByName("Daylighter").getName());
        Assert.assertEquals(DAYLIGHTER_DESCRIPTION, races.getRaceByName("Daylighter").getDescription());
        Assert.assertNotNull(races.getRaceByName("Daylighter").getAbility());
        Assert.assertEquals(DAYLIGHTER_ABILITY_NAME, races.getRaceByName("Daylighter").getAbility().getName());
        Assert.assertEquals(DAYLIGHTER_ABILITY_DESCRIPTION, races.getRaceByName("Daylighter").getAbility().getDescription());
        Assert.assertEquals(DAYLIGHTER_ABILITY_VALUE, races.getRaceByName("Daylighter").getAbility().getValue());

        Assert.assertNotNull(races.getRaceByName("Gaia"));
        Assert.assertEquals(GAIA_NAME, races.getRaceByName("Gaia").getName());
        Assert.assertEquals(GAIA_DESCRIPTION, races.getRaceByName("Gaia").getDescription());
        Assert.assertNotNull(races.getRaceByName("Gaia").getAbility());
        Assert.assertNull(races.getRaceByName("Gaia").getAbility().getName());
        Assert.assertNull(races.getRaceByName("Gaia").getAbility().getDescription());
        Assert.assertNull(races.getRaceByName("Gaia").getAbility().getValue());

        Assert.assertNotNull(races.getRaceByName("Atlantic"));
        Assert.assertEquals(ATLANTIC_NAME, races.getRaceByName("Atlantic").getName());
        Assert.assertEquals(ATLANTIC_DESCRIPTION, races.getRaceByName("Atlantic").getDescription());
        Assert.assertNotNull(races.getRaceByName("Atlantic").getAbility());
        Assert.assertNull(races.getRaceByName("Atlantic").getAbility().getName());
        Assert.assertNull(races.getRaceByName("Atlantic").getAbility().getDescription());
        Assert.assertNull(races.getRaceByName("Atlantic").getAbility().getValue());
    }

    private static final String H001_ID = "H001";
    private static final String H001_NAME = "Kafal";
    private static final String H001_DESCRIPTION = "Hero from the night.";
    private static final String H001_RACE = "Nocturnal";
    private static final int H001_HEALTH = 500;
    private static final int H001_DAMAGE = 200;
    private static final int H001_MANA = 150;

    private static final String H101_ID = "H101";
    private static final String H101_NAME = "Rem";
    private static final String H101_DESCRIPTION = "A hero with unknown powers.";
    private static final String H101_RACE = "Enigma";
    private static final int H101_HEALTH = 500;
    private static final int H101_DAMAGE = 210;
    private static final int H101_MANA = 150;
    private static final String H101_ABILITY_NAME = "Unknown Power";
    private static final String H101_ABILITY_DESCRIPTION = "Rems rage is raising, so does his damage for 25 points. Costs 25 mana points.";
    private static final String H101_ABILITY_VALUE = "D+25|M-25";

    private static final String W001_ID = "W001";
    private static final String W001_NAME = "Rakal";
    private static final String W001_DESCRIPTION = "Arrow of Despair.";
    private static final String W001_ABILITY_NAME = "Big Shot";
    private static final String W001_ABILITY_DESCRIPTION = "An arrow of the demon Lucifer is shot at an opponent damaging 50 points. Costs 65 mana points.";
    private static final String W001_ABILITY_VALUE = "H-50|M-65";

    @Test
    public void testCardLoader() {
        Cards cards = configuration.getCards();
        Races races = configuration.getRaces();

        Assert.assertNotNull(cards);
        Assert.assertNotNull(cards.getAll());

        HeroCard heroCard;
        Assert.assertEquals(H001_ID, cards.getCardById("H001").getId());
        Assert.assertEquals(H001_NAME, cards.getCardById("H001").getName());
        Assert.assertEquals(H001_DESCRIPTION, cards.getCardById("H001").getDescription());
        heroCard = (HeroCard) cards.getCardById("H001");
        Assert.assertNotNull(heroCard.getRace());
        Assert.assertEquals(races.getRaceByName(H001_RACE).getName(), heroCard.getRace().getName());
        Assert.assertEquals(races.getRaceByName(H001_RACE).getDescription(), heroCard.getRace().getDescription());
        Assert.assertNotNull(heroCard.getRace().getAbility());
        Assert.assertEquals(races.getRaceByName(H001_RACE).getAbility().getName(), heroCard.getRace().getAbility().getName());
        Assert.assertEquals(races.getRaceByName(H001_RACE).getAbility().getDescription(), heroCard.getRace().getAbility().getDescription());
        Assert.assertEquals(races.getRaceByName(H001_RACE).getAbility().getValue(), heroCard.getRace().getAbility().getValue());
        Assert.assertEquals(H001_HEALTH, heroCard.getHealth());
        Assert.assertEquals(H001_DAMAGE, heroCard.getDamage());
        Assert.assertEquals(H001_MANA, heroCard.getMana());

        GiftedHeroCard giftedHeroCard;
        Assert.assertEquals(H101_ID, cards.getCardById("H101").getId());
        Assert.assertEquals(H101_NAME, cards.getCardById("H101").getName());
        Assert.assertEquals(H101_DESCRIPTION, cards.getCardById("H101").getDescription());
        giftedHeroCard = (GiftedHeroCard) cards.getCardById("H101");
        Assert.assertNotNull(giftedHeroCard.getRace());
        Assert.assertEquals(races.getRaceByName(H101_RACE).getName(), giftedHeroCard.getRace().getName());
        Assert.assertEquals(races.getRaceByName(H101_RACE).getDescription(), giftedHeroCard.getRace().getDescription());
        Assert.assertNotNull(giftedHeroCard.getRace().getAbility());
        Assert.assertEquals(races.getRaceByName(H101_RACE).getAbility().getName(), giftedHeroCard.getRace().getAbility().getName());
        Assert.assertEquals(races.getRaceByName(H101_RACE).getAbility().getDescription(), giftedHeroCard.getRace().getAbility().getDescription());
        Assert.assertEquals(races.getRaceByName(H101_RACE).getAbility().getValue(), giftedHeroCard.getRace().getAbility().getValue());
        Assert.assertEquals(H101_HEALTH, giftedHeroCard.getHealth());
        Assert.assertEquals(H101_DAMAGE, giftedHeroCard.getDamage());
        Assert.assertEquals(H101_MANA, giftedHeroCard.getMana());
        Assert.assertNotNull(giftedHeroCard.getAbility());
        Assert.assertEquals(H101_ABILITY_NAME, giftedHeroCard.getAbility().getName());
        Assert.assertEquals(H101_ABILITY_DESCRIPTION, giftedHeroCard.getAbility().getDescription());
        Assert.assertEquals(H101_ABILITY_VALUE, giftedHeroCard.getAbility().getValue());

        WeaponCard weaponCard;
        Assert.assertEquals(W001_ID, cards.getCardById("W001").getId());
        Assert.assertEquals(W001_NAME, cards.getCardById("W001").getName());
        Assert.assertEquals(W001_DESCRIPTION, cards.getCardById("W001").getDescription());
        weaponCard = (WeaponCard) cards.getCardById("W001");
        Assert.assertNotNull(weaponCard.getAbility());
        Assert.assertEquals(W001_ABILITY_NAME, weaponCard.getAbility().getName());
        Assert.assertEquals(W001_ABILITY_DESCRIPTION, weaponCard.getAbility().getDescription());
        Assert.assertEquals(W001_ABILITY_VALUE, weaponCard.getAbility().getValue());
    }
}
