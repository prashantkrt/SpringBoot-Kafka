package com.myLearning.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfigTopic {

	@Bean
	public NewTopic createTopic() {
		TopicBuilder topicBuilder = TopicBuilder.name("myTopic2");
		//return topicBuilder.partitions(2).build();
		return topicBuilder.build();

	}

}
