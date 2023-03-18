#!/bin/bash
set -m
(sleep 1.8 ; curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/) &
java -jar /mnt/example-16/target/quarkus-app/quarkus-run.jar
