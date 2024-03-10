package com.myLearning.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myLearning.demo.kafka.JsonKafkaProducer;
import com.myLearning.demo.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	@Autowired
	private JsonKafkaProducer producer;

	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User data) {
		producer.sendMessage(data);
		return ResponseEntity.ok("Json Message sent to Kafka topic");
	}

}
