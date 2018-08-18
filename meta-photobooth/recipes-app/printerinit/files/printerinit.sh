# Check to see if the printer is already installed
if [ `lpstat -p 2>&1 | grep -E 'CP910' -c || true` = "0" ]
then
    echo "Installing CP910"
    lpadmin -p CP910 -E -m /usr/share/cups/ppd/Canon_CP910.ppd -v usb://Canon/CP910?serial=C914010200000141
    lpadmin -d CP910
fi

