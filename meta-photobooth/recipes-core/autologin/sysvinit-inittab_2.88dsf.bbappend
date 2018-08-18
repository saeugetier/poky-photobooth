LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

do_install_append() {
    #!/bin/sh
    sed -i 's:/sbin/getty 38400 tty1:/bin/login -f root tty1 </dev/tty1 >/dev/tty1 2>&1:' ${D}${sysconfdir}/inittab
}



