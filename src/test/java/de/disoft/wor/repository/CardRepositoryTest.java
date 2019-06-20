package de.disoft.wor.repository;

import de.disoft.wor.domain.card.AbstractCard;
import de.disoft.wor.domain.card.MagicHeroCard;
import de.disoft.wor.domain.card.NormalHeroCard;
import de.disoft.wor.domain.card.WeaponCard;
import de.disoft.wor.util.enumeration.CardType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;

    @Test
    public void testGetCards() {
        Assert.notNull(cardRepository, "Card repository cannot be null.");
        Assert.notNull(cardRepository.getCards(), "Cards cannot be null.");
    }

    @Test
    public void testStoreCards() throws Exception {
        HashMap<Integer, AbstractCard> cards = new HashMap<>();
        cards.put(1, new NormalHeroCard(1, "Normal Test Hero", "The usual test card for normal heroes.", 2000, 2000, 2000));
        cards.put(2, new MagicHeroCard(2, "Magical Test Hero", "The usual test card for magic heroes.", 2000, 2000, 2000, "TSP"));
        cards.put(3, new WeaponCard(3, "Normal Test Weapon", "The usual test card for normal weapons.", CardType.NORMAL_WEAPON, "TSPL"));
        cards.put(4, new WeaponCard(4, "Magic Test Weapon", "The usual test card for magic weapons.", CardType.MAGIC_WEAPON, "TSPL"));
        cardRepository.storeCards(cards, System.out);
    }

}
