package fr.inovia.blog;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class TraficRatpConfiguration extends Configuration {
    @NotEmpty
    private String urlRatp;

    @JsonProperty
    public String getUrlRatp() {
        return urlRatp;
    }

    @JsonProperty
    public void setUrlRatp(String urlRatp) {
        this.urlRatp = urlRatp;
    }
}
