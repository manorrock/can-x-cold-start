#!/bin/bash
PIRANHA_HOME=Piranha21.10.0
set -m
rm -rf $PIRANHA_HOME/webapps/example*
cp example-22/target/example22.war $PIRANHA_HOME/webapps
cd $PIRANHA_HOME/bin
echo 'TIME0:' `gdate +%s%3N`
./run.sh
