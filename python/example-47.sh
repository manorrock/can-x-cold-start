#!/bin/sh

echo 'TIME0:' `gdate +%s%3N`
docker run --rm -it -v $PWD:/mnt python python3 /mnt/example-46.py
