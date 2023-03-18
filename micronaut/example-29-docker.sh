#!/bin/bash
(sleep 1.1 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/) &
java -jar /mnt/example-28/target/example28.jar
