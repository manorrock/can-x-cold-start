#!/bin/zsh

# -----------------------------------------------------------------------------
# Note this script assumes you have done 'brew install coreutils' to make
# gdate available.
# -----------------------------------------------------------------------------
#
#  $1 is the location of the CSV file you want to append your results to
#

cd ${0:a:h}

TIME0=`gdate +%s%3N`
java -jar target/coldstart-piranha-embedded.jar $1 $TIME0 &
while true; do
  curl http://localhost:8000/helloworld
  if [[ $? == "0" ]]; then
    break
  fi
done
