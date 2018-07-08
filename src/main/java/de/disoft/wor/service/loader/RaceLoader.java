package de.disoft.wor.service.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.disoft.wor.domain.Races;

import java.io.IOException;

public final class RaceLoader {
    private static final String RACES_JSON = "data/races.json";
    private static Races races = null;

    private RaceLoader() {
    }

    public static Races getRaces() {
        if (races == null) {
            loadRaces();
        }
        return races;
    }

    private static void loadRaces() {
        try {
            races = new ObjectMapper().readValue(ClassLoader.getSystemResource(RACES_JSON), Races.class);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
