package com.myLearning.wikimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafka03WikimediaProjectProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafka03WikimediaProjectProducerApplication.class, args);
	}

	@Autowired
	private WikemediaKafkaProducer producer;

	@Override
	public void run(String... args) throws Exception {
		producer.sendMessage();

	}

}
