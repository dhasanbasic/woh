package de.disoft.wor.domain.card;

import de.disoft.wor.util.enumerations.CardType;


public abstract class AbstractCard {

    private Integer id;
    private String name;
    private String description;

    public abstract CardType getType();

    AbstractCard(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
