package com.restapi.topics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.topics.model.Topic;
import com.restapi.topics.repository.TopicRepository;

@Service
public class TopicService {


	@Autowired
	TopicRepository topicsRepository;
	
	public List<Topic> getTopics() {
		
		return topicsRepository.findAll();
	}

	public void addTopic(Topic newTopic) {
		topicsRepository.save(newTopic);
		
	}
}
