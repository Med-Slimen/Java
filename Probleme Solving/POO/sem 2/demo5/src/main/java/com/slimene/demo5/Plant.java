package com.slimene.demo5;


import javafx.beans.property.*;

public class Plant {

    private IntegerProperty id;
    private StringProperty name;
    private StringProperty species;

    public Plant(int id, String name, String species) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.species = new SimpleStringProperty(species);
    }

    public int getId() { return id.get(); }
    public String getName() { return name.get(); }
    public String getSpecies() { return species.get(); }

    public IntegerProperty idProperty() { return id; }
    public StringProperty nameProperty() { return name; }
    public StringProperty speciesProperty() { return species; }
}
