#!/bin/bash
set -m
sleep 0.5 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/ &
echo 'TIME0:' `gdate +%s%3N`
java -jar example-16/target/quarkus-app/quarkus-run.jar
