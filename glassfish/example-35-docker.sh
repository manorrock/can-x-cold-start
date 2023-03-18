#!/bin/bash
GLASSFISH_HOME=/mnt/Glassfish6.2.2
cd $GLASSFISH_HOME/bin
(sleep 13 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/example34/) &
./asadmin start-domain --verbose