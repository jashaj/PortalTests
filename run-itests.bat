echo 'Cleaning resources from previous runs...'
del \tmp\rave_db.*
echo 'Start integration tests...'
mvn -e clean integration-test
echo '...End integration tests'

