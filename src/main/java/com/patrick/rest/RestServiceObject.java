package com.patrick.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrick.model.User;

@RestController
public class RestServiceObject {

	@RequestMapping("/getObject")
	public User getResponse(){
//		List<User> userList = new ArrayList<User>();
//		userList.add(new User("pat1","123"));
//		userList.add(new User("Patrick","OYES"));
		return new User("pat1","123");
	}
}
