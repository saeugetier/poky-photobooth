#!/bin/sh

#export QWS_MOUSE_PROTO=tslib:/dev/input/touchscreen

if [ ! -f /etc/pointercal ]; then
    ts_calibrate
fi

qtbooth -plugin Tslib &
