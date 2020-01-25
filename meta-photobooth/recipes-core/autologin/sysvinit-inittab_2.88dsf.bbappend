do_install_append() {
    #!/bin/sh
    sed -i 's:/sbin/getty 38400 tty1:/bin/login -f root tty1 </dev/tty1 >/dev/tty1 2>\&1:' ${D}${sysconfdir}/inittab
}



