package fr.inovia.blog;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
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
        final TraficRatpResource resource = new TraficRatpResource( configuration.getUrlRatp() );
        environment.jersey().register(resource);
        environment.jersey().register(new IOExceptionMapper());
        environment.healthChecks().register("Dispo site RATP", new RatpHealthCheck( configuration.getUrlRatp() ));
    }
}
