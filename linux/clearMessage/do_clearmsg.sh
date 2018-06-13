#!/bin/bash

chmod 644 /etc/logrotate.d/messages
logrotate /etc/logrotate.d/messages
if [ $? -ne 0 ]; then
    rm /var/lib/logrotate.status -f
    logrotate /etc/logrotate.d/messages
fi
