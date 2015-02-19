package fr.inovia.blog;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class TraficRatpConfiguration extends Configuration {
    @NotEmpty
    private String urlRatp;

    @NotEmpty
    private String urlLignes;

    @NotEmpty
    private String urlStations;

    @JsonProperty
    public String getUrlRatp() {
        return urlRatp;
    }

    @JsonProperty
    public void setUrlRatp(String urlRatp) {
        this.urlRatp = urlRatp;
    }

    @JsonProperty
    public String getUrlLignes() {
        return urlLignes;
    }

    @JsonProperty
    public void setUrlLignes(String urlLignes) {
        this.urlLignes = urlLignes;
    }

    @JsonProperty
    public String getUrlStations() {
        return urlStations;
    }

    @JsonProperty
    public void setUrlStations(String urlStations) {
        this.urlStations = urlStations;
    }
}
