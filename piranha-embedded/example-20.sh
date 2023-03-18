#!/bin/bash
set -m
echo 'TIME0:' `gdate +%s%3N`
java -jar example-20/target/example20.jar
