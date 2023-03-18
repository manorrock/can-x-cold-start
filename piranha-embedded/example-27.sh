#!/bin/bash
set -m
PIRANHA_HOME=Piranha21.10.0
rm -rf $PIRANHA_HOME/webapps/example*
cp example-22/target/example22.war $PIRANHA_HOME/webapps
echo 'TIME0:' `gdate +%s%3N`
docker run --rm -it -p 8080:8080 -v $PWD:/mnt eclipse-temurin:17 bash /mnt/example-27-docker.sh
