inherit update-rc.d

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.DOC;md5=ad1419ecc56e060eccf8184a87c4285f \
                    file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

INITSCRIPT_NAME = "cups"
INITSCRIPT_PARAMS = "defaults"

S = "${WORKDIR}"

SRC_URI += "file://cups.initd"

do_install_append () {
   install -d -m 0755 ${D}${sysconfdir}/init.d
   install -m 0755 ${WORKDIR}/cups.initd ${D}${sysconfdir}/init.d/cups
}
