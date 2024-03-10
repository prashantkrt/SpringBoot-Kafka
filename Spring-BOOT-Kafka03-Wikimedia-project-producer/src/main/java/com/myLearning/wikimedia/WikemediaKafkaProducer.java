package com.myLearning.wikimedia;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.EventHandler;

@Service
public class WikemediaKafkaProducer {

	private static final Logger logger = LoggerFactory.getLogger(WikemediaKafkaProducer.class);
	private static String topic = "wikimedia_recent_changes2";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

//	public WikemediaKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
//		this.kafkaTemplate = kafkaTemplate;
//	}

	public void sendMessage() throws InterruptedException {

		logger.info("SendMessage method call");

		// To read the real data stream from wikimedia, we use event source
		EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
		EventSource eventSourse = builder.build();

		EventSource source = new EventSource.Builder(eventHandler, URI.create("http://localhost:8080/events/")).build();
		source.start();

		eventSourse.start();
		TimeUnit.MINUTES.sleep(10);
	}

}
