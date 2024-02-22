DESCRIPTION = "System Initialize Service"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://startup.sh \
    file://startup.service \
"

inherit systemd

S = "${WORKDIR}"

RDEPENDS:${PN}  = "bash"
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "startup.service"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/startup.sh ${D}${bindir}
    
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/startup.service ${D}${systemd_unitdir}/system/
}

FILES:${PN} += " \
    ${bindir}/startup.sh \
    ${systemd_unitdir}/system/startup.service \
"
