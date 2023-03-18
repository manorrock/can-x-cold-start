#!/bin/sh

echo 'TIME0:' `gdate +%s%3N`
java -cp example-2/target/classes example.example2.Example2
