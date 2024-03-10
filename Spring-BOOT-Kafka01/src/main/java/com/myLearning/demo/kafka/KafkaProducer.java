package com.myLearning.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
//creating kafkaproducer
@Service
public class KafkaProducer {
	
	private static final Logger logger = LoggerFactory.getLogger("KafkaProducer");

	private KafkaTemplate<String, String> kafkaTemplate;

	//using constructor instead of autowire 
	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		logger.info(String.format("message sent %s", message));
		kafkaTemplate.send("myTopic2", message);
	}

}
