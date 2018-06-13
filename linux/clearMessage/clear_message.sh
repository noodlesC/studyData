#!/bin/bash

#clear messages
/usr/bin/chattr -a /var/log/messages && 
cat /dev/null > /var/log/messages && 
/usr/bin/killall -HUP rsyslogd && 
/usr/bin/chattr +a /var/log/messages

rm /var/log/messages-* -f

cp -rf messages /etc/logrotate.d/messages && chmod 644 /etc/logrotate.d/messages &&
echo "*/2 * * * * root sh /home/soft/tools/clearMessage/do_clearmsg.sh" >> /etc/crontab
