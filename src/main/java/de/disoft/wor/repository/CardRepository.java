package de.disoft.wor.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import de.disoft.wor.domain.card.AbstractCard;
import de.disoft.wor.util.WorUtils;
import de.disoft.wor.util.enumeration.ErrorType;
import de.disoft.wor.util.exception.WorTechnicalException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Repository
public final class CardRepository {

    private ObjectMapper objectMapper;
    private Map<Integer, AbstractCard> cards;

    @SuppressWarnings("UnusedDeclaration")
    @Value("${wor.data.cards}")
    private String cardsFile;

    @PostConstruct
    private void initialize() {
        initializeObjectMapper();
        initializeCards();
    }

    private void initializeObjectMapper() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    @SuppressWarnings("unchecked")
    private void initializeCards() {
        InputStream inputStream = null;
        try {
            inputStream = new ClassPathResource(cardsFile).getInputStream();
            cards = objectMapper.readValue(inputStream, new TypeReference<HashMap<Integer, AbstractCard>>() {
            });
        } catch (NullPointerException | IOException e) {
            throw new WorTechnicalException(ErrorType.CARD_REPOSITORY_ERROR, e);
        } finally {
            WorUtils.closeInputStream(inputStream);
        }
    }

    public Map<Integer, AbstractCard> getCards() {
        return cards;
    }

    public void storeCards(HashMap<Integer, AbstractCard> cards, OutputStream outputStream) {
        try {
            objectMapper.writeValue(outputStream, cards);
        } catch (IOException e) {
            throw new WorTechnicalException(ErrorType.CARD_REPOSITORY_ERROR, e);
        }
    }

}
