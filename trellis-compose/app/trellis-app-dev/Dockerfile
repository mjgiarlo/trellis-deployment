FROM ubuntu:16.04

MAINTAINER Christopher Johnson <christopher_hanna.johnson@uni-leipzig.de>
LABEL description = "Provides a Trellis Repository"

ENV TRELLIS_SNAPSHOT trellis-app-dev-0.1.2-SNAPSHOT
ENV TRELLIS_RUNTIME /opt
ENV JAVA_OPTS="-Xms250m -Xmx1024m"
RUN apt-get update && \
    apt-get -y install \
    default-jdk \
    git \
    bash \
    nano \
    curl \
    net-tools

ENV TRELLIS_DIST=${TRELLIS_SNAPSHOT}.tar
COPY ${TRELLIS_DIST} /tmp/${TRELLIS_DIST}

RUN mkdir -p ${TRELLIS_RUNTIME} && \
    cd ${TRELLIS_RUNTIME} && \
    tar -xvf /tmp/${TRELLIS_DIST} && \
    mv ${TRELLIS_SNAPSHOT} trellis && \
    rm -rf /tmp/${TRELLIS_DIST}*

WORKDIR ${TRELLIS_RUNTIME}/trellis
COPY etc etc
RUN mkdir /var/lib/trellis
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh
ENTRYPOINT [ "/entrypoint.sh" ]
CMD [ "/opt/trellis/etc/config.yml" ]