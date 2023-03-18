#!/bin/bash
set -m
(sleep 1.7 ; curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/example39/ ) &
java -jar /mnt/example-39/target/example39.jar
