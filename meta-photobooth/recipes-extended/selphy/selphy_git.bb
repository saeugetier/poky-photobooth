DESCRIPTION = "A program to send pictures to print to a Canon Selphy CP printer via wifi "
SECTION = "printing"
HOMEPAGE = "https://github.com/saeugetier/go-selphy-cp"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://${GO_IMPORT}"
SRCREV = "${AUTOREV}"

GO_IMPORT = "github.com/saeugetier/go-selphy-cp"
GO_INSTALL = "${GO_IMPORT}"

inherit go

# This is just to make clear where this example is
do_install_append() {
    mv ${D}${bindir}/go-selphy-cp ${D}${bindir}/${BPN}
}

RDEPENDS_${PN} = "bash"
