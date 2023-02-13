#!/bin/bash
WILDFLY_HOME=WildFly25.0.0
set -m
rm -rf $WILDFLY_HOME/standalone/deployments/example*
cp example-14/target/example14.war $WILDFLY_HOME/standalone/deployments
cd $WILDFLY_HOME/bin
sleep 1 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/example14/ &
echo 'TIME0:' `gdate +%s%3N`
./standalone.sh
