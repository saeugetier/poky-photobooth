#!/bin/sh

#export QWS_MOUSE_PROTO=tslib:/dev/input/touchscreen

if [ ! -f /etc/pointercal ]; then
    ts_calibrate
fi

if gphoto2 --auto-detect | grep -q "usb"; then
   echo "Camera available"
else
   echo "wake up camera"
   echo "6=1" > /dev/pi-blaster
   sleep 0.2
   echo "6=0" > /dev/pi-blaster
   sleep 2
fi

qtbooth -plugin Tslib &
