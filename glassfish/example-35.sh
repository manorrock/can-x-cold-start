#!/bin/bash
set -m
GLASSFISH_HOME=Glassfish6.2.2
rm -rf $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy/example*
rm -rf $GLASSFISH_HOME/glassfish/domains/domain1/applications/example*
cp example-34/target/example34.war $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy
echo 'TIME0:' `gdate +%s%3N`
docker run --rm -it -p 8080:8080 -v $PWD:/mnt eclipse-temurin:17 sh /mnt/example-35-docker.sh
