# Portal Tests

**This repository is no longer maintained**

Integration tests for [A WEb and SOcial Mashup Engine](https://rave.apache.org/)

## System requirements
  * Java 6 or up
  * [Maven 3](http://maven.apache.org)

## Run all tests
To run all tests, execute

    mvn clean integration-test

Maven will delete the existing H2 database, start up the portal, run all tests and then shut down the portal.

## Run individual test stories

Individual stories that extend `eu.jasha.portaltests.stories.PortalStories` can be run as junit tests in your IDE.

For individual stories Maven will not automatically start or stop the portal. You need a running portal on http://localhost:8080/
