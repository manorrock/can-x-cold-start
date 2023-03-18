#!/bin/bash
set -m
echo 'TIME0:' `gdate +%s%3N`
(sleep 0.8 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/helloWorld) &
java -jar example-31/target/example31.jar
