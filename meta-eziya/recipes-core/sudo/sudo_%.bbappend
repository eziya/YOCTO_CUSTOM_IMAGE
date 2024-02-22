FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://sudoers"

do_install:append() {
    install -m 0440 ${WORKDIR}/sudoers ${D}${sysconfdir}/sudoers
}

