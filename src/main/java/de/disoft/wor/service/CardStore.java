package de.disoft.wor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CardStore {


    private ObjectMapper mapper;

    @PostConstruct
    protected void initialize() {
        mapper = new ObjectMapper();
    }
}
