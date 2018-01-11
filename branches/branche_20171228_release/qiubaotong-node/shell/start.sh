#!/bin/sh

cd `dirname $0`
cd ..

pid=`ps -ef |grep node |grep bin/www | awk '{print $2}'`

if [ -n "$pid" ]
then
    echo "node is already running,exit!"
    exit 0
fi

export NODE_ENV=development && node bin/www 2>>log/error.log 1>>log/info.log &

#export NODE_ENV=test && node bin/www 2>>log/error.log 1>>log/info.log &

#export NODE_ENV=production && node bin/www 2>>log/error.log 1>>log/info.log &

echo "node start successfully..."
