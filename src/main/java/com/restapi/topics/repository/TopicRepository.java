package com.restapi.topics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.topics.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, String> { }

