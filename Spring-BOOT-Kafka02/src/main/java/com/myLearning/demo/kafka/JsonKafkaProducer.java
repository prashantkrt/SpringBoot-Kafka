package com.myLearning.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.myLearning.demo.payload.User;

@Service
public class JsonKafkaProducer {

	private static final Logger logger = LoggerFactory.getLogger("JsonKafkaProducer");	
	
	@Autowired
	private KafkaTemplate<String, User> template;
	
	
	public void sendMessage(User user)
	{
		
	logger.info(String.format("Message sent %s", user.toString()));	
	
	Message<User> message = MessageBuilder
			.withPayload(user)
			.setHeader(KafkaHeaders.TOPIC, "myTopic2")
			.build();
	
//	Message<User> message = MessageBuilder
//			.withPayload(user)			
//			.build();	
//	
	template.send(message);
	
	}	

}
