require recipes-core/images/rpi-test-image.bb

DESCRIPTION = "Custom image with Ethernet and CAN bus tools"

# OpenSSH
IMAGE_FEATURES:remove = "ssh-server-dropbear"
IMAGE_FEATURES:append = " ssh-server-openssh"

# Ethernet Tools
IMAGE_INSTALL:append = " net-tools iperf3 ethtool iproute2"

# CANbus Tools
IMAGE_INSTALL:append = " can-utils libsocketcan"

# Applications
IMAGE_INSTALL:append = " picocom mariadb openjdk-8"

# Python3
IMAGE_INSTALL:append = " python3 python3-pymysql python3-can python3-cantools"

# Software firewall
IMAGE_INSTALL:append = " nftables"

# Startup scripts
IMAGE_INSTALL:append = " startup-script"

# Security settings
inherit extrausers

IMAGE_INSTALL:append = " sudo"

PASSWD = "\$6\$vRcGS0O8nEeug1zJ\$YnRLFm/w1y/JtgGOQRTfm57c1.QVSZfbJEHzzLUAFmwcf6N72tDQ7xlsmhEF.3JdVL9iz75DVnmmtxVnNIFvp0"

# Disabling root access and adding new user 'pi' with sudo privileges
# Lock root account and set shell to /sbin/nologin
EXTRA_USERS_PARAMS = "usermod -L -e 1 root; \
                      usermod -s /sbin/nologin root; \
                      useradd -u 1200 -d /home/pi -s /bin/sh -p '${PASSWD}' pi; \
                      usermod -a -G sudo pi;"
