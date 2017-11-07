/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.trellisldp.camel.ActivityStreamProcessor;

public final class MessageConsumerClient {

    private static final Logger LOG = LoggerFactory.getLogger(MessageConsumerClient.class);

    private MessageConsumerClient() {
    }

    public static void main(String[] args) throws Exception {

        LOG.info("About to run Kafka-camel integration...");

        CamelContext camelContext = new DefaultCamelContext();

        camelContext.addRoutes(new RouteBuilder() {
            public void configure() {
                PropertiesComponent pc =
                        getContext().getComponent("properties", PropertiesComponent.class);
                pc.setLocation("classpath:application.properties");

                log.info("About to start route: Kafka Server -> Log ");

                from("kafka:{{consumer.topic}}?brokers={{kafka.host}}:{{kafka.port}}"
                        + "&maxPollRecords={{consumer.maxPollRecords}}"
                        + "&consumersCount={{consumer.consumersCount}}"
                        + "&seekTo={{consumer.seekTo}}" + "&groupId={{consumer.group}}")
                        .routeId("FromKafka")
                        .unmarshal().json(JsonLibrary.Jackson)
                        .process(new ActivityStreamProcessor())
                        .marshal().json(JsonLibrary.Jackson, true)
                        .to("file://{{serialization.log}}");
            }
        });
        camelContext.start();

        // let it run for 5 minutes before shutting down
        Thread.sleep(5 * 60 * 1000);

        camelContext.stop();
    }

}