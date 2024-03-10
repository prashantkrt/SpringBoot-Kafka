package com.myLearning.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.myLearning.kafka.constants.ApplicationConstants;
import com.myLearning.kafka.model.Customer;

@Service
public class KafkaConsumerService {

	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

	@KafkaListener(topics = ApplicationConstants.TOPIC_NAME, groupId = "group4")
	public void consume(String customer) {
		//logger.info(String.format("message received --> %s", customer.toString()));
		logger.info(String.format("message received --> %s", customer));
	}

}
