package com.myLearning.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.myLearning.demo.payload.User;

@Service
public class JsonKafkaConsumer {

	private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

	@KafkaListener(topics = "myTopic2", groupId = "myGroup")
	public void consume(User user) {
		logger.info(String.format("message consumed %s", user.toString()));

	}

}
