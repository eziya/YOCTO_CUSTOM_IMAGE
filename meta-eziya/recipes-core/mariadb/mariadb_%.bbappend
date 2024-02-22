FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://my.cnf.patch;patchdir=${WORKDIR}"

SYSTEMD_AUTO_ENABLE:${PN}-server = "enable"
