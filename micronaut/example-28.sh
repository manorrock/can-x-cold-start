#!/bin/bash
set -m
sleep 0.52 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/ &
echo 'TIME0:' `gdate +%s%3N`
java -jar example-28/target/example28.jar
