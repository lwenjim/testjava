package com.classba.center.mq;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class Kafka
{
	public static void main(String[] args) throws ExecutionException, InterruptedException
	{
		HashMap<String, Object> map = new HashMap<>();
		map.put("bootstrap.servers", "localhost:9092");
		map.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		map.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		map.put("enable.auto.commit", false);
		KafkaProducer kafkaProducer = new KafkaProducer(map);
		RecordMetadata recordMetadata = (RecordMetadata)kafkaProducer.send(new ProducerRecord("data_cms", "123")).get();
		System.out.println(recordMetadata.offset());
	}
}
