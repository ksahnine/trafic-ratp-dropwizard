package fr.inovia.blog.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Passage {
    private String direction;

    private String attente;

    public Passage() {
    }

    public Passage(String direction, String attente) {
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
