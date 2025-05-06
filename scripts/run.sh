#!/bin/bash

cd ../clubnu-external-api/ || exit 1

./gradlew bootRun --args='--spring.profiles.active=local'