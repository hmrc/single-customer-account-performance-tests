#!/usr/bin/env bash

sbt -DrunLocal=false  -Dperftest.runSmokeTest=true gatling:test
