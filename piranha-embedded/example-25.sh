#!/bin/bash
set -m
echo 'TIME0:' `gdate +%s%3N`
docker run --rm -it -p 8080:8080 -v $PWD:/mnt eclipse-temurin:17 java -jar /mnt/example-21/target/example21.jar
