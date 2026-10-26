#!/bin/bash
# Задача 8.1 · один из вариантов исправления.
# Какие банки нужны на самом деле, надо уточнить у автора скрипта.

# падать на ошибках, на неустановленных переменных и на ошибках в пайпах
set -euo pipefail

case "$BANK" in
    alfa|rsb|domrf|basic) ;;
    *)
        echo "Неизвестный банк: $BANK" >&2
        exit 1
        ;;
esac

BANK_DIR="/var/opt/qa/nextcloud/banks/${BANK}"

# каталог сервиса client-app исторически называется customer-app
if [[ "$SERVICE" == "pcr-processing-client-app" ]]; then
    PATH_TO_DIST="${BANK_DIR}/pcr-processing-customer-app/latest"
else
    PATH_TO_DIST="${BANK_DIR}/${SERVICE}/latest"
fi

if [[ "$BANK" == "alfa" || "$BANK" == "basic" ]] && [[ "$SERVICE" == pcr-processing* ]]; then
    sh -x install_docker_pcr-processing.sh "$BANK" "$PATH_TO_DIST" "$DEPLOY_DIR"
fi
