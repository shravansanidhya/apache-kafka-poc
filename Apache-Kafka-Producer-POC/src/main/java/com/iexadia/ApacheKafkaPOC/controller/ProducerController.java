package com.iexadia.ApacheKafkaPOC.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iexadia.ApacheKafkaPOC.model.User;

@RestController
public class ProducerController {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplete;
	
	private String topic = "kafkaPOC";
	
	@GetMapping("/publish")
	public String publishMessage() {
		
		kafkaTemplete.send(topic, "Hi Shravan, This is a POC of Kafka");
		return "Welcome to Apache Kafka POC";
	}
	
	@GetMapping("/publishJson")
	public String publishJsonMessage() {
		
		List<User> users = Arrays.asList(new User(1, "Shravan", "Bangalore"), new User(2, "Rajesh", "Bhopal"));
		kafkaTemplete.send(topic, users);
		
		return "Json Data Published";
	}
	
}
