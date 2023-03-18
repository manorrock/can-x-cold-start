#!/bin/sh

echo 'TIME0:' `gdate +%s%3N`
docker run --rm -it -v $PWD:/mnt node node /mnt/example-44.js
