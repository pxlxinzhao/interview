package com.patrick.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestService {

	@RequestMapping("/getString")
	public String getResponse(){

		return "patrick is a dumb";
	}
}
