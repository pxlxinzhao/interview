package com.javahash.spring.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

@Controller
public class RestController {

	@RequestMapping("/html/rest")
    public @ResponseBody String reJson(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String message = request.getParameter("message");
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		Users user = new Users(Integer.valueOf(id), username);
		
		
		JsonFactory f = new JsonFactory();
		OutputStream out = new ByteArrayOutputStream();
		JsonGenerator g = f.createJsonGenerator(out);
		
		   g.writeStartObject();
		   g.writeStringField("id", id);
		   g.writeStringField("username", username);
//		   g.writeObjectFieldStart("name");
//		   g.writeStringField("first", "Joe");
//		   g.writeStringField("last", "Sixpack");
//		   g.writeEndObject(); // for field 'name'
//		   g.writeStringField("gender", "male");
//		   g.writeBooleanField("verified", false);
//		   g.writeEndObject();
		   g.close(); // important: will force flushing of output, close underlying output stream

		 System.out.print(out.toString());


		
//		JsonView.Render(user, response);
//		System.out.println("Recieved message: " + message);
		return out.toString();
		
		
		
	}
    		
}
