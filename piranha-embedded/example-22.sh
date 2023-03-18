#!/bin/bash
set -m
sleep 1 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/ &
echo 'TIME0:' `gdate +%s%3N`
java -jar piranha-micro-21.10.0.jar --war example-22/target/example22.war
