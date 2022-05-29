package com.dev2qa.forum.mvc;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.loader.plan.spi.JoinDefinedByMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class TopicController {
	@Autowired
	private TopicService topicService;
	@RequestMapping(value={"/topicList"})
	public ModelAndView home() {
		List<Topic> listTopic = topicService.listAll();
		ModelAndView mav = new ModelAndView("topic_list");
		mav.addObject("listTopic", listTopic);
		System.out.println("vao listTopic");
		return mav;
	}
	@RequestMapping("/newTopic")
	public String newTopicForm(Map<String, Object> model) {
		Topic topic = new Topic();
		model.put("topic", topic);
		
		return "forum_topic_new";
	}
	@RequestMapping(value = "/saveTopic", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("topic") Topic topic) {
		User user1=new User();
		user1.setId(1);
		topic.setUser(user1);
		topic.setCreatedTime(Calendar.getInstance());
		topicService.save(topic);
		return "redirect:/topicList";
	}
}
