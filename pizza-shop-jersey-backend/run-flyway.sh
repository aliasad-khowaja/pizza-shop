#! /bin/sh
printf "executing flyway migration"
mvn clean flyway:migrate
printf "execution completed"