package com.metacube.messageservice;

public class EmailService implements MessageService{

	@Override
	public void sendMessage(String message, String receiver) {
		// TODO Auto-generated method stub
		
		System.out.println("Email sends to "+receiver+" with message "+message);
		
	}
	
	

}
