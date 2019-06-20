package de.disoft.wor.domain.card;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.disoft.wor.mapper.CardMapper;
import de.disoft.wor.util.enumeration.CardType;

@JsonDeserialize(using = CardMapper.class)
public abstract class AbstractCard {

    private Integer id;
    private String name;
    private String description;

    public abstract CardType getType();

    protected AbstractCard(Integer id, String name, String description) {
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
