package fr.inovia.blog.health;

import java.net.HttpURLConnection;
import java.net.URL;
import com.codahale.metrics.health.HealthCheck;

public class RatpHealthCheck extends HealthCheck {
    private String urlRatp;

    public RatpHealthCheck(String urlRatp) {
        this.urlRatp = urlRatp;
    }

    @Override
    protected Result check() throws Exception {
        URL url = new URL(urlRatp);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        final int status = connection.getResponseCode();
        if (status != 200 ) {
            return Result.unhealthy("Indisponibilité du site RATP");
        }
        return Result.healthy();
    }
}
