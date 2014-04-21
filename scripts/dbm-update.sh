#!/bin/sh

# Updates a database to the current version.
# $ dbm-update [ENVIRONMENT]

grails $1 dbm-clear-checksums
grails $1 dbm-update
