package com.javahash.spring.controller;

import hibernate.HibernateHelper;
import hibernate.OpenfireHibernateTemplate;
import model.Identity_dating;
import model.Users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
	
	@RequestMapping("/html/Register")
    public String register( @RequestParam(value="username", required=true) String username,
    		Model model) {
		
		HibernateHelper oht = new OpenfireHibernateTemplate();
		
		
		Users user = new Users();
		user.setUsername(username);
		oht.saveUser(user);
		
		int userId = oht.getUserByName(username).getId();
		Identity_dating idd = new Identity_dating();
		idd.setUser_id(userId);
		oht.saveIdd(idd);
		
		return "html/Login";
	}
}
