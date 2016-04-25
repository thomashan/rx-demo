#!/bin/sh

echo "Installing libs"
(cd ./../libs && exec ./gradlew clean install)

grails clean
grails run-app
