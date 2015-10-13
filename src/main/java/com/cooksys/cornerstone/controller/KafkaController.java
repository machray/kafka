package com.cooksys.cornerstone.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cornerstone.exceptions.ResourceNotFoundException;
import com.cooksys.cornerstone.model.KafkaResponse;

@RestController
@RequestMapping("/rest/kafka/{message}")
public class KafkaController {
	
	@RequestMapping(method = RequestMethod.POST)
	public KafkaResponse addMessage(@PathVariable String message) {
		KafkaResponse response = new KafkaResponse();
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		
		try {
			process = runtime.exec("bin/kafka-console-producer.sh --broker-list localhost:9092--topic test");
			response.setResult(new Date().toString() + " - " + message);
			process = runtime.exec(response.getResult());
			process.destroy();
			
		} catch (IOException e) {
			throw new ResourceNotFoundException();
		}
	
		return response;
	}
}
