# shatrix-businesscard

# Description
    SHATROX is a custom Poky distribution for X86-64 Computers
    Will be used as a minimal image for business cards

## Prerequisites
    This project is based on Yocto Project 3.0.1 (Zeus)
    Please follow the instructions about "Compatible Linux Distribution" and "Build Host Packages" from this page
    https://www.yoctoproject.org/docs/3.0/brief-yoctoprojectqs/brief-yoctoprojectqs.html

## Build Host
    Tested on Ubuntu 18.04 LTS 64-bit

## Required Packages
```bash
$ sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
build-essential chrpath socat cpio python python3 python3-pip python3-pexpect \
xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa \
libsdl1.2-dev pylint3 xterm
```

## Fetch everything
```bash
$ git clone --recursive git@github.com:shatrix/shatrix-businesscard.git
```

## Build SHATROX Distro for X86-64
```bash
$ cd shatrix-businesscard
$ ./scripts/start-bitbake-shell.sh
```

By default it's building for qemux86-64 target
You can change it to genericx86-64, to run on any X86-64 (Intel & AMD)
by adding this line to the end of conf/local.conf
```bash
MACHINE = "genericx86-64"
```
Start building the SHATROX minimal image with this cmd
```bash
$ bitbake -k sh-card-minimal-image
```
Or build the SHATROX Qt image with this cmd
```bash
$ bitbake -k sh-card-qt-image
```

## Flash the output image to your MicroSD Card
Connect your USB stick to your PC, and check your card device name using 'lsblk' command
```bash
$ sudo dd if=tmp/deploy/images/genericx86-64/sh-card-minimal-image-genericx86-64-xxxxxxxxx.rootfs.wic of=/dev/sdX bs=4M oflag=sync
```

## Depends on
    URI: git://git.yoctoproject.org/poky.git
    branch: zeus

    URI: git://git.openembedded.org/meta-openembedded
    branch: zeus

    URI: https://github.com/meta-qt5/meta-qt5
    branch: zeus

    URI: git://git.yoctoproject.org/meta-intel
    branch: zeus


## Contributing
    meta-shatrix-card layer maintainer: Sherif Mousa <sherif.e.mousa@gmail.com>

