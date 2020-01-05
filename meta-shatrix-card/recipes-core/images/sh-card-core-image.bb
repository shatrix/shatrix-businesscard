################################################################################
#
# Shatrox Basic Console Image, with dev tools
#
################################################################################
inherit core-image

DESCRIPTION = "Shatrox Basic Console Image, with dev tools"
HOMEPAGE    = "https://github.com/shatrix/shatrix-businesscard"
SECTION     = "image"
PR          = "r001"

BUILDHISTORY_COMMIT        = "0"

# Base ROOTFS size 1GB
#IMAGE_ROOTFS_SIZE          = "1048576"
# Extra space in ROOTFS 6GB
#IMAGE_ROOTFS_EXTRA_SPACE   = "6291456"

IMAGE_FEATURES += "package-management dev-pkgs debug-tweaks splash"

#DEPENDS += " zip-native python3-pip-native "

IMAGE_INSTALL += " \
  ${CORE_SHATROX} \
  ${UTILITIES_PKGS} \
  ${WEB_PKGS} \
"

CORE_SHATROX = " \
  ${CORE_IMAGE_EXTRA_INSTALL} \
  packagegroup-core-boot  \
  base-files \
  base-passwd \
  busybox \
  zlib \
  libxml2 \
  initscripts-functions \
  bash \
  connman \
  connman-plugin-ethernet \
  dhcp-client \
  tzdata \
  kernel-modules \
  netbase \
  ethtool \
  fuse \
  sqlite3 \
  mariadb \
  mysql-python \
  alsa-lib  \
  alsa-utils \
  dbus \
  udev \
  glibc \
  ntfs-3g \
  dnsmasq \
  acl \
  libcap \
  libcap-bin \
  attr \
  ebtables \
  arptables \
  fontconfig \
"

WEB_PKGS = " \
  openssh \
  openssh-keygen \
  openssh-sftp-server \
  openssh-ssh \
  openssh-scp \
  iproute2 \
  iptables \
  libnfnetlink \
  curl \
  wget \
  libwebsockets \
  libcrypto \
  jansson \
  openssl \
  openssl-engines \
  openssl-misc \
  net-tools \
  apache2 \
"

DEV_SDK_PKGS = " \
  binutils \
  binutils-symlinks \
  coreutils \
  cpp \
  cpp-symlinks \
  diffutils \
  elfutils elfutils-binutils \
  file \
  g++ \
  g++-symlinks \
  gcc \
  gcc-symlinks \
  gdb \
  gdbserver \
  gettext \
  git \
  ldd \
  libstdc++ \
  libstdc++-dev \
  libtool \
  ltrace \
  make \
  pkgconfig \
  python \
  python-modules \
  python-pip \
  python3 \
  python3-modules \
  python3-pip \
  strace \
  perl-misc \
  perl-modules \
  perl \
  readline \
  mtd-utils \
  fbgrab \
  babeltrace \
"

UTILITIES_PKGS = " \
  bzip2 \
  tar \
  devmem2 \
  dosfstools \
  ethtool \
  fbset \
  findutils \
  grep \
  i2c-tools \
  iperf3 \
  less \
  lsof \
  nano \
  texinfo \
  usbutils \
  xz \
  watchdog \
  netcat-openbsd \
  nmap \
  ntp ntp-tickadj \
  procps \
  rng-tools \
  sysfsutils \
  tcpdump \
  unzip \
  util-linux \
  zip \
  opkg \
  opkg-utils \
  nfs-utils \
  nfs-utils-client \
  libusb1 \
  rsync \
  e2fsprogs \
  e2fsprogs-e2fsck \
  e2fsprogs-mke2fs \
  e2fsprogs-tune2fs \
  fontconfig-utils \
  libunwind \
  linuxptp \
  smartmontools \
  gperftools \
  cpprest \
  libwebsockets \
  asio \
  libflac \
  libsndfile1 \
  libogg \
  gstreamer1.0 \
  gstreamer1.0-plugins-good-isomp4 \
  gstreamer1.0-plugins-base-videoconvert \
  gstreamer1.0-plugins-base-app \
  gstreamer1.0-plugins-bad-videoparsersbad \
  gconf \
  libpng \
  tiff \
  htop \
  iputils \
  traceroute \
  ncurses-terminfo \
"

set_local_timezone_UTC() {
  ln -sf /usr/share/zoneinfo/UTC ${IMAGE_ROOTFS}/etc/localtime
}

ROOTFS_POSTPROCESS_COMMAND += " \
  set_local_timezone_UTC ; \
  write_image_manifest ; \
"

export IMAGE_BASENAME = "sh-card-core-image"
