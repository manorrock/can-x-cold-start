#!/bin/bash
set -m
echo 'TIME0:' `gdate +%s%3N`
docker run --rm -it -p 8080:8080 -v $PWD:/mnt eclipse-temurin:17 java -jar /mnt/piranha-micro-21.10.0.jar --war /mnt/example-22/target/example22.war
