package com.dev2qa.forum.mvc;




import java.util.Calendar;
import java.util.Stack;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;


@MappedSuperclass
public abstract class AMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar createdTime;
	private String content;
//	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
//	    @JoinColumn(name = "user_id", nullable = false)
//	private User user;

	public AMessage() {
		super();
	}
	public AMessage(long id, String title, Calendar createdTime, String content) {
	super();
	this.id = id;
	this.title = title;
	this.createdTime = createdTime;
	this.content = content;
}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Calendar getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
//	
}
