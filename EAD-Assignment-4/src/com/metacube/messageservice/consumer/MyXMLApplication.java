package com.metacube.messageservice.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.metacube.messageservice.MessageService;

public class MyXMLApplication {
	
	public void sendMessage(String messageService)
	{
		ApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");
		MessageService message = (MessageService)factory.getBean(messageService);
		message.sendMessage("Hello", "Akshat");
	}

}
