package com.metacube.messageservice;

public class TwitterService implements MessageService{

	public TwitterService() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	//implemented message of MessageService interface
	@Override
	public void sendMessage(String message, String receiver) {
		// TODO Auto-generated method stub
		
		System.out.println("Twitter message sended to "+receiver+" with message: "+message);
		
	}

}
