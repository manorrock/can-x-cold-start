#!/bin/sh

echo 'TIME0:' `gdate +%s%3N`
docker run --rm -it -p 8080:8080 -v $PWD:/mnt eclipse-temurin:17 java -jar /mnt/example-8/target/example8.jar
