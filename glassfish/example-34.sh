#!/bin/bash
GLASSFISH_HOME=Glassfish6.2.2
set -m
rm -rf $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy/example*
rm -rf $GLASSFISH_HOME/glassfish/domains/domain1/applications/example*
cp example-34/target/example34.war $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy
cd $GLASSFISH_HOME/bin
(sleep 5 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/example34/ &)
echo 'TIME0:' `gdate +%s%3N`
./asadmin start-domain --verbose
