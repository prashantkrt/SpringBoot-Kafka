package com.myLearning.wikimedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myLearning.wikimedia.model.Customer;
import com.myLearning.wikimedia.service.KafkaService;

@RestController
@RequestMapping("/api/v1/publish")
public class KafkaController {

	@Autowired
	private KafkaService service;

	//http://localhost:8080/api/v1/publish/addCustomer
	@GetMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer) {
		service.addMessage(customer);
		return "Customer added";
	}

	//http://localhost:8080/api/v1/publish/addCustomer
	@PostMapping("/addCustomer")
	public String addCustomers(@RequestBody List<Customer> customer) {
		service.add(customer);
		return "Customers added";
	}

}
