package fr.inovia.blog.resources;

import fr.inovia.blog.core.Ligne;
import fr.inovia.blog.core.Station;
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

@Path("/reseau-ratp")
@Produces(MediaType.APPLICATION_JSON)
public class ReseauRatpResource {
    private final String urlLignes;
    private final String urlStations;

    public ReseauRatpResource(String urlLignes, String urlStations) {
        this.urlLignes = urlLignes;
        this.urlStations = urlStations;
    }

    @GET
    @Timed
    @Path("/metro/stations")
    public ArrayList<Station> stationsMetro() throws IOException {
        ArrayList<Station> stationsMetro = new ArrayList<Station>();
        // web scraping
        String url = urlStations;
        Document doc = Jsoup.connect(url).get();
        Elements resultatBrut = doc.select("#horMetroStations option"); // Lignes des stations
        for (Element e : resultatBrut) {
            String id = e.attr("value");
            String nom = e.text();
            stationsMetro.add(new Station(id, nom));
        }
        return stationsMetro;
    }

    @GET
    @Timed
    @Path("/metro/lignes")
    public ArrayList<Ligne> lignesMetro() throws IOException {
        ArrayList<Ligne> lignesMetro = new ArrayList<Ligne>();
        // web scraping
        String url = urlLignes;
        Document doc = Jsoup.connect(url).get();
        Elements resultatBrut = doc.select("#inside div.lignes"); // Lignes du réseau
        Element lignesMetroElt = resultatBrut.get(1); // Lignes du métro
        for (Element e : lignesMetroElt.children()) {
            String id = e.attr("id");
            String numero = id.substring(id.lastIndexOf('_') + 1);
            Elements e_c = e.children();
            String iconUrl = e_c.get(0).attr("src"); // URL icone
            String etat = e_c.select("span.perturb_message").get(0).text(); // Etat trafic
            lignesMetro.add(new Ligne(id, numero, iconUrl, etat));
        }

        return lignesMetro;
    }
}
