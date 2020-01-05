################################################################################
#
# Shatrox Basic Console Minimal Image
#
################################################################################
inherit core-image

DESCRIPTION = "Shatrox Minimal Console Image"
HOMEPAGE    = "https://github.com/shatrix/shatrix-businesscard"
SECTION     = "image"
PR          = "r001"

BUILDHISTORY_COMMIT        = "0"

# Base ROOTFS size 1GB
#IMAGE_ROOTFS_SIZE          = "1048576"
# Extra space in ROOTFS 6GB
#IMAGE_ROOTFS_EXTRA_SPACE   = "6291456"

IMAGE_FEATURES += "package-management dev-pkgs debug-tweaks splash"

IMAGE_INSTALL += " \
  ${CORE_SHATROX} \
"

CORE_SHATROX = " \
  ${CORE_IMAGE_EXTRA_INSTALL} \
  packagegroup-core-boot  \
  base-files \
  base-passwd \
  busybox \
  initscripts-functions \
  bash \
  tzdata \
  kernel-modules \
  dbus \
  udev \
  fontconfig \
"

set_local_timezone_UTC() {
  ln -sf /usr/share/zoneinfo/UTC ${IMAGE_ROOTFS}/etc/localtime
}

ROOTFS_POSTPROCESS_COMMAND += " \
  set_local_timezone_UTC ; \
  write_image_manifest ; \
"

export IMAGE_BASENAME = "sh-card-minimal-image"
