# Build:
#   docker build -t ksahnine/trafic-ratp-dropwizard .
#
# Run: 
#   docker run -t -p 8080:8080 ksahnine/trafic-ratp-dropwizard 
#
# DOCKER_VERSION 1.4

FROM java:7
MAINTAINER Kadda SAHNINE <kadda.sahnine@inovia-conseil.fr>

ADD target/trafic-ratp-1.0.0-SNAPSHOT.jar /data/trafic-ratp-1.0.0-SNAPSHOT.jar
ADD trafic-ratp.yml /data/trafic-ratp.yml

CMD java -jar trafic-ratp-1.0.0-SNAPSHOT.jar server /data/trafic-ratp.yml

EXPOSE 8080
