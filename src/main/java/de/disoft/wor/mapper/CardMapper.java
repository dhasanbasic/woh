package de.disoft.wor.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.disoft.wor.domain.card.AbstractCard;
import de.disoft.wor.util.enumeration.CardType;
import org.springframework.beans.BeanUtils;

import java.io.IOException;

public class CardMapper extends StdDeserializer<AbstractCard> {

    public CardMapper() {
        this(null);
    }

    public CardMapper(Class<?> vc) {
        super(vc);
    }

    @Override
    public AbstractCard deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        String type = jsonNode.get("type").asText();
        CardType cardType = CardType.valueOf(type);
        return BeanUtils.instantiateClass(cardType.getCardClass());
    }
}
