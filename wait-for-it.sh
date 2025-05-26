#!/usr/bin/env bash

set -e

host="$1"
shift
cmd=("$@")

until nc -z ${host%:*} ${host##*:}; do
  echo "Aguardando o serviço $host estar disponível..."
  sleep 2
done

echo "$host está disponível, executando: ${cmd[*]}"
exec "${cmd[@]}"
