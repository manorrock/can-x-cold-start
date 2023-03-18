#!/bin/bash
set -m
sleep 1.2 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/example39/ &
echo 'TIME0:' `gdate +%s%3N`
java -jar example-39/target/example39.jar
