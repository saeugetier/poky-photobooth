# Check to see if the printer is already installed
if [ `lpstat -p 2>&1 | grep -E 'CP910' -c || true` = "0" ]
then
    echo "Installing CP910"
    lpadmin -p CP910 -E -m /usr/share/cups/ppd/Canon_CP910.ppd
    lpadmin -d CP910
fi

