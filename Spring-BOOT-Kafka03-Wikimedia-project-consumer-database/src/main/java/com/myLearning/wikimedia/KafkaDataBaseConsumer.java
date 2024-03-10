package com.myLearning.wikimedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.myLearning.wikimedia.dao.WikimediaDataRepository;
import com.myLearning.wikimedia.entity.Wikimedia;

@Service
public class KafkaDataBaseConsumer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaDataBaseConsumer.class);

	private WikimediaDataRepository dataRepository;

	public KafkaDataBaseConsumer(WikimediaDataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(String eventMessage) {
		logger.info(String.format("message consumed -> %s", eventMessage));

		Wikimedia wikimediaData = new Wikimedia();
		wikimediaData.setWikiEventData(eventMessage);
		dataRepository.save(wikimediaData);

	}
}
