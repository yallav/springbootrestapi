package com.restapi.topics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.topics.model.Topic;
import com.restapi.topics.service.ResourceNotFoundException;
import com.restapi.topics.service.TopicService;

/**
 * 
 * @author vijay
 * This controller takes care request mapping and invokes corresponding method from TopicService
 *
 */

@RestController
@RequestMapping("/api")
public class TopicController {
	
	
	@Autowired
	TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getTopics();
	}

	@GetMapping("/topics/{id}")
	public ResponseEntity<Topic> getTopic(@PathVariable(value = "id") String topicId) 
		throws ResourceNotFoundException 
	{
		return topicService.getTopic(topicId);
	}
	
	@PostMapping("/topics")
	public void createTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@PutMapping("/topics/{id}")
	public void updateTopic(@PathVariable(value = "id") String topicId, @RequestBody Topic topic) 
			throws ResourceNotFoundException 
	{
		topicService.updateTopic(topicId, topic);
	}
	
	@DeleteMapping("/topics/{id}")
	public void removeTopic(@PathVariable(value = "id") String topicId) 
			throws ResourceNotFoundException 
	{
		topicService.deleteTopic(topicId);
	}
}
