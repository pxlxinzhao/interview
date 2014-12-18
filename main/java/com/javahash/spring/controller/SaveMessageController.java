package com.javahash.spring.controller;

import hibernate.HibernateHelper;
import hibernate.OpenfireHibernateTemplate;
import model.Identity_message;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaveMessageController {

	@RequestMapping("/html/saveMessage")
    public String register( @RequestParam(value="senderName", required=true) String senderName,
    		@RequestParam(value="recipientName", required=true) String recipientName, 
    		@RequestParam(value="messageBody", required=true) String messageBody,
    		@RequestParam(value="type", required=true) String type,
    		Model model) {
		
		HibernateHelper oht = new OpenfireHibernateTemplate();
		Identity_message idm = new Identity_message();
		
		int sender = oht.getUserByName(senderName).getId();
		int recipient = oht.getUserByName(recipientName).getId();	
		int sender_identity = oht.getDatingUserIdentityByUserId(sender).getId();
		int recipient_identity = oht.getDatingUserIdentityByUserId(recipient).getId();
		String sender_type = type;
		String recipient_type = type;
		
		idm.setSender(sender);
		idm.setRecipient(recipient);
		idm.setMessage(messageBody);
		idm.setSender_identity(sender_identity);
		idm.setRecipient_identity(recipient_identity);
		idm.setSender_type(sender_type);
		idm.setRecipient_type(recipient_type);
		
		oht.saveIdentity_message(idm);
		
		return "sendMessage";
	}
}
