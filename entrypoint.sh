#!/bin/sh

echo "Aguardando o serviço mysql-tc-grupo8:3306 estar disponível..."

while ! nc -z mysql-tc-grupo8 3306; do
  sleep 1
done

echo "MySQL disponível, iniciando aplicação..."
exec java -jar /app/appMsLogin.jar