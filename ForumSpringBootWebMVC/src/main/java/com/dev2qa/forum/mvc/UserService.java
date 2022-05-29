package com.dev2qa.forum.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {
	@Autowired UserRepository repo;
	public void save(User user) {
		repo.save(user);
	}
}
