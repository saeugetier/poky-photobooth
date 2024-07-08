#!/bin/sh

#export QWS_MOUSE_PROTO=tslib:/dev/input/touchscreen

if [ ! -f /etc/pointercal ]; then
    ts_calibrate
fi

if gphoto2 --auto-detect | grep -q "usb"; then
   echo "Camera available"
else
   echo "wake up camera"
   echo "25=1" > /dev/pi-blaster
   sleep 0.2
   echo "25=0" > /dev/pi-blaster
   sleep 2
fi

# Loop to restart qtbooth if it crashes (returns non-zero exit code)
while true; do
    qtbooth -plugin Tslib
    EXIT_CODE=$?
    if [ $EXIT_CODE -eq 0 ]; then
        echo "qtbooth exited normally with code $EXIT_CODE, not restarting."
        break
    else
        echo "qtbooth crashed with exit code $EXIT_CODE, restarting..."
        # Optional: Add a sleep to prevent rapid restart in case of continuous crashes
        sleep 1
    fi
done

