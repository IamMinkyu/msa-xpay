package com.xpay.common;

//@Component
//public class LoggingProducer {
//
//  private final KafkaProducer<String, String> producer;
//  private final String topic;
//
//  public LoggingProducer(@Value("${kafka.cluster.bootstrapservers}") String bootstrapServers,
//                         @Value("${logging.topic}") String topic) {
//
//    Properties props = new Properties();
//    props.put("bootstrap.servers", bootstrapServers);
//    props.put("key.serialize", "org.apache.kafka.common.serialization.StringSerializer");
//    props.put("value.serialize", "org.apache.kafka.common.serialization.StringSerializer");
//
//    this.producer = new KafkaProducer<>(props);
//    this.topic = topic;
//
//    System.out.println("LoggingProducer is created");
//  }
//
//  public void sendMessage(String key, String value) {
//    ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
//    producer.send(record, (metadata, exception) -> {
//      if (exception == null) {
//        System.out.println("Success to send message: " + metadata);
//      }
//      else {
//        exception.printStackTrace();
//      }
//    });
//  }
//
//}
