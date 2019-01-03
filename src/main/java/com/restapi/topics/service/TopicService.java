package com.restapi.topics.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restapi.topics.model.Topic;
import com.restapi.topics.repository.TopicRepository;

/**
 * 
 * @author vijay
 * This service takes care of operations with MySql table Topic with the help of TopicRepository.
 * Intention of this service is to have complete business logic.
 *
 */

@Service
public class TopicService {


	@Autowired
	TopicRepository topicsRepository;
	
	public List<Topic> getTopics() {	
		return topicsRepository.findAll();
	}

	public ResponseEntity<Topic> getTopic(String topicId) 
			throws ResourceNotFoundException
	{
		Topic topic = topicsRepository.findById(topicId).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		return ResponseEntity.ok().body(topic);
	}
	
	public void addTopic(Topic newTopic) {
		topicsRepository.save(newTopic);
	}
	
	public ResponseEntity<Topic> updateTopic(String topicId, Topic existedTopic) 
			throws ResourceNotFoundException 
	{
		Topic topic = topicsRepository.findById(topicId).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		topic.setId(existedTopic.getId());
		topic.setName(existedTopic.getName());
		topic.setDescription(existedTopic.getDescription());
		
		topicsRepository.save(existedTopic);
		return ResponseEntity.ok().body(topic);		
	}
	
	public Map<String, Boolean> deleteTopic(String topicId) 
			throws ResourceNotFoundException 
	{
		topicsRepository.findById(topicId).orElseThrow(() -> new ResourceNotFoundException("Not found"));
		
		topicsRepository.deleteById(topicId);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        
        return response;
	}
}
