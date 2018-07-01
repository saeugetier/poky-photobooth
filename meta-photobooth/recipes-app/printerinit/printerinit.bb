SUMMARY = "Add Qt5 bin dir to PATH"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://printerinit.sh \
           file://Canon_CP910.ppd"

PR = "r1"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/profile.d
    install -d ${D}${base_prefix}/usr/share/cups/ppd
    install -m 0755 printerinit.sh ${D}${sysconfdir}/profile.d
    install -m 0755 Canon_CP910.ppd ${D}${base_prefix}/usr/share/cups/ppd
}

FILES_${PN} = "${sysconfdir} ${base_prefix}/usr/share/cups/ppd"

RDEPENDS_${PN} ="cups cups-initd"

