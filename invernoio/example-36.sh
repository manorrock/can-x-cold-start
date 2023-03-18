#!/bin/bash
set -m
(sleep 0.3 && curl --retry 10 --retry-connrefused --retry-delay 0 http://localhost:8080/ &)
echo 'TIME0:' `gdate +%s%3N`
example-36/target/maven-inverno/application_macos_aarch64/example36.app/Contents/MacOS/example36
