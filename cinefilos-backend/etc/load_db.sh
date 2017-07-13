#!/bin/bash

PSQL=/usr/bin/psql
DATABASE=cinefilos_db
DDL_FILE=DDL_20170703.txt
DEFAULT_DATA=default-data.sql

$PSQL -d postgres -c "drop database $DATABASE"
$PSQL -d postgres -c "create database $DATABASE"
$PSQL -d cinefilos_db < $DDL_FILE
$PSQL -d cinefilos_db < $DEFAULT_DATA
