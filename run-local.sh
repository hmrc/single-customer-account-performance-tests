#!/bin/bash

sbt -DrunLocal=true  -Dperftest.runSmokeTest=false gatling:test
