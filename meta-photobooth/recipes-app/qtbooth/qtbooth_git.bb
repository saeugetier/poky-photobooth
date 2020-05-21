SUMMARY = "Qt5 Photobooth Application"
DESCRIPTION = "Test"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504"
SECTION = "application/multimedia"

DEPENDS = "qtbase qtmultimedia qtdeclarative qtquickcontrols2 qtsvg"

PVBASE := "${PV}"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PVBASE}:"
PV = "${PVBASE}+${SRCPV}"
BB_SRCREV_POLICY = "clear"
SRC_URI = "git://github.com/saeugetier/photobooth.git;branch=develop file://x_qtbooth.profile.sh"
#SRCREV = "${AUTOREV}"
SRCREV = "23eda1662cc85ac8c2c633ea149d1db46c30d318"
S = "${WORKDIR}/git"

inherit qmake5

PACKAGES_remove = "${PN}-tools"

COMPATIBLE_MACHINE = "^rpi$"

RDEPENDS_${PN} = "qtbase-plugins qtdeclarative-qmlplugins qtquickcontrols qtquickcontrols2 qtgraphicaleffects qtquickcontrols2-qmlplugins qtvirtualkeyboard qtdeclarative tslib tslib-conf tslib-calibrate fontconfig fontconfig-utils ttf-bitstream-vera selphy udev-extraconf gphoto2 pi-blaster"

do_install_append() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${B}/qtbooth ${D}${bindir}
    install -d ${D}${sysconfdir}/profile.d
    install -m 0755 ${WORKDIR}/x_qtbooth.profile.sh ${D}${sysconfdir}/profile.d
    install -m 0755 -d ${D}/home/root/Pictures
    install -m 0755 -d ${D}/home/root/Pictures/collage
    install -m 0755 -d ${D}/home/root/Pictures/recycle
}

FILES_${PN} += "${datadir}"
FILES_${PN} += "/home/*"
FILES_${PN} += "/usr/bin/qtbooth"

FILES_${PN}_tools = ""

