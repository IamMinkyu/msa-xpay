package com.xpay.common;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import java.util.Properties;



@Component
public class LoggingProducer {

  private final KafkaProducer<String, String> producer;
  private final String topic;

  public LoggingProducer() {

    // Producer Initialization ';'
    String bootstrapServers = "kafka:29092";
    String topic = "xpay.logging.out.stdout";
    Properties props = new Properties();

    // kafka:29092
    props.put("bootstrap.servers", bootstrapServers);

    // "key:value"
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    this.producer = new KafkaProducer<>(props);
    this.topic = topic;
  }

  public void sendMessage(String key, String value) {
    ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
    producer.send(record, (metadata, exception) -> {
      if (exception == null) {

      }
      else {
        exception.printStackTrace();
      }
    });
  }
}
