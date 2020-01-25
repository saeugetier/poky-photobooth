LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPLv21;md5=4bfd28363f541b10d9f024181b8df516"

S = "${WORKDIR}/git"

inherit qmake5

DEPENDS = "qtmultimedia libgphoto2"

RDEPENDS_${PN} = "qtmultimedia"

SRC_URI = "git://github.com/saeugetier/qtmultimedia-gphoto.git"

SRCREV = "484844d562e237276fac4fa461a0bc92e708b906"
#SRCREV = "${AUTOREV}"

FILES_${PN} += "/usr/lib/plugins/mediaservice/libgphoto.so"
