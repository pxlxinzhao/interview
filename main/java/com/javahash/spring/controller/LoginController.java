package com.javahash.spring.controller;

import hibernate.HibernateHelper;
import hibernate.OpenfireHibernateTemplate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/html/login")
    public String register( @RequestParam(value="username", required=true) String username,
    		HttpServletRequest request,
    		Model model) {
		
		HibernateHelper oht = new OpenfireHibernateTemplate();
		    
		request.getSession().setAttribute("username", username);
		
		return "mailbox";
	}
}
