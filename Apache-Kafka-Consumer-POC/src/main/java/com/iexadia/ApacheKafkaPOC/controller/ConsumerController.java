package com.iexadia.ApacheKafkaPOC.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iexadia.ApacheKafkaPOC.model.User;

@RestController
public class ConsumerController {

	List<String> messages = new ArrayList<String>();
	
	List<User> userFromTopic = null;
	
	@KafkaListener(groupId="kafka-group-1", topics="kafkaPOC", containerFactory = "kafkaListenerContainerFactory")
	public List<String> getMessageFromTopic(String data) {
		messages.add(data);
		System.out.println("data: "+data);
		return messages;
	}
	
	@GetMapping("/consumeMessage")
	public List<String> consumeStringMessage() {
		return messages;
	}
	
	@KafkaListener(groupId="kafka-group-2", topics="kafkaPOC", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> getJsonMessageFromTopic(List<User> user) {
		userFromTopic = user;
		return userFromTopic;
	}
	
	@GetMapping("/consumeJsonMessage")
	public List<User> consumeJsonMessage() {
		return userFromTopic;
	}
	
}
