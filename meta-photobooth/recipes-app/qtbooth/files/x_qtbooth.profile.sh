#!/bin/sh

#export QWS_MOUSE_PROTO=tslib:/dev/input/touchscreen

if [ ! -f /etc/pointercal ]; then
    ts_calibrate
fi

if gphoto2 --auto-detect | grep -q "usb"; then
   echo "Camera available"
else
   echo "wake up camera"
   gpio mode 6 out
   gpio write 6 1
   sleep 0.2
   gpio write 6 0
   sleep 2
fi

qtbooth -plugin Tslib &
