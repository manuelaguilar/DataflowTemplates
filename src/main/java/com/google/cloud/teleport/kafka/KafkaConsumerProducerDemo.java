/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// package kafka.examples;
package com.google.cloud.teleport.kafka;

public class KafkaConsumerProducerDemo {
    // kafka_broker_url:port [message] [sync]
    public static void main(String[] args) {
	String brokerUrl;
	String payload = "{\"customerId\" : \"101101\", \"amount_withdrawn\" : 4321.11}";
	boolean isAsync = true;

	if (args.length < 1)
	{
            System.out.println("Usage: KafkaConsumerProducerDemo BROKER_URL:PORT [sync] [message]");
	    System.exit(1);
	}

	brokerUrl = args[0];

	if (args.length == 2)
	{
	    isAsync = !args[1].trim().equalsIgnoreCase("sync");
	}

	if (args.length > 2)
	{
	    isAsync = !args[1].trim().equalsIgnoreCase("sync");
	    payload = args[2];
	}

        Producer producerThread = new Producer(KafkaProperties.TOPIC, brokerUrl, isAsync, payload);
        producerThread.start();

        // Consumer consumerThread = new Consumer(KafkaProperties.TOPIC);
        // consumerThread.start();

    }
}
