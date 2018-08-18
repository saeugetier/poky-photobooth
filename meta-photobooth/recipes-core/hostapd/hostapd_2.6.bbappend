FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://hostapd_booth"

do_install_append () {
	install -m 0644 ${WORKDIR}/hostapd_booth ${D}${sysconfdir}/hostapd.conf
}
