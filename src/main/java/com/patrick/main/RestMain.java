package com.patrick.main;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.springframework.web.client.RestTemplate;

import com.patrick.model.User;

public class RestMain {

	public static void main(String[] args){
	
		try {
			URL url = new URL("http://localhost:8080/interview/getObject");
			URLConnection con = url.openConnection();
			InputStream in = con.getInputStream();
			String encoding = con.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			String body = IOUtils.toString(in, encoding);
			System.out.println(body);
			
			RestTemplate restTemplate = new RestTemplate();
	        User user = restTemplate.getForObject("http://localhost:8080/interview/getObject", User.class);
	        System.out.println("username is:" + user.getUsername());
	        System.out.println("password is:" + user.getPasswd());
//	        Object[] forNow = template.getForObject("URL", Object[].class);
//	        searchList= Arrays.asList(forNow);
	        
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
