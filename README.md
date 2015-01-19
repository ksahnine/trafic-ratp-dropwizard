# [Blog] Service de consultation des horaires du métro parisien
Un cas d'utilisation de <a href="http://dropwizard.io/">Dropwizard</a> illustrant l'article <i><a href="http://blog.inovia-conseil.fr/?p=156">Présentation de Dropwizard</a></i> dans le cadre d'une série consacrée à l'émergence des <a href="http://blog.inovia-conseil.fr/?p=155">architectures orientées microservice</a>.

## Utilisation
Construction du livrable :
`
git clone https://github.com/ksahnine/trafic-ratp-dropwizard.git
cd trafic-ratp-dropwizard
mvn package
`
Démarrage du service :
    java -jar target/trafic-ratp-1.0.0-SNAPSHOT.jar server trafic-ratp.yml
Exemple d'utilisation :
 - Prochains passages métro : Ligne 14 / Station <i>Pyramides</i> / Direction <i>Saint-Lazare</i>
    curl -s http://localhost:8080/trafic-ratp/metro/14/pyramides/A
 - Prochains passages métro : Ligne 14 / Station <i>Pyramides</i> / Direction <i>Olympiades</i>
    curl -s http://localhost:8080/trafic-ratp/metro/14/pyramides/R

