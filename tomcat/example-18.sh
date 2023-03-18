#!/bin/bash
TOMCAT_HOME=Tomcat10.0.12
set -m
rm -rf $TOMCAT_HOME/webapps/example*
cp example-18/target/example18.war $TOMCAT_HOME/webapps
cd $TOMCAT_HOME/bin
echo 'TIME0:' `gdate +%s%3N`
(sleep 0.4 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/example18/) &
./catalina.sh run
