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
Start building the SHATROX minimal image with this cmd
```bash
$ bitbake -k sh-card-minimal-image
```
Or build the SHATROX Qt image with this cmd
```bash
$ bitbake -k sh-card-qt-image
```

## Flash the output image to your MicroSD Card
Connect your microSD card to your PC, and check your card device name using 'lsblk' command
```bash
$ sudo dd bs=4M if= of=/dev/sdX conv=fsync status=progress
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

