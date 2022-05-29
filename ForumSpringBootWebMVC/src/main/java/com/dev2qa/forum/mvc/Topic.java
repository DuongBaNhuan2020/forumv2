package com.dev2qa.forum.mvc;




import java.util.Calendar;
import java.util.List;
import java.util.Stack;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
public class Topic extends AMessage {
	
	@OneToMany(mappedBy = "topic", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<ReplyMessage> messagestopic;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "user_id", nullable = false)
	private User user;

	 
	
	
	public Topic() {
		super();
	}

	public Topic(List<ReplyMessage> messagestopic, User user) {
		super();
		this.messagestopic = messagestopic;
		this.user = user;
	}

	public ReplyMessage getNewMessage() {
		if(this.messagestopic.size()==0) {
			return new ReplyMessage();
		}else {
			return this.messagestopic.get(0);
		}
		
	}

	public List<ReplyMessage> getMessagestopic() {
		return messagestopic;
	}

	public void setMessagestopic(List<ReplyMessage> messagestopic) {
		this.messagestopic = messagestopic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	 
}
