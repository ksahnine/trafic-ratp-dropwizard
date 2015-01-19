package fr.inovia.blog.resources;

import fr.inovia.blog.core.Rame;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Path("/trafic-ratp")
@Produces(MediaType.APPLICATION_JSON)
public class TraficRatpResource {
    private final String urlRatp;

    public TraficRatpResource(String urlRatp) {
        this.urlRatp = urlRatp;
    }

    @GET
    @Timed
    @Path("/metro/{ligne: [0-9]{1,2}[b]{0,1}}/{station}/{sens: [A|R]}")
    public ArrayList<Rame> metro(@PathParam("ligne") String ligne, 
                                    @PathParam("station") String station, 
                                    @PathParam("sens") String sens) throws IOException {
        ArrayList<Rame> prochainsPassages = new ArrayList<Rame>();
        // web scraping
        String url = urlRatp + "/" + station + "/" + ligne + "/" + sens;
        Document doc = Jsoup.connect(url).get();
        Elements resultatBrut = doc.select("#prochains_passages fieldset table tr"); // Enregistrements du tableau des prochains passages
        for (Element e : resultatBrut) {
            System.out.println( "SIZE: " + e.childNodeSize() );
            if ( e.childNodeSize() < 4 )
                continue;
            if ( e.child(0).tagName().equals("th") )
                continue;
            String direction = e.child(0).text();
            String attente = e.child(1).text();
            System.out.println(direction + " " + attente);
            prochainsPassages.add( new Rame(direction, attente) );
        }

        return prochainsPassages;
    }
}
