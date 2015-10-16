package com.cooksys.cornerstone.controller;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.cornerstone.exceptions.ResourceNotFoundException;
import com.cooksys.cornerstone.model.KafkaResponse;

@RestController
@RequestMapping("/rest/kafka/{message}")
public class KafkaController {
//	private Integer number;
//
//	@RequestMapping(method = RequestMethod.GET)
//	public KafkaResponse getUname() {
//		Runtime runtime = Runtime.getRuntime();
//		Process process = null;
//		KafkaResponse response = new KafkaResponse();
//		
//		try {
//			Process processZookeeper = runtime.exec("kafka_2.10-0.8.2.0/bin/zookeeper-server-start.sh config/zookeeper.properties");
//			Process processKafka = runtime.exec("kafka_2.10-0.8.2.0/bin/kafka-server-start.sh config/server.properties");
//			process = runtime.exec("kafka_2.10-0.8.2.0/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 2 --partitions 2 --topic test");
//			process = runtime.exec("kafka_2.10-0.8.2.0/bin/kafka-topics.sh --list --zookeeper localhost:2181");
//			process.waitFor();
//			
//			response.setResult(IOUtils.toString(process.getInputStream(), null));
//			
//		} catch (IOException | InterruptedException e) {
//			throw new ResourceNotFoundException();
//		}
//	
//		System.out.println("Incoming request for /rest/kafka");
//		return response;	
//	}
//	
//	public String getStringValue() {
//		if(number==1) return "one";
//		if(number==2) return "two";
//		
//		return "unknown number";
//	}
//	
//	public Integer getNumber() {
//		return number;
//	}
//	
//	public void setNumber(Integer number) {
//		this.number = number;
//	}
	
	@RequestMapping(method = RequestMethod.POST)
	public KafkaResponse addMessage(@PathVariable String message) {
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		KafkaResponse response = new KafkaResponse();
		
		try {
			process = runtime.exec("bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test");
			response.setResult(new Date().toString() + " - " + message);
			process = runtime.exec(response.getResult());
			process.destroy();
			
		} catch (IOException e) {
			throw new ResourceNotFoundException();
		}
	
		return response;
	}
	
//	public class TestProducer {
//	    public static void main(String[] args) {
//	        long events = Long.parseLong(args[0]);
//	        Random rnd = new Random();
//	 
//	        Properties props = new Properties();
//	        props.put("metadata.broker.list", "broker1:9092,broker2:9092 ");
//	        props.put("serializer.class", "kafka.serializer.StringEncoder");
//	        props.put("partitioner.class", "example.producer.SimplePartitioner");
//	        props.put("request.required.acks", "1");
//	 
//	        ProducerConfig config = new ProducerConfig(props);
//	 
//	        Producer<String, String> producer = new Producer<String, String>(config);
//	 
//	        for (long nEvents = 0; nEvents < events; nEvents++) { 
//	               long runtime = new Date().getTime();  
//	               String ip = “192.168.2.” + rnd.nextInt(255); 
//	               String msg = runtime + “,www.example.com,” + ip; 
//	               KeyedMessage<String, String> data = new KeyedMessage<String, String>("page_visits", ip, msg);
//	               producer.send(data);
//	        }
//	        producer.close();
//	    }
//	}
}
