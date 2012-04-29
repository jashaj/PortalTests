# Portal Tests
Integration tests for A WEb and SOcial Mashup Engine

## System requirements
  * Java 6 or up
  * [Maven 3](http://maven.apache.org)
  * A running [Apache Rave](http://rave.apache.org) portal in the default setup

## Run the tests
To run all tests, execute

    mvn clean install

Individual stories that extend `eu.jasha.portaltests.stories.PortalStories` can be run as junit tests in your IDE.