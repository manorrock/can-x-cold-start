#!/bin/bash
TOMCAT_HOME=/mnt/Tomcat10.0.12
set -m
cd $TOMCAT_HOME/bin
(sleep 1 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/example18/) &
./catalina.sh run
