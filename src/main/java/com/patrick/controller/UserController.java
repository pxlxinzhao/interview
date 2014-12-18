package com.patrick.controller;
 
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.patrick.hibernate.HibernateHelper;
import com.patrick.model.User;

@Controller
public class UserController {
	
	@Resource
	HibernateHelper hibernateHelper;
	
	@RequestMapping("/")
	public String setHomepage1() {
		return "add";
	}
	
	@RequestMapping("/home")
	public String setHomepage2() {
		return "add";
	}
	
	@RequestMapping("/signup")
	public ModelAndView saveUser(HttpServletRequest request, Model model) {
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		System.out.println(username);
		System.out.println(passwd);
		model.addAttribute("username", username);
		model.addAttribute("passwd", passwd);
		Set<User> userSet = new HashSet<User>();
		User user1 = new User("xiaobai","123");
		System.out.println("Start saving");
//		hibernateHelper.saveUser(user1);
		System.out.println("Finish saving");
		User user2 = new User("xiaohei","456");
		userSet.add(user1);
		userSet.add(user2);
		ModelAndView myModel = new ModelAndView("confirm");
		myModel.addObject("userSet",userSet);
		return myModel;
	}
}
