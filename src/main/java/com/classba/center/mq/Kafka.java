package com.classba.center.mq;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.junit.Test;

import java.util.*;


public class Kafka
{
	@Test
	public void consumer()
	{
		HashMap<String, Object> map = new HashMap<>();
		map.put("bootstrap.servers", "localhost:9092");
		map.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		map.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		map.put("group.id", String.format("%d", System.currentTimeMillis()));
		KafkaConsumer consumer = new KafkaConsumer<String, String>(map);
		consumer.subscribe(Arrays.asList("data_cms"));

		Set<TopicPartition> assignment = new HashSet<>();
		while (assignment.size() == 0) {
			consumer.poll(100);
			assignment = consumer.assignment();
		}
		Map<TopicPartition, Long> beginOffsets = consumer.beginningOffsets(assignment);
		for (TopicPartition topicPartition : assignment) {
			long offset = beginOffsets.get(topicPartition);
			consumer.seek(topicPartition, offset);
		}
		Map<TopicPartition, Long> endOffsets = consumer.beginningOffsets(assignment);
		for (TopicPartition topicPartition : assignment) {
			long offset = endOffsets.get(topicPartition);
			consumer.seek(topicPartition, offset);
		}
		ConsumerRecords<String, String> records = consumer.poll(100);
		for (Iterator<ConsumerRecord<String, String>> it = records.iterator(); it.hasNext(); ) {
			ConsumerRecord<String, String> record = it.next();
			System.out.println(String.format("offset:%s, key:%s, value:%s", record.offset(), record.key(), record.value()));
		}
	}

	@Test
	public void producer()
	{
		HashMap<String, Object> map = new HashMap<>();
		map.put("bootstrap.servers", "localhost:9092");
		map.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		map.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		map.put("enable.auto.commit", "false");
		(new KafkaProducer(map)).send(new ProducerRecord<>("data_cms", "name1", String.format("%d", System.currentTimeMillis())));
	}
}
