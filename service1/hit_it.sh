#!/bin/sh

curl -X POST -v http://localhost:8080/account/$1/reactiveDeposit
echo "\n"
