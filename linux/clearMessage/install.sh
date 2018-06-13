#!/bin/sh

NODES=`cat /etc/hosts|grep -v -E 'localhost|mirrors'|awk '{print $2}'`
if [ -f $NODES ]; then
  for node in `cat ./NODES`
  do
    echo "putch host: $node"
    ssh $node "mkdir -p /home/soft/tools"
    scp -r ../clearMessage $node:/home/soft/tools
    ssh $node "cd /home/soft/tools/clearMessage && sh clear_message.sh"
  done
fi
