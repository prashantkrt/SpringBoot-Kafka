package com.myLearning.wikimedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.myLearning.wikimedia.constants.ApplicationConstants;
import com.myLearning.wikimedia.model.Customer;

@Service
public class KafkaService {

	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;

	public String addMessage(Customer customer) {
		kafkaTemplate.send(ApplicationConstants.TOPIC_NAME, customer);
		return "Message published to Kafka topic";
	}

	public String add(List<Customer> customer) {
		if (!customer.isEmpty()) {
			for (Customer c : customer) {
//				Message<List<Customer>> message = MessageBuilder
//						.withPayload(customer)
//						.setHeader(KafkaHeaders.TOPIC, ApplicationConstants.TOPIC_NAME)
//						.build();
				kafkaTemplate.send(ApplicationConstants.TOPIC_NAME, c);
				System.out.println("*****message published to kafka topic -> myTopic3");
			}
		}
		return "Customer records added to Kafka queue successfully!!";
	}

}
