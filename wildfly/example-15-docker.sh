#!/bin/bash
WILDFLY_HOME=/mnt/WildFly25.0.0
set -m
cp /mnt/example-14/target/example14.war $WILDFLY_HOME/standalone/deployments
cd $WILDFLY_HOME/bin
sleep 7 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/example14/ &
./standalone.sh
