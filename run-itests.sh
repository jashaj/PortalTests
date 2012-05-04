#!/bin/sh
echo 'Cleaning resources from previous runs...'
rm -f /tmp/rave_db.*
echo 'Start integration tests...'
mvn -e clean integration-test
echo '...End integration tests'

