FROM maven:3.6.3-jdk-8 AS build

ADD pom.xml pom.xml
ADD src src

RUN mvn package

FROM tomcat:10.0.0-jdk8-openjdk

COPY --from=build target/docker-example.war /usr/local/tomcat/webapps/docker-example.war

CMD ["catalina.sh", "run"]
