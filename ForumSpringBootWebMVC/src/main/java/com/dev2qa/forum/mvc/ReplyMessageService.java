package com.dev2qa.forum.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReplyMessageService {
	@Autowired ReplyMessageRepository repo;
	public void save(ReplyMessage replyMessage) {
		repo.save(replyMessage);
	}
	public List<ReplyMessage> listAll() {
		return (List<ReplyMessage>) repo.findAll();
	}
}
