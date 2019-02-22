package com.metacube.messageservice;

public class TwitterService implements MessageService{

	@Override
	public void sendMessage(String message, String receiver) {
		// TODO Auto-generated method stub
		
		System.out.println("Twitter message sends to "+receiver+" with message "+message);
		
	}

}
