package com.metacube.messageservice;

public class EmailService implements MessageService{
	
	public EmailService()
	{
		super();
	}
	
	//implemented message of MessageService interface
	@Override
	public void sendMessage(String message, String receiver) {
		// TODO Auto-generated method stub
		
		System.out.println("Email sended to "+receiver+" with message: "+message);
		
	}	

}
