package de.disoft.wor.domain;

public abstract class AbstractCard {
    private String id;
    private String name;
    private String description;

    AbstractCard(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "\nAbstractCard { id = '" + id + "', name = '" + name + "', description = '" + description + "' }\n";
    }
}