LICENSE = "GFDL-1.3 & BSD & ( GPL-3.0 & The-Qt-Company-GPL-Exception-1.0 | The-Qt-Company-Commercial ) & ( GPL-2.0+ | LGPL-3.0 | The-Qt-Company-Commercial )"
LIC_FILES_CHKSUM = " \
    file://LICENSE.FDL;md5=6d9f2a9af4c8b8c3c769f6cc1b6aaf7e \
    file://LICENSE.GPL2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
    file://LICENSE.GPL3-EXCEPT;md5=763d8c535a234d9a3fb682c7ecb6c073 \
    file://LICENSE.LGPL3;md5=e6a600fd5e1d9cbde2d983680233ad02 \
"

S = "${WORKDIR}/git"

inherit qmake5

DEPENDS = "qtmultimedia libgphoto2"

RDEPENDS_${PN} = "qtmultimedia"

SRC_URI = "git://github.com/saeugetier/qtmultimedia-gphoto.git"

#SRCREV = "16129d275f6d9d22a7756eb70d82b77a1b969fb9"
SRCREV = "${AUTOREV}"

FILES_${PN} += "/usr/lib/qt5/plugins/mediaservice/libgphoto.so"
