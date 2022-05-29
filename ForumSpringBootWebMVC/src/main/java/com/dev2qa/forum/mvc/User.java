package com.dev2qa.forum.mvc;




import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String userName;
	private String password;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar joinDate;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<Topic> messages;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<ReplyMessage> messagesReply;

	

	public User(long id, String userName, String password, String email, Calendar joinDate, List<Topic> messages,
			List<ReplyMessage> messagesReply) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.joinDate = joinDate;
		this.messages = messages;
		this.messagesReply = messagesReply;
	}

	public User() {
		super();
	}

	//verify
	public boolean verify(String userName, String password) {
		if(this.userName.equals(userName)&&this.password.equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	public Calendar getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Calendar joinDate) {
		this.joinDate = joinDate;
	}

	public List<Topic> getMessages() {
		return messages;
	}

	public void setMessages(List<Topic> messages) {
		this.messages = messages;
	}

	public List<ReplyMessage> getMessagesReply() {
		return messagesReply;
	}

	public void setMessagesReply(List<ReplyMessage> messagesReply) {
		this.messagesReply = messagesReply;
	}


	
}