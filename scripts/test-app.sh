#!/bin/sh

# Runs all Grails unit and integration tests and generates reports.

script_path=`dirname $0`

grails clean
sh $script_path/dbm-drop-all.sh test
sh $script_path/dbm-update.sh test
grails test-app
