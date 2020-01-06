################################################################################
#
# Shatrox Qt Image
#
################################################################################

require sh-card-minimal-image.bb

DESCRIPTION = "Shatrox Qt Image"
HOMEPAGE    = "https://github.com/shatrix/shatrix-businesscard"
SECTION     = "image"
PR          = "r001"

IMAGE_INSTALL += " \
  ${QT5_PKGS} \
  ${QT_EXAMPLES} \
"

QT5_PKGS = " \
  qtbase \
  qtbase-plugins \
  qtquickcontrols \
  qtquickcontrols2 \
  qttranslations \
  qttranslations-qtbase \
  qttranslations-qtquickcontrols \
  qtwayland \
  qtbase-tools \
  qtvirtualkeyboard \
  tslib \
  tslib-conf \
  tslib-calibrate \
  tslib-tests \
  ttf-bitstream-vera \
  qt5-env \
"

QT_EXAMPLES = " \
  cinematicexperience \
  qt5everywheredemo \
  qt5-demo-extrafiles \
"

export IMAGE_BASENAME = "sh-card-qt-image"
