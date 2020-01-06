SUMMARY = "Install my Resume"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://sh-resume file://sh-resume-mini file://shatrix-resume"

PR = "r1"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/shatrix
    install -d ${D}/bin
    install -m 0400 sh-resume ${D}${sysconfdir}/shatrix/sh-resume
    install -m 0400 sh-resume-mini ${D}${sysconfdir}/shatrix/sh-resume-mini
    install -m 0555 shatrix-resume ${D}/bin
}

FILES_${PN} = "${sysconfdir} /bin"
