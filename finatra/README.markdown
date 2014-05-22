# finatra_example

Finatra requires either [maven](http://maven.apache.org/) or [sbt](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html) to build and run your app.

## SBT Instructions

### Runs your app on port 7070

    sbt run

### Packaging (fatjar)

    sbt assembly


## Maven Instructions

### Runs your app on port 7070

    mvn scala:run

### Testing

    mvn test

### Packaging (fatjar)

    mvn package


### To run anywhere else

    java -jar target/*-0.0.1-SNAPSHOT-jar-with-dependencies.jar -com.twitter.finatra.config.logLevel='ERROR' -com.twitter.finatra.config.adminPort=''
