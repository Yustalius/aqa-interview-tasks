#!/bin/bash
# Задача 8.1 · скрипт как его показали на собеседовании. Не запускать, только читать.

if [[ $BANK == "alfa" || $BANK == "rsb" || $BANK == "domrf" ]]; then
    if [[ $SERVICE == "pcr-processing-client-app" ]]; then
        PATH_TO_DIST="/var/opt/qa/nextcloud/banks/${BANK}/pcr-processing-customer-app/latest"
    else
        PATH_TO_DIST="/var/opt/qa/nextcloud/banks/${BANK}/${SERVICE}/latest"
    fi
fi

if { [[ $BANK == alfa ]] || [[ $BANK == basic ]]; } && [[ $SERVICE == pcr-processing* ]]; then
    sh -x install_docker_pcr-processing.sh $BANK $PATH_TO_DIST $DEPLOY_DIR
fi
