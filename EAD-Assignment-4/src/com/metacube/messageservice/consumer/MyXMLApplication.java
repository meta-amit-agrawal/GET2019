package com.metacube.messageservice.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.metacube.messageservice.MessageService;

public class MyXMLApplication {
	
	/*
	 * sendMessage will send the message of given service type
	 * @param requires the service type, message to send, and the receiver to send
	 */
	public void sendMessage(String service,String message, String receiver)
	{
		//connects with XML file to get the object from factory
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/metacube/messageservice/configurator/applicationContext.xml");
		
		//gets the object according to the requested service
		MessageService messageService = (MessageService)factory.getBean(service);
		
		//sends the message
		messageService.sendMessage(message , receiver);
	}

}
