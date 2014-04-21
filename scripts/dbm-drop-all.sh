#!/bin/sh

# Drops all database objects.
# $ dbm-drop-all [ENVIRONMENT]

db_name='yaus'
if [ $1 = 'test' ]; then
    db_name='yausDBTest'
fi

mysql='mysql'

echo "drop database ${db_name};" | $mysql -uyaus -pyaus
echo "create database $db_name;" | $mysql -uyaus -pyaus
