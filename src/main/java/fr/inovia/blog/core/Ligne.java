package fr.inovia.blog.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ligne {
    private String id;

    private String numero;

    private String iconUrl;

    private String etat;

    public Ligne() {
    }

    public Ligne(String id, String numero, String iconUrl, String etat) {
        this.id = id;
        this.numero = numero;
        this.iconUrl = iconUrl;
        this.etat = etat;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public String getNumero() {
        return numero; 
    }

    @JsonProperty
    public String getIconUrl() {
        return iconUrl; 
    }

    @JsonProperty
    public String getEtat() {
        return etat; 
    }
}
