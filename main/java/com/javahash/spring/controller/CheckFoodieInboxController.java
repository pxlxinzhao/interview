package com.javahash.spring.controller;

import hibernate.HibernateHelper;
import hibernate.OpenfireHibernateTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;

import model.Entries;
import model.Identity_message;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckFoodieInboxController {

	@RequestMapping("/html/foodie")
    public String register( @RequestParam(value="type", required=true) String type, 
    		HttpServletRequest request,
    		Model model) {
		List<Entries> entrylist = new ArrayList<Entries>();
		Stack<Entries> stack = new Stack<Entries>();
		model.addAttribute("type", type);
		String username = (String)request.getSession().getAttribute("username");
		
		HibernateHelper oht = new OpenfireHibernateTemplate();
		int RecipientId = oht.getUserByName(username).getId();
		List<Identity_message> Im = oht.getRecentMessagebyRecipient(RecipientId, type);	
		
		for(Identity_message j : Im){
			String message = j.getMessage();
			String sender = oht.getUserById(j.getSender()).getUsername();
			Entries entry = new Entries(message, sender);
//			entrylist.add(entry); 
			stack.push(entry);
		}
		
		int n = stack.size();
		int i=0;
		for (i=0; i<n; i++){
			entrylist.add(stack.pop());
		}
		
		for(Entries e : entrylist){
			System.out.println(e.toString());
		}
		
		model.addAttribute("entrylist", entrylist);
		
		if(type.equalsIgnoreCase("foodie")){
			System.out.println("Entering Foodie Inbox");
			return "FoodieInbox";
		}
		
		return "CheckMyMailbox";

	}

}
