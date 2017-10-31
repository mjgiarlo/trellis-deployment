## trellis-deployment

[![Build Status](https://travis-ci.org/trellis-ldp/trellis-docker-karaf.png?branch=master)](https://travis-ci.org/trellis-ldp/trellis-docker-karaf)

This provides composite deployments for Trellis application modules.  

[`trellis-compose`](trellis-compose): contains docker-compositions

## docker images

* [`trellis-app`](trellis-app)  - Provides the Trellis Application.

[![](https://images.microbadger.com/badges/image/trellisldp/trellis-app.svg)](https://microbadger.com/images/trellisldp/trellis-app "trellisldp/trellis-app")[![](https://images.microbadger.com/badges/version/trellisldp/trellis-app.svg)](https://microbadger.com/images/trellisldp/trellis-app "trellisldp/trellis-app")

* [`trellis-processing`](trellis-rosid-file-streaming)  - Provides a Beam async processor.

[![](https://images.microbadger.com/badges/image/trellisldp/trellis-processing.svg)](https://microbadger.com/images/trellisldp/trellis-processing "trellisldp/trellis-processing")[![](https://images.microbadger.com/badges/version/trellisldp/trellis-processing.svg)](https://microbadger.com/images/trellisldp/trellis-processing "trellisldp/trellis-processing")

* [`kafka`](https://github.com/wurstmeister/kafka-docker)  - Provides Kafka.

[![](https://images.microbadger.com/badges/image/trellisldp/kafka.svg)](https://microbadger.com/images/trellisldp/kafka "trellisldp/kafka")[![](https://images.microbadger.com/badges/version/trellisldp/kafka.svg)](https://microbadger.com/images/trellisldp/kafka "trellisldp/kafka")

* [`zookeeper`](https://github.com/31z4/zookeeper-docker/blob/master/3.5.3-beta/Dockerfile)  - Provides Zookeeper.

## Administration

* Trellis can be monitored at `http://localhost:8081`
* Zookeeper can be monitored at `http://localhost:8090/commands`

## Mount Points

To persist data, create these mount points before running docker-compose:
* `/mnt/trellis-data`
* `/mnt/kafka-data`

## Configuration
* Trellis can be configured with `config.yml`
* Zookeeper can be configured with `zoo.cfg`

## Submodule Update
* To update submodules, run `./gradlew submoduleUpdate`

## OSGI / Karaf
* WIP