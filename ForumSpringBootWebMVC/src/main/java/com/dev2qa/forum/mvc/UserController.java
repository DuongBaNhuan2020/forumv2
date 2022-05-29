package com.dev2qa.forum.mvc;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserController {
	@Autowired
	private UserService userService;
//	@RequestMapping(value={"/"})
//	public ModelAndView home() {
//		ModelAndView mav = new ModelAndView("forum_login");
//		System.out.println("co vao day");
//		return mav;
//	}
	@RequestMapping("/new")
	public String newUserForm(Map<String, Object> model) {
		User user=new User();
		model.put("user", user);
		System.out.println("co vao day /new");
		return "forum_login";
	}
	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		user.setJoinDate(Calendar.getInstance());
		userService.save(user);
		return "redirect:/topicList";
	}
}
