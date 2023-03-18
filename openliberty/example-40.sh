#!/bin/bash
set -m
echo 'TIME0:' `gdate +%s%3N`
docker run --rm -it -p 8080:8080 -v $PWD:/mnt eclipse-temurin:17 sh /mnt/example-40-docker.sh
