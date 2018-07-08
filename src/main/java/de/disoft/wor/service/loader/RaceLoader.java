package de.disoft.wor.service.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.disoft.wor.domain.Races;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public final class RaceLoader {

    private Races races;

    @Value("${wor.data.races}")
    private String racesJson;

    private RaceLoader() {
    }

    @PostConstruct
    public void loadRaces() {
        try {
            races = new ObjectMapper().readValue(ClassLoader.getSystemResource(racesJson), Races.class);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public Races getRaces() {
        return races;
    }
}
