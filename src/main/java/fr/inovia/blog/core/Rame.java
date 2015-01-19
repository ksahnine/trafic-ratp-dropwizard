package fr.inovia.blog.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Rame {
    private String direction;

    private String attente;

    public Rame() {
    }

    public Rame(String direction, String attente) {
        this.direction = direction;
        this.attente = attente;
    }

    @JsonProperty
    public String getDirection() {
        return direction;
    }

    @JsonProperty
    public String getAttente() {
        return attente; 
    }
}
