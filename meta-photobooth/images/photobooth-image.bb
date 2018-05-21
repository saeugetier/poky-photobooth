LICENSE = "MIT"

include recipes-core/images/core-image-base.bb 

IMAGE_FEATURES += "splash"

DEPENDS += "bcm2835-bootfiles"

#SPLASH = "psplash-photobooth"

KERNEL_MODULE_AUTOLOAD += "usbtouchscreen"

#PACKAGECONFIG_append = "eglfs fontconfig gles2 linuxfb tslib"

#PACKAGECONFIG[eglfs] = "-eglfs,-no-eglfs,eglfs"
#PACKAGECONFIG[gles2] = "-opengl es2 -eglfs,,virtual/libgles2 virtual/egl"
#PACKAGECONFIG_GL_pn-qtbase = "gles2 linuxfb"

DISTRO_FEATURES_remove = "x11 wayland"

#MACHINE_EXTRA_RRECOMMENDS = "kernel-modules"
	
IMAGE_INSTALL += "qtbooth qgphotoplugin openssh openssh-keygen openssh-sftp-server usbutils gphoto2 htop qt5-env userland tslib tslib-tests rc-local"

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    disable_bootlogd ; \
 "

export IMAGE_BASENAME = "photobooth-image"
