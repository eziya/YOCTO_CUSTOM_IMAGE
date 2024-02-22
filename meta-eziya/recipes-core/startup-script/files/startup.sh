#!/bin/sh
/sbin/ip link set can0 type can bitrate 500000
/sbin/ip link set can1 type can bitrate 500000
/bin/ifconfig can0 txqueuelen 65536
/bin/ifconfig can1 txqueuelen 65536
/bin/ifconfig can0 up
/bin/ifconfig can1 up
