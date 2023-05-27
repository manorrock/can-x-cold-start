#!/bin/zsh

# -----------------------------------------------------------------------------
# Note this script assumes you have done 'brew install coreutils' to make
# gdate available.
# -----------------------------------------------------------------------------
#
#  $1 is the location of the CSV file you want to append your results to
#

cd ${0:a:h}

#
# Get the Piranha Micro distribution if we not already did.
#
if ! [ -f piranha-micro.jar ]; then
  curl -o piranha-micro.jar https://repo1.maven.org/maven2/cloud/piranha/dist/piranha-dist-micro/23.3.0/piranha-dist-micro-23.3.0.jar
fi

if ! [ -f helloworld.war ]; then
  cp target/coldstart-piranha-micro.war helloworld.war
fi

TIME0=`gdate +%s%3N`
java -Dtime0=$TIME0 -DcsvFilename=$1 -jar piranha-micro.jar --war helloworld.war &
while true; do
  curl http://localhost:8080/
  if [[ $? == "0" ]]; then
    break
  fi
done

rm helloworld.war
