package com.dev2qa.forum.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class TopicService {
	@Autowired TopicRepository repo;
	public void save(Topic topic) {
		repo.save(topic);
	}
	public Topic get(Long id) {
		return repo.findById(id).get();
	}
	public List<Topic> listAll() {
		return (List<Topic>) repo.findAll();
	}
}
