#!/bin/sh

echo "Aguardando o serviço mysql-login:3306 estar disponível..."

/wait-for-it.sh mysql-login:3306 -- \
  sh -c "echo 'MySQL disponível, iniciando aplicação...' && exec java -jar /app/appMsLogin.jar"
