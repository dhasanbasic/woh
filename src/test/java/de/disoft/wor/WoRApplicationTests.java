package de.disoft.wor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WoRApplicationTests {
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
//        Assert.assertNotNull(RaceLoader.getRaces());
//        Assert.assertNotNull(RaceLoader.getRaces().getAll());
//
//        Assert.assertNotNull(RaceLoader.getRaces().getRaceByName("Nocturnal"));
//        Assert.assertEquals(NOCTURNAL_NAME, RaceLoader.getRaces().getRaceByName("Nocturnal").getName());
//        Assert.assertEquals(NOCTURNAL_DESCRIPTION, RaceLoader.getRaces().getRaceByName("Nocturnal").getDescription());
//        Assert.assertNotNull(RaceLoader.getRaces().getRaceByName("Nocturnal").getAbility());
//        Assert.assertEquals(NOCTURNAL_ABILITY_NAME, RaceLoader.getRaces().getRaceByName("Nocturnal").getAbility().getName());
//        Assert.assertEquals(NOCTURNAL_ABILITY_DESCRIPTION, RaceLoader.getRaces().getRaceByName("Nocturnal").getAbility().getDescription());
//        Assert.assertEquals(NOCTURNAL_ABILITY_VALUE, RaceLoader.getRaces().getRaceByName("Nocturnal").getAbility().getValue());
//
//        Assert.assertNotNull(RaceLoader.getRaces().getRaceByName("Daylighter"));
//        Assert.assertEquals(DAYLIGHTER_NAME, RaceLoader.getRaces().getRaceByName("Daylighter").getName());
//        Assert.assertEquals(DAYLIGHTER_DESCRIPTION, RaceLoader.getRaces().getRaceByName("Daylighter").getDescription());
//        Assert.assertNotNull(RaceLoader.getRaces().getRaceByName("Daylighter").getAbility());
//        Assert.assertEquals(DAYLIGHTER_ABILITY_NAME, RaceLoader.getRaces().getRaceByName("Daylighter").getAbility().getName());
//        Assert.assertEquals(DAYLIGHTER_ABILITY_DESCRIPTION, RaceLoader.getRaces().getRaceByName("Daylighter").getAbility().getDescription());
//        Assert.assertEquals(DAYLIGHTER_ABILITY_VALUE, RaceLoader.getRaces().getRaceByName("Daylighter").getAbility().getValue());
//
//        Assert.assertNotNull(RaceLoader.getRaces().getRaceByName("Gaia"));
//        Assert.assertEquals(GAIA_NAME, RaceLoader.getRaces().getRaceByName("Gaia").getName());
//        Assert.assertEquals(GAIA_DESCRIPTION, RaceLoader.getRaces().getRaceByName("Gaia").getDescription());
//        Assert.assertNotNull(RaceLoader.getRaces().getRaceByName("Gaia").getAbility());
//        Assert.assertNull(RaceLoader.getRaces().getRaceByName("Gaia").getAbility().getName());
//        Assert.assertNull(RaceLoader.getRaces().getRaceByName("Gaia").getAbility().getDescription());
//        Assert.assertNull(RaceLoader.getRaces().getRaceByName("Gaia").getAbility().getValue());
//
//        Assert.assertNotNull(RaceLoader.getRaces().getRaceByName("Atlantic"));
//        Assert.assertEquals(ATLANTIC_NAME, RaceLoader.getRaces().getRaceByName("Atlantic").getName());
//        Assert.assertEquals(ATLANTIC_DESCRIPTION, RaceLoader.getRaces().getRaceByName("Atlantic").getDescription());
//        Assert.assertNotNull(RaceLoader.getRaces().getRaceByName("Atlantic").getAbility());
//        Assert.assertNull(RaceLoader.getRaces().getRaceByName("Atlantic").getAbility().getName());
//        Assert.assertNull(RaceLoader.getRaces().getRaceByName("Atlantic").getAbility().getDescription());
//        Assert.assertNull(RaceLoader.getRaces().getRaceByName("Atlantic").getAbility().getValue());
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
//        Assert.assertNotNull(CardLoader.getCards());
//        Assert.assertNotNull(CardLoader.getCards().getAll());
//
//        HeroCard heroCard;
//        Assert.assertEquals(H001_ID, CardLoader.getCards().getCardById("H001").getId());
//        Assert.assertEquals(H001_NAME, CardLoader.getCards().getCardById("H001").getName());
//        Assert.assertEquals(H001_DESCRIPTION, CardLoader.getCards().getCardById("H001").getDescription());
//        heroCard = (HeroCard) CardLoader.getCards().getCardById("H001");
//        Assert.assertNotNull(heroCard.getRace());
//        Assert.assertEquals(RaceLoader.getRaces().getRaceByName(H001_RACE).getName(), heroCard.getRace().getName());
//        Assert.assertEquals(RaceLoader.getRaces().getRaceByName(H001_RACE).getDescription(), heroCard.getRace().getDescription());
//        Assert.assertNotNull(heroCard.getRace().getAbility());
//        Assert.assertEquals(RaceLoader.getRaces().getRaceByName(H001_RACE).getAbility().getName(), heroCard.getRace().getAbility().getName());
//        Assert.assertEquals(RaceLoader.getRaces().getRaceByName(H001_RACE).getAbility().getDescription(), heroCard.getRace().getAbility().getDescription());
//        Assert.assertEquals(RaceLoader.getRaces().getRaceByName(H001_RACE).getAbility().getValue(), heroCard.getRace().getAbility().getValue());
//        Assert.assertEquals(H001_HEALTH, heroCard.getHealth());
//        Assert.assertEquals(H001_DAMAGE, heroCard.getDamage());
//        Assert.assertEquals(H001_MANA, heroCard.getMana());
//
//        GiftedHeroCard giftedHeroCard;
//        Assert.assertEquals(H101_ID, CardLoader.getCards().getCardById("H101").getId());
//        Assert.assertEquals(H101_NAME, CardLoader.getCards().getCardById("H101").getName());
//        Assert.assertEquals(H101_DESCRIPTION, CardLoader.getCards().getCardById("H101").getDescription());
//        giftedHeroCard = (GiftedHeroCard) CardLoader.getCards().getCardById("H101");
//        Assert.assertNotNull(giftedHeroCard.getRace());
//        Assert.assertEquals(RaceLoader.getRaces().getRaceByName(H101_RACE).getName(), giftedHeroCard.getRace().getName());
//        Assert.assertEquals(RaceLoader.getRaces().getRaceByName(H101_RACE).getDescription(), giftedHeroCard.getRace().getDescription());
//        Assert.assertNotNull(giftedHeroCard.getRace().getAbility());
//        Assert.assertEquals(RaceLoader.getRaces().getRaceByName(H101_RACE).getAbility().getName(), giftedHeroCard.getRace().getAbility().getName());
//        Assert.assertEquals(RaceLoader.getRaces().getRaceByName(H101_RACE).getAbility().getDescription(), giftedHeroCard.getRace().getAbility().getDescription());
//        Assert.assertEquals(RaceLoader.getRaces().getRaceByName(H101_RACE).getAbility().getValue(), giftedHeroCard.getRace().getAbility().getValue());
//        Assert.assertEquals(H101_HEALTH, giftedHeroCard.getHealth());
//        Assert.assertEquals(H101_DAMAGE, giftedHeroCard.getDamage());
//        Assert.assertEquals(H101_MANA, giftedHeroCard.getMana());
//        Assert.assertNotNull(giftedHeroCard.getAbility());
//        Assert.assertEquals(H101_ABILITY_NAME, giftedHeroCard.getAbility().getName());
//        Assert.assertEquals(H101_ABILITY_DESCRIPTION, giftedHeroCard.getAbility().getDescription());
//        Assert.assertEquals(H101_ABILITY_VALUE, giftedHeroCard.getAbility().getValue());
//
//        WeaponCard weaponCard;
//        Assert.assertEquals(W001_ID, CardLoader.getCards().getCardById("W001").getId());
//        Assert.assertEquals(W001_NAME, CardLoader.getCards().getCardById("W001").getName());
//        Assert.assertEquals(W001_DESCRIPTION, CardLoader.getCards().getCardById("W001").getDescription());
//        weaponCard = (WeaponCard) CardLoader.getCards().getCardById("W001");
//        Assert.assertNotNull(weaponCard.getAbility());
//        Assert.assertEquals(W001_ABILITY_NAME, weaponCard.getAbility().getName());
//        Assert.assertEquals(W001_ABILITY_DESCRIPTION, weaponCard.getAbility().getDescription());
//        Assert.assertEquals(W001_ABILITY_VALUE, weaponCard.getAbility().getValue());
    }
}
