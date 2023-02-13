#!/bin/bash
set -m

WILDFLY_HOME=WildFly25.0.0
rm -rf $WILDFLY_HOME/standalone/deployments/example*

echo 'TIME0:' `gdate +%s%3N`
docker run --rm -it -p 8080:8080 -v $PWD:/mnt eclipse-temurin:17 sh /mnt/example-15-docker.sh
