package com.dev2qa.forum.mvc;


import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class ForumData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	@OneToMany(mappedBy = "forumdata", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
	@ManyToMany(cascade = CascadeType.ALL)
	private Map<String, User> users;
	@OneToMany(mappedBy = "forumdata", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<Forum> subForums;
	
}
