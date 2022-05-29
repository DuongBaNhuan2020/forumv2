package com.dev2qa.forum.mvc;




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
@Entity
public class Forum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	 @ManyToOne
    private Forum parent;
    @OneToMany(mappedBy="parent")
	private List<Forum> subsForum;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "forumdata_id", nullable = false)
    private ForumData forumdata;
	
}
