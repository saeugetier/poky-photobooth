SUMMARY = "Qt5 Photobooth Application"
DESCRIPTION = "Test"
LICENSE = "LGPLv2.1+ & GFDL-1.2"
LIC_FILES_CHKSUM = "file://COPYING.DOC;md5=ad1419ecc56e060eccf8184a87c4285f \
                    file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

DEPENDS = "qtbase qtmultimedia qtdeclarative qtquickcontrols2 imagemagick cups"

SRC_URI = "git://github.com/saeugetier/photobooth.git file://init"
SRCREV = "6346690deafc0447d65dff4014c6b2b651b484a7"
S = "${WORKDIR}/git/software/qtbooth"

require recipes-qt/qt5/qt5.inc

inherit qmake5

RDEPENDS_${PN} = "qtbase-plugins qtdeclarative-qmlplugins qtquickcontrols qtquickcontrols2 qtquickcontrols2-qmlplugins qtdeclarative tslib tslib-conf tslib-calibrate fontconfig fontconfig-utils ttf-bitstream-vera"


inherit update-rc.d

INITSCRIPT_NAME = "qtbooth"
INITSCRIPT_PARAMS = "defaults 80"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/qtbooth
    install -m 0755 ${B}/qtbooth ${D}${bindir}
}

FILES_${PN} += "${datadir}"
