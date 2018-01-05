#!/bin/sh
pid=`ps -ef |grep node |grep bin/www | awk '{print $2}'`

if [ -z "$pid" ]
then
    echo "can't find node pid,exit!"
    exit 0
fi

kill -9 $pid

echo "node process is stop!"
