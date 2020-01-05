#!/bin/bash

################################################################################
#
# Entry point shell script to start the bitbake shell, after setting all the
# required project configurations and customizations
#
################################################################################

# Defining important variables
export SHATROX_RPI_SCRIPT_PATH=$(dirname $(readlink -e $0))
export SHATROX_RPI_BUILD_PATH="$SHATROX_RPI_SCRIPT_PATH/../build-card"
export EXTERNAL_LAYERS_PATH="$SHATROX_RPI_SCRIPT_PATH/../external"

# make sure build dir exists
mkdir -p $SHATROX_RPI_BUILD_PATH
cd $SHATROX_RPI_BUILD_PATH

# source the default poky init script
. $EXTERNAL_LAYERS_PATH/poky/oe-init-build-env $SHATROX_RPI_BUILD_PATH

# Custom Functions
function _print_info {
  echo -e "\e[34m\e[1m INFO: $1 \e[39m\e[0m"
}

function check_and_add_bblayer {
  if [ "$(grep $1 $SHATROX_RPI_BUILD_PATH/conf/bblayers.conf)" == "" ]; then
    sed -i '/BBLAYERS ?= \" \\/a\  '$EXTERNAL_LAYERS_PATH'\/'$2' \\' $SHATROX_RPI_BUILD_PATH/conf/bblayers.conf
    _print_info "Layer: ($1) was added successfully to bblayers.conf"
  fi
}

# include the extra project conf, and update bblayers paths
if [ "$(grep 'shatrix-card.conf' $SHATROX_RPI_BUILD_PATH/conf/local.conf)" == "" ]; then
  echo 'require conf/shatrix-card.conf' >> $SHATROX_RPI_BUILD_PATH/conf/local.conf
  _print_info "local.conf was updated successfully with the project extra shatrix-card.conf"
fi
check_and_add_bblayer 'meta-qt5' 'meta-qt5'
#check_and_add_bblayer 'meta-boot2qt' 'meta-boot2qt/meta-boot2qt'
#check_and_add_bblayer 'meta-boot2qt-distro' 'meta-boot2qt/meta-boot2qt-distro'
check_and_add_bblayer 'meta-oe' 'meta-openembedded/meta-oe'
check_and_add_bblayer 'meta-multimedia' 'meta-openembedded/meta-multimedia'
check_and_add_bblayer 'meta-networking' 'meta-openembedded/meta-networking'
check_and_add_bblayer 'meta-perl' 'meta-openembedded/meta-perl'
check_and_add_bblayer 'meta-python' 'meta-openembedded/meta-python'
check_and_add_bblayer 'meta-webserver' 'meta-openembedded/meta-webserver'
check_and_add_bblayer 'meta-filesystems' 'meta-openembedded/meta-filesystems'
check_and_add_bblayer 'meta-intel' 'meta-intel'
check_and_add_bblayer 'meta-shatrix-card' '../meta-shatrix-card'

# Print more help for the user
echo ""
_print_info "Start building the SHATROX image with this cmd: \$ bitbake -k sh-card-minimal-image"
_print_info "Or build the SHATROX Qt image with this cmd:    \$ bitbake -k sh-card-qt-image"

# enter the bitbake shell
bash
