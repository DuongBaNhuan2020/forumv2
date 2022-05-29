package com.dev2qa.forum.mvc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ReplyMessageController {
	@Autowired
	private ReplyMessageService replyMessageService;
	@Autowired
	private TopicService topicService;
	@RequestMapping("/detailTopic")
	public ModelAndView detailTopic( @RequestParam long top_id) {
		List<ReplyMessage> listReply = replyMessageService.listAll();
		List<ReplyMessage> listReplyShow = new ArrayList<ReplyMessage>();
		ModelAndView mav = new ModelAndView("forum_show_topic");
		for(ReplyMessage r:listReply) {
			if(r.getTopic().getId()==top_id) {
				listReplyShow.add(r);
			}
		}
//		User author=listReplyShow.get(0).getUser();
//		ReplyMessage firstReplyMessage=listReplyShow.get(0);
		
		Topic topic=topicService.get(top_id);
		User author=topic.getUser();
		
		mav.addObject("listReply", listReplyShow);
		mav.addObject("author", author);
		mav.addObject("firsttopic", topic);
		return mav;
		
	}
	@RequestMapping("/newReply")
	public String newReplyForm(Map<String, Object> model, @RequestParam long top_id) {
		ReplyMessage replyTopic = new ReplyMessage();
		Topic topic=topicService.get(top_id);
		model.put("replytopic", replyTopic);
		model.put("topic", topic);
		return "forum_reply_topic_new";
	}
	@RequestMapping(value = "/saveReplyMessage", method = RequestMethod.POST)
	public String saveReplyMessage(@ModelAttribute("replytopic") ReplyMessage replyMessage,@RequestParam long top_id) {
		User user1=new User();
		user1.setId(1);
		replyMessage.setUser(user1);
		
		Topic topic1=new Topic();
		topic1.setId(top_id);
		replyMessage.setTopic(topic1);
		
		replyMessage.setCreatedTime(Calendar.getInstance());
		replyMessageService.save(replyMessage);
		return "redirect:/detailTopic?top_id="+top_id;
	}
}
