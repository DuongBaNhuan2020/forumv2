package com.dev2qa.forum.mvc;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReplyMessage extends AMessage {
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "topic_id", nullable = false)
	private Topic topic;
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	public ReplyMessage(Topic topic, User user) {
		super();
		this.topic = topic;
		this.user = user;
	}
	
	public ReplyMessage() {
		super();
	}

	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	 
	 
}
