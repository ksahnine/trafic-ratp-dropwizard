package fr.inovia.blog.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Station {
    private String id;

    private String nom;

    public Station() {
    }

    public Station(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public String getNom() {
        return nom; 
    }
}
