#!/bin/bash
set -m
(sleep 1.7 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/helloWorld) &
java -jar /mnt/example-31/target/example31.jar
