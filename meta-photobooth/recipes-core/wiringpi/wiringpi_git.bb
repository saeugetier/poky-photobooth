DESCRIPTION = "A library to control Raspberry Pi GPIO channels"
HOMEPAGE = "https://projects.drogon.net/raspberry-pi/wiringpi/"
SECTION = "devel/libs"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02"

DEPENDS += "virtual/crypt"

# tag 2.46
SRCREV = "8d188fa0e00bb8c6ff6eddd07bf92857e9bd533a"

S = "${WORKDIR}/git"

SRC_URI = "https://github.com/WiringPi/WiringPi.git"

SRC_URI[md5sum] = "946c0df16e2a69a321c84e446cbde9ab"
SRC_URI[sha256sum] = "05e2e92d47e2aa8d0d08bc983e33f9f12b525856d2158257c0c55893493a147c"

COMPATIBLE_MACHINE = "^rpi$"

CFLAGS_prepend = "-I${S}/wiringPi -I${S}/devLib "

EXTRA_OEMAKE += "'INCLUDE_DIR=${D}${includedir}' 'LIB_DIR=${D}${libdir}'"
EXTRA_OEMAKE += "'DESTDIR=${D}/usr' 'PREFIX=""'"

do_compile() {
    oe_runmake -C devLib
    oe_runmake -C wiringPi
    oe_runmake -C gpio 'LDFLAGS=${LDFLAGS} -L${S}/wiringPi -L${S}/devLib'
}

do_install() {
    oe_runmake -C devLib install
    oe_runmake -C wiringPi install
    oe_runmake -C gpio install
}
