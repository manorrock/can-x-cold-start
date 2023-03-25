#!/bin/zsh

# ----------------------------------------------------------------------------
#  $1 is the script to run for a single test.
#  $2 is the location of the CSV file to append to.
# ----------------------------------------------------------------------------

CSV_FILENAME=`realpath $2`

for run in {1..1000}; do 
  $1 $CSV_FILENAME
done
