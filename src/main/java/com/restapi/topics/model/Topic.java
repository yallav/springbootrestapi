package com.restapi.topics.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "topic")
@EntityListeners(AuditingEntityListener.class)
public class Topic {
	
	@Id 
	private String id;
	
	@Column(name = "name", nullable = true)
	private String name;
	
	@Column(name="description", nullable = true)
	private String description;
	
	public Topic() {
		super();
		
	}
	
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	

}
