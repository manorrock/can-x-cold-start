#!/bin/bash
set -m
TOMCAT_HOME=Tomcat10.0.12
rm -rf $TOMCAT_HOME/webapps/example*
cp example-18/target/example18.war $TOMCAT_HOME/webapps
echo 'TIME0:' `gdate +%s%3N`
docker run --rm -it -p 8080:8080 -v $PWD:/mnt eclipse-temurin:17 sh /mnt/example-19-docker.sh
