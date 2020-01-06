SUMMARY = "Install my Resume"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://sh-resume file://sh-resume-mini file://shatrix-resume file://sherif.mousa.pdf file://sh-resume.service"

inherit systemd
SYSTEMD_SERVICE_${PN} = "sh-resume.service"
PR = "r1"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/shatrix
    install -d ${D}/bin
    install -d ${D}/etc/systemd/system/
    install -m 0400 sh-resume ${D}${sysconfdir}/shatrix/
    install -m 0400 sh-resume-mini ${D}${sysconfdir}/shatrix/
    install -m 0400 sherif.mousa.pdf ${D}${sysconfdir}/shatrix/
    install -m 0555 shatrix-resume ${D}/bin/
    install -m 0655 sh-resume.service ${D}/etc/systemd/system/
}

FILES_${PN} = "${datadir} ${sysconfdir} /bin"
