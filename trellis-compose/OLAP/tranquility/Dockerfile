FROM openjdk:8-jre-alpine

MAINTAINER Christopher Johnson <christopher_hanna.johnson@uni-leipzig.de>
LABEL description = "Provides a Tranquility"

# Java config
ENV TRANQUILITY_VERSION                         0.8.2
ENV TRANQUILITY_PROPERTIES_ZOOKEEPER_CONNECT    zookeeper
ENV TRANQUILITY_PROPERTIES_HTTP_PORT            8200

# Dependencies
RUN apk update && apk add bash jq

# Install
RUN wget -q -O - \
    http://static.druid.io/tranquility/releases/tranquility-distribution-$TRANQUILITY_VERSION.tgz \
    | tar -xzf - -C /usr/share \
    && ln -s /usr/share/tranquility-distribution-$TRANQUILITY_VERSION /usr/share/tranquility

COPY conf /usr/share/tranquility-distribution-$TRANQUILITY_VERSION/conf
COPY docker-entrypoint.sh /docker-entrypoint.sh
RUN chmod +x docker-entrypoint.sh
WORKDIR /usr/share/tranquility

ENTRYPOINT /docker-entrypoint.sh