#!/bin/bash
set -m
echo 'TIME0:' `gdate +%s%3N`
java -jar example-21/target/example21.jar
