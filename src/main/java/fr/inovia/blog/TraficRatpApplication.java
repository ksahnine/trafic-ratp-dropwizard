package fr.inovia.blog;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import fr.inovia.blog.resources.ReseauRatpResource;
import fr.inovia.blog.resources.TraficRatpResource;
import fr.inovia.blog.health.RatpHealthCheck;
import fr.inovia.blog.exceptions.IOExceptionMapper;

public class TraficRatpApplication extends Application<TraficRatpConfiguration> {
    public static void main(String[] args) throws Exception {
        new TraficRatpApplication().run(args);
    }

    @Override
    public String getName() {
        return "trafic-ratp";
    }

    @Override
    public void initialize(Bootstrap<TraficRatpConfiguration> bootstrap) {
    }

    @Override
    public void run(TraficRatpConfiguration configuration, Environment environment) {
        final ReseauRatpResource resourceReseau = new ReseauRatpResource( configuration.getUrlLignes(), configuration.getUrlStations());
        final TraficRatpResource resourceTrafic = new TraficRatpResource( configuration.getUrlRatp() );
        environment.jersey().register(resourceReseau);
        environment.jersey().register(resourceTrafic);
        environment.jersey().register(new IOExceptionMapper());
        environment.healthChecks().register("Dispo site RATP", new RatpHealthCheck( configuration.getUrlRatp() ));
    }
}
