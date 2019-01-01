package com.restapi.topics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.topics.model.Topic;
import com.restapi.topics.service.TopicService;

@RestController
@RequestMapping("/api")
public class TopicController {
	
	
	@Autowired
	TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getTopics();
	}

	@PostMapping("/topics")
	public void createTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
}
